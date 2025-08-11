import java.util.Scanner;

public class SISTEMA_EVALUACION {

    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    public static boolean estaAprobado(char literal) {
        return literal == 'A' || literal == 'B' || literal == 'C';
    }

    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        boolean aprobado = estaAprobado(literal);

        System.out.println("\nEstudiante: " + nombre);
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println("\nPromedio: " + promedio);
        System.out.println("Literal: " + literal);
        System.out.println("Resultado: " + (aprobado ? "Aprobado" : "Reprobado"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la cantidad de notas: ");
        int cantidadNotas = sc.nextInt();

        double[] notas = new double[cantidadNotas];

        for (int i = 0; i < cantidadNotas; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }

        mostrarResultado(nombre, notas);
    }
}
