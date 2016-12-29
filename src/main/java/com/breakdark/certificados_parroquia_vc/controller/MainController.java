package com.breakdark.certificados_parroquia_vc.controller;

import java.awt.EventQueue;
import org.springframework.context.ApplicationContext;

import com.breakdark.certificados_parroquia_vc.view.FramePrincipal;

/**
 * @author BreakDark
 * @version 1.0
 */
public class MainController {
	private FramePrincipal frameMain = new FramePrincipal();
	private BautismoController bautismoController;

	/**
	 * @param context
	 *            El contexto spring
	 */
	public MainController(ApplicationContext context) {
		this.bautismoController = new BautismoController(context);
	}

	/**
	 * Iniciara la pantalla principal
	 */
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameMain = new FramePrincipal();
					frameMain.setVisible(true);
					frameMain.setBautismos(bautismoController.getBautismoService().obtenerTodosLosBautismos());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
