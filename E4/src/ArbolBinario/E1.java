package ArbolBinario;

//Programa: Árbol Binario Interactivo (Versión Corregida)
//Autor: Gaona Alcantar Diego Angel
//Descripción: Árbol binario con menú interactivo en consola (Eclipse compatible)

import java.util.Scanner;

public class E1 {
	
	 // ---- Clase interna Nodo ----
    // Representa cada nodo del árbol con su valor y referencias a hijos izquierdo y derecho
    class Nodo {
        int dato;       // Valor almacenado en el nodo
        Nodo izquierdo; // Hijo izquierdo
        Nodo derecho;   // Hijo derecho

        Nodo(int dato) { // Constructor
            this.dato = dato;
            izquierdo = null;
            derecho = null;
        }
    }

    Nodo raiz; // Raíz del árbol

    // Constructor del Árbol Binario
    //public ArbolBinario() {
    public E1() {
        raiz = null; // Inicialmente el árbol está vacío
    }

    // ---- Insertar un nodo ----
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor); // Llama al método recursivo
    }

    // Método recursivo para insertar un nodo
    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) { // Caso base: si el nodo es nulo, se crea uno nuevo
            actual = new Nodo(valor);
            return actual;
        }
        if (valor < actual.dato) { // Si el valor es menor, va al hijo izquierdo
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else if (valor > actual.dato) { // Si es mayor, va al hijo derecho
            actual.derecho = insertarRec(actual.derecho, valor);
        }
        return actual; // Devuelve el nodo actual
    }

    // ---- Buscar un valor ----
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor); // Llama al método recursivo
    }

    // Método recursivo para buscar un valor
    private boolean buscarRec(Nodo actual, int valor) {
        if (actual == null) // Caso base: nodo nulo -> no encontrado
            return false;
        if (actual.dato == valor) // Valor encontrado
            return true;
        // Buscar en subárbol izquierdo o derecho según el valor
        return valor < actual.dato
                ? buscarRec(actual.izquierdo, valor)
                : buscarRec(actual.derecho, valor);
    }

    // ---- Recorridos del árbol ----

    // Recorrido Inorden (Izquierdo -> Raíz -> Derecho)
    public void inorden() {
        System.out.print("Recorrido Inorden: ");
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo actual) {
        if (actual != null) {
            inordenRec(actual.izquierdo);
            System.out.print(actual.dato + " ");
            inordenRec(actual.derecho);
        }
    }

    // Recorrido Preorden (Raíz -> Izquierdo -> Derecho)
    public void preorden() {
        System.out.print("Recorrido Preorden: ");
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.dato + " ");
            preordenRec(actual.izquierdo);
            preordenRec(actual.derecho);
        }
    }

    // Recorrido Postorden (Izquierdo -> Derecho -> Raíz)
    public void postorden() {
        System.out.print("Recorrido Postorden: ");
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo actual) {
        if (actual != null) {
            postordenRec(actual.izquierdo);
            postordenRec(actual.derecho);
            System.out.print(actual.dato + " ");
        }
    }

    // ---- Método de pausa ----
    // Permite que la consola espere para que el usuario vea los resultados antes de continuar
    private static void pausa(Scanner sc) {
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine(); // Limpiar buffer
        sc.nextLine(); // Esperar Enter
    }

    // ---- Menú principal ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArbolBinario arbol = new ArbolBinario();
        E1 arbol = new E1();
        int opcion = 0, valor;

        do {
            // Mostrar opciones del menú
            System.out.println("\n===== MENÚ ÁRBOL BINARIO =====");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar nodo");
            System.out.println("3. Mostrar recorrido INORDEN");
            System.out.println("4. Mostrar recorrido PREORDEN");
            System.out.println("5. Mostrar recorrido POSTORDEN");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            // Verificar que la entrada sea numérica
            if (!sc.hasNextInt()) {
                System.out.println("⚠️ Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada inválida
                continue;
            }

            opcion = sc.nextInt(); // Leer opción seleccionada

            switch (opcion) {
                case 1: // Insertar nodo
                    System.out.print("Ingrese el valor a insertar: ");
                    valor = sc.nextInt();
                    arbol.insertar(valor);
                    System.out.println("✅ Nodo " + valor + " insertado correctamente.");
                    pausa(sc);
                    break;

                case 2: // Buscar nodo
                    System.out.print("Ingrese el valor a buscar: ");
                    valor = sc.nextInt();
                    if (arbol.buscar(valor))
                        System.out.println("🔎 El valor " + valor + " SÍ existe en el árbol.");
                    else
                        System.out.println("❌ El valor " + valor + " NO se encuentra en el árbol.");
                    pausa(sc);
                    break;

                case 3: // Recorrido Inorden
                    arbol.inorden();
                    pausa(sc);
                    break;

                case 4: // Recorrido Preorden
                    arbol.preorden();
                    pausa(sc);
                    break;

                case 5: // Recorrido Postorden
                    arbol.postorden();
                    pausa(sc);
                    break;

                case 6: // Salir
                    System.out.println("\n👋 Saliendo del programa...");
                    break;

                default: // Opción inválida
                    System.out.println("⚠️ Opción no válida. Intente de nuevo.");
                    pausa(sc);
            }

        } while (opcion != 6);

        // Mensaje final
        System.out.println("\n--------------------------------------------");
        System.out.println("     © 2025 - Gaona Alcantar Diego Angel");
        System.out.println("     Árbol Binario desarrollado en Java");
        System.out.println("--------------------------------------------");
        sc.close();
    }

}
