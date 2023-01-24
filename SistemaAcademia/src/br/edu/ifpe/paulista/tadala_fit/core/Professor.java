package br.edu.ifpe.paulista.tadala_fit.core;

public class Professor {
	protected int matricula;
	protected String usuario;
	protected String senha;
	protected String nome;
	protected String telefone;
	protected String email;
	protected String cref;
	
	
	public Professor(int matricula, String usuario, String senha, String nome, String telefone, String email, String cref) {
		this.matricula = matricula;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cref = cref;
	}
	
	public Professor(String usuario, String senha, String nome, String telefone, String email, String cref) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cref = cref;
	}
	
	

	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCref() {
		return cref;
	}


	public void setCref(String cref) {
		this.cref = cref;
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

}
