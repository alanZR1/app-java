package tienda;

import java.util.*;

public class Tienda {
    private List<Producto> productos;

    public Tienda() {
        productos = new ArrayList<>();
        productos.add(new Producto("Bicicleta de Montaña", 250.0));
        productos.add(new Producto("Bicicleta de Ruta", 300.0));
        productos.add(new Producto("Bicicleta Urbana", 200.0));
        productos.add(new Producto("BMX", 180.0));
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
