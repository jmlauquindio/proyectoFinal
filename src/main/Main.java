package main;

import controllers.Parqueadero;

public class Main {

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
         
        parqueadero.ingresarCliente("Juan Pérez", "12345", 300123456, "juanperez@mail.com");
        parqueadero.ingresarCliente("Ana Gómez", "67890", 300987654, "anagomez@mail.com");
         
        System.out.println("Lista de Clientes:");
        parqueadero.getlistaClientes();
    }
}
