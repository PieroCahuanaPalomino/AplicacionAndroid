# Usa una imagen base de Python
FROM python:3.9

# Establece el directorio de trabajo en /src
WORKDIR /src

# Copia todos los archivos, excepto el .env, al directorio de trabajo en el contenedor
#COPY [^.,]* /src/

# Copia los archivos locales al contenedor
COPY . .

# Instala las dependencias de la aplicación
RUN pip install --no-cache-dir -r requirements.txt

# Expone el puerto en el que la aplicación se ejecutará (ajústalo según las necesidades de tu aplicación)
EXPOSE 5000

# Define el comando por defecto para ejecutar tu aplicación
CMD ["python", "index.py"]
