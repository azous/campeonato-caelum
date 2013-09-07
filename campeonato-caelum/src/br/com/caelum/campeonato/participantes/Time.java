package br.com.caelum.campeonato.participantes;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.campeonato.util.TimeCompletoException;

public class Time {
	private Set<Jogador> jogadores = new HashSet<>();
	private String nome;

	public Time(String string) {
		this.setNome(string);
	}

	public boolean contemJogador(Jogador jogador) {
		return this.jogadores.contains(jogador);
	}

	public void listaJogadores() {
		System.out.println(this.getNome());
		for (Jogador j : this.jogadores) {
			j.mostraJogador();
		}
	}

	public void contratarJogador(Jogador jogador) throws TimeCompletoException {
		// time com no maximo 3 jogadores
		switch(jogadores.size()){
		case 3: throw new TimeCompletoException(getNome());
		
		default: this.jogadores.add(jogador);
		}
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
