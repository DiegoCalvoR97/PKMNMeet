package pkmnmeet;

/**
 *
 * @author Diego Calvo
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;

public class Entrenador {

    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int LEFT = 3;
    public static final int DOWN = 2;
    public static final int UPR = 4;
    public static final int RIGHTR = 5;
    public static final int LEFTR = 6;
    public static final int DOWNR = 7;
    public static final int NONE = -1;
    public static final int NONEB = -2;
    public static final int UPB = 8;
    public static final int DOWNB = 10;
    public static final int RIGHTB = 9;
    public static final int LEFTB = 11;

    Animaciones[] animations;
    public int x;
    public int y;
    public static boolean b = false;
    int vx;
    int vy;
    int currentAnimation;
    int currentDirection;
    int probability;
    int cont = 0;
    ImageIcon fondoBatalla;
    Color pxl;

    Random rnd = new Random();
    String path;

    public Entrenador(int x, int y, int vx, int vy, String path) {
        this.path = path;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.currentDirection = -1;
        animations = new Animaciones[12];
    }

    public void Loader(String[] names, boolean bike) throws Exception {

        if (bike == false) {
            for (int j = 0; j < 12; j++) {
                String name = names[j];
                animations[j] = new Animaciones();

                for (int i = 1; i < 4; i++) {

                    animations[j].addScene(new ImageIcon(getClass().getResource(path + "//" + name + i + ".png")).getImage(), 100);

                }

            }
        }
    }

    public void moveUp(long time, boolean running, boolean bike) {

        if (y > 0) {

            if (running == true) {
                y -= 4 * vy;
                while(colision()){
                    y += 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.UPR;
                animations[Entrenador.UPR].update(time);
                probability = rnd.nextInt(100);

                if (probability > 90 && probability <= 95) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            } else if (running == false && bike == false) {
                y -= 2 * vy;
                while(colision()){
                    y += 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.UP;
                animations[Entrenador.UP].update(time);
                probability = rnd.nextInt(100);
                if (probability > 95) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            } else if (bike == true) {
                y -= 6 * vy;
                while(colision()){
                    y += 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.UPB;
                animations[Entrenador.UPB].update(time);
                probability = rnd.nextInt(100);
                if (probability > 85 && probability <= 90) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            }

        }
    }

    public void moveDown(long time, boolean running, boolean bike) {

        if (y < 600 - 50) {

            if (running == true) {
                y += 4 * vy;
                while(colision()){
                    y -= 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.LEFTR;
                animations[Entrenador.LEFTR].update(time);
                probability = rnd.nextInt(100);
                if (probability > 90 && probability <= 95) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            } else if (running == false && bike == false) {
                y += 2 * vy;
                while(colision()){
                    y -= 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.DOWN;
                animations[Entrenador.DOWN].update(time);
                probability = rnd.nextInt(100);
                if (probability > 95) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            } else if (bike == true) {
                y += 6 * vy;
                while(colision()){
                    y -= 1;
                }
                getBounds(x,y);
                currentAnimation = Entrenador.DOWNB;
                animations[Entrenador.DOWNB].update(time);
                probability = rnd.nextInt(100);
                if (probability > 85 && probability <= 90) {
                    cont++;
                    if (cont == 10) {
                        b = true;
                        cont = 0;

                    }
                }

            }

        }

    }

    public void moveRight(long time, boolean running, boolean bike) {
        if (x < 800 - 30) {

            if (x < 800 - vx) {

                if (running == true) {
                    x += 4 * vx;
                    while(colision()){
                        x -= 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.RIGHTR;
                    animations[Entrenador.RIGHTR].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 90 && probability <= 95) {
                        if (cont == 10) {
                            cont++;
                            b = true;
                            cont = 0;

                        }
                    }

                } else if (running == false && bike == false) {
                    x += 2 * vx;
                    while(colision()){
                        x -= 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.RIGHT;
                    animations[Entrenador.RIGHT].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 95) {
                        cont++;
                        if (cont == 10) {
                            b = true;
                            cont = 0;

                        }
                    }

                } else if (bike == true) {
                    x += 6 * vx;
                    while(colision()){
                        x -= 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.RIGHTB;
                    animations[Entrenador.RIGHTB].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 85 && probability <= 90) {
                        cont++;
                        if (cont == 10) {
                            b = true;
                            cont = 0;

                        }
                    }

                }

            }
        }

    }

    public void moveLeft(long time, boolean running, boolean bike) {

        if (x > -5) {
            if (x > -800 - vx) {

                if (running == true && bike == false) {
                    x -= 4 * vx;
                    while(colision()){
                        x += 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.DOWNR;
                    animations[Entrenador.DOWNR].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 90 && probability <= 95) {
                        cont++;
                        if (cont == 10) {
                            b = true;
                            cont = 0;

                        }
                    }

                } else if (running == false && bike == false) {
                    x -= 2 * vx;
                    while(colision()){
                        x += 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.LEFT;
                    animations[Entrenador.LEFT].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 95) {
                        cont++;
                        if (cont == 10) {
                            b = true;
                            cont = 0;

                        }
                    }

                } else if (bike == true) {
                    x -= 6 * vx;
                    while(colision()){
                        x += 1;
                    }
                    getBounds(x,y);
                    currentAnimation = Entrenador.LEFTB;
                    animations[Entrenador.LEFTB].update(time);
                    probability = rnd.nextInt(100);
                    if (probability > 85 && probability <= 90) {
                        cont++;
                        if (cont == 10) {
                            b = true;
                            cont = 0;

                        }
                    }

                }

            }
        }

    }

    public void draw(Graphics g) {
        g.drawImage(animations[currentAnimation].getImage(), x, y, null);
    }
    
    private Boolean colision(){
        return getBounds(x,y).intersects(centroPokemon.Booster());
    }

    public Rectangle getBounds(int x, int y) {
        return new Rectangle(x, y, 20, 27);
    }
}
