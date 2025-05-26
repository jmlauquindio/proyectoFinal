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
	
	
	 public String buscarVehiculoComoTexto(String placa, tipoVehiculo tipoVehiculo, String Cliente) {
	    for (Vehiculo vehiculo : listasVehiculos) { 
	        if (Vehiculo.getPlaca().equals(placa)) {
	        	if (Vehiculo.getTipoVehiculo().equals(tipoVehiculo)) {
	        		if (Vehiculo.cliente()equals(cliente)) {
	        			return "Placa: " + Vehiculo.getPlaca() +
	                   "\nTipoVehiculo: " + Vehiculo.getTipoVehiculo() +
	                   "\nCliente: " + Vehiculo.cliente();
	        		}
	        	}
	        }
	      }
	    return null;
	}
	 
	 public Boolean actualizarVehiculo (String placa, tipoVehiculo newTipoVehiculo, String newColor, String newModelo) {
			for (Vehiculo c: listasVehiculos) {
				if (c.getPlaca().equals(placa)) {
					Vehiculo.setTipoVehiculo(newTipoVehiculo);
					Vehiculo.setColor(newColor);
					Vehiculo.setModelo(newModelo);
					return true;
				}
			}
			return false;
		}
}
