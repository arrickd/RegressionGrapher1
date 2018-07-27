package grapher;

import graphs.Graph;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Graphics;

public class Regression extends Graph {
    
    //private Graphics draw;
    
    public Regression(String title, int width, int height){
        
       super(title,width, height);
        
        coordsX=new ArrayList<>();
        coordsY=new ArrayList<>();
        pairs=0;
        enterData();
      //  draw();        
    }

   // @Override
    public void enterData() {

      //  Scanner scan = new Scanner(System.in);

       // System.out.println("Number of coordinate pairs to enter?");
        pairs = 10;
        
        coordsX.add(20.0); coordsY.add(140.0);
        coordsX.add(60.0); coordsY.add(180.0);
        coordsX.add(130.0); coordsY.add(150.0);
        coordsX.add(95.0); coordsY.add(170.0);
        coordsX.add(75.0); coordsY.add(180.0);
        coordsX.add(40.0); coordsY.add(150.0);
        coordsX.add(120.0); coordsY.add(165.0);
        coordsX.add(185.0); coordsY.add(190.0);
        coordsX.add(100.0); coordsY.add(120.0);
        coordsX.add(200.0); coordsY.add(295.0);
        
        /*
        int check = 0;
        while (check < 5) {

            check++;

            System.out.println("enter x coord: ");
            coordsX.add(scan.nextDouble());

            System.out.println("enter y coord: ");
            coordsY.add(scan.nextDouble());

        }
        */
        
        Operations.setMeanX(coordsX, pairs);
        Operations.setMeanY(coordsY, pairs);
        Operations.setCorrelation(coordsX, coordsY, pairs);
        Operations.setSlope(coordsX, coordsY, pairs);
        Operations.setIntercept();
        
        /* WASTED TIME SORTING ARRAY
        double temp =0;
       
        for (int i = 0; i<coordsX.size(); i++){
            
            for (int j =0; j<coordsX.size(); j++){
            
               if(coordsX.get(i)>coordsX.get(j)){
                   
                   temp =  coordsX.get(i);
                   coordsX.set(i, coordsX.get(j));
                   coordsX.set(j, temp);
               }    
            }  
        }
        */
    }
      
    public static void draw(){
                  
        for(int i=0; i<pairs; i++){
            
            long x = Math.round(coordsX.get(i));
            long y = Math.round(coordsY.get(i));
                                       
            g.setColor(Color.red);
          //g.fillOval( (int)x-3, height-(int)y-3, 6, 6); 
            g.fillOval( (int)x,(int)y, 6, 6); 
        }
                
        g.drawLine(0, (int)Math.round(Operations.getIntercept()), getWidth(), (int)(Math.round(Operations.getSlope()*getWidth())+Operations.getIntercept()));          
    }
}
