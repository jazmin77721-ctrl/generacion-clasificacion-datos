Proyecto: Generación y Clasificación de Datos (Entrega 1)
🎯 Objetivo

Esta primera parte del proyecto tiene como finalidad generar archivos de prueba que luego serán utilizados para organizar y procesar información de vendedores y productos en entregas posteriores.

No se requiere interacción del usuario, todo se crea de manera automática al ejecutar la clase GenerateInfoFiles.

📂 Archivos generados

Al ejecutar el programa se crean los siguientes archivos en la carpeta data/input/:

products.txt
Contiene un listado de productos con el formato:

IDProducto;NombreProducto;PrecioUnidad


salesmen.txt
Contiene la información de los vendedores con el formato:

TipoDocumento;NúmeroDocumento;Nombres;Apellidos


Carpeta sales/
Dentro se crea un archivo por cada vendedor.

Primera línea: tipo y número de documento del vendedor.

Líneas siguientes: ID de producto y cantidad vendida.
Ejemplo:

CC;10324567
P1;3
P5;2
P10;1



generacion-clasificacion-datos/
 ├── src/
 │   ├── com/proyecto/GenerateInfoFiles.java
 │   └── com/service/DataGenerato.java
 ├── data/
 │   └── input/
 │       ├── products.txt
 │       ├── salesmen.txt
 │       └── sales/
 ├── README.md       <-- aquí va el documento explicativo

# generacion-clasificacion-datos
