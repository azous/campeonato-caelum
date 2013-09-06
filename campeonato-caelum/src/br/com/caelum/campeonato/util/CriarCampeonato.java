package br.com.caelum.campeonato.util;

import br.com.caelum.campeonato.participantes.Campeonato;

public class CriarCampeonato implements Executavel{

	@Override
	public boolean executa() {
	
		ListaJogadores lj = new ListaJogadores();
		Campeonato campeonato = new Campeonato();
		campeonato.sortearTimes(lj.listaDeJogadores());
		
		campeonato.fazerTabelas();
		
		return true;
	}

}
