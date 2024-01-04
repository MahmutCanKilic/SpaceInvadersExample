package com.zetcode.sprite;

import com.zetcode.Board;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

public class Shot extends Sprite {
    private boolean soundPlayed = false;
    public static int shotSpeed = 4;


    public Shot(int x, int y) {

        initShot(x, y);
    }

    private void initShot(int x, int y) {

        if(!Board.isTriple){
            var shotImg = "src/images/greenbullet.png";
            var ii = new ImageIcon(shotImg);
            setImage(ii.getImage());
        }else{
            var shotImg = "src/images/redbullet.png";
            var ii = new ImageIcon(shotImg);
            setImage(ii.getImage());
        }




        int H_SPACE = 19;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }
    private void playShotSound() {
        if (!soundPlayed) {
            try {
                File soundFile = new File("sounds/shot.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                float volume = -11.0f;
                gainControl.setValue(volume);


                clip.start();

                soundPlayed = true;
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
    public static void increaseShotSpeed(){
        shotSpeed += 6;
    }
    public void move() {

        this.y -= shotSpeed;


        if (this.y < 0) {
            this.visible = false;
        }
        playShotSound();
    }
}
