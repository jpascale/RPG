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

<h2><b>Índice</b></h2>
<a href="https://github.com/jpascale/RPG#instrucciones">-Instrucciones</a>
<a href="https://github.com/jpascale/RPG#controles">-Controles</a>
<a href="https://github.com/jpascale/RPG#jugabilidad">-Jugabilidad</a>
<a href="https://github.com/jpascale/RPG#informe">-Informe</a>

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

Game of Games (GoG) es un RPG(Role-playing Game). Existe un mundo compuesto por criaturas, algunas más fuertes que otras, y por un personaje dedicado a combatirlas. El jugador debe elegir con qué clase quiere jugar, guerrero o mago. El guerrero tiene mucha vida y mucho poder de ataque pero no puede utilizar magia, por lo que combate cuerpo a cuerpo. El mago, por el contrario, no posee demasiada vida, pero puede atacar desde lejos, siempre y cuando la criatura esté en dirección a la cual está mirando y en un determinador rango. El mago utiliza mana para atacar, esta se gasta y se recupera meditando.

Cada personaje tiene un nivel y experiencia para pasar al próximo. La experiencia se gana matando criaturas. Cada nivel hace al personaje más poderoso.

El personaje tiene un inventario con items, los cuales puede tirar o agarrar. Puede conseguir items a medida que avanza el juego. El item por defecto es "Nudillos" y no puede ser tirado (ni desequipado en caso de no tener otros objetos).

El escenario está dividido en tres "stages" o etapas y cada una tiene criaturas y su Boss. Las criaturas de mayor tamaño se llaman "Bosses" y tienen mayores beneficios. El primer Boss otorga un item, el segundo permite atravezar zonas con agua (Y así conseguir más items) y el tercero y último permite ganar el juego. Las criaturas (excepto los bosses) vuelven a revivir (respawnear) al morir. Si un jugador muere, revive en la posición donde empezó la partida.


<h1><b>Informe</b></h1>

El proyecto está dividido en los siguientes paquetes:

```
Backend
-creatures: Clases dedicadas a las criaturas.
-gamelogic: Lógica del personaje y su comportamiento
-worldlogic: Lógica del mundo.

Intermediario
-handlers: Observa el juego y comunica al render.
-render: Dibuja en pantalla.

Frontend
-frontend: Configuración de el motor gráfico. Recibe input por parte del usuario.

Archivos
-IO: Guardado y carga y archivos.
```

<b>Aclaración:</b> Se usó el patrón Observer en todo el backend. Cada método, cuando es necesario, notifica a todos los observadores un cambio de comportamiento. Los observers son seteados desde afuera del backend. Esto permite que en caso de querer cambiar el frontend del juego, se lo remueve, se agrega uno nuevo y se utilizan observers propios de ser necesario.

<h2><b>worldlogic</b></h2>
El mundo (World) está dividido en tiles (Tiles) que son posiciones donde puede estár el personaje, alguna criatura (Alive) o un item (Item). La orientación se maneja con un sistema de direcciones: norte, sur, este y oeste. Cada Tile posee triggers, los cuales indican si es una posición legal, normal o si hay agua. Los triggers se guardan en un archivo y se cargan cada vez que inicia el juego. Sólo puede haber un Alive por tile.

Para el mapa (World) se utiliza el patrón Singleton.

<h2><b>gamelogic</b></h2>
La Clase más importante es Character. Es la clase que representa al personaje del jugador. Character hereda de Alive, que es la clase que representa algo "vivo" dentro del juego. Se hizo esto con el objetivo de reutilizar código ya que el personaje y las criaturas tienen varios comportamientos en común. Character engloba distintas clases, cada una cumple una funcionalidad distinta con el objetivo de organizar bien el código.

Las clases más importantes que engloba Alive son:
```
Status: Todo lo relacionado a la vida y mana. Los Alive que son criaturas se crean con mana 0.
Tile: Posición donde está parado.

Alive tiene una dirección (Dir - Enum) y un indicador que habilita el poder atravezar zonas con agua.
```

Las clases más importantes que engloba Character son:
```
LevelProfile: Encargado de manejar la experiencia y el nivel del jugador. También actualiza los otros perfiles cada vez que se sube un nivel.

Type: Tipo de clase del personaje (En este proyecto Guerrero o Mago). Character le delega la forma de atacar a Type, quien se la delega a cada clase. (Polimorfismo). Se utilizó el patrón strategy.

Equipment: Inventario del personaje. Agarra/tira un objeto en un tile, y lo equipa.
```