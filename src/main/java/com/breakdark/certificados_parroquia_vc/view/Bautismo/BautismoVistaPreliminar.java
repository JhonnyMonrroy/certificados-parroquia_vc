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
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

/**
 * @author BreakDark
 *
 */
public class BautismoVistaPreliminar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("certBautismo_fondo.jpg"));
			g.drawImage(imagenFondo.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};

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
	 */
	public BautismoVistaPreliminar() {
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 400, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblFsdfgsdfs = new JLabel("fsdfgsdfs");
			contentPanel.add(lblFsdfgsdfs);
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
