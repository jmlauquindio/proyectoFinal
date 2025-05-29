package controllers;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import models.*;

public class VehiculoController {

	private ArrayList<Vehiculo> listasVehiculos;
	
	public VehiculoController () {
		listasVehiculos = new ArrayList <> ();
		}
	
public Boolean registrarVehiculo(String placa, String color, String modelo, Object membresia, TipoVehiculo tipoVehiculo) {
    Vehiculo vehiculo;
    if (tipoVehiculo == TipoVehiculo.AUTOMOVIL) {
        vehiculo = new Automovil(placa, color, modelo, membresia, tipoVehiculo);
    } else if (tipoVehiculo == TipoVehiculo.MOTO) {
        vehiculo = new Moto(placa, color, modelo, membresia, tipoVehiculo);
    } else if (tipoVehiculo == TipoVehiculo.CAMION) {
        vehiculo = new Camion(placa, color, modelo, membresia, tipoVehiculo);
    } else {
        vehiculo = new Vehiculo(placa, color, modelo, membresia, tipoVehiculo);
    }
    this.listasVehiculos.add(vehiculo);
    return true;
}
	public void getlistaVehiculo () {
		for (Vehiculo e: listasVehiculos) {
			System.out.println (e.getPlaca () + " " + e.getColor() +" " + e.getModelo());
			}
		}

	public String buscarVehiculoComoTexto(Cliente clientes, String placa, TipoVehiculo tipoVehiculo) {
	    for (Vehiculo vehiculo : listasVehiculos) { 
	        if (vehiculo.getPlaca().equals(placa)) {
	        	if (vehiculo.getClientes().equals(clientes)) {
	        		if (vehiculo.getTipoVehiculo().equals(tipoVehiculo))
	        			return "Placa: " + vehiculo.getPlaca() + 
	                   "\nCliente: " + vehiculo.getClientes(); 
	        }
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

    // control de espacios disponibles
    private Map<String, Integer> espaciosDisponibles = new HashMap<>();
    private Map<String, Double> tarifasPorHora = new HashMap<>();
    
    public void configurarEspacios(String tipoVehiculo, int cantidad) {
        espaciosDisponibles.put(tipoVehiculo, cantidad);
    }

    public void configurarTarifa(String tipoVehiculo, double tarifa) {
        tarifasPorHora.put(tipoVehiculo, tarifa);
    }

    // registro de ingreso de vehículos temporales
    private Map<String, LocalDateTime> ingresosTemporales = new HashMap<>();
 
    public boolean ingresosVehiculosTemporales(String placa, String color, String modelo, String tipoVehiculo) {
        int espacios = espaciosDisponibles.getOrDefault(tipoVehiculo, 0);
        if (espacios <= 0) {
            JOptionPane.showMessageDialog(null, "No hay espacios disponibles para este tipo de vehículo.");
            return false;
        }
        espaciosDisponibles.put(tipoVehiculo, espacios - 1);
        ingresosTemporales.put(placa, LocalDateTime.now());
        String mensaje = "Ingreso de vehículo temporal:\n"
                + "Placa: " + placa
                + "\nColor: " + color
                + "\nModelo: " + modelo
                + "\nTipo: " + tipoVehiculo
                + "\nHora de ingreso: " + LocalDateTime.now();
        JOptionPane.showMessageDialog(null, mensaje);
        return true;
    }

    public void salidaVehiculoTemporal(String placa, String tipoVehiculo, String nombreParqueadero, String direccion, String representante, String telefonos) {
        LocalDateTime horaIngreso = ingresosTemporales.get(placa);
        if (horaIngreso == null) {
            JOptionPane.showMessageDialog(null, "No se encontró registro de ingreso para la placa: " + placa);
            return;
        }
        LocalDateTime horaSalida = LocalDateTime.now();
        Duration duracion = Duration.between(horaIngreso, horaSalida);
        long horas = duracion.toHours();
        if (duracion.toMinutes() % 60 != 0) {
            horas++;
        }
        double tarifa = tarifasPorHora.getOrDefault(tipoVehiculo, 0.0);
        double monto = tarifa * horas;
        int espacios = espaciosDisponibles.getOrDefault(tipoVehiculo, 0);
        espaciosDisponibles.put(tipoVehiculo, espacios + 1);
        ingresosTemporales.remove(placa);

        generarFacturaTemporal(placa, tipoVehiculo, nombreParqueadero, direccion, representante, telefonos, horaIngreso, horaSalida, horas, tarifa, monto);
        }

    public static String generarFacturaTemporal(String placa, String tipoVehiculo, String nombreParqueadero, String direccion, String representante, String telefonos, LocalDateTime horaIngreso, LocalDateTime horaSalida, long horas, double tarifa, double monto) {

        String factura = "----- FACTURA PARQUEADERO -----\n"
                + "Parqueadero: " + nombreParqueadero + "\n"
                + "Dirección: " + direccion + "\n"
                + "Representante: " + representante + "\n"
                + "Teléfonos: " + telefonos + "\n"
                + "------------------------------\n"
                + "Placa: " + placa + "\n"
                + "Tipo: " + tipoVehiculo + "\n"
                + "Hora ingreso: " + horaIngreso + "\n"
                + "Hora salida: " + horaSalida + "\n"
                + "Horas cobradas: " + horas + "\n"
                + "Tarifa por hora: $" + tarifa + "\n"
                + "Total a pagar: $" + monto + "\n"
                + "------------------------------";

        JOptionPane.showMessageDialog(null, factura);
        return factura;
    }
	
	 public ArrayList<Vehiculo> historialVehiculosPorCliente(Cliente cliente) {
	     ArrayList<Vehiculo> historial = new ArrayList<>();
	     for (Vehiculo v : listasVehiculos) {
	         if (v.getClientes().equals(cliente)) {
	             historial.add(v);
	         }
	     }
	     return historial;
	 }
	
	 private ArrayList<Factura> facturas = new ArrayList<>(); 
	
	 public double totalIngresosPorPeriodo(int year, int month, int day) {
	     double total = 0;
	     for (Factura f : facturas) {
	         LocalDateTime fecha = f.getFecha();
	         if ((year == 0 || fecha.getYear() == year) &&
	             (month == 0 || fecha.getMonthValue() == month) &&
	             (day == 0 || fecha.getDayOfMonth() == day)) {
	             total += f.getMontoTotal();
	         }
	     }
	     return total;
	 }
	
	 public ArrayList<String> vehiculosActualesEnParqueadero() {
	     ArrayList<String> actuales = new ArrayList<>();
	     actuales.addAll(ingresosTemporales.keySet());
	     if (membresiasActivas != null) {
	         actuales.addAll(membresiasActivas.keySet());
	     }
	     return actuales;
	 }
	
	 public ArrayList<Cliente> isMembresiasActivas() {
		 	ArrayList<Cliente> clientes = new ArrayList<>();
		 	for (Vehiculo v : listasVehiculos) {
		 		if (v.getMembresia() != null && v.getMembresia().isMembresiasActivas()) {
		 			Cliente c = v.getClientes();
   	            if (!clientes.contains(c)) {
   	            	clientes.add(c);
   	            }
	 		}
	 	}
		 return clientes;
    }
} 
