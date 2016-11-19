/**
 * "Gráfico"
 *      Esta clase se encarga de proporcionar un grafo apto para graficar
			como se puede observar, los vertices son un conjunto de pares,
 			que se pueden representar en un plano coordenado.
 * @author Rodrigo Vena Garcia
 * @version 1, 10/11/2016
 */
public class Grafico
{
    private Dupla[] vertices;
    private Dupla[] enlaces;
    private boolean izq;
    private double ang;
    
    public Grafico(int nver, Dupla[] ar, boolean left){
        vertices= new Dupla[nver];
        enlaces= ar;
        izq=left;
        ang=2*Math.PI/nver;
		if(nver%2==0)
	        posicionar();
		else posicionarI();
    }
    
    public void setVerX(int i, int x){
        vertices[i].setXY(x,0);   //no modifica directamente
    }
    
    public void setVerY(int i, int y){
        vertices[i].setXY(0,y);   //no modifica directamente
    }
    
    public int getNver(){
        return vertices.length;
    }
    
    public int getAristas(){
        return enlaces.length;
    }
    
    private void posicionar(){
        double y=0;    //se obtiene mediante el seno de nuestro circulo
        boolean forma=true; //300 es el desplazamiento necesario
        for(int i=1;i<=vertices.length;i++){
            y=(Math.sin(i*ang)*250)+300;
            if(espejo(i-1,(int)Math.round(y))){
                forma=false;
                vertices[i-1]=new Dupla(raizEntera(y,forma),(int)Math.round(y));
                forma=true;
            }
            else
                vertices[i-1]=new Dupla(raizEntera(y,forma),(int)Math.round(y));
        }
    }

	private void posicionarI(){
        double y=0;    //se obtiene mediante el seno de nuestro circulo
        boolean forma=true; //300 es el desplazamiento necesario
        for(int i=1;i<=vertices.length;i++){
            y=(Math.sin(i*ang)*250)+300;
            vertices[i-1]=new Dupla(raizEntera(y,forma),(int)Math.round(y));
			forma=!forma;
        }
    }
    
    /*Se aplica la formula del círculo para posicionar los vertices,
        con tal formula obtenemos las dos raices para un valor de x
      62500 en la formula para un radio de 250, con el centro en 300,300 en 
        izq y 330 de espacio entre cada centro
    */
    private int raizEntera(double y, boolean forma){
        int des=0;
        if(!izq)
            des=2*250+80;
        int x=0;
        if(forma)
            x=(int)(300+des+Math.sqrt(62500-((y-300)*(y-300))));
        else
            x=(int)(300+des-Math.sqrt(62500-((y-300)*(y-300))));
        return x;
    }
    
    private boolean espejo(int ultimo, int y){
        boolean hubo=false;
        for(int i=0; i<ultimo;i++)
            if(vertices[i].getY()==y)
                hubo=true;
        return hubo;
    }
    
    public Dupla getVertice(int i){
        return new Dupla(vertices[i].getX(),vertices[i].getY());
    }
    
    public Dupla getEnlaceA(int i){
        return new Dupla(vertices[enlaces[i].getX()].getX()
                ,vertices[enlaces[i].getX()].getY());
    }
    
    public Dupla getEnlaceB(int i){
        return new Dupla( vertices[enlaces[i].getY()].getX(),
            vertices[enlaces[i].getY()].getY());
    }
}