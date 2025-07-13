# 🏥 Medical Appointment System (Java Console App)

Este es un sistema simple de gestión de citas médicas hecho en Java como aplicación de consola. Permite simular el inicio de sesión de doctores y pacientes para gestionar el sistema de forma básica.

---

## 📌 Características principales

- Menú interactivo con opciones para:
  - Iniciar sesión como **Doctor**
  - Iniciar sesión como **Paciente**
- Autenticación por correo electrónico para ambos tipos de usuarios.
- Datos simulados de doctores y pacientes predefinidos.
- Menú exclusivo para cada tipo de usuario después del login.

---

## 📁 Estructura del proyecto

├── model/
│ ├── User.java
│ ├── Doctor.java
│ └── Patient.java
│
├── ui/
│ ├── UiMenu.java
│ ├── UIDoctorMenu.java
│ └── UiPatientMenu.java


---

## 🚀 Cómo ejecutar el proyecto

1. Clona este repositorio:
   ```bash
   git clone https://github.com/usuario/nombre-del-repositorio.git
Abre el proyecto con IntelliJ IDEA o cualquier IDE Java.

Ejecuta la clase UiMenu.java desde el paquete ui.

🧪 Datos de prueba (usuarios predefinidos)
Doctores
Nombre	Email
Jose	jose@gmail.com
Lucas	lucas@gmail.com
Marcos	marcos@gmail.com

Pacientes
Nombre	Email
Kevin	kevin@gmail.com
Eduard	eduard@gmail.com
Daniel	daniel@gmail.com

Puedes iniciar sesión usando cualquiera de estos correos para probar el sistema.

📦 Tecnologías utilizadas
Java 17+ (puede funcionar con versiones anteriores)

IntelliJ IDEA (opcional)

Programación orientada a objetos (POO)

📚 Aprendizajes aplicados
Clases y herencia en Java

Encapsulamiento de datos

Menús de consola interactivos

Uso de ArrayList, Scanner y estructuras de control

Separación por capas (UI y lógica de modelo)

📌 Estado del proyecto
🚧 En desarrollo
Se planean mejoras como:

Persistencia con archivos o base de datos

Registro de usuarios

Gestión de citas médicas reales

🤝 Contribuciones
¿Quieres aportar al proyecto?
¡Las contribuciones son bienvenidas! Puedes abrir issues o pull requests.

📄 Licencia
Este proyecto está bajo la licencia MIT.
