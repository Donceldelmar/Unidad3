package FloydWarshall;

import java.util.Scanner;

public class E8 {
	
	 static final int INF = 99999; // Valor que representa "infinito" (no hay conexión)
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("PROGRAMA ALGORITMO DE FLOYD WARSHALL");
	        System.out.println("MATERIA: ESTRUCTURA Y ORGANIZACION DE DATOS");
	        System.out.println("PROGRAMA ALGORITMO DE FLOYD WARSHALL");
	        System.out.println("ESTE PROGRAMA CALCULA LA DISTANCIA MAS CORTA DE RECORRER UN GARFO");

	        System.out.print("INGRESE EL NUMERO DE VERTICES DE UN GRAFO: ");
	        int V = sc.nextInt();
	        
	        int[][] grafo = new int[V][V];
	        
	        System.out.println("\nINGRESE LA MATRIZ DE ADYACENCIA DEL GRAFO: ");
	        System.out.println("USE 99999 SI NO HAY CONEXIÓN ENTRE DOS VÉRTICES.");
	        System.out.println("(POR EJEMPLO: 0 3 99999 7)");
	        
	        // Leer la matriz de adyacencia
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                grafo[i][j] = sc.nextInt();
	            }
	        }
	        
	        // Ejecutar el algoritmo de Floyd-Warshall
	        floydWarshall(grafo, V);
	        
	        sc.close();
	    }
	    
	    public static void floydWarshall(int[][] grafo, int V) {
	        int[][] dist = new int[V][V];
	        
	        // Inicializamos la matriz de distancias igual que la del grafo
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                dist[i][j] = grafo[i][j];
	            }
	        }
	        
	        // Aplicar el algoritmo de Floyd-Warshall
	        for (int k = 0; k < V; k++) {
	            for (int i = 0; i < V; i++) {
	                for (int j = 0; j < V; j++) {
	                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                    }
	                }
	            }
	        }
	        
	        // Mostrar resultados
	        imprimirMatriz(dist, V);
	    }
	    
	    public static void imprimirMatriz(int[][] dist, int V) {
	        System.out.println("\nMATRIZ CON LAS DISTANCIAS MÁS CORTAS ENTRE TODOS LOS PARES DE VÉRTICES:");
	        
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                if (dist[i][j] == INF)
	                    System.out.print("INF ");
	                else
	                    System.out.print(dist[i][j] + "   ");
	            }
	            System.out.println();
	        }
	        System.err.println("ESTE PROGRAMA FUE ELEBORADO POR ");
	        System.err.println("Gaona Alcantar Diego Angel ");
	        

	    }

}
