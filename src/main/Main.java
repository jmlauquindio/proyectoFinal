package main;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import controllers.Parqueadero;

public class Main {

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
         
        parqueadero.ingresarCliente("Juan Pérez", "12345", 300123456, "juanperez@mail.com", 25);
        parqueadero.ingresarCliente("Ana Gómez", "67890", 300987654, "anagomez@mail.com", 17);

        mostrarMenu(parqueadero);
    }

    public static void mostrarMenu(Parqueadero parqueadero) {
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
            opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (opcion) {
                case 0: agregarCliente(parqueadero); break;
                case 1: listaClientes(parqueadero); break;
                case 2: buscarCliente(parqueadero); break;
                case 3: eliminarCliente(parqueadero); break;
                case 4: exportarClientes(parqueadero); break;
                default: break;
            }
        } while (opcion != 5 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void agregarCliente(Parqueadero parqueadero) {
        JTextField nombre = new JTextField();
        JTextField id = new JTextField();
        JTextField telefono = new JTextField();
        JTextField correo = new JTextField();
        JTextField edad = new JTextField();
        
        Object[] campos = {
            "Nombre:", nombre,
            "ID:", id,
            "Teléfono:", telefono,
            "Correo:", correo,
            "Edad:", edad
        };
        int opcion = JOptionPane.showConfirmDialog(null, campos, "Agregar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                parqueadero.ingresarCliente(
                    nombre.getText(),
                    id.getText(),
                    Integer.parseInt(telefono.getText()),
                    correo.getText(),
                    Integer.parseInt(edad.getText())
                );
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.getMessage());
            }
        }
    }

    public static void listaClientes(Parqueadero parqueadero) {
        SwingUtilities.invokeLater(() -> {
            String html = "<html style='height:100px;overflow:scroll;width:100vh;'>"
                    + "<h2 style='width:500px;background:#CDCDCD;color:white;padding:0 30px;'>Listado de clientes:</h2>"
                    + "<p>" + parqueadero.getListaClientesComoTexto() + "</p>" 
                    + "<p><a href='accion:exportar'><span style='background-color:yellow;width: 200px;'>[Exportar a archivo]</span></a></p>"
                    + "</html>";

            JEditorPane editorPane = new JEditorPane("text/html", html);
            editorPane.setEditable(false);
            editorPane.setOpaque(false);

            JScrollPane scrollPane = new JScrollPane(editorPane);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 400)); 
            
            editorPane.addHyperlinkListener(new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        if ("accion:exportar".equals(e.getDescription())) {
                            exportarClientes(parqueadero);
                        }
                    }
                }
            }); 

            JOptionPane.showMessageDialog(null, editorPane, "Lista de clientes", JOptionPane.PLAIN_MESSAGE);
        });
    }

    public static void buscarCliente(Parqueadero parqueadero) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a buscar:");
        if (id != null && !id.isBlank()) {
            String info = parqueadero.buscarClienteComoTexto(id);
            if (info != null && !info.isBlank()) {
                JOptionPane.showMessageDialog(null, info, "Cliente encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        }
    }

    public static void eliminarCliente(Parqueadero parqueadero) {
        String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:");
        if (id != null && !id.isBlank()) {
            boolean eliminado = parqueadero.eliminarCliente(id);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            }
        }
    }

    public static void exportarClientes(Parqueadero parqueadero) {
        System.out.println("Exportando clientes...");
        JOptionPane.showMessageDialog(null, "Clientes exportados correctamente.");
    }
}