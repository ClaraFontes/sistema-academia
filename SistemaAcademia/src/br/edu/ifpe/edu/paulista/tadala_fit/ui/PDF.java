package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import br.edu.ifpe.paulista.tadala_fit.core.Aluno;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF {
	
	protected String alunoNome;
	
	public PDF (String frase) {
		Document documentoPDF = new Document();
		try {
			PdfWriter.getInstance(documentoPDF, new FileOutputStream("Boleto"+alunoNome+".pdf"));	
			documentoPDF.open();
			Paragraph paragrafo = new Paragraph(frase);
			documentoPDF.add(paragrafo);	
					
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		documentoPDF.close();
	}
	
	public void getAluno(Aluno alunoLogado) {
		alunoNome = alunoLogado.getNome();
		
	}	
}



 