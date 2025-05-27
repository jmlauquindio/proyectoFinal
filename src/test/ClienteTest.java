package test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Cliente;
import models.Parqueadero;

public class ClienteTest {

    @Test
    void testObtenerClientesMenoresDeEdad() {
        System.out.println("Inicia test obtenerListadoMenoresEdad");

        Parqueadero parqueadero = new Parqueadero("Central", "Calle 1", "Jhonatan", "3053159653", "WhatsApp:3053159653, correo: parquedeor.central@gmail.com",10, 10, 5);
        Cliente luis = new Cliente("Luis", "1", "123", "luis@mail.com", 20);
        Cliente juan = new Cliente("Juan", "2", "456", "juan@mail.com", 17);
        Cliente camilo = new Cliente("Camilo", "3", "789", "camilo@mail.com", 15);
        
        parqueadero.registrarCliente(luis);
        parqueadero.registrarCliente(juan);
        parqueadero.registrarCliente(camilo);

        List<Cliente> listaEsperada = List.of(juan, camilo);

        // assertIterableEquals
        assertIterableEquals(listaEsperada, parqueadero.obtenerClientesMenoresDeEdad());

        System.out.println("Finalización obtenerListadoMenoresEdad");
    }

    @Test
    void testClienteDatosVacios() {
        System.out.println("Inicia test ClienteDatosVacios");
        // assertThrows
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("", "", "", "", 0);
        });
        System.out.println("Finalización ClienteDatosVacios");
    }

    @Test
    void testListaClientes() {
        System.out.println("Inicia test ListaClientes");
        Cliente c1 = new Cliente("Ana", "1", "123", "a@mail.com", 18);
        Cliente c2 = new Cliente("Isabela", "2", "456", "i@bmail.com", 18);
        Cliente c3 = new Cliente("Jorge Mario", "3", "789", "j@mail.com", 28);

        Parqueadero parqueadero = new Parqueadero("Central", "Calle 1", "Jhonatan","3053159653", "WhatsApp:3053159653, correo: parquedeor.central@gmail.com", 10, 10, 5);
        parqueadero.registrarCliente(c1);
        parqueadero.registrarCliente(c2);
        parqueadero.registrarCliente(c3);

        List<Cliente> expected = Arrays.asList(c1, c2, c3);
        // assertIterableEquals
        assertIterableEquals(expected, parqueadero.getClientes());
        System.out.println("Finalización ListaClientes");
    }

    @Test
    void testCantidadClientes() {
        System.out.println("Inicia test CantidadClientes");
        Parqueadero parqueadero = new Parqueadero("Central", "Calle 1", "Jhonatan", "3053159653", "WhatsApp:3053159653, correo: parquedeor.central@gmail.com", 10, 10, 5);
        parqueadero.registrarCliente(new Cliente("Ana", "1", "123", "a@mail.com", 18));
        parqueadero.registrarCliente(new Cliente("Isabela", "2", "456", "i@bmail.com", 18));
        // assertTrue
        assertTrue(parqueadero.getClientes().size() == 2);
        System.out.println("Finalización CantidadClientes");
    }
}