package PrimAlgorithm;

import java.util.Scanner;

public class E9 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int V = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            try {
                System.out.print("Introduce el número de vértices: ");
                String entrada = sc.nextLine();
                V = Integer.parseInt(entrada);
                
                if (V <= 0) {
                    System.out.println("Error: El número de vértices debe ser mayor a 0.");
                    continue;
                }
                
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Favor de solo introducar caracteres numéricos, nada de letras.");
                System.out.println("Por favor, intenta de nuevo.\n");
            }
        }

        int[][] graph = new int[V][V];

        System.out.println("\nIntroduce la matriz de adyacencia del grafo (0 si no hay conexión):");
        System.out.println("Nota: Introduce " + V + " números por fila, separados por espacios.");
        
        
        for (int i = 0; i < V; i++) {
            boolean filaValida = false;
            while (!filaValida) {
                try {
                    System.out.print("Fila " + i + ": ");
                    String fila = sc.nextLine();
                    String[] numeros = fila.trim().split("\\s+");
                    
                    if (numeros.length != V) {
                        System.out.println("Error: Debes introducir exactamente " + V + " números.");
                        System.out.println("Números introducidos: " + numeros.length);
                        continue;
                    }
                    
                    
                    for (int j = 0; j < V; j++) {
                        graph[i][j] = Integer.parseInt(numeros[j]);
                        if (graph[i][j] < 0) {
                            System.out.println("Error: Los pesos no pueden ser negativos.");
                            filaValida = false;
                            break;
                        }
                        filaValida = true;
                    }
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error: Favor de solo introducir caracteres numéricos, nada de letras.");
                    System.out.println("Por favor, introduce la fila completa de nuevo.\n");
                }
            }
        }

        
        primMST(graph, V);

        System.out.println("\n---------------------------------");
        System.out.println("    Créditos para el equipo 9");
        System.out.println("---------------------------------");

        System.out.println("\nPresiona Enter para cerrar el programa...");
        sc.nextLine(); 

        sc.close();
    }

    public static void primMST(int[][] graph, int V) {
        int[] parent = new int[V];   
        int[] key = new int[V];      
        boolean[] inMST = new boolean[V];  

        
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        
        key[0] = 0;  
        parent[0] = -1;  

        
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, inMST, V);
            
            if (u == -1) {
                System.out.println("Error: El grafo no es conexo. No se puede construir un MST.");
                return;
            }
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    public static int minKey(int[] key, boolean[] inMST, int V) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    public static void printMST(int[] parent, int[][] graph, int V) {
        int totalCost = 0;
        System.out.println("\nAristas en el Árbol de Expansión Mínima:");

        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) { 
                System.out.println(parent[i] + " - " + i + "  \tPeso: " + graph[i][parent[i]]);
                totalCost += graph[i][parent[i]];
            }
        }

        System.out.println("Costo total mínimo del MST: " + totalCost);
        
        System.out.println("Elaborado por Gaona Alcantar Diego Angel");
        




    }

}
