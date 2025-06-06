package gui;

import tienda.*;
import javax.swing.*;

public class TicketVentana extends JFrame {
    public TicketVentana(Usuario usuario, Carrito carrito) {
        setTitle("Ticket de Compra");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setText("Gracias por tu compra, " + usuario.getNombre() + "!\n\n");
        area.append(carrito.generarTicket());
        area.setEditable(false);

        add(new JScrollPane(area));
        setVisible(true);
    }
}

