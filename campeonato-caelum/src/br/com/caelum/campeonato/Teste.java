package br.com.caelum.campeonato;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.caelum.campeonato.util.CadastroJogador;
import br.com.caelum.campeonato.util.Executavel;
import br.com.caelum.campeonato.util.JogadorJaExisteException;
import br.com.caelum.campeonato.util.ListaJogadores;
import br.com.caelum.campeonato.util.CriarCampeonato;

public class Teste {
	public static void main(String[] args) {

		Executavel cj = new CadastroJogador();
		Executavel lj = new ListaJogadores();
		Executavel st = new CriarCampeonato();

		Map<String, Executavel> map = new HashMap<>();

		map.put("cadastrar", cj);
		map.put("listar", lj);
		map.put("campeonato", st);

		Scanner scanner = new Scanner(System.in);
		Boolean b = true;

		do {
			System.out.println("---- Menu ----");
			System.out.println(" cadastrar | Cadastrar Jogadores");
			System.out.println(" listar | Listar Jogadores");
			System.out.println(" campeonato | Criar Campeonato");

			try {
				b = map.get(scanner.next()).executa();
			} catch (JogadorJaExisteException e) {
				System.out.println("\n" + e.toString() + "\n");
			}

		} while (b);

	}
}
