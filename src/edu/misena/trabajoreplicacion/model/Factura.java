package edu.misena.trabajoreplicacion.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceActual;  // Índice actual en el arreglo de ítems
    private static final int MAX_ITEMS = 100;  // Tamaño máximo del arreglo de ítems

    private static int ultimoFolio = 0;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];  // Inicializa el arreglo de ítems con el tamaño máximo permitido
        this.indiceActual = 0;  // Inicializa el índice actual en 0
        this.folio = generarFolio();  // Asigna un folio único generado
        this.fecha = new Date();  // Inicializa la fecha a la fecha actual
    }

    private int generarFolio() {
        ultimoFolio++;  // Incrementa el último folio
        return ultimoFolio;  // Retorna el nuevo folio
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void setItems(ItemFactura[] items) {
        this.items = items;
    }

    public boolean addItemFactura(ItemFactura item) {
        if (indiceActual < MAX_ITEMS) {
            items[indiceActual++] = item;
            return true;
        }
        return false;
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (int i = 0; i < indiceActual; i++) {
            if (items[i] != null) {
                sb.append(items[i])
                        .append("\n");
            }
        }

        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
