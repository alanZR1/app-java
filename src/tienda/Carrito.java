package tienda;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public String mostrarCarrito() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("Total: $").append(calcularTotal());
        return sb.toString();
    }
}
