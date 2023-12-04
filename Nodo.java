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

class ListaDobleEnlazada {
    private Nodo P; 
    private Nodo F; 

    public ListaDobleEnlazada() {
        P = null;
        F = null;
    }

    public void inicializarLista() {
        P = null;
        F = null;
        System.gc(); 
    }

    public void mostrarAscendente() {
        mostrarLista(1);
    }

    public void mostrarDescendente() {
        mostrarLista(2);
    }

    private void mostrarLista(int orden) {
        if (P == null) {
            System.out.println("La lista está vacía");
            return;
        }

        System.out.println("Soy la lista:");
        if (orden == 1) {
            Nodo actual = P;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        } else if (orden == 2) {
            Nodo actual = F;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.anterior;
            }
        } else {
            System.out.println("Opción no válida");
        }
    }

    public boolean buscar(String datoBuscar) {
        if (P == null) {
            System.out.println(" lista vacía");
            return false;
        }

        Nodo actual;

        if (datoBuscar.compareToIgnoreCase(P.dato) >= 0 && datoBuscar.compareToIgnoreCase(F.dato) <= 0) {
            actual = P;
            while (actual != null) {
                if (actual.dato.equalsIgnoreCase(datoBuscar)) {
                    System.out.println("cadena   : " + datoBuscar + "\" fue encontrada en la lista.");
                    return true;
                }
                actual = actual.siguiente;
            }
        } else if (datoBuscar.compareToIgnoreCase(F.dato) >= 0 && datoBuscar.compareToIgnoreCase(P.dato) <= 0) {
            actual = F;
            while (actual != null) {
                if (actual.dato.equalsIgnoreCase(datoBuscar)) {
                    System.out.println("cadena   :  \"" + datoBuscar + "\" fue encontrada en la lista.");
                    return true;
                }
                actual = actual.anterior;
            }
        } else {
            System.out.println(" cadena   : \"" + datoBuscar + "\" no se encuentra en la lista.");
            return false;
        }

        System.out.println(" cadena :  \"" + datoBuscar + "\" no se encuentra en la lista.");
        return false;
    }

    public boolean eliminar(String cadenaEliminar) {
        if (P == null) {
            System.out.println("La lista está vacía");
            return false;
        }

        Nodo actual = P;
        while (actual != null) {
            if (actual.dato.equalsIgnoreCase(cadenaEliminar)) {
                if (actual.anterior == null) {
                    if (actual.siguiente != null) {
                        actual.siguiente.anterior = null;
                        P = actual.siguiente;
                    } else {
                        P = null;
                        F = null;
                    }
                } else if (actual.siguiente == null) {
                    actual.anterior.siguiente = null;
                    F = actual.anterior;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }

                System.out.println("cadena \"" + cadenaEliminar + "\" ha sido eliminada.");
                return true;
            }
            actual = actual.siguiente;
        }

        System.out.println(" cadena  : \"" + cadenaEliminar + "\" no se encuentra en la lista. No se puede eliminar.");
        return false;
    }

    public void insertar(String nuevaCadena) {
        Nodo nuevoNodo = new Nodo(nuevaCadena);

        if (P == null) {
            P = nuevoNodo;
            F = nuevoNodo;
        } else {
            Nodo actual = P;
            while (actual != null) {
                if (nuevaCadena.compareToIgnoreCase(actual.dato) < 0) {
                    if (actual.anterior == null) {
                        nuevoNodo.siguiente = actual;
                        actual.anterior = nuevoNodo;
                        P = nuevoNodo;
                    } else {
                        nuevoNodo.anterior = actual.anterior;
                        nuevoNodo.siguiente = actual;
                        actual.anterior.siguiente = nuevoNodo;
                        actual.anterior = nuevoNodo;
                    }
                    return;
                } else if (nuevaCadena.compareToIgnoreCase(actual.dato) > 0) {
                    if (actual.siguiente == null) {
                        nuevoNodo.anterior = actual;
                        actual.siguiente = nuevoNodo;
                        F = nuevoNodo;
                        return;
                    }
                    actual = actual.siguiente;
                } else {
                    nuevoNodo.siguiente = actual.siguiente;
                    if (actual.siguiente != null) {
                        actual.siguiente.anterior = nuevoNodo;
                    }
                    actual.siguiente = nuevoNodo;
                    nuevoNodo.anterior = actual;
                    return;
                }
            }
        }
    }

    public void modificar(String cadenaModificar, String nuevaCadena) {
        eliminar(cadenaModificar);
        insertar(nuevaCadena);
        System.out.println(" cadena : \"" + cadenaModificar + "\" ha sido modificada por \"" + nuevaCadena + "\".");
    }
}