package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.Date;

/**
 * Clase Bautismo
 * 
 * @author BreakDark
 * @version 1.0
 */
public class Bautismo {
	private Integer id;
	private String libro;
	private Integer pagina;
	private Integer partida;
	private String apellido_paterno;
	private String apellido_materno;
	private String nombres;
	private String lugar_bautismo;
	private Date fecha_bautismo;
	private String lugar_nacimiento;
	private Date fecha_nacimiento;
	private String padre;
	private String madre;
	private String padrino;
	private String madrina;
	// datos de la oficialia de registro civil
	private String oficialia;
	private String oficialia_libro;
	private Integer oficialia_partida;
	// datos del parroco que oficializo el bautismo
	/** el parroco que oficializo el bautizmo */
	private String parroco;
	private String notas; // notas marginales
	// para la migracion
	private Integer ms_access_id;

	// METODOS GET Y SET
	/**
	 * @return El id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            El id a asignar
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return El libro
	 */
	public String getLibro() {
		return libro;
	}

	/**
	 * @param libro
	 *            El libro a asignar
	 */
	public void setLibro(String libro) {
		this.libro = libro;
	}

	/**
	 * @return La pagina
	 */
	public Integer getPagina() {
		return pagina;
	}

	/**
	 * @param pagina
	 *            La pagina a asignar
	 */
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return La partida
	 */
	public Integer getPartida() {
		return partida;
	}

	/**
	 * @param partida
	 *            La partida a asignar
	 */
	public void setPartida(Integer partida) {
		this.partida = partida;
	}

	/**
	 * @return El apellido_paterno
	 */
	public String getApellido_paterno() {
		return apellido_paterno;
	}

	/**
	 * @param apellido_paterno
	 *            El apellido_paterno a asignar
	 */
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	/**
	 * @return El apellido_materno
	 */
	public String getApellido_materno() {
		return apellido_materno;
	}

	/**
	 * @param apellido_materno
	 *            El apellido_materno a asignar
	 */
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	/**
	 * @return Los nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            Los nombres a asignar
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return El lugar_bautismo
	 */
	public String getLugar_bautismo() {
		return lugar_bautismo;
	}

	/**
	 * @param lugar_bautismo
	 *            El lugar_bautismo a asignar
	 */
	public void setLugar_bautismo(String lugar_bautismo) {
		this.lugar_bautismo = lugar_bautismo;
	}

	/**
	 * @return La fecha_bautismo
	 */
	public Date getFecha_bautismo() {
		return fecha_bautismo;
	}

	/**
	 * @param fecha_bautismo
	 *            La fecha_bautismo a asignar
	 */
	public void setFecha_bautismo(Date fecha_bautismo) {
		this.fecha_bautismo = fecha_bautismo;
	}

	/**
	 * @return El lugar_nacimiento
	 */
	public String getLugar_nacimiento() {
		return lugar_nacimiento;
	}

	/**
	 * @param lugar_nacimiento
	 *            El lugar_nacimiento a asignar
	 */
	public void setLugar_nacimiento(String lugar_nacimiento) {
		this.lugar_nacimiento = lugar_nacimiento;
	}

	/**
	 * @return La fecha_nacimiento
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	/**
	 * @param fecha_nacimiento
	 *            La fecha_nacimiento a asignar
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
	 * @return El padre
	 */
	public String getPadre() {
		return padre;
	}

	/**
	 * @param padre
	 *            El padre a asignar
	 */
	public void setPadre(String padre) {
		this.padre = padre;
	}

	/**
	 * @return La madre
	 */
	public String getMadre() {
		return madre;
	}

	/**
	 * @param madre
	 *            La madre a asignar
	 */
	public void setMadre(String madre) {
		this.madre = madre;
	}

	/**
	 * @return El padrino
	 */
	public String getPadrino() {
		return padrino;
	}

	/**
	 * @param padrino
	 *            El padrino a asignar
	 */
	public void setPadrino(String padrino) {
		this.padrino = padrino;
	}

	/**
	 * @return La madrina
	 */
	public String getMadrina() {
		return madrina;
	}

	/**
	 * @param madrina
	 *            La madrina a asignar
	 */
	public void setMadrina(String madrina) {
		this.madrina = madrina;
	}

	/**
	 * @return La oficialia
	 */
	public String getOficialia() {
		return oficialia;
	}

	/**
	 * @param oficialia
	 *            La oficialia a asignar
	 */
	public void setOficialia(String oficialia) {
		this.oficialia = oficialia;
	}

	/**
	 * @return El oficialia_libro
	 */
	public String getOficialia_libro() {
		return oficialia_libro;
	}

	/**
	 * @param oficialia_libro
	 *            El oficialia_libro a asignar
	 */
	public void setOficialia_libro(String oficialia_libro) {
		this.oficialia_libro = oficialia_libro;
	}

	/**
	 * @return El oficialia_partida
	 */
	public Integer getOficialia_partida() {
		return oficialia_partida;
	}

	/**
	 * @param oficialia_partida
	 *            El oficialia_partida a asignar
	 */
	public void setOficialia_partida(Integer oficialia_partida) {
		this.oficialia_partida = oficialia_partida;
	}

	/**
	 * @return El parroco
	 */
	public String getParroco() {
		return parroco;
	}

	/**
	 * @param parroco
	 *            El parroco a asignar
	 */
	public void setParroco(String parroco) {
		this.parroco = parroco;
	}

	/**
	 * @return Las notas
	 */
	public String getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            Las notas a asignar
	 */
	public void setNotas(String notas) {
		this.notas = notas;
	}

	/**
	 * @return El ms_access_id
	 */
	public Integer getMs_access_id() {
		return ms_access_id;
	}

	/**
	 * @param ms_access_id
	 *            El ms_access_id a asignar
	 */
	public void setMs_access_id(Integer ms_access_id) {
		this.ms_access_id = ms_access_id;
	}
}
