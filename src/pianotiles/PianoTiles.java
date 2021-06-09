package pianotiles;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Calendar;

public class PianoTiles {

    Robot robot;    
    
    public PianoTiles() throws Exception{
        // THE GAME:
        // http://www.4j.com/Piano-Tiles-2-Online
        // Play it on fullscreen
        // Resolution 1280 X 720
        
        robot = new Robot();
        Thread.sleep(3000);
        startGame();
        playGame();     
    }
    
    void playGame() throws Exception{        
        int clicked = 0;
        while(true){            
            if(robot.getPixelColor(743, 670).getRed() < 20 && clicked != 1){
                clicker(743, 670);
                clicked = 1;
            }else if(robot.getPixelColor(878, 670).getRed() < 20 && clicked != 2){
                clicker(878, 670);
                clicked = 2;
            }else if(robot.getPixelColor(1030, 670).getRed() < 20 && clicked != 3){
                clicker(1030, 670);
                clicked = 3;
            }else if(robot.getPixelColor(1165, 670).getRed() < 20 && clicked != 4){
                clicker(1165, 670);
                clicked = 4;
            }            
        }
    }
    
    void startGame() throws Exception{        
        if(robot.getPixelColor(743, 670).getRed() == 54){
            clicker(743, 670);
            System.out.println("Start button 1. place");
        }else if(robot.getPixelColor(878, 670).getRed() == 54){
            clicker(878, 670);
            System.out.println("Start button 2. place");
        }else if(robot.getPixelColor(1030, 670).getRed() == 54){
            clicker(1030, 670);
            System.out.println("Start button 3. place");
        }else if(robot.getPixelColor(1165, 670).getRed() == 54){
            clicker(1165, 670);
            System.out.println("Start button 4. place");
        }else{
            System.out.println("No start button.");
        }
    }
    
    void clicker(int x, int y){
        for (int i = 0; i < 10; i++)
            robot.mouseMove(x, y);        
        
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }    

    public static void main(String[] args) {
        try{
            new PianoTiles();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
