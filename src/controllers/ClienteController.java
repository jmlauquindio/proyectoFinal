package controllers;

import java.util.ArrayList;
import models.*;

public class ClienteController {

    private ArrayList<Cliente> listasClientes;

    public ClienteController() {
        listasClientes = new ArrayList<>();
    }

    // Validación para evitar clientes duplicados por ID
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

    public String buscarClienteComoTexto(String id, String name, String phone) {
        for (Cliente cliente : listasClientes) {
            if (cliente.getId().equals(id)) {
                if (cliente.getName().equals(name)) {
                    if (cliente.getPhone().equals(phone)) {
                        return "Name: " + cliente.getName() +
                                "\nID: " + cliente.getId() +
                                "\nPhone: " + cliente.getPhone() +
                                "\nMail: " + cliente.getMail() +
                                "\nAge: " + cliente.getAge();
                    }
                }
            }
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

    public void vehiculosCliente() {
        // Por implementar: asociación de vehículos con cliente
    }
}