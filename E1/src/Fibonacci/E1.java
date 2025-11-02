package Fibonacci;

import java.util.Scanner; // Importa la clase Scanner para poder leer datos desde el teclado

public class E1 {
	
	public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
        // Muestra información introductoria al usuario
        System.out.println("Sigue los pasos solicitados para ejecutar de manera correcta el programa.");
        System.out.println("Código realizado por Gaoan Alcantar Diego Angel\n");

        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para capturar la entrada del usuario
        System.out.print("Introduce el número de términos: "); // Pide al usuario cuántos términos desea generar
        int n = sc.nextInt(); // Guarda el número ingresado por el usuario en la variable 'n'
        sc.close(); // Cierra el objeto Scanner para liberar los recursos del sistema

        System.out.println("Serie de Fibonacci:"); // Muestra el título antes de imprimir la serie

        // Bucle que recorre desde 0 hasta n-1
        for (int i = 0; i < n; i++) { // Repite el proceso n veces para generar los n términos
            System.out.print(fibonacci(i) + " "); // Llama al método 'fibonacci' y muestra el resultado en la misma
                                                  // línea
        }
    }
	
	
	
	// Método recursivo que calcula el valor de Fibonacci en una posición dada
    public static int fibonacci(int n) {
        if (n <= 1) // Si el número es 0 o 1, devuelve el mismo valor de n (casos base)
            return n; // Caso base que detiene la recursión
        else // En los demás casos...
            return fibonacci(n - 1) + fibonacci(n - 2); // Suma los dos valores anteriores de la secuencia
    }
	
	

}
