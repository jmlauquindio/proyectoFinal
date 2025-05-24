package controllers;

import java.util.ArrayList;

import models.Cliente;
import java.util.List; 

public class Parqueadero {

		private ArrayList<Cliente> listasClientes;
		  
		public Parqueadero () {
			listasClientes = new ArrayList <> ();
		}
		
		public Boolean ingresarCliente (String name, String id,  int phone, String mail, int edad) {
			Cliente cliente = new Cliente (name, id, phone, mail, edad);
			this.listasClientes.add (cliente);
			return true;
		}
		public void getlistaClientes () {
			for (Cliente e: listasClientes) {
				System.out.println (e.getName () + " " + e.getId());
				}
		}
		
		public Boolean eliminarCliente (String idCliente) {
		        return this.listasClientes.remove(idCliente);
		}
		

		public void buscarCliente () {
			for (Cliente e: listasClientes) { 
				
			}
		}
		public String getListaClientesComoTexto() {
			String clientes = "";
			for (Cliente e: listasClientes) {
				clientes = clientes + " <br> " + e.getName() + " " + e.getId();  
				}
			return clientes;
		}

		public String buscarClienteComoTexto(String id) {
		    for (Cliente cliente : listasClientes) { 
		        if (cliente.getId().equals(id)) {
		            return "Nombre: " + cliente.getName() +
		                   "\nID: " + cliente.getId() +
		                   "\nTeléfono: " + cliente.getPhone() +
		                   "\nCorreo: " + cliente.getMail() +
		                   "\nEdad: " + cliente.getEdad();
		        }
		    }
		    return null;
		}
}

