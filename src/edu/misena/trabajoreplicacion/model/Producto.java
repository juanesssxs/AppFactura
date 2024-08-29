package edu.misena.trabajoreplicacion.model;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    private static int ultimoCodigo = 0;  // Inicializar el último código en 0


    public Producto(String nombre, double precio) {
        this.codigo = codigo();  // Asignar el código único generado
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {

    }

    private String codigo() {
        ultimoCodigo++;  // Incrementar el último código
        return "P" + String.format("%04d", ultimoCodigo);  // Formatear el código con 4 dígitos
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
