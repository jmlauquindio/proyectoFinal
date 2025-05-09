package main;
import javax.swing.*;

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
            String html = "<html><h2 style='background:#CDCDCD;color:white;padding:30px;'>Listado de clientes:</h2>"; 
            html = html + "<p>" + parqueadero.getListaClientesComoTexto() + "</p></html>";

            JEditorPane editorPane = new JEditorPane("text/html", html);
            editorPane.setEditable(false);
            editorPane.setOpaque(false);

            JOptionPane.showMessageDialog(null, editorPane, "Lista de clientes", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
