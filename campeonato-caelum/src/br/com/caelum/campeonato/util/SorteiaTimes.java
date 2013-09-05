package br.com.caelum.campeonato.util;

public class SorteiaTimes implements Executavel{

	@Override
	public boolean executa() {
	
		ListaJogadores lj = new ListaJogadores();
		Campeonato campeonato = new Campeonato();
		campeonato.sortearTimes(lj.listaDeJogadores());
		
		return true;
	}

}
