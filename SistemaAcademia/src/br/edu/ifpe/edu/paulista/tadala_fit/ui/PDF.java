package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF {

	public PDF (String frase, String nome) {
		Document documentoPDF = new Document();
		try {
			PdfWriter.getInstance(documentoPDF, new FileOutputStream(nome+".pdf"));	
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
}



 