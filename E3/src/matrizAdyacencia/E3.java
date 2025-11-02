package matrizAdyacencia;

import java.util.Scanner;

public class E3 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️⃣ Pedimos el número de vértices
        
        System.out.println("Elaborado por Gaona Alcantar Diego Angel");
        System.out.println("Ingrese el número de vértices: ");
        int vertices = sc.nextInt();
        sc.nextLine(); // Limpia el buffer

        // 2️⃣ Creamos un arreglo con los nombres de los vértices (A, B, C, ...)
        char[] nombres = new char[vertices];
        for (int i = 0; i < vertices; i++) { //Ciclo for sencillo para llenar el arreglo de vértices
            nombres[i] = (char) ('A' + i); // El resultado de esto es [A,B,B,D,ETC..]
        }

        // 3️⃣ Creamos la matriz de adyacencia
        int[][] matriz = new int[vertices][vertices];

        // 4️⃣ Pedimos las conexiones
        System.out.println("\nIngrese las conexiones entre vértices (0 = no hay conexión, 1 = hay conexión):");
        for (int i = 0; i < vertices; i++) {//Lee filas
            for (int j = 0; j < vertices; j++) { // Lee columnas
                if (i == j) { // Si el vértice apunta a si mismo, por defecto, el valor de la arista se asigna con 0
                    matriz[i][j] = 0; // un vértice no se conecta consigo mismo
                } else {
                    System.out.print("¿Existe conexión entre " + nombres[i] + " y " + nombres[j] + "? "); //Se pide al usuario indicar si existe conexión entre un vértice y otro
                    matriz[i][j] = sc.nextInt(); //Se coloca 1 o 0 en la fila y columna que corresponda
                }
            }
        }

        // 5️⃣ Mostramos la matriz de adyacencia con encabezados
        System.out.println("\nMatriz de adyacencia:");
        System.out.print("   ");
        for (char c : nombres) { //Ciclo forEach para mostrar la representación de los NODOS en las columnas
            System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < vertices; i++) { //Ciclo for ANIDADO para poder recorrer la matriz bidimensional(filas y columnas)
            System.out.print(nombres[i] + "  "); //En el cilo for de filas, se pintan tambien las letras para representar los NODOS
            for (int j = 0; j < vertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // 6️⃣ Mostramos las conexiones encontradas
        System.out.println("\nConexiones encontradas:");
        for (int i = 0; i < vertices; i++) { //Ciclo for ANIDADO para escribir la conexión entre nodos que el usuaruio introdujo
            for (int j = 0; j < vertices; j++) {
                if (matriz[i][j] == 1) {
                    System.out.println("El vértice " + nombres[i] + " está conectado con " + nombres[j]);
                }
            }
        }

        sc.close();
    }

}
