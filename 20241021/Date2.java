package com.ifsc.ctds;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteDate {

	
	public static void main(String[] args) {

		Calendar calendario = Calendar.getInstance();
		
		JOptionPane.showMessageDialog(null, calendario.getTime());

	}

}
