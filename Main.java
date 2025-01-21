/*
    Space Invaders by Nikolas Kaounis
        👨‍💻   (* ^ ω ^) 
        
    Made from Jan 11th–Feb 8th, 2024
    1050 lines of code 😖
*/

import java.util.Random;
import java.util.ArrayList;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Main
{
    public static City outer_space = new City(16, 27);
    public static Random numGen = new Random();
    
    public static Alien[][] aliens = new Alien[2][9];
    public static int[][] aliens_poss = new int[2][9];
    //This ArrayList keeps track of the indices of aliens which are available to shoot (i.e., not dead).
    public static ArrayList<Integer> available_aliens = new ArrayList<Integer>();
    
    public static Player player;
    public static Bulwark[] bulwarks;
    public static boolean is_game_still_going = true;
    
    
    public static void main() {
        set_background();
        player = new Player(14, 13);
        
        //create Bulwarks
        bulwarks = new Bulwark[4];
        for (int i = 0; i < 4; i++) {
            bulwarks[i] = new Bulwark(outer_space, 12, 2 + 7*i);
        }
        
        //add each Aliens twice (two rows)
        for (int i = 0; i < 9; i++) { available_aliens.add(i); available_aliens.add(i);}
        
        //create and position all the Aliens
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                aliens[i][j] = new Alien(2*i+3, 3*j+1, i, j);
                aliens_poss[i][j] = 3*j+1;
            }
        }
        
        //don't want to kill the player immediately, now do we?
        pause(5000);
        
        new Thread(() -> { aliens_start(0); }).start();
        pause(600); //offset the rows a bit
        new Thread(() -> { aliens_start(1); }).start();  
        
    }
    
    //probably could've chosen a better name but oh well
    public static BackgroundTile[][] black_things = new BackgroundTile[20][32];
    
    private static void aliens_start(int row) {
        
        for (int i = 0; i < 9; i++) {
            if (aliens[row][i] != null) { aliens[row][i].get_moving(2000); }
        }
        
        int temp;
        
        while (available_aliens.size() > 0 && is_game_still_going) {
            //Pick a random Alien to shoot.
            temp = numGen.nextInt(available_aliens.size());
            
            //just in case the Alien is dead
            try { aliens[row][available_aliens.get(temp)].shoot(); } catch (NullPointerException e) {}
            pause(2500);
        }
        
        if (is_game_still_going) { end(); } //ends (wins) instead of dying
    }
    
    public static void delete_alien(int row, int index) {
        aliens[row][index] = null;
        available_aliens.remove(available_aliens.indexOf(index));
    }
    
    private static void set_background() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 32; j++) {
                black_things[i][j] = new BackgroundTile(i, j);
            }
        }
    }
    
    public static Robot[] ending_robots;
    
    private static void end() {
        ending_robots = new Robot[8];
        String[] labels = new String[] {"Y", "O", "U", "", "W", "I", "N", "!"};
        for (int i = 0; i < 8; i++) {
            ending_robots[i] = new Robot(outer_space, 7, 10+i, Direction.NORTH);
            ending_robots[i].setIcon( new ShapeIcon( new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), Color.white ) );
            ending_robots[i].setLabel(labels[i]);
        }
        
        for (int h = 0; h < 3; h++) {
            for (int i = 0; i < 20; i++) {
                //background to red
                for (int j = 0; j < 32; j++) {
                    black_things[i][j].change_colour_to(new Color(100, 0, 0));
                }
            }
            for (int i = 0; i < 4; i++) {
                //bulwarks to red
                bulwarks[i].set_all_icons(new ShapeIcon(new Rectangle2D.Double(0, 0, 1, 1), new Color(100, 0, 0)));
            }
            pause(1000);
            for (int i = 0; i < 20; i++) {
                //background to blue
                for (int j = 0; j < 32; j++) {
                    black_things[i][j].change_colour_to(new Color(0, 0, 100));
                }
            }
            for (int i = 0; i < 4; i++) {
                //bulwarks to blue
                bulwarks[i].set_all_icons(new ShapeIcon(new Rectangle2D.Double(0, 0, 1, 1), new Color(0, 0, 100)));
            }
            pause(1000);
        }
    }
    
    private static void death() {
        Robot[] ending_robots = new Robot[8];
        String[] labels = new String[] {"Y", "O", "U", "", "D", "I", "E", "D"};
        for (int i = 0; i < 8; i++) {
            ending_robots[i] = new Robot(outer_space, 7, 10+i, Direction.NORTH);
            ending_robots[i].setIcon(new ShapeIcon(new Rectangle2D.Double(0, 0, 1, 1), new Color(150, 0, 0)));
            ending_robots[i].setLabel(labels[i]);
        }
    }
    
    public static void pause(int m_seconds) { try { Thread.sleep(m_seconds); } catch (InterruptedException e) {} }
}
