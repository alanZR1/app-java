package gui;

import tienda.*;
import javax.swing.*;
import java.awt.*;

public class Galeria extends JFrame {
    public Galeria(Usuario usuario, Tienda tienda, Carrito carrito) {
        setTitle("Galería de Bicicletas - Usuario: " + usuario.getNombre());
        setSize(600, 400);
        setLocationRelativeTo(null);

        DefaultListModel<Producto> modelo = new DefaultListModel<>();
        tienda.getProductos().forEach(modelo::addElement);
        JList<Producto> lista = new JList<>(modelo);

        JButton btnAgregar = new JButton("Agregar al carrito");
        JButton btnCarrito = new JButton("Ir al carrito");

        btnAgregar.addActionListener(e -> {
            Producto p = lista.getSelectedValue();
            if (p != null) {
                carrito.agregarProducto(p);
                JOptionPane.showMessageDialog(this, p.getNombre() + " agregado al carrito.");
            }
        });

        btnCarrito.addActionListener(e -> {
            new CarritoVentana(usuario, carrito);
            dispose();
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botones.add(btnAgregar);
        botones.add(btnCarrito);
        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}