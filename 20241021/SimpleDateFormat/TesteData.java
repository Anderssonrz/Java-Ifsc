package com.ifsc.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteData {

	public static void main(String[] args) {
		
		Date hoje = new Date();
		DateFormat df1 = null;
		String formato = "dd/MM/yyyy";
	
		df1 = new SimpleDateFormat(formato);
		
		JOptionPane.showMessageDialog(null, df1.format(hoje));

	
	}

}
