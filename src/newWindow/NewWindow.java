package newWindow;

import display.Display;
import grapher.Regression;
import grapher.Operations;
//import gfx.Assets;
//import input.InputManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
//import states.GameState;
//import states.States;
//import states.Win;

//Implement Runnable for threading needs run()
public class NewWindow implements Runnable {

    protected Display display;
    public static int width, height;
    public String title;

    private Thread thread;
    private boolean running = false;

    protected BufferStrategy bs;
    protected static Graphics g;

    //STATES
    //private States gameState;
    //private InputManager inputKey;
    //private static boolean win = Player.isWin();
    //Constructor
    public NewWindow(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;
        //display = new Display(title, width, height);
        // inputKey = new InputManager();
    }

    //INITIALIZER calls new display
    private void init() {

        display = new Display(title, width, height);
        
        //display.getFrame().addKeyListener(inputKey);
        // Assets.init(); //load all assets once

     //   gameState = new GameState(this);
     //   States.setState(gameState);

    }

    //Updates variables position etc
    private void tick() {

        // inputKey.tick();
        // if(States.getState()!=null)
        //   States.getState().tick();
    }

    //Drawing stuff after updated thru tick
    public void render() {

        
        bs = display.getCanvas().getBufferStrategy(); // draw to buffer>screen
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3); // 3 buffers
            return;
        }

        g = bs.getDrawGraphics(); // draw tool

        //clear screen
        g.clearRect(0, 0, width, height);

        //Draw here//
        
       // g.setColor(Color.blue);
       // g.drawRect(0, 0, 100, 100);
       // g.fillOval(100, 100, 100, 100);
        Regression.draw();
        
       
        
        //  if(States.getState()!=null)
        //  States.getState().render(g);
        //End draw//
        //display and dump resource
        bs.show();
        g.dispose();       
    }

    //initializes game loop
    @Override
    public void run() {

        init();
        render();
        

        int fps = 100;// higher = faster game
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        //increments tick and render based on fps set
        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            /*
            if(timer>= 1000000000){ //prints fps
                System.out.println("ticks and frams:" +ticks);
                ticks = 0;
                timer =0;
            }*/
        }

        stop();

    }
//
//    // public InputManager getInputManager(){
//    //     return inputKey;
//    // }
//    //check if running and create thread, also intializes run method
    public synchronized void start() {

        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);//pass this object
        thread.start();
    }
//
//    //check if stopped and stop thread, nees try catch
    public synchronized void stop() {

        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Graphics getG() {
        return g;
    }
    
    public static int getWidth(){
        return width;
    }
    
    public static int getHeight(){
        return height;
    }

   
}
