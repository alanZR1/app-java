package tienda;

import java.util.*;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public String generarTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Ticket de Compra ---\n");
        for (Producto p : productos) {
            sb.append(p.getNombre()).append(" - $").append(p.getPrecio()).append("\n");
        }
        sb.append("-------------------------\n");
        sb.append("Total: $").append(calcularTotal()).append("\n");
        return sb.toString();
    }
}