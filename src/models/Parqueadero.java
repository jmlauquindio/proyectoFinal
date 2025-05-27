package models;
import java.util.ArrayList;
import java.util.LinkedList; 

public class Parqueadero {
    private String name;
    private String direccion;
    private String representante;
    private String telefonos;
    private String mediosContactos;
    private int espaciosMotos;
    private int espaciosAutomoviles;
    private int espaciosCamiones;
    private ArrayList<Cliente> clientes;

    public Parqueadero(String name, String direccion, String representante,String telefonos, String mediosContactos, int espaciosMotos, int espaciosAutomoviles, int espaciosCamiones) {
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
}