# UD 1-1 Generación de procesos en Java
#### By Moisés Fernández Muiña

<p>

Durante el proceso de realización de la presente práctica
se ha mantenido un proceso de desarrollo que consta 
de los siguientes aspectos:

- __Cada pregunta se ha respondido en su correspondiente rama__,
siendo la rama de development donde se han unido todas ellas
para comprobar que funcionan correctamente.
- __Los cambios entre ramas no serán aplicados a menos que se
deba solucionar algun error visual.__ Es decir, la rama X se mergea
con development y tiene un error de ortográfico en un _Sout_, se 
habrá corregido sin comentar en el commit.
</p>

Dicho esto, explicaré MI porque a cada solución:

<br>

>_Antes de empezar, avisar que los commits están en Ingles:_

<br>

### TODOS LOS EJERCICIOS FUNCIONAN EN WINDOWS
##### Es posible que en Linux también, pero se deberá tener "Firefox" instalado para los 2 primeros.

__1.- Desarrolla una aplicación en Java que abra el número de ventanas del navegador de tu elección
que indique el usuario. Puede indicarlo como entrada de teclado o como argumento del ejecutable.
El proceso debe terminar cuando todas las ventanas del navegador se cierren.__

Para este ejercicio me basé en una estructura simple, un bucle que pregunta constantemente si el proceso
al que está apuntando está vivo, haciendo que aunque a los que esté apuntando dejen de estarlo, siempre 
apuntará al mismo. Dentro del bucle, cuando un proceso muere es eliminado de la lista, por lo que si al 
proceso al que el "cursor" pregunta, si dicho proceso ha terminado es eliminado de la lista de procesos.
El bucle finaliza cuando la lista tenga un _.size()_ de 0.

__2.- Desarrolla una segunda aplicación en Java que abra el número de ventanas del navegador de tu
elección que indique el usuario. Puede indicarlo como entrada de teclado o como argumento del
ejecutable. Los procesos deben terminar 500 ms después de arrancar. Cada proceso debe indicar la
hora de inicio y la hora de finalización.__

Para esta tarea, hubo un punto que no supuso problema de realizar pero que a la hora de leerlo
no llegué a entender bien, y es que si los procesos morían 500ms tras ser ejecutados (simultáneamente) o bien
se ejecuta 1 y muere a los 500ms, el siguiente igual, etc. He realizado el segundo caso, ya que es mejor visualmente
de ver el resultado. Para este punto, mi desarrollo se basó más en un único bucle que se encarga
de lanzar el proceso, iniciar un contador de milisegundos (marcando el tiempo acutal al mismo tiempo),
y posteriormente matándolo. No utilicé ninguna lista en este caso, ya que no lo vi necesario.

__3- Desarrolla una tercera aplicación en Java que reciba como entrada una ruta a un fichero del
sistema. Tu programa debe abrir el fichero, si existe, utilizando el comando cat y enviar la salida a la
entrada del comando wc, que se utiliza para contar las líneas de un fichero.__

Dado que en windows no existen dichos comandos, realizé dos alternativas: la de Windows y la de Linux. El
código no tiene mucha complicación, sencillamente filtré el comando según el sistema operativo que se está 
ejecutando y redireccioné el resultado para que lo que enviasen los comandos se viese por la salida que yo
quería que se mostrase.