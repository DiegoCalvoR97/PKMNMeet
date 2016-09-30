package pkmnmeet;

import java.awt.Rectangle;

/**
 *
 * @author Diego Calvo
 */
public class centroPokemon {
    public int x, y, w, h ;

    public centroPokemon(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    public static Rectangle Booster(){
        return new Rectangle(54, 75, 160, 145);
    }
    
}
