/**
 * 
 */
package com.breakdark.certificados_parroquia_vc;

import java.awt.EventQueue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.breakdark.certificados_parroquia_vc.view.FramePrincipal;

/**
 * @author BreakDark
 * @version 1.0
 */
public class Main {
	/**
	 * Lanzamos la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("resource")
			public void run() {
				try {
					ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
					FramePrincipal framePrincipal = (FramePrincipal) context.getBean("framePrincipal");
					framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
