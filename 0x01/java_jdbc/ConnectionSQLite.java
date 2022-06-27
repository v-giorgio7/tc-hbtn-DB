import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    static Connection connection;

    public static void main(String[] args) {
        connection = initConnection("org.sqlite.JDBC",
                "jdbc:sqlite:sqlite_database_2022.db");

        try {
            connection.close();
            System.out.println("Connection to database has been closed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection initConnection(String classPackage, String url) {
        try {
            if (connection == null) {
                Class.forName(classPackage);

                String urlConnection = url;
                String databaseName = url.split(":")[1];

                connection = DriverManager.getConnection(urlConnection);
                System.out.println("Connection to " + databaseName + " database has been established");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
