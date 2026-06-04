//LIBRERÍA ARRAYLIST
import java.util.ArrayList;
//CLASE BUGSERVICE
public class BugService {
    //CREACION DE MI OBJETO BUGS DONDE GUADARE CADA REGISTO
    ArrayList <Bug> bugs = new ArrayList<>();
    //METODO PARA CRER LOS REGISTROS
    public void crearRegistros(Bug bug){
                   bugs.add(bug);
            System.out.println("Registro creado exitosamente");
    }
    //METODO PARA LISTAR LOS BUGS REGISTRADOS
    public void verBugs(){
        for(Bug bug: bugs ){
            System.out.println(bug);
        }
    }
    //METODO PARA EDITAR ALGUN BUG YA REGISTRADO
    public void editarBug (String idEditar, String nuevoTitulo, String nuevaDescripcion){
        for(Bug bug: bugs){
            if(bug.getId().equals(idEditar)){
                bug.setTitulo(nuevoTitulo);
                bug.setDescripcion(nuevaDescripcion);

                break;
            }

        }
    }
    //METODO PARA ELIMINAR REGISTROS BUGS
    public void eliminarBug(String idEliminar){
        for(Bug bug: bugs){
        if(bug.getId().equals(idEliminar)){
            bugs.remove(bug);
            break;
        }
    }
    }
    public boolean existeId(String id){
        for(Bug bug: bugs){
            if(bug.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
