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
import javax.swing.JTextField;

import com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

/**
 * @author BreakDark
 *
 */
public class BautismoEditar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLibro;
	private JTextField textFieldApellidoPaterno;
	private JTextField textFieldApellidoMaterno;
	private JTextField textFieldNombres;
	private JTextField textFieldLugarBautismo;
	private JTextField textFieldLugarNacimiento;
	private JTextField textFieldPadre;
	private JTextField textFieldMadre;
	private JTextField textFieldPadrino;
	private JTextField textFieldMadrina;
	private JTextField textFieldOficialia;
	private JTextField textFieldOficialiaLibro;
	private JTextField textFieldParroco;
	private JDateChooser dateChooserFechaBautismo;
	private JDateChooser dateChooserFechaNacimiento;
	private JTextArea textAreaNota;
	private JLabel lblLibro;
	private JLabel lblPgina;
	private JLabel lblPartida;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblNombres;
	private JLabel lblLugarDeBautismo;
	private JLabel lblFechaDeBautismo;
	private JLabel lblLugarDeNacimiento;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblNombreDelPadre;
	private JLabel lblNombreDeLa;
	private JLabel lblNombreDelPadrino;
	private JLabel lblNombreDeLa_1;
	private JLabel lblNmeroDeLa;
	private JLabel lblLibroDeLa;
	private JLabel lblPartidaDeLa;
	private JLabel lblNombreDelParroco;
	private JLabel lblNotas;

	private Bautismo bautismo;
	private JSpinner spinnerPagina;
	private JSpinner spinnerPartida;
	private JSpinner spinnerOficialiaPartida;

	private boolean edicion;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			BautismoEditar dialog = new BautismoEditar();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param edicion Un valor booleando para indicar si esta en el modo edicion
	 */
	public BautismoEditar(boolean edicion) {
		this.edicion=edicion;
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Editar Bautismo");
		setBounds(100, 100, 463, 640);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(19, 2, 5, 0));
		{
			lblLibro = new JLabel("Libro:");
			lblLibro.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblLibro);
		}
		{
			textFieldLibro = new JTextField();
			if(this.edicion)
				textFieldLibro.setEditable(false);
			lblLibro.setLabelFor(textFieldLibro);
			contentPanel.add(textFieldLibro);
			textFieldLibro.setColumns(10);
		}
		{
			lblPgina = new JLabel("Página:");
			lblPgina.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPgina);
		}
		{
			spinnerPagina = new JSpinner();
			if(this.edicion)
				spinnerPagina.setEnabled(false);
			contentPanel.add(spinnerPagina);
		}
		{
			lblPartida = new JLabel("Partida:");
			lblPartida.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPartida);
		}
		{
			spinnerPartida = new JSpinner();
			if(this.edicion)
				spinnerPartida.setEnabled(false);
			contentPanel.add(spinnerPartida);
		}
		{
			lblApellidoPaterno = new JLabel("Apellido Paterno:");
			lblApellidoPaterno.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblApellidoPaterno);
		}
		{
			textFieldApellidoPaterno = new JTextField();
			contentPanel.add(textFieldApellidoPaterno);
			textFieldApellidoPaterno.setColumns(10);
		}
		{
			lblApellidoMaterno = new JLabel("Apellido Materno:");
			lblApellidoMaterno.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblApellidoMaterno);
		}
		{
			textFieldApellidoMaterno = new JTextField();
			contentPanel.add(textFieldApellidoMaterno);
			textFieldApellidoMaterno.setColumns(10);
		}
		{
			lblNombres = new JLabel("Nombres:");
			lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombres);
		}
		{
			textFieldNombres = new JTextField();
			contentPanel.add(textFieldNombres);
			textFieldNombres.setColumns(10);
		}
		{
			lblLugarDeBautismo = new JLabel("Lugar de Bautismo:");
			lblLugarDeBautismo.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblLugarDeBautismo);
		}
		{
			textFieldLugarBautismo = new JTextField();
			contentPanel.add(textFieldLugarBautismo);
			textFieldLugarBautismo.setColumns(10);
		}
		{
			lblFechaDeBautismo = new JLabel("Fecha de Bautismo:");
			lblFechaDeBautismo.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblFechaDeBautismo);
		}
		{
			dateChooserFechaBautismo = new JDateChooser();
			contentPanel.add(dateChooserFechaBautismo);
		}
		{
			lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento:");
			lblLugarDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblLugarDeNacimiento);
		}
		{
			textFieldLugarNacimiento = new JTextField();
			contentPanel.add(textFieldLugarNacimiento);
			textFieldLugarNacimiento.setColumns(10);
		}
		{
			lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblFechaDeNacimiento);
		}
		{
			dateChooserFechaNacimiento = new JDateChooser();
			contentPanel.add(dateChooserFechaNacimiento);
		}
		{
			lblNombreDelPadre = new JLabel("Nombre del Padre:");
			lblNombreDelPadre.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombreDelPadre);
		}
		{
			textFieldPadre = new JTextField();
			contentPanel.add(textFieldPadre);
			textFieldPadre.setColumns(10);
		}
		{
			lblNombreDeLa = new JLabel("Nombre de la Madre:");
			lblNombreDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombreDeLa);
		}
		{
			textFieldMadre = new JTextField();
			contentPanel.add(textFieldMadre);
			textFieldMadre.setColumns(10);
		}
		{
			lblNombreDelPadrino = new JLabel("Nombre del Padrino:");
			lblNombreDelPadrino.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombreDelPadrino);
		}
		{
			textFieldPadrino = new JTextField();
			contentPanel.add(textFieldPadrino);
			textFieldPadrino.setColumns(10);
		}
		{
			lblNombreDeLa_1 = new JLabel("Nombre de la Madrina:");
			lblNombreDeLa_1.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombreDeLa_1);
		}
		{
			textFieldMadrina = new JTextField();
			contentPanel.add(textFieldMadrina);
			textFieldMadrina.setColumns(10);
		}
		{
			lblNmeroDeLa = new JLabel("Oficialia de Registro Civil:");
			lblNmeroDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNmeroDeLa);
		}
		{
			textFieldOficialia = new JTextField();
			if(this.edicion)
				textFieldOficialia.setEditable(false);
			contentPanel.add(textFieldOficialia);
			textFieldOficialia.setColumns(10);
		}
		{
			lblLibroDeLa = new JLabel("Libro de la Oficialia:");
			lblLibroDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblLibroDeLa);
		}
		{
			textFieldOficialiaLibro = new JTextField();
			if(this.edicion)
				textFieldOficialiaLibro.setEditable(false);
			contentPanel.add(textFieldOficialiaLibro);
			textFieldOficialiaLibro.setColumns(10);
		}
		{
			lblPartidaDeLa = new JLabel("Partida de la Oficialia:");
			lblPartidaDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblPartidaDeLa);
		}
		{
			spinnerOficialiaPartida = new JSpinner();
			if(this.edicion)
				spinnerOficialiaPartida.setEnabled(false);
			contentPanel.add(spinnerOficialiaPartida);
		}
		{
			lblNombreDelParroco = new JLabel("Nombre del Parroco:");
			lblNombreDelParroco.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNombreDelParroco);
		}
		{
			textFieldParroco = new JTextField();
			contentPanel.add(textFieldParroco);
			textFieldParroco.setColumns(10);
		}
		{
			lblNotas = new JLabel("Notas marginales:");
			lblNotas.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNotas);
		}
		{
			textAreaNota = new JTextArea();
			textAreaNota.setWrapStyleWord(true);
			textAreaNota.setRows(3);
			contentPanel.add(textAreaNota);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardarButton = new JButton("Guardar");
				guardarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// guardamos los datos
						int dialogResult = JOptionPane.showConfirmDialog(null, "Esta seguro de guardar esta información?",null, JOptionPane.YES_NO_OPTION);
						if(dialogResult == JOptionPane.YES_OPTION){
							actualizarBautismo();
							// TODO Generar servicio de actualizarBautismo
							System.out.println(bautismo);
						}
					}
				});
				guardarButton.setActionCommand("OK");
				buttonPane.add(guardarButton);
				getRootPane().setDefaultButton(guardarButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
	}

	/**
	 * @return El bautismo
	 */
	public Bautismo getBautismo() {
		return bautismo;
	}

	/**
	 * @param bautismo
	 *            El bautismo a asignar
	 */
	public void setBautismo(Bautismo bautismo) {
		this.bautismo = bautismo;
		this.dateChooserFechaBautismo.setDate(bautismo.getFecha_bautismo());
		this.dateChooserFechaNacimiento.setDate(bautismo.getFecha_nacimiento());
		this.textAreaNota.setText(bautismo.getNotas());
		this.textFieldApellidoMaterno.setText(bautismo.getApellido_materno());
		this.textFieldApellidoPaterno.setText(bautismo.getApellido_paterno());
		this.textFieldLibro.setText(bautismo.getLibro());
		this.textFieldLugarBautismo.setText(bautismo.getLugar_bautismo());
		this.textFieldLugarNacimiento.setText(bautismo.getLugar_nacimiento());
		this.textFieldMadre.setText(bautismo.getMadre());
		this.textFieldMadrina.setText(bautismo.getMadrina());
		this.textFieldNombres.setText(bautismo.getNombres());
		this.textFieldOficialia.setText(bautismo.getOficialia());
		this.textFieldOficialiaLibro.setText(bautismo.getOficialia_libro());
		this.spinnerOficialiaPartida.setValue(bautismo.getOficialia_partida());
		this.textFieldPadre.setText(bautismo.getPadre());
		this.textFieldPadrino.setText(bautismo.getPadrino());
		this.spinnerPagina.setValue(bautismo.getPagina());
		this.textFieldParroco.setText(bautismo.getParroco());
		this.spinnerPartida.setValue(bautismo.getPartida());
	}

	/**
	 * Metodo que actualiza al bautisno con los datos actualmente cargados
	 */
	private void actualizarBautismo() {
		bautismo.setApellido_materno(this.textFieldApellidoMaterno.getText());
		bautismo.setApellido_paterno(this.textFieldApellidoPaterno.getText());
		bautismo.setFecha_bautismo(this.dateChooserFechaBautismo.getDate());
		bautismo.setFecha_nacimiento(this.dateChooserFechaNacimiento.getDate());
		bautismo.setLibro(this.textFieldLibro.getText());
		bautismo.setLugar_bautismo(this.textFieldLugarBautismo.getText());
		bautismo.setLugar_nacimiento(this.textFieldLugarNacimiento.getText());
		bautismo.setMadre(this.textFieldMadre.getText());
		bautismo.setMadrina(this.textFieldMadrina.getText());
		bautismo.setNombres(this.textFieldNombres.getText());
		bautismo.setNotas(this.textAreaNota.getText());
		bautismo.setOficialia(this.textFieldOficialia.getText());
		bautismo.setOficialia_libro(this.textFieldOficialiaLibro.getText());
		bautismo.setOficialia_partida((Integer)this.spinnerOficialiaPartida.getValue());
		bautismo.setPadre(this.textFieldPadre.getText());
		bautismo.setPadrino(this.textFieldPadrino.getText());
		bautismo.setPagina((Integer)this.spinnerPagina.getValue());
		bautismo.setParroco(this.textFieldParroco.getText());
		bautismo.setPartida((Integer)this.spinnerPartida.getValue());
	}

}
