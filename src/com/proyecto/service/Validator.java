package com.proyecto.service;

import java.util.List;
import java.util.stream.Collectors;
import com.proyecto.service.model.Producto;
import com.proyecto.service.model.Vendedor;
import com.proyecto.service.model.Venta;

/**
 * Clase encargada de validar la consistencia de los datos leídos desde los archivos.
 *
 * <p>Verifica que:
 * <ul>
 *   <li>Todos los IDs de producto presentes en las ventas existan en la lista de productos.</li>
 *   <li>Las cantidades vendidas sean positivas.</li>
 *   <li>(Opcional) Que los vendedores estén correctamente cargados.</li>
 * </ul>
 * </p>
 */
public class Validator {

    /**
     * Valida los datos antes de generar los reportes.
     *
     * @param productos  Lista de productos disponibles.
     * @param vendedores Lista de vendedores cargados.
     * @param ventas     Lista de ventas leídas desde los archivos.
     * @return true si los datos son válidos, false en caso contrario.
     */
    public boolean validarDatos(List<Producto> productos, List<Vendedor> vendedores, List<Venta> ventas) {

        for (Venta v : ventas) {
            boolean existeProducto = productos.stream()
                    .anyMatch(p -> p.getId().trim().equalsIgnoreCase(v.getIdProducto().trim()));

            if (!existeProducto) {
                System.out.println("❌ Producto inexistente con ID: " + v.getIdProducto());
                System.out.println("👉 IDs disponibles: " + productos.stream()
                        .map(Producto::getId)
                        .collect(Collectors.joining(", ")));
                return false;
            }

            if (v.getCantidad() <= 0) {
                System.out.println("⚠️ Cantidad inválida para el producto ID: " + v.getIdProducto());
                return false;
            }
        }

        // (Validación opcional de vendedores)
        if (vendedores == null || vendedores.isEmpty()) {
            System.out.println("⚠️ No se encontraron vendedores cargados. Verifica el archivo salesmen.txt.");
            return false;
        }

        return true;
    }
}
