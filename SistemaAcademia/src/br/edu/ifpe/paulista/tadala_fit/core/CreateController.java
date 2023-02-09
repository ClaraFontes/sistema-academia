package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.Blob;
import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class CreateController { 
	
	public static Aluno createAluno(String user, String password, String nome, String sexo, String cpf, String telefone, String email, String data_nascimento, Double altura, Double peso, Double bf, String comorbidade, Blob image) throws ClassNotFoundException, SQLException, Exception {
		
		if(user.isBlank() || password.isBlank() || nome.isBlank() || sexo.isBlank() || cpf.isBlank() || telefone.isBlank() || email.isBlank() || data_nascimento.isBlank() || altura.toString().isBlank() || peso.toString().isBlank() || bf.toString().isBlank() || comorbidade.isBlank()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		else if(nome.matches("^[0-9]*[.]{0,1}[0-9]*$") || sexo.matches("^[0-9]*[.]{0,1}[0-9]*$") || comorbidade.matches("^[0-9]*[.]{0,1}[0-9]*$") || cpf.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || altura.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || peso.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || bf.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new Exception("Preencha os campos corretamente");
		}
		
		else if(password.length() <= 5) {
			throw new RuntimeException("Senha muito curta, use 6 ou mais caracteres");
		}
		
		else if(user.isEmpty() || password.isEmpty() || nome.isEmpty() || sexo.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty() || data_nascimento.isEmpty() || altura.toString().isEmpty() || peso.toString().isEmpty() || bf.toString().isEmpty() || comorbidade.isEmpty()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		Repository repository = new MySQLRepository();
		return repository.cadastroAluno(user, password, nome, sexo, cpf, telefone, email, data_nascimento, altura, peso, bf, comorbidade, image);
	}
	
	public static Professor createProfessor(String user, String password, String nome, String telefone, String email, String cref, Blob image) throws ClassNotFoundException, SQLException, Exception {
		if(user.isBlank() || password.isBlank() || nome.isBlank() || telefone.isBlank() || email.isBlank() || cref.isBlank()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		else if(nome.matches("^[0-9]*[.]{0,1}[0-9]*$") || telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || cref.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new Exception("Preencha os campos corretamente");
		}
		
		else if(password.length() <= 5) {
			throw new RuntimeException("Senha muito curta, use 6 ou mais caracteres");
		}
		
		else if(user.isEmpty() || password.isEmpty() || nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || cref.isEmpty() ) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		Repository repository = new MySQLRepository();
		return repository.cadastroProfessor(user, password, nome, telefone, email, cref, image);
	}
}
