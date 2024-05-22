# Taller Java 

## Iteración I

Decisiones principales respecto al diseño del sistema:

- **Modularización**: Conceptualmente los requerimientos del sistema se dividen en seis categorías. Cada categoría representa un módulo del Sistema. 
Un módulo es una separación lógica dentro de la aplicación

- **Bajo acoplamiento entre módulos**: Se intenta que los módulos solo se comuniquen entre si, mediate el intercambio de eventos o uso de interfaces.
Además cada módulo cuenta con sus propias clases de Dominio y sus repositorio propio de datos.

- **Separación en capas**: podemos ver a cada módulo del sistema como un corte "vertical" del sistema. Sin embargo dentro de cáda módulos existe separación de conceptos utilizando capas lógicas (corte horizotal)

- **Priorización de lógica de negocio**: las dependencias entre capas lógicas determina que la capa principal es la capa de Domonio. El resto de las caps depende de su capas inferior. El esquema de capas sigue los lineamientos de una "arquitectura limpia".

- **Facilidad de testeo**: el diseño en capas permite realizar test unitarios de la capa de Dominio y de Aplicación. El bajo acoplamiento entre módulos permite probar los mismos de forma independiente.

![image](https://github.com/gabrielaramburu/TallerJakartaEE/assets/63823685/45eeedb5-355a-4513-9eca-b28cef2f4a8f)

### Dependencias entre módulos

Nota: posible idea para documentar las dependencias entre módulos. Los diagramas, son representativos, no están completos.

--- 
**Módulo Peaje**

![image](https://github.com/gabrielaramburu/TallerJakartaEE/assets/63823685/48db9731-0d83-4e2a-9647-8e64140ab389)

---

**Módulo Gestión**
![image](https://github.com/gabrielaramburu/TallerJakartaEE/assets/63823685/63854c26-dd06-4e4e-bcf0-7544fe041fb6)


---
Otra idea interesante es documentar los eventos que dispara cada módulo y quien los escucha
