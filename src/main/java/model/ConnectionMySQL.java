package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	public static Connection open_connection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eva_continua2_java", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
