package me.mrxbox98.v1_9_1.advancedflags;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_8;
import com.github.fierioziy.particlenativeapi.plugin.ParticleNativePlugin;
import com.google.gson.Gson;
import me.mrxbox98.v1_9_1.advancedflags.commands.CommandHandler;
import me.mrxbox98.v1_9_1.advancedflags.config.AdvancedConfig;
import me.mrxbox98.v1_9_1.advancedflags.flags.Flag;
import me.mrxbox98.v1_9_1.advancedflags.flags.FlagManager;
import me.mrxbox98.v1_9_1.advancedflags.listeners.MainListener;
import me.mrxbox98.v1_9_1.advancedflags.utils.AdvancedPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    private static AdvancedFlags instance;

    public static Particles_1_8 particles;

    public static File data;

    public static HashMap<String, String> aliases;

    @Override
    public void onEnable() {
        instance=this;

        try {
            setup();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ParticleNativeAPI api = ParticleNativePlugin.getAPI();

        particles = api.getParticles_1_8();

        CommandHandler.setupCommands();

        getServer().getPluginManager().registerEvents(new MainListener(),this);

        System.out.println(aliases);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static AdvancedFlags getInstance()
    {
        return instance;
    }

    /**
     * <br>Sets up all of the flags<br>
     */
    public static void setupFlags()
    {

        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player: instance.getServer().getOnlinePlayers())
                {
                    if(AdvancedPlayer.getAdvancedPlayer(player)==null || AdvancedPlayer.getAdvancedPlayer(player).flagId==-1)
                    {

                    }
                    else
                    {
                        FlagManager.drawFlagOnPlayer(player, FlagManager.flags.get(AdvancedPlayer.getAdvancedPlayer(player).flagId));
                    }
                }
            }
        }.runTaskTimerAsynchronously(instance, AdvancedConfig.delay,1);
    }

    /**
     * Sets up the plugin
     * @throws IOException File error
     */
    public static void setup() throws IOException {
        AdvancedConfig.setupConfig();

        FlagManager.setup();
        setupFlags();

        aliases=setupAliases();
    }

    public static HashMap<String, String> setupAliases() {

        HashMap<String, String> hashMap = new HashMap<>();

        Gson gson = new Gson();

        System.out.println(GREEN_BACKGROUND+"↱   STARTED FLAG LINKING   ↰");

        for(Flag flag: FlagManager.flags)
        {
            try
            {
                String str = readJsonFromUrl("http://api.worldbank.org/v2/country/" +flag.abbr.toLowerCase()+ "?format=json");

                int start = str.indexOf("name")+7;

                int end = str.substring(start).indexOf(",")-1+start;

                String name = str.substring(start,end);

                hashMap.put(flag.abbr, name);

                System.out.println(GREEN_BACKGROUND+"|           "+flag.abbr+"           |");
            }
            catch(Exception | Error e)
            {
                e.printStackTrace();
            }


        }

        return hashMap;
    }

    public static String readJsonFromUrl(String url) throws Exception {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return readAll(rd);
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
