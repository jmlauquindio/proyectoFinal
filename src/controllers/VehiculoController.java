package controllers;
import java.util.ArrayList;
import models.*;

public class VehiculoController {

	private ArrayList<Vehiculo> listasVehiculos;
	
	public VehiculoController () {
		listasVehiculos = new ArrayList <> ();
		}
	
	public Boolean registrarVehiculo (String placa, tipoVehiculo tipoVehiculo, String color, String modelo) {
		Vehiculo vehiculo = new Vehiculo (placa, tipoVehiculo, color, modelo);
		this.listasVehiculos.add (vehiculo);
		return true;
	}
	public void getlistaVehiculo () {
		for (Vehiculo e: listasVehiculos) {
			System.out.println (e.getPlaca () + " " + e.getTipoVehiculo() + " " + e.getColor() +" " + e.getModelo());
			}
		}
	
	
	 public String buscarVehiculoComoTexto(String placa, TipoVehiculo tipoVehiculo, String Cliente) {
	    for (Vehiculo vehiculo : listasVehiculos) { 
	        if (vehiculo.getPlaca().equals(placa)) {
	        	if (vehiculo.getTipoVehiculo().equals(tipoVehiculo)) {
	        		if (vehiculo.getCliente()equals(Cliente)) {
	        			return "Placa: " + vehiculo.getPlaca() +
	                   "\nTipoVehiculo: " + vehiculo.getTipoVehiculo() +
	                   "\nCliente: " + vehiculo.getName();
	        		}
	        	}
	        }
	      }
	    return "Vehículo no encontrado.";
	 }
	
	 public Boolean actualizarVehiculo (String placa, tipoVehiculo newTipoVehiculo, String newColor, String newModelo) {
			for (Vehiculo vehiculo: listasVehiculos) {
				if (vehiculo.getPlaca().equals(placa)) {
					Vehiculo.setTipoVehiculo(newTipoVehiculo);
					Vehiculo.setColor(newColor);
					Vehiculo.setModelo(newModelo);
					return true;
				}
			}
			return false;
		}
}
