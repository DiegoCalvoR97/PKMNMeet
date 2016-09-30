package pkmnmeet;

import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Calvo
 */
public class PKMNMeet extends JFrame {

    public Thread movieLoop;
    public static PKMNMeet v;
    public Canvas c;
    public Entrenador J1;
    public boolean bike = false, running = false, battle = false;
    public ImageIcon fondo, fndbatalla, colisiones, cp, icon;
    public static Image icono;
    public AudioClip sound;
    int sw = 0;

    public PKMNMeet(int w, int h) {

        try {
            c = new Canvas();
            this.setSize(w, h);
            c.setSize(w, h);
            this.add(c);
            this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent ke) {

                }

                @Override
                public void keyPressed(KeyEvent ke) {
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_UP: {
                            J1.currentDirection = Entrenador.UP;
                            break;
                        }
                        case KeyEvent.VK_LEFT: {
                            J1.currentDirection = Entrenador.LEFT;
                            break;
                        }
                        case KeyEvent.VK_RIGHT: {
                            J1.currentDirection = Entrenador.RIGHT;
                            break;
                        }
                        case KeyEvent.VK_DOWN: {
                            J1.currentDirection = Entrenador.DOWN;
                            break;
                        }
                        case KeyEvent.VK_S: {
                            if (bike == false) {

                                running = true;
                            }
                            break;
                        }
                        case KeyEvent.VK_B: {

                            if (bike == true) {
                                bike = false;
                                sound.stop();
                                sound = java.applet.Applet.newAudioClip(getClass().getResource("/soundtracks/Mt Blaze Peak   Pokémon Mystery Dungeon RedBlue Rescue Team.wav"));
                                sound.loop();

                            } else if (bike == false) {
                                bike = true;
                                sound.stop();
                                sound = java.applet.Applet.newAudioClip(getClass().getResource("/soundtracks/Sky Tower   Pokémon Mystery Dungeon RedBlue Rescue Team.wav"));
                                sound.loop();
                            }
                            break;
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent ke) {
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_UP: {
                            J1.currentDirection = Entrenador.NONE;
                            if (battle == true) {
                                System.out.println("Battle");
                            }
                            break;
                        }
                        case KeyEvent.VK_LEFT: {
                            J1.currentDirection = Entrenador.NONE;
                            if (battle == true) {
                                System.out.println("Battle");
                            }
                            break;
                        }
                        case KeyEvent.VK_RIGHT: {
                            J1.currentDirection = Entrenador.NONE;
                            if (battle == true) {
                                System.out.println("Battle");
                            }
                            break;
                        }
                        case KeyEvent.VK_DOWN: {
                            J1.currentDirection = Entrenador.NONE;
                            if (battle == true) {
                                System.out.println("Battle");
                            }
                            break;
                        }
                        case KeyEvent.VK_S: {
                            running = false;
                        }
                    }
                }
            });

            J1 = new Entrenador(400, 300, 1, 1, "spritesEntrenador");
            String[] names = {"arriba", "adelante", "abajo", "atras", "arribac", "adelantec", "abajoc", "atrasc", "arribab", "adelanteb", "abajob", "atrasb"};
            J1.Loader(names, bike);

            sound = java.applet.Applet.newAudioClip(getClass().getResource("/soundtracks/Mt Blaze Peak   Pokémon Mystery Dungeon RedBlue Rescue Team.wav"));
            sound.loop();
            fondo = new ImageIcon(getClass().getResource("/pictures/PASTO.png"));
            cp = new ImageIcon(getClass().getResource("/pictures/CENTRO POKEMON.png"));
            fndbatalla = new ImageIcon(getClass().getResource("/pictures/fondo_batalla.png"));
            icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pictures/Icon.png"));
            icon = new ImageIcon(getClass().getResource("/pictures/Icon.png"));

            movieLoop = new Thread(new Runnable() {
                @Override
                public void run() {
                    c.createBufferStrategy(3);

                    Graphics gc = c.getBufferStrategy().getDrawGraphics();
                    long startTime = System.currentTimeMillis();
                    long currentTime = 0;
                    while (true) {
                        try {
                            currentTime = System.currentTimeMillis() - startTime;
//                            gc.setColor(Color.BLACK);
//                            gc.fillRect(0, 0, getWidth(), c.getHeight());

                            gc.drawImage(fondo.getImage(), 0, 0, 800, 600, null);

                            switch (J1.currentDirection) {
                                case Entrenador.UP: {
                                    J1.moveUp(currentTime, running, bike);

                                    if (Entrenador.b == true) {
                                        System.out.println("Batalla");
                                        
                                    }
                                    break;

                                }
                                case Entrenador.LEFT: {
                                    J1.moveLeft(currentTime, running, bike);

                                    if (Entrenador.b == true) {
                                        System.out.println("Batalla");
                                        
                                    }
                                    break;
                                }
                                case Entrenador.RIGHT: {
                                    J1.moveRight(currentTime, running, bike);

                                    if (Entrenador.b == true) {
                                        System.out.println("Batalla");
                                        

                                    }
                                    break;
                                }
                                case Entrenador.DOWN: {
                                    J1.moveDown(currentTime, running, bike);

                                    if (Entrenador.b == true) {
                                        System.out.println("Batalla");
                                        
                                    }
                                    break;
                                }
                            }
                            sw = 0;
                            J1.draw(gc);
                            gc.drawImage(cp.getImage(), 54, 51, null);
                            c.getBufferStrategy().show();
                            Thread.sleep(20);
                        } catch (Exception e) {
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void pSalvaje() {

        
    }

    public static void main(String[] args) {

        //Ventana de la Pelea
//        venLucha b = new venLucha(800, 600);
//        b.setLocationRelativeTo(null);
//        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        b.setVisible(true);
//        b.setResizable(false);
//        b.setLocationRelativeTo(null);
//        b.setTitle("Pokemón: Meet In The Dungeon");
//        b.setIconImage(icono);
        //Ventana Principal
        PKMNMeet v = new PKMNMeet(800, 600);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
        v.setResizable(false);
        v.movieLoop.start();
        v.setLocationRelativeTo(null);
        v.setTitle("Pokemón: Meet In The Dungeon");
        v.setIconImage(icono);

    }

}
