package br.com.caelum.campeonato.util;

import br.com.caelum.campeonato.participantes.Campeonato;

public class CriarCampeonato implements Executavel{

	@Override
	public boolean executar() {
	
		ListaJogadores lj = new ListaJogadores();
		Campeonato campeonato = new Campeonato();
		campeonato.sortearTimes(lj.listaDeJogadores());
		
		Thread t1 = new Thread(campeonato);
		t1.start();
		
		return true;
	}

}
