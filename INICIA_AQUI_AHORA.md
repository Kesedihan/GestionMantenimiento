# 🎯 GUÍA RÁPIDA - PARA EMPEZAR AHORA

## 1️⃣ PASO 1: CREAR BASE DE DATOS (30 segundos)

Abre PowerShell y ejecuta:

```powershell
psql -U postgres -c "CREATE DATABASE \"GestionMantenimiento\";"
```

Si te pide contraseña, ingresa la que configuraste en PostgreSQL.

---

## 2️⃣ PASO 2: CARGAR DATOS EN LA BD (1 minuto)

Navega a la carpeta del proyecto y ejecuta:

```powershell
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento
psql -U postgres -d GestionMantenimiento -f datos_prueba_simple.sql
```

**Si tienes error**, intenta con el otro script:
```powershell
psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

---

## 3️⃣ PASO 3: COMPILAR PROYECTO (2 minutos)

```powershell
mvn clean install
```

Espera a que termине. Deberías ver "BUILD SUCCESS" al final.

---

## 4️⃣ PASO 4: EJECUTAR APLICACIÓN (30 segundos)

```powershell
mvn spring-boot:run
```

Espera hasta ver algo como:
```
Tomcat started on port(s): 8080 (http)
```

---

## 5️⃣ PASO 5: ABRIR EN NAVEGADOR (10 segundos)

Abre tu navegador y ve a:

```
http://localhost:8080
```

---

## 6️⃣ PASO 6: PROBAR LOGIN (1 minuto)

### En la página de inicio:
- Haz clic en cualquier rol (todos van a login)

### En la página de login:
- **Email**: `juan.garcia@example.com`
- **Contraseña**: `password123`
- Haz clic en "Iniciar Sesión"

---

## 7️⃣ PASO 7: EXPLORAR VISTAS NUEVAS (2 minutos)

### Después de loguearte, verás:

1. **Dashboard** - Tu perfil y módulos
2. **Panel Solicitante** - Haz clic en cualquier módulo o ve a `/solicitante`
3. **Abrir Ticket** - Clic en "Nueva Solicitud" o ve a `/abrirTicket`
4. **Mis Solicitudes** - Ve a `/solicitudes`

---

## 📝 QUÉ HACER EN CADA VISTA

### ✅ Panel Solicitante (`/solicitante`)
```
Verás 4 módulos:
• Abrir Ticket → Clic para crear nueva solicitud
• Estado Ticket → Ver tus solicitudes
• Mis Órdenes → Ordenes de trabajo (futuro)
• Reportes → Descargar reportes (futuro)
```

### ✅ Abrir Ticket (`/abrirTicket`)
```
Formulario con:
1. Tipo de Falla (dropdown)
2. Descripción (textarea)
3. Ubicación (text input)
4. Urgencia (radio buttons: Baja, Media, Alta)
5. Botones: Enviar | Cancelar
```

### ✅ Mis Solicitudes (`/solicitudes`)
```
Verás:
• Información del usuario
• Lista de solicitudes (tabla)
• Estadísticas: Pendientes, En Proceso, Completadas, Cerradas
```

---

## 🔑 OTRAS CREDENCIALES DE PRUEBA

| Email | Contraseña | Rol |
|-------|-----------|-----|
| juan.garcia@example.com | password123 | Solicitante |
| carlos.martinez@example.com | password123 | Operario |
| maria.lopez@example.com | password123 | Jefe Mantenimiento |
| pedro.rodriguez@example.com | password123 | Oficina Mantenimiento |
| admin@example.com | admin123 | Administrador |

---

## ⚠️ PROBLEMAS COMUNES

### "Connection refused"
```
→ PostgreSQL no está corriendo
→ Solución: Inicia PostgreSQL desde Servicios de Windows
```

### "Database does not exist"
```
→ No ejecutaste PASO 1
→ Solución: Corre: psql -U postgres -c "CREATE DATABASE \"GestionMantenimiento\";"
```

### "No data available"
```
→ No ejecutaste PASO 2
→ Solución: Corre: psql -U postgres -d GestionMantenimiento -f datos_prueba_simple.sql
```

### "Maven not found"
```
→ Maven no está en PATH
→ Solución: Instala Maven o usa el mvnw incluido:
   .\mvnw clean install
   .\mvnw spring-boot:run
```

### "CSS no se ve"
```
→ Limpia el cache del navegador
→ Solución: F12 → Ctrl+Shift+Delete → Limpiar → Recargar F5
```

---

## 📊 QUÉ VERÁS

### 🎨 Página de Inicio (`/`)
- Navbar azul con logo
- 4 tarjetas de rol (todas van a login)
- Estilos modernos con gradientes

### 🔓 Login (`/login`)
- Formulario centrado
- Campo de email y contraseña
- Botones de iniciar sesión y volver
- Manejo de errores con alertas

### 📊 Dashboard (`/dashboard`)
- Navbar con usuario actual
- Perfil y roles del usuario
- 4 módulos principales

### 👤 Panel Solicitante (`/solicitante`)
- Navbar con usuario y logout
- Header con título y botón de nueva solicitud
- Información de roles
- 4 módulos interactivos

### 📝 Abrir Ticket (`/abrirTicket`)
- Navbar con volver
- Formulario con secciones numeradas
- Validación de campos
- Envío y captura en BD

### 📋 Mis Solicitudes (`/solicitudes`)
- Navbar con opciones
- Información general del usuario
- Tabla de solicitudes
- 4 tarjetas de estadísticas

---

## 🎯 FLUJO COMPLETO (5 minutos)

```
1. http://localhost:8080
   ↓
2. Selecciona un rol cualquiera
   ↓
3. Login: juan.garcia@example.com / password123
   ↓
4. Ves Dashboard
   ↓
5. Click "Panel Solicitante" o ve a /solicitante
   ↓
6. Click "Abrir Ticket" o ve a /abrirTicket
   ↓
7. Completa formulario y envía
   ↓
8. Ves confirmación: "¡Éxito! Tu solicitud ha sido creada"
   ↓
9. Click "Mis Solicitudes" para ver tu nueva solicitud
   ↓
10. ¡Listo! 🎉
```

---

## 🎨 CARACTERÍSTICAS NUEVAS

✨ **Vistas Nueva**
- Panel de Solicitante
- Formulario para Abrir Tickets
- Lista de Solicitudes

🎨 **Diseño**
- Navbar con usuario actual
- Gradientes azules profesionales
- Animaciones suaves
- Tarjetas modernas
- Responsivo para móvil

🔐 **Seguridad**
- Validación de sesión
- Protección de rutas
- Roles diferenciados
- Asignación automática de usuario

🗄️ **Base de Datos**
- 5 usuarios de prueba
- 5 roles diferentes
- Solicitudes vinculadas a usuarios
- Tipos de falla y ubicaciones

---

## 📞 COMANDOS ÚTILES

```powershell
# Ver estado de PostgreSQL
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM usuario;"

# Ver roles
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM rol;"

# Ver solicitudes
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM solicitud_mantenimiento;"

# Detener aplicación Spring Boot
Ctrl + C (en la terminal donde corre mvn spring-boot:run)

# Reiniciar
mvn spring-boot:run
```

---

## 🚀 ¡LISTO!

Ya tienes todo listo para:
- ✅ Loguearte
- ✅ Ver tu panel
- ✅ Abrir tickets
- ✅ Ver solicitudes
- ✅ Experimentar con diferentes roles

**¿Preguntas?** Consulta:
- `CARGAR_DATOS_BD.md` - Problemas con base de datos
- `VISTAS_ACTUALIZADAS.md` - Resumen de cambios
- `ARQUITECTURA.md` - Estructura completa
- `COMIENZA_AQUI.md` - Guía general

---

**Hecho con ❤️ | Spring Boot 3.5.7 | Thymeleaf | Bootstrap 5 | PostgreSQL**

¡Disfruta! 🎉
