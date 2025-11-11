-- ============================================
-- SCRIPT DE DATOS DE PRUEBA - VERSION SIMPLE
-- Sistema de Gestión de Mantenimiento
-- (Sin ON CONFLICT - Más compatible)
-- ============================================

-- ============================================
-- 1. CREAR ROLES
-- ============================================

INSERT INTO rol (nombre) VALUES ('SOLICITANTE');
INSERT INTO rol (nombre) VALUES ('OPERARIO');
INSERT INTO rol (nombre) VALUES ('JEFE_MANTENIMIENTO');
INSERT INTO rol (nombre) VALUES ('OFICINA_MANTENIMIENTO');
INSERT INTO rol (nombre) VALUES ('ADMINISTRADOR');

-- ============================================
-- 2. CREAR USUARIOS DE PRUEBA
-- ============================================

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

-- ============================================
-- 3. ASIGNAR ROLES A USUARIOS
-- ============================================

-- Juan García es Solicitante (ID 1, Rol 1)
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);

-- Carlos Martínez es Operario (ID 2, Rol 2)
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);

-- María López es Jefe de Mantenimiento (ID 3, Rol 3)
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 3);

-- Pedro Rodríguez es de Oficina de Mantenimiento (ID 4, Rol 4)
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (4, 4);

-- Admin tiene todos los roles (ID 5)
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 1);  -- Solicitante
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 2);  -- Operario
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 3);  -- Jefe
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 4);  -- Oficina
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 5);  -- Administrador

-- ============================================
-- 4. CREAR CATEGORÍAS DE EQUIPOS
-- ============================================

INSERT INTO categoria (nombre, descripcion)
VALUES ('Maquinaria Pesada', 'Equipos de gran tamaño para producción');

INSERT INTO categoria (nombre, descripcion)
VALUES ('Equipos Eléctricos', 'Motores, transformadores y equipos de distribución');

INSERT INTO categoria (nombre, descripcion)
VALUES ('HVAC', 'Sistemas de aire acondicionado y ventilación');

INSERT INTO categoria (nombre, descripcion)
VALUES ('Equipos de Oficina', 'Computadoras, impresoras y periféricos');

-- ============================================
-- 5. CREAR UBICACIONES
-- ============================================

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Planta Principal', 'Edificio principal de producción');

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Almacén', 'Área de almacenamiento y logística');

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Oficinas Administrativas', 'Área de administración y directiva');

INSERT INTO ubicacion (nombre, descripcion)
VALUES ('Taller de Mantenimiento', 'Taller donde se realizan reparaciones');

-- ============================================
-- VERIFICAR DATOS INSERTADOS
-- ============================================

SELECT '=== USUARIOS CREADOS ===' as Información;
SELECT id_usuario, nombre, apellido, correo, activo FROM usuario;

SELECT '' as '';

SELECT '=== ROLES DISPONIBLES ===' as Información;
SELECT id_rol, nombre FROM rol;

SELECT '' as '';

SELECT '=== ASIGNACIONES DE ROLES ===' as Información;
SELECT 
    u.id_usuario,
    u.nombre || ' ' || u.apellido as "Usuario",
    r.nombre as "Rol"
FROM usuario u
JOIN usuario_rol ur ON u.id_usuario = ur.id_usuario
JOIN rol r ON ur.id_rol = r.id_rol
ORDER BY u.nombre, r.nombre;

SELECT '' as '';

SELECT '=== CATEGORÍAS ===' as Información;
SELECT id_categoria, nombre FROM categoria;

SELECT '' as '';

SELECT '=== UBICACIONES ===' as Información;
SELECT id_ubicacion, nombre FROM ubicacion;

-- ============================================
-- CREDENCIALES DE PRUEBA
-- ============================================
-- juan.garcia@example.com / password123 (Solicitante)
-- carlos.martinez@example.com / password123 (Operario)
-- maria.lopez@example.com / password123 (Jefe Mantenimiento)
-- pedro.rodriguez@example.com / password123 (Oficina Mantenimiento)
-- admin@example.com / admin123 (Administrador)
