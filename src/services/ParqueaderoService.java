package services;
import models.*;
import java.util.ArrayList;

public class ParqueaderoService {
    private ArrayList<Cliente> clientes;
    private int espaciosMotos;
    private int espaciosAutomoviles;
    private int espaciosCamiones;

    public ParqueaderoService(int espaciosMotos, int espaciosAutomoviles, int espaciosCamiones) {
        this.clientes = new ArrayList<>();
        this.espaciosMotos = espaciosMotos;
        this.espaciosAutomoviles = espaciosAutomoviles;
        this.espaciosCamiones = espaciosCamiones;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(String id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public boolean hayEspacioDisponible(String tipoVehiculo) {
        switch (tipoVehiculo) {
            case "MOTO":
                return espaciosMotos > 0;
            case "AUTOMOVIL":
                return espaciosAutomoviles > 0;
            case "CAMION":
                return espaciosCamiones > 0;
            default:
                return false;
        }
    }

    public void ocuparEspacio(String tipoVehiculo) {
        if (hayEspacioDisponible(tipoVehiculo)) {
            switch (tipoVehiculo) {
                case "MOTO":
                    espaciosMotos--;
                    break;
                case "AUTOMOVIL":
                    espaciosAutomoviles--;
                    break;
                case "CAMION":
                    espaciosCamiones--;
                    break;
            }
        }
    }

    public void liberarEspacio(String tipoVehiculo) {
        switch (tipoVehiculo) {
            case "MOTO":
                espaciosMotos++;
                break;
            case "AUTOMOVIL":
                espaciosAutomoviles++;
                break;
            case "CAMION":
                espaciosCamiones++;
                break;
        }
    }
}