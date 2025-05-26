package controllers;

import java.util.ArrayList;

import models.Cliente;

public class ClienteController {

			private ArrayList<Cliente> listasClientes;
			  
			public ClienteController () {
				listasClientes = new ArrayList <> ();
			}
			
			public Boolean ingresarCliente (String name, String id,  String phone, String mail, int age) {
				Cliente cliente = new Cliente (name, id, phone, mail, age);
				this.listasClientes.add (cliente);
				return true;
			}
			public void getlistaClientes () {
				for (Cliente e: listasClientes) {
					System.out.println (e.getName () + " " + e.getId());
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
				for (Cliente e: listasClientes) {
					clientes = clientes + " <br> " + e.getName() + " " + e.getId();  
					}
				return clientes;
			}

			public String buscarClienteComoTexto(String id, String name, String phone) {
			    for (Cliente cliente : listasClientes) { 
			        if (cliente.getId().equals(id)) {
			        	if (cliente.getName ().equals(name)) {
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
			public Boolean actualizarCliente (String name, String newId, String newPhone, String newMail, int newAge) {
				for (Cliente c: listasClientes) {
					if (c.getName().equals(name)) {
						Cliente.setId(newId);
						Cliente.setPhone(newPhone);
						Cliente.setMail(newMail);
						Cliente.setAge(newAge);
						return true;
					}
				}
				return false;
			}
			
			public void vehiculosCliente () {
			}
			
}