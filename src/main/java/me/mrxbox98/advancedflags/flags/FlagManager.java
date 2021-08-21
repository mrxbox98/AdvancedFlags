package me.mrxbox98.advancedflags.flags;

import me.mrxbox98.advancedflags.AdvancedFlags;
import me.mrxbox98.advancedflags.LogHelper;
import me.mrxbox98.advancedflags.config.AdvancedConfig;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FlagManager implements LogHelper {

    /**
     * The abbreviations of all the countries with ISO code 3166 ALPHA-2
     */
    public static final ArrayList<String> abbreviations = new ArrayList<>();

    /**
     * The arraylist of the flags used
     */
    public static ArrayList<Flag> flags = new ArrayList<>();

    /**
     * The flags to use
     */
    public static String[] csv = {
            "AF",
            "AL",
            "DZ",
            "AS",
            "AD",
            "AO",
            "AG",
            "AR",
            "AM",
            "AW",
            "AU",
            "AT",
            "AZ",
            "BS",
            "BH",
            "BD",
            "BB",
            "BY",
            "BE",
            "BZ",
            "BJ",
            "BM",
            "BT",
            "Pl",
            "BO",
            "BA",
            "BW",
            "BR",
            "BN",
            "BG",
            "BF",
            "BI",
            "KH",
            "CM",
            "CA",
            "CV",
            "KY",
            "CF",
            "TD",
            "CL",
            "CN",
            "CO",
            "KM",
            "CG",
            "th",
            "CR",
            "CI",
            "HR",
            "CU",
            "CY",
            "CZ",
            "DK",
            "DJ",
            "DM",
            "DO",
            "EC",
            "EG",
            "SV",
            "GQ",
            "ER",
            "EE",
            "ET",
            "FO",
            "FJ",
            "FI",
            "FR",
            "PF",
            "GA",
            "GM",
            "GE",
            "DE",
            "GH",
            "GI",
            "GR",
            "GL",
            "GD",
            "GU",
            "GT",
            "GN",
            "GW",
            "GY",
            "HT",
            "HN",
            "HK",
            "HU",
            "IR",
            "IS",
            "IN",
            "ID",
            "IQ",
            "IE",
            "IM",
            "IL",
            "IT",
            "JM",
            "JP",
            "JO",
            "KZ",
            "KE",
            "KI",
            "De",
            "KR",
            "KW",
            "KG",
            "LA",
            "LV",
            "LB",
            "LS",
            "LR",
            "LY",
            "LI",
            "LT",
            "LU",
            "MO",
            "th",
            "MG",
            "MW",
            "MY",
            "MV",
            "ML",
            "MT",
            "MH",
            "MR",
            "MU",
            "MX",
            "MC",
            "MN",
            "ME",
            "MA",
            "MZ",
            "MM",
            "NA",
            "NR",
            "NP",
            "NL",
            "NC",
            "NZ",
            "NI",
            "NE",
            "NG",
            "MP",
            "NO",
            "OM",
            "PK",
            "PW",
            "PA",
            "PG",
            "PY",
            "PE",
            "PH",
            "PL",
            "PT",
            "PR",
            "QA",
            "RO",
            "RU",
            "RW",
            "KN",
            "LC",
            "VC",
            "WS",
            "SM",
            "ST",
            "SA",
            "SN",
            "RS",
            "SC",
            "SL",
            "SG",
            "SK",
            "SI",
            "SB",
            "SO",
            "ZA",
            "SS",
            "ES",
            "LK",
            "SD",
            "SR",
            "SZ",
            "SE",
            "CH",
            "SY",
            "Pr",
            "TW",
            "TJ",
            "TH",
            "TL",
            "TG",
            "TO",
            "TT",
            "TN",
            "TR",
            "TM",
            "TC",
            "TV",
            "UG",
            "UA",
            "AE",
            "GB",
            "US",
            "UY",
            "UZ",
            "VU",
            "BO",
            "VE",
            "VN",
            "YE",
            "ZM"
    };



    /**
     * Sets up the flags by downloading them from the api
     * and creating particle objects for all of them
     */
    public static void setup()
    {

        abbreviations.addAll(Arrays.asList(csv));

        AdvancedFlags.getInstance().getLogger().info(abbreviations.toString());

        System.out.println(BLUE_BACKGROUND+"↱STARTED FLAG DOWNLOADING↰"+RESET);

        for (String abbreviation : abbreviations) {
            try {
                flags.add(new Flag(abbreviation));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(BLUE_BACKGROUND+"↳      FINISHED FLAGS    ↲"+RESET);

        AdvancedFlags.setupFlags();
    }

    /**
     * Draws a flag on a player
     * @param player the player to draw the flag on
     * @param flag the flag to draw on the player
     */
    public static void drawFlagOnPlayer(Player player, Flag flag)
    {

        for(int x=-flag.ow/2;x<flag.ow/2;x++)
        {
            for(int y=-flag.oh/2;y<flag.oh/2;y++)
            {
                flag.particles[x][y].display(generateLocation(x,y,player));
            }
        }
    }

    /**
     * Creates the location the particle should be displayed at
     * @param passX the x cord of the particle on the flag
     * @param passY the y cord of the particle on the flag
     * @param player the player
     * @return the location of the particle
     */
    public static Location generateLocation(int passX, int passY, Player player)
    {
        double xOffset=((double)passX)/-10d;
        double yOffset=((double)passY)/-10d+4d;
        double zOffset=0;



        if(AdvancedConfig.rotatePitch)
        {

        }

        if(AdvancedConfig.rotateYaw)
        {
            xOffset*=Math.sin(player.getLocation().getYaw());
            zOffset=((double)passX)/-10d;
            zOffset*=Math.cos(player.getLocation().getYaw());
        }
        zOffset+=getXOffset(passX);

        Location loc = player.getLocation().add(xOffset,yOffset,zOffset);

        return loc;
    }

    /**
     * For animated flags
     * @param w the width var
     * @return the x offset
     */
    public static double getXOffset(double w)
    {
        if(AdvancedConfig.animate)
        {
            return Math.sin(w+(((int)System.currentTimeMillis())/100))/10d;
        }
        return 0d;

    }

}
