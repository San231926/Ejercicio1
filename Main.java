package Ejercicio1;

import java.util.List;
import java.util.Scanner;

    

public class Main {

    static int bandera = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        System.out.println("Configuración inicial del sistema");
        System.out.print("Ingrese la fecha (AAAAMMDD): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese la capacidad total del lugar: ");
        int capacidadTotal = Integer.parseInt(scanner.nextLine());

        sistema.configurarSistema(fecha, capacidadTotal);

        while (bandera!=1) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar comprador");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Generar reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                agregarComprador(scanner, sistema);
            } else if (opcion == 2) {
                comprarBoletos(scanner, sistema);
            } else if (opcion == 3) {
                System.out.println(sistema.consultarDisponibilidadTotal());
            } else if (opcion == 4) {
                consultarDisponibilidadIndividual(scanner, sistema);
            } else if (opcion == 5) {
                System.out.println(sistema.generarReporteCaja());
            } else if (opcion == 6) {
                System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                bandera = 1;
                return;
            } else {
                System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
            
        }
    }

    private static void agregarComprador(Scanner scanner, Sistema sistema) {
        System.out.print("Ingrese el nombre del comprador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del comprador: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el presupuesto máximo del comprador: ");
        double presupuesto = Double.parseDouble(scanner.nextLine());

        Comprador comprador = sistema.agregarComprador(nombre, email, presupuesto);
        System.out.println("Comprador agregado: " + comprador.getNombre());
    }

    private static void comprarBoletos(Scanner scanner, Sistema sistema) {
        System.out.print("Ingrese el nombre del comprador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del comprador: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el presupuesto máximo del comprador: ");
        double presupuesto = Double.parseDouble(scanner.nextLine());

        Comprador comprador = sistema.agregarComprador(nombre, email, presupuesto);

        System.out.print("Ingrese el número de la localidad (0-2): ");
        int localidad = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        List<Boleto> boletosComprados = sistema.comprarBoletos(comprador, localidad, cantidad);
        if (boletosComprados.isEmpty()) {
            System.out.println("No se pudieron comprar boletos.");
        } else {
            System.out.println("Se compraron " + boletosComprados.size() + " boletos.");
            for (Boleto boleto : boletosComprados) {
                System.out.println("Boleto #" + boleto.getNumero());
            }
        }
    }

    private static void consultarDisponibilidadIndividual(Scanner scanner, Sistema sistema) {
        System.out.print("Ingrese el número de la localidad (0-2): ");
        int localidad = Integer.parseInt(scanner.nextLine());
        System.out.println(sistema.consultarDisponibilidadIndividual(localidad));
    }
}
