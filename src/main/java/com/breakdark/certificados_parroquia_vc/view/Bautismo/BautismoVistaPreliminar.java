/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.view.Bautismo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 */
	public BautismoVistaPreliminar() throws IOException, DocumentException {
		setAlwaysOnTop(true);
		setBounds(100, 100, 675, 683);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			// cargamos la plantilla a diligenciar
			//File archivoPDF_origen = new File("recursos/bautismo_preliminar.pdf");
			File archivoPDF_destino = new File("recursos/temp.pdf");
			
			archivoPDF_destino.getParentFile().mkdir();
			
//			ByteArrayOutputStream arrayBytes = new ByteArrayOutputStream();
//			PdfWriter f;
			
			PdfReader pdfReader = new PdfReader("recursos/bautismo_preliminar.pdf");
			FileOutputStream fileStream=new FileOutputStream(archivoPDF_destino);
			PdfStamper stamper = new PdfStamper(pdfReader, fileStream);
			//PdfStamper stamper = new PdfStamper(pdfReader,Ounew OutputStream());
			// se obtienen los campos del formulario
			AcroFields pdfForm = stamper.getAcroFields();
			pdfForm.removeXfa();
			// se llenan los campos del formulario
			// datos de la parroquia
			pdfForm.setField("txtParroquia", "LLLLLLLLLLLLLLLLLLLL");
			pdfForm.setField("txtPresbitero", "FFFFFFFFFFFFFFFFFFF");
			// datos del bautismo
			// pdfForm.setField("libro", bautismo.getLibro());
			// pdfForm.setField("pagina", bautismo.getPagina());
			// pdfForm.setField("partida", bautismo.getPartida());
			// pdfForm.setField("paterno", bautismo.getPaterno());
			// pdfForm.setField("materno", bautismo.getMaterno());
			// pdfForm.setField("nombres", bautismo.getNombres());
			// pdfForm.setField("lugar_bautismo", bautismo.getLugar_bautismo());
			// pdfForm.setField("fecha_bautismo",
			// bautismo.mostrarFechaBautismo());
			// pdfForm.setField("lugar_nacimiento",
			// bautismo.getLugar_nacimiento());
			// pdfForm.setField("fecha_nacimiento",
			// bautismo.mostrarFechaNacimiento());
			// pdfForm.setField("padre", bautismo.getPadre());
			// pdfForm.setField("madre", bautismo.getMadre());
			// pdfForm.setField("padrino", bautismo.getPadrino());
			// pdfForm.setField("madrina", bautismo.getMadrina());
			// pdfForm.setField("oficialia", bautismo.getOficialia());
			// pdfForm.setField("libro_oficialia",
			// bautismo.getLibro_oficialia());
			// pdfForm.setField("partida_oficialia",
			// bautismo.getPartida_oficialia());
			// pdfForm.setField("parroco", bautismo.getParroco());
			// pdfForm.setField("notas", bautismo.getNotas());
			// // datos del lugar y la fecha actual
			// pdfForm.setField("lugar", configuracion.getLugar());
			// pdfForm.setField("lugar2", configuracion.getLugar());
			// Calendar hoy = Calendar.getInstance();
			// pdfForm.setField("dia", Integer.toString(hoy.get(Calendar.DATE)));
			// pdfForm.setField("mes",
			// FechaBreakDark.mostrarMes(hoy.get(Calendar.MONTH))
			// .toUpperCase());
			// pdfForm.setField("gestion",
			// Integer.toString(hoy.get(Calendar.YEAR) % 10));
			// cerramos el archivo
			//stamper.setFormFlattening(true);
			//stamper.setFullCompression();//.setFreeTextFlattening(true);
			stamper.close();
			pdfReader.close();
			
			//arrayBytes

			PagePanel panelpdf = new PagePanel();
			panelpdf.setBounds(21, 11, 571, 610);
			
			@SuppressWarnings("resource")
			//RandomAccessFile raf = new RandomAccessFile(archivoPDF, "r");
			RandomAccessFile raf = new RandomAccessFile(archivoPDF_destino, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
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
		// ImageIcon imagenFondo = new
		// ImageIcon(getClass().getResource("certBautismo_fondo.jpg"));
		// System.out.println(imagenFondo.getImage());
		// contentPanel.paintComponents(super.getGraphics());//
		// imageUpdate(imagenFondo.getImage(),
		// // 1, 0, 0,200,
		// // 400);
		// contentPanel.repaint();
		// contentPanel.getGraphics().create();

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
