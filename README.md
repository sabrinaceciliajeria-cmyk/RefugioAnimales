![](screenshot-1775781823.png/)
<div align="center">

```
           ╔══════════════════════════════════════════════════════╗
           ║                                                      ║
           ║             🐾 REFUGIO DE ANIMALES 🐾               ║
           ║            Sistema de Gestión en Consola             ║
           ║                                                      ║
           ╚══════════════════════════════════════════════════════╝
```

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Console](https://img.shields.io/badge/Consola-000000?style=for-the-badge&logo=windowsterminal&logoColor=white)
![Status](https://img.shields.io/badge/Estado-Activo-brightgreen?style=for-the-badge)

*Sistema de consola para la gestión integral de un refugio de animales rescatados.*

</div>

```
Local (vacío) --force→ GitHub (sobreescribe todo)
```

---

## 📖 Descripción del Proyecto

**Refugio de Animales** es un sistema de gestión desarrollado en **Java**, diseñado para que voluntarios puedan administrar de forma simple y eficiente lo siguiente:

- 🐶 Los **animales rescatados** que ingresan al refugio
- 🏷️ Las **especies** registradas en el sistema
- 📋 Los **estados de adopción** de cada animal
- 📊 **Reportes generales** del estado del refugio

El sistema está pensado para uso diario, con validaciones robustas que evitan errores y mensajes claros en cada acción.

---

## 🧩 Estructuras de Datos Usadas

| # | Estructura | Tipo Java | Propósito |
|---|---|---|---|
| 1️⃣ | **Lista** | `List<String>` | Almacena todos los animales registrados |
| 2️⃣ | **Mapa de estados** | `Map<String, String>` | Relaciona cada animal con su estado actual |
| 3️⃣ | **Conjunto de especies** | `Set<String>` | Guarda las especies sin permitir duplicados |
| 4️⃣ | **Mapa animal→especie** | `Map<String, String>` | Relaciona cada animal con su especie |
| 5️⃣ | **Arreglo de estados** | `String[]` | Define los estados fijos del sistema |

```java
List<String>        animales       // ["Firulais", "Mishi", "Rocky"]
Map<String, String> estadoAnimal   // {Firulais → "Disponible", Mishi → "Adoptado"}
Set<String>         especies       // {Perro, Gato, Conejo}
Map<String, String> animalEspecie  // {Firulais → "Perro", Mishi → "Gato"}
String[]            estados        // ["Disponible", "Adoptado"]
```

---

## ▶️ Cómo Ejecutar el Programa

### ✅ Requisitos previos

- Tener instalado **Java 11** o superior
- Una terminal o consola de comandos

### 🚀 Pasos

```bash
# 1. Clona el repositorio
git clone https://github.com/sabrinaceciliajeria-cmyk/RefugioAnimales

# 2. Entra a la carpeta del proyecto
cd refugio-animales

# 3. Compila el archivo Java
javac RefugioAnimales.java

# 4. Ejecuta el programa
java RefugioAnimales
```

---

## 🖥️ Ejemplo de Menú

Al ejecutar el programa verás el siguiente menú principal:

```
=== REFUGIO DE ANIMALES ===
1. Registrar animal
2. Registrar especie
3. Marcar animal como adoptado
4. Mostrar animales disponibles
5. Mostrar animales adoptados
6. Mostrar reporte general
7. Salir
===========================
Seleccione una opción:
```

### 📋 Ejemplo de Reporte General

```
--- Reporte General ---
Total animales: 3
Disponibles: 2
Adoptados: 1

Nombre | Especie | Estado
----------------------------
Firulais | Perro | Disponible
Mishi    | Gato  | Adoptado
Rocky    | Perro | Disponible
```

### ✅ Validaciones del sistema

```
❌ No se permiten animales duplicados
❌ No se puede registrar un animal con especie inexistente
❌ No se puede adoptar un animal que ya fue adoptado
❌ No se aceptan campos vacíos
✅ El programa nunca se rompe con entradas inválidas
```

---

## 📁 Estructura del Proyecto

```
refugio-animales/
│
├── 📄 RefugioAnimales.java   ← Código fuente principal
├── 📝 README.md                        ← Documentación del proyecto
└── 🚫 .gitignore                       ← Archivos ignorados por Git
```

---

## 👥 Integrantes del Equipo

| # | Nombre |
|---|---|
| 1 |  Sabrina Jeria
| 2 |  Diego Peña
| 3 |  Manuel Labrador
| 4 |  Arantxa Fischer
| 5 |  Natalia Medel
| 6 |  Cristopher Contreras
| 7 |  Cristian Díaz

---

<div align="center">

Hecho con ❤️ para los animales que esperan un hogar 🐾

</div>
