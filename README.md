# control-inventario-backend
## Pasos para inciar

**1. Clonar la Aplicación**

```bash
git clone https://github.com/ErickBrayan/control-inventario-backend.git
```

**2. Crear Base de Datos MySQL**
```bash
create database db-inventario-minimarket
```

**3. Cambiar username y password para para la instalacion**

+ abrir `src/main/resources/application.yml`
+ cambiar `spring.datasource.username` y `spring.datasource.password` segun tu MySQL

**4. iniciar aplicacion usando maven**

```bash
mvn spring-boot:run
```
La aplicacion iniciara en el puerto <http://localhost:8080>
