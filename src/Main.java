import tienda.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppGUI().crearGUI());
    }
}

class AppGUI {
    private Tienda tienda;
    private Carrito carrito;
    private JFrame frame;
    private JList<Producto> listaProductos;
    private JTextArea areaCarrito;

    public void crearGUI() {
        tienda = new Tienda();
        carrito = new Carrito();

        frame = new JFrame("Tienda de Bicicletas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Lista de productos

        listaProductos = new JList<>(tienda.getProductos().toArray(new Producto[0]));
        listaProductos.setBackground(new Color(255, 255, 240));
        listaProductos.setSelectionBackground(new Color(173, 216, 230));
        frame.add(new JScrollPane(listaProductos), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar al carrito");
        JButton btnVerCarrito = new JButton("Ver Carrito");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnVerCarrito);
        frame.add(panelBotones, BorderLayout.SOUTH);

        // area del carrito

        areaCarrito = new JTextArea(10, 20);
        areaCarrito.setEditable(false);
        areaCarrito.setBackground(new Color(245, 255, 250)); // Fondo tipo menta
        areaCarrito.setForeground(Color.DARK_GRAY); // Texto
        frame.add(new JScrollPane(areaCarrito), BorderLayout.EAST);

        // Acciones
        btnAgregar.setBackground(new Color(60, 179, 113)); // Verde medio
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.addActionListener(e -> {
            Producto seleccionado = listaProductos.getSelectedValue();
            if (seleccionado != null) {
                carrito.agregarProducto(seleccionado);
                JOptionPane.showMessageDialog(frame, seleccionado.getNombre() + " agregado al carrito.");
            }
        });
        btnVerCarrito.setBackground(new Color(30, 144, 255)); // Azul fuerte
        btnVerCarrito.setForeground(Color.WHITE);
        btnVerCarrito.addActionListener(e -> {
            areaCarrito.setText(carrito.mostrarCarrito());
        });

        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Fondo del JFrame
        frame.setVisible(true);
    }
}
