# 🧠 Proyecto: Generación y Clasificación de Datos

---

## 🎯 Objetivo

Este proyecto tiene como finalidad simular un flujo de información entre **productos**, **vendedores** y **ventas**, para luego organizar los datos, validar su consistencia y generar reportes automatizados.  
Se desarrolla en **Java 8**, aplicando una estructura modular y separando las responsabilidades por capas (lectura, validación, procesamiento y generación de reportes).

---

## 📦 Entregas

### ✅ Entrega 1 — Semana 3

En esta primera parte se implementó la **generación automática de archivos de prueba**.

**Archivos generados en `data/input/`:**

- `products.txt` → catálogo de productos (`ID;Nombre;Precio`)
- `salesmen.txt` → listado de vendedores (`TipoDoc;NúmeroDoc;Nombres;Apellidos`)
- Carpeta `sales/` → un archivo por vendedor con sus ventas:
  - Primera línea: identificación del vendedor (`TipoDoc;NúmeroDoc`)
  - Líneas siguientes: productos vendidos (`IDProducto;CantidadVendida`)

**Main ejecutado:** `GenerateInfoFiles.java`

---

### ✅ Entrega 2 — Semana 5

Se desarrolló un segundo flujo de ejecución más completo, enfocado en **leer, procesar y generar reportes** a partir de los datos creados.

El nuevo main (`Main.java`) realiza las siguientes tareas:

1. Lee los archivos de entrada con `FileReaderService`.
2. Valida la consistencia de los datos con `Validator`.
3. Procesa las ventas y productos para cruzar información.
4. Genera los reportes finales mediante `ReportGenerator`.

**Archivos generados en `data/output/`:**

- `reporte_vendedores.csv` → (Encabezado: `Vendedor;TotalVentas`)
- `reporte_productos.csv` → (Encabezado: `Producto;CantidadVendida`)

**Main ejecutado:** `Main.java`

---

## 📂 Estructura Final del Proyecto


generacion-clasificacion-datos/
├── src/
│ └── com/proyecto/
│ ├── GenerateInfoFiles.java # Main 1 (Entrega 1)
│ ├── Main.java # Main 2 (Entrega 2)
│ └── service/
│ ├── DataGenerator.java
│ ├── FileReaderService.java
│ ├── ReportGenerator.java
│ ├── Validator.java
│ └── model/
│ ├── Producto.java
│ ├── Vendedor.java
│ └── Venta.java
│
├── data/
│ ├── input/
│ │ ├── products.txt
│ │ ├── salesmen.txt
│ │ └── sales/
│ │ ├── CC_15804309.txt
│ │ ├── CC_23547395.txt
│ │ ├── ...
│ │
│ └── output/
│ ├── reporte_vendedores.csv
│ └── reporte_productos.csv
│
├── docs/
│ ├── faltantes-semana5.md
│ ├── conclusiones.md
│ └── README.md
│
└── README.md

