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
