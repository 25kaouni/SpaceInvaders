/*
   All icons made by hand.
   Unfortunately.
 */

import becker.robots.*;
import becker.robots.icons.*;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.geom.GeneralPath;

public class Icons {
    public static Icon invis = new ShapeIcon( new Rectangle2D.Double( 0.0, 0.0, 1.0, 1.0), new Color(0, 0, 0, 0), 1);
    
                                                                //ALIEN
    static GeneralPath path1, path2, path3, path4;
    
    static {
        path1 = new GeneralPath();
        //base white rectangle
        path1.moveTo(3f/16, 5f/16);
        path1.lineTo(14f/16, 5f/16);
        path1.lineTo(14f/16, 13f/16);
        path1.lineTo(3f/16, 13f/16);
        
        path1.closePath();
        
        path2 = new GeneralPath();
        //top middle
        path2.moveTo(6f/16, 13f/16);
        path2.lineTo(11f/16, 13f/16);
        path2.lineTo(11f/16, 12f/16);
        path2.lineTo(10f/16, 12f/16);
        path2.lineTo(10f/16, 11f/16);
        path2.lineTo(7f/16, 11f/16);
        path2.lineTo(7f/16, 12f/16);
        path2.lineTo(6f/16, 12f/16);
        path2.closePath();
        
                //left eye
        path2.moveTo(6f/16, 9f/16);
        path2.lineTo(6f/16, 10f/16);
        path2.lineTo(7f/16, 10f/16);
        path2.lineTo(7f/16, 9f/16);
        path2.closePath();
        
        //right eye
        path2.moveTo(10f/16, 9f/16);
        path2.lineTo(10f/16, 10f/16);
        path2.lineTo(11f/16, 10f/16);
        path2.lineTo(11f/16, 9f/16);
        path2.closePath();
        
        path3 = new GeneralPath();
        //top left
        path3.moveTo(3f/16, 9f/16);
        path3.lineTo(3f/16, 13f/16);
        path3.lineTo(5f/16, 13f/16);
        path3.lineTo(5f/16, 12f/16);
        path3.lineTo(6f/16, 12f/16);
        path3.lineTo(6f/16, 11f/16);
        path3.lineTo(5f/16, 11f/16);
        path3.lineTo(5f/16, 10f/16);
        path3.lineTo(4f/16, 10f/16);
        path3.lineTo(4f/16, 9f/16);
        path3.closePath();
        
        //top right
        path3.moveTo(14f/16, 9f/16);
        path3.lineTo(14f/16, 13f/16);
        path3.lineTo(12f/16, 13f/16);
        path3.lineTo(12f/16, 12f/16);
        path3.lineTo(11f/16, 12f/16);
        path3.lineTo(11f/16, 11f/16);
        path3.lineTo(12f/16, 11f/16);
        path3.lineTo(12f/16, 10f/16);
        path3.lineTo(13f/16, 10f/16);
        path3.lineTo(13f/16, 9f/16);
        path3.closePath();
    
        //left between leg and body
        path3.moveTo(4f/16, 6f/16);
        path3.lineTo(4f/16, 8f/16);
        path3.lineTo(5f/16, 8f/16);
        path3.lineTo(5f/16, 6f/16);
        path3.lineTo(6f/16, 6f/16);
        path3.lineTo(6f/16, 5f/16);
        path3.lineTo(3f/16, 5f/16);
        path3.lineTo(3f/16, 6f/16);
        path3.closePath();
        
        //right between leg and body
        path3.moveTo(12f/16, 6f/16);
        path3.lineTo(12f/16, 8f/16);
        path3.lineTo(13f/16, 8f/16);
        path3.lineTo(13f/16, 6f/16);
        path3.lineTo(14f/16, 6f/16);
        path3.lineTo(14f/16, 5f/16);
        path3.lineTo(11f/16, 5f/16);
        path3.lineTo(11f/16, 6f/16);
        path3.closePath();
        
        //bottom between legs
        path3.moveTo(6f/16, 6f/16);
        path3.lineTo(6f/16, 7f/16);
        path3.lineTo(11f/16, 7f/16);
        path3.lineTo(11f/16, 6f/16);
        path3.lineTo(9f/16, 6f/16);
        path3.lineTo(9f/16, 5f/16);
        path3.lineTo(8f/16, 5f/16);
        path3.lineTo(8f/16, 6f/16);
        path3.closePath();

        path4 = new GeneralPath();
        //top left
        path4.moveTo(3f/16, 13f/16);
        path4.lineTo(5f/16, 13f/16);
        path4.lineTo(5f/16, 12f/16);
        path4.lineTo(6f/16, 12f/16);
        path4.lineTo(6f/16, 11f/16);
        path4.lineTo(5f/16, 11f/16);
        path4.lineTo(5f/16, 10f/16);
        path4.lineTo(4f/16, 10f/16);
        path4.lineTo(4f/16, 12f/16);
        path4.lineTo(3f/16, 12f/16);
        path4.closePath();
        
        //top right
        path4.moveTo(14f/16, 13f/16);
        path4.lineTo(12f/16, 13f/16);
        path4.lineTo(12f/16, 12f/16);
        path4.lineTo(11f/16, 12f/16);
        path4.lineTo(11f/16, 11f/16);
        path4.lineTo(12f/16, 11f/16);
        path4.lineTo(12f/16, 10f/16);
        path4.lineTo(13f/16, 10f/16);
        path4.lineTo(13f/16, 12f/16);
        path4.lineTo(14f/16, 12f/16);
        path4.closePath();
        
        //bottom left
        path4.moveTo(3f/16, 5f/16);
        path4.lineTo(3f/16, 8f/16);
        path4.lineTo(4f/16, 8f/16);
        path4.lineTo(4f/16, 7f/16);
        path4.lineTo(5f/16, 7f/16);
        path4.lineTo(5f/16, 6f/16);
        path4.lineTo(4f/16, 6f/16);
        path4.lineTo(4f/16, 5f/16);
        
        path4.closePath();
        
        //bottom right
        path4.moveTo(14f/16, 5f/16);
        path4.lineTo(14f/16, 8f/16);
        path4.lineTo(13f/16, 8f/16);
        path4.lineTo(13f/16, 7f/16);
        path4.lineTo(12f/16, 7f/16);
        path4.lineTo(12f/16, 6f/16);
        path4.lineTo(13f/16, 6f/16);
        path4.lineTo(13f/16, 5f/16);
        
        //bottom middle
        path4.moveTo(7f/16, 7f/16);
        path4.lineTo(11f/16, 7f/16);
        path4.lineTo(11f/16, 6f/16);
        path4.lineTo(12f/16, 6f/16);
        path4.lineTo(12f/16, 5f/16);
        path4.lineTo(5f/16, 5f/16);
        path4.lineTo(5f/16, 6f/16);
        path4.lineTo(6f/16, 6f/16);
        path4.lineTo(6f/16, 7f/16);
        path4.closePath();
    }
    
    static Icon bg = new ShapeIcon(path1, Color.white, 1),
                layer_1 = new ShapeIcon(path2, Color.black, 1),
                layer_2 = new ShapeIcon(path3, Color.black, 1),
                layer_3 = new ShapeIcon(path4, Color.black, 1);
        
    public static Icon alien1 = new CompositeIcon( new Icon[]
        { bg, layer_1, layer_2} );
    
    public static Icon alien2 = new CompositeIcon( new Icon[]
        { bg, layer_1, layer_3 } );
    
                                                                    //PLAYER
    private static GeneralPath shape;
    
    static {
        shape = new GeneralPath();
        shape.moveTo(0f/16, 5f/16);
        shape.lineTo(0f/16, 8f/16);
        shape.lineTo(1f/16, 8f/16);
        shape.lineTo(1f/16, 9f/16);
        shape.lineTo(7f/16, 9f/16);
        shape.lineTo(7f/16, 11f/16);
        shape.lineTo(9f/16, 11f/16);
        shape.lineTo(9f/16, 9f/16);
        shape.lineTo(15f/16, 9f/16);
        shape.lineTo(15f/16, 8f/16);
        shape.lineTo(16f/16, 8f/16); 
        shape.lineTo(16f/16, 5f/16);
        
        shape.closePath();
    }
    
    public static Icon player = new ShapeIcon(shape, new Color(0, 255, 20), 1);
    
                                                                    //BULWARK
    private static GeneralPath bpath1, bpath2, bpath3;
    
    static {
        bpath1 = new GeneralPath();
        bpath1.moveTo(0, 0);
        bpath1.lineTo(0f/16, 13f/16);
        bpath1.lineTo(1f/16, 13f/16);
        bpath1.lineTo(1f/16, 14f/16);
        bpath1.lineTo(2f/16, 14f/16);
        bpath1.lineTo(2f/16, 15f/16);
        bpath1.lineTo(3f/16, 15f/16);
        bpath1.lineTo(3f/16, 16f/16);
        bpath1.lineTo(16f/16, 16f/16);
        bpath1.lineTo(16f/16, 9f/16);
        bpath1.lineTo(8f/16, 9f/16);
        bpath1.lineTo(8f/16, 8f/16);
        bpath1.lineTo(7f/16, 8f/16);
        bpath1.lineTo(7f/16, 7f/16);
        bpath1.lineTo(6f/16, 7f/16);
        bpath1.lineTo(6f/16, 0f/16);
        bpath1.closePath();
        
        bpath2 = new GeneralPath();
        bpath2.moveTo(16f/16, 0f/16);
        bpath2.lineTo(16f/16, 13f/16);
        bpath2.lineTo(15f/16, 13f/16);
        bpath2.lineTo(15f/16, 14f/16);
        bpath2.lineTo(14f/16, 14f/16);
        bpath2.lineTo(14f/16, 15f/16);
        bpath2.lineTo(13f/16, 15f/16);
        bpath2.lineTo(13f/16, 16f/16);
        bpath2.lineTo(0f/16, 16f/16);
        bpath2.lineTo(0f/16, 9f/16);
        bpath2.lineTo(8f/16, 9f/16);
        bpath2.lineTo(8f/16, 8f/16);
        bpath2.lineTo(9f/16, 8f/16);
        bpath2.lineTo(9f/16, 7f/16);
        bpath2.lineTo(10f/16, 7f/16);
        bpath2.lineTo(10f/16, 0f/16);
        bpath2.closePath();
        
        bpath3 = new GeneralPath();
        bpath3.moveTo(0f/16, 16f/16);
        bpath3.lineTo(16f/16, 16f/16);
        bpath3.lineTo(16f/16, 9f/16);
        bpath3.lineTo(0f/16, 9f/16);
        bpath3.closePath();
    }
    
    public static Icon  bulwark_left = new ShapeIcon(bpath2, new Color(51, 255, 0), 1),
                        bulwark_middle = new ShapeIcon(bpath3, new Color(51, 255, 0), 1),
                        bulwark_right = new ShapeIcon(bpath1, new Color(51, 255, 0), 1);
                        
                                                                    //BULLET
    private static GeneralPath bupath;
    
    static {
        bupath = new GeneralPath();
        bupath.moveTo(0f/16, 8f/16); //top left
        bupath.lineTo(5f/16, 6f/16); //between left spikes top
        bupath.lineTo(2f/16, 2f/16); //left spike
        bupath.lineTo(7f/16, 4f/16); // middle left
        bupath.lineTo(8f/16, 0f/16); // middle spike
        bupath.lineTo(9f/16, 4f/16); // middle right
        bupath.lineTo(14f/16, 2f/16); //right spike
        bupath.lineTo(11f/16, 6f/16); //beween right spikes top
        bupath.lineTo(16f/16, 8f/16); //top right
        
        bupath.lineTo(11f/16, 10f/16); //beween right spikes top
        bupath.lineTo(14f/16, 14f/16); //right spike
        bupath.lineTo(9f/16, 12f/16); // middle right
        bupath.lineTo(8f/16, 16f/16); // middle spike
        bupath.lineTo(7f/16, 12f/16); // middle left
        bupath.lineTo(2f/16, 14f/16); //left spike
        bupath.lineTo(5f/16, 10f/16); //between left spikes top
        bupath.closePath();
    }
    
    public static Icon explosion = new ShapeIcon(bupath, new Color(255, 30, 30), 1);
    
                                                                    //DEAD ALIEN
    private static GeneralPath ex;
    
    static {
        ex = new GeneralPath();
        
        ex.moveTo(1f/16, 7f/16);
        ex.lineTo(1f/16, 8f/16);
        ex.lineTo(3f/16, 8f/16);
        ex.lineTo(3f/16, 7f/16);
        ex.closePath();
        
        ex.moveTo(12f/16, 7f/16);
        ex.lineTo(12f/16, 8f/16);
        ex.lineTo(14f/16, 8f/16);
        ex.lineTo(14f/16, 7f/16);
        ex.closePath();
        
        ex.moveTo(2f/16, 13f/16);
        ex.lineTo(3f/16, 13f/16);
        ex.lineTo(3f/16, 12f/16);
        ex.lineTo(4f/16, 12f/16);
        ex.lineTo(4f/16, 11f/16);
        ex.lineTo(5f/16, 11f/16);
        ex.lineTo(5f/16, 10f/16);
        ex.lineTo(4f/16, 10f/16);
        ex.lineTo(4f/16, 11f/16);
        ex.lineTo(3f/16, 11f/16);
        ex.lineTo(3f/16, 12f/16);
        ex.lineTo(2f/16, 12f/16);
        ex.closePath();
        
        ex.moveTo(10f/16, 6f/16);
        ex.lineTo(11f/16, 6f/16);
        ex.lineTo(11f/16, 5f/16);
        ex.lineTo(12f/16, 5f/16);
        ex.lineTo(12f/16, 4f/16);
        ex.lineTo(13f/16, 4f/16);
        ex.lineTo(13f/16, 3f/16);
        ex.lineTo(12f/16, 3f/16);
        ex.lineTo(12f/16, 4f/16);
        ex.lineTo(11f/16, 4f/16);
        ex.lineTo(11f/16, 5f/16);
        ex.lineTo(10f/16, 5f/16);
        ex.closePath();
        
        ex.moveTo(8f/16, 4f/16);
        ex.lineTo(9f/16, 4f/16);
        ex.lineTo(9f/16, 1f/16);
        ex.lineTo(8f/16, 1f/16);
        ex.closePath();
        
        ex.moveTo(6f/16, 14f/16);
        ex.lineTo(7f/16, 14f/16);
        ex.lineTo(7f/16, 11f/16);
        ex.lineTo(6f/16, 11f/16);
        ex.closePath();
        
        ex.moveTo(4f/16, 2f/16);
        ex.lineTo(4f/16, 4f/16);
        ex.lineTo(5f/16, 4f/16);
        ex.lineTo(5f/16, 5f/16);
        ex.lineTo(6f/16, 5f/16);
        ex.lineTo(6f/16, 4f/16);
        ex.lineTo(5f/16, 4f/16);
        ex.lineTo(5f/16, 2f/16);
        ex.closePath();
        
        ex.moveTo(11f/16, 13f/16);
        ex.lineTo(11f/16, 11f/16);
        ex.lineTo(10f/16, 11f/16);
        ex.lineTo(10f/16, 10f/16);
        ex.lineTo(9f/16, 10f/16);
        ex.lineTo(9f/16, 11f/16);
        ex.lineTo(10f/16, 11f/16);
        ex.lineTo(10f/16, 13f/16);
        ex.closePath();
        
        ex.moveTo(2f/16, 4f/16);
        ex.lineTo(2f/16, 5f/16);
        ex.lineTo(3f/16, 5f/16);
        ex.lineTo(3f/16, 6f/16);
        ex.lineTo(4f/16, 6f/16);
        ex.lineTo(4f/16, 5f/16);
        ex.lineTo(3f/16, 5f/16);
        ex.lineTo(3f/16, 4f/16);
        ex.closePath();
        
        ex.moveTo(12f/16, 9f/16);
        ex.lineTo(12f/16, 10f/16);
        ex.lineTo(13f/16, 10f/16);
        ex.lineTo(13f/16, 11f/16);
        ex.lineTo(14f/16, 11f/16);
        ex.lineTo(14f/16, 10f/16);
        ex.lineTo(13f/16, 10f/16);
        ex.lineTo(13f/16, 9f/16);
        ex.closePath();
    }
    
    public static Icon alien_dead = new ShapeIcon(ex, Color.white, 1);
}