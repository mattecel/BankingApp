package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

	private static Connection conn = null;

	// defining a method to get the connection
	public static Connection getConnection() {

		try {

			// Checking if a connection exists and creating one if it doesn't
			if (conn == null) {

				// "hot fix" to ensure that driver loads correcting on application start
				Class.forName("org.postgresql.Driver");

				Properties props = new Properties();

				InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connections.properties");

				props.load(input);

				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");

				conn = DriverManager.getConnection(url, username, password);
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
