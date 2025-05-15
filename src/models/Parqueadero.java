package models;

import java.util.ArrayList;
import java.util.LinkedList; 

public class Parqueadero {
    private String nombre;
    private String direccion;
    private String representante;
    private int espaciosMotos;
    private int espaciosAutomoviles;
    private int espaciosCamiones;
    private ArrayList<Cliente> clientes;

    public Parqueadero(String nombre, String direccion, String representante, int espaciosMotos, int espaciosAutomoviles, int espaciosCamiones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.representante = representante;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", direccion=" + direccion + ", representante=" + representante
                + ", espaciosMotos=" + espaciosMotos + ", espaciosAutomoviles=" + espaciosAutomoviles
                + ", espaciosCamiones=" + espaciosCamiones + "]";
    }

    public LinkedList<Cliente> obtenerClientesMenoresDeEdad() {
        LinkedList<Cliente> clientesMenores = new LinkedList<>();

        for (Cliente cliente : clientes) {
            if (cliente.getEdad() < 18) {
                clientesMenores.add(cliente);
            }
        }

        return clientesMenores;
    }
}