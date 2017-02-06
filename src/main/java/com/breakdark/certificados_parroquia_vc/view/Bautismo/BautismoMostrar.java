/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.view.Bautismo;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;
import org.apache.pdfbox.printing.PDFPageable;

import com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.awt.event.ActionEvent;

/**
 * @author BreakDark
 * @vesrion 1.0 16/01/2017
 */
public class BautismoMostrar extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblMadrina;
	private JLabel lblPaterno;
	private JLabel lblPagina;
	private JLabel lblMaterno;
	private JLabel lblLugarNacimiento;
	private JLabel lblNombres;
	private JLabel lblPadre;
	private JLabel lblPartidaOficialia;
	private JLabel lblFechaNacimiento;
	private JLabel lblNotas;
	private JLabel lblParroco;
	private JLabel lblFechaBautismo;
	private JLabel lblLugarBautismo;
	private JLabel lblLibro;
	private JLabel lblPartida;
	private JLabel lblOficialia;
	private JLabel lblPadrino;
	private JLabel lblMadre;
	private JLabel lblLibroOficialia;

	private Bautismo bautismo;

	/**
	 * Create the dialog.
	 */
	public BautismoMostrar() {
		setTitle("Datos del Bautismo");
		setBounds(100, 100, 576, 522);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lbl_Libro = new JLabel("Libro:");
			lbl_Libro.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_Libro.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_Libro);
		}
		{
			lblLibro = new JLabel("libro bautismo");
			contentPanel.add(lblLibro);
		}
		{
			JLabel lbl_Pgina = new JLabel("Página:");
			lbl_Pgina.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_Pgina.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_Pgina);
		}
		{
			lblPagina = new JLabel("pagina bautismo");
			contentPanel.add(lblPagina);
		}
		{
			JLabel lbl_Partida = new JLabel("Partida:");
			lbl_Partida.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_Partida.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_Partida);
		}
		{
			lblPartida = new JLabel("partida bautismo");
			contentPanel.add(lblPartida);
		}
		{
			JLabel lbl_ApellidoPaterno = new JLabel("Apellido Paterno:");
			lbl_ApellidoPaterno.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_ApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_ApellidoPaterno);
		}
		{
			lblPaterno = new JLabel("paterno bautismo");
			contentPanel.add(lblPaterno);
		}
		{
			JLabel lbl_ApellidoMaterno = new JLabel("Apellido Materno:");
			lbl_ApellidoMaterno.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_ApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_ApellidoMaterno);
		}
		{
			lblMaterno = new JLabel("materno bautismo");
			contentPanel.add(lblMaterno);
		}
		{
			JLabel lbl_Nombres = new JLabel("Nombres:");
			lbl_Nombres.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_Nombres.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lbl_Nombres);
		}
		{
			lblNombres = new JLabel("nombres bautismo");
			contentPanel.add(lblNombres);
		}
		{
			JLabel lblLugarDelBautismo = new JLabel("Lugar de Bautismo:");
			lblLugarDelBautismo.setHorizontalAlignment(SwingConstants.LEFT);
			lblLugarDelBautismo.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblLugarDelBautismo);
		}
		{
			lblLugarBautismo = new JLabel("lugar bautismo");
			contentPanel.add(lblLugarBautismo);
		}
		{
			JLabel lblFechaSelBautismo = new JLabel("Fecha de Bautismo:");
			lblFechaSelBautismo.setHorizontalAlignment(SwingConstants.LEFT);
			lblFechaSelBautismo.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblFechaSelBautismo);
		}
		{
			lblFechaBautismo = new JLabel("fecha bautismo");
			contentPanel.add(lblFechaBautismo);
		}
		{
			JLabel lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento:");
			lblLugarDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblLugarDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblLugarDeNacimiento);
		}
		{
			lblLugarNacimiento = new JLabel("lugar nacimiento");
			contentPanel.add(lblLugarNacimiento);
		}
		{
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
			lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblFechaDeNacimiento);
		}
		{
			lblFechaNacimiento = new JLabel("fecha bautismo");
			contentPanel.add(lblFechaNacimiento);
		}
		{
			JLabel lblNombreDelPadre = new JLabel("Nombre del Padre:");
			lblNombreDelPadre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombreDelPadre.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNombreDelPadre);
		}
		{
			lblPadre = new JLabel("padre bautismo");
			contentPanel.add(lblPadre);
		}
		{
			JLabel lblNombreDeLa = new JLabel("Nombre de la Madre:");
			lblNombreDeLa.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombreDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNombreDeLa);
		}
		{
			lblMadre = new JLabel("madre bautismo");
			contentPanel.add(lblMadre);
		}
		{
			JLabel lblNombreDelPadrino = new JLabel("Nombre del Padrino:");
			lblNombreDelPadrino.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombreDelPadrino.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNombreDelPadrino);
		}
		{
			lblPadrino = new JLabel("padrino bautismo");
			contentPanel.add(lblPadrino);
		}
		{
			JLabel lblNombreDeLa_1 = new JLabel("Nombre de la Madrina:");
			lblNombreDeLa_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombreDeLa_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNombreDeLa_1);
		}
		{
			lblMadrina = new JLabel("madre bautismo");
			contentPanel.add(lblMadrina);
		}
		{
			JLabel lblNmeroDeOficialia = new JLabel("Número de Oficialia de Registro Civil:");
			lblNmeroDeOficialia.setHorizontalAlignment(SwingConstants.LEFT);
			lblNmeroDeOficialia.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNmeroDeOficialia);
		}
		{
			lblOficialia = new JLabel("oficialia bautismo");
			contentPanel.add(lblOficialia);
		}
		{
			JLabel lblLibroDeLa = new JLabel("Libro de la Oficialia:");
			lblLibroDeLa.setHorizontalAlignment(SwingConstants.LEFT);
			lblLibroDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblLibroDeLa);
		}
		{
			lblLibroOficialia = new JLabel("libro oficialia");
			contentPanel.add(lblLibroOficialia);
		}
		{
			JLabel lblPartidaDeLa = new JLabel("Partida de la Oficialia:");
			lblPartidaDeLa.setHorizontalAlignment(SwingConstants.LEFT);
			lblPartidaDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblPartidaDeLa);
		}
		{
			lblPartidaOficialia = new JLabel("partida oficialia");
			contentPanel.add(lblPartidaOficialia);
		}
		{
			JLabel lblParrocoQueOficializo = new JLabel("Parroco que oficializo el Bautismo:");
			lblParrocoQueOficializo.setHorizontalAlignment(SwingConstants.LEFT);
			lblParrocoQueOficializo.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblParrocoQueOficializo);
		}
		{
			lblParroco = new JLabel("parroco bautismo");
			contentPanel.add(lblParroco);
		}
		{
			JLabel lblNotasMarginales = new JLabel("Notas marginales:");
			lblNotasMarginales.setHorizontalAlignment(SwingConstants.LEFT);
			lblNotasMarginales.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNotasMarginales);
		}
		{
			lblNotas = new JLabel("notas bautismo");
			contentPanel.add(lblNotas);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVistaPreliminar = new JButton("Vista Preliminar");
				btnVistaPreliminar.setEnabled(false);
				btnVistaPreliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							BautismoVistaPreliminar dialog = new BautismoVistaPreliminar();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				btnVistaPreliminar.setActionCommand("OK");
				buttonPane.add(btnVistaPreliminar);
				getRootPane().setDefaultButton(btnVistaPreliminar);
			}
			{
				JButton btnImprimir = new JButton("Imprimir");
				btnImprimir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Imprime el archivo PDF generado con el bautismo
						// elegido
						// cargamos la plantilla a diligenciar
						String ruta_pdf_origen = "recursos/bautismo_preliminar.pdf";
						String ruta_pdf_destino = "recursos/temp.pdf";
						File pdf_destino = new File(ruta_pdf_destino);

						// creamos el archivo
						pdf_destino.getParentFile().mkdir();
						try {
							PdfReader pdfReader = new PdfReader(ruta_pdf_origen);
							FileOutputStream fileStream = new FileOutputStream(pdf_destino);
							PdfStamper stamper = new PdfStamper(pdfReader, fileStream);
							// se obtienen los campos del formulario
							AcroFields pdfForm = stamper.getAcroFields();
							// pdfForm.removeXfa();
							// se llenan los campos del formulario
							// datos de la parroquia
							pdfForm.setField("txtParroquia", "LLLLLLLLLLLLLLLLLLLL");
							pdfForm.setField("txtPresbitero", "FFFFFFFFFFFFFFFFFFF");
							// datos del bautismo
							pdfForm.setField("txtLibro", bautismo.getLibro());
							pdfForm.setField("txtPagina", bautismo.getPagina().toString());
							pdfForm.setField("txtPartida", bautismo.getPartida().toString());
							pdfForm.setField("txtPaterno", bautismo.getApellido_paterno());
							pdfForm.setField("txtMaterno", bautismo.getApellido_materno());
							pdfForm.setField("txtNombre", bautismo.getNombres());
							// // pdfForm.setField("lugar_bautismo",
							// // bautismo.getLugar_bautismo());
							// // pdfForm.setField("fecha_bautismo",
							// // bautismo.mostrarFechaBautismo());
							// // pdfForm.setField("lugar_nacimiento",
							// // bautismo.getLugar_nacimiento());
							// // pdfForm.setField("fecha_nacimiento",
							// // bautismo.mostrarFechaNacimiento());
							// // pdfForm.setField("padre",
							// bautismo.getPadre());
							// // pdfForm.setField("madre",
							// bautismo.getMadre());
							// // pdfForm.setField("padrino",
							// // bautismo.getPadrino());
							// // pdfForm.setField("madrina",
							// // bautismo.getMadrina());
							// // pdfForm.setField("oficialia",
							// // bautismo.getOficialia());
							// // pdfForm.setField("libro_oficialia",
							// // bautismo.getLibro_oficialia());
							// // pdfForm.setField("partida_oficialia",
							// // bautismo.getPartida_oficialia());
							// // pdfForm.setField("parroco",
							// // bautismo.getParroco());
							// // pdfForm.setField("notas",
							// bautismo.getNotas());
							// // // datos del lugar y la fecha actual
							// // pdfForm.setField("lugar",
							// // configuracion.getLugar());
							// // pdfForm.setField("lugar2",
							// // configuracion.getLugar());
							// // Calendar hoy = Calendar.getInstance();
							// // pdfForm.setField("dia",
							// // Integer.toString(hoy.get(Calendar.DATE)));
							// // pdfForm.setField("mes",
							// //
							// FechaBreakDark.mostrarMes(hoy.get(Calendar.MONTH))
							// // .toUpperCase());
							// // pdfForm.setField("gestion",
							// // Integer.toString(hoy.get(Calendar.YEAR) %
							// 10));
							// // cerramos el archivo
							// // stamper.setFormFlattening(true);
							// //
							// stamper.setFullCompression();//.setFreeTextFlattening(true);
							stamper.close();
							fileStream.close();
							pdfReader.close();
							//
							//
							// // imprimimos el archivo
							// // //File fileToPrint = new
							// File(ruta_pdf_destino);
							// // //Desktop.getDesktop().print(fileToPrint);
							// // PrinterJob job = PrinterJob.getPrinterJob();
							// // //job.setPrintService(printer);
							// // PDDocument doc = PDDocument.load(new
							// // File(ruta_pdf_destino));
							// //
							// // doc.silentPrint(job);
							//
							// // doc.print();

							// PDDocument pdf = PDDocument.load(new
							// File(ruta_pdf_origen));

							// PDAcroForm acroForm =
							// pdf.getDocumentCatalog().getAcroForm();
							//
							//
							//
							// acroForm.getField("txtParroquia").setValue("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

							// pdf.save(pdf_destino);
							// pdf.close();
							// pdf = PDDocument.load(pdf_destino);
							// PrinterJob job = PrinterJob.getPrinterJob();
							// job.setPageable(new PDFPageable(pdf));
							// if (job.printDialog()) {
							// System.out.println("IMPRIMIENDO!!!!!!!!!!!");
							// job.print();
							// }
							// pdf.close();

							// File fileToPrint = new
							// File("c:\\Documentos\\fichero.docx");
							Desktop.getDesktop().print(pdf_destino);
							// pdfReader.close();
							// } catch (PrinterException ex) {
							// JOptionPane.showMessageDialog(null, "Error al
							// momento de acceder a la impresora",
							// "ERROR DE IMPRESIÓN", JOptionPane.ERROR_MESSAGE);
							// System.out.println("Error en la Impresora");
							// ex.printStackTrace();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				buttonPane.add(btnImprimir);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected JLabel getLblMadrina() {
		return lblMadrina;
	}

	protected JLabel getLblPaterno() {
		return lblPaterno;
	}

	protected JLabel getLblPagina() {
		return lblPagina;
	}

	protected JLabel getLblMaterno() {
		return lblMaterno;
	}

	protected JLabel getLblLugarNacimiento() {
		return lblLugarNacimiento;
	}

	protected JLabel getLblNombres() {
		return lblNombres;
	}

	protected JLabel getLblPadre() {
		return lblPadre;
	}

	protected JLabel getLblPartidaOficialia() {
		return lblPartidaOficialia;
	}

	protected JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	protected JLabel getLblNotas() {
		return lblNotas;
	}

	protected JLabel getLblParroco() {
		return lblParroco;
	}

	protected JLabel getLblFechaBautismo() {
		return lblFechaBautismo;
	}

	protected JLabel getLblLugarBautismo() {
		return lblLugarBautismo;
	}

	protected JLabel getLblLibro() {
		return lblLibro;
	}

	protected JLabel getLblPartida() {
		return lblPartida;
	}

	protected JLabel getLblOficialia() {
		return lblOficialia;
	}

	protected JLabel getLblPadrino() {
		return lblPadrino;
	}

	protected JLabel getLblMadre() {
		return lblMadre;
	}

	protected JLabel getLblLibroOficialia() {
		return lblLibroOficialia;
	}

	/**
	 * @return El bautismo
	 */
	public Bautismo getBautismo() {
		return bautismo;
	}

	/**
	 * Asigna los valores del bautismo
	 * 
	 * @param bautismo
	 *            El bautismo a asignar
	 */
	public void setBautismo(Bautismo bautismo) {
		this.bautismo = bautismo;
		lblLibro.setText(bautismo.getLibro());
		lblPagina.setText(bautismo.getPagina().toString());
		lblPartida.setText(bautismo.getPartida().toString());
		lblPaterno.setText(bautismo.getApellido_paterno());
		lblMaterno.setText(bautismo.getApellido_materno());
		lblNombres.setText(bautismo.getNombres());
		lblLugarBautismo.setText(bautismo.getLugar_bautismo());
		lblFechaBautismo.setText(bautismo.getFecha_bautismo().toString());
		lblLugarNacimiento.setText(bautismo.getLugar_nacimiento());
		lblFechaNacimiento.setText(bautismo.getFecha_nacimiento().toString());
		lblPadre.setText(bautismo.getPadre());
		lblMadre.setText(bautismo.getMadre());
		lblPadrino.setText(bautismo.getPadrino());
		lblMadrina.setText(bautismo.getMadrina());
		lblOficialia.setText(bautismo.getOficialia());
		lblLibroOficialia.setText(bautismo.getOficialia_libro());
		lblPartidaOficialia.setText(bautismo.getOficialia_partida().toString());
		lblParroco.setText(bautismo.getParroco());
		lblNotas.setText(bautismo.getNotas());
	}
}
