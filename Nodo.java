
class Nodo {
    String valor;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}

class ListaDoblementeEnlazada {
    private Nodo primero;
    private Nodo ultimo;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
    }

    public void insertar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            Nodo actual = primero;
            while (actual != null && valor.compareToIgnoreCase(actual.valor) >= 0) {
                actual = actual.siguiente;
            }

            if (actual == null) {
                nuevoNodo.anterior = ultimo;
                ultimo.siguiente = nuevoNodo;
                ultimo = nuevoNodo;
            } else if (actual.anterior == null) {
                nuevoNodo.siguiente = primero;
                primero.anterior = nuevoNodo;
                primero = nuevoNodo;
            } else {
                nuevoNodo.siguiente = actual;
                nuevoNodo.anterior = actual.anterior;
                actual.anterior.siguiente = nuevoNodo;
                actual.anterior = nuevoNodo;
            }
        }
    }

    public void eliminar(String valor) {
        Nodo actual = primero;
        while (actual != null && !actual.valor.equalsIgnoreCase(valor)) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (actual == primero) {
                primero = actual.siguiente;
                if (primero != null) {
                    primero.anterior = null;
                }
            } else if (actual == ultimo) {
                ultimo = actual.anterior;
                ultimo.siguiente = null;
            } else {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }
        }
    }

    public boolean buscar(String valor) {
        Nodo actual = primero;
        while (actual != null && valor.compareToIgnoreCase(actual.valor) >= 0) {
            if (actual.valor.equalsIgnoreCase(valor)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrarAscendente() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }

    public void mostrarDescendente() {
        Nodo actual = ultimo;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.anterior;
        }
    }
}