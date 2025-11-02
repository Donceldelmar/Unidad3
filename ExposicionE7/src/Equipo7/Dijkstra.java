package Equipo7;

public class Dijkstra {
	
	public int costo[][] = new int[10][10];
    public int dist[] = new int[10];

    public void calcula(int x, int y) {
        int indi[] = new int[x + 1];
        int u, costomin = 1, c, d, minimo;

        // Inicializa las distancias y los indicadores
        for (u = 1; u <= x; u++) {
            indi[u] = 0;
            this.dist[u] = this.costo[y][u];
        }

        c = 2;

        // Algoritmo principal de Dijkstra
        while (c <= x) {
            minimo = 99; // valor muy grande
            costomin = 1;

            // Buscar el vértice con la distancia mínima
            for (d = 1; d <= x; d++) {
                if (this.dist[d] < minimo && indi[d] != 1) {
                    minimo = this.dist[d];
                    costomin = d;
                }
            }

            indi[costomin] = 1;
            c++;

            // Actualizar las distancias de los vértices adyacentes
            for (d = 1; d <= x; d++) {
                if ((this.dist[costomin] + this.costo[costomin][d] < this.dist[d]) && indi[d] != 1) {
                    this.dist[d] = this.dist[costomin] + this.costo[costomin][d];
                }
            }
        }
    }

}
