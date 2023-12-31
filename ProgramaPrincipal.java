import java.util.Scanner;
public class ProgramaPrincipal {

    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Inicializar / Borrar Lista");
            System.out.println("2. Mostrar Lista (Ascendente)");
            System.out.println("3. Mostrar Lista (Descendente)");
            System.out.println("4. Buscar");
            System.out.println("5. Insertar");
            System.out.println("6. Eliminar");
            System.out.println("7. Modificar");
            System.out.println("8. Créditos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    lista.inicializarLista();
                    break;
                case 2:
                    lista.mostrar(true);
                    break;
                case 3:
                    lista.mostrar(false);
                    break;
                case 4:
                    System.out.print("Cadena a buscar: ");
                    String cadenaBuscar = scanner.nextLine();
                    lista.buscar(cadenaBuscar);
                    break;
                case 5:
                    System.out.print("Nueva cadena a insertar: ");
                    String nuevaCadena = scanner.nextLine();
                    lista.agregarElemento(nuevaCadena);
                    break;
                case 6:
                    System.out.print("Cadena a eliminar: ");
                    String cadenaEliminar = scanner.nextLine();
                    lista.eliminar(cadenaEliminar);
                    break;
                case 7:
                    System.out.print("Cadena a modificar: ");
                    String cadenaModificar = scanner.nextLine();
                    System.out.print("Ingrese nueva cadena: ");
                    String nuevaCadenaModificar = scanner.nextLine();
                    lista.modificar(cadenaModificar, nuevaCadenaModificar);
                    break;
                case 8:
                    System.out.println("Créditos:");
                    System.out.println("Materia: Estructura de datos");
                    System.out.println("Integrantes del equipo:");
                    System.out.println("David Gomez Herrera 22170035");
                    System.out.println("Maria de los Angeles Rivera Villegas 21030227 ");
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 9);
        scanner.close();
    }
}