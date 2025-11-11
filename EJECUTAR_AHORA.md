# 🎯 EJECUTAR EL PROYECTO - INSTRUCCIONES FINALES

## ✅ Verificación Previa (2 minutos)

### 1. Verificar PostgreSQL
```bash
# En PowerShell como Administrador
# Verificar que PostgreSQL esté instalado
psql --version

# Debería mostrar algo como: psql (PostgreSQL) 12.x
```

### 2. Verificar Maven
```bash
# En PowerShell
mvn --version

# Debería mostrar algo como: Apache Maven 3.8.x
```

### 3. Verificar Java
```bash
# En PowerShell
java -version

# Debería mostrar: Java 25 (o una versión compatible)
```

---

## 🗄️ Preparar la Base de Datos (2 minutos)

### Paso 1: Crear la base de datos
```sql
-- Abrir pgAdmin o psql
CREATE DATABASE "GestionMantenimiento";
```

### Paso 2: Insertar datos de prueba
```bash
# En PowerShell, en la carpeta del proyecto
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento

psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

**Deberías ver**:
```
INSERT 0 1
INSERT 0 1
...
(varias líneas)
```

✅ Si ves esto, la BD está lista.

---

## 🚀 Ejecutar el Proyecto (1 minuto)

### Opción 1: Ejecutar directamente

```bash
# En PowerShell, en la carpeta del proyecto
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento

# Limpiar y compilar
mvn clean install

# Ejecutar
mvn spring-boot:run
```

**Espera a ver este mensaje**:
```
Started ProyectoHackatonApplication in X.XXX seconds (JVM running for Y.YYY)
```

### Opción 2: Compilar y ejecutar por separado

```bash
# Compilar
mvn clean package

# Ejecutar
java -jar target/proyectoHackaton-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Acceder a la Aplicación

### 1️⃣ Abre tu navegador
```
http://localhost:8080
```

### 2️⃣ Deberías ver
```
┌─────────────────────────────────┐
│       INICIO                    │ (navbar azul)
├─────────────────────────────────┤
│                                 │
│        BIENVENIDO               │
│   Seleccione su rol:            │
│                                 │
│  [Solicitante] [Oficina]       │
│  [Jefe]       [Operario]       │
│                                 │
└─────────────────────────────────┘
```

✅ Si ves esto, **¡el CSS está funcionando!** 🎉

---

## 🔓 Prueba el Login

### Hacer login
1. Click en cualquier tarjeta (ej: Solicitante)
2. Te llevará a http://localhost:8080/login
3. Ingresa las siguientes credenciales:

```
Correo: juan.garcia@example.com
Contraseña: password123
```

4. Click "Iniciar Sesión"

### Verás el Dashboard
```
┌──────────────────────────────────┐
│ SGM - Mantenimiento              │
│ Bienvenido: Juan García [Logout] │
├──────────────────────────────────┤
│ PERFIL             PANEL CONTROL │
│ • Correo           ┌────────────┐│
│ • Teléfono    [📋] [🔧] [📊]   ││
│ • Cargo       [Solicitudes...]  ││
│               └────────────────┘│
│ ROLES              [📦] Equipos  │
│ [SOLICITANTE]                    │
└──────────────────────────────────┘
```

✅ Si ves esto, **¡todo está funcionando!** 🎉

---

## 🎨 Verificar que CSS Cargue

### Método 1: Visual
En cualquier página deberías ver:
- ✅ **Colores azules** en bordes y botones
- ✅ **Fondo oscuro** (gris/negro)
- ✅ **Efectos hover** cuando pasas mouse
- ✅ **Texto claro** y legible
- ✅ **Botones con gradientes**

### Método 2: Developer Tools
1. Abre: **F12** (Developer Tools)
2. Ve a pestaña: **Network**
3. Recarga: **F5**
4. Busca estos archivos:
   ```
   index.css    ← Status: 200 ✅
   login.css    ← Status: 200 ✅
   dashboard.css ← Status: 200 ✅
   ```

### Método 3: Verificar en HTML
1. En Developer Tools, ve a **Elements**
2. Busca `<link rel="stylesheet"...`
3. Deberías ver:
   ```html
   <link rel="stylesheet" href="/index.css">
   <!-- O -->
   <link rel="stylesheet" href="/login.css">
   <!-- O -->
   <link rel="stylesheet" href="/dashboard.css">
   ```

✅ Si ves esto, **CSS está cargando correctamente** 🎉

---

## ⚠️ Si Algo No Funciona

### Problem 1: "Connection refused" a PostgreSQL
```bash
# Solución: Iniciar PostgreSQL
# En Windows, ir a: Services → buscar "postgresql" → Iniciar
# O en PowerShell (como Admin):
net start postgresql-x64-15
```

### Problem 2: "Port 8080 already in use"
```bash
# Cambiar puerto en application.properties:
# Agregar: server.port=8081

# O matar el proceso que usa 8080:
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Problem 3: CSS no se ve (página blanca)
```bash
# 1. Limpiar cache del navegador
# F12 → Ctrl+Shift+Delete → Limpiar

# 2. Hard refresh
# Ctrl+Shift+R (Windows)

# 3. Recompilar el proyecto
mvn clean install
mvn spring-boot:run

# 4. Abre en navegador privado/incógnito
```

### Problem 4: "Tabla no encontrada"
```bash
# 1. Verificar que la BD fue creada
# En pgAdmin o psql:
\l

# 2. Verificar que los datos se insertaron
# En pgAdmin o psql:
SELECT COUNT(*) FROM usuario;

# 3. Si aún falla, recompilar
mvn clean install
```

### Problem 5: Errores en consola Maven
```bash
# Solución:
# 1. Copiar el error completo
# 2. Verificar que sea un error real (no advertencia)
# 3. Si es un error, limpiar y recompilar:
mvn clean install -DskipTests
```

---

## 📝 Credenciales de Prueba Disponibles

```
┌──────────────────────────────────────────────────────┐
│ USUARIO               │ CONTRASEÑA  │ ROL            │
├──────────────────────────────────────────────────────┤
│ juan.garcia@...      │ password123 │ SOLICITANTE    │
│ carlos.martinez@...  │ password123 │ OPERARIO       │
│ maria.lopez@...      │ password123 │ JEFE_MANT.    │
│ pedro.rodriguez@...  │ password123 │ OFICINA_MANT. │
│ admin@example.com    │ admin123    │ ADMINISTRADOR  │
└──────────────────────────────────────────────────────┘
```

---

## 🎯 Checklist de Ejecución

```bash
# ✅ Hacer esto en orden:

[ ] 1. PostgreSQL corriendo
     net start postgresql-x64-15

[ ] 2. BD creada
     CREATE DATABASE "GestionMantenimiento";

[ ] 3. Datos insertados
     psql -U postgres -d GestionMantenimiento -f datos_prueba.sql

[ ] 4. Compilar proyecto
     mvn clean install

[ ] 5. Ejecutar aplicación
     mvn spring-boot:run

[ ] 6. Abrir navegador
     http://localhost:8080

[ ] 7. Ver página de inicio con estilos ✅

[ ] 8. Hacer login
     juan.garcia@example.com / password123

[ ] 9. Ver dashboard personalizado ✅

[ ] 10. Verificar CSS en todos los elementos
```

---

## 🔄 Flujo Completo

```
1. http://localhost:8080
   ↓
   Página de Inicio (con CSS azul)
   ↓
2. Click en "Solicitante"
   ↓
   http://localhost:8080/login
   ↓
   Formulario Login (con CSS bonito)
   ↓
3. Ingresa credenciales:
   - juan.garcia@example.com
   - password123
   ↓
   Click "Iniciar Sesión"
   ↓
4. http://localhost:8080/dashboard
   ↓
   Dashboard personalizado (con CSS profesional)
   ↓
5. Ver información del usuario
   - Nombre: Juan García
   - Rol: SOLICITANTE
   - Módulos disponibles
```

---

## 💡 Tips Útiles

### Ver logs en tiempo real
```bash
# Los logs se mostrarán en la consola mientras ejecutas:
mvn spring-boot:run

# Buscar errores:
# Buscar líneas que contengan: ERROR, Exception, error
```

### Detener la aplicación
```bash
# En PowerShell:
# Presiona: Ctrl + C
```

### Ejecutar en background (opcional)
```bash
# Ejecutar sin ocupar la terminal:
# (Abre PowerShell nueva y ejecuta en la carpeta del proyecto)
Start-Process -NoNewWindow mvn clean install ; Start-Process -NoNewWindow mvn spring-boot:run
```

---

## 📚 Documentación Disponible

| Archivo | Contenido |
|---------|-----------|
| `INICIO_RAPIDO.md` | 3 pasos para ejecutar |
| `GUIA_CONFIGURACION.md` | Configuración detallada |
| `CAMBIOS_REALIZADOS.md` | Cambios técnicos |
| `ARQUITECTURA.md` | Diagramas de arquitectura |
| `CSS_ACTUALIZADO.md` | Detalles de CSS |
| `VERIFICACION_CHECKLIST.md` | Checklist completo |
| `RESUMEN_CSS_FINAL.md` | Resumen de CSS |

---

## ✨ Resumen Final

**Antes** ❌
- CSS no se veía
- Aplicación sin estilos
- Rutas incorrectas

**Ahora** ✅
- CSS carga perfectamente
- Diseño profesional y moderno
- Todas las rutas correctas
- Completamente funcional

---

## 🎉 ¡Listo para Ejecutar!

```bash
# Abre PowerShell en la carpeta del proyecto y ejecuta:

cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento

mvn spring-boot:run
```

**¡Luego abre http://localhost:8080 en tu navegador!** 🚀

---

**Si tienes problemas, verifica**:
1. ✅ PostgreSQL está en ejecución
2. ✅ Base de datos existe
3. ✅ Datos de prueba están insertados
4. ✅ Maven compila sin errores
5. ✅ Java versión 25 o compatible
6. ✅ Puerto 8080 no está ocupado

**¡Éxito! 🎯**
