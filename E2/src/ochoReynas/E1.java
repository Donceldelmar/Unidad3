package ochoReynas;

/**
 * Implementación del Algoritmo de las 8 Reinas
 * utilizando el esquema de Vuelta Atrás (Backtracking)
 * proporcionado por el usuario.
 */

public class E1 {
	
	// N es el tamaño del tablero (8x8)
    private static final int N = 8;
    
    /**
     * Almacena la solución.
     * La lógica del código usa índices base 1 (de 1 a 8).
     * reinas[i] = j significa:
     * "La reina de la COLUMNA 'i' está colocada en la FILA 'j'"
     * Usamos N+1 para tener índices de 1 a 8 (ignorando el 0).
     */
    private int[] reinas;
    
    // Bandera para indicar si se encontró una solución
    private boolean solucion;

    /**
     * Constructor
     */
    //public OchoReinas() { Originalmente estaba asi se modifico por que la clase prinkcipal cambio
    public E1() {
        // Inicializa el array (Java lo llena de 0s por defecto)
        reinas = new int[N + 1]; 
        solucion = false;
    }

    /**
     * Método público (interfaz) para iniciar la búsqueda de la solución.
     * Este es el método que proporcionaste.
     */
    public boolean solucionReinas() {
        solucion = false;
        // Inicia la búsqueda recursiva en la primera columna (i=1)
        ponerReina(1); 
        return solucion;
    }

    /**
     * Método recursivo de backtracking para colocar las reinas.
     * Este es el método que proporcionaste.
     * * @param i La columna actual que estamos intentando resolver.
     */
    private void ponerReina(int i) {
        int j;
        j = 0; // 'j' representa la FILA que vamos a probar
        
        do {
            j++; // Probar la fila 'j' (de 1 a 8)
            
            // <Anotar selección>
            reinas[i] = j; // Coloca la reina de la columna 'i' en la fila 'j'

            // <Determinar si selección es válida>
            if (valido(i)) {
                
                // si <problema no solucionado> entonces...
                if (i < N) { 
                    // Llamada recursiva para la siguiente columna (i+1)
                    ponerReina(i + 1);
                    
                    // --- VUELTA ATRÁS (BACKTRACK) ---
                    // Si la llamada recursiva (!solucion) falló,
                    // significa que la fila 'j' no era correcta.
                    if (!solucion) {
                        reinas[i] = 0; // <Borrar anotación>
                    }
                } else { 
                    // si <problema solucionado>
                    // (i == N), todas las reinas (de 1 a 8) están colocadas
                    solucion = true;
                }
            }
        } while (!solucion && (j < N)); // j < 8 según tu texto (es lo mismo que N)
    }

    /**
     * Verifica si la reina recién colocada en la columna 'i'
     * es atacada por alguna reina anterior (columnas 1 a i-1).
     * Este es el método que proporcionaste.
     *
     * @param i La columna de la reina que acabamos de colocar.
     * @return true si la posición es válida (no es atacada), false si no.
     */
    private boolean valido(int i) {
        /* Inspecciona si la reina de la columna i es atacada por
           alguna reina colocada anteriormente */
        int r; // 'r' itera sobre las columnas anteriores (1 a i-1)
        boolean libre = true;
        
        for (r = 1; r <= i - 1; r++) {
            
            // 1. no esté en la misma fila
            libre = libre && (reinas[i] != reinas[r]);
            
            // 2. no esté en alguna de las dos diagonales
            // Lógica: (col - fila) == (col' - fila') -> misma diagonal \
            // Lógica: (col + fila) == (col' + fila') -> misma diagonal /
            // (Tu código usa (i - reinas[i]) y (i + reinas[i]), lo cual es correcto)
            
            libre = libre && ((i + reinas[i]) != (r + reinas[r])); // Diagonal /
            libre = libre && ((i - reinas[i]) != (r - reinas[r])); // Diagonal \
        }
        return libre;
    }

    /**
     * Método auxiliar para mostrar el tablero con la solución.
     */
    public void mostrarTablero() {
        if (!solucion) {
            System.out.println("No se ha encontrado solución.");
            return;
        }
        System.out.println("Solución para las 8 Reinas:");
        for (int f = 1; f <= N; f++) { // f = fila
            for (int c = 1; c <= N; c++) { // c = columna
                // Si la reina de la columna 'c' está en la fila 'f'
                if (reinas[c] == f) {
                    System.out.print(" R ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila
        }
    }

    /**
     * Método principal (main) para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        //OchoReinas problema = new OchoReinas(); Originalmante estaba así se realizo el cambio por que la clase principal cambio
    	E1 problema = new E1();
        
        System.out.println("Buscando una solución al problema de las 8 Reinas...");
        
        if (problema.solucionReinas()) {
            problema.mostrarTablero();
        } else {
            System.out.println("No se encontró ninguna solución.");
        }
        
        System.out.println("\nCódigo Hecho Por Gaona Alcantar Diego Angel");
    }

}
