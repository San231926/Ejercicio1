package Ejercicio1;

public class Comprador {
    private String nombre;
    private String email;
    private double presupuestoMaximo;

    public Comprador(String nombre, String email, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
}