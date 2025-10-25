package com.proyecto.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import com.proyecto.service.model.*;
/**
 * Servicio responsable de la lectura de archivos de entrada.
 * 
 * <p>Convierte el contenido de los archivos ubicados en <code>/data/input/</code>
 * en listas de objetos de tipo {@link Producto}, {@link Vendedor} y {@link Venta}.</p>
 */
public class FileReaderService {

    /**
     * Lee el archivo de productos y lo convierte en una lista de objetos Producto.
     * 
     * @param ruta Ruta del archivo products.txt
     * @return Lista de productos cargados.
     */
    public List<Producto> leerProductos(String ruta) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String id = partes[0];
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    productos.add(new Producto(id, nombre, precio));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error leyendo productos: " + e.getMessage());
        }
        return productos;
    }

    /**
     * Lee el archivo de vendedores y lo convierte en una lista de objetos Vendedor.
     * 
     * @param ruta Ruta del archivo salesmen.txt
     * @return Lista de vendedores cargados.
     */
    public List<Vendedor> leerVendedores(String ruta) {
        List<Vendedor> vendedores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    vendedores.add(new Vendedor(partes[0], partes[1], partes[2], partes[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error leyendo vendedores: " + e.getMessage());
        }
        return vendedores;
    }

    /**
     * Lee todos los archivos de ventas ubicados dentro de la carpeta indicada.
     * 
     * <p>Cada archivo representa las ventas de un vendedor. La primera línea contiene 
     * el tipo y número de documento del vendedor (que se omite), y las siguientes líneas 
     * indican los productos y sus cantidades.</p>
     * 
     * @param carpetaVentas Ruta de la carpeta /sales/
     * @return Lista combinada de todas las ventas.
     */
    public List<Venta> leerVentas(String carpetaVentas) {
        List<Venta> ventas = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(carpetaVentas))) {
            for (Path archivo : stream) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo.toFile()))) {
                    String linea;
                    boolean primeraLinea = true;
                    while ((linea = br.readLine()) != null) {
                        if (primeraLinea) { primeraLinea = false; continue; }
                        String[] partes = linea.split(";");
                        if (partes.length == 2) {
                            String idProducto = partes[0];
                            int cantidad = Integer.parseInt(partes[1]);
                            ventas.add(new Venta(idProducto, cantidad));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error leyendo ventas: " + e.getMessage());
        }
        return ventas;
    }
}
