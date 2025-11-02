package ArbolOrdenado;

//Elaborado Por Gaona Alcantar Diego Angel

import java.util.Scanner;

public class E4 {
	
	// ---- Clase Nodo ----
    // Representa cada nodo del árbol con su valor y referencias a hijos izquierdo y derecho
    class Nodo {
        int dato;
        Nodo izq, der;
        Nodo(int d) { dato = d; } // Constructor
    }

    Nodo raiz; // Raíz del árbol

    // ---- Método para insertar un nodo ----
    // Inserta un valor en el árbol respetando la propiedad de árbol ordenado
    void insertar(int v) {
        Nodo nuevo = new Nodo(v);
        if (raiz == null) { raiz = nuevo; return; } // Si el árbol está vacío, nuevo nodo es la raíz
        Nodo actual = raiz;
        while (true) {
            if (v <= actual.dato) { // Si el valor es menor o igual, va al hijo izquierdo
                if (actual.izq == null) { actual.izq = nuevo; break; }
                actual = actual.izq;
            } else { // Si es mayor, va al hijo derecho
                if (actual.der == null) { actual.der = nuevo; break; }
                actual = actual.der;
            }
        }
    }

    // ---- Recorrido Inorden ----
    // Retorna un String con los valores en orden ascendente
    String inorden(Nodo n) {
        if (n == null) return "";
        return inorden(n.izq) + n.dato + " " + inorden(n.der);
    }

    // ---- Recorrido Preorden ----
    // Retorna un String con los valores: nodo -> izquierda -> derecha
    String preorden(Nodo n) {
        if (n == null) return "";
        return n.dato + " " + preorden(n.izq) + preorden(n.der);
    }

    // ---- Recorrido Postorden ----
    // Retorna un String con los valores: izquierda -> derecha -> nodo
    String postorden(Nodo n) {
        if (n == null) return "";
        return postorden(n.izq) + postorden(n.der) + n.dato + " ";
    }

    // ---- Contar nodos ----
    // Devuelve la cantidad de nodos en el árbol
    int contarNodos(Nodo n) {
        if (n == null) return 0;
        return 1 + contarNodos(n.izq) + contarNodos(n.der);
    }

    // ---- Sumar nodos ----
    // Devuelve la suma de todos los valores de los nodos
    int sumarNodos(Nodo n) {
        if (n == null) return 0;
        return n.dato + sumarNodos(n.izq) + sumarNodos(n.der);
    }

    // ---- Método de pausa ----
    // Permite que la consola espere para ver los resultados antes de continuar
    void pausa(Scanner sc) {
        System.out.println("\nPresiona Enter para continuar...");
        sc.nextLine();
    }

    // ---- Menú principal ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ArbolOrdenado arbol = new ArbolOrdenado();
        E4 arbol = new E4();
        int op = 0;

        while (true) {
            // Mostrar opciones del menú
            System.out.println("\n=== MENÚ ÁRBOL ORDENADO ===");
            System.out.println("Elaborado Por Gaona Alcantar Diego Angel");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Mostrar Inorden");
            System.out.println("3. Mostrar Preorden");
            System.out.println("4. Mostrar Postorden");
            System.out.println("5. Contar nodos");
            System.out.println("6. Sumar nodos");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            // Leer opción del usuario
            String linea = sc.nextLine();
            try { op = Integer.parseInt(linea); }
            catch (Exception e) { 
                System.out.println("⚠️ Entrada inválida."); 
                continue; 
            }

            switch (op) {
                case 1: // Insertar nodo
                    System.out.print("Valor a insertar: ");
                    try {
                        int val = Integer.parseInt(sc.nextLine());
                        arbol.insertar(val);
                        System.out.println("✅ Nodo agregado.");
                    } catch (Exception e) { System.out.println("⚠️ Valor inválido."); }
                    arbol.pausa(sc);
                    break;

                case 2: // Mostrar Inorden
                    String resIn = arbol.inorden(arbol.raiz);
                    System.out.println(resIn.isEmpty() ? "Árbol vacío" : "Inorden: " + resIn);
                    arbol.pausa(sc);
                    break;

                case 3: // Mostrar Preorden
                    String resPre = arbol.preorden(arbol.raiz);
                    System.out.println(resPre.isEmpty() ? "Árbol vacío" : "Preorden: " + resPre);
                    arbol.pausa(sc);
                    break;

                case 4: // Mostrar Postorden
                    String resPost = arbol.postorden(arbol.raiz);
                    System.out.println(resPost.isEmpty() ? "Árbol vacío" : "Postorden: " + resPost);
                    arbol.pausa(sc);
                    break;

                case 5: // Contar nodos
                    System.out.println("Total de nodos: " + arbol.contarNodos(arbol.raiz));
                    arbol.pausa(sc);
                    break;

                case 6: // Sumar nodos
                    System.out.println("Suma de todos los nodos: " + arbol.sumarNodos(arbol.raiz));
                    arbol.pausa(sc);
                    break;

                case 7: // Salir
                    System.out.println("👋 Fin del programa.");
                    arbol.pausa(sc);
                    sc.close();
                    return;

                default: // Opción inválida
                    System.out.println("⚠️ Opción inválida.");
                    arbol.pausa(sc);
            }
        }
    }

}
