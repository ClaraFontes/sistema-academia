package br.edu.ifpe.paulista.tadala_fit.core;

public class Professor {
	protected int matricula;
	protected String usuario;
	protected String senha;
	protected String nome;
	protected String sexo;
	protected String cpf;
	protected String cargo;
	
	public Professor(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Professor(int matricula, String usuario, String senha, String nome, String sexo, String cpf, String cargo) {
		this.matricula = matricula;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.cargo = cargo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
