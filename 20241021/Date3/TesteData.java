package com.ifsc.ctds;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class TesteData {

	public static void main(String[] args) {
			Date hoje = new Date();
			DateFormat df1 = null;
			String dataFormatada = null;

			df1 = DateFormat.getDateInstance(DateFormat.FULL);
			dataFormatada = df1.format(hoje);
			
			JOptionPane.showMessageDialog(null, dataFormatada);

		}
	}

