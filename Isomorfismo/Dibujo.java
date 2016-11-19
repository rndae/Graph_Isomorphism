import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * "Dibujo"
 *    Clase encargada de animar y dibujar los dos grafos
 * @author Rodrigo Vena Garcia
 * @version 1, 06/11/2016
 */

public class Dibujo extends JPanel implements ActionListener
{
    Grafico g1,g2;
    //
    Timer tm;
    int tiempo=0;
    boolean ani;
    int[] map;
    boolean [] sobreX;
    boolean [] sobreY;
    
    public Dibujo(Grafico gr1, Grafico gr2)
    {
        g1=gr1;
        g2=gr2;
        ani=false;
    }
    
    public Dibujo(Grafico gr1, Grafico gr2, int[] mapeo)
    {
        g1=gr1;
        g2=gr2;
        if(mapeo!=null)
            ani=true;
        else ani=false;
        map=mapeo;
        tm=new Timer(10,this);
        sobreX= new boolean[gr2.getNver()];
        sobreY= new boolean[gr2.getNver()];
    }
    
    public boolean fusionado(boolean [] sobre){
        boolean fus=true;
        for(int i=0;i<sobre.length;i++){
            if(sobre[i]==false){
                fus=false;
                i=sobre.length;
            }
        }
        return fus;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        if(ani){
            armarG(g,g1);
            fusionar(g);
            tm.start();
            g.drawString("Tiempo:"+tiempo, 5, 70);
            if(fusionado(sobreX)&&fusionado(sobreY))
                tm.stop();
        }else{
            armarG(g,g1);
            armarG(g,g2);
        }
    }
    
    private void armarG(Graphics g, Grafico gra){
        g.setColor(Color.WHITE);
        for(int i=0; i<gra.getNver();i++){
            g.fillOval(gra.getVertice(i).getX(),gra.getVertice(i).getY(),7,7);
        }
        g.setColor(Color.decode("#293d56"));
        for(int i=0; i<gra.getAristas();i++){
            g.drawLine(gra.getEnlaceA(i).getX(),gra.getEnlaceA(i).getY(),
                       gra.getEnlaceB(i).getX(),gra.getEnlaceB(i).getY());
        }
    }
    
    private void fusionar(Graphics g){
        //revisar
        g.setColor(Color.RED);
        for(int i=0; i<g2.getNver();i++){
            if(Math.abs(g2.getVertice(i).getX()-g1.getVertice(map[i]).getX())>0){
                g2.setVerX(i,-1);
            }else
                sobreX[i]=true;
            if(Math.abs(g2.getVertice(i).getY()-g1.getVertice(map[i]).getY())>0){   
                if(g2.getVertice(i).getY()-g1.getVertice(map[i]).getY()>0)
                    g2.setVerY(i,-1);
                else g2.setVerY(i,1);
            }else
                sobreY[i]=true;
            g.fillOval(g2.getVertice(i).getX(),g2.getVertice(i).getY(),7,7);
        }
        g.setColor(Color.decode("#463263"));
        for(int i=0; i<g2.getAristas();i++){
            g.drawLine(g2.getEnlaceA(i).getX(),g2.getEnlaceA(i).getY(),
                       g2.getEnlaceB(i).getX(),g2.getEnlaceB(i).getY());
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
      return new Dimension(1200, 700);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        tiempo=tiempo+1;
        repaint();
    }
}
