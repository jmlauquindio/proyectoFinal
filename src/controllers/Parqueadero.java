package controllers;

import java.util.ArrayList;

import models.Cliente; 

public class Parqueadero {

		private ArrayList<Cliente> listasClientes;
		  
		public Parqueadero () {
			listasClientes = new ArrayList <> ();
		}
		
		public Boolean ingresarCliente (String name, String id,  String phone, String mail, int edad) {
			Cliente cliente = new Cliente (name, id, phone, mail, edad);
			this.listasClientes.add (cliente);
			return true;
		}
		public void getlistaClientes () {
			for (Cliente e: listasClientes) {
				System.out.println (e.getName () + " " + e.getId());
				}
		}
		
		public Boolean eliminarCliente (ArrayList<String> listaClientes, String idCliente) {
		        return listaClientes.remove(idCliente);
		}
		


		public String getListaClientesComoTexto(String name) {
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
		        			return "Nombre: " + cliente.getName() +
		                   "\nID: " + cliente.getId() +
		                   "\nTeléfono: " + cliente.getPhone() +
		                   "\nCorreo: " + cliente.getMail() +
		                   "\nEdad: " + cliente.getEdad();
		        		}
		        	}
		        }
		    }
		    
		    return null;
		}
}

