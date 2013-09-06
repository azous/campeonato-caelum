package br.com.caelum.campeonato.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.campeonato.participantes.Jogador;

public class CadastroJogador implements Executavel {

	@Override
	public boolean executa() throws JogadorJaExisteException {
		// Cadastra jogador e salva em arquivo
		String nome;
		String cpf;
		String idade;
		String confirm;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Digite os dados do jogador:");

			System.out.print("Nome: ");
			nome = scanner.next();

			System.out.print("CPF: ");
			cpf = scanner.next();

			System.out.print("Idade: ");
			idade = scanner.next();

			File file = new File("jogadores.txt");

//			ListaJogadores lj = new ListaJogadores();
//			Jogador jogador = new Jogador(nome + "," + cpf + "," + idade);
//			Set<Jogador> sj = lj.listaDeJogadores();
//			
//			if(sj.contains(jogador)){
//				throw new JogadorJaExisteException();
//			}
			
			try (PrintStream ps = new PrintStream(new FileOutputStream(file,
					true));) {

				ps.print(nome + "," + cpf + "," + idade + ";");

			} catch (FileNotFoundException e) {
				System.out.println("File " + file + " not found");
			}
			
			System.out.print("Cadastrar novo jogador(Y/n): ");
			confirm = scanner.next();
		
		} while (confirm.equals("Y"));
		
		System.out.println("Jogadores cadastrados com sucesso!");
		return true;
	}

}
