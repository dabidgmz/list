import java.util.Scanner;  // Import the Scanner class

public class ProgramaPrincipal {

    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
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
                    System.out.println("Lista inicializada y borrada.");
                    break;
                case 2:
                    lista.mostrarListaAscendente();
                    break;
                case 3:
                    lista.mostrarListaDescendente();
                    break;
                case 4:
                    System.out.print("Cadena a buscar: ");
                    String cadenaBuscar = scanner.nextLine();
                    lista.buscar(cadenaBuscar);
                    break;
                case 5:
                    System.out.print("Nueva cadena a insertar: ");
                    String nuevaCadena = scanner.nextLine();
                    lista.insertar(nuevaCadena);
                    System.out.println("Cadena insertada correctamente.");
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
                    System.out.println("Materia: Estructuras de Datos");
                    System.out.println("Integrantes del equipo:");
                    System.out.println("Maria de los Angeles Rivera Villegas - 2103227");
                    System.out.println("David Gomez Herrera - 22170035");
                    break;
                case 9:
                    System.out.println("Fin:)");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 9);

        scanner.close();
    }
}