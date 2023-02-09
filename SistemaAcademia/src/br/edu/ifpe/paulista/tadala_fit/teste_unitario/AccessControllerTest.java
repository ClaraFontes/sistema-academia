package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import br.edu.ifpe.paulista.tadala_fit.core.AccessController;
import br.edu.ifpe.paulista.tadala_fit.core.Administrador;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;
import br.edu.ifpe.paulista.tadala_fit.core.Professor;

public class AccessControllerTest {
	
	// LOGIN DE ADMIN
	Administrador loginAdmin;
	@Test
	public void loginValidAdmin() {
		try {
			loginAdmin = AccessController.loginAdm("clara", "12345");
			assertNotNull(loginAdmin);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	    }
	@Test
	public void loginInvalidAdmin() {
		try {
			loginAdmin = AccessController.loginAdm("naoexiste", "123"); // falha programada.
			assertNotNull(loginAdmin);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	    }
	
	@Test
	public void testAdminEmptyFields() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			loginAdmin = AccessController.loginAdm(" ", " ");
		});
		assertEquals("Inform user and password.", exception.getMessage());
	}
	
	//LOGIN PROFESSOR
	Professor loginProfessor;
	@Test
	public void testValidProfessor() {
		try {
			loginProfessor = AccessController.loginProfessor("prof clara", "123");
			assertNotNull(loginProfessor);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void testInvalidProfessor() {
		try {
			loginProfessor = AccessController.loginProfessor("naoexiste", "123456"); // falha programada.
			assertNotNull(loginProfessor);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void testProfessorEmptyFields() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			loginProfessor = AccessController.loginProfessor(" ", " ");
		});
		assertEquals("Inform user and password.", exception.getMessage());
	
	}
	
	//LOGIN ALUNO
	Aluno loginAluno;
	@Test
	public void testInvalidAluno() {
			try {
				loginAluno = AccessController.loginAluno("NAOEXISTENOBANCO", "ana"); // falha programada.
				assertNotNull(loginAluno);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		    }
	@Test
	public void testValidAluno() {
			try {
				loginAluno = AccessController.loginAluno("clara", "ana"); 
				assertNotNull(loginAluno);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		    }

	
	@Test
	public void testAlunoEmptyFields() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			loginAluno = AccessController.loginAluno(" ", " ");
		});
		assertEquals("Inform user and password.", exception.getMessage());
	}

}
