package br.com.caelum.campeonato.participantes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import br.com.caelum.campeonato.util.TimeCompletoException;

public class Campeonato implements Runnable {
	private List<Time> times = new ArrayList<>();

	// Times não compartilham jogadores
	public void sortearTimes(Set<Jogador> setDeJogadores) {

		Random random = new Random();

		Time time = new Time("Java");
		Time time2 = new Time("JavaEE");
		Time time3 = new Time("JavaFX");

		times.add(time2);
		times.add(time);
		times.add(time3);

		Map<Integer, Time> mapDeTimes = new HashMap<>();
		mapDeTimes.put(0, time);
		mapDeTimes.put(1, time2);
		mapDeTimes.put(2, time3);

		Set<Integer> setDeKeys = mapDeTimes.keySet();

		Iterator<Jogador> iterator = setDeJogadores.iterator();

		while (iterator.hasNext()) {

			Time t = mapDeTimes.get(random.nextInt(3));
			try {
				t.contratarJogador(iterator.next());
			} catch (TimeCompletoException e) {
				e.toString();
			}
			iterator.remove();
		}

		for (Integer i : setDeKeys) {
			mapDeTimes.get(i).listaJogadores();
		}

	}

	// Sorteia os campeonatos entre times e exporta para arquivo
	public void fazerTabelas() {
		Random random = new Random();

		Set<String> setDeTabelas = new HashSet<>();

		try (PrintStream ps = new PrintStream(new FileOutputStream(
				"tabelas.txt"))) {
			for (int i = 0; i < times.size(); i++) {
				int time1 = random.nextInt(3);
				int time2 = random.nextInt(3);
				while (time1 == time2) {
					time2 = random.nextInt(3);
				}
				
				ps.print("| ");
				for (int j = 0; j < times.get(time1).getNome().length(); j++) {
					ps.print("-");
				}
				ps.print(" VS ");
				for (int j = 0; j < times.get(time2).getNome().length(); j++) {
					ps.print("-");
				}
				ps.println(" |");
				
				ps.println("| " + times.get(time1).getNome() + " || "
						+ times.get(time2).getNome() + " |") ;

			}

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	@Override
	public void run() {
		this.fazerTabelas();
	}
}
