Game of Games
===

Instituto Tecnológico de Buenos Aires
Programación Orientada a objetos

Profesores:
	-Pablo Giorgi
	-Augusto Nizzo McIntosh
	-Claudio 

Alumnos:
	-Juan Martín Pascale - 55027
	-Teófilo Duffau - 54151

<h2><b>Instrucciones</b></h2>

1. Clonar el repositorio: 
```
git clone git@github.com:jpascale/RPG.git
```

2. Importar el proyecto desde Eclipse:
```
File > Import
```

3. Ejecutar.

4. _(Opcional)_ En caso de no ejecutar es un problema de los archivos nativos de Slick2D. La solución es:
```
	Click derecho sobre el proyecto > Properties > Java Build Path
	Add JARs > Agregar todos los JAR de lib/jars

	Expandir lwjgl.jar > Clickear "Edit..." > Setear como directorio los nativos del sistema operativo que se esté usando. EJ: "GOG/lib/native/macosx"
```

<h2><b>Controles</b></h2>

Flecha derecha: Moverse a la derecha
Flecha izquierda: Moverse a la izquierda
Arriba: Moverse hacia el norte
Flecha: Moverse hacia el sur

Barra especiadora: Atacar

M: Meditar (Magos)
A: Agarrar/Tirar item al piso
Q: Equipar item

Z: Recuperar todos los stats (Cheat)

1: Guardar partida en Slot 1
2: Guardar partida en Slot 2
3: Guardar partida en Slot 3


<h2><b>Jugabilidad</b></h2>

Game of Games (GoG) es un RPG(Role-playing Game). Existe un mundo compuesto por criaturas, algunas más fuertes que otras, y por un personaje dedicado a combatirlas. El jugador debe elegir con qué clase quiere jugar, guerrero o mago. El guerrero tiene mucha vida y mucho poder de ataque pero no puede utilizar magia, por lo que combate cuerpo a cuerpo. El mago, por el contrario, no posee demasiada vida, pero puede atacar desde lejos, siempre y cuando la criatura esté en dirección a la cual está mirando y en un determinador rango.

Cada personaje tiene un nivel y experiencia para pasar al próximo. La experiencia se gana matando criaturas. Cada nivel hace al personaje más poderoso.

El escenario está dividido en tres "stages" o etapas y cada una tiene criaturas y su Boss. Las criaturas de mayor tamaño se llaman "Bosses" y tienen mayores beneficios. El primer Boss otorga un item, el segundo permite atravezar zonas con agua (Y así conseguir más items) y el tercero y último permite ganar el juego. Las criaturas (excepto los bosses) vuelven a revivir (respawnear) al morir. Si un jugador muere, revive en la posición donde empezó la partida.


<h1><b>Informe</b></h1>
