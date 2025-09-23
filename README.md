# Proyecto: Generación y Clasificación de Datos

## 🎯 Objetivo
Este proyecto busca simular un flujo de datos de productos, vendedores y ventas para luego organizar la información y generar reportes.  
Se desarrolla en **Java 8** siguiendo una estructura modular con paquetes separados por responsabilidades.

---

## 📌 Entregas

### ✅ Entrega 1 (Semana 3)
- Se implementó la generación automática de archivos de prueba.
- Archivos generados en `data/input/`:
  - `products.txt` → Catálogo de productos (`ID;Nombre;Precio`)
  - `salesmen.txt` → Listado de vendedores (`TipoDoc;NúmeroDoc;Nombres;Apellidos`)
  - Carpeta `sales/` → Un archivo por vendedor con sus ventas:
    - Primera línea: identificación del vendedor (`TipoDoc;NúmeroDoc`)
    - Líneas siguientes: productos vendidos (`IDProducto;CantidadVendida`)
- Main ejecutado: **`GenerateInfoFiles`**

---

### ✅ Entrega 2 (Semana 5)
- Se añadió un **segundo main (`Main`)** que:
  - Lee los archivos de entrada usando **`FileReaderService`**.
  - Genera reportes preliminares con **`ReportGenerator`**.
- Archivos creados en `data/output/`:
  - `reporte_vendedores.csv` (encabezado: `Vendedor;TotalVentas`)
  - `reporte_productos.csv` (encabezado: `Producto;CantidadVendida;Precio`)
- Actualmente los reportes contienen solo encabezados (versión preliminar).
- Main ejecutado: **`Main`**

---

## 📂 Estructura del Proyecto


generacion-clasificacion-datos/
├── src/
│ └── com/proyecto/
│ ├── GenerateInfoFiles.java # main 1 (Entrega 1)
│ ├── Main.java # main 2 (Entrega 2)
│ └── service/
│ ├── DataGenerato.java
│ ├── FileReaderService.java
│ ├── ReportGenerator.java
│ ├── Validator.java
│ └── models/
│ ├── Producto.java
│ ├── Vendedor.java
│ └── Venta.java
├── data/
│ ├── input/
│ │ ├── products.txt
│ │ ├── salesmen.txt
│ │ └── sales/
│ │ ├── CC_XXXXX.txt
│ │ └── ...
│ └── output/
│ ├── reporte_vendedores.csv
│ └── reporte_productos.csv
├── docs/
│ └── faltantes-semana5.md
└── README.md


## 🚀 Ejecución

1. **Generar archivos de prueba**
   ```bash
   Ejecutar GenerateInfoFiles (main 1)
   
   
   SALIDA ESPERADA:
   Archivos de entrada generados en la carpeta data/input
   Ejecutar Main (main 2)
   Productos cargados : 20
Vendedores cargados : 5
Archivo de ventas leído: CC_12345678.txt (6 líneas)
...
Reporte preliminar de vendedores generado en data/output/reporte_vendedores.csv
Reporte preliminar de productos generado en data/output/reporte_productos.csv
Reportes generados correctamente en data/output/
   
