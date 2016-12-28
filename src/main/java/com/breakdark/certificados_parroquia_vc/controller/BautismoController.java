package com.breakdark.certificados_parroquia_vc.controller;

import org.springframework.context.ApplicationContext;

import com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService;

/**
 * @author BreakDark
 * @version 1.0
 */
class BautismoController {

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

}
