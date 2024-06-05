import java.sql.*;

public class TesteUsandoJdbcUtils {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "12345";
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = JDBCUtils.abrirConexao(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		String insertSql = "INSERT INTO conta (numero_agencia, titular, saldo) VALUES (?, ?, ?)";
		
		int linhasAlteradas = JDBCUtils.realizarInsert(conn, insertSql, 1234,"Daniel Abella",150000);
		
		if(linhasAlteradas > 0) {
			System.out.println("Conta inserida com sucesso!");
		}
	}
}
