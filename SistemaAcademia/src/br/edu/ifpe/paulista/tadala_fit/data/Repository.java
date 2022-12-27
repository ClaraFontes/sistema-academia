package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;


public interface Repository {

		public Aluno loginAluno(String user, String password) throws SQLException;
		public Professor loginProfessor(String user, String password) throws SQLException;
		public Administrador loginAdm(String user, String password) throws SQLException;
		
	}

