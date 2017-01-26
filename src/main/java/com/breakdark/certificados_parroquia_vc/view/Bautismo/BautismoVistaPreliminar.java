/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.view.Bautismo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

/**
 * @author BreakDark
 *
 */
public class BautismoVistaPreliminar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BautismoVistaPreliminar dialog = new BautismoVistaPreliminar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public BautismoVistaPreliminar() throws IOException {
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 400, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			PagePanel panelpdf = new PagePanel();
			panelpdf.setBounds(21, 11, 349, 471);
			File file = new File("recursos/test.pdf");
	        @SuppressWarnings("resource")
			RandomAccessFile raf = new RandomAccessFile(file, "r");
	        FileChannel channel = raf.getChannel();
	        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0, channel.size());
	        PDFFile pdffile = new PDFFile(buf);
	        PDFPage page = pdffile.getPage(0);
			contentPanel.setLayout(null);
	        
			contentPanel.add(panelpdf);
			panelpdf.showPage(page);
	        repaint();
	        panelpdf.repaint();
	        panelpdf.setVisible(true);
		}
		// contentPanel.setLayout(null);
		// fondo del panel
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("certBautismo_fondo.jpg"));
		System.out.println(imagenFondo.getImage());
		contentPanel.paintComponents(super.getGraphics());// imageUpdate(imagenFondo.getImage(),
															// 1, 0, 0,200,
															// 400);
		contentPanel.repaint();
		//contentPanel.getGraphics().create();

		// contentPanel.paint(Graphics g){

	};

	// System.out.println(gr);

	// contentPanel.getGraphics().drawImage(imagenFondo.getImage(),0,0,null);
	// contentPanel.paintComponents(g);

	// contentPanel.setOpaque(false);
	// contentPanel.setBackground(new
	// ImageIcon("recursos//certBautismo_fondo.jpg").getImage());
	// contentPanel.repaint();

	{
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}
}
