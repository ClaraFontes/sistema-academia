package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class DeleteController {
	
	public static Aluno deleteAluno(Integer matricula) throws RuntimeException, ClassNotFoundException, SQLException {
		if (matricula.toString().isBlank() || matricula.toString().isEmpty() || matricula.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new RuntimeException("Preencha os campos corretamente");
		}
		
		Repository repository = new MySQLRepository();
		return repository.deleteAluno(matricula);
	}
	
	public static Professor deleteProfessor(Integer matricula) throws RuntimeException, ClassNotFoundException, SQLException {
		if (matricula.toString().isBlank() || matricula.toString().isEmpty() || matricula.toString().matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
			throw new RuntimeException("Preencha os campos corretamente");
		}
		
		Repository repository = new MySQLRepository();
		return repository.deleteProfessor(matricula);
	}
}
