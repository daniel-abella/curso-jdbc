import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	public static Connection abrirConexao(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void encerrarConexao(Connection conn) throws SQLException {
		conn.close();
	}

	public static ResultSet realizarSelect(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		stmt.close();
		return rs;
	}

	public static int realizarInsert(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		int rowsAffected = stmt.executeUpdate(query);
		return rowsAffected;
	}

	public static int realizarDelete(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		int rowsAffected = stmt.executeUpdate(query);
		return rowsAffected;
	}

	public static int realizarUpdate(Connection conn, String query) throws SQLException {
		Statement stmt = conn.createStatement();
		int rowsAffected = stmt.executeUpdate(query);
		return rowsAffected;
	}

	public static int realizarInsert(Connection conn, String query, Object... params) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(query);
		setParameters(pstmt, params);
		int rowsAffected = pstmt.executeUpdate();
		return rowsAffected;
	}

	private static void setParameters(PreparedStatement pstmt, Object... params) throws SQLException {
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
	}
}