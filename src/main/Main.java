package main;

import javax.swing.*;
import controllers.ClienteController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ClienteController cliente = new ClienteController();

        cliente.ingresarCliente("Juan Pérez", "12345", "3123142412", "juanperez@mail.com", 25);
        cliente.ingresarCliente("Ana Gómez", "67890", "231232142", "anagomez@mail.com", 17);

        mostrarMenu(cliente);
    }

    public static void mostrarMenu(ClienteController cliente) {
        SwingUtilities.invokeLater(() -> {
            String html = "<html style='height:100px;overflow:scroll;width:100vh;'>"
                    + "<h2 style='width:500px;background:#CDCDCD;color:white;padding:0 30px;'>Menú principal<br><small>Clientes:</h2>"
                    + "<p>" + cliente.getListaClientesComoTexto() + "</p>"
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
                    "Exportar clientes",
                    "Salir"
            };

            int opcion;

            do {
                opcion = JOptionPane.showOptionDialog(null, editorPane, "Menú Principal", JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                switch (opcion) {
                    case 0: agregarCliente(cliente); break;
                    case 1: listaClientes(cliente); break;
                    case 2: buscarCliente(cliente); break;
                    case 3: eliminarCliente(cliente); break;
                    case 4: exportarClientes(cliente); break;
                    default: break;
                }
            } while (opcion != 5 && opcion != JOptionPane.CLOSED_OPTION);
        });
    }

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
            String name = JOptionPane.showInputDialog("Ingrese el nombre del cliente a buscar:");
            if (name != null && !name.isBlank()) {
                String phone = JOptionPane.showInputDialog("Ingrese el número de teléfono del cliente a buscar:");
                if (phone != null && !phone.isBlank()) {
                    String info = clienteController.buscarClienteComoTexto(id, name, phone);
                    if (info != null && !info.isBlank()) {
                        JOptionPane.showMessageDialog(null, info, "Cliente encontrado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                }
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
}
