package com.breakdark.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Libreria para imprimir documentos
 * 
 * @author BreakDark
 * @version 1.0 18/04/2017
 */
public class Imprimir {

	/**
	 * Imprime un documento pdf por la interfaz del sistema operativo
	 * 
	 * @param archivo_pdf
	 *            Archivo file de tipo <code>File</code>
	 */
	public static void imprimirPDF(File archivo_pdf) {
		try {
			Desktop.getDesktop().print(archivo_pdf);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo imprimir el documento", "ERROR!!!",
					JOptionPane.ERROR_MESSAGE);
			System.out.println("No se pudo imprimir el documento");
			e.printStackTrace();
		}
	}
}
