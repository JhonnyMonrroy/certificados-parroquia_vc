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

	// METODOS GENERADOS

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Bautismo [id=" + id + ", libro=" + libro + ", pagina=" + pagina + ", partida=" + partida
				+ ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", nombres="
				+ nombres + ", lugar_bautismo=" + lugar_bautismo + ", fecha_bautismo=" + fecha_bautismo
				+ ", lugar_nacimiento=" + lugar_nacimiento + ", fecha_nacimiento=" + fecha_nacimiento + ", padre="
				+ padre + ", madre=" + madre + ", padrino=" + padrino + ", madrina=" + madrina + ", oficialia="
				+ oficialia + ", oficialia_libro=" + oficialia_libro + ", oficialia_partida=" + oficialia_partida
				+ ", parroco=" + parroco + ", notas=" + notas + ", ms_access_id=" + ms_access_id + "]";
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
		result = prime * result + ((apellido_materno == null) ? 0 : apellido_materno.hashCode());
		result = prime * result + ((apellido_paterno == null) ? 0 : apellido_paterno.hashCode());
		result = prime * result + ((fecha_bautismo == null) ? 0 : fecha_bautismo.hashCode());
		result = prime * result + ((fecha_nacimiento == null) ? 0 : fecha_nacimiento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + ((lugar_bautismo == null) ? 0 : lugar_bautismo.hashCode());
		result = prime * result + ((lugar_nacimiento == null) ? 0 : lugar_nacimiento.hashCode());
		result = prime * result + ((madre == null) ? 0 : madre.hashCode());
		result = prime * result + ((madrina == null) ? 0 : madrina.hashCode());
		result = prime * result + ((ms_access_id == null) ? 0 : ms_access_id.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
		result = prime * result + ((oficialia == null) ? 0 : oficialia.hashCode());
		result = prime * result + ((oficialia_libro == null) ? 0 : oficialia_libro.hashCode());
		result = prime * result + ((oficialia_partida == null) ? 0 : oficialia_partida.hashCode());
		result = prime * result + ((padre == null) ? 0 : padre.hashCode());
		result = prime * result + ((padrino == null) ? 0 : padrino.hashCode());
		result = prime * result + ((pagina == null) ? 0 : pagina.hashCode());
		result = prime * result + ((parroco == null) ? 0 : parroco.hashCode());
		result = prime * result + ((partida == null) ? 0 : partida.hashCode());
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
		Bautismo other = (Bautismo) obj;
		if (apellido_materno == null) {
			if (other.apellido_materno != null)
				return false;
		} else if (!apellido_materno.equals(other.apellido_materno))
			return false;
		if (apellido_paterno == null) {
			if (other.apellido_paterno != null)
				return false;
		} else if (!apellido_paterno.equals(other.apellido_paterno))
			return false;
		if (fecha_bautismo == null) {
			if (other.fecha_bautismo != null)
				return false;
		} else if (!fecha_bautismo.equals(other.fecha_bautismo))
			return false;
		if (fecha_nacimiento == null) {
			if (other.fecha_nacimiento != null)
				return false;
		} else if (!fecha_nacimiento.equals(other.fecha_nacimiento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (lugar_bautismo == null) {
			if (other.lugar_bautismo != null)
				return false;
		} else if (!lugar_bautismo.equals(other.lugar_bautismo))
			return false;
		if (lugar_nacimiento == null) {
			if (other.lugar_nacimiento != null)
				return false;
		} else if (!lugar_nacimiento.equals(other.lugar_nacimiento))
			return false;
		if (madre == null) {
			if (other.madre != null)
				return false;
		} else if (!madre.equals(other.madre))
			return false;
		if (madrina == null) {
			if (other.madrina != null)
				return false;
		} else if (!madrina.equals(other.madrina))
			return false;
		if (ms_access_id == null) {
			if (other.ms_access_id != null)
				return false;
		} else if (!ms_access_id.equals(other.ms_access_id))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		if (oficialia == null) {
			if (other.oficialia != null)
				return false;
		} else if (!oficialia.equals(other.oficialia))
			return false;
		if (oficialia_libro == null) {
			if (other.oficialia_libro != null)
				return false;
		} else if (!oficialia_libro.equals(other.oficialia_libro))
			return false;
		if (oficialia_partida == null) {
			if (other.oficialia_partida != null)
				return false;
		} else if (!oficialia_partida.equals(other.oficialia_partida))
			return false;
		if (padre == null) {
			if (other.padre != null)
				return false;
		} else if (!padre.equals(other.padre))
			return false;
		if (padrino == null) {
			if (other.padrino != null)
				return false;
		} else if (!padrino.equals(other.padrino))
			return false;
		if (pagina == null) {
			if (other.pagina != null)
				return false;
		} else if (!pagina.equals(other.pagina))
			return false;
		if (parroco == null) {
			if (other.parroco != null)
				return false;
		} else if (!parroco.equals(other.parroco))
			return false;
		if (partida == null) {
			if (other.partida != null)
				return false;
		} else if (!partida.equals(other.partida))
			return false;
		return true;
	}

	/**
	 * @return Un String con el nombre completo del que fue bautizado
	 */
	public String getNombreCompleto() {
		return ((this.apellido_paterno != null) ? this.apellido_paterno + " " : "")
				+ ((this.apellido_materno != null) ? this.apellido_materno + " " : "") + this.nombres;
	}

}
