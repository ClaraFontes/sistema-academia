package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import br.edu.ifpe.paulista.tadala_fit.core.AccessController;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;

public class ProfessorLoginTest {

	@Test
	public void test() {
		Professor loginProfessor;
		try {
			loginProfessor = AccessController.loginProfessor("matheus", "123456");
			assertNotNull(loginProfessor);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
		

}
