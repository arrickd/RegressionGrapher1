package graphs;

import java.util.ArrayList;
import newWindow.NewWindow;

public abstract class Graph extends NewWindow {
    
    protected static ArrayList<Double> coordsX; //= new ArrayList<>();
    protected static ArrayList<Double> coordsY; //= new ArrayList<>();
    protected static int pairs; // = 0;
    protected static int width;
    protected static int height;

    public Graph(String title, int width, int height) {
        super(title, width, height);
    }
    
   // public abstract void init();
   // public abstract void render();
    
    public void printList() {

        for (int i = 0; i < pairs; i ++) {

            System.out.println("("+coordsX.get(i) + ", " + coordsY.get(i)+")");

        }

    }

    /*
    public void setCoordsX(ArrayList<Double> coordsX) {
        Graph.coordsX = coordsX;
    }

    public void setCoordsY(ArrayList<Double> coordsY) {
        Graph.coordsY = coordsY;
    }
   

    public void setPairs(int pairs) {
        Graph.pairs = pairs;
    }

 */
    
    public ArrayList<Double> getCoordsX() {
        return coordsX;
    }

    public ArrayList<Double> getCoordsY() {
        return coordsY;
    }

    public int getPairs() {
        return pairs;
    }
    
    
    
    
    
    
}

