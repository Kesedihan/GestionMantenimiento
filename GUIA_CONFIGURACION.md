# Sistema de Gestión de Mantenimiento - Guía de Configuración

## 📋 Descripción
Sistema de gestión de mantenimiento desarrollado con Spring Boot 3.5.7, usando:
- **Framework**: Spring Boot
- **Template Engine**: Thymeleaf
- **Base de Datos**: PostgreSQL
- **Seguridad**: Spring Security
- **Build Tool**: Maven

## 🚀 Requisitos Previos

### Software Necesario:
- **Java 25** (o superior)
- **Maven 3.8+**
- **PostgreSQL 12+**
- **IDE recomendado**: IntelliJ IDEA o Visual Studio Code

### Base de Datos:
1. Crear la base de datos en PostgreSQL:
```sql
CREATE DATABASE "GestionMantenimiento";
```

2. Asegurar que las credenciales en `application.properties` sean correctas:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/GestionMantenimiento
spring.datasource.username=postgres
spring.datasource.password=1077846858
```

## 🔧 Instalación y Ejecución

### 1. Clonar o Descargar el Proyecto
```bash
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento
```

### 2. Compilar el Proyecto
```bash
mvn clean install
```

### 3. Ejecutar el Proyecto
```bash
mvn spring-boot:run
```

O si prefieres usar Java directamente:
```bash
mvn clean package
java -jar target/proyectoHackaton-0.0.1-SNAPSHOT.jar
```

### 4. Acceder a la Aplicación
Abre tu navegador y ve a: **http://localhost:8080**

## 📱 Navegación de la Aplicación

### Página de Inicio (`/`)
- Muestra 4 opciones de roles:
  - Solicitante
  - Oficina de Mantenimiento
  - Jefe de Mantenimiento
  - Operario
- Cada opción redirige al login

### Página de Login (`/login`)
- Campo de **Correo Electrónico**
- Campo de **Contraseña**
- Validación de credenciales
- Mensajes de error

### Dashboard (`/dashboard`)
- Bienvenida personalizada con nombre del usuario
- Visualización de roles asignados
- Módulos disponibles:
  - Solicitudes de Mantenimiento
  - Órdenes de Trabajo
  - Reportes y Análisis
  - Catálogo de Equipos

## 🗂️ Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/proyectohackaton/
│   │       ├── Config/
│   │       │   ├── SecurityConfig.java      # Configuración de seguridad
│   │       │   └── WebConfig.java            # Configuración web
│   │       ├── Controller/
│   │       │   └── AuthController.java       # Controlador de autenticación
│   │       ├── Entity/                       # Entidades JPA
│   │       ├── Repository/                   # Repositorios
│   │       ├── Service/                      # Servicios de lógica de negocio
│   │       └── ProyectoHackatonApplication.java
│   └── resources/
│       ├── application.properties            # Configuración de la app
│       ├── static/                           # Recursos estáticos (CSS, JS)
│       └── templates/                        # Vistas Thymeleaf
│           ├── index.html
│           ├── login.html
│           └── dashboard.html
```

## 🔐 Seguridad

### Características de Seguridad:
- **Spring Security**: Autenticación y autorización
- **BCryptPasswordEncoder**: Cifrado de contraseñas
- **Session Management**: Gestión de sesiones de usuario
- **CSRF Protection**: Protección contra ataques CSRF

### Rutas Públicas:
- `/` - Página de inicio
- `/login` - Página de login
- `/css/**`, `/js/**`, `/images/**` - Recursos estáticos

### Rutas Protegidas:
- `/dashboard` - Requiere autenticación

## 📊 Base de Datos

Las tablas se crean automáticamente mediante **Hibernate** con la configuración:
```properties
spring.jpa.hibernate.ddl-auto=update
```

### Principales Entidades:
- **Usuario**: Almacena información de usuarios
- **Rol**: Define roles del sistema
- **SolicitudMantenimiento**: Solicitudes de mantenimiento
- **OrdenDeTrabajo**: Órdenes de trabajo
- **Equipo**: Equipos del sistema
- Y más...

## 🛠️ Servicios y Controladores

### Servicios Disponibles:

#### UsuarioService
```java
- obtenerTodosLosUsuarios()
- obtenerUsuarioPorId(Long)
- obtenerUsuarioPorCorreo(String)
- crearUsuario(Usuario)
- actualizarUsuario(Usuario)
- eliminarUsuario(Long)
- validarCredenciales(String, String)
```

#### RolService
```java
- obtenerTodosLosRoles()
- obtenerRolPorId(Long)
- crearRol(Rol)
- actualizarRol(Rol)
- eliminarRol(Long)
```

### Controladores:

#### AuthController
```
GET  /             -> Página de inicio
GET  /login        -> Formulario de login
POST /login        -> Procesar login
GET  /logout       -> Cerrar sesión
GET  /dashboard    -> Panel de control
```

## 🎨 Vistas Thymeleaf

Todas las vistas HTML utilizan **Thymeleaf** para:
- Binding de datos del modelo
- Navegación con rutas dinámicas (`th:href="@{...}"`)
- Validación y mensajes de error
- Seguridad con CSRF tokens

### Ejemplo:
```html
<a th:href="@{/login}" class="btn btn-primary">Iniciar Sesión</a>
<span th:text="${usuario.nombre}"></span>
<div th:if="${error}" class="alert alert-danger">...</div>
```

## 📝 Crear Datos de Prueba

Para crear usuarios de prueba, puedes usar cualquier herramienta SQL:

```sql
-- Insertar un usuario de prueba
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Juan', 'Pérez', 'juan@example.com', 'password123', '3001234567', true, 'Solicitante');

-- Insertar roles
INSERT INTO nombre_rol (nombre_rol) VALUES ('SOLICITANTE');
INSERT INTO nombre_rol (nombre_rol) VALUES ('OPERARIO');
INSERT INTO nombre_rol (nombre_rol) VALUES ('JEFE_MANTENIMIENTO');
INSERT INTO nombre_rol (nombre_rol) VALUES ('OFICINA_MANTENIMIENTO');
```

## ⚠️ Notas Importantes

1. **Contraseñas en Desarrollo**: En desarrollo, las contraseñas se almacenan en texto plano. Para producción, usar BCryptPasswordEncoder.

2. **PostgreSQL**: Asegurar que el servicio PostgreSQL esté en ejecución.

3. **Puerto por defecto**: La aplicación corre en `http://localhost:8080`

4. **Cache de Thymeleaf**: Deshabilitado para desarrollo:
   ```properties
   spring.thymeleaf.cache=false
   ```

## 🔍 Troubleshooting

### Error: "Connection refused"
- Verificar que PostgreSQL esté corriendo
- Verificar credenciales en `application.properties`

### Error: "Puerto 8080 ya en uso"
- Cambiar el puerto en `application.properties`:
  ```properties
  server.port=8081
  ```

### Error: "Tabla no encontrada"
- Ejecutar: `mvn clean install`
- Asegurar que Hibernate cree las tablas automáticamente

## 📚 Próximos Pasos

1. Crear más controladores para los módulos de:
   - Solicitudes de Mantenimiento
   - Órdenes de Trabajo
   - Reportes
   - Equipos

2. Implementar validación de formularios

3. Crear interfaces REST API

4. Implementar logging completo

5. Agregar pruebas unitarias e integración

## 📞 Soporte

Para problemas o preguntas, verificar:
- Logs de la aplicación
- Configuración de `application.properties`
- Estado de la base de datos
- Versiones compatibles de Java y Maven

---

**Desarrollado con ❤️ usando Spring Boot 3.5.7 y Thymeleaf**
