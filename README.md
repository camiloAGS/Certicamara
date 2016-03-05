# Vehículo a Control Remoto
### Desarrollado por
- Camilo Andrés Guchubo Sierra 
- C.C. 1.019.013.479 de Bogotá

### Versión
1.0
## Requisitos
[java version "1.8.0_60"]

Proyecto hecho en Eclipse Mars 1

## Instrucciones
El programa funciona por medio de las instrucciones dadas en la consola:

Para crear la superficie por donde se desplazará el auto:

**S** *n m*

*n* = número de filas

*m* = número de columnas

```sh
S 10 5
```

Para desplazar el vehículo:

**D** *p,c*

*p* = número de pasos en la dirección *c*

Donde *c* puede valer:
 * N (norte)
 * S (sur)
 * E (este)
 * O (oeste)
```sh
D 3,N
```
Mueve el auto tres pasos hacia el Norte.

Se pueden encadenar movimientos con el caracter **';'** y el auto se moverá ejecutándolos secuencialmente:

```sh
D 3,N;4,e;5,S;2,o
```

Es indiferente la capitalización de las letras.
## Diagrama de clases:

Imagen disponible en la raíz de este proyecto. Archivo .vpp en la carpeta /resources

   [java version "1.8.0_60"]: <http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>
