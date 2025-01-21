import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.geom.GeneralPath;

public class AlienBullet extends Bullet
{
    private Alien alien;
    private int x, y, row;
    private int time_between_frames = 100;
    
    private ShapeIcon bullet_icon = new ShapeIcon(
            new Rectangle2D.Double(0.45, 0.3, 0.1, 0.4),
            new Color(255, 255, 141));
    private ShapeIcon invis_icon  = new ShapeIcon(
            new Rectangle(1, 1), new Color(0, 0, 0, 0) );
    private ShapeIcon dead_icon   = new ShapeIcon(
            new Rectangle(1, 1), Color.red);
    
    private AlienBullet[] frames = new AlienBullet[12];
    

    public AlienBullet(Alien alien_arg, int row) {
        super(alien_arg);
        alien = alien_arg;
        x = alien.getAvenue();
        y = alien.getStreet();
        this.row = row;
        this.setIcon(invis_icon);
        create_beam(); travel();
        
    }
    
    private AlienBullet(int st, int av) {
        super(st, av);
        this.setIcon(invis_icon);
    }
    
    private AlienBullet(int st, int av, Direction d) {
        super(st, av, d);
        this.setIcon(invis_icon);
    }
    
    private void create_beam() {
        //Initializes all frames of the AlienBullet, the first being at y = 4.
        
        for (int i = 0; i < 12; i++) {
            if (i + 4 == 12 && (x - 2) % 7 < 2) { break; }
            frames[i] = new AlienBullet(i + 4, x);
            frames[i].setIcon(invis_icon);
        }
        //If y equals 5 (i.e., if the Alien is in the bottom row), delete the first two frames.
        //This is to avoid having two different sets of methods for the two different rows of Aliens.
        //This way, I can just detect if the first frame is null; if it is, skip to the third.
        if (y == 5) {
            frames[0].setIcon(invis_icon); frames[0] = null;
            frames[1].setIcon(invis_icon); frames[1] = null;
        }
    }
    
    private void travel() {
        //asynchronous lambda code from:
            //https://stackoverflow.com/questions/1842734/how-to-asynchronously-call-a-method-in-java
        new Thread(() -> {
            
            //if the Alien is in the top row
            if (frames[0] != null) {
                frames[0].setIcon(bullet_icon);
                Main.pause(time_between_frames);
                frames[1].setIcon(bullet_icon);
                frames[0].setIcon(invis_icon);
                frames[0] = null;
                Main.pause(time_between_frames);
                frames[2].setIcon(bullet_icon);
                frames[1].setIcon(invis_icon);
                frames[1] = null;
                Main.pause(time_between_frames);
            }
            
            //"travel" the AlienBullet
            for (int i = 3; i <= 7; i++) {
                frames[i].setIcon(bullet_icon);
                frames[i-1].setIcon(invis_icon);
                frames[i-1] = null;
                Main.pause(time_between_frames);
            }
            
            //if the AlienBullet is at a Bulwark, explode
            if ( 0 <= ( (x-2) % 7 ) && (x-2) % 7 < 2 ) { smash_into_bulwark(); return;}
            
            //continue travelling until the Player
            frames[7].setIcon(invis_icon);
            frames[7] = null;
            if (frames[8] == null || frames[9] == null) { return; }
            frames[8].setIcon(bullet_icon);
            Main.pause(time_between_frames);            
            frames[9].setIcon(bullet_icon);
            frames[8].setIcon(invis_icon);
            frames[8] = null;
            Main.pause(time_between_frames);
            frames[10].setIcon(bullet_icon);
            frames[9].setIcon(invis_icon);
            frames[9] = null;
            Main.pause(time_between_frames);
            
            //Kill the Player if it makes contact.
            if (x == Player.x) {
                frames[10].setIcon(invis_icon);
                Player.die(Main.player);
                Main.is_game_still_going = false;
                return;
            }
            
            //If it missed the Player, keep going until the end.
            frames[11].setIcon(bullet_icon);
            frames[10].setIcon(invis_icon);
            frames[10] = null;
            Main.pause(time_between_frames);
            frames[11].setIcon(invis_icon);
            frames[11] = null;
            frames = null;
            
            
        }).start();
               
    }
    
    
    private void smash_into_bulwark() {
        new Thread(() -> {
            frames[7].setIcon(Icons.explosion);
            Main.pause(200);
            frames[7].setIcon(invis_icon);
        }).start();
    }
}
