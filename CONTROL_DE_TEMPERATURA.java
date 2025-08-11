import java.util.Scanner;
public class CONTROL_DE_TEMPERATURA {

        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);

            double[] registros = new double[7]; // Arreglo para almacenar temperaturas de cada día de la semana
            String[] nombresDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
            boolean datosCargados = false; // Indicador para saber si ya se ingresaron temperaturas

            while (true) {
                System.out.println("\n=== Menú Principal ===");
                System.out.println("1. Ingresar temperaturas semanales");
                System.out.println("2. Ver temperaturas registradas");
                System.out.println("3. Mostrar temperatura más alta");
                System.out.println("4. Calcular suma total (usando recursividad)");
                System.out.println("5. Salir del programa");
                System.out.print("Seleccione una opción (1-5): ");

                int opcionSeleccionada = entrada.nextInt();

                switch (opcionSeleccionada) {
                    case 1: // Ingreso de temperaturas
                        System.out.println("\nIngrese la temperatura correspondiente a cada día:");
                        for (int i = 0; i < registros.length; i++) {
                            System.out.print(nombresDias[i] + ": ");
                            registros[i] = entrada.nextDouble();
                        }
                        datosCargados = true;
                        System.out.println(">> Temperaturas ingresadas correctamente.");
                        break;

                    case 2: // Mostrar temperaturas
                        if (!datosCargados) {
                            System.out.println(">> No hay temperaturas cargadas aún.");
                        } else {
                            imprimirTemperaturas(registros, nombresDias);
                        }
                        break;

                    case 3: // Mostrar temperatura máxima
                        if (!datosCargados) {
                            System.out.println(">> No hay datos disponibles.");
                        } else {
                            double maxTemp = obtenerTemperaturaMaxima(registros);
                            int diaMaximo = obtenerIndiceMaximo(registros);
                            mostrarTemperaturaMaxima(maxTemp); // Mostrar solo el valor
                            mostrarTemperaturaMaxima(maxTemp, nombresDias[diaMaximo]); // Mostrar con el día
                        }
                        break;

                    case 4: // Sumar temperaturas recursivamente
                        if (!datosCargados) {
                            System.out.println(">> No se han ingresado datos aún.");
                        } else {
                            double total = sumarTemperaturasRecursivo(registros, 0);
                            System.out.println(">> Suma total de temperaturas (método recursivo): " + total + "°C");
                        }
                        break;

                    case 5: // Salida del programa
                        System.out.println("Finalizando el programa. ¡Hasta luego!");
                        entrada.close();
                        return;

                    default:
                        System.out.println(">> Opción inválida. Intente nuevamente con un número entre 1 y 5.");
                }
            }
        }

        // Procedimiento para imprimir todas las temperaturas junto con su día correspondiente
        public static void imprimirTemperaturas(double[] temperaturas, String[] diasSemana) {
            System.out.println("\n=== Registro de Temperaturas ===");
            for (int i = 0; i < temperaturas.length; i++) {
                System.out.println(diasSemana[i] + ": " + temperaturas[i] + "°C");
            }
        }

        // Función que retorna la temperatura más alta en el arreglo
        public static double obtenerTemperaturaMaxima(double[] temperaturas) {
            double maxima = temperaturas[0];
            for (double temp : temperaturas) {
                if (temp > maxima) {
                    maxima = temp;
                }
            }
            return maxima;
        }

        // Procedimiento sobrecargado para mostrar la temperatura máxima sin indicar el día
        public static void mostrarTemperaturaMaxima(double temperatura) {
            System.out.println("\n>> Temperatura más alta registrada: " + temperatura + "°C");
        }

        // Procedimiento sobrecargado para mostrar la temperatura máxima e incluir el día correspondiente
        public static void mostrarTemperaturaMaxima(double temperatura, String dia) {
            System.out.println(">> Temperatura más alta (" + dia + "): " + temperatura + "°C");
        }

        // Método recursivo para sumar todos los valores del arreglo de temperaturas
        public static double sumarTemperaturasRecursivo(double[] temperaturas, int posicion) {
            if (posicion == temperaturas.length) {
                return 0;
            }
            return temperaturas[posicion] + sumarTemperaturasRecursivo(temperaturas, posicion + 1);
        }

        // Función que devuelve el índice donde se encuentra la temperatura más alta
        public static int obtenerIndiceMaximo(double[] temperaturas) {
            int indice = 0;
            for (int i = 1; i < temperaturas.length; i++) {
                if (temperaturas[i] > temperaturas[indice]) {
                    indice = i;
                }
            }
            return indice;
        }
    }



