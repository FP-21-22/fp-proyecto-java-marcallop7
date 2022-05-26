# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2021/2022)
Autor/a: Marina Calero Lopez   uvus: marcallop7

El proyecto trata sobre los paciente y la vacunación de la pandemia actual, utilizando datos de interés para implementar distintas funcionalidades.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp**: Paquete que contiene los tipos del proyecto.
  * **fp.clinico**: contiene el tipo Persona y sus métodos.
  * **fp.farmaceutico**: contiene el tipo Paciente y sus métodos
  * **fp.utiles**:  paquete que contiene las clases de utilidad.
  * **fp.vacunas**: contiene el tipo Vacunacion y sus métodos.
  * **fp.test**: contiene las pruebas para el código desarrollado.
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<cca_vacunas_3.csv\>**: nos proporciona información sobre las personas vacunadas.
    * **\<estudio_clinico.csv\>**: nos proporciona información sobre una persona.
    * **\<medicamentos.csv\>**: nos proporciona información sobre los medicamentos.
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset cca_vacunas_3.csv está compuesto por \<7\> columnas, con la siguiente descripción:

* **\<fecha>**: de tipo \<LocalDate\>, representa fecha en la que las personas se vacunaron.
* **\<comunidad>**: de tipo \<String\>, representa la comunidad donde se han vacunado.
* **\<pfizer>**: de tipo \<Integer\>, representa el número de vacunas que se han puesto dicha vacuna en una fecha y comunidad determinada.
* **\<moderna>**: de tipo \<Integer\>, representa el número de vacunas que se han puesto dicha vacuna en una fecha y comunidad determinada.
* **\<astrazeneca>**: de tipo \<Integer\>, representa el número de vacunas que se han puesto dicha vacuna en una fecha y comunidad determinada.
* **\<jassen>**: de tipo \<Integer\>, representa el número de vacunas que se han puesto dicha vacuna en una fecha y comunidad determinada.
* **\<num_personas>**: de tipo \<Integer\>, representa el número de personas que se han puesto dicha vacuna en una fecha y comunidad determinada.

El dataset estudio_clinico.csv está compuesto por \<7\> columnas, con la siguiente descripción:

* **\<id>**: de tipo \<String\>, representa el id de una persona.
* **\<genero>**: de tipo \<String\>, representa el genero de la persona, puede ser Male, Female o Others.
* **\<edad>**: de tipo \<Double\>, representa la edad de la persona.
* **\<hipertension>**: de tipo \<Boolean\>, representa si la persona tiene hipertension o no.
* **\<enfermedad_corazon>**: de tipo \<Boolean\>, representa si la persona tiene o no problemas en el corazón.
* **\<tipo>**: de tipo \<TipoResidencia\>, representa donde reside la persona, si en un sitio rural o urbano.
* **\<nivel_medio_glucosa>**: de tipo \<Double\>, representa el nivel medio de glucosa.

El dataset medicamentos.csv está compuesto por \<7\> columnas, con la siguiente descripción:

* **\<nombre_medicamento>**: de tipo \<String\>, representa el nombre del medicamento.
* **\<tipo>**: de tipo \<Tipo_medicamento\>, representa el tipo de medicamento, si es anatomico, quimico o terapeutico.
* **\<codigo_enfermedad>**: de tipo \<String\>, representa el código de la enfermedad.
* **\<farmaceutica>**: de tipo \<String\>, representa la farmaceutica de donde viene.
* **\<puntucaion>**: de tipo \<Double\>, representa la puntuación del medicamento.
* **\<indice_somatico>**: de tipo \<Integer\>, representa el indice somático del medicamento.
* **\<fecha_catalogo>**: de tipo \<LocalDate\>, representa la fecha del medicamento.


## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
