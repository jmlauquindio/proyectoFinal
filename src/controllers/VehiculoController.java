package controllers;
import java.util.ArrayList;
import models.*;

public class VehiculoController {

	private ArrayList<Vehiculo> listasVehiculos;
	
	public VehiculoController () {
		listasVehiculos = new ArrayList <> ();
		}
	
	public Boolean registrarVehiculo (String placa,  String color, String modelo, Object membresia) {
		Vehiculo vehiculo = new Vehiculo (placa, color, modelo, membresia);
		this.listasVehiculos.add (vehiculo);
		return true;
	}
	public void getlistaVehiculo () {
		for (Vehiculo e: listasVehiculos) {
			System.out.println (e.getPlaca () + " " + e.getColor() +" " + e.getModelo());
			}
		}
	
	

	public String buscarVehiculoComoTexto(Cliente clientes, String placa, String Cliente) {
	    for (Vehiculo vehiculo : listasVehiculos) { 
	        if (vehiculo.getPlaca().equals(placa)) {  
	        			return "Placa: " + vehiculo.getPlaca() + 
	                   "\nCliente: " + vehiculo.getClientes(); 
	        }
	      }
	    return "Vehículo no encontrado.";
	 }
	
	 public Boolean actualizarVehiculo (Cliente clientes, String newPlaca, String newColor, String newModelo) {
			for (Vehiculo vehiculo: listasVehiculos) {
				if (vehiculo.getClientes().equals(clientes)) {
					vehiculo.setPlaca(newPlaca); 
					vehiculo.setColor(newColor);
					vehiculo.setModelo(newModelo);
					return true;
				}
			}
			return false;
		}
}
