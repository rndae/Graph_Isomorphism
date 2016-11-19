------------------------------------------------------------------------
This is the project README file:
------------------------------------------------------------------------

PROJECT TITLE: Isomorfismo
PURPOSE OF PROJECT: Determinar si dos grafos son isomorfos
VERSION or DATE: 11/11/2016
HOW TO START THIS PROJECT: Run the main method from the "Ventana" Class to start the program.
			   Ejecutar el metodo "main" de Ventana.
AUTHORS: RVG
USER INSTRUCTIONS:

1.	Preparar los dos grafos a ser evaluados, para esto: 
    > Ir a la carpeta donde está el paquete y los archivos de java y ubicar los archivos de texto “grafo1.txt” y “grafo2.txt”
    > Seguidamente para determinar los grafos a procesar, modifique el texto en cada uno de los respectivos archivos, nótese que el formato de lectura es el siguiente:

    cantidad_vertices	 cantidad_aristas
    x(0) 			y(0)
    x(1) 			y(1)
    x(2) 			y(2)
    ... 			...
    ... 			...
    x(cant_aristas-1) 	y(cant_aristas-1)

    x representa un vértice que se conecta a otro representado por y. 

    Ejemplo, para un grafo con 7 vertices y 6 aristas
 
    7 6
    2 4
    0 2
    1 3
    4 6
    4 5
    0 1

2.	Ejecutar el programa principal que está en la clase “Ventana” (Ventana.java)
        Se abrirá una ventana con los dos grafos dibujados.
    
3.	Presionar el botón “VERIFICAR” que aparece en la aplicación para saber si existe isomorfismo entre los dos grafos, si existe empezarán inmediatamente a animarse.

