package me.mrxbox98.advancedflags.particles;

import com.github.fierioziy.particlenativeapi.api.packet.ParticlePacket;
import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.config.AdvancedConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.awt.*;

public class Particle {

    /**
     * The color of the particle
     */
    public Color color;

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
        Bukkit.getScheduler().runTaskAsynchronously(AdvancedFlags.getInstance(), () -> {
            ParticlePacket packet = AdvancedFlags.particles.REDSTONE.packetColored(true, location, color.getRed(), color.getGreen(), color.getBlue());
            
            packet.sendInRadiusTo(AdvancedFlags.instance.getServer().getOnlinePlayers(), 30D, AdvancedFlags.playerPredicate);
        });

    }

}
