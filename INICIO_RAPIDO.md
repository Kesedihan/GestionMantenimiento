# 🚀 GUÍA RÁPIDA DE INICIO

## ⚡ 3 Pasos para Ejecutar el Proyecto

### 1. Crear la Base de Datos
```sql
-- En PostgreSQL (pgAdmin o psql)
CREATE DATABASE "GestionMantenimiento";
```

### 2. Insertar Datos de Prueba
```bash
# En PowerShell o CMD
psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

### 3. Ejecutar la Aplicación
```bash
# En la carpeta del proyecto
mvn spring-boot:run
```

---

## 🌐 Acceder a la Aplicación

Abre tu navegador en:
```
http://localhost:8080
```

---

## 🔓 Credenciales de Prueba

Prueba con cualquiera de estos usuarios:

```
Correo: juan.garcia@example.com
Contraseña: password123

O

Correo: admin@example.com
Contraseña: admin123
```

---

## 📁 Archivos Importantes

| Archivo | Descripción |
|---------|------------|
| `CAMBIOS_REALIZADOS.md` | 📋 Resumen completo de todos los cambios |
| `GUIA_CONFIGURACION.md` | 📚 Guía detallada de configuración |
| `datos_prueba.sql` | 🗂️ Script SQL con datos de prueba |
| `pom.xml` | ⚙️ Dependencias del proyecto |

---

## 🎯 Estructura del Proyecto Después de los Cambios

```
GestionMantenimiento/
├── src/main/java/com/example/proyectohackaton/
│   ├── Config/
│   │   ├── SecurityConfig.java ✨ NUEVO
│   │   └── WebConfig.java ✨ NUEVO
│   ├── Controller/
│   │   └── AuthController.java ✨ ACTUALIZADO
│   ├── Service/
│   │   ├── UsuarioService.java ✨ NUEVO
│   │   └── RolService.java ✨ ACTUALIZADO
│   └── Entity/ (Entidades existentes)
│
├── src/main/resources/
│   ├── templates/
│   │   ├── index.html ✨ ACTUALIZADO (Thymeleaf)
│   │   ├── login.html ✨ ACTUALIZADO (Thymeleaf)
│   │   └── dashboard.html ✨ NUEVO
│   ├── static/
│   │   ├── css/
│   │   └── js/
│   └── application.properties
│
├── pom.xml ✨ ACTUALIZADO
├── CAMBIOS_REALIZADOS.md ✨ NUEVO
├── GUIA_CONFIGURACION.md ✨ NUEVO
├── datos_prueba.sql ✨ NUEVO
└── README.md
```

---

## ✨ Lo que Ahora Funciona

✅ **Página de Inicio** (`/`)
- Selecciona tu rol
- Interfaces visual amigable

✅ **Login** (`/login`)
- Ingresa con correo electrónico
- Validación automática

✅ **Dashboard** (`/dashboard`)
- Panel personalizado
- Ver tu perfil y roles
- Acceso a módulos

✅ **Logout** (`/logout`)
- Cierra sesión correctamente

---

## 🔍 Solucionar Problemas Comunes

### ❌ Error: "Connection refused"
**Solución**: Verifica que PostgreSQL esté en ejecución
```bash
# Verificar estado
pg_isready -h localhost
```

### ❌ Error: "Port 8080 already in use"
**Solución**: Cambiar puerto en `application.properties`
```properties
server.port=8081
```

### ❌ Error: "Tabla no encontrada"
**Solución**: Ejecutar:
```bash
mvn clean install
```

### ❌ Error: "Template not found"
**Solución**: Asegurar que HTMLs estén en `src/main/resources/templates/`

---

## 📞 Próximos Pasos Opcionales

1. **Crear más controladores** para otros módulos
2. **Agregar validación** en los formularios
3. **Implementar REST API** con JSON
4. **Agregar pruebas unitarias**
5. **Mejorar diseño UI** con Bootstrap customizado

---

## 💡 Consejo Importante

Si quieres usar **contraseñas encriptadas** en el futuro, necesitarás:

1. Generar hash BCrypt:
```java
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
String hashedPassword = encoder.encode("password123");
```

2. Insertar en la BD:
```sql
UPDATE usuario SET contrasena = '$2a$10...' WHERE correo = 'user@example.com';
```

---

**¡Listo para empezar! 🎉**

Si necesitas ayuda, revisa `GUIA_CONFIGURACION.md`
