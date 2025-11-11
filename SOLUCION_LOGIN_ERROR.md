# 🔧 SOLUCIÓN: DATOS CARGADOS AUTOMÁTICAMENTE

## ✅ ¿QUÉ SE FIX?

El problema era que:
- ❌ Los datos NO estaban siendo cargados en la BD
- ❌ Al hacer login, siempre devolvía "error"
- ❌ Había que ejecutar SQL manualmente

**Ahora:**
- ✅ Los datos se crean AUTOMÁTICAMENTE al iniciar
- ✅ Los usuarios se cargan cada vez que ejecutas el proyecto
- ✅ No necesitas scripts SQL

---

## 🚀 CÓMO FUNCIONA AHORA

### Paso 1: Limpia (opcional pero recomendado)

```powershell
# En PowerShell
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento

# Opcional: Borrar BD anterior
psql -U postgres -c "DROP DATABASE IF EXISTS \"GestionMantenimiento\";"

# Crear BD vacía
psql -U postgres -c "CREATE DATABASE \"GestionMantenimiento\";"
```

### Paso 2: Ejecutar la aplicación

```powershell
# Compilar
mvn clean install

# Ejecutar
mvn spring-boot:run
```

### Paso 3: Esperar el mensaje

Verás en la consola:

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

### Paso 4: Abrir navegador

```
http://localhost:8080
```

### Paso 5: Login

- **Email**: `juan.garcia@example.com`
- **Contraseña**: `password123`

✅ ¡Ahora funciona!

---

## 📊 USUARIOS DISPONIBLES

### Rol: EMPLEADO
```
juan.garcia@example.com
password123
```

### Rol: TÉCNICO
```
carlos.martinez@example.com
password123
```

```
maria.lopez@example.com
password123
```

### Rol: EMPLEADO (Oficina)
```
pedro.rodriguez@example.com
password123
```

### Rol: ADMINISTRADOR
```
admin@example.com
admin123
```

---

## 🔧 ARCHIVOS MODIFICADOS

### ✨ NUEVO: `DataInitializer.java`

```
src/main/java/com/example/proyectohackaton/Config/DataInitializer.java
```

**¿Qué hace?**
- Implement `CommandLineRunner` - se ejecuta automáticamente al iniciar
- Crea 3 roles (ADMINISTRADOR, TECNICO, EMPLEADO)
- Crea 5 usuarios de prueba
- Verifica que no existan antes de crear
- Muestra mensajes informativos en la consola

---

## 💡 CÓMO FUNCIONA INTERNAMENTE

```
1. Spring Boot inicia
                ↓
2. JPA/Hibernate crea las tablas (ddl-auto=update)
                ↓
3. DataInitializer.run() se ejecuta automáticamente
                ↓
4. Crea roles en la tabla `rol`
                ↓
5. Crea usuarios en la tabla `usuario`
                ↓
6. Asigna roles a usuarios en la tabla `usuario_rol`
                ↓
7. Mensaje de éxito en consola
                ↓
8. Aplicación lista para usar
```

---

## ⚠️ NOTAS IMPORTANTES

### 1. Los datos se crean CADA VEZ
```
✅ Si los datos ya existen, NO se duplican (usa findByCorreo)
✅ Si la BD está vacía, se crean automáticamente
```

### 2. Las contraseñas están en TEXTO PLANO
```
⚠️ SOLO PARA DESARROLLO
⚠️ En producción usar BCryptPasswordEncoder
```

### 3. Los roles están HARDCODEADOS
```
ADMINISTRADOR
TECNICO
EMPLEADO
```

### 4. Los usuarios están HARDCODEADOS
```
5 usuarios con correos y contraseñas predeterminadas
```

---

## 🆘 ¿ALGO NO FUNCIONA?

### Si no ves los mensajes de inicialización

Verifica la consola en Spring Boot. Si ves errores, probablemente:

```
❌ PostgreSQL no está corriendo
   → Solución: net start postgresql-x64-15

❌ Puerto 5432 está ocupado
   → Solución: Cambiar puerto en application.properties

❌ Contraseña de PostgreSQL es diferente
   → Solución: Cambiar en application.properties
```

### Si login sigue sin funcionar

```
1. Verifica que veas ✅ en la consola
2. Copia exactamente el correo (con minúsculas)
3. Copia exactamente la contraseña (case-sensitive)
4. Limpia cache del navegador (Ctrl+Shift+Delete)
```

---

## 📚 DOCUMENTACIÓN ANTERIOR

- `INICIA_AQUI_AHORA.md` - Ya no necesitas cargar SQL
- `CARGAR_DATOS_BD.md` - Ya no necesitas esto
- `datos_prueba.sql` - YA NO ES NECESARIO
- `datos_prueba_simple.sql` - YA NO ES NECESARIO

---

## ✨ RESUMEN

```
ANTES (❌ Complicado):
1. Crear BD
2. Cargar SQL manualmente
3. Esperar errores ON CONFLICT
4. Arreglar tablas
5. Ejecutar aplicación

AHORA (✅ Automático):
1. Ejecutar: mvn spring-boot:run
2. ¡Listo! Los datos ya están cargados
3. Login con: juan.garcia@example.com / password123
```

---

## 🎉 ¡DISFRUTA!

Tu aplicación ahora está **100% operativa** desde el primer ejecutable.

No hay SQL que cargar, no hay datos que migrar.

**Todo funciona automáticamente.** 🚀
