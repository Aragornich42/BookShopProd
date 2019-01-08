package Client;

import java.io.IOException;
import java.sql.*;

class MainClient {

	public static void main(String[] args) throws IOException {

		//new Authorization2();
		final String url = "jdbc:mysql://localhost:3306/labdb?verifyServerCertificate=false&useSSL=false" +
				"&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Moscow";
		final String user = "root";
		final String pass = "1627384950As";

		Connection connection;
		Statement statement;
		ResultSet result;

		String query = "select * from s";

		try {
			connection = DriverManager.getConnection(url, user, pass);

			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
				System.out.println(result.getString(1) + " " + result.getString(2) + " " +
						result.getInt(3) + " " + result.getString(4));
			System.out.println();

			String query2 = "insert into labdb.s values ('S6', 'Nicolas', 50, 'Shakhty')";

			statement.executeUpdate(query2);
			System.out.println("Update DB\n");

			result = statement.executeQuery(query);
			while (result.next())
				System.out.println(result.getString(1) + " " + result.getString(2) + " " +
						result.getInt(3) + " " + result.getString(4));

			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
