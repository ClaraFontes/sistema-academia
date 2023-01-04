package br.edu.ifpe.paulista.tadala_fit.core;

import java.sql.SQLException;

import br.edu.ifpe.paulista.tadala_fit.data.MySQLRepository;
import br.edu.ifpe.paulista.tadala_fit.data.Repository;

public class AccessController {

	
		
		public static Aluno loginAluno(String user, String password) throws ClassNotFoundException, SQLException {
			if (user.isBlank() || password.isBlank()) {
				throw new RuntimeException("Inform user and password.");
			}
			
			Repository repository = new MySQLRepository();
			return repository.loginAluno(user, password);
		

	}
		
		public static Professor loginProfessor(String user, String password) throws ClassNotFoundException, SQLException {
			if (user.isBlank() || password.isBlank()) {
				throw new RuntimeException("Inform user and password.");
			}
			
			Repository repository = new MySQLRepository();
			return repository.loginProfessor(user, password);
		

	}
		
		public static Administrador loginAdm(String user, String password) throws ClassNotFoundException, SQLException {
			if (user.isBlank() || password.isBlank()) {
				throw new RuntimeException("Inform user and password.");
			}
			
			Repository repository = new MySQLRepository();
			return repository.loginAdm(user, password);			
			
		

	}
		
		
}
