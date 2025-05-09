package main;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import controllers.Parqueadero;

public class Main {

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
         
        parqueadero.ingresarCliente("Juan Pérez", "12345", 300123456, "juanperez@mail.com");
        parqueadero.ingresarCliente("Ana Gómez", "67890", 300987654, "anagomez@mail.com");
          
        //parqueadero.getlistaClientes();
        listaClientes(parqueadero);
    }
    public static void listaClientes(Parqueadero parqueadero) {

        SwingUtilities.invokeLater(() -> {
            String html = "<html style='height:100px;overflow:scroll'>"
                    + "<h2 style='width:500px;background:#CDCDCD;color:white;padding:0 30px;'>Listado de clientes:</h2>"
                    + "<p>" + parqueadero.getListaClientesComoTexto() + "</p>"
                    + "<img style='width:100px' src='https://www.pngall.com/wp-content/uploads/15/User-PNG-Images-HD-180x180.png'/>"
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

    public static void exportarClientes(Parqueadero parqueadero) {
        System.out.println("Exportando clientes...");
        JOptionPane.showMessageDialog(null, "Clientes exportados correctamente.");
    }
}
