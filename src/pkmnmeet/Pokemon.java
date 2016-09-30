package pkmnmeet;

import java.awt.Graphics;

/**
 *
 * @author Diego Calvo
 */
public class Pokemon {

    int x, y, ps, atck, defns, nivel;
    String tipo, vulnerabilidad, fortaleza, path;

    public Pokemon(int x, int y, int ps, int atck, int defns, String tipo, String vulnerabilidad, String fortaleza, int nivel, String path) {
        this.x = x;
        this.y = y;
        this.ps = ps;
        this.atck = atck;
        this.defns = defns;
        this.tipo = tipo;
        this.vulnerabilidad = vulnerabilidad;
        this.fortaleza = fortaleza;
        this.nivel = nivel;
        this.path = path;
    }

    void draw(Graphics gc) {
        
    }
    
    

}
