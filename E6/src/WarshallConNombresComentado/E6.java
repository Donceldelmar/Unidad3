package WarshallConNombresComentado;

public class E6 {
	
	// Definimos el número de nodos del grafo
    private static final int N = 4;

    // Definimos los nombres de cada nodo (pueden ser letras o nombres reales)
    private static final char[] NOMBRES = {'A', 'B', 'C', 'D'};

    // Método principal donde inicia el programa
    public static void main(String[] args) {

        // Creamos la matriz de adyacencia del grafo
        // 1 = hay camino directo entre los nodos
        // 0 = no hay camino directo
        int[][] grafo = {
            {1, 1, 0, 0}, // Desde A: puede ir a A y B
            {0, 1, 1, 0}, // Desde B: puede ir a B y C
            {0, 0, 1, 1}, // Desde C: puede ir a C y D
            {0, 0, 0, 1}  // Desde D: solo puede ir a D
        };



        
        // Mostramos la matriz inicial con nombres
        System.out.println();
        System.out.println("..........PROGRAMA REALIZADO POR Gaona Alcantar Diego..........");
        System.out.println();
        System.out.println("Matriz de adyacencia inicial (caminos directos):");
        mostrarMatrizConNombres(grafo); // Llamamos a la función que imprime la matriz

        // Aplicamos el algoritmo de Warshall
        int[][] cierreTransitivo = warshall(grafo); // Calcula todos los caminos posibles

        // Mostramos la matriz resultante con todos los caminos
        System.out.println("\nMatriz de cierre transitivo (todos los caminos posibles):");
        mostrarMatrizConNombres(cierreTransitivo); // Llamamos nuevamente a la función de impresión
    }

    /**
     * Método que implementa el algoritmo de Warshall
     * Calcula el cierre transitivo del grafo
     */
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static int[][] warshall(int[][] matriz) {

        // Creamos una nueva matriz para no modificar la original
        int[][] resultado = new int[N][N];

        // Copiamos los valores de la matriz original
        for (int i = 0; i < N; i++) {      // Recorremos las filas
            for (int j = 0; j < N; j++) {  // Recorremos las columnas
                resultado[i][j] = matriz[i][j]; // Copiamos el valor de la posición
            }
        }

        // Ciclo principal de Warshall
        // k es el nodo intermedio que usamos para verificar caminos indirectos
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {      // Recorremos filas (nodos de inicio)
                for (int j = 0; j < N; j++) {  // Recorremos columnas (nodos de destino)
                    // Verificamos si existe un camino indirecto i → k → j
                    // Si ya hay camino directo o encontramos un indirecto, ponemos 1
                    resultado[i][j] = (resultado[i][j] == 1) ||
                                      (resultado[i][k] == 1 && resultado[k][j] == 1) ? 1 : 0;
                                      
                }
            }
        }
        
        // Retornamos la matriz con todos los caminos posibles
        return resultado;
        
    }

    /**
     * Método para imprimir la matriz con los nombres de nodos
     */
    
    public static void mostrarMatrizConNombres(int[][] matriz) {
        System.out.println();
 

        // Imprimimos los nombres de las columnas
        System.out.print("    "); // Espacio para la esquina superior izquierda
        for (int i = 0; i < N; i++) {
            System.out.print(NOMBRES[i] + "   "); // Nombre de cada columna
        }
        System.out.println(); // Saltamos línea después de la fila de nombres

        // Imprimimos cada fila con su nombre
        for (int i = 0; i < N; i++) {
            System.out.print(NOMBRES[i] + " | "); // Nombre de la fila
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + "   "); // Valor de cada celda
            }
            System.out.println(); // Saltamos línea al terminar la fila
        }
        
    }

}
