package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

import br.edu.ifpe.paulista.tadala_fit.core.AccessController;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

public class AlunoLoginTest {

	@Test
	public void test() {
		Aluno loginAluno;
			try {
				loginAluno = AccessController.loginAluno("NAOEXISTENOBANCO", "ana");
				assertNotNull(loginAluno);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
		    }
}
