package controllers;
import java.util.ArrayList;
import models.*;

public class VehiculoController {

	private ArrayList<Vehiculo> listasVehiculos;
	
	public VehiculoController () {
		listasVehiculos = new ArrayList <> ();
		}
	
	public Boolean registrarVehiculo (String placa, TipoVehiculo tipoVehiculo, String color, String modelo, models.Membresia membresia) {
		Vehiculo vehiculo = new Vehiculo (placa, tipoVehiculo, color, modelo, membresia);
		this.listasVehiculos.add (vehiculo);
		return true;
	}
	public void getlistaVehiculo () {
		for (Vehiculo e: listasVehiculos) {
			System.out.println (e.getPlaca () + " " + e.getTipoVehiculo() + " " + e.getColor() +" " + e.getModelo());
			}
		}
	
	

	public String buscarVehiculoComoTexto(Cliente clientes, String placa, TipoVehiculo tipoVehiculo, String Cliente) {
	    for (Vehiculo vehiculo : listasVehiculos) { 
	        if (vehiculo.getPlaca().equals(placa)) {
	        	if (vehiculo.getTipoVehiculo().equals(tipoVehiculo)) {
	        		if (vehiculo.getClientes().equals(clientes)) {
	        			return "Placa: " + vehiculo.getPlaca() +
	                   "\nTipoVehiculo: " + vehiculo.getTipoVehiculo() +
	                   "\nCliente: " + vehiculo.getClientes();
	        		}
	        	}
	        }
	      }
	    return "Vehículo no encontrado.";
	 }
	
	 public Boolean actualizarVehiculo (Cliente clientes, String newPlaca, TipoVehiculo newTipoVehiculo, String newColor, String newModelo) {
			for (Vehiculo vehiculo: listasVehiculos) {
				if (vehiculo.getClientes().equals(clientes)) {
					vehiculo.setPlaca(newPlaca);
					vehiculo.setTipoVehiculo(newTipoVehiculo);
					vehiculo.setColor(newColor);
					vehiculo.setModelo(newModelo);
					return true;
				}
			}
			return false;
		}
}
