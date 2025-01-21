/*
    bul·wark
        [ˈbo͝olˌwərk]
    NOUN
    a defensive wall.
*/

import java.util.*;
import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Color;
import java.awt.Rectangle;

public class Bulwark extends Wall
{
    
    private ShapeIcon bulwark_icon = new ShapeIcon(new Rectangle(1, 1), Color.gray);
    private Bulwark[] full_wall = new Bulwark[2];
    
    public Bulwark(City city, int st, int ave) {
        super(city, st, ave, Direction.SOUTH);
        this.setIcon(Icons.invis);
        init_wall(st, ave);
    }
    
    public Bulwark(int st, int ave) { super(Main.outer_space, st, ave, Direction.SOUTH); }
    
    private void init_wall(int st, int ave) {
        //Each Bulwark is composed of a left and a right half.
        full_wall[0] = new Bulwark(st, ave);
        full_wall[0].setIcon(Icons.bulwark_left);
        
        full_wall[1] = new Bulwark(st, ave+1);
        full_wall[1].setIcon(Icons.bulwark_right);
    }
    
    public void set_all_icons(Icon icon) { full_wall[0].setIcon(icon); full_wall[1].setIcon(icon); }
}