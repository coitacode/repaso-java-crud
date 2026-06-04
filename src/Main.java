import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BugService bugService = new BugService();
        boolean continuar = true ;

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
                        System.out.println("Ingresa Id");
                        id = scanner.nextLine();

                        if(bugService.existeId(id)){
                            System.out.println("El id que intentas agragar ya existe en la BD");
                            break;
                        }
                        System.out.println("Ingresa Titulo");
                        titulo = scanner.nextLine();
                        System.out.println("Ingresa Descripcion");
                        descripcion = scanner.nextLine();

                        Bug bug = new Bug(id,titulo, descripcion);

                        bugService.crearRegistros(bug);
                        System.out.println(bug);
                        break;
                    case 2:
                        //OPCIÓN 2: VER LISTA DE BUGS
                        bugService.verBugs();
                        break;
                    case 3:
                        System.out.println("Ingresa el id del registro a editar");
                        idEditar = scanner.nextLine();
                        System.out.println("Ingresa el nuevo titulo");
                        String nuevoTitulo = scanner.nextLine();
                        System.out.println("Actualiza la descripcion");
                        String nuevaDescripcion = scanner.nextLine();

                        bugService.editarBug(idEditar, nuevoTitulo, nuevaDescripcion);
                        bugService.verBugs();
                        break;

                    case 4:
                        System.out.println("Ingresa el ID que deseas eliminar");
                        String idEliminar = scanner.nextLine();
                        bugService.eliminarBug(idEliminar);
                        bugService.verBugs();
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
