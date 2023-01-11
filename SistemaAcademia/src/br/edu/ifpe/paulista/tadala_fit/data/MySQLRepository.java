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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, nome, sexo, cpf, senha, usuario cargo FROM aluno a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String sexo = resultSet.getString("sexo");
				String cpf = resultSet.getString("cpf");
				String cargo = resultSet.getString("cargo");
				Aluno alunoAtual = new Aluno(matricula, user, password, nome, sexo, cpf, cargo);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			PreparedStatement statement = connection.prepareStatement("SELECT id, nome, user, password FROM administrador a WHERE a.user = ? AND a.password = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Administrador admAtual = new Administrador(id, user, password, nome);
				return admAtual;
			} else {
				
				return null;
			}
	} finally {
		connection.close();
	}
	}
}

