import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Ventana
{
    private static JFrame f;
    private static JPanel p;
    private static JButton b_isom;
    
    public Ventana(){
        f=new JFrame("Isomorfismo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        p= new JPanel();
        b_isom=new JButton("Verificar");
    }
    
    public static void main(String[] args){
		Lectura l= new Lectura();
		Dupla[] arista1=l.leerGs(new File("grafo1.txt"));
		int v1=l.getV();
		Dupla[] arista2=l.leerGs(new File("grafo2.txt"));
		int v2=l.getV();
        Grafico g1=new Grafico(v1,arista1, true);
        Grafico g2=new Grafico(v2,arista2, false);
        Grafo gra1=new Grafo(v1,arista1);
        Grafo gra2=new Grafo(v2,arista2);
        
        Isomorfismo iso=new Isomorfismo(gra1,gra2);
        final String veri= iso.verificar();
        final int[] map=iso.getMapeo();
        
        final Dibujo d1=new Dibujo(g1,g2);
        new Ventana();
        final Dibujo d2= new Dibujo(g1,g2,map);
        p.add(b_isom);
        p.add(d1);
        f.add(p);
        
        f.add(p,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        
        b_isom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,veri);
                if(map!=null){
                p.remove(d1);
                p.add(d2);
                f.add(p,BorderLayout.CENTER);
                f.pack();
                f.setVisible(true);
            }
            }
        }); 
    }
}
