/*
    This one's a bit useless.
    I originally created it in hopes of working around getIntersection()'s protected-ness.
    I found an easier work-around but never bothered to delete this.
*/

import java.util.Random;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.Rectangle;

public class BackgroundTile extends Thing {
    private ShapeIcon bg_icon = new ShapeIcon(new Rectangle(1, 1), new Color(0,0,0));
    private int st, av;
    
    public BackgroundTile(int st, int av) {
        super(Main.outer_space, st, av);
        this.st = st; this.av = av;
        this.setIcon(bg_icon);
    }
    
    public void change_colour_to(Color new_col) {
        this.setIcon(new ShapeIcon(new Rectangle(1, 1), new_col) );
    }
}