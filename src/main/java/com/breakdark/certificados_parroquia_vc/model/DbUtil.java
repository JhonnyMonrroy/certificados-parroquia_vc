/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author BreakDark
 * @version 1.0
 */
public class DbUtil {
	private DataSource dataSource;
	
	public void initialize(){
		DataSource dataSource=this.getDataSource();
		try{
			Connection connection=dataSource.getConnection();
			Statement statement = connection.createStatement();
			String SQL="create table BAUTISMO "
					+ "(id,) ";
		}catch(SQLException e){
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
	 * @param dataSource El dataSource a asignar
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
