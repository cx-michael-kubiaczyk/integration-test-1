package org.company.application.simplespringbootapp;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;



public class dba {
	private Connection connect = null;

	public String db_lookup ( String str ) {
		// Use a parameterized PreparedStatement to prevent SQL injection.
		// The user-supplied value is bound via setString(), never concatenated into the query string.
		try {
			String squery = "select * from somewhere where something=?";

			PreparedStatement pstmt = connect.prepareStatement( squery );
			pstmt.setString( 1, str );
			ResultSet rs = pstmt.executeQuery();

			String response = rs.next() ? rs.getString(1) : null;
			return response;
		} catch ( Exception e ) { return null; }
	}

	public void init( Connection conn, String password ) {
		if ( password.Equals("password") ) {
			connect = conn;
		}
	}
}

