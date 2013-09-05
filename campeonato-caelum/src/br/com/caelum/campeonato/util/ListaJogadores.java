package br.com.caelum.campeonato.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.campeonato.participantes.Jogador;

public class ListaJogadores implements Executavel {

	@Override
	public boolean executa() {

		// lista os objetos
		Set<Jogador> jogadores = this.listaDeJogadores();

		for (Jogador jogs : jogadores) {
			jogs.mostraJogador();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nRetornar ao menu(Y/n): ");
		if (scanner.next().equals("Y")) {
			return true;
		}
		return false;
	}

	public Set<Jogador> listaDeJogadores() {
		
		// Lê de arquivo e cria objetos
		File file = new File("jogadores.txt");
		Set<Jogador> jogadores = new HashSet<>();

		try (Scanner scanner = new Scanner(new FileInputStream(file)).useDelimiter(";");) {

			while (scanner.hasNext()) {
				
				Jogador jogador = new Jogador(scanner.next());
				jogadores.add(jogador);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		return jogadores;
	}
}