package Object;

import Other.Animation;
import Other.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;

import static UserInterface.Screen.GRAVITY;
import static UserInterface.Screen.GROUNDY;

public class MainCharacter {
    private float x = 0;
    private float y = 20;
    private float speedY = 0;
    private Animation characterRun;

    public MainCharacter(){
        characterRun = new Animation(200);
        characterRun.addFrame(Resource.getResourceImage("data/duobieganie1.png"));
        characterRun.addFrame(Resource.getResourceImage("data/duobieganie2.png"));
    }

    public void update(){
        characterRun.update();      //duo porusza się podczas biegania
        if(y >= GROUNDY - characterRun.getFrame().getHeight()){     //linie do skoku
            speedY = 0;
            y = GROUNDY - characterRun.getFrame().getHeight();
        }
        else {
            speedY+=GRAVITY;
            y+=speedY;
        }
    }

    public void draw(Graphics g){
        g.drawRect((int) x, (int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());
        g.drawImage(characterRun.getFrame(), (int)x, (int)y, null);
    }

    public void jump(){
        speedY = -4;                //skok, strzałka w górę
        y += speedY;
    }

    public void duck(){
        //napisać                //kucanie, strzałka w dół
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
}
