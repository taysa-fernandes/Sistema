package Sistema.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionFactory {
	public static final String PACKAGE_TO_SCAN = "sistema";
	public static final String DATABASE_NAME = "sistema";
	public static final String databaseURL = "jdbc:postgresql://localhost:5432/sistema";
	public static final String usuario = "postgres";
	public static final String senha = "taysa";
	public static final String driverName = "org.postgresql.Driver";

	public static Connection conexao() throws SQLException, ClassNotFoundException {
		Class.forName(driverName);
		try {
			DriverManager.deregisterDriver(new Driver() {
			});
			return (Connection) DriverManager.getConnection(databaseURL, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Erro ao conectar!");
		}
		return null;
	}
}
