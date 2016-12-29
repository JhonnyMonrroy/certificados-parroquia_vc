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

import javax.swing.JScrollPane;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

/**
 * @author BreakDark
 *
 */
@SuppressWarnings("serial")
public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTable tableBautismo;

	private List<Bautismo> bautismos;
	private JTextField textFieldPartida;
	private JTextField textFieldNombre;

	/**
	 * Creando el marco.
	 */
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
		btnNuevoBautismo.setToolTipText("Adiciona un nuevo Bautismo");

		textFieldPartida = new JTextField();
		textFieldPartida.setToolTipText("Número de Partida de Bautismo");
		textFieldPartida.setColumns(10);

		JLabel lblPartida = new JLabel("Partida:");
		lblPartida.setLabelFor(textFieldPartida);

		JLabel lblNombre = new JLabel("Nombre:");

		textFieldNombre = new JTextField();
		lblNombre.setLabelFor(textFieldNombre);
		textFieldNombre.setToolTipText("Utilice un solo Nombre o un Apellido");
		textFieldNombre.setColumns(10);

		JButton btnBuscarBautismo = new JButton("Buscar");
		btnBuscarBautismo.setEnabled(false);
		btnBuscarBautismo.setToolTipText("Buscar Bautismos");

		JLabel lblDesde = new JLabel("Desde:");

		JLabel lblHasta = new JLabel("Hasta:");
		
		JDateChooser dateChooserFechaDesde = new JDateChooser();
		lblDesde.setLabelFor(dateChooserFechaDesde);
		
		JDateChooser dateChooserFechaHasta = new JDateChooser();
		lblHasta.setLabelFor(dateChooserFechaHasta);
		
		JComboBox comboBoxFecha = new JComboBox();
		comboBoxFecha.setBackground(UIManager.getColor("Button.background"));
		comboBoxFecha.setToolTipText("Seleccione por que tipo de fechas desea buscar");
		comboBoxFecha.setModel(new DefaultComboBoxModel(new String[] {"Fecha de Bautismo", "Fecha de Nacimiento"}));
		comboBoxFecha.setSelectedIndex(0);
		GroupLayout gl_panelBautismo = new GroupLayout(panelBautismo);
		gl_panelBautismo.setHorizontalGroup(
			gl_panelBautismo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBautismo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBautismo.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelBautismo.createSequentialGroup()
							.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelBautismo.createSequentialGroup()
									.addComponent(lblPartida)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldPartida, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(98))
								.addGroup(gl_panelBautismo.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(18)))
							.addGap(3)
							.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelBautismo.createSequentialGroup()
									.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDesde)
										.addComponent(lblHasta))
									.addGap(18)
									.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateChooserFechaHasta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooserFechaDesde, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
								.addComponent(comboBoxFecha, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(btnBuscarBautismo, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNuevoBautismo)
							.addGap(20))))
		);
		gl_panelBautismo.setVerticalGroup(
			gl_panelBautismo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBautismo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelBautismo.createSequentialGroup()
							.addComponent(comboBoxFecha, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPartida)
									.addComponent(textFieldPartida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBautismo.createSequentialGroup()
										.addGap(10)
										.addComponent(lblDesde))
									.addComponent(dateChooserFechaDesde, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelBautismo.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNombre)
									.addComponent(lblHasta))
								.addComponent(dateChooserFechaHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_panelBautismo.createSequentialGroup()
							.addGroup(gl_panelBautismo.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscarBautismo, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addComponent(btnNuevoBautismo, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addContainerGap())
		);

		tableBautismo = new JTable();
		scrollPane.setViewportView(tableBautismo);
		tableBautismo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nombre Completo", "Fecha de Bautismo", "Fecha de Nacimiento" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, Object.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
		DefaultTableModel tableModel = (DefaultTableModel) this.tableBautismo.getModel();
		for (Bautismo bautismo : this.bautismos) {
			Object[] dataBautismo = { bautismo.getId(), bautismo.getNombreCompleto(),
					dateFormat.format(bautismo.getFecha_bautismo()),
					dateFormat.format(bautismo.getFecha_nacimiento()) };
			tableModel.addRow(dataBautismo);
		}
	}
}
