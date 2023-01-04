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
	
	@SuppressWarnings("resource")
	public Aluno loginAluno(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "@Anaclara18");
			PreparedStatement statement = connection.prepareStatement("SELECT *, senha FROM aluno a WHERE a.usuario = ? AND a.senha = ?");
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
			} 
		} finally {
			connection.close();
		}
		return null;
		
		
	}
	
	public Professor loginProfessor(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "Stormchadow123");
			PreparedStatement statement = connection.prepareStatement("SELECT *, senha FROM professor a WHERE a.usuario = ? AND a.senha = ?");
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
			} 
		} finally {
			connection.close();
		}
		return null;
		
		
		
	}
	
	public Administrador loginAdm(String user, String password) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "@Anaclara18");
			PreparedStatement statement = connection.prepareStatement("SELECT *, password FROM administrador a WHERE a.user = ? AND a.password = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String sexo = resultSet.getString("sexo");
				String cpf = resultSet.getString("cpf");
				String cargo = resultSet.getString("cargo");
				Administrador admAtual = new Administrador(matricula, user, password, nome, sexo, cpf, cargo);
				return admAtual;
			} 
		} finally {
			connection.close();
		}
		return null;
		
		
	}

}