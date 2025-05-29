package models;

import java.time.LocalDate;

public class Membresia {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costo;

    public Membresia() {
    }

    public Membresia(LocalDate fechaInicio, LocalDate fechaFin, double costo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
    }

    public boolean isMembresiasActivas() {
        return LocalDate.now().isBefore(fechaFin);
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setMonto(double monto) {
        this.costo = monto;
    }
}