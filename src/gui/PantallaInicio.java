package gui;

import tienda.*;
        import javax.swing.*;
        import java.awt.*;

public class PantallaInicio extends JFrame {
    public PantallaInicio() {
        setTitle("Bienvenido a la Tienda de Bicicletas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/resources/bici.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(imagenEscalada));

        JLabel nombreLabel = new JLabel("Ingrese su nombre:");
        JTextField campoNombre = new JTextField(20);
        JButton btnContinuar = new JButton("Continuar");

        btnContinuar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            if (!nombre.isEmpty()) {
                Usuario usuario = new Usuario(nombre);
                Tienda tienda = new Tienda();
                Carrito carrito = new Carrito();
                new Galeria(usuario, tienda, carrito);
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(imgLabel);
        panel.add(nombreLabel);
        panel.add(campoNombre);
        panel.add(btnContinuar);
        add(panel);

        setVisible(true);
    }
}
