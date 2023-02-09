package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;
import org.junit.Test;
import br.edu.ifpe.paulista.tadala_fit.core.CreateController;

public class AlunoRegisterTest {
	
	/*	String user = "testuser";
		String password = "testpass";
		String nome = "Teste Nome";
		String sexo = "Masculino";
		String cpf = "12345678900";
		String telefone = "1234567890";
		String email = "teste@email.com";
		String data_nascimento = "2000-01-01";
		Double altura = 1.70;
		Double peso = 70.0;
		Double bf = 20.0;
		String comorbidade = "Nenhuma";
		Blob image = null;
		*/

	@Test
	public void testCreateAlunoBlankField() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createAluno("", "", "", "", "","", "", "",null,null, null, null, null);
			//CreateController.createAluno("carlinhos", "123456", "carlinhos", "masculino", "302103213","1231283712", "carlinhos@gmail.com", "24/09/1993",1.70, 120.2, null, null, null);
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
		}

	@Test
	public void testCreateAlunoMatchesFields() {
		Exception exception = assertThrows(Exception.class, () -> {
			CreateController.createAluno("1231$@.!23"/*usuário*/, "12123"/*Senha*/, "1231$@.!23"/*Nome*/, "1231$@.!23"/*Sexo*/, "ASDUHSAIDUHSI"/*CPF*/, "ASDUHSAIDUHSI"/*telefone*/,"ASDUHSAIDUHSasdsadI"/*email*/, "24/0*&!&/10"/*dt_nascimento*/,1.90/*altura*/,75.7/*peso*/,12.0/*bf*/,"123812321"/*comorbidade*/, null/*Blob*/);
		});
		assertEquals("Preencha os campos corretamente", exception.getMessage());
	}
}

	