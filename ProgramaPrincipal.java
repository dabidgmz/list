import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
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

                int opcion;
                while (true) {
                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Ingrese un número válido.");
                        scanner.nextLine();
                    }
                }

                switch (opcion) {
                    case 1:
                        lista = new ListaDoblementeEnlazada();
                        System.out.println("Lista reiniciada y vacía.");
                        break;
                    case 2:
                        if (!lista.estaVacia()) {
                            lista.mostrarAscendente();
                        } else {
                            System.out.println("La lista está vacía.");
                        }
                        break;
                    case 3:
                        if (!lista.estaVacia()) {
                            lista.mostrarDescendente();
                        } else {
                            System.out.println("La lista está vacía.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese la cadena a buscar: ");
                        String cadenaBuscar = scanner.nextLine();
                        if (lista.buscar(cadenaBuscar)) {
                            System.out.println("La cadena fue encontrada en la lista.");
                        } else {
                            System.out.println("La cadena no fue encontrada en la lista.");
                        }
                        break;
                    case 5:
                        System.out.print("Ingrese la cadena a insertar: ");
                        String cadenaInsertar = scanner.nextLine();
                        if (!lista.buscar(cadenaInsertar)) {
                            lista.insertar(cadenaInsertar);
                            System.out.println("Cadena insertada con éxito.");
                        } else {
                            System.out.println("La cadena ya existe en la lista.");
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese la cadena a eliminar: ");
                        String cadenaEliminar = scanner.nextLine();
                        if (lista.buscar(cadenaEliminar)) {
                            lista.eliminar(cadenaEliminar);
                            System.out.println("Cadena eliminada con éxito.");
                        } else {
                            System.out.println("La cadena no existe en la lista.");
                        }
                        break;
                    case 7:
                        System.out.print("Ingrese la cadena a modificar: ");
                        String cadenaModificar = scanner.nextLine();
                        System.out.print("Ingrese la nueva cadena: ");
                        String nuevaCadena = scanner.nextLine();
                        if (lista.buscar(cadenaModificar)) {
                            lista.eliminar(cadenaModificar);
                            lista.insertar(nuevaCadena);
                            System.out.println("Cadena modificada con éxito.");
                        } else {
                            System.out.println("La cadena no se pudo localizar en la lista.");
                        }
                        break;
                    case 8:
                        System.out.println("Créditos:");
                        System.out.println("Materia: Estructuras de Datos");
                        System.out.println("Integrantes del equipo:");
                        System.out.println("Mria de los angeles Rivera Villegas - 2030227");
                        System.out.println("David Gomez Herrera - 22170035");
                        break;
                    case 9:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}