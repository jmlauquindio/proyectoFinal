package controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.*;

public class ParqueaderoController {
	
	private static ArrayList<Parqueadero> listasParqueaderos = new ArrayList<>();
	
	public ParqueaderoController () { 
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
	    StringBuilder sb = new StringBuilder();
	    for (Parqueadero parqueadero : listasParqueaderos) {
	        sb.append("Parqueadero: ").append(parqueadero.getName()).append("\n")
	          .append("Motos: ").append(parqueadero.getEspaciosMotos()).append("\n")
	          .append("Automóviles: ").append(parqueadero.getEspaciosAutomoviles()).append("\n")
	          .append("Camiones: ").append(parqueadero.getEspaciosCamiones()).append("\n\n");
	    }
	    JOptionPane.showMessageDialog(null, sb.toString(), "Puestos Disponibles", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void configurarTarifas() {
	    for (Parqueadero parqueadero : listasParqueaderos) {
	        String tarifaMoto = JOptionPane.showInputDialog("Tarifa para Moto:", parqueadero.getTarifaMoto());
	        String tarifaAuto = JOptionPane.showInputDialog("Tarifa para Automóvil:", parqueadero.getTarifaAutomovil());
	        String tarifaCamion = JOptionPane.showInputDialog("Tarifa para Camión:", parqueadero.getTarifaCamion());
	        try {
	            parqueadero.setTarifaMoto(Double.parseDouble(tarifaMoto));
	            parqueadero.setTarifaAutomovil(Double.parseDouble(tarifaAuto));
	            parqueadero.setTarifaCamion(Double.parseDouble(tarifaCamion));
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error en tarifas. Deben ser números.");
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Tarifas actualizadas.");
	}
	
	public static void pagoPeriodo() {
	    String[] opciones = {"1 mes", "3 meses", "1 año"};
	    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el período de pago:", "Pago por Período",
	            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
	    if (seleccion >= 0) {
	        JOptionPane.showMessageDialog(null, "Período seleccionado: " + opciones[seleccion]); 
	    }
	}
	
	public static void historialPagos() {
	    StringBuilder sb = new StringBuilder();
	    for (Parqueadero parqueadero : listasParqueaderos) {
	        sb.append("Parqueadero: ").append(parqueadero.getName()).append("\n");
	        for (Pagos pago : parqueadero.getPagos()) {  
	            sb.append(pago.toString()).append("\n");
	        }
	        sb.append("\n");
	    }
	    JOptionPane.showMessageDialog(null, sb.toString(), "Historial de Pagos", JOptionPane.INFORMATION_MESSAGE);
	}
	
}