package com.proyecto.service.models;

public class Venta {
    private String idProducto;
    private int cantidad;

    public Venta() {}

    // Getters y Setters
    public String getIdProducto() { return idProducto; }
    public void setIdProducto(String idProducto) { this.idProducto = idProducto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
