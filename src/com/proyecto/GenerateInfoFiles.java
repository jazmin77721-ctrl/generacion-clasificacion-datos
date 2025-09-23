package com.proyecto;

import com.proyecto.service.DataGenerato;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        /*
         * Usamos try-catch para manejar la posibilidad de errores.
         * Si ocurre un error, se mostrará un mensaje en consola.
         * Si todo sale bien, se informará que los archivos se generaron correctamente.
         */
        try {
            // Parámetros: cantidad de productos, vendedores y items por venta
            new DataGenerato().run(20, 5, 5);
            System.out.println("Archivos de entrada generados en la carpeta data/input");
        } catch (Exception e) {
            /*
             * En caso de que se presente un inconveniente,
             * se captura la excepción para evitar que el programa colapse.
             * También se muestra el mensaje de error en consola.
             */
            System.err.println("Error al generar archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
