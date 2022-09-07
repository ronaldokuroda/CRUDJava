package br.com.ronaldokuroda.teste;

import java.util.Scanner;

import br.com.ronaldokuroda.estacionamentocrud.Consultar;
import br.com.ronaldokuroda.estacionamentocrud.Excluir;
import br.com.ronaldokuroda.estacionamentocrud.veiculos;

public class testarExcluir {

	public static void main(String[] args) {
		
		
		Excluir excluir = new Excluir();
		excluir.excluir(excluirVeiculo());

	}

	private static veiculos excluirVeiculo() {
		
		veiculos veiculo = null;
		Consultar consulta = new Consultar();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a placa do veiculo: ");
		String placa = sc.next();
		
		veiculo = consulta.consultarPorPlaca(placa);
		
		sc.close();
		
		return veiculo;
		
	}
}
