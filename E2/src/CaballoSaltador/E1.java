package CaballoSaltador;

import java.util.Scanner;

/**
 * Resuelve el problema del "Salto del Caballo" en un tablero de N x N
 * usando un algoritmo de backtracking.
 */

public class E1 {
	
	 // Tamaño del tablero (8x8)
    static final int N = 8;
    // Usamos N+1 para poder usar índices base 1 (de 1 a 8) y que coincida
    // con la notación de ajedrez, ignorando la fila 0 y columna 0.
    static final int n = (N + 1); 
    
    private int[][] tablero = new int[n][n];
    private boolean exito; // Bandera para saber si se encontró solución
    
    // Los 8 movimientos posibles del caballo (desplazamientos en x, y)
    private int[][] SALTO = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                             {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    
    private int x0, y0; // Coordenadas iniciales

    /**
     * Constructor de la clase.
     * @param x Coordenada x inicial (1 a N)
     * @param y Coordenada y inicial (1 a N)
     * @throws Exception si las coordenadas están fuera del rango
     */
    //public CaballoSaltador(int x, int y) throws Exception {
    public E1(int x, int y) throws Exception {
        if ((x < 1) || (x > N) || (y < 1) || (y > N)) {
            throw new Exception("Coordenadas fuera de rango (deben ser de 1 a " + N + ")");
        }
        x0 = x;
        y0 = y;
        
        // Inicializa el tablero con ceros
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tablero[i][j] = 0;
            }
        }
        
        // Coloca el primer movimiento
        tablero[x0][y0] = 1;
        exito = false;
    }

    /**
     * Método público para iniciar la resolución del problema.
     * @return true si se encontró solución, false en caso contrario.
     */
    public boolean resolverProblema() {
        // Inicia la búsqueda recursiva a partir del segundo movimiento (i = 2)
        saltoCaballo(x0, y0, 2);
        return exito;
    }

    /**
     * Método recursivo de backtracking para encontrar el camino.
     * @param x Coordenada x actual
     * @param y Coordenada y actual
     * @param i El número de movimiento actual (de 2 a N*N)
     */
    private void saltoCaballo(int x, int y, int i) {
        int nx, ny; // Coordenadas del siguiente salto
        int k = 0;  // Índice para iterar sobre los 8 movimientos posibles (SALTO)

        do {
            k++;
            nx = x + SALTO[k - 1][0]; // Calcula la coordenada x del siguiente salto
            ny = y + SALTO[k - 1][1]; // Calcula la coordenada y del siguiente salto

            // Comprueba si el siguiente salto es VÁLIDO:
            // 1. Está dentro de los límites del tablero (1 a N)
            // 2. La casilla no ha sido visitada (tablero[nx][ny] == 0)
            if ((nx >= 1 && nx <= N) && (ny >= 1 && ny <= N) && (tablero[nx][ny] == 0)) {
                
                // Si es válido, marca la casilla con el número de movimiento
                tablero[nx][ny] = i; 

                if (i < N * N) { // Caso recursivo: Aún no se llena el tablero
                    saltoCaballo(nx, ny, i + 1); // Llama recursivamente para el siguiente movimiento

                    // Si la llamada recursiva no llevó al éxito (!exito),
                    // es un callejón sin salida. Debemos retroceder (backtrack).
                    if (!exito) {
                        tablero[nx][ny] = 0; // Desmarca la casilla (la pone en 0)
                    }
                } else {
                    // Caso base: Se completó el tablero (i == N*N)
                    exito = true; // Se encontró la solución
                }
            }
        } while (k < 8 && !exito); // Repetir mientras queden movimientos (k<8) Y no se haya encontrado el éxito
    }

    /**
     * Muestra el tablero en la consola.
     */
    public void mostrarTablero() {
        System.out.println("Tablero de la solución:");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // System.out.printf usa formato para que todos los números
                // ocupen 2 espacios (%2d) y se vea alineado.
                System.out.printf("%2d ", tablero[i][j]);
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    /**
     * Método principal (main) para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //CaballoSaltador caballo = null;
        E1 caballo = null;

        try {
            System.out.println("--- Solución al Problema del Salto del Caballo (8x8) ---");
            System.out.print("Introduce la coordenada X inicial (1-8): ");
            int x = sc.nextInt();
            System.out.print("Introduce la coordenada Y inicial (1-8): ");
            int y = sc.nextInt();

            // 1. Crear el objeto CaballoSaltador
            //caballo = new CaballoSaltador(x, y);
            caballo = new E1(x, y);
            
            System.out.println("\nCalculando solución desde (" + x + ", " + y + ")...");
            long tiempoInicio = System.currentTimeMillis();

            // 2. Resolver el problema
            if (caballo.resolverProblema()) {
                long tiempoFin = System.currentTimeMillis();
                System.out.println("¡Solución encontrada! (Tiempo: " + (tiempoFin - tiempoInicio) + " ms)");
                System.out.println("---------------------------------");
                // 3. Mostrar el resultado
                caballo.mostrarTablero();
            } else {
                System.out.println("No se encontró una solución partiendo desde (" + x + ", " + y + ").");
            }

        } catch (java.util.InputMismatchException e) {
            System.err.println("Error: Debes introducir números enteros.");
        } catch (Exception e) {
            // Captura la excepción de "Coordenadas fuera de rango"
            System.err.println("Error: " + e.getMessage());
        } finally {
            sc.close(); // Cierra el scanner
            System.out.println("\nCódigo Hecho Por Gaona Alcantar Diego Angel");
        }
    }

}
