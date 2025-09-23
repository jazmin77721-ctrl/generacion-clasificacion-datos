package com.proyecto;

import com.proyecto.service.FileReaderService;
import com.proyecto.service.ReportGenerator;

public class Main {
    public static void main(String[] args) {
        try {
            FileReaderService reader = new FileReaderService();
            ReportGenerator report = new ReportGenerator();

            // TODO: leer archivos
            reader.loadProducts("data/input/products.txt");
            reader.loadSalesmen("data/input/salesmen.txt");
            reader.loadSales("data/input/sales/");

            // TODO: generar reportes
            report.generateSalesReport("data/output/reporte_vendedores.csv");
            report.generateProductReport("data/output/reporte_productos.csv");

            System.out.println("Reportes generados correctamente en data/output/");
        } catch (Exception e) {
            System.err.println("Error al procesar archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
