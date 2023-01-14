package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;

public class MySQLRepository implements Repository {
	

	public MySQLRepository() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
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
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, nome, sexo, cpf, cargo, senha FROM professor a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String sexo = resultSet.getString("sexo");
				String cpf = resultSet.getString("cpf");
				String cargo = resultSet.getString("cargo");
				Professor professorAtual = new Professor(matricula, user, password, nome, sexo, cpf, cargo);
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

