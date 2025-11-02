package Equipo1;

//Programa para resolver las Torres de Hanoi

//Código realizado por Gaona Alcantar Diego


public class TorresDeHanoi {
	
	 /**
     * Resuelve el rompecabezas de las Torres de Hanoi de forma recursiva.
     *
     * @param n        El número de discos a mover.
     * @param origen   La torre de origen.
     * @param destino  La torre de destino.
     * @param auxiliar La torre auxiliar.
     */
    public static void hanoi(int n, char origen, char destino, char auxiliar) {

        // Caso base: si solo hay un disco, muévelo directamente
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return;
        }

        // Mueve los n-1 discos superiores de la torre de origen a la auxiliar,
        // usando la torre de destino como auxiliar temporal.
        hanoi(n - 1, origen, auxiliar, destino);

        // Mueve el disco más grande (el n-ésimo disco) del origen al destino.
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino);

        // Mueve los n-1 discos de la torre auxiliar a la de destino,
        // usando la torre de origen como auxiliar temporal.
        hanoi(n - 1, auxiliar, destino, origen);
    }

    public static void main(String[] args) {
        // Muestra instrucciones iniciales al usuario
        System.out.println("Sigue los pasos solicitados para ejecutar de manera correcta el programa.");
        System.out.println("Código realizado por Gaona Alacantar Diego Angel\n");
        // Ejemplo de uso: Mover 3 discos
        int numeroDeDiscos = 3;
        hanoi(numeroDeDiscos, 'A', 'C', 'B');
    }

}
