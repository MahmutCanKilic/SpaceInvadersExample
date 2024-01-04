package com.zetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Particle {
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private int life;
    private Color color;
    private long creationTime;
    private float size;
    public Particle(int x, int y, int speedX, int speedY, int life, Color color,float size) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.life = life;
        this.color = color;
        this.creationTime = System.currentTimeMillis();
        this.size = size;
    }
    public long getCreationTime() {
        return creationTime;
    }
    public boolean isAlive() {
        return life > 0;
    }

    public void update() {
        x += speedX;
        y += speedY;
        life--;
        size -= 0.1;

        if (size <= 0) {
            size = 0;
        }

    }

    public void draw(Graphics g) {
        g.setColor(color);
        int drawSize = (int) size;
        g.fillRect(x, y, drawSize, drawSize);
    }
}

