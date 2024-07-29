package Ejercicio1;

public class Localidad {
    private String nombre;
    private int capacidad;
    private int boletosVendidos;
    private double precio;

    public Localidad(String nombre, int capacidad, double precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.boletosVendidos = 0;
    }

    public int getDisponibilidad() {
        return capacidad - boletosVendidos;
    }

    public int venderBoletos(int cantidad) {
        int disponibles = getDisponibilidad();
        int aVender = Math.min(cantidad, disponibles);
        boletosVendidos += aVender;
        return aVender;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}