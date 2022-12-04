package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Object.MainCharacter;

public class Screen extends JPanel implements Runnable, KeyListener {

    public static final float GRAVITY = 0.1f;
    public static final float GROUNDY = 300; //piksele

    private MainCharacter mainCharacter;
    private Thread thread;

    public Screen(){
        thread = new Thread(this);
        mainCharacter = new MainCharacter();
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {                 //poruszanie się świata
        while(true){
            mainCharacter.update();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);                 //zmiana otoczenia, przesuwa się
        //g.setColor(Color.blue);
        //g.fillRect(0, 0, getWidth(), getHeight());
        //g.setColor(Color.BLACK);
        g.drawLine(0, (int)GROUNDY, getWidth(),(int)GROUNDY);
        mainCharacter.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            mainCharacter.jump();       //skok
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            mainCharacter.duck();       //kucanie
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }
}
