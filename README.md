# Examen2Parcial_TecnicasRuben

Mi repositorio es: https://github.com/rodriiMatamoros/Examen2Parcial_TecnicasRuben.git

## Ejercicio 1
1) Los elementos que definen a un objeto son:

      a) El tipo de visibilidad que tiene asignado: privado o público.
    
    - [x] b) La identidad, Los atributos que representan su estado y los métodos que representan su comportamiento.

2) El hecho de que un método pueda recibir un número variable de atributos se denomina: 

      a) Herencia

    - [x] b) Polimorfismo

3) Imagine que la clase C hereda de la clase B. Y la clase B hereda de la clase A. Cuando se cree un objeto de la clase C, ¿cuál será la secuencia en que se ejecutarán los constructores?

    a) Primero el constructor de C, luego constructor de B y, finalmente, el constructor de A

    - [x] b) Primero el constructor de A, luego constructor de B y, finalmente, el constructor de C

4) Para referenciar los atributos de un objeto en un método de la misma clase

    - [x] a) Debo utilizar la palabra reservada self como prefijo

    b) Los atributos deben ser públicos, en caso contrario no se pueden referenciar desde métodos que no sean el constructor.étodos que no sean el constructor.étodos que no sean el constructor.

5) En el paradigma de la programación orientado a objetos:

    a) Se recomienda que las acciones estén lo más acopladas posibles al código para obtener el mayor rendimiento posible.

    - [x] b) Se favorece la semántica y la reutilización de código en detrimento del rendimiento.
    
    
## Ejercicio 2
**¿Cuáles son las características de la programación orientada a objetos?**

La programación orientada a objetos (POO) en Java se basa en el concepto de clases y objetos. Las características principales de la POO en Java incluyen:

Abstracción: permite la definición de objetos y clases que representan conceptos del mundo real.

Encapsulamiento: protege los datos y el comportamiento de una clase de acceso no autorizado externo.

Herencia: permite la creación de nuevas clases que heredan atributos y métodos de una clase existente.

Polimorfismo: permite que objetos de diferentes clases respondan al mismo mensaje de diferentes maneras.

Clases: una plantilla o modelo que define un conjunto de atributos y métodos para crear objetos.

Objetos: una instancia de una clase con valores específicos de atributos.

Métodos: funciones dentro de una clase que definen su comportamiento y operaciones.

Atributos: variables dentro de una clase que almacenan datos específicos.

Constructores: un tipo especial de método que se utiliza para inicializar objetos.

Interfaces: una colección de métodos abstractos que una clase puede implementar para definir su comportamiento.

En resumen, la programación orientada a objetos en Java permite la creación de objetos que encapsulan datos y comportamiento, y se comunican entre sí mediante mensajes y métodos, lo que permite una mayor modularidad, flexibilidad y reutilización de código.


## Ejercicio 3
**¿Qué es la visibilidad de una variable o un método? ¿Qué tipos hay? ¿Cuándo debe utilizarse cada tipo?**

La visibilidad en Java se refiere al alcance o accesibilidad de una variable o método dentro de una clase. Hay cuatro tipos de visibilidad en Java: public, private, protected y default (o package-private).

Public: los miembros (variables o métodos) declarados como públicos son accesibles desde cualquier lugar en el código, tanto dentro como fuera de la clase.

Private: los miembros declarados como privados solo son accesibles desde dentro de la clase que los define. No pueden ser accedidos desde ninguna otra clase, incluso si se encuentra en el mismo paquete.

Protected: los miembros declarados como protegidos son accesibles desde dentro de la clase que los define y desde cualquier subclase de esa clase, incluso si se encuentra en un paquete diferente.

Default o package-private: los miembros declarados sin ninguna modificador de acceso (es decir, sin public, private o protected) solo son accesibles desde dentro del mismo paquete en el que se encuentra la clase.

La elección de la visibilidad adecuada para una variable o método depende de la funcionalidad que se quiera lograr en la clase. Algunas consideraciones comunes incluyen:

Public: se utiliza cuando se quiere que una variable o método sea accesible desde cualquier parte del código, ya que la clase debe ser utilizada por otras partes del código.

Private: se utiliza para proteger la implementación interna de una clase. Los miembros privados solo son accesibles dentro de la clase, lo que ayuda a evitar cambios no intencionales en su valor desde otros lugares del código.

Protected: se utiliza cuando se desea que los miembros de una clase sean accesibles para las subclases, pero no para otros códigos que no sean subclases.

Default o package-private: se utiliza cuando se desea que los miembros de una clase sean accesibles solo dentro del mismo paquete, lo que ayuda a mantener la encapsulación y la modularidad del código.
