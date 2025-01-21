import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.geom.GeneralPath;

public class Bullet extends Thing
{
    private Player player;
    private int player_x;
    private int time_between_frames = 40;
    
    private ShapeIcon bullet_icon = new ShapeIcon(
            new Rectangle2D.Double(0.45, 0.0, 0.1, 1.0),
            new Color(244, 255, 41));
    private ShapeIcon invis_icon  = new ShapeIcon(
            new Rectangle(1, 1), new Color(0, 0, 0, 0) );
    private ShapeIcon dead_icon   = new ShapeIcon(
            new Rectangle(1, 1), Color.red);
    
    Bullet[] frames = new Bullet[15];
    
    public Bullet(Player player_arg) {
        super(Main.outer_space, player_arg.getStreet() - 1, player_arg.getAvenue(), Direction.NORTH);
        this.setIcon(invis_icon);
        player = player_arg;
        player_x = player.getAvenue();
        switch (player_x) {
            case 2, 3: case 9, 10: case 16, 17: case 23, 24:
                smash_into_bulwark(); break;
            default:
                create_beam(); travel(); break;
        }
        frames[0].setIcon(invis_icon);
    }
    
    protected Bullet(Alien alien_arg) {
        super(Main.outer_space, alien_arg.getStreet() + 1, alien_arg.getAvenue(), Direction.NORTH);
    }
    
    protected Bullet(int st, int av) {
        super(Main.outer_space, st, av, Direction.NORTH);
        this.setIcon(invis_icon);
    }
    
    protected Bullet(int st, int av, Direction d) {
        super(Main.outer_space, st, av, d);
        this.setIcon(invis_icon);
    }
    
    private void create_beam() {
        for (int i = 0; i < 15; i++) {
            frames[i] = new Bullet(13 - i, player_x);
            //frames[i].setIcon(invis_icon);
        }
    }
    
    private void travel() {
        //asynchronous lambda code from:
            //https://stackoverflow.com/questions/1842734/how-to-asynchronously-call-a-method-in-java
        new Thread(() -> {
            frames[0].setIcon(bullet_icon);
            Main.pause(time_between_frames);
            //Go through the bullets, changing their icons, to mimic motion. Nothing actually moves here.
            for (int i = 1; i <= 8; i++) {
                frames[i].setIcon(bullet_icon);
                frames[i-1].setIcon(invis_icon);
                frames[i-1] = null; //Delete the last frame so that we're not hogging too much memory.
                Main.pause(time_between_frames);
            }
            
            boolean is_on_alien = false;
            
            for (int j = 0; j < 9; j++) {
                //Checks every alien in row 1 (the bottom row) of Main.aliens to see if their x-position matches the Bullet's.
                //An array with x-positions is helpful since the Aliens are constantly moving.
                //The Alien also has to not be null (i.e. not dead).
                if (player_x == Main.aliens_poss[1][j] && Main.aliens[1][j] != null) {
                    frames[8].setIcon(invis_icon);
                    frames[8] = null;
                    is_on_alien = true;
                    Main.aliens[1][j].die(); //kill the alien!!
                    break;
                }
            }
            if (!is_on_alien) {
                //If the Bullet is not at the same x as any alien in row 1...
                frames[9].setIcon(bullet_icon);
                frames[8].setIcon(invis_icon);
                frames[8] = null;
                is_on_alien = false;
                Main.pause(time_between_frames);       
                for (int j = 0; j < 9; j++) {
                    //...check if it is for row 0.
                    if (player_x == Main.aliens_poss[0][j] && Main.aliens[0][j] != null) {
                        //same as before
                        frames[9].setIcon(invis_icon);
                        frames[9] = null;
                        is_on_alien = true;
                        Main.aliens[0][j].die();
                        break;
                    }
                }
                if (!is_on_alien) {
                    //If there is still no match, then the Bullet has completely missed.
                    //Therefore, keep going with the rest of the frames, until the end of the screen.
                    for (int i = 10; i <= 14; i++) {
                        frames[i].setIcon(bullet_icon);
                        frames[i-1].setIcon(invis_icon);
                        frames[i-1] = null;
                        Main.pause(time_between_frames);
                    }
                    frames[14].setIcon(invis_icon);
                }
            }
            
        }).start();
        
    }
    
    private void smash_into_bulwark() {
        //If the player tries to fire from behind a Bulwark. It won't do anything, bud.
        frames[0] = new Bullet(13, player_x, Direction.SOUTH);
        new Thread(() -> {
            frames[0].setIcon(Icons.explosion);
            Main.pause(200);
            frames[0].setIcon(invis_icon);
        }).start();
    }
}