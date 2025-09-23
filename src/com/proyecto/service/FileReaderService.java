package com.proyecto.service;
//================Importaciones===================
/*
 * Servicios para leer archivos de entrada
 * products.txt
 * salesmen.txt
 * sales/*.txt
 * */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;


public class FileReaderService {
	
	//Carga Productos desde productos.txt
    public void loadProducts(String path) {
    	try {
    		List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    		System.out.println("Productos cargados : " + lines.size());
    		// TODO parsear lineas a objetos productos
    	}catch(IOException e) {
    		System.err.println("Error leyendo productos: " + e.getMessage());
    	}
    }
    
    /**
     * Carga vendedores desde salesmen.txt
     */

    public void loadSalesmen(String path) {
    	try {
    		List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    		System.out.println("Vendedores cargados : " + lines.size());
    		//TODO parsear lienas a objetos vendedor
		}catch(IOException e) {
			System.err.println("Error leyendo vendedores: " + e.getMessage());
		}
    }
	/*
	 * Carga todas las ventas de la carpetas sales/
	 * */
    public void loadSales(String folderPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*.txt")) {
            for (Path file : stream) {
                List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                System.out.println("Archivo de ventas leído: " + file.getFileName() + " (" + lines.size() + " líneas)");
                // TODO: parsear cada línea a objetos Venta
            }
        } catch (IOException e) {
            System.err.println("Error leyendo ventas: " + e.getMessage());
        }
    }
}
