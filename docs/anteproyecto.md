# Anteproyecto

> NOTA: Incluir diagramas donde proceda (diagramas de clases, casos de uso, entidad relación, ...).

## OBJETIVOS

Programa de escritorio capaz de generar correos masivos con el potencial de declarar variables para modificar el grado de aguante varias modificaciones con el fin de flexibilizar la aplicación y darle más polivalencia.


## PREANALISIS DE LO EXISTENTE (Opcional)

*[TODO] Si procede, se informará brevemente sobre el funcionamiento del sistema actual. El que vamos a reemplazar o a mejorar. Este sistema no tiene por qué estar necesariamente automatizado pudiendo realizarse actualmente de forma manual por personas.*

## ANÁLISIS DEL SOFTWARE

En esta sección se explican los requisitos fundamentales que requiere el sistema, es decir, lo que el programa hará desde el punto de vista del cliente.
Dichas pautas y requisitos a implementar en la aplicación son los siguientes:

Permitir al usuario importar un texto, de forma que esta pueda ser posteriormente usada y gestionada por el programa.
Permitir seleccionar los diferentes servicios de correos que se usaran mas adelante.
Automatización en la creación de correos con los parámetros establecidos por la fuente de texto y los archivos/documentos seleccionados por el usuario previamente en el manejo del programa.
Trabajar con variables personalizadas para la gestión de los parámetros que la aplicación utilizará a la hora de generar los correos.
Permitir al usuario manejar todas las diferentes acciones que la aplicación ofrece.

## Casos de uso
Se desarrollarán los casos de uso de la appliacion y sus requisitos funcionales para expresarlos desde el punto de vista del usuario, los cuales guiarán todo el proceso de desarrollo de la apliacion.

Estos casos de uso proporcionarán, por tanto, un modo claro y preciso de comunicación entre usuario y desarrollador.
El sistema que se describe en este caso de uso es el siguiente: Un usuario interactúa con el programa y selecciona una fuente de datos y un texto con parámetros introducidos manualmente. Una vez generados los correos, los parámetros serán reemplazados por las variables de la fuente de datos.

Entre las acciones que puede realizar están:

Importar texto: Importa un texto cuyos parámetros introducidos por el usuario serán sustituidos por los valores que tengan según la fuente de datos.
Importar fuente de datos: Selecciona un archivo que sirva como fuente de datos (p. ej. .txt) para que la aplicación gestione el valor de los parámetros que se encuentran en el documento actual.
Generar correos: Selecciona el destino en donde se crearán los correos acordes con al texto pasado y la fuente de datos proporcionados. Una vez seleccionado, se enviaran los correos.
Salir de la aplicación: El usuario sale de la aplicación.

![image](https://github.com/GabrielPerezMinik/integracion-dam/blob/main/docs/Caso%20de%20uso.png)


> *Incuir los diagramas necesarios*

## DISEÑO DEL SOFTWARE

Las librerías que utilizará el software serán las librerías de javafx y Spring, lo que me permitira tener más facilidad a la hora de programar el codigo.

La Api de Google Gmail y outlook en primera Instancia.

Ciclo de Vida
En este apartado se explicará el modelo de ciclo de vida elegido para esta aplicación y se explicará la justificación de los procedimientos elegidos para su progresiva implementación desde diferentes puntos de vista.

El modelo de ciclo de vida elegido para esta aplicación es el de Modelo de desarrollo incremental

Los motivos por los que he elegido este método de desarrollo para esta aplicación son los siguientes:

El modelo incremental se diferencia por dividir sus tareas en iteraciones, trabajando objetivos en pequeños tramos específicos. Estas iteraciones permiten una fácil administración y están sujetas a cambios y modificaciones según las necesidades que puedan ir surgiendo.

Desde el punto de vista del usuario final: El ciclo de vida elegido ofrece la posibilidad de gestionar la aplicación de una manera menos rigida y mas sujeta a las necesidades que vayan surgiendo para este.
Desde el punto de vista del Programador: Ofrece la posibilidad de irse centrando en aquellas tareas que se necesite y ajustarla a las necesidades y complicaciones que puedan ir surgiendo.

Por el tipo de aplicación: Permite descentralizar los diferentes tipos de api, interfaces y programas de una manera más eficiente.

Por la facilidad de uso: Gracias a que el desarrollo incremental es caracterizado por dividir tareas las etapas del ciclo de vida de software, permite adaptarse segun el programa avance a la hora de desarrollar el programa en todos sus aspectos.

Ventajas:
1.Es fácil para el desglose de las tareas debido a que se utilizó divide y vencerás.
2.Tiene un costo de entrega inicial más bajo.
3.Tiene un despliegue de recursos incremental.
4.Es bueno usarlo cuando los requisitos se conocen por adelantado.
5.Es bueno usarlo cuando los proyectos tienen cronogramas de desarrollo extensos.
6.Es bueno usarlo cuando los proyectos usan nueva tecnología.
7.Genera software de trabajo de forma rápida y temprana durante el ciclo de vida del software.
8.Es más flexible y menos costoso cambiar el alcance y los requisitos.
9.Es fácil administrar cada iteración.
10.Es fácil administrar el riesgo debido a las iteraciones.

Desventajas:
1.Requiere un buen diseño de la planificación.
2.Es más costoso que el modelo de cascada.
3.La definición del sistema debe ser completa y clara.

El diagrama de flujo de datos de este proyecto no solo corresponde a la aplicación, sino a cómo se gestiona en parte el el documento y la fuente de datos que maneja, ya que ambos aspectos están relacionados directamente. Los diagramas de flujos de datos entonces quedarían de esta manera:

![image](https://github.com/GabrielPerezMinik/integracion-dam/blob/main/docs/Diagrama1.PNG)

## ESTIMACIÓN DE COSTES

[Link de Excel con la estimacion de costes](https://docs.google.com/spreadsheets/d/1Rd3qjHD5qf6JAjjsU7hJKEydYYYr9Js45sEC2GkVuS0/edit?usp=sharing)
