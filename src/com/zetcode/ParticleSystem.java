package com.zetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ParticleSystem {
    private List<Particle> particles;
    private Random random;

    public ParticleSystem() {
        particles = new ArrayList<>();
        random = new Random();
    }

    public void createParticles(int x, int y, int count, Color particleColor,float size) {
        for (int i = 0; i < count; i++) {

            int speedX = random.nextInt(7) - 2;
            int speedY = random.nextInt(7) - 2;


            int startX = x + random.nextInt(21) - 10;
            int startY = y + random.nextInt(21) - 10;

            int life = random.nextInt(30) + 20;

            Particle particle = new Particle(startX, startY, speedX, speedY, life, particleColor, size);
            particles.add(particle);
        }
    }

    public void updateParticles() {
        long currentTime = System.currentTimeMillis();
        Iterator<Particle> iterator = particles.iterator();
        while (iterator.hasNext()) {
            Particle particle = iterator.next();
            particle.update();


            if (currentTime - particle.getCreationTime() >= 1000) {
                iterator.remove();
            }
        }
    }

    public void drawParticles(Graphics g) {
        for (Particle particle : particles) {
            particle.draw(g);
        }
    }
}
