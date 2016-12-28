/**
 * 
 */
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

/**
 * @author BreakDark
 *
 */
@SuppressWarnings("serial")
public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JTable tableBautismo;

	private List<Bautismo> bautismos;

	/**
	 * Creando el marco.
	 */
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panelBautismo = new JPanel();
		tabbedPane.addTab("Bautismo", (Icon) null, panelBautismo, null);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelBautismo = new GroupLayout(panelBautismo);
		gl_panelBautismo.setHorizontalGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBautismo.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 667, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(306, Short.MAX_VALUE)));
		gl_panelBautismo.setVerticalGroup(gl_panelBautismo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBautismo.createSequentialGroup().addGap(71)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE).addContainerGap()));

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
