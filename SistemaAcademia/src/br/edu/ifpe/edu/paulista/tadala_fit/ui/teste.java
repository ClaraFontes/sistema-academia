package br.edu.ifpe.edu.paulista.tadala_fit.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class teste {

	public static void main(String[] args) {
		Date hoje = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = formato.format(hoje);
		System.out.print(dataFormatada);
		
		

	}

}
