package com.proyecto.service.model;

public class Venta {
    private String idProducto;   // ahora es String
    private int cantidad;

    // ✅ Constructor actualizado
    public Venta(String idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    // ✅ Getters y Setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idProducto='" + idProducto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
