package models;

import java.util.ArrayList;

public class Vehiculo {
    private String placa;
    private TipoVehiculo TipoVehiculo; 
    private String color;
    private String modelo;
    private ArrayList<Cliente> clientes;

    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, String color, String modelo) {
        this.placa = placa;
        this.TipoVehiculo = tipoVehiculo;
        this.color = color;
        this.modelo = modelo;
        this.clientes = new ArrayList<>();
    } 
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
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

    public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	@Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", tipoVehiculo=" + TipoVehiculo + ", color=" + color + ", modelo=" + modelo + "]";
    }
	
}