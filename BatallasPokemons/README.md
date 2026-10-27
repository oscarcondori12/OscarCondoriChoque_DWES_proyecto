# Batallas Pokémon

Autor: Óscar Condori Choque

## Descripción del proyecto

Aplicación web desarrollada con Spring Boot,Thymeleaf y Maven que permite consultar un catálogo de Pokémon cargado desde un JSON

La aplicación incluye:
- Página de inicio con formulario para introducir el nombre del entrenador (
- Listado de Pokémon con imagen, nombre  y tipos con colores diferenciados
- Página de detalle de cada Pokémon 
- Página de error cuando se solicita un Pokémon inexistente
- Menú de navegación y pie de página comunes en todas las vistas

## Tecnologías utilizadas

- Java 25
- Spring Boot
- Spring Web
- Thymeleaf
- Maven
- Puerto: 8082

## Tabla de peticiones

 Método HTTP  Ruta               Qué hace                                                                  Respuesta del navegador                          |
 GET          `/`                Muestra la página de inicio con el formulario del nombre de entrenador   Página HTML (`index.html`)                       |
 POST         `/`                Valida el nombre del entrenador                        Si es válido → redirección a `/pokemons`<br>Si no es válido → Página HTML (`index.html`) con mensaje de error |
 GET          `/pokemons`        Muestra el listado completo de Pokémon                                   Página HTML (`pokemons.html`)                    |
 GET          `/pokemons/{id}`   Muestra la ficha detallada del Pokémon con el identificador indicado     Si existe → Página HTML (`detalle.html`)<br>Si no existe → **redirección** a `/notfound` |
 GET          `/notfound`        Muestra la página de “Pokémon no encontrado”                             Página HTML (`notfound.html`)                    |

## Como ejecutar 

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA 
3. Ejecutar la clase principal `BatallasPokemonsApplication`
4. Abrir el navegador en: [http://localhost:8082](http://localhost:8082)

## Estructura principal

- `src/main/resources/data/pokemon.json` → Datos del catálogo
- `src/main/resources/templates/` → Vistas Thymeleaf
- `src/main/resources/static/` → Recursos estáticos 