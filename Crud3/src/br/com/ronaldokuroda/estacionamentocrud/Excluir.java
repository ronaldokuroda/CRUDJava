package br.com.ronaldokuroda.estacionamentocrud;

public class Excluir {
	
	public void excluir(veiculos veiculo) {
		String delete = "delete from veiculo where placa = '" + veiculo.getPlaca() + "'";
		
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.executarDML(delete);
	}

}
