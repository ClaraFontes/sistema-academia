package br.edu.ifpe.paulista.tadala_fit.core;

import java.util.ArrayList;

import org.json.JSONObject;

public class Aluno {
	protected int matricula;
	protected String usuario;
	protected String senha;
	protected String nome;
	protected String sexo;
	protected String cpf;
	protected String telefone;
	protected String email;
	protected String data_nascimento;
	protected double altura;
	protected double peso;
	protected double bf;
	protected String comorbidade;
	protected int matricula_prof_encarregado;
	protected JSONObject treino_a;
	protected ArrayList<String> treino_b = new ArrayList<String>();
	protected ArrayList<String> treino_c = new ArrayList<String>();
	protected ArrayList<String> treino_d = new ArrayList<String>();
	protected String situacao;
	
	public Aluno(int matricula, String usuario, String senha, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, double altura, double peso, double bf, String comorbidade, String situacao,JSONObject treino_a) {
		this.matricula = matricula;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.altura = altura;
		this.peso = peso;
		this.bf = bf;
		this.comorbidade = comorbidade;
		this.situacao = situacao;
		this.treino_a = treino_a;
	}
	
	public Aluno( String usuario, String senha, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, double altura, double peso, double bf, String comorbidade) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.altura = altura;
		this.peso = peso;
		this.bf = bf;
		this.comorbidade = comorbidade;
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

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getBf() {
		return bf;
	}

	public void setBf(double bf) {
		this.bf = bf;
	}

	public String getComorbidade() {
		return comorbidade;
	}

	public void setComorbidade(String comorbidade) {
		this.comorbidade = comorbidade;
	}

	public int getMatricula_prof_encarregado() {
		return matricula_prof_encarregado;
	}

	public void setMatricula_prof_encarregado(int matricula_prof_encarregado) {
		this.matricula_prof_encarregado = matricula_prof_encarregado;
	}

	public JSONObject getTreino_a() {
		return treino_a;
	}

	public void setTreino_a(JSONObject treino_a) {
		this.treino_a = treino_a;
	}

	public ArrayList<String> getTreino_b() {
		return treino_b;
	}

	public void setTreino_b(ArrayList<String> treino_b) {
		this.treino_b = treino_b;
	}

	public ArrayList<String> getTreino_c() {
		return treino_c;
	}

	public void setTreino_c(ArrayList<String> treino_c) {
		this.treino_c = treino_c;
	}

	public ArrayList<String> getTreino_d() {
		return treino_d;
	}

	public void setTreino_d(ArrayList<String> treino_d) {
		this.treino_d = treino_d;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
