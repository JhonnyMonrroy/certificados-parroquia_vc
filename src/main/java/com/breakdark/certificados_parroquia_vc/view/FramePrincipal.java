package com.breakdark.certificados_parroquia_vc.view;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo;
import com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService;
import com.breakdark.certificados_parroquia_vc.view.Bautismo.BautismoEditar;

import javax.swing.JScrollPane;

import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author BreakDark
 *
 */
public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableBautismo;

	// para acceder a los datos
	private BautismoService bautismoService;

	private JTextField txtPartidaBautismo;
	private JTextField txtNombreBautismo;
	private JDateChooser dateFechaDesdeBautismo;
	private JDateChooser dateFechaHastaBautismo;
	private JButton btnBuscarBautismo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboFechaBautismo;
	private JTextField txtLibroBautismo;

	/**
	 * Creando el marco.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelBautismo = new JPanel();
		tabbedPane.addTab("Bautismo", (Icon) null, panelBautismo, null);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNuevoBautismo = new JButton("Nuevo Bautismo");
		btnNuevoBautismo.setEnabled(false);
		btnNuevoBautismo.addActionListener(new ActionListener() {
			/**
			 * Al hacer click al boton Nuevo bautismo
			 * 
			 * @param e
			 *            El manejador del evento
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					BautismoEditar dialog = new BautismoEditar();
					dialog.setTitle("Nuevo Bautismo");
					// Bautismo bautismo = new Bautismo();
					// bautismo.setNombres("JUAN JOSE");
					// bautismo.setApellido_paterno("PEREZ");
					// bautismo.setApellido_materno("QUIROGA");
					// dialog.setBautismo(bautismo);
					dialog.setBautismo(new Bautismo());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNuevoBautismo.setToolTipText("Adiciona un nuevo Bautismo");

		txtPartidaBautismo = new JTextField();
		txtPartidaBautismo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validarBotonBuscarBautismo();
			}
		});
		// textFieldPartidaBautismo.setToolTipText("Numero de Partida de
		// Bautismo");
		txtPartidaBautismo.setColumns(10);

		JLabel lblPartida = new JLabel("Partida:");
		lblPartida.setLabelFor(txtPartidaBautismo);
		// lblPartida.setLabelFor(textFieldPartidaBautismo);

		JLabel lblNombre = new JLabel("Nombre:");

		txtNombreBautismo = new JTextField();
		txtNombreBautismo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validarBotonBuscarBautismo();
			}
		});
		// lblNombre.setLabelFor(textFieldNombreBautismo);
		// textFieldNombreBautismo.setToolTipText("Utilice un solo Nombre o un
		// Apellido");
		txtNombreBautismo.setColumns(10);

		btnBuscarBautismo = new JButton("Buscar");
		btnBuscarBautismo.setEnabled(false);
		btnBuscarBautismo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarBautismos();
			}
		});
		btnBuscarBautismo.setToolTipText("Buscar Bautismos");

		JLabel lblDesde = new JLabel("Desde:");

		JLabel lblHasta = new JLabel("Hasta:");

		dateFechaDesdeBautismo = new JDateChooser();
		dateFechaDesdeBautismo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				validarBotonBuscarBautismo();
			}
		});
		// lblDesde.setLabelFor(dateChooserFechaDesdeBautismo);

		dateFechaHastaBautismo = new JDateChooser();
		dateFechaHastaBautismo.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				validarBotonBuscarBautismo();
			}
		});
		// lblHasta.setLabelFor(dateFechaHastaBautismo);

		comboFechaBautismo = new JComboBox();
		comboFechaBautismo.setBackground(UIManager.getColor("Button.background"));
		comboFechaBautismo.setToolTipText("Seleccione por que tipo de fechas desea buscar");
		comboFechaBautismo
				.setModel(new DefaultComboBoxModel(new String[] { "Fecha de Bautismo", "Fecha de Nacimiento" }));
		comboFechaBautismo.setSelectedIndex(0);

		txtLibroBautismo = new JTextField();
		txtLibroBautismo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validarBotonBuscarBautismo();
			}
		});
		txtLibroBautismo.setColumns(10);

		JLabel lblLibro = new JLabel("Libro:");

		JButton btnLimpiarFormularioBautismo = new JButton("Limpiar formulario");
		btnLimpiarFormularioBautismo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limpia los datos de la busqueda del bautismo
				txtLibroBautismo.setText("");
				txtPartidaBautismo.setText("");
				txtNombreBautismo.setText("");
				comboFechaBautismo.setSelectedIndex(0);
				dateFechaDesdeBautismo.setDate(null);
				dateFechaHastaBautismo.setDate(null);
				// desactivamos el boton buscar
				btnBuscarBautismo.setEnabled(false);
			}
		});
		GroupLayout gl_panelBautismo = new GroupLayout(panelBautismo);
		gl_panelBautismo
				.setHorizontalGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelBautismo
								.createSequentialGroup().addGap(
										12)
								.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 704,
												Short.MAX_VALUE)
										.addGroup(gl_panelBautismo.createSequentialGroup().addGroup(gl_panelBautismo
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panelBautismo.createSequentialGroup()
														.addComponent(lblNombre)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtNombreBautismo, GroupLayout.PREFERRED_SIZE,
																166, GroupLayout.PREFERRED_SIZE)
														.addGap(18))
												.addGroup(gl_panelBautismo.createSequentialGroup()
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblLibro).addComponent(lblPartida))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(txtLibroBautismo, 0, 0, Short.MAX_VALUE)
																.addComponent(txtPartidaBautismo,
																		GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
														.addGap(98)))
												.addGap(3)
												.addGroup(gl_panelBautismo
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(gl_panelBautismo.createSequentialGroup()
																.addGroup(gl_panelBautismo
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblHasta).addComponent(lblDesde))
																.addGap(18)
																.addGroup(gl_panelBautismo
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(dateFechaHastaBautismo,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(dateFechaDesdeBautismo,
																				GroupLayout.PREFERRED_SIZE, 111,
																				GroupLayout.PREFERRED_SIZE)))
														.addComponent(comboFechaBautismo, 0, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
														.addComponent(btnLimpiarFormularioBautismo)
														.addComponent(btnBuscarBautismo, GroupLayout.DEFAULT_SIZE, 139,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNuevoBautismo)))
								.addGap(20)));
		gl_panelBautismo.setVerticalGroup(
				gl_panelBautismo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelBautismo
						.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBautismo
										.createSequentialGroup()
										.addComponent(btnBuscarBautismo, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelBautismo.createSequentialGroup()
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
														.addComponent(comboFechaBautismo, GroupLayout.PREFERRED_SIZE,
																21, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtLibroBautismo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblLibro))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
														.addGroup(
																gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblPartida).addComponent(
																				txtPartidaBautismo,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panelBautismo.createSequentialGroup()
																		.addGap(10).addComponent(lblDesde))
																.addComponent(dateFechaDesdeBautismo,
																		Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
														.addComponent(dateFechaHastaBautismo,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.BASELINE)
																.addComponent(txtNombreBautismo,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblNombre).addComponent(lblHasta)))
												.addGap(12))
										.addGroup(gl_panelBautismo.createSequentialGroup().addGroup(gl_panelBautismo
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnLimpiarFormularioBautismo, GroupLayout.PREFERRED_SIZE,
														20, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNuevoBautismo, GroupLayout.DEFAULT_SIZE, 79,
														Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE).addContainerGap()));

		tableBautismo = new JTable();
		tableBautismo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println(e.getClickCount());
				// al doble click
				if (e.getClickCount() == 2) {
					// JOptionPane.showMessageDialog(null,
					// tableBautismo.getSelectedRow());
					// System.out.println(tableBautismo.getValueAt(tableBautismo.getSelectedRow(),
					// 0));
					Bautismo bautismo = bautismoService.obtenerBautismoDeId(
							Integer.parseInt(tableBautismo.getValueAt(tableBautismo.getSelectedRow(), 0).toString()));
					System.out.println(bautismo);
				}
			}
		});
		scrollPane.setViewportView(tableBautismo);
		tableBautismo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Libro", "Partida", "Nombre Completo", "Fecha Bautismo", "Fecha Nacimiento" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableBautismo.getColumnModel().getColumn(0).setPreferredWidth(23);
		tableBautismo.getColumnModel().getColumn(0).setMinWidth(13);
		tableBautismo.getColumnModel().getColumn(1).setPreferredWidth(51);
		tableBautismo.getColumnModel().getColumn(2).setPreferredWidth(55);
		tableBautismo.getColumnModel().getColumn(3).setPreferredWidth(328);
		tableBautismo.getColumnModel().getColumn(4).setPreferredWidth(111);
		tableBautismo.getColumnModel().getColumn(5).setPreferredWidth(111);
		panelBautismo.setLayout(gl_panelBautismo);

		JPanel panelPrimeraComunion = new JPanel();
		tabbedPane.addTab("Primera Comunión", null, panelPrimeraComunion, null);
		tabbedPane.setEnabledAt(1, false);

		JPanel panelConfirmacion = new JPanel();
		tabbedPane.addTab("Confirmación", null, panelConfirmacion, null);
		GroupLayout gl_panelConfirmacion = new GroupLayout(panelConfirmacion);
		gl_panelConfirmacion.setHorizontalGroup(
				gl_panelConfirmacion.createParallelGroup(Alignment.LEADING).addGap(0, 695, Short.MAX_VALUE));
		gl_panelConfirmacion.setVerticalGroup(
				gl_panelConfirmacion.createParallelGroup(Alignment.LEADING).addGap(0, 396, Short.MAX_VALUE));
		panelConfirmacion.setLayout(gl_panelConfirmacion);
		tabbedPane.setEnabledAt(2, false);

		JPanel panelMatrimonio = new JPanel();
		tabbedPane.addTab("Matrimonio", null, panelMatrimonio, null);
		tabbedPane.setEnabledAt(3, false);
	}

	/**
	 * Metodo que reliza el proceso de buscar el bautismo
	 */
	protected void buscarBautismos() {
		// validamos los campos antes de enviarlos a la busqueda
		String libro = txtLibroBautismo.getText().equals("") ? null : txtLibroBautismo.getText();
		Integer partida = txtPartidaBautismo.getText().equals("") ? null
				: Integer.parseInt(txtPartidaBautismo.getText());
		String indicio_nombre = txtNombreBautismo.getText().equals("") ? null : txtNombreBautismo.getText();
		String tipo_fecha = comboFechaBautismo.getSelectedIndex() == 0 ? "bautismo" : "nacimiento";
		Date fecha_desde = dateFechaDesdeBautismo.getDate();
		Date fecha_hasta = dateFechaHastaBautismo.getDate();

		List<Bautismo> bautismos = bautismoService.buscarBautismos(libro, partida, indicio_nombre, tipo_fecha,
				fecha_desde, fecha_hasta);

		DefaultTableModel tableModel = (DefaultTableModel) tableBautismo.getModel();
		tableModel.setRowCount(0);// limpiamos la tabla
		// tableModel.getDataVector().removeAllElements();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (bautismos != null && bautismos.size() > 0) {
			for (Bautismo bautismo : bautismos) {
				Object[] dataBautismo = { bautismo.getId(), bautismo.getLibro(), bautismo.getPartida(),
						bautismo.getNombreCompleto(), dateFormat.format(bautismo.getFecha_bautismo()),
						dateFormat.format(bautismo.getFecha_nacimiento()) };
				tableModel.addRow(dataBautismo);
			}
		} else {
			String datos_busqueda = "";
			if (libro != null) {
				datos_busqueda += "Libro: " + libro + "\n";
			}
			if (partida != null) {
				datos_busqueda += "Partida: " + partida + "\n";
			}
			if (indicio_nombre != null) {
				datos_busqueda += "Indicio de nombre: " + indicio_nombre + "\n";
			}
			if (fecha_desde != null && fecha_hasta != null) {
				datos_busqueda += "Tipo de fecha: " + tipo_fecha + "\n";
				datos_busqueda += "Fecha fecha: " + dateFormat.format(fecha_desde) + "\n";
				datos_busqueda += "Fecha hasta: " + dateFormat.format(fecha_hasta) + "\n";
			}
			JOptionPane.showMessageDialog(null, "No se encontraron Bautismos para los datos:\n" + datos_busqueda,
					"Información", JOptionPane.INFORMATION_MESSAGE);
		}

		// setBautismos(bautismoService.buscarBautismos(libro, partida,
		// indicio_nombre, tipo_fecha, fecha_desde,
		// fecha_hasta));
	}

	/**
	 * Funci&oacute;n que valida los controles para activar el boton Buscar
	 */
	private void validarBotonBuscarBautismo() {
		// System.out.println(this.dateChooserFechaDesdeBautismo.getDate());
		// System.out.println(this.dateChooserFechaHastaBautismo.getDate());
		this.btnBuscarBautismo.setEnabled(!this.txtLibroBautismo.getText().equals("")
				|| !this.txtPartidaBautismo.getText().equals("") || !this.txtNombreBautismo.getText().equals("")
				|| (this.dateFechaDesdeBautismo.getDate() != null && this.dateFechaHastaBautismo.getDate() != null));
	}

	protected JTextField getTextFieldPartidaBautismo() {
		return txtPartidaBautismo;
	}

	protected JTextField getTextFieldNombreBautismo() {
		return txtNombreBautismo;
	}

	protected JDateChooser getDateChooserFechaDesde() {
		return dateFechaDesdeBautismo;
	}

	protected JDateChooser getDateChooserFechaHasta() {
		return dateFechaHastaBautismo;
	}

	protected JButton getBtnBuscarBautismo() {
		return btnBuscarBautismo;
	}

	@SuppressWarnings("rawtypes")
	protected JComboBox getComboBoxFecha() {
		return comboFechaBautismo;
	}

	/**
	 * @return El bautismoService
	 */
	public BautismoService getBautismoService() {
		return bautismoService;
	}

	/**
	 * @param bautismoService
	 *            El bautismoService a asignar
	 */
	public void setBautismoService(BautismoService bautismoService) {
		this.bautismoService = bautismoService;
	}
}
