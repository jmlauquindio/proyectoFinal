package test; 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import models.Parqueadero;

public class ParqueaderoTest {

    //assertEquals
    @Test
    void testNombreParqueadero() {
        Parqueadero parqueadero = new Parqueadero("Central", "Calle 1", "Jhonatan", "3053159653", "WhatsApp:3053159653, correo: parquedeor.central@gmail.com", 10, 10, 5);
        assertEquals("Central", parqueadero.getName());
    }
    
}