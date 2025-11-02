package Factorial;

//Programa para calcular el factorial de un número
//Código realizado por Gaona Alcanatar Diego Angel

import java.util.Scanner; // Importa la clase Scanner que permite leer datos ingresados por el usuario desde el teclado

public class E1 {
	
	 public static void main(String[] args) { // Método principal donde inicia la ejecución del programa
	        // Muestra instrucciones iniciales al usuario
	        System.out.println("Sigue los pasos solicitados para ejecutar de manera correcta el programa.");
	        System.out.println("Código realizado por Gaona Alcantar Diego Angel\n");

	        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para poder leer la entrada del usuario
	        System.out.print("Introduce un número: "); // Solicita al usuario que introduzca un número
	        int n = sc.nextInt(); // Almacena el número ingresado en la variable 'n'
	        sc.close(); // Cierra el objeto Scanner para liberar memoria y recursos del sistema

	        // Muestra en pantalla el resultado del cálculo del factorial
	        System.out.println("El factorial de " + n + " es: " + factorial(n));
	    }

	    // Método recursivo que calcula el factorial de un número
	    public static long factorial(int n) {
	        if (n == 0 || n == 1) // Si el número es 0 o 1, se devuelve 1 porque 0! y 1! = 1
	            return 1; // Caso base: detiene la recursión
	        else // En caso contrario...
	            return n * factorial(n - 1); // Llama al mismo método con (n - 1) para calcular n * (n-1)!
	    }
	
	

}
