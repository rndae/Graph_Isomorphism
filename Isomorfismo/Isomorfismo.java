
/**
 * "Isomorfismo de un Grafo"
 *      Clase encargada de determinar el isomorfismo de un grafo.
 * @author Rodrigo Vena Garcia
 * @version 1, 10/11/2016
 */
public class Isomorfismo
{
    private Grafo g1, g2;
    private boolean []cond;
    private int[] map;
    private int t;
    private int[][] mat; //matriz de compatibilidad //[g1][g2]
    
    public Isomorfismo(Grafo grafo1, Grafo grafo2)
    {
        g1=grafo1;
        g2=grafo2;
        cond=new boolean[]{false,false,false};
        ordenG();
        tamG();
        t=g1.getOrden();
        mat=new int[t][t];
        map=funcM();
    }
    
    public int[] getMapeo(){
        return map;
    }
    
    public String verificar(){
        String r="No hay función de mapeo.";
        if(cond[0]&&cond[1])
            if(map!=null)
                r="Existe isomorfismo";
            else
                r="No existe una función de mapeo, no son isomorfos";
        else if(cond[1])
            r="No son isomorfos, porque no son del mismo orden. " +r;
        else if(cond[0])
            r="No son isomorfos, porque no son del mismo tamaño. " +r;
        else
            r="No son isomorfos, porque no son ni del mismo tamaño ni orden. "+r;
        return r;
    }
    
    private void ordenG(){
        if(g1.getOrden()==g2.getOrden())
            cond[0]=true;
    }
    
    private void tamG(){
        if(g1.getTam()==g2.getTam())
            cond[1]=true;
    }
    
    private int[] funcM(){
        int[] rel=null;
        if(cond[0]&&cond[1]){
            rel=new int[g1.getOrden()];
            rel=iso();
        }
        return rel;
    }
    
    private int[] rellenar(int[]f){
        for(int i=0;i<f.length;i++){
            f[i]=-1;
        }
        return f;
    }
    
    private int[] iso(){
        int[] f=new int[t];
        int [] aux;
        f=rellenar(f);
        for (int i=0;i<t;i++)
            for(int j=0;j<t;j++)                
                if(com(i,j)==-1){   //si no es compatible
                    if(j==t-1){
                        f=null;
                        i=t;
                    }}
                else if(com(i,j)==0){   //si no se verificó aún
                    aux=f;
                    ver(i,j,copia(f));
                    if(com(i,j)==1 && contiene(f,j)==-1){
                            f[i]=j;
                            j=t;
                    }else {
                        if(j==t-1){
                        f=null;
                        i=t;
                    }
                    }
                }else if(contiene(f,j)>-1){
                    ;
                }else {   //en caso de que sea compatible
                    f[i]=j;
                    j=t;
                     }
        return f;
    }
    
    private int[] copia(int [] fun){
        int[] aux=new int[fun.length];
        for(int i=0;i<aux.length;i++)
            aux[i]=fun[i];
        return aux;
    }
    
    private int ver(int p, int q, int[] local){        
        int[] a=g2.getVecinos(p);
        int[] b=g1.getVecinos(q);
        //int[] local=parcial;
        int [] pareja=new int[a.length];
        //local=parcial;
        int r=0;
        if(a.length!=b.length||mat[p][q]==-1){
            //mat[p][q]=-1;
            r=-1;
        }else if(mat[p][q]==1)
            r=1;
        else{
            int conte=-1;
            for(int i=0;i<a.length;i++){
                for(int j=0;j<b.length;j++){
                    conte=contiene(local,b[j]);
                    if(conte!=-1){  //contiene==true
                        if(conte==a[i]){
                            pareja[i]=1;
                            j=a.length;
                        }
                    }else{
                        local[a[i]]=b[j];
                        int ant=local[a[i]];
                        if(ver(a[i],b[j],local)==-1){
                            local[a[i]]=ant;
                        }else {
                            pareja[i]=1;
                            j=a.length;
                        }
                    }
                }
            }
            if(contiene(pareja,0)==-1||a.length==0){
                mat[p][q]=1;
                r=1;
            }else{
                mat[p][q]=-1;
                r=-1;
            }
        }
        return r;
    }
    
    private int contiene(int[] func,int ele){
        int tiene=-1;
        for(int i=0;i<func.length;i++){
            if(func[i]==ele){
                tiene=i;
                i=func.length;
            }
        }
        return tiene;
    }
    
    private int com(int p, int q){
        return mat[p][q];
    }
}
