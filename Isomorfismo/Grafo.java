import java.util.*;

/**
 * "Grafo"
 *      Representa un grafo en una lista de adyacencia, junto con sus propiedades.
 * @author Rodrigo Vena Garcia
 * @version 1, 06/11/2016
 */
public class Grafo
{
    int aristas,vertices;
    Dupla[] enlaces;
    List<Integer>[] grafo;
    
    public Grafo(int lecv, Dupla[] leca)
    {
        vertices=lecv;
        grafo=(List<Integer>[])new List[vertices];
        aristas=leca.length;
        enlaces=leca;
        addVertices();
        addEnlaces();
    }
    
    public int getOrden()
    {
        return vertices;
    }
    
    public int getTam()
    {
        return aristas;
    }
    
    private void addVertices(){
        for(int i=0;i<vertices;i++){
            grafo[i]=new ArrayList<Integer>();
        }
    }
    
    private void addArista(int a, int b){
        grafo[a].add(b);
        grafo[b].add(a);
    }
    
    private void addEnlaces(){
        for(int i=0;i<aristas;i++){
            addArista(enlaces[i].getX(),enlaces[i].getY());
        }
    }
    
    public int[] getVecinos(int v){
        int vec[]=new int[grafo[v].size()];
        int i=0;
        for(int item:grafo[v]){
            vec[i]=item;
            i++;
        }
        return vec;
    }
}
