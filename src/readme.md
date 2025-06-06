README - Tienda de Bicicletas (Swing GUI)
=========================================

📦 Estructura de Paquetes:
---------------------------
- tienda/: Clases de lógica de negocio
    - Producto.java: Representa una bicicleta con nombre y precio
    - Tienda.java: Contiene una lista de bicicletas disponibles
    - Carrito.java: Maneja los productos seleccionados
    - Usuario.java: Representa al usuario que compra

- gui/: Interfaces gráficas usando Swing
    - PantallaInicio.java: Bienvenida con imagen y campo de nombre
    - Galeria.java: Muestra catálogo de bicicletas
    - CarritoVentana.java: Permite ver y eliminar productos del carrito
    - TicketVentana.java: Muestra ticket final de compra

- Main.java: Punto de entrada del programa

🖼️ Requisitos para imágenes:
----------------------------
- Coloca la imagen "bicicleta.png" en la carpeta: `src/resources/`
- Asegúrate de marcar `/resources` como Resources Root en IntelliJ

🛠️ Cómo ejecutar el proyecto:
-----------------------------
1. Abrir el proyecto en IntelliJ IDEA
2. Ejecutar la clase `Main.java`
3. Ingresar tu nombre, ver catálogo, agregar al carrito y finalizar la compra

✅ Funcionalidades:
------------------
- Bienvenida personalizada con imagen
- Catálogo de bicicletas con opción de agregar al carrito
- Vista del carrito con opción de eliminar elementos
- Ticket final con desglose de precios y nombre del usuario

🎯 Posibles mejoras:
--------------------
- Persistencia de compras en archivo
- Gestión de stock o cantidades
- Ingreso con múltiples usuarios