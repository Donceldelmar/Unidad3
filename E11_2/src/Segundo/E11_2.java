package Segundo;

import java.util.LinkedList;

public class E11_2 {
	
	static LinkedList<Integer>[] tabla = new LinkedList[5];

    public static int funcionHash(int numero) {
        return numero % tabla.length;
    }

    public static void insertar(int numero) {
        int indice = funcionHash(numero);

        if (tabla[indice] == null) {
            tabla[indice] = new LinkedList<>();
        }
        tabla[indice].add(numero);
    }

    public static void mostrar() {
    	
    	System.out.println("\nElaborado por Gaona Alcantar Diego Angel");
    	
        System.out.println("\nTabla Hash con Encadenamiento:");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + " -> " + tabla[i]);
        }
    }

    public static void main(String[] args) {
        insertar(10);
        insertar(15);
        insertar(20);
        insertar(6);
        insertar(32);
        insertar(12);

        mostrar();
    }

}
