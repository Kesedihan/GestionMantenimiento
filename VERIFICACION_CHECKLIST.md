# ✅ CHECKLIST DE VERIFICACIÓN

## 🔍 Antes de Ejecutar el Proyecto

### Verificar Archivos

- [ ] Archivo `src/main/resources/static/index.css` existe
- [ ] Archivo `src/main/resources/static/login.css` existe
- [ ] Archivo `src/main/resources/static/dashboard.css` existe
- [ ] Archivo `src/main/resources/templates/index.html` existe
- [ ] Archivo `src/main/resources/templates/login.html` existe
- [ ] Archivo `src/main/resources/templates/dashboard.html` existe

### Verificar Contenido HTML

En `index.html`:
- [ ] Contiene `<link rel="stylesheet" th:href="@{/index.css}" />`
- [ ] NO contiene `<link rel="stylesheet" th:href="@{/css/index.css}" />`

En `login.html`:
- [ ] Contiene `<link rel="stylesheet" th:href="@{/login.css}">`
- [ ] NO contiene `<link rel="stylesheet" th:href="@{/css/login.css}">`

En `dashboard.html`:
- [ ] Contiene `<link rel="stylesheet" th:href="@{/dashboard.css}">`
- [ ] NO contiene `<link rel="stylesheet" th:href="@{/css/index.css}">`

---

## 🚀 Proceso de Ejecución

### Paso 1: Base de Datos
```bash
[ ] PostgreSQL está corriendo
[ ] Base de datos "GestionMantenimiento" existe
[ ] Ejecutar: psql -U postgres -d GestionMantenimiento -f datos_prueba.sql
```

### Paso 2: Compilar
```bash
[ ] Ejecutar: mvn clean install
[ ] Compilación exitosa (sin errores)
[ ] Compilación exitosa (sin warnings importantes)
```

### Paso 3: Ejecutar
```bash
[ ] Ejecutar: mvn spring-boot:run
[ ] Ver mensaje: "Started ProyectoHackatonApplication"
[ ] Ver: "Tomcat started on port(s): 8080"
```

---

## 🌐 Pruebas en Navegador

### Página de Inicio (/)

**URL**: http://localhost:8080

Verificar:
- [ ] Se carga correctamente
- [ ] Se ve el navbar con "INICIO" en azul
- [ ] Se ve "BIENVENIDO" en grande
- [ ] Se ven 4 tarjetas con:
  - [ ] Icono de persona
  - [ ] Icono de engranaje
  - [ ] Icono de persona con tarjeta
  - [ ] Icono de persona con insignia
- [ ] Tarjetas tienen borde azul
- [ ] Al pasar mouse sobre tarjeta:
  - [ ] Tarjeta se eleva
  - [ ] Icono se agranda y cambia de color
  - [ ] Botón cambia de color
- [ ] Los botones dicen "Solicitante", "Oficina Mantenimiento", "Jefe Mantenimiento", "Operario"

**CSS Cargado**:
- [ ] Colores: fondo oscuro, azul en bordes
- [ ] Fuentes claras y legibles
- [ ] Animaciones suaves
- [ ] Responsive en móvil

---

### Página de Login (/login)

**URL**: http://localhost:8080/login

Verificar:
- [ ] Formulario centrado en pantalla
- [ ] Título "INICIAR SESIÓN" en gradiente azul
- [ ] 2 campos de entrada:
  - [ ] "Correo Electrónico"
  - [ ] "Contraseña"
- [ ] 2 botones:
  - [ ] "Iniciar Sesión" (con gradiente azul)
  - [ ] "Volver al Inicio" (transparente)
- [ ] Campo de correo es de tipo email
- [ ] Campo de contraseña es tipo password (puntos)

**Interacciones**:
- [ ] Al pasar mouse sobre botón "Iniciar Sesión":
  - [ ] Botón cambia de color
  - [ ] Sombra aumenta
  - [ ] Se eleva ligeramente
- [ ] Al hacer click en "Volver al Inicio":
  - [ ] Redirige a http://localhost:8080 ✅

**Ingreso de Credenciales**:
```
Correo: juan.garcia@example.com
Contraseña: password123
```
- [ ] Hace click en "Iniciar Sesión"
- [ ] Redirige a /dashboard
- [ ] Ve el nombre del usuario
- [ ] No muestra error

**Error en Credenciales**:
```
Correo: usuario@invalido.com
Contraseña: incorrecta
```
- [ ] Hace click en "Iniciar Sesión"
- [ ] Permanece en /login
- [ ] Muestra alerta roja con "Credenciales inválidas"

---

### Página de Dashboard (/dashboard)

**URL**: http://localhost:8080/dashboard

Verificar Sesión Activa:
- [ ] Se ve el navbar con:
  - [ ] Icono de herramientas + texto "SGM - Mantenimiento"
  - [ ] A la derecha: "Bienvenido: Juan García"
  - [ ] Botón rojo "Cerrar Sesión"

- [ ] Lado izquierdo:
  - [ ] Card "PERFIL" con:
    - [ ] Correo del usuario
    - [ ] Teléfono del usuario
    - [ ] Cargo del usuario
  - [ ] Card "ROLES" con:
    - [ ] Rol asignado en badge azul
    
- [ ] Centro/Derecha:
  - [ ] Título "Panel de Control"
  - [ ] 4 módulos en grid:
    - [ ] "Solicitudes de Mantenimiento" (icono documento)
    - [ ] "Órdenes de Trabajo" (icono herramientas)
    - [ ] "Reportes y Análisis" (icono gráfico)
    - [ ] "Equipos" (icono archivo)

**Interacciones**:
- [ ] Al pasar mouse sobre un módulo:
  - [ ] Tarjeta se eleva
  - [ ] Icono se agranda
  - [ ] Sombra aumenta

**Cerrar Sesión**:
- [ ] Click en botón "Cerrar Sesión"
- [ ] Redirige a http://localhost:8080
- [ ] Puede acceder a /login normalmente

**Sin Sesión Activa**:
- [ ] Accede directamente a http://localhost:8080/dashboard
- [ ] Redirige automáticamente a /login

---

## 🎨 CSS Verificación Detallada

### En Cada Página

Abre Developer Tools (F12) → Tab "Network":

```
✅ Verificar que cargan:
  - bootstrap@5.3.8/dist/css/bootstrap.min.css (Status: 200)
  - bootstrap-icons@1.13.1/font/bootstrap-icons.min.css (Status: 200)
  - /index.css (Status: 200)  O  /login.css (Status: 200)  O  /dashboard.css (Status: 200)
  - bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js (Status: 200)
```

**Tab "Console"**:
- [ ] No hay errores rojos (❌)
- [ ] No hay advertencias de CSS no cargado

**Tab "Elements"**:
- [ ] En `<head>` se ven los `<link>` de CSS
- [ ] En los elementos se aplican estilos CSS

---

## 🔧 Solución de Problemas

### CSS No Aparece

**Síntoma**: Página se ve blanca o gris, sin estilos

**Soluciones**:
1. [ ] En Developer Tools → Network, ¿cargan los CSS?
   - Si NO: Verificar rutas en HTML
   - Si SÍ: Verificar que los archivos tengan contenido

2. [ ] Verificar archivos existen:
   ```bash
   dir src\main\resources\static\
   ```

3. [ ] Limpiar y recompilar:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. [ ] Limpiar cache navegador:
   - [ ] F12 → Ctrl+Shift+Delete → Borrar cookies y datos
   - [ ] Recargar página

---

### No Aparece Dashboard

**Síntoma**: Al hacer login, no muestra dashboard

**Soluciones**:
1. [ ] Verificar datos en BD:
   ```sql
   SELECT * FROM usuario WHERE correo = 'juan.garcia@example.com';
   ```

2. [ ] Ver logs en consola de Maven para errores

3. [ ] Verificar que AuthController tenga método dashboard

---

### Bootstrap No Funciona

**Síntoma**: Botones/Cards se ven feos, sin estilos Bootstrap

**Soluciones**:
1. [ ] CDN de Bootstrap accesible (necesita internet)
2. [ ] En Developer Tools → Network, ¿carga bootstrap?
3. [ ] Si es offline, descargar Bootstrap localmente

---

## 📊 Resumen de Pruebas

```
PÁGINA          | CSS      | RESPONSIVO | FUNCIONAL
─────────────────────────────────────────────────
index.html      | ✅/❌   | ✅/❌     | ✅/❌
login.html      | ✅/❌   | ✅/❌     | ✅/❌
dashboard.html  | ✅/❌   | ✅/❌     | ✅/❌
```

---

## ✨ Características a Verificar

- [ ] Animaciones suaves (no abruptas)
- [ ] Colores consistentes (azul principalmente)
- [ ] Responsive en móvil (girar pantalla)
- [ ] Botones interactivos (hover, click)
- [ ] Mensajes de error claros
- [ ] Sin errores en consola
- [ ] Sin advertencias de CSS
- [ ] Carga rápida
- [ ] Iconos se ven correctamente
- [ ] Fuentes claras y legibles

---

## 🎯 Conclusión

Cuando todas las casillas ✅ estén marcadas:

```
✅ Proyecto configurado correctamente
✅ CSS cargando sin problemas
✅ Vistas funcionando
✅ Autenticación activa
✅ Responsive
✅ Listo para usar
```

---

**Usa este checklist para asegurar que todo está funcionando correctamente** ✅
