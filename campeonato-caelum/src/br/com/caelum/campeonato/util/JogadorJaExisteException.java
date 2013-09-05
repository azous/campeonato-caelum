package br.com.caelum.campeonato.util;

public class JogadorJaExisteException extends Exception {
	@Override
	public String toString() {
		return "Jogador ja cadastrado com esse CPF!";
	}
}
