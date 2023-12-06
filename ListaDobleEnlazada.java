import java.util.Scanner;

class Nodo {
    public String dato;
    public Nodo anterior;
    public Nodo siguiente;

    public Nodo(String dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

public class ListaDobleEnlazada {
    Scanner scanner = new Scanner(System.in);
    Nodo p;
    Nodo f;

    public ListaDobleEnlazada() {
        p = null;
        f = null;
    }

    public void inicializarLista() {
        vaciarLista();
        System.out.println("Lista inicializada y borrada.");
    }

    public void vaciarLista() {
        Nodo actual = p;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = null;
            actual.anterior = null;
            actual = siguiente;
        }
        p = null;
        f = null;
    }

    public void agregarElemento(String dato) {
        Nodo nuevo = new Nodo(dato);

        if (p == null) {
            p = nuevo;
            f = nuevo;
        } else {
            Nodo actual;
            if (insertar(dato)) {
                actual = p;
                while (actual != null && dato.compareToIgnoreCase(actual.dato) > 0) {
                    actual = actual.siguiente;
                }
            } else {
                actual = f;
                while (actual != null && dato.compareToIgnoreCase(actual.dato) < 0) {
                    actual = actual.anterior;
                }
                if (actual != null) {
                    actual = actual.siguiente;
                }
            }

            if (actual == p) {
                nuevo.siguiente = p;
                p.anterior = nuevo;
                p = nuevo;
            } else if (actual == null) {
                nuevo.anterior = f;
                f.siguiente = nuevo;
                f = nuevo;
            } else {
                nuevo.siguiente = actual;
                nuevo.anterior = actual.anterior;
                actual.anterior.siguiente = nuevo;
                actual.anterior = nuevo;
            }
        }
    }

    private boolean insertar(String dato) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        int mitadAbecedario = abecedario.length() / 2;
        int posicionDato = abecedario.indexOf(Character.toLowerCase(dato.charAt(0)));¿
        return posicionDato < mitadAbecedario;
    }
    public void mostrar(boolean ascendente) {
        if (p == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (ascendente) {
            Nodo actual = p;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        } else {
            Nodo actual = f;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.anterior;
            }
        }
    }

    public Nodo buscar(String dato) {
        if (p == null) {
            System.out.println("La lista está vacía.");
            return null;
        }

        Nodo actual;
        char primerCaracter = Character.toUpperCase(dato.charAt(0));

        if (primerCaracter <= 'M') {
            actual = p;
            while (actual != null && dato.compareToIgnoreCase(actual.dato) > 0) {
                actual = actual.siguiente;
            }
        } else {
            actual = f;
            while (actual != null && dato.compareToIgnoreCase(actual.dato) < 0) {
                actual = actual.anterior;
            }
        }

        if (actual != null && dato.equalsIgnoreCase(actual.dato)) {
            System.out.println("Dato encontrado: " + actual.dato);
            return actual;
        }
        System.out.println("Dato no encontrado.");
        return null;
    }

    public boolean eliminar(String dato) {
        Nodo nodoAEliminar = buscar(dato);
        if (nodoAEliminar == null) {
            System.out.println("No se encontró el dato para eliminar.");
            return false;
        }

        if (nodoAEliminar == p) {
            p = nodoAEliminar.siguiente;
            if (p != null) {
                p.anterior = null;
            }
        } else if (nodoAEliminar == f) {
            f = nodoAEliminar.anterior;
            if (f != null) {
                f.siguiente = null;
            }
        } else {
            nodoAEliminar.anterior.siguiente = nodoAEliminar.siguiente;
            if (nodoAEliminar.siguiente != null) {
                nodoAEliminar.siguiente.anterior = nodoAEliminar.anterior;
            }
        }
        System.out.println("Dato eliminado con éxito.");
        return true;
    }

    public void modificar(String datoAntiguo, String datoNuevo) {
        if (p == null) {
            System.out.println("La lista está vacía. No se puede realizar la modificación.");
            return;
        }

        eliminar(datoAntiguo);
        agregarElemento(datoNuevo);
        System.out.println("Cadena : \"" + datoAntiguo + "\" ha sido modificada por \"" + datoNuevo + "\".");
    }
}