package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;


public interface Repository {

		public Aluno loginAluno(String user, String password) throws SQLException;
		public Professor loginProfessor(String user, String password) throws SQLException;
		public Administrador loginAdm(String user, String password) throws SQLException;
		public Aluno cadastroAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade) throws SQLException;
		public Professor cadastroProfessor(String user, String password, String nome, String telefone, String email, String cref) throws SQLException;
		public ArrayList<Aluno> getAllAluno() throws SQLException;
		public Aluno getAlunoFiltered(Integer pesquisa) throws SQLException;
		public Aluno updateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula) throws SQLException;
}