package me.mrxbox98.advancedflags.flags;

import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.particles.Particle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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

        if(this.getClass().getResource("/flags/"+abbr.toLowerCase()+".png")==null)
        {
            image=ImageIO.read(new File(AdvancedFlags.getInstance().getDataFolder().getAbsolutePath()+abbr.toLowerCase()+".png"));
        }
        else
        {
            image=ImageIO.read(this.getClass().getResource("/flags/"+abbr.toLowerCase()+".png"));
        }




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
