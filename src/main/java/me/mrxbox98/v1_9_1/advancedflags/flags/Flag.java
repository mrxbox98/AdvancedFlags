package me.mrxbox98.v1_9_1.advancedflags.flags;

import me.mrxbox98.v1_9_1.advancedflags.particles.Particle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Flag {

    public Color[][] colors;

    public Particle[][] particles;

    public String abbr;

    public int ow;

    public int oh;

    public Flag(String abbreviation) throws IOException {

        oh=20;

        abbr=abbreviation;

        BufferedImage image;

        image=ImageIO.read(this.getClass().getResource("/flags/"+abbr.toLowerCase()+".png"));

        ow=image.getWidth();



        colors = new Color[ow][oh];

        for(int x=0;x<ow;x++)
        {
            for(int y=0;y<oh;y++)
            {
                colors[x][y]=new Color(image.getRGB(x,y));
            }
        }

        particles = new Particle[ow][oh];

        for(int x=0;x<ow;x++)
        {
            for(int y=0;y<oh;y++)
            {
                particles[x][y]=new Particle(colors[x][y]);
            }
        }


    }

}
