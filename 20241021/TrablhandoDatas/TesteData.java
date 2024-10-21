package com.ifsc.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteData {

	public static void main(String[] args) {
		
		Calendar dataInicio = Calendar.geInstance();
		dataInicio.set(2024, Calendar.JANUARY,1);
		
		String formato = "dd/MM/yyyy";
	
		df1 = new SimpleDateFormat(formato);
		
		JOptionPane.showMessageDialog(null, df1.format(hoje));

	
	}

}
