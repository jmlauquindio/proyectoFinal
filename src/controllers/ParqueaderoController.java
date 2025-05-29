package controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.*;

public class ParqueaderoController {
	
	public static ArrayList<Parqueadero> listasParqueaderos = new ArrayList<>();
	
	public ParqueaderoController () { 
	}
	
    public Boolean ingresarParqueadero(String id, String name, String direccion, String representante, String telefonos, String mediosContactos, int espaciosMotos, int espaciosAutomoviles, int espaciosCamiones) {
        for (Parqueadero p : listasParqueaderos) {
            if (p.getId().equals(id)) {
                System.out.println("Ya existe un parqueadero con el mismo ID: " + id);
                return false;
            }
        }
        Parqueadero parqueadero = new Parqueadero(id, name, direccion, representante, telefonos, mediosContactos, espaciosMotos, espaciosAutomoviles, espaciosCamiones);
        ParqueaderoController.listasParqueaderos.add(parqueadero);
        return true;
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

	public static void puestosDisponibles() {

	    if (listasParqueaderos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay parqueaderos registrados.");
	        return;
	    }
	    
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

	    if (listasParqueaderos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No hay parqueaderos registrados.");
	        return;
	    }
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
		// Solicitar datos al usuario
		String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
		if (idCliente == null || idCliente.isBlank()) return;

		String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
		if (placa == null || placa.isBlank()) return;

		String[] opciones = {"1 mes", "3 meses", "1 año"};
		int seleccion = JOptionPane.showOptionDialog(
			null,
			"Seleccione el período de pago:",
			"Pago por Período",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE,
			null,
			opciones,
			opciones[0]
		);
		if (seleccion == JOptionPane.CLOSED_OPTION) return;

		// Determinar duración y monto
		int meses = (seleccion == 0) ? 1 : (seleccion == 1) ? 3 : 12;
		double monto = 0;
		double tarifa = 0;
		String tipoVehiculo = "";

		// Buscar el parqueadero 
		Parqueadero parqueadero = listasParqueaderos.get(0);

		// Buscar cliente y vehículo
		Cliente cliente = null;
		for (Cliente c : parqueadero.getClientes()) {
			if (c.getId().equals(idCliente)) {
				cliente = c;
				break;
			}
		}
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
			return;
		}
		Vehiculo vehiculo = cliente.getVehiculoPorPlaca(placa);
		if (vehiculo == null) {
			JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
			return;
		}
		tipoVehiculo = vehiculo.getTipoVehiculoString();

		// Determinar tarifa según tipo de vehículo
		switch (tipoVehiculo.toLowerCase()) {
			case "moto":
				tarifa = parqueadero.getTarifaMoto();
				break;
			case "automóvil":
			case "automovil":
				tarifa = parqueadero.getTarifaAutomovil();
				break;
			case "camión":
			case "camion":
				tarifa = parqueadero.getTarifaCamion();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido.");
				return;
		}
		monto = tarifa * meses;

		// Registrar membresía en el vehículo
		Membresia membresia = new Membresia();
		membresia.setFechaInicio(java.time.LocalDate.now());
		membresia.setFechaFin(java.time.LocalDate.now().plusMonths(meses));
		membresia.setMonto(monto);
		vehiculo.setMembresia(membresia);

		// Registrar pago
		Pagos pago = new Pagos();
		pago.setCliente(cliente);
		pago.setVehiculo(vehiculo);
		pago.setMonto(monto);
		pago.setFecha(java.time.LocalDate.now());
		pago.setTipo("Membresía " + meses + " mes(es)");

		parqueadero.addPago(pago);

		JOptionPane.showMessageDialog(null, "Pago registrado exitosamente.\nMonto: $" + monto + "\nMembresía activa hasta: " + membresia.getFechaFin());
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