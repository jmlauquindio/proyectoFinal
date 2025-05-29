package models;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import interfaces.IParqueaderos; 

public class Parqueadero implements IParqueaderos {
	private String id;
    private String name;
    private String direccion;
    private String representante;
    private String telefonos;
    private String mediosContactos;
    private int espaciosMotos;
    private int espaciosAutomoviles;
    private int espaciosCamiones;
    private ArrayList<Cliente> clientes;
    private double tarifaMoto;
    private double tarifaAutomovil;
    private double tarifaCamion;
    private List<Pagos> pagos = new ArrayList<>();

    public Parqueadero(String id, String name, String direccion, String representante, String telefonos, String mediosContactos, int espaciosMotos, int espaciosAutomoviles, int espaciosCamiones) {
    	this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.representante = representante;
        this.telefonos = telefonos;
        this.mediosContactos = mediosContactos;
        this.espaciosMotos = espaciosMotos;
        this.espaciosAutomoviles = espaciosAutomoviles;
        this.espaciosCamiones = espaciosCamiones;
        this.clientes = new ArrayList<>();
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
    
    public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
    
    public int getEspaciosMotos() {
        return espaciosMotos;
    }
    
    public void setEspaciosMotos(int espaciosMotos) {
        this.espaciosMotos = espaciosMotos;
    }

    public int getEspaciosAutomoviles() {
        return espaciosAutomoviles;
    }

    public void setEspaciosAutomoviles(int espaciosAutomoviles) {
        this.espaciosAutomoviles = espaciosAutomoviles;
    }

    public int getEspaciosCamiones() {
        return espaciosCamiones;
    }

    public void setEspaciosCamiones(int espaciosCamiones) {
        this.espaciosCamiones = espaciosCamiones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }   
    
    public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getMediosContactos() {
		return mediosContactos;
	}

	public void setMediosContactos(String mediosContactos) {
		this.mediosContactos = mediosContactos;
	}

	public double getTarifaMoto() {
	    return tarifaMoto;
	}

	public double getTarifaAutomovil() {
	    return tarifaAutomovil;
	}

	public double getTarifaCamion() {
	    return tarifaCamion;
	}

	public void setTarifaMoto(double tarifaMoto) {
	    this.tarifaMoto = tarifaMoto;
	}

	public void setTarifaAutomovil(double tarifaAutomovil) {
	    this.tarifaAutomovil = tarifaAutomovil;
	}

	public void setTarifaCamion(double tarifaCamion) {
	    this.tarifaCamion = tarifaCamion;
	}

    public List<Pagos> getPagos() {
        return pagos;
    }

    public void addPago(Pagos pago) {
        pagos.add(pago);
    }

    public void setPagos(List<Pagos> pagos) {
        this.pagos = pagos;
    }
	
	@Override
    public String toString() {
        return "Parqueadero [name=" + name + ", direccion=" + direccion + ", representante=" + representante
                + ",telefonos" + telefonos + ", mediosContactos" + mediosContactos + ", espaciosMotos=" + espaciosMotos + ", espaciosAutomoviles=" + espaciosAutomoviles
                + ", espaciosCamiones=" + espaciosCamiones + "]";
    }

    public LinkedList<Cliente> obtenerClientesMenoresDeEdad() {
        LinkedList<Cliente> clientesMenores = new LinkedList<>();

        for (Cliente cliente : clientes) {
            if (cliente.getAge() < 18) {
                clientesMenores.add(cliente);
            }
        }

        return clientesMenores;
    }

	@Override
	public void configurarDatos(String name, String direccion, String representante, String telefonos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurarEspacios(TipoVehiculo tipoVehiculo, int cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurarTarifa(TipoVehiculo tipoVehiculo, double tarifaPorHora) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hayEspacioDisponible(TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ocuparEspacio(TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void liberarEspacio(TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getTarifa(TipoVehiculo tipoVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> getEspaciosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNaMe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTelefonoS() {
		// TODO Auto-generated method stub
		return null;
	} 
    

}