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
import org.json.JSONException;
import org.json.JSONObject;
import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;

public class MySQLRepository implements Repository {

	private static final String ROOT_SENHA = "Stormchadow123";	
	

	public MySQLRepository() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	public Professor cadastroProfessor(String user, String password, String nome, String telefone, String email, String cref, Blob image) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root",ROOT_SENHA);
			String sql = ("INSERT INTO professor(usuario, senha, nome, telefone, email, cref, foto) VALUES (?,?,?,?,?,?,?)");
			String sql2 = ("SELECT usuario,cref FROM professor a WHERE a.usuario = ? OR a.cref = ?");
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
				stm.setBlob(7, image);
				stm.execute();
				
			}
		} finally {
			connection.close();
		}
		Professor professorCadastrado = new Professor(user, password, nome, telefone, email, cref, image);
		return professorCadastrado;
	}
	
	
	public Aluno cadastroAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade, Blob image)  throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root",ROOT_SENHA);
			String sql = ("INSERT INTO aluno(usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade,foto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String sql2 = ("SELECT usuario,cpf FROM aluno a WHERE a.usuario = ? OR a.cpf = ?");
			PreparedStatement stm2 = connection.prepareStatement(sql2);
			stm2.setString(1, user);
			stm2.setString(2, cpf);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root",ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, usuario, senha, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade, matricula_prof_encarregado, treino_a, treino_b, treino_c, treino_d, treino_e, dt_pagamento, foto FROM aluno a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Aluno loginAluno = getAluno(resultSet);
				return loginAluno;
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT matricula, nome, telefone, email, cref, usuario, senha, foto FROM professor a WHERE a.usuario = ? AND a.senha = ?");
			statement.setString(1, user);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int matricula = resultSet.getInt("matricula");
				String nome = resultSet.getString("nome");
				String telefone = resultSet.getString("telefone");
				String email = resultSet.getString("email");
				String cref = resultSet.getString("cref");
				Blob image = resultSet.getBlob("foto");
				Professor professorAtual = new Professor(matricula, user, password, nome, telefone, email, cref, image);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 ArrayList<Aluno> alunos = new ArrayList<Aluno>();
				 	Aluno alunoRecebido = getAluno(resultSet);
					alunos.add(alunoRecebido);
				 while (resultSet.next()) {
					 Aluno alunoRecebido1 = getAluno(resultSet);
					alunos.add(alunoRecebido1);
				 }
				 return alunos;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}

	
	public Aluno getAlunoFiltered(Integer pesquisa, String nome) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM aluno a WHERE a.matricula = ? OR a.nome = ?");
			statement.setInt(1, pesquisa);
			statement.setString(2, nome);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
			Aluno AlunoFiltered = getAluno(resultSet);
			return AlunoFiltered;
			} else {
				JOptionPane.showMessageDialog(null,"Aluno não encontrado");
				return null;
			}
		} finally {
			connection.close();
		}
	}
	
	public Aluno updateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula, Blob image) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql1 = ("UPDATE aluno a SET telefone = ?, email = ?, altura = ?, peso = ?, bf = ?, foto = ? WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, telefone);
			statement1.setString(2, email);
			statement1.setDouble(3, altura);
			statement1.setDouble(4, peso);
			statement1.setDouble(5, bf);
			statement1.setBlob(6,image);
			statement1.setInt(7, matricula);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Atualização feita com Sucesso,Reinicie a sessão para ve as alterações!");
		} finally {
			connection.close();
		}
		return null;
	}
	
	public ArrayList<Professor> getAllProfessor() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 ArrayList<Professor> professores = new ArrayList<Professor>();
				 	Professor professorRecebido0 = getProfessor(resultSet);
					professores.add(professorRecebido0);
				 while (resultSet.next()) {
					 	Professor professorRecebido = getProfessor(resultSet);
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
	
	public Professor getProfessorFiltered(Integer pesquisa,  String nome) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM professor a WHERE a.matricula = ? OR a.nome = ?");
			statement.setInt(1, pesquisa);
			statement.setString(2, nome);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Professor professofiltered = getProfessor(resultSet);
				return professofiltered;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}
	}

	public Professor updateProfessor(String telefone, String email,Integer matricula, Blob image) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql1 = ("UPDATE professor a SET telefone = ?, email = ?, foto = ? WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, telefone);
			statement1.setString(2, email);
			statement1.setBlob(3, image);
			statement1.setInt(4, matricula);
			statement1.execute();
			JOptionPane.showMessageDialog(null, "Atualização feita com Sucesso, reinicie a sessão para ver as alterações!");
		} finally {
			connection.close();
		}
		return null;
	}
	
	public Aluno deleteAluno(int matricula) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql1 = ("DELETE FROM aluno a WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, matricula);
			statement1.execute();
		} finally {
			connection.close();
		}
		return null;
	}
	
	public Professor deleteProfessor(int matricula) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql1 = ("DELETE FROM professor a WHERE matricula = ?");
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, matricula);
			statement1.execute();
		} finally {
			connection.close();
		}
		return null;
	}

	public Aluno updatePagamento(String data,int matricula) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET dt_pagamento = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, data);
			statement.setInt(2,matricula);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Pagamento Realizado com Sucesso");
		}finally {
			connection.close();
		}
		return null;
	}
	
	public ArrayList<Aluno> getAlunosWithoutProf() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String  sql = ("SELECT * FROM aluno a WHERE matricula_prof_encarregado IS NULL");
			PreparedStatement statement = connection.prepareStatement(sql);
			//statement.setNull(1, java.sql.Types.INTEGER);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 ArrayList<Aluno> alunosWithoutProf = new ArrayList<Aluno>();
				 	Aluno alunoRecebido = getAluno(resultSet);
					alunosWithoutProf.add(alunoRecebido);
				 while (resultSet.next()) {
					 Aluno alunoRecebido1 = getAluno(resultSet);
					alunosWithoutProf.add(alunoRecebido1);
				 }
				 return alunosWithoutProf;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}

		}
	
	public ArrayList<Aluno> getMyAlunos(int matriculaProf) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String  sql = ("SELECT * FROM aluno a WHERE matricula_prof_encarregado = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, matriculaProf);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 ArrayList<Aluno> myAlunos = new ArrayList<Aluno>();
				 	Aluno alunoRecebido = getAluno(resultSet);
				 	myAlunos.add(alunoRecebido);
				 while (resultSet.next()) {
					 Aluno alunoRecebido1 = getAluno(resultSet);
					 myAlunos.add(alunoRecebido1);
				 }
				 return myAlunos;
			} else {
				return null;
			}
		} finally {
			connection.close();
		}

		}
	
	public Aluno assumeAluno(int matriculaProf, int matriculaAluno) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET matricula_prof_encarregado = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, matriculaProf);
			statement.setInt(2,matriculaAluno);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Aluno assumido com sucesso");
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	public Aluno cadastrarTreinoA(int matriculaAluno, JSONObject treino) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET treino_a = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			if (treino != null) {
				statement.setObject(1, treino.toString());
			} else {
				statement.setObject(1, null);
			}
			statement.setInt(2, matriculaAluno);
			statement.execute();
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	public Aluno cadastrarTreinoB(int matriculaAluno, JSONObject treino) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET treino_a = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			if (treino != null) {
				statement.setObject(1, treino.toString());
			} else {
				statement.setObject(1, null);
			}
			statement.setInt(2, matriculaAluno);
			statement.execute();
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	public Aluno cadastrarTreinoC(int matriculaAluno, JSONObject treino) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET treino_a = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			if (treino != null) {
				statement.setObject(1, treino.toString());
			} else {
				statement.setObject(1, null);
			}
			
			statement.setInt(2, matriculaAluno);
			statement.execute();
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	public Aluno cadastrarTreinoD(int matriculaAluno, JSONObject treino) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET treino_a = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			if (treino != null) {
				statement.setObject(1, treino.toString());
			} else {
				statement.setObject(1, null);
			}
			statement.setInt(2, matriculaAluno);
			statement.execute();
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	public Aluno cadastrarTreinoE(int matriculaAluno, JSONObject treino) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tadalafit", "root", ROOT_SENHA);
			String sql = ("UPDATE aluno a SET treino_a = ? WHERE matricula = ?");
			PreparedStatement statement = connection.prepareStatement(sql);
			if (treino != null) {
				statement.setObject(1, treino.toString());
			} else {
				statement.setObject(1, null);
			}
			statement.setInt(2, matriculaAluno);
			statement.execute();
		} finally {
			connection.close();
		}
		return null;
		
	}
	
	
	private Aluno getAluno(ResultSet resultSet) throws SQLException, JSONException {
		Integer matricula = resultSet.getInt("matricula");
		String user = resultSet.getString("usuario");
		String password = resultSet.getString("senha");
		String nome = resultSet.getString("nome");
		String sexo = resultSet.getString("sexo");
		String cpf = resultSet.getString("cpf");
		String telefone = resultSet.getString("telefone");
		String email = resultSet.getString("email");
		String data_nascimento= resultSet.getString("data_nascimento");
		Double altura = resultSet.getDouble("altura");
		Double peso = resultSet.getDouble("peso");
		Double bf = resultSet.getDouble("bf");
		String comorbidade = resultSet.getString("comorbidade");
		int matricula_prof_encarregado = resultSet.getInt("matricula_prof_encarregado");
		String dt_pagamento = resultSet.getString("dt_pagamento");
		DateTime dataHoraAtual = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		DateTime dt = formatter.parseDateTime(dt_pagamento);
		int dias = Days.daysBetween(dt, dataHoraAtual).getDays();
		Object treino_a = resultSet.getObject("treino_a");
		JSONObject treino_a_JSON = null;
		
		Object treino_b = resultSet.getObject("treino_b");
		JSONObject treino_b_JSON = null;
		
		Object treino_c = resultSet.getObject("treino_c");
		JSONObject treino_c_JSON = null;
		
		Object treino_d = resultSet.getObject("treino_d");
		JSONObject treino_d_JSON = null;
		
		Object treino_e = resultSet.getObject("treino_e");
		JSONObject treino_e_JSON = null;
		if (treino_a != null) {
			treino_a_JSON = new JSONObject(treino_a.toString());
		}	
		if (treino_b != null) {
			treino_b_JSON = new JSONObject(treino_b.toString());
		}
		
		if (treino_c != null) {
			treino_c_JSON = new JSONObject(treino_c.toString());
		}
		
		if (treino_d != null) {
			treino_d_JSON = new JSONObject(treino_d.toString());
		}
		
		if (treino_e != null) {
			treino_e_JSON = new JSONObject(treino_e.toString());
		}
		
		Blob image = (Blob) resultSet.getBlob("foto");
		Aluno alunoRecebido = new Aluno(matricula, user, password, nome, sexo, cpf,telefone, email, data_nascimento,altura, peso, bf, comorbidade, matricula_prof_encarregado, dias, treino_a_JSON, treino_b_JSON, treino_c_JSON, treino_d_JSON, treino_e_JSON, image);
		return alunoRecebido;
	}
	private Professor getProfessor(ResultSet resultSet) throws SQLException {
		int matricula = resultSet.getInt("matricula");
		String user = resultSet.getString("usuario");
		String password = resultSet.getString("senha");
		String nome = resultSet.getString("nome");
		String telefone = resultSet.getString("telefone");
		String email = resultSet.getString("email");
		String cref = resultSet.getString("cref");
		Blob image = resultSet.getBlob("foto");
		Professor professorRecebido = new Professor(matricula, user, password, nome, telefone, email, cref, image);
		return professorRecebido;
	}

}