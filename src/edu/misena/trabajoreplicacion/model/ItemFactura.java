package edu.misena.trabajoreplicacion.model;

public class ItemFactura {
    private Producto producto;
    private int cantidad;

    public ItemFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public ItemFactura(int i, Producto producto) {
    }

    // Getters y setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float calcularImporte() {
        return (float) (cantidad * producto.getPrecio());
    }

    @Override
    public String toString() {
        return producto.getCodigo() +
                "\t" + producto.getNombre() +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}


