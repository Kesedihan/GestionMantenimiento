# 📝 INSTRUCCIONES PARA CARGAR DATOS EN LA BD

## Opción 1: Desde Windows PowerShell (Recomendado)

### Paso 1: Abre PowerShell
```powershell
# Navega a la carpeta del proyecto
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento
```

### Paso 2: Conecta a PostgreSQL y carga el script
```powershell
# Asumiendo que PostgreSQL está instalado en el PATH
psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

Si te pide contraseña, ingresa la que configuraste en PostgreSQL.

---

## Opción 2: Desde pgAdmin (GUI)

### Paso 1: Abre pgAdmin
1. Abre pgAdmin en el navegador
2. Conéctate al servidor PostgreSQL

### Paso 2: Crea la base de datos
```sql
CREATE DATABASE "GestionMantenimiento";
```

### Paso 3: Ejecuta el script
1. Selecciona la BD `GestionMantenimiento`
2. Haz clic en **Query Tool** (o Tools > Query Tool)
3. Copia el contenido de `datos_prueba.sql`
4. Pégalo en la ventana de Query Tool
5. Presiona **F5** o haz clic en **Execute**

---

## Opción 3: Desde Command Prompt (cmd)

```cmd
cd C:\Users\Kese\Documents\GitHub\GestionMantenimiento
psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

---

## ❌ PROBLEMAS COMUNES

### Error: "FATAL: role 'postgres' does not exist"
**Solución**: Cambia `postgres` por el usuario que creaste en PostgreSQL
```powershell
psql -U tu_usuario -d GestionMantenimiento -f datos_prueba.sql
```

### Error: "database 'GestionMantenimiento' does not exist"
**Solución**: Crea primero la base de datos
```powershell
psql -U postgres -c "CREATE DATABASE \"GestionMantenimiento\";"
psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

### Error: "syntax error near 'ON CONFLICT'"
**Solución**: Usa el script alternativo `datos_prueba_simple.sql` (sin ON CONFLICT)

### Error: "table 'usuario' does not exist"
**Solución**: Primero compila y ejecuta el proyecto Spring Boot para que Hibernate cree las tablas:
```powershell
mvn clean install
mvn spring-boot:run
```
Luego carga los datos después de que aparezca "Tomcat started on port 8080"

---

## ✅ CÓMO VERIFICAR QUE LOS DATOS SE CARGARON

### Desde PowerShell
```powershell
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM usuario;"
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM rol;"
psql -U postgres -d GestionMantenimiento -c "SELECT * FROM usuario_rol;"
```

### Desde pgAdmin
1. Expande `GestionMantenimiento` > `Schemas` > `public` > `Tables`
2. Haz clic derecho en `usuario` > `View/Edit Data` > `All Rows`
3. Deberías ver los 5 usuarios

---

## 🔑 CREDENCIALES DE PRUEBA

Una vez cargados los datos, puedes usar:

| Email | Contraseña | Rol |
|-------|-----------|-----|
| juan.garcia@example.com | password123 | Solicitante |
| carlos.martinez@example.com | password123 | Operario |
| maria.lopez@example.com | password123 | Jefe Mantenimiento |
| pedro.rodriguez@example.com | password123 | Oficina Mantenimiento |
| admin@example.com | admin123 | Administrador |

---

## 📋 SCRIPT PASO A PASO (Si lo haces manual)

Si prefieres insertarlos uno por uno:

```sql
-- 1. Crear roles
INSERT INTO rol (nombre) VALUES ('SOLICITANTE');
INSERT INTO rol (nombre) VALUES ('OPERARIO');
INSERT INTO rol (nombre) VALUES ('JEFE_MANTENIMIENTO');
INSERT INTO rol (nombre) VALUES ('OFICINA_MANTENIMIENTO');
INSERT INTO rol (nombre) VALUES ('ADMINISTRADOR');

-- 2. Crear usuarios
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Juan', 'García', 'juan.garcia@example.com', 'password123', '3001234567', true, 'Solicitante');

INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Carlos', 'Martínez', 'carlos.martinez@example.com', 'password123', '3009876543', true, 'Operario');

INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('María', 'López', 'maria.lopez@example.com', 'password123', '3005555555', true, 'Jefe de Mantenimiento');

INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Pedro', 'Rodríguez', 'pedro.rodriguez@example.com', 'password123', '3004444444', true, 'Personal de Oficina');

INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Admin', 'Sistema', 'admin@example.com', 'admin123', '3003333333', true, 'Administrador del Sistema');

-- 3. Asignar roles (obtén los IDs primero)
SELECT * FROM usuario;
SELECT * FROM rol;

-- Luego asigna (reemplaza los números con los IDs reales):
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);  -- Juan es Solicitante
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);  -- Carlos es Operario
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 3);  -- María es Jefe
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (4, 4);  -- Pedro es Oficina
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 1); -- Admin es Solicitante
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 2); -- Admin es Operario
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 3); -- Admin es Jefe
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 4); -- Admin es Oficina
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 5); -- Admin es Administrador
```

---

## 🎯 PRÓXIMOS PASOS

1. ✅ Cargar datos en BD
2. ✅ Compilar proyecto: `mvn clean install`
3. ✅ Ejecutar: `mvn spring-boot:run`
4. ✅ Acceder: http://localhost:8080
5. ✅ Loguearse con juan.garcia@example.com / password123

¡Listo! 🚀
