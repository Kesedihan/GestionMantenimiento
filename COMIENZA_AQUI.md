# 🚀 COMIENZA AQUÍ - COMANDO RÁPIDO

## ⚡ Si tienes prisa (2 MINUTOS)

### 1️⃣ Abre PowerShell en la carpeta del proyecto:
```powershell
cd c:\Users\Kese\Documents\GitHub\GestionMantenimiento
```

### 2️⃣ Ejecuta:
```powershell
mvn spring-boot:run
```

### 3️⃣ Abre navegador:
```
http://localhost:8080
```

---

## ✨ ¿QUE VAS A VER?

✅ Página de inicio con 4 opciones (linda, con CSS)
✅ Formulario de login elegante
✅ Dashboard personalizado después de iniciar sesión

---

## 📝 CREDENCIALES (COPIA-PEGA)

```
juan.garcia@example.com
password123
```

---

## ⚠️ REQUISITO PREVIO

PostgreSQL debe estar corriendo. Si no:
```powershell
net start postgresql-x64-15
```

---

## 🆘 ¿No funciona?

### Si dice "Connection refused"
```powershell
# Inicia PostgreSQL
net start postgresql-x64-15
```

### Si dice "puerto ocupado"
```powershell
# Mata el proceso en 8080
netstat -ano | findstr :8080
taskkill /PID [NUMBER] /F
```

### Si el CSS no se ve
```powershell
# Limpia el cache: F12 en el navegador → Ctrl+Shift+Delete
# Luego recarga la página (Ctrl+F5)
```

---

## 📚 DOCUMENTACIÓN DISPONIBLE

| Necesito | Leo |
|----------|-----|
| Entender antes de ejecutar | **INICIO_RAPIDO.md** |
| Instrucciones paso a paso | **EJECUTAR_AHORA.md** |
| Ver qué se cambió | **CAMBIOS_REALIZADOS.md** |
| Entender arquitectura | **ARQUITECTURA.md** |
| Saber sobre el CSS | **CSS_ACTUALIZADO.md** |
| Verificar todo funciona | **VERIFICACION_CHECKLIST.md** |
| Ver antes/después | **COMPARACION_ANTES_DESPUES.md** |
| Mapa de documentación | **INDICE_DOCUMENTACION.md** |
| Bienvenida completa | **BIENVENIDA.md** |

---

## ✅ CHECKLIST DE 30 SEGUNDOS

- [ ] PowerShell está abierto en la carpeta
- [ ] PostgreSQL está corriendo
- [ ] Ejecuté `mvn spring-boot:run`
- [ ] Abro http://localhost:8080 en Chrome/Firefox
- [ ] Veo página linda con 4 opciones
- [ ] Hago clic en "Solicitante"
- [ ] Me lleva a login (veo formulario bonito)
- [ ] Ingreso: juan.garcia@example.com / password123
- [ ] Veo dashboard con mi nombre y módulos

**Si todo funciona = ¡Proyecto OK! 🎉**

---

## 🎯 PRÓXIMOS PASOS

1. ✅ Ejecutar (`mvn spring-boot:run`)
2. ✅ Probar login
3. 📖 Leer CAMBIOS_REALIZADOS.md
4. 🔧 Expandir con nuevas vistas
5. 🚀 Hacer deploy

---

## 💡 TIPS

- Usa `Ctrl+Shift+Delete` para limpiar cache si CSS no carga
- Usa `F12` para Developer Tools si hay errores
- Usa `Ctrl+C` en PowerShell para detener la app

---

**¡Listo? ¡Ejecuta `mvn spring-boot:run` ahora! 🚀**
