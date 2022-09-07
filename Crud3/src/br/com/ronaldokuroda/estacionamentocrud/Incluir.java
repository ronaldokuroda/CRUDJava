package br.com.ronaldokuroda.estacionamentocrud;

public class Incluir {
	
	public void incluir (veiculos veiculo) {
		
		
		if (veiculo.getDataHoraSaida() != null) {
			
		String incluir = "insert into veiculo values ('" + veiculo.getPlaca() + "' , '" + veiculo.getMarca() + "' , '" + veiculo.getModelo() + "' , '" + veiculo.getDataHoraEntrada() + "' , '" + veiculo.getDataHoraSaida() + "')";
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.executarDML(incluir);
		
		} else {
			
			String incluir = "insert into veiculo values ('" + veiculo.getPlaca() + "' , '" + veiculo.getMarca() + "' , '" + veiculo.getModelo() + "' , '" + veiculo.getDataHoraEntrada() + "' , " + veiculo.getDataHoraSaida() + ")";
			
			ConexaoMySQL conexao = new ConexaoMySQL();
			conexao.executarDML(incluir);
			
		}
		
	}
}
