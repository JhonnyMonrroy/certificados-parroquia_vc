/**
 * 
 */
package com.breakdark.certificados_parroquia_vc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.breakdark.certificados_parroquia_vc.controller.MainController;

/**
 * @author BreakDark
 * @version 1.0
 */
public class Main {
	/**
	 * Lanzamos la aplicacion
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config_development.xml");
		if (args.length > 0 && args[0].equals("enviroment=production")) {
			context = new ClassPathXmlApplicationContext("spring-config_production.xml");
		}
		MainController mainController = new MainController(context);
		mainController.iniciar();
	}

}
