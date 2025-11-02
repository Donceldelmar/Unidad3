package DivideyVenceras;
//Programa que aplica la técnica Divide y Vencerás para encontrar el valor máximo en un arreglo
//Código realizado por Gaona Alcantar Diego Angel


public class E1 {
	public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        System.out.println("Sigue los pasos solicitados para ejecutar de manera correcta el programa.");
        System.out.println("Código realizado por Gaoina Alcantar Diego Angel\n");

        int[] arreglo = { 5, 9, 3,}; // Declara e inicializa un arreglo con valores enteros

        // Verifica que el arreglo no esté vacío antes de procesarlo
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío. No se puede calcular un valor máximo.");
            return;
        }

        // Llama al método recursivo 'maximo' para obtener el valor máximo del arreglo
        int max = maximo(arreglo, 0, arreglo.length - 1);

        // Muestra en pantalla el resultado final obtenido
        System.out.println("El valor máximo en el arreglo es: " + max);
    }

    /**
     * Método recursivo que implementa la técnica "Divide y Vencerás"
     * para encontrar el máximo valor dentro de un arreglo.
     */
    public static int maximo(int[] arr, int inicio, int fin) {
        // Caso base: si el rango tiene un solo elemento, ese es el máximo
        if (inicio == fin) {
            return arr[inicio];
        }

        // Calcula la posición media del arreglo
        int medio = (inicio + fin) / 2;

        // Llamadas recursivas: busca el máximo en la mitad izquierda y derecha
        int maxIzq = maximo(arr, inicio, medio);
        int maxDer = maximo(arr, medio + 1, fin);

        // Devuelve el mayor de ambos valores
        return Math.max(maxIzq, maxDer);
    }

}
