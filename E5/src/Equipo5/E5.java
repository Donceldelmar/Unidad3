package Equipo5;

import java.util.Scanner;



public class E5 {
	
	// ---------------- Clase Nodo ----------------
    class Nodo {
        int dato;       // Valor del nodo
        Nodo izdo, dcho; // Hijos izquierdo y derecho
        int altura;     // Altura del nodo, necesaria para balancear el árbol

        public Nodo(int valor) {
            dato = valor;
            izdo = dcho = null; // Al crear un nodo hoja, no tiene hijos
            altura = 1;          // La altura de un nodo hoja es 1
        }
    }

    private Nodo raiz; // Raíz del árbol AVL

    // ---------------- Métodos de utilidad ----------------
    // Devuelve la altura de un nodo, 0 si es null
    private int altura(Nodo n) { return n == null ? 0 : n.altura; }

    // Calcula el factor de balance de un nodo: altura izquierda - altura derecha
    private int getBalance(Nodo n) { return n == null ? 0 : altura(n.izdo) - altura(n.dcho); }

    // Rotación simple a la derecha (para casos LL)
    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izdo;
        Nodo T2 = x.dcho;

        x.dcho = y;   // Rotamos
        y.izdo = T2;  // Ajustamos subárbol

        // Actualizamos alturas
        y.altura = Math.max(altura(y.izdo), altura(y.dcho)) + 1;
        x.altura = Math.max(altura(x.izdo), altura(x.dcho)) + 1;

        return x; // Nuevo nodo raíz de este subárbol
    }

    // Rotación simple a la izquierda (para casos RR)
    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.dcho;
        Nodo T2 = y.izdo;

        y.izdo = x;  // Rotamos
        x.dcho = T2; // Ajustamos subárbol

        // Actualizamos alturas
        x.altura = Math.max(altura(x.izdo), altura(x.dcho)) + 1;
        y.altura = Math.max(altura(y.izdo), altura(y.dcho)) + 1;

        return y; // Nuevo nodo raíz de este subárbol
    }

    // ---------------- Inserción ----------------
    // Método público para insertar un valor
    public void insertar(int valor) { raiz = insertarNodo(raiz, valor); }

    // Inserción recursiva
    private Nodo insertarNodo(Nodo nodo, int valor) {
        // 1. Inserción como árbol binario de búsqueda
        if (nodo == null) return new Nodo(valor);

        if (valor < nodo.dato) nodo.izdo = insertarNodo(nodo.izdo, valor);
        else if (valor > nodo.dato) nodo.dcho = insertarNodo(nodo.dcho, valor);
        else return nodo; // Valores duplicados no permitidos

        // 2. Actualizar altura del nodo
        nodo.altura = 1 + Math.max(altura(nodo.izdo), altura(nodo.dcho));

        // 3. Calcular factor de balance
        int balance = getBalance(nodo);

        // 4. Aplicar rotaciones según el tipo de desbalance
        if (balance > 1 && valor < nodo.izdo.dato) return rotacionDerecha(nodo); // LL
        if (balance < -1 && valor > nodo.dcho.dato) return rotacionIzquierda(nodo); // RR
        if (balance > 1 && valor > nodo.izdo.dato) { // LR
            nodo.izdo = rotacionIzquierda(nodo.izdo);
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && valor < nodo.dcho.dato) { // RL
            nodo.dcho = rotacionDerecha(nodo.dcho);
            return rotacionIzquierda(nodo);
        }

        return nodo; // Nodo ya balanceado
    }

    // ---------------- Borrado ----------------
    // Método público para borrar un valor
    public void borrar(int valor) { raiz = borrarNodo(raiz, valor); }

    private Nodo borrarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null; // Nodo no encontrado

        // 1. Buscar el nodo a borrar
        if (valor < nodo.dato) nodo.izdo = borrarNodo(nodo.izdo, valor);
        else if (valor > nodo.dato) nodo.dcho = borrarNodo(nodo.dcho, valor);
        else {
            // Nodo encontrado
            if (nodo.izdo == null || nodo.dcho == null) {
                // Nodo con cero o un hijo
                Nodo temp = (nodo.izdo != null) ? nodo.izdo : nodo.dcho;
                if (temp == null) return null; // Sin hijos
                else nodo = temp; // Un hijo
            } else {
                // Nodo con dos hijos
                Nodo temp = minValueNodo(nodo.dcho); // Encontrar sucesor inorden
                nodo.dato = temp.dato; // Reemplazar valor
                nodo.dcho = borrarNodo(nodo.dcho, temp.dato); // Borrar sucesor
            }
        }

        if (nodo == null) return null;

        // 2. Actualizar altura
        nodo.altura = 1 + Math.max(altura(nodo.izdo), altura(nodo.dcho));
        int balance = getBalance(nodo);

        // 3. Rotaciones si es necesario
        if (balance > 1 && getBalance(nodo.izdo) >= 0) return rotacionDerecha(nodo);
        if (balance > 1 && getBalance(nodo.izdo) < 0) { nodo.izdo = rotacionIzquierda(nodo.izdo); return rotacionDerecha(nodo); }
        if (balance < -1 && getBalance(nodo.dcho) <= 0) return rotacionIzquierda(nodo);
        if (balance < -1 && getBalance(nodo.dcho) > 0) { nodo.dcho = rotacionDerecha(nodo.dcho); return rotacionIzquierda(nodo); }

        return nodo; // Nodo balanceado
    }

    // ---------------- Métodos auxiliares ----------------
    // Encuentra el nodo con el valor mínimo en un subárbol
    private Nodo minValueNodo(Nodo nodo) { while (nodo.izdo != null) nodo = nodo.izdo; return nodo; }

    // Recorrido inorden para mostrar los valores en orden ascendente
    public void inOrden() { inOrdenRec(raiz); System.out.println(); }
    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izdo);
            System.out.print(nodo.dato + " ");
            inOrdenRec(nodo.dcho);
        }
    }

    // ---------------- Menú interactivo ----------------
    public static void main(String[] args) {
        //Expo arbol = new Expo();
    	E5 arbol = new E5();
        Scanner sc = new Scanner(System.in);
        int opcion, valor;

        do {
            System.out.println("Código realizado por Gaona Alcntar Diego Angel\n");
            System.out.println("\n--- Árbol AVL Interactivo ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Borrar nodo");
            System.out.println("3. Mostrar árbol inorden");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    valor = sc.nextInt();
                    arbol.insertar(valor); // Inserta valor y rebalancea automáticamente
                    System.out.println(valor + " insertado.");
                    break;
                case 2:
                    System.out.print("Valor a borrar: ");
                    valor = sc.nextInt();
                    arbol.borrar(valor); // Borra valor y rebalancea automáticamente
                    System.out.println(valor + " borrado si existía.");
                    break;
                case 3:
                    System.out.print("Árbol inorden: ");
                    arbol.inOrden(); // Muestra todos los valores en orden ascendente
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close(); // Cierra el scanner
    }

}
