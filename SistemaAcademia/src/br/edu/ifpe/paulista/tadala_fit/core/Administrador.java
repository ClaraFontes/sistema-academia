package br.edu.ifpe.paulista.tadala_fit.core;

public class Administrador {
	protected int id;
	protected String usuario;
	protected String senha;
	protected String nome;
	protected String cpf;
	
	public Administrador(int id, String usuario, String senha, String nome, String cpf) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getMatricula() {
		return id;
	}

	public void setMatricula(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}

