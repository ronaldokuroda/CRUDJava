package br.com.ronaldokuroda.estacionamentocrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {
	
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	
	private Connection conectar() {
		
		try {
			
			String usuario = "root";
			String senha = "root";
			
			String ipBancoDados = "localhost";
			String nomeBanco = "estacionamento";
			
			String conexao = "jdbc:mysql://" + ipBancoDados + "/" + nomeBanco;
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(conexao, usuario, senha);
			System.out.println("Conectou no banco de dados");
			
		} catch (SQLException ex){
			
			System.out.println("Erro: Não conseguiu conectar no Banco de dados");
			
		} catch (ClassNotFoundException ex) {
			
			System.out.println("Erro: Não encontrou o driver do Banco de dados");
			
		}
		return conn;
	}
	
	public ResultSet executarConsulta(String consulta) {
		
		conn = conectar();
		
		try {
			
			stm = conn.createStatement();
			rs = stm.executeQuery(consulta);
			
		} catch (SQLException ex) {
			
			System.out.println("Não conseguiu executar a consulta \n" + consulta);
			desconectar();
			
		}
		
		return rs;
	}
	
	public boolean executarDML(String dml) {
		
		boolean ok = false;
		
		conn = conectar();
		
		try {
			
			stm = conn.createStatement();
			stm.execute(dml);
			ok = true;
			
		} catch (SQLException ex) {
			
			System.out.println("Não conseguiu conectar o DML \n" + dml);
			
		} finally {
			
			desconectar();
			
		}
		
		return ok;
	}
	
	public void desconectar() {
		
		fecharResultSet(this.rs);
		fecharStatement(this.stm);
		fecharConnection(this.conn);
		
	}
	
	public void fecharConnection(Connection conn) {
		
		try {
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Desconectou do banco de dados.");
				
			}
			
		} catch (SQLException ex){
			
			System.out.println("Não conseguiu desconectar do BD.");
			
		}
	}
	
	public void fecharStatement (Statement stm) {
		
		try {
			
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			
		} catch (SQLException ex) {
			
			System.out.println("Erro ao fechar o procedimento de consulta.");
			
		}
	}
	
	public void fecharResultSet (ResultSet resultado) {
		
		try {
			
			if(resultado != null && !resultado.isClosed()) {
				resultado.close();
				
			}
			
		} catch (SQLException ex) {
			
			System.out.println("Erro ao fechar o resultado da consulta.");
			
		}
	}
	
	
}
