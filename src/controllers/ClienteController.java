package controllers;

import java.util.ArrayList;
import models.*;

public class ClienteController {

    private ArrayList<Cliente> listasClientes;

    public ClienteController() {
        listasClientes = new ArrayList<>();
    }

    // Ingresar cliente junto con validación para evitar clientes duplicados por ID
    public Boolean ingresarCliente(String name, String id, String phone, String mail, int age) {
        for (Cliente c : listasClientes) {
            if (c.getId().equals(id)) {
                System.out.println("Ya existe un cliente con el mismo ID: " + id);
                return false;
            }
        }
        Cliente cliente = new Cliente(name, id, phone, mail, age);
        this.listasClientes.add(cliente);
        return true;
    }

    public void getlistaClientes() {
        for (Cliente e : listasClientes) {
            System.out.println(e.getName() + " " + e.getId());
        }
    }
    public ArrayList<Cliente> getClientes(){
    	return this.listasClientes;
    }

    public boolean eliminarCliente(String idCliente) {
        for (Cliente e : listasClientes) {
            if (e.getId().equals(idCliente)) {
                listasClientes.remove(e);
                return true;
            }
        }
        return false;
    }

    public String getListaClientesComoTexto() {
        String clientes = "";
        for (Cliente e : listasClientes) {
            clientes = clientes + " <br> " + e.getName() + " " + e.getId();
        }
        return clientes;
    }

    public String buscarClienteComoTexto(String id) {
        for (Cliente cliente : listasClientes) {
            if (cliente.getId().equals(id)) { 
                return "Name: " + cliente.getName() +
                        "\nID: " + cliente.getId() +
                        "\nPhone: " + cliente.getPhone() +
                        "\nMail: " + cliente.getMail() +
                        "\nAge: " + cliente.getAge();
            } 
        }
        return null;
    }
    public String buscarClientePorIdComoTexto(String id) {
        Cliente cliente = getClientePorId(id);
        if (cliente != null) {
            return cliente.toString();
        }
        return null;
    }
    public Boolean actualizarCliente(String name, String newId, String newPhone, String newMail, int newAge) {
        for (Cliente cliente : listasClientes) {
            if (cliente.getName().equals(name)) {
                cliente.setId(newId);
                cliente.setPhone(newPhone);
                cliente.setMail(newMail);
                cliente.setAge(newAge);
                return true;
            }
        }
        return false;
    }

    //   Obtener un cliente por su ID
    public Cliente getClientePorId(String id) {
        for (Cliente c : listasClientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    //Contar el total de clientes registrados
    public int contarClientes() {
        return listasClientes.size();
    }
    
    //Agregar vehiculo
    public boolean agregarVehiculoACliente(String idCliente, String placa, TipoVehiculo tipo, boolean membresia, String color, String modelo) {
        Cliente cliente = getClientePorId(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return false;
        }
        
        Parqueadero parqueadero = ParqueaderoController.listasParqueaderos.get(0);
        
        if (membresia) {
            switch (tipo) {
                case AUTOMOVIL:
                    if (parqueadero.getEspaciosAutomoviles() <= 0) {
                        JOptionPane.showMessageDialog(null, "No hay cupos para carros.");
                        return false;
                    }
                    parqueadero.setEspaciosAutomoviles(parqueadero.getEspaciosAutomoviles() - 1);
                    break;
                case MOTO:
                    if (parqueadero.getEspaciosMotos() <= 0) {
                        JOptionPane.showMessageDialog(null, "No hay cupos para motos.");
                        return false;
                    }
                    parqueadero.setEspaciosMotos(parqueadero.getEspaciosMotos() - 1);
                    break;
                case CAMION:
                    if (parqueadero.getEspaciosCamiones() <= 0) {
                        JOptionPane.showMessageDialog(null, "No hay cupos para camiones.");
                        return false;
                    }
                    parqueadero.setEspaciosCamiones(parqueadero.getEspaciosCamiones() - 1);
                    break;
            }
        }

        Vehiculo vehiculo = new Vehiculo(placa, color, modelo, membresia, tipo);
        cliente.getVehiculos().add(vehiculo);
        return true;
    }
    
    //Obtener información de vehiculos de un cliente
    public String getVehiculosClienteComoTexto(String idCliente) {
        Cliente cliente = getClientePorId(idCliente);  
        if (cliente != null) {
            return cliente.vehiculosComoTexto();  
        }
        return null;
    }
    public Cliente buscarClientePorVehiculo(String placa) {
        for (Cliente cliente : listasClientes) { 
            if (cliente.getVehiculoPorPlaca(placa) != null) {
                return cliente;
            }
        }
        return null;
    }

    public boolean actualizarVehiculoDeCliente(String idCliente, String placa, String color, String modelo) {
        Cliente cliente = getClientePorId(idCliente);
        if (cliente != null) {
            Vehiculo vehiculo = cliente.getVehiculoPorPlaca(placa);
            if (vehiculo != null) {
                vehiculo.setColor(color);
                vehiculo.setModelo(modelo);
                return true;
            }
        }
        return false;
    }
}