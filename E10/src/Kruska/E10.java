package Kruska;

import java.util.*;

public class E10 {
	
	static class Arista implements Comparable<Arista> {
        int u, v, peso;

        Arista(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }

        public int compareTo(Arista otra) {
            return this.peso - otra.peso; // ordenar por peso
        }
    }

    // Buscar el representante de un conjunto (Union-Find simple)
    static int encontrar(int padre[], int i) {
        if (padre[i] == i)
            return i;
        return encontrar(padre, padre[i]);
    }

    // Unir dos conjuntos
    static void unir(int padre[], int a, int b) {
        padre[encontrar(padre, a)] = encontrar(padre, b);
    }

    public static void main(String[] args) {
        // Grafo con 4 vértices y 5 aristas
        List<Arista> aristas = new ArrayList<>();
        aristas.add(new Arista(0, 1, 10));
        aristas.add(new Arista(0, 2, 6));
        aristas.add(new Arista(0, 3, 5));
        aristas.add(new Arista(1, 3, 15));
        aristas.add(new Arista(2, 3, 4));

        // Ordenar aristas por peso
        Collections.sort(aristas);

        int V = 4; // número de vértices
        int padre[] = new int[V];
        for (int i = 0; i < V; i++)
            padre[i] = i;

        System.out.println("Aristas del árbol de expansión mínima:");

        for (Arista a : aristas) {
            int raizU = encontrar(padre, a.u);
            int raizV = encontrar(padre, a.v);

            if (raizU != raizV) { // Si no forma ciclo
                System.out.println(a.u + " - " + a.v + " => " + a.peso);
                unir(padre, raizU, raizV);

            }
        }
        System.out.println("Este código fue creado por Gaona Alcantar Diego Angel");
        

    }

}
