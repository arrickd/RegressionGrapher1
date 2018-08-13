package grapher;

import graphs.Graph;

import java.awt.Color;

import java.util.ArrayList;

import java.awt.image.BufferedImage;

import display.ImageLoader;

public class Regression extends Graph {
       
    public Regression(String title, int width, int height){
        
       super(title,width, height);
        
        coordsX=new ArrayList<>();
        coordsY=new ArrayList<>();
        pairs=0;
        enterData();       
    }

   // @Override
    public void enterData() {
       
        //EDIT ME/////////////////////////////
        coordsX.add(20.0); coordsY.add(140.0); //pair 1
        coordsX.add(60.0); coordsY.add(180.0); //pair 2..etc
        coordsX.add(130.0); coordsY.add(150.0);
        coordsX.add(95.0); coordsY.add(170.0);
        coordsX.add(75.0); coordsY.add(180.0);
        coordsX.add(40.0); coordsY.add(150.0);
        coordsX.add(120.0); coordsY.add(165.0);
        coordsX.add(185.0); coordsY.add(190.0);
        coordsX.add(100.0); coordsY.add(120.0);
        coordsX.add(200.0); coordsY.add(295.0);
        ///////////////////////////////////////
         pairs = coordsX.size();
   
        Operations.setMeanX(coordsX, pairs);
        Operations.setMeanY(coordsY, pairs);
        Operations.setCorrelation(coordsX, coordsY, pairs);
        Operations.setSlope(coordsX, coordsY, pairs);
        Operations.setIntercept();        
    }
      
    public static void draw(){
                
        BufferedImage img = ImageLoader.loadImage("/images/background.jpg");
        g.drawImage(img, 0, 0, null);
        
        for(int i=0; i<pairs; i++){
            
            long x = Math.round(coordsX.get(i));
            long y = Math.round(coordsY.get(i));
            
            g.setColor(Color.red);
            g.fillOval( (int)x+8,(300-(int)y), 6, 6); 
            
        }
                
        g.drawLine(8, (300-(int)Math.round(Operations.getIntercept())), getWidth(), 300-((int)(Math.round(Operations.getSlope()*getWidth())+Operations.getIntercept())));          
    
    }
}
