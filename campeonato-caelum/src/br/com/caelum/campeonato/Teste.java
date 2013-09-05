package br.com.caelum.campeonato;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.caelum.campeonato.util.CadastroJogador;
import br.com.caelum.campeonato.util.Executavel;
import br.com.caelum.campeonato.util.JogadorJaExisteException;
import br.com.caelum.campeonato.util.ListaJogadores;
import br.com.caelum.campeonato.util.SorteiaTimes;

public class Teste {
	public static void main(String[] args) {

		Executavel cj = new CadastroJogador();
		Executavel lj = new ListaJogadores();
		Executavel st = new SorteiaTimes();

		Map<String, Executavel> map = new HashMap<>();

		map.put("1", cj);
		map.put("2", lj);
		map.put("3", st);

		Scanner scanner = new Scanner(System.in);
		Boolean b = true;

		do {
			System.out.println("---- Menu ----");
			System.out.println(" 1 | Cadastrar Jogadores");
			System.out.println(" 2 | Listar Jogadores");
			System.out.println(" 3 | Sortear Times");

			Executavel ex = map.get(scanner.next());
			try {
				b = ex.executa();
			} catch (JogadorJaExisteException e) {
				System.out.println("\n" + e.toString() + "\n");
			}

		} while (b);

	}
}
