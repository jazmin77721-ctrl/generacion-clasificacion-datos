package com.proyecto;

import java.util.List;
import com.proyecto.service.FileReaderService;
import com.proyecto.service.ReportGenerator;
import com.proyecto.service.Validator;
import com.proyecto.service.model.Producto;
import com.proyecto.service.model.Vendedor;
import com.proyecto.service.model.Venta;

/**
 * Clase principal que ejecuta la lectura, validación y generación de reportes.
 * 
 * <p>Este main se encarga de:
 * <ul>
 *   <li>Leer los archivos de entrada desde la carpeta <code>data/input</code>.</li>
 *   <li>Validar la consistencia de los datos leídos (productos, vendedores y ventas).</li>
 *   <li>Generar los reportes finales de vendedores y productos en formato CSV.</li>
 * </ul>
 * </p>
 */
public class Main {
    public static void main(String[] args) {

        try {
            // 🔹 Instancias de los servicios principales
            FileReaderService lector = new FileReaderService();
            ReportGenerator reportes = new ReportGenerator();
            Validator validador = new Validator();

            // 🔹 Lectura de los archivos de entrada
            List<Producto> productos = lector.leerProductos("data/input/products.txt");
            List<Vendedor> vendedores = lector.leerVendedores("data/input/salesmen.txt");
            List<Venta> ventas = lector.leerVentas("data/input/sales");

            // 🔹 Validación de los datos
            if (!validador.validarDatos(productos, vendedores, ventas)) {
                System.out.println("❌ Error en los datos. Revisa los archivos de entrada.");
                return;
            }

            // 🔹 Generación de reportes
            reportes.generarReporteVendedores(vendedores, ventas, productos, "data/output/reporte_vendedores.csv");
            reportes.generarReporteProductos(ventas, productos, "data/output/reporte_productos.csv");

            // 🔹 Mensaje final
            System.out.println("✅ Programa finalizado correctamente. Revisa los reportes en /data/output/");

        } catch (Exception e) {
            System.out.println("⚠️ Error durante la ejecución: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
