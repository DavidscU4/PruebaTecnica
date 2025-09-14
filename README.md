# PruebaTecnica
Prueba Técnica perfil junior
## 🚀 Despliegue rápido con Docker

### Requisitos
- Docker (Desktop o Engine) con Docker Compose v2.

### Opción A — App en Docker usando tu Postgres local
> En Windows/Mac usa `host.docker.internal` como host; en Linux puede requerir `--add-host=host.docker.internal:host-gateway`.

**Build & Run**
```bash
# 1) Construir la imagen
docker build -t prueba-tecnica:latest .

# 2) Ejecutar la app
# (ajusta usuario/clave/DB si usas otros)
docker run --name prueba_tecnica_app --rm -p 8080:8080 \
  -e TZ=America/Guayaquil \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/banco \
  -e SPRING_DATASOURCE_USERNAME=banco_user \
  -e SPRING_DATASOURCE_PASSWORD=root \
  prueba-tecnica:latest
