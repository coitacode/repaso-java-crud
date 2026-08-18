public interface BugRepository {

    void crearRegistros(Bug bug);
    void verRegistros();
    boolean existeId(String id);
    void editarRegistros(String idEditar, String tituloEditar, String descripcionEditar );
    void eliminarRegistros(String id);

}
