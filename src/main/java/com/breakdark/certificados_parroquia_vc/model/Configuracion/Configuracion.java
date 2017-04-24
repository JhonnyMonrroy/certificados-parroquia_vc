package com.breakdark.certificados_parroquia_vc.model.Configuracion;

import java.util.Date;

/**
 * Configuracion.java. Modelo para la tabla configuracion
 * 
 * @author BreakDark (Jhonny Monrroy)
 * @version 1.0 22 abr. 2017
 */
public class Configuracion {
	private Integer id;
	private String nombre_parroquia;
	private String nombre_parroco;
	private Date fecha; // fecha de configuracion
	private Boolean oficial; // configuracion oficial

	// METODOS GET SET
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
	 * @return El nombre_parroquia
	 */
	public String getNombre_parroquia() {
		return nombre_parroquia;
	}

	/**
	 * @param nombre_parroquia
	 *            El nombre_parroquia a asignar
	 */
	public void setNombre_parroquia(String nombre_parroquia) {
		this.nombre_parroquia = nombre_parroquia;
	}

	/**
	 * @return El nombre_parroco
	 */
	public String getNombre_parroco() {
		return nombre_parroco;
	}

	/**
	 * @param nombre_parroco
	 *            El nombre_parroco a asignar
	 */
	public void setNombre_parroco(String nombre_parroco) {
		this.nombre_parroco = nombre_parroco;
	}

	/**
	 * @return El fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            El fecha a asignar
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return El oficial
	 */
	public Boolean getOficial() {
		return oficial;
	}

	/**
	 * @param oficial
	 *            El oficial a asignar
	 */
	public void setOficial(Boolean oficial) {
		this.oficial = oficial;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre_parroco == null) ? 0 : nombre_parroco.hashCode());
		result = prime * result + ((nombre_parroquia == null) ? 0 : nombre_parroquia.hashCode());
		result = prime * result + ((oficial == null) ? 0 : oficial.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracion other = (Configuracion) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre_parroco == null) {
			if (other.nombre_parroco != null)
				return false;
		} else if (!nombre_parroco.equals(other.nombre_parroco))
			return false;
		if (nombre_parroquia == null) {
			if (other.nombre_parroquia != null)
				return false;
		} else if (!nombre_parroquia.equals(other.nombre_parroquia))
			return false;
		if (oficial == null) {
			if (other.oficial != null)
				return false;
		} else if (!oficial.equals(other.oficial))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", nombre_parroquia=" + nombre_parroquia + ", nombre_parroco="
				+ nombre_parroco + ", fecha=" + fecha + ", oficial=" + oficial + "]";
	}
}
