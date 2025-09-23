package com.proyecto.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class ReportGenerator {

    public void generateSalesReport(String outputPath) {
        try (BufferedWriter w = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8)) {
            w.write("Vendedor;TotalVentas");
            w.newLine();
            // TODO: Agregar lógica real en Entrega 3
            System.out.println("Reporte preliminar de vendedores generado en " + outputPath);
        } catch (IOException e) {
            System.err.println("Error al generar reporte de vendedores: " + e.getMessage());
        }
    }

    public void generateProductReport(String outputPath) {
        try (BufferedWriter w = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8)) {
            w.write("Producto;CantidadVendida;Precio");
            w.newLine();
            // TODO: Agregar lógica real en Entrega 3
            System.out.println("Reporte preliminar de productos generado en " + outputPath);
        } catch (IOException e) {
            System.err.println("Error al generar reporte de productos: " + e.getMessage());
        }
    }
}
