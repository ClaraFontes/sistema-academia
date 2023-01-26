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
	
	public static Aluno getAlunoFiltered(String pesquisa) throws ClassNotFoundException, SQLException {
		Repository repository = new MySQLRepository();
		return repository.getAlunoFiltered(pesquisa);
	}
}
