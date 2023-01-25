package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class UpdateController {
	public static Aluno UpdateAluno(Integer matricula, String telefone, String email, Double  altura, Double peso, Double bf) throws ClassNotFoundException, SQLException, Exception {
		if( telefone.isBlank() || email.isBlank() || altura.toString().isBlank() || peso.toString().isBlank() || bf.toString().isBlank()) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		else if( matricula.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || telefone.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || altura.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || peso.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || bf.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new Exception("Preencha os campos corretamente");
		}
		
		else if( telefone.isEmpty() || email.isEmpty() || altura.toString().isEmpty() || peso.toString().isEmpty() || bf.toString().isEmpty() ) {
			throw new RuntimeException("Preencha todos os campos");
		}
		
		Repository repository = new MySQLRepository();
		return repository.updateAluno(matricula, telefone, email, altura, peso, bf);
	}
}
