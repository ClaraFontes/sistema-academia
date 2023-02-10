package br.edu.ifpe.paulista.tadala_fit.teste_unitario;

import static org.junit.Assert.*;

import java.sql.Blob;

import org.junit.Test;

import br.edu.ifpe.paulista.tadala_fit.core.CreateController;

public class CreateControllerTest {
	
	// ALUNO
	@Test
	public void testCreateAlunoBlankField() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createAluno("    ", "   ", "   ", "   ", "   ","   ", "  ", "    ",null,null, null, null, null,null, " ");
			//CreateController.createAluno("carlinhos", "123456", "carlinhos", "masculino", "302103213","1231283712", "carlinhos@gmail.com", "24/09/1993",1.70, 120.2, null, null, null);
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
		}

	@Test
	public void testCreateAlunoMatchesFields() {
		Exception exception = assertThrows(Exception.class, () -> {
			CreateController.createAluno("1231$@.!23"/*usuário*/, "12123"/*Senha*/, "1231$@.!23"/*Nome*/, "1231$@.!23"/*Sexo*/, "ASDUHSAIDUHSI"/*CPF*/, "ASDUHSAIDUHSI"/*telefone*/,"ASDUHSAIDUHSasdsadI"/*email*/, "24/0*&!&/10"/*dt_nascimento*/,1.90/*altura*/,75.7/*peso*/,12.0/*bf*/,"123812321"/*comorbidade*/, null/*Blob*/, null, "daddda");
		});
		assertEquals("Preencha os campos corretamente", exception.getMessage());
	}
	
	@Test
	public void testCreateAlunoMatchesPasswordSize() {
		Blob image = null;
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createAluno("testuser", "123", "Teste Nome", "Masculino", "12345678900", "1234567890", "teste@email.com", "2000-01-01", 1.70, 70.0, 20.0, "Nenhuma", image, null, "a");
		});
		assertEquals("Senha muito curta, use 6 ou mais caracteres", exception.getMessage());
	}
	
	@Test
	public void testCreateAlunoEmptyField() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createAluno("", "", "", "", "","", "", "",null,null, null, null, null, null, "");
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
	}
	
	//PROFESSOR
	@Test
	public void testCreateProfessorBlankField() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createProfessor( "   ", "   ", "   ", "   ","   ", "  ", null);
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
	}
	
	@Test
	public void testCreateProfessorMatchesFields() {
		Exception exception = assertThrows(Exception.class, () -> {
			CreateController.createProfessor( "1231$@.!23", "12123", "1231$@.!23", "ASDUHSAIDUHSI","ASDUHSAIDUHSasdsadI", "-=-=", null);
		});
		assertEquals("Preencha os campos corretamente", exception.getMessage());
	}
	
	@Test
	public void testCreateProfessorMatchesPasswordSize() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createProfessor("testeuser", "121", "Tete Nome", "81987876565","teste@gmail.com", "111111-L", null);
		});
		assertEquals("Senha muito curta, use 6 ou mais caracteres", exception.getMessage());
	}
	
	@Test
	public void testCreateProfessorEmptyField() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			CreateController.createProfessor( "", "", "", "","", "", null);
		});
		assertEquals("Preencha todos os campos", exception.getMessage());
	}

}
