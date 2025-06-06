package gui;

import tienda.*;
import javax.swing.*;
import java.awt.*;

public class CarritoVentana extends JFrame {
    public CarritoVentana(Usuario usuario, Carrito carrito) {
        setTitle("Carrito de Compras");
        setSize(500, 400);
        setLocationRelativeTo(null);

        DefaultListModel<Producto> modelo = new DefaultListModel<>();
        carrito.getProductos().forEach(modelo::addElement);
        JList<Producto> lista = new JList<>(modelo);

        JButton btnEliminar = new JButton("Eliminar seleccion");
        JButton btnComprar = new JButton("Comprar");

        btnEliminar.addActionListener(e -> {
            Producto p = lista.getSelectedValue();
            if (p != null) {
                carrito.eliminarProducto(p);
                modelo.removeElement(p);
            }
        });

        btnComprar.addActionListener(e -> {
            new TicketVentana(usuario, carrito);
            dispose();
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botones.add(btnEliminar);
        botones.add(btnComprar);
        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
