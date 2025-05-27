package controllers;

import java.util.ArrayList;

import models.*;

public class ParqueaderoController {
	private ArrayList<Parqueadero> listasParqueaderos;
	public ParqueaderoController () {
		listasParqueaderos = new ArrayList <> ();
	}
	public Boolean actualizarDatos(String name, String newDireccion, String newRepresentante,String newTelefonos, String newMediosContactos, int newEspaciosMotos, int newEspaciosAutomoviles, int newEspaciosCamiones) {
		for (Parqueadero parqueadero: listasParqueaderos) {
			if (parqueadero.getName().equals(name)) {
				parqueadero.setDireccion(newDireccion);
				parqueadero.setRepresentante(newRepresentante);
				parqueadero.setTelefonos(newTelefonos);
				parqueadero.setMediosContactos(newMediosContactos);
				parqueadero.setEspaciosMotos(newEspaciosMotos);
				parqueadero.setEspaciosAutomoviles(newEspaciosAutomoviles);
				parqueadero.setEspaciosCamiones(newEspaciosCamiones);
				return true;
			}
		}
		return false;
	}

	public void puestosDisponibles() {
		
	}
	public void configurarTarifas() {
		
	}
	public void pagoPeriodo () {
		
	}
	public void historialPagos() {
		
	}
}