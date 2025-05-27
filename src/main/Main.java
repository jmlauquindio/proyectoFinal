package main;

import javax.swing.*;
import controllers.ClienteController;
import models.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static String nombreParqueadero = "Parqueadero Armenia"; 
    private static String direccionParqueadero = "Calle 123 #45-67";
    private static String telefonoParqueadero = "1234567890";
    private static String representanteParqueadero = "Julian Martinez"; 


    public static void main(String[] args) {
        ClienteController cliente = new ClienteController();

        cliente.ingresarCliente("Juan Pérez", "123", "3123142412", "juanperez@mail.com", 25);
        cliente.ingresarCliente("Ana Gómez", "321", "231232142", "anagomez@mail.com", 17);

        mostrarMenu(cliente);
    }

    public static void mostrarMenu(ClienteController cliente) {
        while (true) {
            String html = "<html style='height:100px;overflow:scroll;width:100vh;'>"
                    + "<div style='background:#2E4053;padding:20px;border-radius:10px;margin-bottom:10px;'>"
                    + "<h1 style='color:#F7DC6F;margin:0;'>" + nombreParqueadero + "</h1>"
                    + "<p style='color:#D6DBDF;margin:5px 0 0 0;'><b>Dirección:</b> " + direccionParqueadero + "</p>"
                    + "<p style='color:#D6DBDF;margin:0;'><b>Teléfono:</b> " + telefonoParqueadero + "</p>"
                    + "<p style='color:#D6DBDF;margin:0;'><b>Representante:</b> " + representanteParqueadero + "</p>"
                    + "</div>"
                    + "<h2 style='width:500px;background:#CDCDCD;color:#2E4053;padding:0 30px;border-radius:8px;'>Menú principal </h2>"
                    + "</html>";

            JEditorPane editorPane = new JEditorPane("text/html", html);
            editorPane.setEditable(false);
            editorPane.setOpaque(false);

            JScrollPane scrollPane = new JScrollPane(editorPane);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
            String[] opciones = {
                    "Agregar cliente",
                    "Listar clientes",
                    "Buscar cliente",
                    "Eliminar cliente",
                    "Ver vehículos del cliente",
                    "Buscar vehículo",
                    "Configuración",
                    "Exportar clientes",
                    "Salir"
            };

            int opcion = JOptionPane.showOptionDialog(null, editorPane, "Menú Principal", JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0: agregarCliente(cliente); break;
                case 1: listaClientes(cliente); break;
                case 2: buscarCliente(cliente); break;
                case 3: eliminarCliente(cliente); break;
                case 4: verVehiculosCliente(cliente); break;
                case 5: buscarVehiculo(cliente); break;
                case 6: configuracion(); continue;
                case 7: exportarClientes(cliente); break;
                case 8: 
                case JOptionPane.CLOSED_OPTION:
                    return; 
                default: break;
            }
        }
    }

    //Método para agregar clientes
    public static void agregarCliente(ClienteController clienteController) {
        JTextField name = new JTextField();
        JTextField id = new JTextField();
        JTextField phone = new JTextField();
        JTextField mail = new JTextField();
        JTextField age = new JTextField();

        Object[] campos = {
                "Nombre:", name,
                "ID:", id,
                "Teléfono:", phone,
                "Correo:", mail,
                "Edad:", age,
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                // Validaciones básicas
                if (name.getText().isBlank() || id.getText().isBlank() || phone.getText().isBlank() ||
                    mail.getText().isBlank() || age.getText().isBlank()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }

                int edad = Integer.parseInt(age.getText());
                if (edad <= 0) {
                    throw new IllegalArgumentException("La edad debe ser un número positivo.");
                }

                clienteController.ingresarCliente(
                        name.getText(),
                        id.getText(),
                        phone.getText(),
                        mail.getText(),
                        edad
                );
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Edad inválida. Debe ser un número.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.getMessage());
            }
        }
    }
    
    //Método para agregar Vehiculos
    public static void agregarVehiculo(ClienteController clienteController, String idCliente) {
        JTextField placa = new JTextField();
        JTextField tipo = new JTextField();
        JTextField color = new JTextField();
        JTextField modelo = new JTextField();

        Object[] campos = {
            "Placa:", placa,
            "Tipo (Automóvil/Moto/Camión):", tipo,
            "Color:", color,
            "Modelo:", modelo
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Agregar Vehículo", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                if (placa.getText().isBlank() || tipo.getText().isBlank() ||
                    color.getText().isBlank() || modelo.getText().isBlank()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }
                boolean agregado = clienteController.agregarVehiculoACliente(
                    idCliente,
                    placa.getText(), 
                    color.getText(),
                    modelo.getText()
                );
                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el vehículo.");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar vehículo: " + e.getMessage());
            }
        }
    }
    
    //Método para mostrar la lista de clientes
    public static void listaClientes(ClienteController clienteController) {
        SwingUtilities.invokeLater(() -> {
            String html = "<html style='height:100px;overflow:scroll'>"
                    + "<h2 style='width:500px;background:#CDCDCD;color:white;padding:0 30px;'>Listado de clientes:</h2>"
                    + "<p>" + clienteController.getListaClientesComoTexto() + "</p>"
                    + "</html>";

            JEditorPane editorPane = new JEditorPane("text/html", html);
            editorPane.setEditable(false);
            editorPane.setOpaque(false);

            JScrollPane scrollPane = new JScrollPane(editorPane);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

            JOptionPane.showMessageDialog(null, editorPane, "Lista de clientes", JOptionPane.PLAIN_MESSAGE);
        });
    }

    public static void buscarCliente(ClienteController clienteController) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a buscar:");
        if (id != null && !id.isBlank()) {
            String info = clienteController.buscarClienteComoTexto(id);
            if (info != null && !info.isBlank()) {
                String[] opciones = {"Actualizar datos", "Agregar vehículo", "Cerrar"};
                int opcion = JOptionPane.showOptionDialog(
                    null,
                    info,
                    "Cliente encontrado",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
                );
                if (opcion == 0) {
                    actualizarCliente(clienteController, id);
                } else if (opcion == 1) {
                    agregarVehiculo(clienteController, id);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        }
    }

	public static void actualizarCliente(ClienteController clienteController, String id) { 
	    Cliente cliente = clienteController.getClientePorId(id);
	    if (cliente == null) {
	        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
	        return;
	    }
	
	    JTextField name = new JTextField(cliente.getName());
	    JTextField phone = new JTextField(cliente.getPhone());
	    JTextField mail = new JTextField(cliente.getMail());
	    JTextField age = new JTextField(String.valueOf(cliente.getAge()));
	
	    Object[] campos = {
	        "Nombre:", name,
	        "Teléfono:", phone,
	        "Correo:", mail,
	        "Edad:", age,
	    };
	
	    int opcion = JOptionPane.showConfirmDialog(null, campos, "Actualizar Cliente", JOptionPane.OK_CANCEL_OPTION);
	    if (opcion == JOptionPane.OK_OPTION) {
	        try {
	            if (name.getText().isBlank() || phone.getText().isBlank() ||
	                mail.getText().isBlank() || age.getText().isBlank()) {
	                throw new IllegalArgumentException("Todos los campos son obligatorios.");
	            }
	            int edad = Integer.parseInt(age.getText());
	            if (edad <= 0) {
	                throw new IllegalArgumentException("La edad debe ser un número positivo.");
	            }
	            boolean actualizado = clienteController.actualizarCliente(
	                id,
	                name.getText(),
	                phone.getText(),
	                mail.getText(),
	                edad
	            );
	            if (actualizado) {
	                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo actualizar el cliente.");
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Edad inválida. Debe ser un número.");
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
	        }
	    }
	}

    public static void eliminarCliente(ClienteController clienteController) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:");
        if (id != null && !id.isBlank()) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean eliminado = clienteController.eliminarCliente(id);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }
            }
        }
    }

    public static void exportarClientes(ClienteController clienteController) {
        String datos = clienteController.getListaClientesComoTexto();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"))) {
            writer.write(datos);
            JOptionPane.showMessageDialog(null, "Clientes exportados correctamente a 'clientes.txt'.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al exportar clientes: " + e.getMessage());
        }
    }

    public static void buscarVehiculo(ClienteController clienteController) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");
        if (placa != null && !placa.isBlank()) {
        	
            // Busca el vehículo y el cliente al que pertenece
            Cliente cliente = clienteController.buscarClientePorVehiculo(placa);
            if (cliente != null) {
                models.Vehiculo vehiculo = cliente.getVehiculoPorPlaca(placa);
                if (vehiculo != null) {
                    String info = vehiculo.toString() + "\nPropietario: " + cliente.getName();
                    String[] opciones = {"Actualizar vehículo", "Cerrar"};
                    int opcion = JOptionPane.showOptionDialog(
                        null,
                        info,
                        "Vehículo encontrado",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                    );
                    if (opcion == 0) {
                        actualizarVehiculo(clienteController, cliente.getId(), placa);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            }
        }
    }
    
    public static void actualizarVehiculo(ClienteController clienteController, String idCliente, String placa) {
        Cliente cliente = clienteController.getClientePorId(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return;
        }
        models.Vehiculo vehiculo = cliente.getVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            return;
        }
 
        JTextField color = new JTextField(vehiculo.getColor());
        JTextField modelo = new JTextField(vehiculo.getModelo());

        Object[] campos = { 
            "Color:", color,
            "Modelo:", modelo
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Actualizar Vehículo", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                if ( color.getText().isBlank() || modelo.getText().isBlank()) {
                    throw new IllegalArgumentException("Todos los campos son obligatorios.");
                }
                boolean actualizado = clienteController.actualizarVehiculoDeCliente(
                    idCliente,
                    placa, 
                    color.getText(),
                    modelo.getText()
                );
                if (actualizado) {
                    JOptionPane.showMessageDialog(null, "Vehículo actualizado correctamente."); 
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el vehículo.");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar vehículo: " + e.getMessage());
            }
        }
    }
    public static void verVehiculosCliente(ClienteController clienteController) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente para ver sus vehículos:");
        if (id != null && !id.isBlank()) {
            String info = clienteController.getVehiculosClienteComoTexto(id);
            if (info != null && !info.isBlank()) {
                JOptionPane.showMessageDialog(null, info, "Vehículos del Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron vehículos para este cliente o el cliente no existe.");
            }
        }
    }
public static void configuracion() {
    JTextField nombre = new JTextField(nombreParqueadero);
    JTextField direccion = new JTextField(direccionParqueadero);
    JTextField telefono = new JTextField(telefonoParqueadero);
    JTextField representante = new JTextField(representanteParqueadero);

    Object[] campos = {
        "Nombre del parqueadero:", nombre,
        "Dirección:", direccion,
        "Teléfono:", telefono,
        "Representante:", representante
    };

    int opcion = JOptionPane.showConfirmDialog(null, campos, "Configuración del Parqueadero", JOptionPane.OK_CANCEL_OPTION);
    if (opcion == JOptionPane.OK_OPTION) {
        if (nombre.getText().isBlank() || direccion.getText().isBlank() ||
            telefono.getText().isBlank() || representante.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }
        nombreParqueadero = nombre.getText();
        direccionParqueadero = direccion.getText();
        telefonoParqueadero = telefono.getText();
        representanteParqueadero = representante.getText();
        JOptionPane.showMessageDialog(null, "Datos del parqueadero actualizados correctamente.");
    }
}
}
