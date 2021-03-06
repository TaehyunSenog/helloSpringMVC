import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_TEST {
	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost","root", "1231");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SHOW DATABASES");

			if (st.execute("SHOW DATABASES"))
				rs = st.getResultSet();

			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}
		} catch (SQLException SQLex) {
			System.out.println("SQLException: " + SQLex.getMessage());
			System.out.println("SQLState: " + SQLex.getSQLState());
		}
	}
}
