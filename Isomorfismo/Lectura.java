import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * "Lectura"
 *      Se encarga de codificar una entrada para el grafo
 * @author Rodrigo Vena Garcia
 * @version 1, 10/11/2016
 */
public class Lectura
{
    private int v;
    public Lectura(){
        v=-1;
    }
    
    public int getV(){
        return v;
    }
    
    public Dupla[] leerGs(File grafo){
        Dupla[] enlaces;
       try {
          Scanner scan = new Scanner(grafo);
          v = scan.nextInt();
          int aristas = scan.nextInt();
          enlaces = new Dupla[aristas];
        for(int i=0; i<aristas; i++) {
           enlaces[i]=new Dupla(scan.nextInt(), scan.nextInt());
        }
        scan.close();
        } 
       catch (FileNotFoundException e) {
           enlaces=null;
           e.printStackTrace();
       }
       return enlaces;
    }
}

/*El formato de lectura que se considera es el siguiete:
 * 
 *  cantidad_vertices cantidad_aristas
 *  x(0) y(0)
 *  x(1) y(1)
 *  x(2) y(2)
 *  ... ...
 *  ... ...
 *  x(cant_aristas-1) y(cant_aristas-1)
 * 
 * //////////////////
 * Ejemplo, para un grafo con 7 vertices y 6 aristas
 * 
 * 7 6
 * 2 4
 * 0 2
 * 1 3
 * 4 6
 * 4 5
 * 0 1
*/