package models;

public class Vehiculo {

	private String placa;
	private String tipoVehiculo;
	private String color;
	private String modelo;
	public Vehiculo(String placa, String tipoVehiculo, String color, String modelo) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.color = color;
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	} 

	
}
