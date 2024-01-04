package com.zetcode.sprite;

import com.zetcode.Board;
import com.zetcode.Commons;

import javax.swing.ImageIcon;
import java.util.Random;

public class Pickable extends Sprite {

    public enum PickableType {
        SINGLE_SHOT,
        TRIPLE_SHOT,
        SPEED_UP,
        PLAYER_SPEED_UP
    }

    private PickableType type;
    private boolean pickedUp;
    private int fallSpeed;

    public Pickable(int x, int y) {
        initPickable(x, y);
        pickedUp = false;
        fallSpeed = 5;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    private void initPickable(int x, int y) {
        this.x = x;
        this.y = y;


        Random random = new Random();
        int pickableTypeIndex = random.nextInt(PickableType.values().length);
        type = PickableType.values()[pickableTypeIndex];


        String pickableImg = getPickableImageByType(type);
        var ii = new ImageIcon(pickableImg);

        setImage(ii.getImage());
    }

    private String getPickableImageByType(PickableType type) {
        switch (type) {
            case SINGLE_SHOT:
                return "src/images/singleshot.png";
            case TRIPLE_SHOT:
                return "src/images/tripleshot.png";
            case SPEED_UP:
                return "src/images/shotspeedup.png";
            case PLAYER_SPEED_UP:
                return "src/images/playerspeedup.png";
            default:
                return "";
        }
    }

    public void act() {
        if (!pickedUp) {
            y += fallSpeed;
            if (y >= Commons.GROUND - Commons.PICKABLE_HEIGHT) {
                die();
            }
        }
    }

    public void pickup() {
        if (!pickedUp) {

            setVisible(false);
            pickedUp = true;


            handlePickupEffect();
        }
    }

    private void handlePickupEffect() {
        switch (type) {
            case SINGLE_SHOT:
                Board.isTriple = false;
                break;
            case TRIPLE_SHOT:
                Board.isTriple = true;
                break;
            case SPEED_UP:
                Shot.increaseShotSpeed();
                Board.shotDelay -= 50;
                break;
            case PLAYER_SPEED_UP:

                Player.playerSpeed += 3;
                break;
        }
    }


}
