package com.proyecto.service;

public class Validator {
    public static boolean validateProductId(String id) {
        // TODO: validar formato de ID
        return true;
    }

    public static boolean validateValues(double precio, int cantidad) {
        // TODO: validar valores
        return precio >= 0 && cantidad >= 0;
    }
}
