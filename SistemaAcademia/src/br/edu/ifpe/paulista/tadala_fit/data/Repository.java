package br.edu.ifpe.paulista.tadala_fit.data;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONObject;

import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;


public interface Repository {

		public Aluno loginAluno(String user, String password) throws SQLException;
		public Professor loginProfessor(String user, String password) throws SQLException;
		public Administrador loginAdm(String user, String password) throws SQLException;
		public Aluno cadastroAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade, Blob image, JSONObject evolucao, String ultimaevolucao) throws SQLException;
		public Professor cadastroProfessor(String user, String password, String nome, String telefone, String email, String cref, Blob image) throws SQLException;
		public ArrayList<Aluno> getAllAluno() throws SQLException;
		public Aluno getAlunoFiltered(Integer pesquisa, String nome) throws SQLException;
		public Aluno updateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula, Blob image,JSONObject evolucao, String ultimaevolucao) throws SQLException;
		public Aluno updateAlunoAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula, Blob image) throws SQLException;
		public ArrayList<Professor> getAllProfessor() throws SQLException;
		public Professor getProfessorFiltered(Integer pesquisa, String nome) throws SQLException;
		public Professor updateProfessor(String telefone, String email,Integer matricula, Blob image) throws SQLException;
		public Aluno deleteAluno(int matricula)  throws SQLException;
		public Professor deleteProfessor(int matricula)  throws SQLException;
		public Aluno updatePagamento(String data, int matricula) throws SQLException;
		public ArrayList<Aluno> getAlunosWithoutProf() throws SQLException;
		public ArrayList<Aluno> getMyAlunos(int matriculaProf) throws SQLException;
		public Aluno assumeAluno(int matriculaProf, int matriculaAluno) throws SQLException;
		public Aluno cadastrarTreinoA(int matriculaAluno, JSONObject treino) throws SQLException;
		public Aluno cadastrarTreinoB(int matriculaAluno, JSONObject treino) throws SQLException;
		public Aluno cadastrarTreinoC(int matriculaAluno, JSONObject treino) throws SQLException;
		public Aluno cadastrarTreinoD(int matriculaAluno, JSONObject treino) throws SQLException;
		public Aluno cadastrarTreinoE(int matriculaAluno, JSONObject treino) throws SQLException;
}