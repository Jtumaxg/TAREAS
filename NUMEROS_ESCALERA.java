import java.util.Scanner;

public class NUMEROS_ESCALERA {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Solicita al usuario la cantidad de niveles para generar las escaleras
        System.out.print("Ingrese la cantidad de niveles deseada: ");
        int cantidadNiveles = entrada.nextInt();

        // Verifica que el número ingresado sea válido (positivo y mayor que cero)
        if (cantidadNiveles < 1) {
            System.out.println("Error: El número de niveles debe ser mayor a cero.");
        } else {
            // Imprime la escalera ascendente
            System.out.println("\n>> Escalera Ascendente:");
            construirEscaleraAscendente(cantidadNiveles);

            // Imprime la escalera descendente
            System.out.println("\n>> Escalera Descendente:");
            construirEscaleraDescendente(cantidadNiveles);
        }

        entrada.close(); // Cierre del escáner al final del programa
    }

    // Método que genera una escalera ascendente desde 1 hasta n
    public static void construirEscaleraAscendente(int niveles) {
        for (int fila = 1; fila <= niveles; fila++) {
            mostrarLinea(fila); // Cada fila representa un nivel con números del 1 al valor de 'fila'
        }
    }

    // Método que genera una escalera descendente desde n hasta 1
    public static void construirEscaleraDescendente(int niveles) {
        for (int fila = niveles; fila >= 1; fila--) {
            mostrarLinea(fila); // Cada fila representa un nivel con números del 1 al valor de 'fila'
        }
    }

    // Método encargado de imprimir una línea de la escalera con formato "1.2.3..."
    public static void mostrarLinea(int hasta) {
        for (int numero = 1; numero <= hasta; numero++) {
            System.out.print(numero);
            if (numero < hasta) {
                System.out.print("."); // Agrega punto si no es el último número
            }
        }
        System.out.println(); // Salto de línea al terminar cada fila
    }
}
