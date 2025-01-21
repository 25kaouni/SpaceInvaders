import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.GeneralPath;

public class Player extends RobotRC
{
    public static int x;
    
    //private ShapeIcon player_icon = new ShapeIcon(new Rectangle(1, 1), Color.white);
    //private Icon test_icon = new ShapeIcon(new Rectangle2D.Double(0.2, 0.2, 1.0, 1.0), Color.blue);
    
    public Player() {
        super(Main.outer_space, 14, 13, Direction.SOUTH);
        this.x = 13;
        this.setIcon(Icons.player);
    }
    
    public Player(int aStreet, int anAvenue) {
        super(Main.outer_space, aStreet, anAvenue, Direction.SOUTH);
        this.x = anAvenue;
        this.setIcon(Icons.player);
        this.setSpeed(150);
    }
    
    private void turnRight() { for (int i = 0; i < 3; i++) { turnLeft(); } }
    
    private void turnAround() { turnLeft(); turnLeft(); }
    
    // @Overload
    private void move(int distance) { for (int i = 0; i < distance; i++) { move(); } }
    
    // @Override
    protected void keyTyped(char key) {
        switch (key) {
            case 'd': case 'D':
                if (this.getAvenue() != 26) {
                    turnLeft();
                    move(1);
                    turnRight();
                    x += 1;
                } break;
                
            case 'a': case 'A':
                if (this.getAvenue() != 0) {
                    turnRight();
                    move(1);
                    turnLeft();
                    x -= 1;
                } break;
            
            case ' ': case 'w': case 'W':
                shoot(); break;
        }
    }
    
    public static void die(Player player) {
        player.setIcon(Icons.explosion);
        Main.pause(2000);
        player.setTransparency(1);
        
        //set background to dark red
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 32; j++) {
                Main.black_things[i][j].change_colour_to(new Color(50, 0, 0));
            }
        }
        Main.pause(250);
        //set bg to slightly lighter red
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 32; j++) {
                Main.black_things[i][j].change_colour_to(new Color(100, 0, 0));
            }
        }
        Main.pause(400);
        //set all Aliens to red
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                if (Main.aliens[i][j] != null) {
                    Main.aliens[i][j].setIcon(new ShapeIcon(new Rectangle2D.Double(0, 0, 1, 1), new Color(150, 0, 0)));
                }
            }
        }
        //set bg to red
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 32; j++) {
                Main.black_things[i][j].change_colour_to(new Color(150, 0, 0));
            }
        }
        //set all Bulwarks to red
        for (int i = 0; i < 4; i++) {
            Main.bulwarks[i].set_all_icons(new ShapeIcon(new Rectangle2D.Double(0, 0, 1, 1), new Color(150, 0, 0)));
        }
        //label all robots
        Main.ending_robots = new Robot[9];
        String[] labels = new String[] {"G", "A", "M", "E", "", "O", "V", "E", "R"};
        for (int i = 0; i < 9; i++) {
            Main.ending_robots[i] = new Robot(Main.outer_space, 7, 9+i, Direction.NORTH);
            Main.ending_robots[i].setIcon( new ShapeIcon( new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), Color.white ) );
            Main.ending_robots[i].setLabel(labels[i]);
        }
    }
    
    private void shoot() { Bullet bullet = new Bullet(this); }
}