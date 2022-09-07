package br.com.ronaldokuroda.teste;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.ronaldokuroda.estacionamentocrud.Editar;
import br.com.ronaldokuroda.estacionamentocrud.veiculos;

public class testarEditar {

	public static void main(String[] args) {
		
		Editar editar = new Editar();
		
		veiculos veiculo = null;
		veiculo = editarDados();
		editar.alterarPorPlaca(veiculo);

	}
	
	public static veiculos editarDados() {
		
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
		
		veiculo.setDataHoraSaida(DataHoraFormatado);
		
		sc.close();
		
		return veiculo;
	}

}
