package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class ReadController {
	
	public static ArrayList<Aluno> getAllAlunos() throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getAllAluno();
	}
	
	public static Aluno getAlunoFiltered(Integer pesquisa,String nome) throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getAlunoFiltered(pesquisa,nome);
	}
	
	public static ArrayList<Professor> getAllProfessor() throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getAllProfessor();
	}
	
	public static Professor getProfessorFiltered(Integer pesquisa, String nome) throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getProfessorFiltered(pesquisa, nome);
	}
	
	public static ArrayList<Aluno> getMyAlunos(int matriculaProf) throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getMyAlunos(matriculaProf);
	}
	
	public static ArrayList<Aluno> getAlunosWithoutProf() throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getAlunosWithoutProf();
	}
	
}