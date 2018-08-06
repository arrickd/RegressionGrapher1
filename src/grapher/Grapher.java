package grapher;


public class Grapher {
    
    static final int width=310;
    static final int height=310;
    
    public static void main(String[] args) {
  
        Regression reg = new Regression("Best fit slave",width,height);
        System.out.println("r= "+Operations.getCorrelation());
        System.out.println("Best line= "+Operations.getIntercept()+"+"+Operations.getSlope()+"x");
        System.out.println("Slope "+Operations.getSlope());
        reg.printList();
        reg.start();
        
       
    }
}
