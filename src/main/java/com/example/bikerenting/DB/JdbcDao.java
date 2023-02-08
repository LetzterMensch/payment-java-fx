package com.example.bikerenting.DB;
import java.sql.*;

public class JdbcDao {
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_CARD_QUERY = "INSERT INTO cards (cardNumber, cardHolderName, expirationDate, securityCode) VALUES (?, ?, ?, ?)";

    private static final String INSERT_TRANSACTION_QUERY = "INSERT INTO transactions (amount, method, createAt, transactionDescription) VALUES (?, ?, ?, ?,?)";

    private static final String SELECT_CARD_QUERY = "SELECT cardId FROM cards WHERE cardNumber LIKE %?%";
    public void insertCardRecord(String cardNumber, String cardHolderName, Date expirationDate, String securityCode) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARD_QUERY)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, cardHolderName);
            preparedStatement.setDate(3, expirationDate);
            preparedStatement.setString(4, securityCode);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    public String getCardID(String cardNumber) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARD_QUERY)) {
            preparedStatement.setString(1, cardNumber);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            return preparedStatement.getResultSet().toString();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return "CARD DOES NOT EXIT.";
    }
    public void insertTransactionRecord(Integer amount, String method, Time createAt, String transactionDescription, String cardId) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION_QUERY)) {
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, method);
            preparedStatement.setTime(3, createAt);
            preparedStatement.setString(4, transactionDescription);
            preparedStatement.setString(5, cardId);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
