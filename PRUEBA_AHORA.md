# ✅ PRUEBA AHORA - PASO A PASO (5 MINUTOS)

## 🎯 OBJETIVO

Ejecutar la aplicación y hacer login exitosamente con los datos que se cargan automáticamente.

---

## ⏱️ TIEMPO ESTIMADO: 5 MINUTOS

```
1. Preparar base de datos   → 30 seg
2. Compilar proyecto        → 2 min
3. Ejecutar aplicación      → 30 seg
4. Probar login             → 1 min
5. Explorar vistas          → 1 min
```

---

## 📋 CHECKLIST PRE-EJECUCIÓN

Marca cada uno:

- [ ] PowerShell está abierto
- [ ] PostgreSQL está corriendo (ver abajo)
- [ ] Visual Studio Code está abierto con el proyecto
- [ ] Tienes conexión a internet (para descargar dependencias)

---

## ⚙️ VERIFICAR QUE POSTGRESQL ESTÁ CORRIENDO

### En PowerShell (como Administrador):

```powershell
# Verificar si está corriendo
Get-Service postgresql-x64-15

# Debería mostrar:
# Status   Name                DisplayName
# ------   ----                -----------
# Running  postgresql-x64-15   postgresql-x64-15
```

Si muestra `Stopped`:

```powershell
# Iniciar PostgreSQL
Start-Service postgresql-x64-15

# O si el nombre es diferente:
Get-Service postgres*  # para ver el nombre exacto
Start-Service [nombre que ves arriba]
```

---

## 🚀 EJECUCIÓN (COPY-PASTE EN POWERSHELL)

### Paso 1: Preparar BD (30 segundos)

```powershell
# Ir a la carpeta del proyecto
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento

# Eliminar BD anterior (si existe)
psql -U postgres -c "DROP DATABASE IF EXISTS \"GestionMantenimiento\";"

# Crear BD vacía
psql -U postgres -c "CREATE DATABASE \"GestionMantenimiento\";"
```

**Resultado esperado:**
```
CREATE DATABASE
```

### Paso 2: Compilar proyecto (2 minutos)

```powershell
# Limpiar y compilar
mvn clean install
```

**Espera a ver:**
```
[INFO] BUILD SUCCESS
```

Si ves `BUILD FAILURE`, hay un error. Copia el error y muéstramelo.

### Paso 3: Ejecutar aplicación (30 segundos)

```powershell
# Ejecutar el proyecto
mvn spring-boot:run
```

**Espera a ver estos mensajes:**

```
╔═══════════════════════════════════════════════════════╗
║    Inicializando datos de prueba...                   ║
╚═══════════════════════════════════════════════════════╝
✅ Rol creado: ADMINISTRADOR
✅ Rol creado: TECNICO
✅ Rol creado: EMPLEADO
✅ Usuario creado: juan.garcia@example.com (Solicitante)
✅ Usuario creado: carlos.martinez@example.com (Técnico de Mantenimiento)
✅ Usuario creado: maria.lopez@example.com (Jefe de Mantenimiento)
✅ Usuario creado: pedro.rodriguez@example.com (Personal de Oficina)
✅ Usuario creado: admin@example.com (Administrador del Sistema)
╔═══════════════════════════════════════════════════════╗
║    ✅ Datos de prueba cargados correctamente          ║
║    📝 Prueba con: juan.garcia@example.com            ║
║    🔐 Contraseña: password123                         ║
╚═══════════════════════════════════════════════════════╝
```

Y luego:

```
Tomcat started on port(s): 8080 (http)
```

**Si ves esto, ¡la aplicación está lista!**

---

## 🌐 PASO 4: ABRIR NAVEGADOR (1 minuto)

### Abre una nueva pestaña y ve a:

```
http://localhost:8080
```

**Deberías ver:**
```
┌─────────────────────────────────┐
│   🔧 SISTEMA DE GESTIÓN        │
│   DE MANTENIMIENTO              │
│                                 │
│   BIENVENIDO                    │
│                                 │
│   Seleccione su rol:            │
│                                 │
│   [👤 Solicitante]              │
│   [🔧 Técnico]                  │
│   [👔 Supervisor]               │
│   [💼 Administrador]            │
└─────────────────────────────────┘
```

---

## 🔑 PASO 5: HACER LOGIN (1 minuto)

### Haz clic en cualquier rol

Por ejemplo: **Solicitante**

Se abre una página de login:

```
┌──────────────────────────┐
│   INICIAR SESIÓN         │
│                          │
│   Email:     [_______]   │
│   Contraseña:[_______]   │
│                          │
│   [Iniciar Sesión]       │
└──────────────────────────┘
```

### Completa con:

```
Email: juan.garcia@example.com
Contraseña: password123
```

### Haz clic en "Iniciar Sesión"

**Resultado esperado:**
```
✅ REDIRECT A /dashboard
✅ Ves el panel de control personalizado
✅ Ves tu nombre: "Juan García"
✅ Ves tus roles
```

---

## ✨ PASO 6: EXPLORAR VISTAS (1 minuto)

### En el dashboard, verás:

```
Dashboard
└─ Panel Solicitante (botón)
└─ Mis Órdenes (botón)
└─ Reportes (botón)
└─ Logout
```

### Haz clic en "Panel Solicitante"

Verás:
```
Panel Solicitante
├─ 4 módulos interactivos
│  ├─ Abrir Ticket
│  ├─ Estado Ticket
│  ├─ Mis Órdenes
│  └─ Reportes
│
└─ Tus roles asignados
```

### Prueba: "Abrir Ticket"

Se abre un formulario:
```
Formulario de Ticket
├─ Tipo de Falla (select)
├─ Descripción (textarea)
├─ Ubicación (text)
├─ Equipo (text)
├─ Urgencia (radio: Baja/Media/Alta)
└─ Botones: Enviar / Cancelar
```

### Completa con datos de prueba:

```
Tipo de Falla: Eléctrica
Descripción: Tablero de control dañado
Ubicación: Piso 2
Equipo: Maquinaria Central
Urgencia: Alta
```

### Haz clic en "Enviar"

**Resultado:**
```
✅ REDIRECT A /solicitudes?exito=true
✅ Mensaje: "¡Éxito! Solicitud creada"
✅ Tu solicitud aparece en la lista
```

---

## 🎉 ¡FELICIDADES!

Si llegaste hasta aquí, **TODO FUNCIONA PERFECTAMENTE** ✅

```
┌──────────────────────────────────┐
│  ✅ BD FUNCIONANDO              │
│  ✅ AUTENTICACIÓN EXITOSA       │
│  ✅ VISTAS CARGADAS             │
│  ✅ FORMULARIOS GUARDANDO DATOS │
│                                  │
│  SISTEMA 100% OPERATIVO          │
└──────────────────────────────────┘
```

---

## 📚 PRÓXIMOS PASOS

### Probar otros usuarios:

```
carlos.martinez@example.com / password123 (Técnico)
maria.lopez@example.com / password123 (Jefe)
pedro.rodriguez@example.com / password123 (Empleado)
admin@example.com / admin123 (Administrador)
```

### Explorar la aplicación:

- [ ] Ir a /solicitante
- [ ] Ir a /abrirTicket
- [ ] Ir a /solicitudes
- [ ] Hacer logout
- [ ] Intentar acceder a /dashboard sin login (debe redirigir)

### Verificar BD:

```powershell
# En PowerShell, conectarse a BD
psql -U postgres -d GestionMantenimiento

# Ver usuarios:
SELECT * FROM usuario;

# Ver roles:
SELECT * FROM rol;

# Ver asignaciones:
SELECT u.nombre, r.nombre FROM usuario u 
JOIN usuario_rol ur ON u.id_usuario = ur.id_usuario 
JOIN rol r ON ur.id_rol = r.id_rol;

# Salir
\q
```

---

## 🆘 TROUBLESHOOTING

### Problema: "Connection refused"
**Solución:**
```powershell
Start-Service postgresql-x64-15
```

### Problema: "Port 8080 already in use"
**Solución:**
```powershell
# Encontrar proceso en puerto 8080
netstat -ano | findstr :8080

# Matar proceso (reemplaza [PID])
taskkill /PID [PID] /F

# Ejecutar aplicación nuevamente
mvn spring-boot:run
```

### Problema: "Build failed"
**Solución:**
- Borra carpeta `target`: `rmdir /s target`
- Intenta de nuevo: `mvn clean install`
- Si persiste, copia el error y muéstramelo

### Problema: "No se carga el CSS"
**Solución:**
- Limpia cache: `Ctrl+Shift+Delete` en navegador
- Recarga página: `Ctrl+F5`
- Cierra y abre otra pestaña

### Problema: Login sigue sin funcionar
**Solución:**
- Verifica que veas ✅ en la consola
- Copia exactamente el correo (minúsculas)
- Copia exactamente la contraseña
- Borra cookies: `Ctrl+Shift+Delete`

---

## 📞 SOPORTE

Si algo no funciona:

1. Copia todos los mensajes de error
2. Toma screenshot de la pantalla
3. Describe qué paso falla
4. Muéstramelo

Estaré listo para ayudarte 💪

---

## 🎊 ¡DISFRUTA TU APLICACIÓN!

Ahora tienes un **sistema de gestión de mantenimiento completamente funcional** con:

✅ Autenticación por email/contraseña
✅ Roles y permisos
✅ Vistas responsivas
✅ Formularios guardando datos
✅ CSS bonito y animaciones
✅ Datos que se cargan automáticamente

**Ningún SQL que correr. Ningún error de BD. Todo automático.**

¡Que lo disfrutes! 🚀
