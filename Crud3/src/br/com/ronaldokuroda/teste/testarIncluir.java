package br.com.ronaldokuroda.teste;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.ronaldokuroda.estacionamentocrud.Incluir;
import br.com.ronaldokuroda.estacionamentocrud.veiculos;

public class testarIncluir {

public static void main(String[] args) {
		
		veiculos veiculo = null;
		Incluir incluir = new Incluir();
		
		veiculo = coletarDados();
		incluir.incluir(veiculo);
		
		System.out.println("Adicionado: " + veiculo.getPlaca());
		
	}
	
	public static veiculos coletarDados() {
		
		Scanner sc = new Scanner(System.in);
		veiculos veiculo = new veiculos();
		
		System.out.println("Digite a Placa: ");
		veiculo.setPlaca(sc.nextLine());
		System.out.println("Digite a Marca: ");
		veiculo.setMarca(sc.nextLine());
		System.out.println("Digite o Modelo: ");
		veiculo.setModelo(sc.nextLine());
		
		
		
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter formatarDataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
		String DataHoraFormatado = dataHora.format(formatarDataHora);
		
		veiculo.setDataHoraEntrada(DataHoraFormatado);
		
		//veiculo.setDataHoraSaida(DataHoraFormatado);
		
		sc.close();
		
		return veiculo;
	}

}
