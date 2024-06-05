import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TesteInsertMySQL {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "12345";

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            String insertSql = "INSERT INTO conta (numero_agencia, titular, saldo) VALUES (?, ?, ?)";

            PreparedStatement pstm = connection.prepareStatement(insertSql);
            pstm.setInt(1, 1); // Exemplo de número de agência
            pstm.setString(2, "Daniel Abella"); // Exemplo de titular
            pstm.setDouble(3, 150000); // Exemplo de saldo

            int linhasInseridas = pstm.executeUpdate(); //Dispara o SQL INSERT no SGBD!
            if (linhasInseridas > 0) {
                System.out.println("Um novo registro foi inserido com sucesso!");
            }
            
            pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
