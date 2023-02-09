package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import br.edu.ifpe.paulista.tadala_fit.core.AccessController;
import br.edu.ifpe.paulista.tadala_fit.core.Administrador;

public class AdminLoginTest {

	@Test
	public void test() {
		Administrador loginAdmin;
		try {
			loginAdmin = AccessController.loginAdm("matheus", "123");
			assertNotNull(loginAdmin);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	    }
	}

