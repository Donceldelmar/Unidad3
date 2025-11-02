package Equipo7;

import java.util.Scanner;

public class dijkstraAlgoritmo {
	
	public static void main(String[] args) { // Método principal donde inicia la ejecución del programa.

	    int u, z, origen = 0, nodos = 0, opcion = 0, exitl = 0; // Declaración de variables enteras: u,z = índices; origen = vértice origen; nodos = número de nodos; opcion = opción del menú; exitl = control para salir del submenú.
	    boolean t, w = true, y; // Variables booleanas: 

	    Scanner teclado = new Scanner(System.in); // Crea un Scanner para leer la entrada del usuario desde la consola.

	    while (w) { // Ciclo principal que mantiene el programa en ejecución hasta que se llame a System.exit(0) o se cambie w (aquí w nunca cambia directamente, el exit se hace con System.exit).
	        System.out.println("|---------------------------Bienvenido---------------------------|"); 
	        System.out.println("|----------------------Algoritmo Dijkstra------------------------|"); 
	        System.out.println("|--------------------------Instrucciones-------------------------|"); 
	        System.out.println("| Este programa ayuda a la resolución de grafos con el método de |"); 
	        System.out.println("| Algoritmo Dijkstra                                             |");
	        System.out.println("| Selecciona No.1 Para digitar Nodos                             |"); 
	        System.out.println("| Selecciona No.2 Para salir del Programa                        |"); 
	        System.out.println("|----------------------------------------------------------------|");
	        System.out.println("| Este programa fue elaborado por el equipo 7 :3                 |"); 

	        do {
	            t = false; // control de excepciones antes de cada intento.
	            try {
	                System.out.print("Selecciona la opción: "); // Pide al usuario que seleccione una opción.
	                opcion = teclado.nextInt(); // Lee la opción como entero.
	            } catch (Exception e) { // Se verifica si el dato de entrada es un número
	                System.out.println("Solo se aceptan números naturales."); // Mensaje de error para el usuario.
	                t = true; // Se repite el bucle de entrada.
	                teclado.next(); //dato de entrada por medio del scanner
	            }
	        } while (t);

	        switch (opcion) { // Selección de acción según la opción ingresada.

	            case 1:
	                y = true; // Activa el sub-bucle que permite repetir la ejecución del algoritmo o volver al menú.

	                while (y) { // Bucle del caso 1 (entrada de nodos, matriz y ejecución del algoritmo).
	                    System.out.println("Seleccionaste 1"); // Mensaje indicando la elección.

	                    do {
	                        t = false;
	                        try {
	                            System.out.println("|-------Digita el número de nodos-------|"); // Solicita cantidad de nodos.
	                            nodos = teclado.nextInt(); // Lee número de nodos.
	                        } catch (Exception e) {
	                            System.out.println("Solo se aceptan números naturales."); // Error si no es entero.
	                            t = true; // Señala repetir la entrada.
	                            teclado.next(); 
	                        }
	                    } while (t); // Repete hasta obtener un entero válido para nodos.

	                    Dijkstra abc = new Dijkstra(); // Crea una instancia de la clase Dijkstra

	                    System.out.println("Digita los costos de la matriz (Cada costo separado por espacios)"); // Instrucciones para ingresar la matriz de costos.
	                    System.out.println("O digítalos uno por uno:"); // Alternativa: el usuario puede ponerlos uno a uno.

	                    for (u = 1; u <= nodos; u++) { // Itera por filas; OBSERVACIÓN: empieza en 1, por lo que la matriz en Dijkstra debe ser de tamaño >= nodos+1.
	                        for (z = 1; z <= nodos; z++) { // Itera por columnas; similar nota sobre índices 1..n.
	                            do {
	                                t = false; 
	                                try {
	                                    abc.costo[u][z] = teclado.nextInt(); // Lee el costo y lo almacena en la matriz costo de la instancia abc.
	                                } catch (Exception e) {
	                                    System.out.println("Solo se aceptan números naturales"); // Mensaje si la entrada no es válida.
	                                    t = true; // Indica que se debe repetir la lectura de este elemento.
	                                    teclado.next();
	                                }
	                            } while (t);

	                            if (abc.costo[u][z] == 0) { // Si el usuario ingresó 0...
	                                abc.costo[u][z] = 999; // ...lo sustituye por 999 (representa 'infinito' / no-conectado; debe coincidir con la implementación en la clase Dijkstra).
	                            }
	                        }
	                    }

	                    do {
	                        t = false;
	                        try {
	                            System.out.println("Digite el origen del vértice:"); // Pide el vértice origen para Dijkstra.
	                            origen = teclado.nextInt(); // Lee el origen como entero.
	                        } catch (Exception e) {
	                            System.out.println("Solo se aceptan números naturales");
	                            t = true; 
	                            teclado.next();
	                        }
	                    } while (t); // Repetir hasta obtener un entero válido para origen.

	                    abc.calcula(nodos, origen); // Llama al método calcula() de la clase Dijkstra para ejecutar el algoritmo con los datos introducidos.

	                    System.out.println("El camino más corto desde el origen " + origen + " a todos los demás vértices es:"); // Mensaje previo a mostrar resultados.
	                    for (u = 1; u <= nodos; u++) { // Recorre todos los nodos para imprimir distancia mínima desde el origen.
	                        if (u != origen) { // Evita imprimir la distancia del origen a sí mismo.
	                            System.out.println("Origen: " + origen + "  Destino: " + u + "  Costo mínimo: " + abc.dist[u]); // Muestra origen, destino y costo mínimo almacenado en abc.dist[u].
	                        }
	                    }

	                    System.out.println("|-------------------------------------------------|");
	                    System.out.println("|Selecciona No.1 para regresar al menú principal  |");
	                    System.out.println("|Selecciona otro número para volver a empezar     |");

	                    do {
	                        t = false;
	                        try {
	                            System.out.print("Selecciona una opción: "); //Selección de opciones
	                            exitl = teclado.nextInt(); // Lee la opción.
	                        } catch (Exception e) {
	                            System.out.println("Solo se aceptan números naturales");
	                            t = true; 
	                            teclado.next(); 
	                        }
	                    } while (t); // Repe

	                    if (exitl == 1) {
	                        y = false; // Si el usuario selecciona 1, sale del while(y) y regresa al menú principal (switch).
	                    }
	                }
	                break; // Fin del case 1.

	            case 2:
	                System.out.println("Seleccionaste salir, gracias por ejecutar el programa."); // Mensaje de despedida.
	                System.exit(0); // Termina todo el programa inmediatamente con código de salida 0.
	                break;

	            default:
	                System.out.println("Opción no válida, intenta nuevamente."); // Mensaje por si la opción ingresada no es 1 ni 2.
	                break;
	        }
	    }
	}

}
