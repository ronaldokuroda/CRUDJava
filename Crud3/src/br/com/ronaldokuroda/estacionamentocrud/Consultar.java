package br.com.ronaldokuroda.estacionamentocrud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultar {
	
	public veiculos consultarPorPlaca(String placa) {
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		veiculos veiculo = null;
		
		try {
			
			String consulta = "select * from veiculo where placa = '" + placa + "'";
			ResultSet rs = conexao.executarConsulta(consulta);
			
			if(rs.next()) {
				
				veiculo = new veiculos();
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setDataHoraEntrada(rs.getString("dataHoraEntrada"));
				veiculo.setDataHoraSaida(rs.getString("dataHoraSaida"));
				
			}
		} catch (SQLException ex) {
			
			System.out.println("Não conseguiu consultar os dados do veiculo.");
			
		} finally {
			
			conexao.desconectar();
			
		}
		
		return veiculo;
		
	}

}
