# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Manuel Serrano Rubio  uvus: manserrub

Trabajaremos con un dataset de datos sobre los pasajeros que viajaban en el titanic. 
Ofrece datos sobre los pasajeros en cuestion, nombre, edad, ropa que llevaban...
Utilizaremos una programación orientada a objetos (java) para realizar consultas sobre este dataset.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.pasajero**: Paquete que contiene los tipos del proyecto.
  * **fp.pasajero.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto.
    * **titanic.csv**: Dataset de datos sobre titanic.
    
## Estructura del *dataset*

El dataset está compuesto por 10 columnas, con la siguiente descripción:

* **PassengerId**: de tipo Integer, representa la ID del pasajero.
* **Name**: de tipo String, representa el nombre del pasajero.
* **BoardingTime**: de tipo LocalTime, representa la hora de embarque del pasajero.
* **Survived**: de tipo Boolean, representa si el pasajero sobrevivio o no.
* **Age**: de tipo Integer, representa la edad del pasajero.
* **Cabin**: de tipo String, representa la cabina en la que viajaba el pasajero.
* **Pclass**: de tipo Integer, representa la clase en la que viajaba el pasajero.
* **TicketCost**: de tipo Integer, el precio del billete comprado por el pasajero.
* **Sex**: de tipo Enumerate, representa el genero del pasajero.
* **Clothes**: de tipo List<String>, representa una lista con la ropa que llevaban los pasajeros.
	
	Además, el dataset está formado por 891 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados



### Tipo Base
En el tipo base del proyecto (pasajeros.java), se declaran las propiedades básicas del tipo, las propiedades derivadas, las funciones auxiliares, los métodos getters y setters, los constructores, los checkers, el método de igualdad, el método de orden natural y la representación como cadena.

**Propiedades**:

- PassengerId, de tipo Integer,  consultable y modificable.
- Name, de tipo String,  consultable y modificable.
- BoardingTime, de tipo LocalTime, consultable y modificable.
- Survived, de tipo Boolean, consultable y modificable.
- Age, de tipo Integer, consultable y modificable.
- Cabin, de tipo String, consultable y modificable.
- Pclass, de tipo Integer, consultable y modificable.
- TicketCost, de tipo Integer, consultable y modificable.
- Sex, de tipo Enumerate, consultable y modificable.
- Clothes, de tipo List<String>, consultable y modificable.

**Constructores**: 

- C1: Un constructor con todas las propiedades del tipo.
- C2: Un constructor con las propiedades: passengerId, name, sex y age.

**Restricciones**:
 
- R1: La persona tiene que tener entre 25 y 40 años, age <= 40 && age >= 25
- R2: El precio del ticket tiene que ser positivo, ticketCost > 0
- R3: La persona tiene que haber embarcado entre las 12:00 y las 22:00, boardingTime.isAfter(LocalTime.of(10,00,00)) && boardingTime.isBefore(LocalTime.of(22, 00, 00)

**Criterio de igualdad**: Para que dos objetos sean iguales se tiene que cumplir que todos los atributos lo son.

**Criterio de ordenación**: Para establecer el orden natural, primero, comparamos por el name, posteriormente por el ID del pasajero, si ha sobrevivido, la edad, la clase en la que viajaba, la cabina, el genero, el precio del ticket y por ultimo la hora de abordaje. En ese orden.

**Otras operaciones**:
 
-	getHourBoarding(): Nos da la HORA exacta de abordaje, solo la hora, sin minutos ni segundos. Es una propiedad derivada.

#### Tipos auxiliaress
Este proyecto, cuenta con un tipo Enumerate llamado Genero, que cuenta con 2 propiedades: MALE, FEMALE..

### Factoría
La factoria se encarga de parsear los diferentes datos del csv para luego pasarlo por una funcion que los lee y muestra por consola.

- List<Pasajero> leePasajero(String rutaFichero): Engargado de leer el csv y pasarlo por consola.
-	Pasajero parsearPasajero(String linea): Encargado de parsear los datos del csv.
-	Boolean parseaBooleano(Integer a): Encargado de parsear los Booleanos.
-	List<String> parseLista(String cadena): Encargado de parsear las Listas.

### Tipo Contenedor

En el contenedor encontramos todas las funciones las cuales se encargan de jugar con los diferentes datos para mostrar variedades de soluciones y respuestas a diferentes problemas que se puedan plantear.

**Propiedades**:

- passenger, de tipo \<List<Pasajero>\>, consultable. 

**Constructores**: 

- ContenedorPasajero(): Constructor vacio que crea una lista vacia.
- ContenedorPasajero(Collection<Pasajero> passenger): Constructor que introduce un collection el cual pasa los datos recibidos a una lista.
- ContenedorPasajero(Stream<Pasajero> passenger): Constructor que introduce un stream el cual pasa los datos recibidos a una lista.

	
**Criterio de igualdad**: Igualdad segun passenger.

**Otras operaciones**:
 
ENTREGA II
-	Double getCosteTotal(): Nos devuelve el precio total de todos los tickets.
-	Boolean existePasajeroPorEdad(Integer age): Nos dice si existe algun pasajero con la edad que le damos.
-	List<String> getPasajerosVivos(): Nos devuelve una lista con los pasajeros que sobrevivieron.
-	Map <Integer, List <String>> agrupaPasajerosPorClases(): Map que agrupa los diferentes pasajeros segun la clase en la que viajaban.
-	Map<Genero, Integer> numeroPasajerosPorSexo(): Map con el numero de pasajeros que viajaba de cada sexo.
	
ENTREGA III
	BLOQUE I
-	Boolean existePasajeroPorEdadSTREAM(Integer age): Nos dice si existe algun pasajero con la edad que le damos haciendo uso de .stream() .
-	Integer  getCosteTotalSTREAM(): Nos devuelve el precio total de todos los tickets haciendo uso de .stream() .
-	List<String> getPasajerosVivosSTREAM(): Nos devuelve una lista con los pasajeros que sobrevivieron haciendo uso de .stream() .
-	Pasajero maxPasajeroPorCosteTicketYSurvivedSTREAM(): Pasajero que sobrevivio y mas gasto en su ticket.
-	List<Pasajero> filtradoPorSurvivedOrdenadoPorEdadSTREAM(): Lista ordenada por edad de pasajeros que sobrevivieron.
	
	BLOQUE II
-	Map <Integer, List <String>> agrupaPasajerosPorClasesSTREAM(): Agrupa los pasajeros por clases.
-	Map <Genero, List<Integer>> agruparEdadSegunGeneroSTREAM(): Crea un map con el genero como clave y una lista con la edad de todos los pasajeros de ese genero. .
-	Map <Integer, Pasajero> agruparMaxPasajeroPorEdadSTREAM(): Pasajero por edad que gasto mas en su ticket.
-	SortedMap<Genero, List<String>> getNPrimerosPasajerosPorGeneroSTREAM(Integer n): N pasajeros segun genero que entraron primero en el barco.
-	Genero getMayorNumeroDeGeneroABordoSTREAM(): Devuelve el genero del mayor numero de pasajeros de ese mismo genero.
