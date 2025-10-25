package com.proyecto.service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import com.proyecto.service.model.Producto;
import com.proyecto.service.model.Vendedor;
import com.proyecto.service.model.Venta;

/**
 * Clase encargada de generar los reportes finales en formato CSV.
 * 
 * <p>Contiene métodos para crear los reportes de productos y vendedores a partir
 * de las listas procesadas en el programa principal.</p>
 */
public class ReportGenerator {

    public void generarReporteVendedores(List<Vendedor> vendedores, List<Venta> ventas, List<Producto> productos, String rutaSalida) {
        System.out.println("📊 Generando reporte de vendedores...");

        Map<String, Double> totalPorVendedor = new HashMap<>();

        for (Vendedor v : vendedores) {
            double total = 0;
            for (Venta venta : ventas) {
            	Optional<Producto> productoOpt = productos.stream()
            	        .filter(p -> p.getId().trim().equalsIgnoreCase(venta.getIdProducto().trim()))
            	        .findFirst();


                if (productoOpt.isPresent()) {
                    total += venta.getCantidad() * productoOpt.get().getPrecio();
                }
            }
            totalPorVendedor.put(v.getNombres() + " " + v.getApellidos(), total);
        }

        List<Map.Entry<String, Double>> ordenados = totalPorVendedor.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());

        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida))) {
            pw.println("Vendedor;Total Recaudado");
            for (Map.Entry<String, Double> e : ordenados) {
                pw.println(e.getKey() + ";" + String.format("%.2f", e.getValue()));
            }
            System.out.println("✅ Reporte generado: " + rutaSalida);
        } catch (IOException e) {
            System.out.println("⚠️ Error escribiendo reporte de vendedores: " + e.getMessage());
        }
    }

    /**
     * Genera un reporte CSV con la cantidad total vendida por cada producto.
     * 
     * <p>Lee la lista de ventas y cruza los IDs de producto con la lista de productos 
     * disponible. Luego suma las cantidades vendidas de cada producto y genera un archivo 
     * CSV ordenado de mayor a menor cantidad vendida.</p>
     *
     * @param ventas Lista de objetos Venta leídos desde los archivos de ventas.
     * @param productos Lista de productos disponibles.
     * @param rutaSalida Ruta donde se guardará el archivo CSV resultante.
     */
    public void generarReporteProductos(List<Venta> ventas, List<Producto> productos, String rutaSalida) {
        System.out.println("📦 Generando reporte de productos...");

        // Mapa que almacena el total vendido por ID de producto
        Map<String, Integer> cantidadPorProducto = new HashMap<>();

        // Acumular las cantidades vendidas
        for (Venta v : ventas) {
            cantidadPorProducto.merge(v.getIdProducto().trim(), v.getCantidad(), Integer::sum);
        }

        // Ordenar de mayor a menor por cantidad
        List<Map.Entry<String, Integer>> ordenados = cantidadPorProducto.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        // Escribir el archivo CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida))) {
            pw.println("Producto;Cantidad Vendida");

            for (Map.Entry<String, Integer> e : ordenados) {
                // Buscar nombre del producto según el ID
                String nombre = productos.stream()
                        .filter(p -> p.getId().trim().equalsIgnoreCase(e.getKey().trim()))
                        .map(Producto::getNombre)
                        .findFirst()
                        .orElse("Desconocido");

                pw.println(nombre + ";" + e.getValue());
            }

            System.out.println("✅ Reporte generado: " + rutaSalida);

        } catch (IOException e) {
            System.out.println("⚠️ Error escribiendo reporte de productos: " + e.getMessage());
        }
    }
}
