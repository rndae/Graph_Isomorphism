
public class Dupla
{
    private int x;
    private int y;

    public Dupla(int xx, int yy)
    {
        x=xx;
        y=yy;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setXY(int modx, int mody){
        x=x+modx;
        y=y+mody;
    }
}
