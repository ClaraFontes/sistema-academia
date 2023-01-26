package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
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

	public Aluno loginAluno(String user, String password) throws SQLException, JSONException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
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
				Object treino_a = resultSet.getObject("treino_a");
				JSONObject treino_a_JSON = new JSONObject(treino_a.toString());
				    
				Aluno alunoAtual = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao, treino_a_JSON);
				
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno");
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				 ArrayList<Aluno> alunos = new ArrayList();
				 while (resultSet.next()) {
				 	int matricula = resultSet.getInt("matricula");
				 	String user = resultSet.getString("user");
				 	String password = resultSet.getString("password");
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
					Object treino_a = resultSet.getObject("treino_a");
					JSONObject treino_a_JSON = new JSONObject(treino_a.toString());
					Aluno alunoRecebido = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao,treino_a_JSON);
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
	
	public Aluno getAlunoFiltered(String pesquisa) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno a WHERE a.nome = ? OR a.matricula = ?");
			statement.setString(1, pesquisa);
			statement.setString(2, pesquisa);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
			 	String user = resultSet.getString("user");
			 	String password = resultSet.getString("password");
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
				Object treino_a = resultSet.getObject("treino_a");
				JSONObject treino_a_JSON = new JSONObject(treino_a.toString());
				Aluno alunoFiltered = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao,treino_a_JSON);
				return alunoFiltered;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}
	
	public Aluno updateAluno(Integer matricula, String telefone, String email, Double  altura, Double peso, Double bf) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			String sql1 = ("UPDATE aluno a SET telefone = ?, email = ?, altura = ?, peso = ?, bf = ? WHERE a.matricula = ?");
			String sql2 = ("SELECT * FROM aluno a WHERE a.matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, telefone);
			statement1.setString(2, email);
			statement1.setDouble(3, altura);
			statement1.setDouble(4, peso);
			statement1.setDouble(5, bf);
			statement1.setInt(6, matricula);
			statement1.executeQuery();
			
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			statement1.setInt(1, matricula);
			ResultSet resultSet = statement1.executeQuery();
			if (resultSet.next()) {
				int matricula2 = resultSet.getInt("matricula");
			 	String user2 = resultSet.getString("user");
			 	String password2 = resultSet.getString("password");
				String nome2 = resultSet.getString("nome");
				String sexo2 = resultSet.getString("sexo");
				String cpf2 = resultSet.getString("cpf");
				String telefone2 = resultSet.getString("telefone");
				String email2 = resultSet.getString("email");
				String data_nascimento2 = resultSet.getString("data_nascimento");
				Double altura2 = resultSet.getDouble("altura");
				Double peso2 = resultSet.getDouble("peso");
				Double bf2 = resultSet.getDouble("bf");
				String comorbidade2 = resultSet.getString("comorbidade");
				String situacao2 = resultSet.getString("situacao");
				Object treino_a = resultSet.getObject("treino_a");
				JSONObject treino_a_JSON = new JSONObject(treino_a.toString());
				Aluno alunoUpdated = new Aluno(matricula2, user2, password2, nome2, sexo2, cpf2, telefone2, email2, data_nascimento2, altura2, peso2, bf2, comorbidade2, situacao2, treino_a_JSON);
				return alunoUpdated;
			} else {
				return null;
			}
			
		} finally {
			connection.close();
		}
	}
}


