
package kalastajapeli.domain;

public class Pala {
    int x;
    int y;
    
    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean osuu(Pala toinen){
        return x==toinen.x && y==toinen.y;
    }
    
    public String toString(){
        return "("+x+","+y+")";
    }
}
