import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteListagemMySQL {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "12345";

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

            Statement statement = connection.createStatement();
            String sql = "SELECT numero_conta, numero_agencia, titular, saldo FROM conta";          
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int numeroConta = resultSet.getInt("numero_conta");
                int numeroAgencia = resultSet.getInt("numero_agencia");
                String titular = resultSet.getString("titular");
                double saldo = resultSet.getDouble("saldo");

                System.out.println("Conta: " + numeroConta + " da agência " + numeroAgencia + " do titular " + titular + " com saldo " + saldo);
            }
			
            resultSet.close();
            statement.close();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}