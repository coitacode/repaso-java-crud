import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
       BugRepository bugService = new BugService();
        boolean continuar = true ;
        String confirmacion = "";

        do {
            System.out.println("Selecciona una opcion del 1 al 5");
            System.out.println("1.- Registrar bug");
            System.out.println("2.- Ver lista de bugs");
            System.out.println("3.- Editar bugs");
            System.out.println("4.- Eliminar bug");
            System.out.println("5.- Salir del menú");
            if(scanner.hasNextInt()){
                String id;
                String titulo;
                String descripcion;
                String idEditar;
                int menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu){
                    case 1:
                        //OPCIÓN 1: INGRESAR
                        System.out.println("Ingresa Id (BUG-XXX)");
                        id = scanner.nextLine();

                        if(! id.startsWith("BUG-")){
                            System.out.println("El formato ID no es correcto");
                            break;
                        }

                        if(bugService.existeId(id)){
                            System.out.println("El id que intentas agragar ya existe en la BD");
                            break;
                        }
                        System.out.println("Ingresa Titulo");
                        titulo = scanner.nextLine();
                        if(titulo.isBlank()){
                            System.out.println("El titulo no debe estar vacio");
                            break;
                        }
                        System.out.println("Ingresa Descripcion");
                        descripcion = scanner.nextLine();
                        if(descripcion.isBlank()){
                            System.out.println("La descripcion no puede estar vacia");
                            break;
                        }

                        Bug bug = new Bug(id,titulo, descripcion);

                        bugService.crearRegistros(bug);
                        System.out.println(bug);
                        break;
                    case 2:
                        //OPCIÓN 2: VER LISTA DE BUGS
                        bugService.verRegistros();
                        break;
                    case 3:

                        System.out.println("Ingresa el id del registro a editar");
                        idEditar = scanner.nextLine();
                        if(!bugService.existeId(idEditar)){
                            System.out.println("Error: El ID ingresado no fue encontrado en el sistema.");
                            break;
                        }
                        System.out.println("Ingresa el nuevo titulo");
                        String nuevoTitulo = scanner.nextLine();
                        System.out.println("Actualiza la descripcion");
                        String nuevaDescripcion = scanner.nextLine();

                        bugService.editarRegistros(idEditar, nuevoTitulo, nuevaDescripcion);
                        bugService.verRegistros();
                        break;

                    case 4:

                        System.out.println("Ingresa el ID que deseas eliminar");
                        String idEliminar = scanner.nextLine();
                        if(!bugService.existeId(idEliminar)){
                            System.out.println("Error: El ID ingresado no fue encontrado en el sistema.");
                            break;
                        }
                        System.out.println("Está seguro que deSea elminar el registro " + idEliminar
                        );
                        System.out.println("escribe (S) para continuar o (N) para cancelar");
                        confirmacion = scanner.nextLine();
                            if(confirmacion.equalsIgnoreCase("S")){
                                bugService.eliminarRegistros(idEliminar);
                            }
                            else{
                                System.out.println("Accion cancelada");
                                break;
                            }

                        System.out.println("Registro eliminado");
                        break;

                    case 5:
                        continuar=false;
                        System.out.println("Hasta pronto");
                        break;

                    default:
                        System.out.println(menu + " no es parte del menú");
                }

            }else{
                System.out.println("Lee bien las instrucciones, solo opciones del 1-5");
               scanner.nextLine();
            }
            }
        while( continuar);
    }
}
