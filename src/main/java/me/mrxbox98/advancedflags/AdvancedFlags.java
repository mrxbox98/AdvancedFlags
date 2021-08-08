package me.mrxbox98.advancedflags;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_8;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import me.mrxbox98.advancedflags.commands.CommandHandler;
import me.mrxbox98.advancedflags.config.AdvancedConfig;
import me.mrxbox98.advancedflags.flags.CustomFlags;
import me.mrxbox98.advancedflags.flags.FlagManager;
import me.mrxbox98.advancedflags.listeners.MainListener;
import me.mrxbox98.advancedflags.utils.AdvancedPlayer;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public final class AdvancedFlags extends JavaPlugin implements LogHelper {

    public static JavaPlugin instance;

    public static Particles_1_8 particles;

    public static boolean v1_8 =true;

    public static final String version = "1.1.2";

    public static HashMap<String, String> aliases = new HashMap<>();

    public void onEnable() {

        instance=this;

        if(getServer().getVersion().contains("1.13") || getServer().getVersion().contains("1.14") || getServer().getVersion().contains("1.15") || getServer().getVersion().contains("1.16") || getServer().getVersion().contains("1.17"))
        {
            v1_8=false;
        }
        else
        {
            v1_8=true;
        }

        int pluginId=12331;
        Metrics metrics = new Metrics(this, pluginId);

        CustomFlags.setupCustomFlags();

        try {
            setup();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ParticleNativeAPI api = ParticleNativeCore.loadAPI(instance);

        particles = api.getParticles_1_8();

        CommandHandler.setupCommands();

        instance.getServer().getPluginManager().registerEvents(new MainListener(),AdvancedFlags.instance);

        aliases.put("PR","Puerto Rico");aliases.put( "PT","Portugal");aliases.put( "PW","Palau");aliases.put( "PY","Paraguay");aliases.put( "QA","Qatar");aliases.put( "Pl","Poland");aliases.put( "Pr","Puerto Rico");aliases.put( "AD","Andorra");aliases.put( "AE","United Arab Emirates");aliases.put( "AF","Afghanistan");aliases.put( "AG","Antigua and Barbuda");aliases.put( "AL","Albania");aliases.put( "AM","Armenia");aliases.put( "AO","Angola");aliases.put( "AR","Argentina");aliases.put( "AS","American Samoa");aliases.put( "AT","Austria");aliases.put( "AU","Australia");aliases.put( "AW","Aruba");aliases.put( "AZ","Azerbaijan");aliases.put( "RO","Romania");aliases.put( "BA","Bosnia and Herzegovina");aliases.put( "BB","Barbados");aliases.put( "RS","Serbia");aliases.put( "BD","Bangladesh");aliases.put( "BE","Belgium");aliases.put( "RU","Russian Federation");aliases.put( "BF","Burkina Faso");aliases.put( "BG","Bulgaria");aliases.put( "RW","Rwanda");aliases.put( "BH","Bahrain");aliases.put( "BI","Burundi");aliases.put( "BJ","Benin");aliases.put( "BM","Bermuda");aliases.put( "BN","Brunei Darussalam");aliases.put( "BO","Bolivia");aliases.put( "SA","Saudi Arabia");aliases.put( "SB","Solomon Islands");aliases.put( "BR","Brazil");aliases.put( "SC","Seychelles");aliases.put( "BS","Bahama");aliases.put( "SD","Sudan");aliases.put( "BT","Bhutan");aliases.put( "SE","Sweden");aliases.put( "SG","Singapore");aliases.put( "BW","Botswana");aliases.put( "SI","Slovenia");aliases.put( "BY","Belarus");aliases.put( "BZ","Belize");aliases.put( "SK","Slovak Republic");aliases.put( "SL","Sierra Leone");aliases.put( "SM","San Marino");aliases.put( "SN","Senegal");aliases.put( "SO","Somalia");aliases.put( "CA","Canada");aliases.put( "SR","Suriname");aliases.put( "SS","South Sudan");aliases.put( "ST","Sao Tome and Principe");aliases.put( "CF","Central African Republic");aliases.put( "SV","El Salvador");aliases.put( "CG","Cong");aliases.put( "CH","Switzerland");aliases.put( "CI","Cote d'Ivoire");aliases.put( "SY","Syrian Arab Republic");aliases.put( "SZ","Eswatini");aliases.put( "CL","Chile");aliases.put( "CM","Cameroon");aliases.put( "CN","China");aliases.put( "CO","Colombia");aliases.put( "CR","Costa Rica");aliases.put( "TC","Turks and Caicos Islands");aliases.put( "TD","Chad");aliases.put( "CU","Cuba");aliases.put( "CV","Cabo Verde");aliases.put( "TG","Togo");aliases.put( "th","Thailand");aliases.put( "TH","Thailand");aliases.put( "CY","Cyprus");aliases.put( "TJ","Tajikistan");aliases.put( "CZ","Czech Republic");aliases.put( "TL","Timor-Leste");aliases.put( "TM","Turkmenistan");aliases.put( "TN","Tunisia");aliases.put( "TO","Tonga");aliases.put( "TR","Turkey");aliases.put( "TT","Trinidad and Tobago");aliases.put( "DE","Germany");aliases.put( "TV","Tuvalu");aliases.put( "TW","Taiwa");aliases.put( "DJ","Djibouti");aliases.put( "DK","Denmark");aliases.put( "DM","Dominica");aliases.put( "DO","Dominican Republic");aliases.put( "UA","Ukraine");aliases.put( "UG","Uganda");aliases.put( "DZ","Algeria");aliases.put( "EC","Ecuador");aliases.put( "US","United States");aliases.put( "EE","Estonia");aliases.put( "De","Germany");aliases.put( "EG","Egyp");aliases.put( "UY","Uruguay");aliases.put( "UZ","Uzbekistan");aliases.put( "ER","Eritrea");aliases.put( "VC","St. Vincent and the Grenadines");aliases.put( "ES","Spain");aliases.put( "ET","Ethiopia");aliases.put( "VE","Venezuel");aliases.put( "VN","Vietnam");aliases.put( "VU","Vanuatu");aliases.put( "FI","Finland");aliases.put( "FJ","Fiji");aliases.put( "FO","Faroe Islands");aliases.put( "FR","France");aliases.put( "GA","Gabon");aliases.put( "GB","United Kingdom");aliases.put( "WS","Samoa");aliases.put( "GD","Grenada");aliases.put( "GE","Georgia");aliases.put( "GH","Ghana");aliases.put( "GI","Gibraltar");aliases.put( "GL","Greenland");aliases.put( "GM","Gambi");aliases.put( "GN","Guinea");aliases.put( "GQ","Equatorial Guinea");aliases.put( "GR","Greece");aliases.put( "GT","Guatemala");aliases.put( "GU","Guam");aliases.put( "GW","Guinea-Bissau");aliases.put( "GY","Guyana");aliases.put( "HK","Hong Kong SA");aliases.put( "HN","Honduras");aliases.put( "HR","Croatia");aliases.put( "HT","Haiti");aliases.put( "YE","Yemen");aliases.put( "HU","Hungary");aliases.put( "ID","Indonesia");aliases.put( "IE","Ireland");aliases.put( "IL","Israel");aliases.put( "IM","Isle of Man");aliases.put( "IN","India");aliases.put( "ZA","South Africa");aliases.put( "IQ","Iraq");aliases.put( "IS","Iceland");aliases.put( "IT","Italy");aliases.put( "ZM","Zambia");aliases.put( "JM","Jamaica");aliases.put( "JO","Jordan");aliases.put( "JP","Japan");aliases.put( "KE","Kenya");aliases.put( "KG","Kyrgyz Republic");aliases.put( "KH","Cambodia");aliases.put( "KI","Kiribati");aliases.put( "KM","Comoros");aliases.put( "KN","St. Kitts and Nevis");aliases.put( "KR","Kore");aliases.put( "KW","Kuwait");aliases.put( "KY","Cayman Islands");aliases.put( "KZ","Kazakhstan");aliases.put( "LA","Lao PDR");aliases.put( "LB","Lebanon");aliases.put( "LC","St. Lucia");aliases.put( "LI","Liechtenstein");aliases.put( "LK","Sri Lanka");aliases.put( "LR","Liberia");aliases.put( "LS","Lesotho");aliases.put( "LT","Lithuania");aliases.put( "LU","Luxembourg");aliases.put( "LV","Latvia");aliases.put( "LY","Libya");aliases.put( "MA","Morocco");aliases.put( "MC","Monaco");aliases.put( "ME","Montenegro");aliases.put( "MG","Madagascar");aliases.put( "MH","Marshall Islands");aliases.put( "ML","Mali");aliases.put( "MM","Myanmar");aliases.put( "MN","Mongolia");aliases.put( "MO","Macao SA");aliases.put( "MP","Northern Mariana Islands");aliases.put( "MR","Mauritania");aliases.put( "MT","Malta");aliases.put( "MU","Mauritius");aliases.put( "MV","Maldives");aliases.put( "MW","Malawi");aliases.put( "MX","Mexico");aliases.put( "MY","Malaysia");aliases.put( "MZ","Mozambique");aliases.put( "NA","Namibia");aliases.put( "NC","New Caledonia");aliases.put( "NE","Niger");aliases.put( "NG","Nigeria");aliases.put( "NI","Nicaragua");aliases.put( "NL","Netherlands");aliases.put( "NO","Norway");aliases.put( "NP","Nepal");aliases.put( "NR","Nauru");aliases.put( "NZ","New Zealand");aliases.put( "OM","Oman");aliases.put( "PA","Panama");aliases.put( "PE","Peru");aliases.put( "PF","French Polynesia");aliases.put( "PG","Papua New Guinea");aliases.put( "PH","Philippines");aliases.put( "PK","Pakistan");aliases.put( "PL","Poland");

        new UpdateChecker(this, 95031).getVersion(version -> {
            if(version.equalsIgnoreCase(version))
            {
                System.out.println(LogHelper.BLACK_BACKGROUND+"AdvancedFlags is up to date!");
            }
            else
            {
                System.out.println(LogHelper.BLACK_BACKGROUND+"AdvancedFlags is not up to date!");
            }
        });
    }

    public void onDisable() {

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
        }.runTaskTimerAsynchronously(instance, 0,AdvancedConfig.delay);
    }

    /**
     * <br>Rotates the flags that are on the player<br>
     */
    public static void setupRotate()
    {
        Bukkit.getScheduler().runTaskTimerAsynchronously(AdvancedFlags.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Player player: instance.getServer().getOnlinePlayers())
                {
                    if(AdvancedPlayer.getAdvancedPlayer(player).rotate)
                    {
                        AdvancedPlayer.getAdvancedPlayer(player).advance();
                    }
                }
            }
        },0,20);
    }

    /**
     * Sets up the plugin
     * @throws IOException File error
     */
    public static void setup() throws IOException {
        AdvancedConfig.setupConfig();

        FlagManager.setup();
        setupFlags();

        setupRotate();
    }





    public static String readJsonFromUrl(String url) throws Exception {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            return readAll(rd);
        } finally {
            is.close();
        }
    }

    /**
     * Reads the stuff in the reader
     * @param rd the reader
     * @return the data in the reader
     * @throws IOException possible error
     */
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JavaPlugin getInstance()
    {
        return instance;
    }

}
