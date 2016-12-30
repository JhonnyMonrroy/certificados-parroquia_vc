package com.breakdark.certificados_parroquia_vc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo;
import com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService;

/**
 * @author BreakDark
 * @version 1.0
 */
public class BautismoController {

	private BautismoService bautismoService;

	/**
	 * @param context
	 *            El contexto spring
	 */
	public BautismoController(ApplicationContext context) {
		this.bautismoService = (BautismoService) context.getBean("bautismoService");
	}

	/**
	 * @return El bautismoService
	 */
	public BautismoService getBautismoService() {
		return bautismoService;
	}

	/**
	 * @param object
	 * @param string
	 * @param string2
	 * @param selectedIndex
	 * @param date
	 * @param date2
	 * @return
	 */
	public List<Bautismo> buscarBautismo(Object object, String string, String string2, int selectedIndex, Date date,
			Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

}
