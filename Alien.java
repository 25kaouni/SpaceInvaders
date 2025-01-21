import java.util.Random;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.GeneralPath;

public class Alien extends RobotSE
{
    private Random numGen = new Random();
    private AnimatedIcon alien_anim = new AnimatedIcon(this, new Icon[] { Icons.alien1, Icons.alien2 }, 1000);
    private Icon invis = new ShapeIcon( new Rectangle2D.Double( 0.0, 0.0, 1.0, 1.0), new Color(0, 0, 0, 0), 1);
    
    private int row, index;
    
    public Alien(int st, int av, int row, int index) {
        super(Main.outer_space, st, av, Direction.SOUTH);
        this.row = row;
        this.index = index;
        this.setIcon(alien_anim);
        this.alien_anim.start();
        this.setSpeed(100);
    }
    
    public void shoot() {
        AlienBullet bullet = new AlienBullet(this, row);
    }
    
    public void die() {
        new Thread(() -> {
            this.setIcon(Icons.alien_dead);
            try { Thread.sleep(400); } catch (InterruptedException ie) {}
            this.setIcon(invis);
            if (Main.aliens[row][index] != null) { Main.delete_alien(row, index); }
        }).start();
    }
    
    public void move_over(boolean to_the_left) {
        if (to_the_left) {
            turnRight();
            move(1);
            turnLeft();
            Main.aliens_poss[row][index] -= 1;
        }
        else {
            turnLeft();
            move(1);
            turnRight();
            Main.aliens_poss[row][index] += 1;
        }
    }
    
    public void get_moving(int time_to_wait) {
        
        new Thread(() -> {
            do {
                Main.pause(time_to_wait);
                this.move_over(true);
                
                for (int j = 0; j < 2; j++) {
                    Main.pause(time_to_wait);
                    this.move_over(false);
                }
                
                Main.pause(time_to_wait);
                this.move_over(true);
            } while (Main.is_game_still_going);
        }).start();
    }
    
}
