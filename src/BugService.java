import java.sql.*;

public class BugService implements BugRepository{

    private final String URL = "jdbc:mysql://localhost:3306/bugs_dev";
    private final String USUARIO = "root";
    private final String PASSWORD = "Mysql123";

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);


    }

    public void crearRegistros(Bug bug) {

        String sql = "INSERT INTO bugs(id,titulo,descripcion) VALUES (?,?,?)";

        try (Connection conexion = connection();
             PreparedStatement comando = conexion.prepareStatement(sql)) {
            comando.setString(1, bug.getId());
            comando.setString(2, bug.getTitulo());
            comando.setString(3, bug.getDescripcion());
            int filasAfectadas = comando.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeId(String id) {

        String sql = "SELECT COUNT(*) FROM bugs WHERE id = ?";
        try (Connection conexion = connection();
             PreparedStatement comando = conexion.prepareStatement(sql)) {
            comando.setString(1, id);
            ResultSet resultSet = comando.executeQuery();
            resultSet.next();
            int cuenta = resultSet.getInt(1);
            return cuenta > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // si hay error, asumimos que no existe
        }

    }

    public void verRegistros() {
        String sql = "SELECT * FROM bugs";
        try (
                Connection conexion = connection();        // ← recurso 1
                PreparedStatement comando = conexion.prepareStatement(sql)  // ← recurso 2
        ) {
            // aquí va la lógica
            ResultSet resultSet = comando.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String titulo = resultSet.getString("titulo");
                String descripcion = resultSet.getString("descripcion");
                System.out.println(id + " | " + titulo + " | " + descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editarRegistros (String idEditar, String tituloEditar, String descripcionEditar){
        String sql ="UPDATE bugs SET titulo = ?, descripcion = ? WHERE id = ?";

        try(
                Connection conexion = connection();
                 PreparedStatement comando = conexion.prepareStatement(sql);

                )
        {
            comando.setString(1,tituloEditar);
            comando.setString(2,descripcionEditar);
            comando.setString(3, idEditar);
            comando.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void eliminarRegistros(String id){
        String sql = "DELETE FROM bugs WHERE id =?";
        try(
                Connection conexion = connection();
                PreparedStatement comando = conexion.prepareStatement(sql);
                ){
            comando.setString(1,id);
            comando.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}