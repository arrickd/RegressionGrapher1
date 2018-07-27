package display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    
    //frame
    private JFrame frame;
    private Canvas canvas; //canvas for images in frame
    
    private String title;
    private int width, height;
    
    //frame constructor
    public Display(String title, int width, int height){
        
        this.title=title;
        this.width=width;
        this.height=height;
        
        createDisplay();
        
    }
    
    private void createDisplay(){
        
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes game when hit x
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); //center on screen
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);//need this so any comp can properly display inutp 
        
        frame.add(canvas);//add to frame
        frame.pack(); //pack neatly 
        
    }
    
    public Canvas getCanvas(){
        
        return canvas;
        
    }
    
    public JFrame getFrame(){
        return frame;
        
        
    }
    

}
