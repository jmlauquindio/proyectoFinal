package services;

import models.Membresia;
import java.time.Duration;
import java.time.LocalDateTime;

public class PagoService {

    public double calcularPagoPorHoras(LocalDateTime horaEntrada, LocalDateTime horaSalida, double tarifaPorHora) {
        long horas = Duration.between(horaEntrada, horaSalida).toHours();
        return horas * tarifaPorHora;
    }

    public double calcularPagoMembresia(Membresia membresia) {
        return membresia.getCosto();
    }
}