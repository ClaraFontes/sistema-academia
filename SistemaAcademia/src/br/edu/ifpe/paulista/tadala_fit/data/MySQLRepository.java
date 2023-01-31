package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql = ("INSERT INTO professor(usuario, senha, nome, telefone, email, cref) VALUES (?,?,?,?,?,?)");
			String sql2 = ("SELECT usuario FROM professor a WHERE a.usuario = ? and a.cref = ?");
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
	
	
	public Aluno cadastroAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade, Blob image)  throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql = ("INSERT INTO aluno(usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade,foto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
				stm.setBlob(13, image);
				stm.execute();
				
			}
			} finally {
				connection.close();
			}
		Aluno alunoCadastrado = new Aluno(user, password, nome, sexo, cpf, telefone, email, data_nascimento,altura, peso, bf, comorbidade,image);
		return alunoCadastrado;
		}

	public Aluno loginAluno(String user, String password) throws SQLException, JSONException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade, matricula_prof_encarregado, treino_a, treino_b, treino_c, treino_d, dt_pagamento,foto FROM aluno a WHERE a.usuario = ? AND a.senha = ?");
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
				String dt_pagamento = resultSet.getString("dt_pagamento");
				DateTime dataHoraAtual = new DateTime();
				DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
				DateTime dt = formatter.parseDateTime(dt_pagamento);
				int dias = Days.daysBetween(dt, dataHoraAtual).getDays(); 
				Object treino_a = resultSet.getObject("treino_a");
				JSONObject treino_a_JSON = null;
				if (treino_a != null) {
					treino_a_JSON = new JSONObject(treino_a.toString());
				}
				Blob image = resultSet.getBlob("foto");
				Aluno alunoAtual = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, dias,treino_a_JSON, image);
				/*JSONArray keys = treino_a_JSON.names();
				for (int i = 0; i < treino_a_JSON.names().length(); i++) {
					
					String key = treino_a_JSON.names().getString(i);
					System.out.print(key + ": ");
					for (int v = 0; v < treino_a_JSON.getJSONArray(key).length(); v++) {
						if (treino_a_JSON.getJSONArray(key).length() == 2) {
							String value = treino_a_JSON.getJSONArray(key).getString(v);
							System.out.print(value + " ");
						} else if(treino_a_JSON.getJSONArray(key).length() == 0) {
							System.out.print("Não tem treino ainda");
						}
						else {
							String value = treino_a_JSON.getJSONArray(key).getString(v);
							System.out.println(value);
						}
						
						
					}
				}
				*/
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
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, nome, telefone, email, cref, usuario, senha FROM professor a WHERE a.usuario = ? AND a.senha = ?");
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
					String dt_pagamento0 = resultSet.getString("dt_pagamento");
					DateTime dataHoraAtual = new DateTime();
					DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
					DateTime dt0 = formatter.parseDateTime(dt_pagamento0);
					int dias0 = Days.daysBetween(dt0, dataHoraAtual).getDays();
					Object treino_a0 = resultSet.getObject("treino_a");
					JSONObject treino_a0_JSON = null;
					if (treino_a0 != null) {
						treino_a0_JSON = new JSONObject(treino_a0.toString());
					}
					Blob image = (Blob) resultSet.getBlob("foto");
					Aluno alunoRecebido0 = new Aluno(matricula0, user0, password0, nome0, sexo0, cpf0,telefone0, email0, data_nascimento0,altura0, peso0, bf0, comorbidade0, dias0, treino_a0_JSON,image);
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
					String dt_pagamento = resultSet.getString("dt_pagamento");
					DateTime dt = formatter.parseDateTime(dt_pagamento);
					int dias = Days.daysBetween(dt, dataHoraAtual).getDays();
					Object treino_a = resultSet.getObject("treino_a");
					JSONObject treino_a_JSON = null;
					if (treino_a_JSON != null)  {
						treino_a_JSON = new JSONObject(treino_a.toString());
					}
					 Blob image1 = resultSet.getBlob("foto");
					Aluno alunoRecebido = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, dias, treino_a_JSON, image1);
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
				String dt_pagamento = resultSet.getString("dt_pagamento");
				DateTime dataHoraAtual = new DateTime();
				DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
				DateTime dt = formatter.parseDateTime(dt_pagamento);
				int dias = Days.daysBetween(dt, dataHoraAtual).getDays(); 
				Object treino_a = resultSet.getObject("treino_a");
				JSONObject treino_a_JSON = new JSONObject(treino_a.toString());
				 Blob image = resultSet.getBlob("foto");
				Aluno alunoFiltered = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, dias, treino_a_JSON, image);
				return alunoFiltered;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}
	
	public Aluno updateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula,Blob imageBlob) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			String sql1 = ("UPDATE aluno a SET telefone = ?, email = ?, altura = ?, peso = ?, bf = ?, foto = ? WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, telefone);
			statement1.setString(2, email);
			statement1.setDouble(3, altura);
			statement1.setDouble(4, peso);
			statement1.setDouble(5, bf);
			statement1.setBlob(6, imageBlob);
			statement1.setInt(7, matricula);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Atualização feita com Sucesso, reinicie a sessão para ver as alterações!");
		} finally {
			connection.close();
		}
		return null;
	}
	
	public ArrayList<Professor> getAllProfessor() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 ArrayList<Professor> professores = new ArrayList<Professor>();
				 	int matricula0 = resultSet.getInt("matricula");
				 	String user0 = resultSet.getString("usuario");
				 	String password0 = resultSet.getString("senha");
					String nome0 = resultSet.getString("nome");
					String telefone0 = resultSet.getString("telefone");
					String email0 = resultSet.getString("email");
					String cref0 = resultSet.getString("cref");
					Professor professorRecebido0 = new Professor(matricula0, user0, password0, nome0, telefone0, email0, cref0);
					professores.add(professorRecebido0);
				 while (resultSet.next()) {
					 	int matricula = resultSet.getInt("matricula");
					 	String user = resultSet.getString("usuario");
					 	String password = resultSet.getString("senha");
						String nome = resultSet.getString("nome");
						String telefone = resultSet.getString("telefone");
						String email = resultSet.getString("email");
						String cref = resultSet.getString("cref");
						Professor professorRecebido = new Professor(matricula, user, password, nome, telefone, email, cref);
						professores.add(professorRecebido);
				 }
				 return professores;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
		
	}
	
	public Professor getProfessorFiltered(Integer pesquisa) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", "123456");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor a WHERE a.matricula = ?");
			statement.setInt(1, pesquisa);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
			 	String user = resultSet.getString("usuario");
			 	String password = resultSet.getString("senha");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String cref = resultSet.getString("cref");
				Professor professorFiltered = new Professor(matricula, user, password, nome, telefone, email, cref);
				return professorFiltered;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}

}