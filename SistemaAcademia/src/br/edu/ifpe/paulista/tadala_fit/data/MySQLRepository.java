package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;

public class MySQLRepository implements Repository {
	

	public MySQLRepository() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	
	public Professor cadastroProfessor(String user, String password, String nome, String telefone, String email, String cref) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql = ("INSERT INTO professor(user, password, nome, telefone, email, cref) VALUES (?,?,?,?,?,?)");
			String sql2 = ("SELECT user FROM professor WHERE user = ? and cref = ?");
			PreparedStatement stm2 = connection.prepareStatement(sql2);
			stm2.setString(1, user);
			stm2.setString(2, cref);
			ResultSet resultSet = stm2.executeQuery();
			if (resultSet.next()) {
				return null;
			}
			else {
				PreparedStatement stm = connection.prepareStatement(sql);
				stm.setString(1, user);
				stm.setString(2, password);
				stm.setString(3, nome);
				stm.setString(4, telefone);
				stm.setString(5, email);
				stm.setString(6, cref);
				stm.execute();
			}
		} finally {
			connection.close();
		}
		Professor professorCadastrado = new Professor(user, password, nome, telefone, email, cref);
		return professorCadastrado;
	}
	
	
	public Aluno cadastroAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade)  throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql = ("INSERT INTO aluno(usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			String sql2 = ("SELECT usuario FROM aluno WHERE usuario = ?");
			PreparedStatement stm2 = connection.prepareStatement(sql2);
			stm2.setString(1, user);
			ResultSet resultSet = stm2.executeQuery();
			if(resultSet.next()) {
				return null;
			}
			else{
				PreparedStatement stm = connection.prepareStatement(sql);
				stm.setString(1, user);
				stm.setString(2, password);
				stm.setString(3, nome);
				stm.setString(4, sexo);
				stm.setString(5, cpf);
				stm.setString(6, telefone);
				stm.setString(7, email);
				stm.setString(8, data_nascimento);
				stm.setDouble(9, altura);
				stm.setDouble(10, peso);
				stm.setDouble(11, bf);
				stm.setString(12, comorbidade);
				stm.execute();
				
			}
			} finally {
				connection.close();
			}
		Aluno alunoCadastrado = new Aluno(user, password, nome, sexo, cpf, telefone, email, data_nascimento,altura, peso, bf, comorbidade);
		return alunoCadastrado;
		}

	public Aluno loginAluno(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade, matricula_prof_encarregado, treino_a, treino_b, treino_c, treino_d, situacao FROM aluno a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String sexo = resultSet.getString("sexo");
				String cpf = resultSet.getString("cpf");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String data_nascimento = resultSet.getString("data_nascimento");
				Double altura = resultSet.getDouble("altura");
				Double peso = resultSet.getDouble("peso");
				Double bf = resultSet.getDouble("bf");
				String comorbidade = resultSet.getString("comorbidade");
				String situacao = resultSet.getString("situacao");
				//JSONObject treino_a = (JSONObject) resultSet.getArray("treino_a");
				Aluno alunoAtual = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao);
				return alunoAtual;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
		
	}
	
	public Professor loginProfessor(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, nome, telefone, email, cref, FROM professor a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String cref = resultSet.getString("cref");
				Professor professorAtual = new Professor(matricula, user, password, nome, telefone, email, cref);
				return professorAtual;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
		
	}
	
	public Administrador loginAdm(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT id, nome, user, cpf, password FROM administrador a WHERE a.user = ? AND a.password = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cpf = resultSet.getString("cpf");
				Administrador admAtual = new Administrador(id, user, password, nome, cpf);
				return admAtual;
			} else {
				
				return null;
			}
	} finally {
		connection.close();
	}
	
  }
	
	public ArrayList<Aluno> getAllAluno()throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				//ALTERAÇÃO TESTE, POIS ESTAVA PERDENDO A PRIMEIRA ITERAÇÃO, NÃO MOSTRANDO O PRIMEIRO USUÁRIO DO BANCO NA CONSULTA.
				 ArrayList<Aluno> alunos = new ArrayList<Aluno>();
				 	Integer matricula0 = resultSet.getInt("matricula");
				 	String user0 = resultSet.getString("usuario");
				 	String password0 = resultSet.getString("senha");
					String nome0 = resultSet.getString("nome");
					String sexo0 = resultSet.getString("sexo");
					String cpf0 = resultSet.getString("cpf");
					String telefone0 = resultSet.getString("telefone");
					String email0 = resultSet.getString("email");
					String data_nascimento0 = resultSet.getString("data_nascimento");
					Double altura0 = resultSet.getDouble("altura");
					Double peso0 = resultSet.getDouble("peso");
					Double bf0 = resultSet.getDouble("bf");
					String comorbidade0 = resultSet.getString("comorbidade");
					String situacao0 = resultSet.getString("situacao");
					//JSONObject treino_a = (JSONObject) resultSet.getArray("treino_a");
					Aluno alunoRecebido0 = new Aluno(matricula0, user0, password0, nome0, sexo0, cpf0,telefone0, email0, data_nascimento0,altura0, peso0, bf0, comorbidade0, situacao0);
					alunos.add(alunoRecebido0);
				 while (resultSet.next()) {
				 	Integer matricula = resultSet.getInt("matricula");
				 	String user = resultSet.getString("usuario");
				 	String password = resultSet.getString("senha");
					String nome = resultSet.getString("nome");
					String sexo = resultSet.getString("sexo");
					String cpf = resultSet.getString("cpf");
					String telefone = resultSet.getString("telefone");
					String email = resultSet.getString("email");
					String data_nascimento = resultSet.getString("data_nascimento");
					Double altura = resultSet.getDouble("altura");
					Double peso = resultSet.getDouble("peso");
					Double bf = resultSet.getDouble("bf");
					String comorbidade = resultSet.getString("comorbidade");
					String situacao = resultSet.getString("situacao");
					//JSONObject treino_a = (JSONObject) resultSet.getArray("treino_a");
					Aluno alunoRecebido = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao);
					alunos.add(alunoRecebido);
				 }
				 return alunos;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}
	
	public Aluno getAlunoFiltered(Integer pesquisa) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno a WHERE a.matricula = ?");
			statement.setInt(1, pesquisa);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Integer matricula = resultSet.getInt("matricula");
			 	String user = resultSet.getString("usuario");
			 	String password = resultSet.getString("senha");
				String nome = resultSet.getString("nome");
				String sexo = resultSet.getString("sexo");
				String cpf = resultSet.getString("cpf");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String data_nascimento = resultSet.getString("data_nascimento");
				Double altura = resultSet.getDouble("altura");
				Double peso = resultSet.getDouble("peso");
				Double bf = resultSet.getDouble("bf");
				String comorbidade = resultSet.getString("comorbidade");
				String situacao = resultSet.getString("situacao");
				//JSONObject treino_a = (JSONObject) resultSet.getArray("treino_a");
				Aluno alunoFiltered = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao);
				return alunoFiltered;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}
	
	public Aluno updateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql1 = ("UPDATE aluno a SET telefone = ?, email = ?, altura = ?, peso = ?, bf = ? WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, telefone);
			statement1.setString(2, email);
			statement1.setDouble(3, altura);
			statement1.setDouble(4, peso);
			statement1.setDouble(5, bf);
			statement1.setInt(6, matricula);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Atualização feita com Sucesso, reinicie a sessão para ver as alterações!");
		} finally {
			connection.close();
		}
		return null;
	}


}