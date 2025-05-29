package models;

import java.time.LocalDate;

public class Pagos {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double monto;
    private LocalDate fecha;
    private String tipo; 

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha +
               ", Cliente: " + (cliente != null ? cliente.getName() : "N/A") +
               ", Vehículo: " + (vehiculo != null ? vehiculo.getPlaca() : "N/A") +
               ", Tipo: " + tipo +
               ", Monto: $" + monto;
    }
}