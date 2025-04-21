package controllers;

import java.util.ArrayList;

import models.Cliente;

public class Parqueadero {

		private ArrayList<Cliente> listasClientes;
		  
		public Parqueadero () {
			listasClientes = new ArrayList <> ();
		}
		
		public Boolean ingresarCliente (String name, String id,  int phone, String mail) {
			Cliente cliente = new Cliente (name, id, phone, mail);
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
		
}