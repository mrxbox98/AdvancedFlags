package me.mrxbox98.advancedflags.particles;

import me.mrxbox98.advancedflags.AdvancedFlags;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.awt.*;

public class Particle {

    /**
     * The color of the particle
     */
    Color color;

    /**
     * Creates a new particle with a color
     * @param color the color to use
     */
    public Particle(Color color)
    {
        this.color=color;
    }

    /**
     * Displays the particle at a location
     * @param location the location to display the particle at
     */
    public void display(Location location)
    {
        Bukkit.getScheduler().runTaskAsynchronously(AdvancedFlags.getInstance(), new Runnable() {
            @Override
            public void run() {
                Object packet = AdvancedFlags.particles.REDSTONE().packetColored(true,location,org.bukkit.Color.fromRGB(color.getRed(),color.getGreen(),color.getBlue()));
                AdvancedFlags.particles.sendPacketIf(location, 30D, packet, AdvancedFlags.playerPredicate);
            }
        });

    }

}
