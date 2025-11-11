-- ============================================
-- SCRIPT DE DATOS DE PRUEBA
-- Sistema de Gestión de Mantenimiento
-- ============================================

-- Limpiar datos anteriores (opcional)
-- DELETE FROM usuario_rol;
-- DELETE FROM usuario;
-- DELETE FROM nombre_rol;

-- ============================================
-- 1. CREAR ROLES (Si no existen)
-- ============================================

INSERT INTO nombre_rol (nombre_rol) VALUES ('SOLICITANTE')
ON CONFLICT DO NOTHING;

INSERT INTO nombre_rol (nombre_rol) VALUES ('OPERARIO')
ON CONFLICT DO NOTHING;

INSERT INTO nombre_rol (nombre_rol) VALUES ('JEFE_MANTENIMIENTO')
ON CONFLICT DO NOTHING;

INSERT INTO nombre_rol (nombre_rol) VALUES ('OFICINA_MANTENIMIENTO')
ON CONFLICT DO NOTHING;

INSERT INTO nombre_rol (nombre_rol) VALUES ('ADMINISTRADOR')
ON CONFLICT DO NOTHING;

-- ============================================
-- 2. CREAR USUARIOS DE PRUEBA
-- ============================================

-- Usuario 1: Solicitante
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Juan', 'García', 'juan.garcia@example.com', 'password123', '3001234567', true, 'Solicitante')
ON CONFLICT DO NOTHING;

-- Usuario 2: Operario
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Carlos', 'Martínez', 'carlos.martinez@example.com', 'password123', '3009876543', true, 'Operario')
ON CONFLICT DO NOTHING;

-- Usuario 3: Jefe de Mantenimiento
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('María', 'López', 'maria.lopez@example.com', 'password123', '3005555555', true, 'Jefe de Mantenimiento')
ON CONFLICT DO NOTHING;

-- Usuario 4: Oficina de Mantenimiento
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Pedro', 'Rodríguez', 'pedro.rodriguez@example.com', 'password123', '3004444444', true, 'Personal de Oficina')
ON CONFLICT DO NOTHING;

-- Usuario 5: Administrador
INSERT INTO usuario (nombre, apellido, correo, contrasena, celular, activo, descripcion_cargo)
VALUES ('Admin', 'Sistema', 'admin@example.com', 'admin123', '3003333333', true, 'Administrador del Sistema')
ON CONFLICT DO NOTHING;

-- ============================================
-- 3. ASIGNAR ROLES A USUARIOS
-- ============================================

-- Juan García es Solicitante
INSERT INTO usuario_rol (id_usuario, id_rol)
SELECT u.id_usuario, nr.id_rol 
FROM usuario u, rol nr
WHERE u.correo = 'juan.garcia@example.com' 
  AND nr.nombre_rol = 'SOLICITANTE'
ON CONFLICT DO NOTHING;

-- Carlos Martínez es Operario
INSERT INTO usuario_rol (id_usuario, id_rol)
SELECT u.id_usuario, nr.id_rol 
FROM usuario u, rol nr
WHERE u.correo = 'carlos.martinez@example.com' 
  AND nr.nombre_rol = 'OPERARIO'
ON CONFLICT DO NOTHING;

-- María López es Jefe de Mantenimiento
INSERT INTO usuario_rol (id_usuario, id_rol)
SELECT u.id_usuario, nr.id_rol 
FROM usuario u, rol nr
WHERE u.correo = 'maria.lopez@example.com' 
  AND nr.nombre_rol = 'JEFE_MANTENIMIENTO'
ON CONFLICT DO NOTHING;

-- Pedro Rodríguez es de Oficina de Mantenimiento
INSERT INTO usuario_rol (id_usuario, id_rol)
SELECT u.id_usuario, nr.id_rol 
FROM usuario u, rol nr
WHERE u.correo = 'pedro.rodriguez@example.com' 
  AND nr.nombre_rol = 'OFICINA_MANTENIMIENTO'
ON CONFLICT DO NOTHING;

-- Admin tiene todos los roles
INSERT INTO usuario_rol (id_usuario, id_rol)
SELECT u.id_usuario, nr.id_rol 
FROM usuario u, rol nr
WHERE u.correo = 'admin@example.com'
ON CONFLICT DO NOTHING;

-- ============================================
-- 4. CREAR CATEGORÍAS DE EQUIPOS
-- ============================================

INSERT INTO categoria (nombre, descripcion)
VALUES ('Maquinaria Pesada', 'Equipos de gran tamaño para producción')
ON CONFLICT DO NOTHING;

INSERT INTO categoria (nombre, descripcion)
VALUES ('Equipos Eléctricos', 'Motores, transformadores y equipos de distribución')
ON CONFLICT DO NOTHING;

INSERT INTO categoria (nombre, descripcion)
VALUES ('HVAC', 'Sistemas de aire acondicionado y ventilación')
ON CONFLICT DO NOTHING;

INSERT INTO categoria (nombre, descripcion)
VALUES ('Equipos de Oficina', 'Computadoras, impresoras y periféricos')
ON CONFLICT DO NOTHING;

-- ============================================
-- 5. CREAR UBICACIONES
-- ============================================

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Planta Principal', 'Edificio principal de producción')
ON CONFLICT DO NOTHING;

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Almacén', 'Área de almacenamiento y logística')
ON CONFLICT DO NOTHING;

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Oficinas Administrativas', 'Área de administración y directiva')
ON CONFLICT DO NOTHING;

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Taller de Mantenimiento', 'Taller donde se realizan reparaciones')
ON CONFLICT DO NOTHING;

-- ============================================
-- VERIFICAR DATOS INSERTADOS
-- ============================================

SELECT '=== USUARIOS ===' as Información;
SELECT id_usuario, nombre, apellido, correo FROM usuario;

SELECT '=== ROLES ===' as Información;
SELECT id_rol, nombre_rol FROM rol;

SELECT '=== ASIGNACIONES DE ROLES ===' as Información;
SELECT u.nombre, u.apellido, nr.nombre_rol
FROM usuario u
JOIN usuario_rol ur ON u.id_usuario = ur.id_usuario
JOIN rol nr ON ur.id_rol = nr.id_rol
ORDER BY u.nombre;

-- ============================================
-- NOTES
-- ============================================
-- Las credenciales de prueba son:
-- - juan.garcia@example.com / password123 (Solicitante)
-- - carlos.martinez@example.com / password123 (Operario)
-- - maria.lopez@example.com / password123 (Jefe)
-- - pedro.rodriguez@example.com / password123 (Oficina)
-- - admin@example.com / admin123 (Administrador)
