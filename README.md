# 📖 Proyecto: Generador de Credenciales para Asistentes de Evento  
**Autor:** Aníbal  
**Asignatura:** Patrones de Diseño  
**Profesor:** Giovanni Cáceres  

---

## 📌 Descripción del sistema y problema a resolver  

Este sistema de consola permite gestionar asistentes a un evento, generar credenciales personalizadas con identificadores únicos, y exportarlas en distintos formatos (TXT real y PDF simulado).  

**Problema resuelto:**  
En eventos o reuniones, se requiere llevar un registro claro de asistentes, generar credenciales identificatorias y exportar esa información en formatos útiles. Este sistema permite:

- Registrar asistentes con su nombre, RUT y tipo de acceso.
- Visualizar la lista de asistentes.
- Eliminar asistentes registrados.
- Generar credenciales únicas por asistente.
- Exportar credenciales en TXT real o PDF simulado.

---

## 📌 Patrones de Diseño aplicados y justificación  

| Tipo             | Patrón aplicado | Por qué se usa | Dónde y cómo se implementó |
|:----------------|:----------------|:---------------|:----------------------------|
| Creacional       | Singleton        | Se requiere una única instancia centralizada que genere credenciales únicas. | Clase `GeneradorCredenciales`: genera credenciales asegurando una sola instancia a lo largo del sistema mediante un método `getInstancia()`. |
| Estructural      | Adapter          | Permite definir distintos formatos de exportación sin alterar el sistema base. | Interfaz `Exportador` y sus implementaciones `ExportadorTxt` y `ExportadorPdf`. Según la elección del usuario, el sistema adapta la exportación a TXT real o PDF simulado. |
| Comportamiento   | Iterator         | Facilita recorrer listas de asistentes de forma controlada. | Clase `ListaAsistentes` implementa métodos de iteración para recorrer y manipular la colección de asistentes registrados. |
| Libre elección   | Observer         | Permite notificar acciones importantes (como agregar asistentes) sin acoplar el sistema. | Interfaz `Observador`, clase `Logger` y clase `SujetoAsistentes` para notificar acciones y dejar registro por consola. |

---

## 📌 Instrucciones de compilación y ejecución  

### 📂 Estructura de carpetas

📂 Source Packages
│
├── adapter → Adapter Pattern

Exportador.java → interfaz común

ExportadorPdf.java → exportación PDF simulada

ExportadorTxt.java → exportación a archivo real TXT

├── iterator → Iterator Pattern

ListaAsistentes.java → lista propia con métodos de recorrido

├── model → Clases de dominio

Asistente.java → contiene id, nombre, rut y tipo de acceso

Credencial.java → credencial generada por asistente

ValidarRut.java → utilitario de validación

├── observer → Observer Pattern

Logger.java → observador que imprime logs

Observador.java → interfaz observador

SujetoAsistentes.java → sujeto observado que notifica

├── principal

Main.java → clase con el flujo principal de la aplicación

├── singleton → Singleton Pattern

GeneradorCredenciales.java → generador de credenciales único

