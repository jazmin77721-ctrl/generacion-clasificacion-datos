package com.proyecto;

import com.proyecto.service.DataGenerator;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        try {
            DataGenerator generator = new DataGenerator();

            generator.createProductsFile(10);
            generator.createSalesManInfoFile(5);
            generator.createSalesFiles(5, 15);

            System.out.println("✅ Archivos generados exitosamente en la carpeta data/input/");
        } catch (Exception e) {
            System.out.println("⚠️ Error generando archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
