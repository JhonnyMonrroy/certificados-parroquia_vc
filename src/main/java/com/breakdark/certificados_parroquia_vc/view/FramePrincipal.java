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

	private List<Bautismo> bautismos;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 471);
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
				// System.out.println("CLICK CLICK");
				System.out.println("Libro: " + txtLibroBautismo.getText());
				System.out.println(
						"Partida: " + (txtPartidaBautismo.getText().equals("") ? null : txtPartidaBautismo.getText()));
				System.out.println(
						"Nombre: " + (txtNombreBautismo.getText().equals("") ? null : txtNombreBautismo.getText()));
				System.out.println("Tipo fecha: " + comboFechaBautismo.getSelectedIndex());
				System.out.println("Fecha desde: " + dateFechaDesdeBautismo.getDate());
				System.out.println("Fecha hasta: " + dateFechaHastaBautismo.getDate());
				setBautismos(bautismoService.buscarBautismos(
						txtLibroBautismo.getText().equals("") ? txtLibroBautismo.getText() : null,
						(txtPartidaBautismo.getText().equals("") ? null
								: Integer.parseInt(txtPartidaBautismo.getText())),
						(txtNombreBautismo.getText().equals("") ? null : txtNombreBautismo.getText()),
						comboFechaBautismo.getSelectedItem().toString(), dateFechaDesdeBautismo.getDate(),
						dateFechaHastaBautismo.getDate()));
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
		lblHasta.setLabelFor(dateFechaHastaBautismo);

		comboFechaBautismo = new JComboBox();
		comboFechaBautismo.setBackground(UIManager.getColor("Button.background"));
		comboFechaBautismo.setToolTipText("Seleccione por que tipo de fechas desea buscar");
		comboFechaBautismo
				.setModel(new DefaultComboBoxModel(new String[] { "Fecha de Bautismo", "Fecha de Nacimiento" }));
		comboFechaBautismo.setSelectedIndex(0);

		txtLibroBautismo = new JTextField();
		txtLibroBautismo.setColumns(10);

		JLabel lblLibro = new JLabel("Libro:");
		GroupLayout gl_panelBautismo = new GroupLayout(panelBautismo);
		gl_panelBautismo
				.setHorizontalGroup(
						gl_panelBautismo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBautismo.createSequentialGroup().addContainerGap()
										.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelBautismo.createSequentialGroup()
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 695,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_panelBautismo.createSequentialGroup()
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_panelBautismo.createSequentialGroup()
																		.addComponent(lblNombre)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(txtNombreBautismo,
																				GroupLayout.PREFERRED_SIZE, 166,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18))
																.addGroup(gl_panelBautismo.createSequentialGroup()
																		.addGroup(gl_panelBautismo
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(lblLibro)
																				.addComponent(lblPartida))
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addGroup(gl_panelBautismo
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(txtLibroBautismo, 0, 0,
																						Short.MAX_VALUE)
																				.addComponent(txtPartidaBautismo,
																						GroupLayout.DEFAULT_SIZE, 86,
																						Short.MAX_VALUE))
																		.addGap(98)))
														.addGap(3)
														.addGroup(gl_panelBautismo
																.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(gl_panelBautismo.createSequentialGroup()
																		.addGroup(gl_panelBautismo
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(lblDesde)
																				.addComponent(lblHasta))
																		.addGap(18)
																		.addGroup(gl_panelBautismo
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(dateFechaHastaBautismo,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(dateFechaDesdeBautismo,
																						GroupLayout.DEFAULT_SIZE, 111,
																						Short.MAX_VALUE)))
																.addComponent(comboFechaBautismo, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(18)
														.addComponent(btnBuscarBautismo, GroupLayout.DEFAULT_SIZE, 116,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnNuevoBautismo).addGap(20)))));
		gl_panelBautismo
				.setVerticalGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING).addGroup(gl_panelBautismo
						.createSequentialGroup().addContainerGap().addGroup(gl_panelBautismo
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(gl_panelBautismo.createSequentialGroup()
										.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
												.addComponent(comboFechaBautismo, GroupLayout.PREFERRED_SIZE, 21,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtLibroBautismo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblLibro))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblPartida).addComponent(txtPartidaBautismo,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelBautismo.createSequentialGroup().addGap(10)
																.addComponent(lblDesde))
														.addComponent(dateFechaDesdeBautismo, Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtNombreBautismo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre).addComponent(lblHasta))
												.addComponent(dateFechaHastaBautismo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18))
								.addGroup(gl_panelBautismo.createSequentialGroup()
										.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnBuscarBautismo, GroupLayout.DEFAULT_SIZE, 76,
														Short.MAX_VALUE)
												.addComponent(btnNuevoBautismo, GroupLayout.DEFAULT_SIZE, 78,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE).addContainerGap()));

		tableBautismo = new JTable();
		scrollPane.setViewportView(tableBautismo);
		tableBautismo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nombre Completo", "Fecha de Bautismo", "Fecha de Nacimiento" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableBautismo.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableBautismo.getColumnModel().getColumn(0).setMinWidth(13);
		tableBautismo.getColumnModel().getColumn(1).setPreferredWidth(356);
		tableBautismo.getColumnModel().getColumn(2).setPreferredWidth(121);
		tableBautismo.getColumnModel().getColumn(3).setPreferredWidth(122);
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
	 * @param bautismos
	 *            Los bautismos a asignar Tambien asigna a la tablaBautismo la
	 *            lista de bautismos
	 */
	public void setBautismos(List<Bautismo> bautismos) {
		this.bautismos = bautismos;
		DefaultTableModel tableModel = (DefaultTableModel) this.tableBautismo.getModel();
		tableModel.setRowCount(0);// limpiamos la tabla
		if (bautismos != null && bautismos.size() > 0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");

			// tableModel.getDataVector().removeAllElements();
			for (Bautismo bautismo : this.bautismos) {
				Object[] dataBautismo = { bautismo.getId(), bautismo.getNombreCompleto(),
						dateFormat.format(bautismo.getFecha_bautismo()),
						dateFormat.format(bautismo.getFecha_nacimiento()) };
				tableModel.addRow(dataBautismo);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron Bautismos", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Funci&oacute;n que valida los controles para activar el boton Buscar
	 */
	private void validarBotonBuscarBautismo() {
		// System.out.println(this.dateChooserFechaDesdeBautismo.getDate());
		// System.out.println(this.dateChooserFechaHastaBautismo.getDate());
		this.btnBuscarBautismo.setEnabled(!this.txtPartidaBautismo.getText().equals("")
				|| !this.txtNombreBautismo.getText().equals("")
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
