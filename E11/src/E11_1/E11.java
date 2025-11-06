package E11_1;

public class E11 {
	
	static String[] tabla = new String[10];

    public static int funcionHash(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += clave.charAt(i);
        }
        return suma % tabla.length;
    }

    public static void insertar(String nombre) {
        int indice = funcionHash(nombre);

        // Resolver colisión con sondeo lineal
        while (tabla[indice] != null) {
            indice = (indice + 1) % tabla.length;
        }
        tabla[indice] = nombre;
    }

    public static void mostrar() {
    	
    	 System.out.println("\nPrograma Elaborado por Gaona Alcantar Diego Angel");
    	 
    	 System.out.println("\nContenido de la Tabla Hash:");
    	 
    	 
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + " -> " + tabla[i]);
        }
    }

    public static void main(String[] args) {
    	
    	
        insertar("Karen");
        insertar("Luis");
        insertar("Karla");
        insertar("Miguel");

        mostrar();
    }

}
