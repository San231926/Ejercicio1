package Ejercicio1;

public class Boleto {
    private String numero;
    private Localidad localidad;
    private Comprador comprador;

    public Boleto(String numero, Localidad localidad, Comprador comprador) {
        this.numero = numero;
        this.localidad = localidad;
        this.comprador = comprador;
    }

    public String getNumero() {
        return numero;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public Comprador getComprador() {
        return comprador;
    }
}