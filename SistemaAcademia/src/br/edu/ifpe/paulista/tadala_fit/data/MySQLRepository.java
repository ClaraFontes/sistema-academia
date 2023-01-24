package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
				String treino_a = resultSet.getString("treino_a");
				Aluno alunoAtual = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, situacao,treino_a);
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
}


