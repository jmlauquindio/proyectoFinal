package models;

import java.time.LocalDateTime;

public class Factura {
    private Vehiculo vehiculo;
    private LocalDateTime fecha;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;
    private double tarifaPorHora;
    private long horasCobradas;
    private double montoTotal;

    public Factura(Vehiculo vehiculo, LocalDateTime fecha, LocalDateTime horaIngreso, LocalDateTime horaSalida, double tarifaPorHora, long horasCobradas, double montoTotal) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.tarifaPorHora = tarifaPorHora;
        this.horasCobradas = horasCobradas;
        this.montoTotal = montoTotal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public double getTarifaPorHora() {
		return tarifaPorHora;
	}

	public void setTarifaPorHora(double tarifaPorHora) {
		this.tarifaPorHora = tarifaPorHora;
	}

	public long getHorasCobradas() {
		return horasCobradas;
	}

	public void setHorasCobradas(long horasCobradas) {
		this.horasCobradas = horasCobradas;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	@Override
    public String toString() {
        return "Factura vehiculo=" + vehiculo + ", horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ",tarifaPorHora=" + tarifaPorHora +", horasCobradas=" + horasCobradas + ", montoTotal=" + montoTotal;
	}


}