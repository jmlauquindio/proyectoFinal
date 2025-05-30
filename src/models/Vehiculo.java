package models;

import java.util.ArrayList;

public class Vehiculo{
	protected String placa;
	protected String color;
    protected String modelo;
    protected ArrayList<Cliente> clientes;
    protected Object membresia; 
    protected TipoVehiculo tipoVehiculo;

	public Vehiculo(String placa, String color, String modelo, Object membresia,TipoVehiculo tipoVehiculo) {
        this.placa = placa; 
        this.color = color;
        this.modelo = modelo;
        this.clientes = new ArrayList<>();
        this.membresia = membresia;
        this.tipoVehiculo = tipoVehiculo;
	}
	public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
	
	public Object getMembresia() {
		return membresia;
	}
	
	public void setMembresia (Membresia membresia) {
		this.membresia = membresia;
	}
	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getTipoVehiculoString() {
		return ""+tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	@Override
    public String toString() {
        return "Vehiculo placa=" + placa + ", color=" + color + ", modelo=" + modelo + ",tipovehiculo=" + tipoVehiculo;
	}

}