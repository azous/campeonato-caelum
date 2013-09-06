package br.com.caelum.campeonato.participantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Campeonato {
	private List<Time> times = new ArrayList<>();

	// Times não compartilham jogadores
	public void sortearTimes(Set<Jogador> setDeJogadores) {

		Random random = new Random();

		Time time = new Time("Java");
		Time time2 = new Time("JavaEE");
		Time time3 = new Time("JavaFX");

		Map<Integer, Time> mapDeTimes = new HashMap<>();
		mapDeTimes.put(0, time);
		mapDeTimes.put(1, time2);
		mapDeTimes.put(2, time3);

		Set<Integer> setDeKeys = mapDeTimes.keySet();

		for (Jogador j : setDeJogadores) {
			for (Integer i : setDeKeys) {
				if (mapDeTimes.get(i).contemJogador(j)) {
					break;
				}
			}
			Time t = mapDeTimes.get(random.nextInt(3));
			t.contratarJogador(j);
		}

		for (Integer i : setDeKeys) {
			mapDeTimes.get(i).listaJogadores();
		}

	}

	// Sorteia os campeonatos entre times e exporta para arquivo
	public void fazerTabelas() {
		for (Time t : this.times) {
			// TODO gerar tabela em nova thread e exportar pra arquivo
		}

	}
}
