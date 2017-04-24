/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

/**
 * Clase para crear las tablas por defecto
 * 
 * @author BreakDark
 * @version 1.0
 */
public class DbUtil {
	private DataSource dataSource;

	public void initialize() {
		DataSource dataSource = this.getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			// creando la tabla bautismo
			String SQL = "CREATE TABLE IF NOT EXISTS bautismo (";
			SQL += "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , ";
			SQL += "libro TEXT NOT NULL , ";
			SQL += "pagina INTEGER NOT NULL , ";
			SQL += "partida INTEGER NOT NULL , ";
			SQL += "apellido_paterno TEXT NOT NULL , ";
			SQL += "apellido_materno TEXT NOT NULL , ";
			SQL += "nombres TEXT, ";
			SQL += "lugar_bautismo TEXT, ";
			SQL += "fecha_bautismo DATETIME, ";
			SQL += "lugar_nacimiento TEXT, ";
			SQL += "fecha_nacimiento DATETIME, ";
			SQL += "padre TEXT, ";
			SQL += "madre TEXT, ";
			SQL += "padrino TEXT, ";
			SQL += "madrina TEXT, ";
			SQL += "oficialia TEXT, ";
			SQL += "oficialia_libro TEXT, ";
			SQL += "oficialia_partida INTEGER, ";
			SQL += "parroco TEXT, ";
			SQL += "notas TEXT, ";
			SQL += "ms_access_id INTEGER)";
			statement.executeUpdate(SQL);

			// creando la tabla configuracion
			SQL = "CREATE TABLE IF NOT EXISTS configuracion (";
			SQL += "id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , ";
			SQL += "nombre_parroquia TEXT NOT NULL , ";
			SQL += "nombre_parroco TEXT NOT NULL , ";
			SQL += "fecha DATETIME, ";
			SQL += "oficial BOOLEAN); ";
			statement.executeUpdate(SQL);
			statement.close();

			// insertando el primer registro de configuracion
			SQL = "INSERT INTO configuracion(nombre_parroquia, nombre_parroco, fecha, oficial)";
			SQL += "SELECT ?, ?, ?, ? ";
			SQL += "WHERE NOT EXISTS(SELECT id from configuracion);";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, "Nuestra Señora Virgen de Copacabana");
			ps.setString(2, "P. Frolian Mamani Ch.");
			ps.setDate(3, new java.sql.Date(new Date().getTime())); // fecha
																	// y
																	// hora
			ps.setBoolean(4, true);
			// ps.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
			ps.executeUpdate();
			ps.close();
			// statement.executeUpdate(SQL);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODOS GET Y SET
	/**
	 * @return El dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            El dataSource a asignar
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
