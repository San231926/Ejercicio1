package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Localidad> localidades;
    private List<Boleto> boletos;
    private String fecha;
    private int contadorBoletos;

    public Sistema() {
        localidades = new ArrayList<>();
        boletos = new ArrayList<>();
        contadorBoletos = 0;
    }

    public void configurarSistema(String fecha, int capacidadTotal) {
        this.fecha = fecha;
        int capacidadPorLocalidad = capacidadTotal / 3;
        localidades.add(new Localidad("Localidad 1", capacidadPorLocalidad, 100));
        localidades.add(new Localidad("Localidad 5", capacidadPorLocalidad, 500));
        localidades.add(new Localidad("Localidad 10", capacidadPorLocalidad, 1000));
    }

    public Comprador agregarComprador(String nombre, String email, double presupuesto) {
        return new Comprador(nombre, email, presupuesto);
    }

    public List<Boleto> comprarBoletos(Comprador comprador, int localidadIndex, int cantidad) {
        if (localidadIndex < 0 || localidadIndex >= localidades.size()) {
            throw new IllegalArgumentException("Localidad inválida");
        }

        Localidad localidad = localidades.get(localidadIndex);
        if (localidad.getPrecio() > comprador.getPresupuestoMaximo()) {
            return new ArrayList<>(); // No se puede comprar
        }

        int boletosComprados = localidad.venderBoletos(Math.min(cantidad, 6));
        List<Boleto> boletosNuevos = new ArrayList<>();
        for (int i = 0; i < boletosComprados; i++) {
            Boleto boleto = new Boleto(generarNumeroBoleto(), localidad, comprador);
            boletos.add(boleto);
            boletosNuevos.add(boleto);
        }
        return boletosNuevos;
    }

    public String consultarDisponibilidadTotal() {
        StringBuilder sb = new StringBuilder();
        for (Localidad localidad : localidades) {
            sb.append(localidad.getNombre())
              .append(": ")
              .append(localidad.getDisponibilidad())
              .append(" boletos disponibles\n");
        }
        return sb.toString();
    }

    public String consultarDisponibilidadIndividual(int localidadIndex) {
        if (localidadIndex < 0 || localidadIndex >= localidades.size()) {
            return "Localidad inválida";
        }
        Localidad localidad = localidades.get(localidadIndex);
        return localidad.getNombre() + ": " + localidad.getDisponibilidad() + " boletos disponibles";
    }

    public String generarReporteCaja() {
        double total = 0;
        for (Boleto boleto : boletos) {
            total += boleto.getLocalidad().getPrecio();
        }
        return "Total recaudado: $" + total;
    }

    private String generarNumeroBoleto() {
        contadorBoletos++;
        return fecha + String.format("%03d", contadorBoletos);
    }
}
