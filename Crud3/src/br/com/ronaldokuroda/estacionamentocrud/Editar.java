package br.com.ronaldokuroda.estacionamentocrud;

public class Editar {
	
	public void alterarPorPlaca(veiculos veiculo) {
		
		String update = " update veiculo set marca = '" + veiculo.getMarca() + "', modelo = '" + veiculo.getModelo() + "', dataHoraEntrada = '" + veiculo.getDataHoraEntrada() + "', dataHoraSaida = '" + veiculo.getDataHoraSaida() + "' where placa = '" + veiculo.getPlaca() + "' ";
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.executarDML(update);
	}

}
