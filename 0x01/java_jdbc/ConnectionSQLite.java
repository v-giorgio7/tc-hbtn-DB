

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    static Connection connection;

    public static void main(String[] args) {
        connection = initConnection();

        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection initConnection() {
        try {
            if (connection == null) {
                String urlConnection = "jdbc:sqlite:sqlite_database_2022.db";

                connection = DriverManager.getConnection(urlConnection);
                System.out.println("Connection to SQLite Database has been established");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
