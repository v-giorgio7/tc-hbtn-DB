import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    private Connection connection;

    @Override
    public Connection connect(String urlConexao) {
        try {
            connection = DriverManager.getConnection(urlConexao);

            System.out.println("Connection to database has been established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        String sqlStatement = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(80) NOT NULL," +
                "idade INTEGER NOT NULL," +
                "cpf VARCHAR(11) NOT NULL," +
                "rg VARCHAR(11) NOT NULL)";

        try {
            connection = this.connect(urlConexao);
            Statement stm = connection.createStatement();
            stm.executeUpdate(sqlStatement);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        String sqlStatement = "INSERT INTO clientes (nome, idade, cpf, rg) VALUES (?,?,?,?)";

        try {
            connection = this.connect(url_conexao);
            PreparedStatement pstm = connection.prepareStatement(sqlStatement);
            pstm.setString(1, cliente.getNome());
            pstm.setInt(2, cliente.getIdade());
            pstm.setString(3, cliente.getCpf());
            pstm.setString(4, cliente.getRg());
            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String sqlStatement = "SELECT * FROM clientes";
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            connection = this.connect(urlConexao);
            Statement stm = connection.createStatement();

            ResultSet rs = stm.executeQuery(sqlStatement);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));

                listaClientes.add(cliente);
            }

            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.getNome() + " - " + cliente.getIdade());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sqlStatement = "UPDATE clientes SET nome=?, idade=? WHERE id=?";

        try {
            connection = this.connect(urlConexao);
            PreparedStatement pstm = connection.prepareStatement(sqlStatement);
            pstm.setString(1, name);
            pstm.setInt(2, idade);
            pstm.setInt(3, id);
            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sqlStatement = "DELETE FROM clientes WHERE id=?";

        try {
            connection = this.connect(urlConexao);
            PreparedStatement pstm = connection.prepareStatement(sqlStatement);
            pstm.setInt(1, id);
            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
