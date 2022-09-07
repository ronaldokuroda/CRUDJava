package br.com.ronaldokuroda.teste;

import java.util.Scanner;

import br.com.ronaldokuroda.estacionamentocrud.Consultar;
import br.com.ronaldokuroda.estacionamentocrud.veiculos;

public class testarConsultar {

	public static void main(String[] args) {
		
		veiculos veiculo = null;
		Consultar consulta = new Consultar();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a placa do veiculo: ");
		String placa = sc.next();
		
		veiculo = consulta.consultarPorPlaca(placa);
		
		sc.close();
		
		mostrarDados(veiculo);

	}
	
	public static void mostrarDados(veiculos veiculo) {
		
		if(veiculo != null) {
			
			System.out.println("\n############### DADOS DO VEICULO #################");
			System.out.println("PLACA:  " + veiculo.getPlaca());
			System.out.println("MARCA:  " + veiculo.getMarca());
			System.out.println("MODELO: " + veiculo.getModelo());
			System.out.println("Data e Hora da Entrada:  " + veiculo.getDataHoraEntrada());
			System.out.println("Data e Hora da Saida:  " + veiculo.getDataHoraSaida());
			System.out.println("############### DADOS DO VEICULO #################\n");
			
		} else {
			System.out.println("Veiculo Não Encontrado");
		}
	}

}
