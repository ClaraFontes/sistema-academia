package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;

import org.junit.Test;
import br.edu.ifpe.paulista.tadala_fit.core.UpdateController;

public class UpdateControllerTest {

	@Test
	public void test() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			UpdateController.UpdateAluno("", "", 1.70, 78.5, 10.0, 2, null, null, "");
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
		};
		
	/*@Test
	public void test2() {
		Exception exception = assertThrows(Exception.class, () -> {
			UpdateController.UpdateAluno("adadadad", "SASDADAD", "a", "b", "c", "d", null);			
		});
		assertEquals("Preencha os campos corretamente", exception.getMessage());
		};*/
}


