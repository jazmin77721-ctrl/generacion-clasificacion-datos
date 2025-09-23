package com.proyecto.service;

// ============ Importaciones ============
// java.io.*                -> Clases de E/S (BufferedWriter, IOException).
// java.nio.charset.*       -> Charset UTF-8 para escribir/leer texto correctamente.
// java.nio.file.*          -> Manejo de rutas y archivos (Path, Paths, Files, StandardOpenOption).
// java.util.*              -> Utilidades como List, Arrays, Random, etc.
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Genera archivos de prueba para la Entrega 1:
 * - products.txt   : catálogo de productos (ID;Nombre;Precio)
 * - salesmen.txt   : vendedores (TipoDoc;NúmeroDoc;Nombres;Apellidos)
 * - sales/*.txt    : ventas por vendedor
 *
 * Estructura de cada archivo en sales/*.txt:
 *   Línea 1  -> TipoDocumento;NúmeroDocumento
 *   Siguientes líneas -> IDProducto;CantidadVendida
 *
 * Las rutas son relativas a ./data/input (se crean si no existen).
 */
public class DataGenerato {

    // Directorios base
    private final Path baseData  = Paths.get("data");
    private final Path inputDir  = baseData.resolve("input");
    private final Path salesDir  = inputDir.resolve("sales");

    // Archivos de salida
    private final Path productsFile = inputDir.resolve("products.txt");
    private final Path salesmenFile = inputDir.resolve("salesmen.txt");

    // Generador de valores pseudoaleatorios
    private final Random rnd = new Random();

    /**
     * Punto de entrada del generador.
     *
     * @param productsCount cantidad de productos a crear
     * @param salesmenCount cantidad de vendedores a crear
     * @param itemsPerSale  líneas (ID;Cantidad) en cada archivo de ventas
     * @throws IOException si ocurre un error de E/S
     */
    public void run(int productsCount, int salesmenCount, int itemsPerSale) throws IOException {
        ensureDirs();
        generateProducts(productsCount);
        generateSalesmen(salesmenCount, itemsPerSale);
    }

    /**
     * Crea las carpetas ./data/input y ./data/input/sales si no existen.
     */
    private void ensureDirs() throws IOException {
        Files.createDirectories(salesDir); // Crea toda la jerarquía necesaria
    }

    /**
     * Genera products.txt con formato: ID;Nombre;Precio
     * Se sobrescribe en cada ejecución (TRUNCATE por defecto en este overload).
     */
    private void generateProducts(int count) throws IOException {
        List<String> names = Arrays.asList("Pan", "Croissant", "Torta", "Galleta", "Mogolla", "Arepa");

        // newBufferedWriter(Path, Charset) -> crea o trunca por defecto
        try (BufferedWriter w = Files.newBufferedWriter(productsFile, StandardCharsets.UTF_8)) {
            for (int i = 1; i <= count; i++) {
                String id   = "P" + i;
                String name = names.get(rnd.nextInt(names.size())) + " " + i;
                double price = 500 + rnd.nextInt(4000); // 500..4499

                w.write(id + ";" + name + ";" + price);
                w.newLine();
            }
        }
    }

    /**
     * Genera salesmen.txt (reiniciado en cada ejecución) y un archivo de ventas por vendedor en /sales.
     *
     * @param count        número de vendedores a crear
     * @param itemsPerSale número de líneas de detalle (ID;Cantidad) por archivo de ventas
     */
    private void generateSalesmen(int count, int itemsPerSale) throws IOException {
        List<String> fn = Arrays.asList("Ana", "Luis", "Carlos", "Marta", "Juan", "Sofía");
        List<String> ln = Arrays.asList("García", "Pérez", "Rodríguez", "López", "Martínez");

        // Cargar una sola vez los productos para tomar IDs (mejor rendimiento)
        List<String> productLines = Files.readAllLines(productsFile, StandardCharsets.UTF_8);

        // Abrimos salesmen.txt truncando (reinicia contenido cada vez)
        try (BufferedWriter w = Files.newBufferedWriter(
                salesmenFile,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (int i = 1; i <= count; i++) {
                String docType   = "CC";
                String docNumber = String.valueOf(10_000_000 + rnd.nextInt(90_000_000));
                String first     = fn.get(rnd.nextInt(fn.size()));
                String last      = ln.get(rnd.nextInt(ln.size()));

                // Línea en salesmen.txt: Tipo;Número;Nombres;Apellidos
                w.write(docType + ";" + docNumber + ";" + first + ";" + last);
                w.newLine();

                // Archivo de ventas por vendedor (se sobrescribe cada vez)
                Path sf = salesDir.resolve(docType + "_" + docNumber + ".txt");
                try (BufferedWriter sw = Files.newBufferedWriter(
                        sf,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING)) {

                    // Encabezado con identificación del vendedor
                    sw.write(docType + ";" + docNumber);
                    sw.newLine();

                    // Detalle de ventas: N líneas con "ID;Cantidad"
                    for (int j = 0; j < itemsPerSale; j++) {
                        String[] p = productLines.get(rnd.nextInt(productLines.size())).split(";");
                        String pid = p[0];
                        long qty   = 1 + rnd.nextInt(5);
                        sw.write(pid + ";" + qty);
                        sw.newLine();
                    }
                }
            }
        }
    }
}
