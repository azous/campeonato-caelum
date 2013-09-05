package br.com.caelum.campeonato.participantes;

import java.util.HashSet;
import java.util.Set;

public class Time {
	private Set<Jogador> jogadores = new HashSet<>();
	private String nome;

	public Time(String string) {
		this.setNome(string);
	}

	public boolean contemJogador(Jogador jogador){
		return this.jogadores.contains(jogador);
	}
	
	public void listaJogadores() {
		System.out.println(this.getNome());
		for(Jogador j : this.jogadores){
			j.mostraJogador();
		}
	}

	public void setJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
