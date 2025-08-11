import java.util.Scanner;
import java.util.ArrayList;

public class CAJERO1 {

    public static void main(String[] args) {
        double[] saldo = {1500.00}; // Usamos arreglo para simular "referencia"
        ArrayList<String> historial = new ArrayList<>();
        iniciarSesion(saldo, historial);
    }

    public static void mostrarMenu() {
        System.out.println("\n1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
    }

    public static void consultarSaldo(double[] saldo, ArrayList<String> historial) {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo[0]);
        historial.add("\"Consulta de saldo\"");
    }

    public static void depositarDinero(double[] saldo, Scanner scanner, ArrayList<String> historial) {
        System.out.print("Ingrese el monto a depositar: Q");
        double monto = scanner.nextDouble();
        if (monto > 0) {
            saldo[0] += monto;
            System.out.println("Depósito exitoso.");
            historial.add("\"Depósito de Q" + String.format("%.2f", monto) + "\"");
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public static void retirarDinero(double[] saldo, Scanner scanner, ArrayList<String> historial) {
        System.out.print("Ingrese el monto a retirar: Q");
        double monto = scanner.nextDouble();
        if (monto > 0 && monto <= saldo[0]) {
            saldo[0] -= monto;
            System.out.println("Retiro exitoso.");
            historial.add("\"Retiro de Q" + String.format("%.2f", monto) + "\"");
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
    }

    public static void iniciarSesion(double[] saldo, ArrayList<String> historial) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido al Cajero Automático");

        do {
            mostrarMenu();
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo, historial);
                    break;
                case 2:
                    depositarDinero(saldo, scanner, historial);
                    break;
                case 3:
                    retirarDinero(saldo, scanner, historial);
                    break;
                case 4:
                    System.out.println("\nSaliendo...");
                    System.out.println("Historial de transacciones:");
                    for (String transaccion : historial) {
                        System.out.println(transaccion);
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
