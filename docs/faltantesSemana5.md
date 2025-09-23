# Faltantes - Entrega 2 (Semana 5)

Este documento lista las funcionalidades que aún no están implementadas en el proyecto **Generación y Clasificación de Datos** y que serán desarrolladas en la siguiente etapa.

---

## 🔹 Lectura de datos
- [ ] Conversión de líneas de `products.txt` en objetos `Producto`.
- [ ] Conversión de líneas de `salesmen.txt` en objetos `Vendedor`.
- [ ] Conversión de archivos en `sales/` en objetos `Venta`.

---

## 🔹 Procesamiento de información
- [ ] Calcular el total de ventas por cada vendedor.
- [ ] Calcular la cantidad total vendida por cada producto.
- [ ] Integrar productos y ventas para cruzar información (validar IDs, totales, etc.).

---

## 🔹 Reportes
- [ ] Generar `reporte_vendedores.csv` con datos reales (ordenado por total de ventas).
- [ ] Generar `reporte_productos.csv` con datos reales (ordenado por cantidad vendida).
- [ ] Incluir encabezados completos y registros procesados en cada reporte.

---

## 🔹 Validaciones
- [ ] Validar que los IDs de productos en las ventas existan en `products.txt`.
- [ ] Validar que los valores numéricos sean positivos (precios, cantidades).
- [ ] Manejo de errores cuando un archivo de entrada está vacío o incompleto.

---

## 🔹 Otros
- [ ] Mejorar mensajes en consola para que indiquen el progreso paso a paso.
- [ ] Documentar en el README cómo se procesan los datos (flujo completo).
