package br.com.caelum.campeonato.participantes;

public class Jogador {
	private String nome;
	private String cpf;
	private int idade;

	// Jogador só pode ser criado com parametros
	public Jogador(String next) {

		String[] string = next.split(",");
		this.setNome(string[0]);
		this.setCpf(string[1]);
		this.setIdade(string[2]);

	}

	@Override
	public int hashCode() {
		return new Integer(this.cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogador) {
			return this.cpf.equals(((Jogador) obj).getCpf());
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		Integer i = new Integer(idade);
		this.idade = i;
	}

	public void mostraJogador() {
		// TODO Auto-generated method stub
		System.out.println("Jogador: " + getNome());
		System.out.println("\tCPF: " + getCpf());
		System.out.println("\tIdade: " + getIdade());
	}

}
