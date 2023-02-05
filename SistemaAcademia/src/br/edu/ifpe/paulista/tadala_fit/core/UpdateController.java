package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.Blob;
import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class UpdateController {
	public static Aluno UpdateAluno(String telefone, String email, Double  altura, Double peso, Double bf,Integer matricula, Blob imagemBlob) throws ClassNotFoundException, SQLException, Exception {
		if( telefone.isBlank() || email.isBlank() || altura.toString().isBlank() || peso.toString().isBlank() || bf.toString().isBlank()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		else if(telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || altura.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || peso.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || bf.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new Exception("Preencha os campos corretamente");
		}
		
		else if( telefone.isEmpty() || email.isEmpty() || altura.toString().isEmpty() || peso.toString().isEmpty() || bf.toString().isEmpty() ) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		Repository repository = new MySQLRepository();
		return repository.updateAluno(telefone, email, altura, peso, bf,matricula, imagemBlob);
	}
	
	public static Professor UpdateProfessor(String telefone, String email,Integer matricula, Blob image) throws ClassNotFoundException, SQLException, Exception {
		if( telefone.isBlank() || email.isBlank()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		else if(telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new Exception("Preencha os campos corretamente");
		}
		
		else if( telefone.isEmpty() || email.isEmpty()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		Repository repository = new MySQLRepository();
		return repository.updateProfessor(telefone, email, matricula,image);
	}
	public static Aluno updatePagamento(String date, int matricula)throws ClassNotFoundException, SQLException, Exception {
		Repository repository = new MySQLRepository();
		return repository.updatePagamento(date, matricula);
	}
}
