package me.mrxbox98.v1_8_5.advancedflags.flags;

import me.mrxbox98.v1_8_5.advancedflags.AdvancedFlags;
import me.mrxbox98.v1_8_5.advancedflags.LogHelper;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;

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
            "IS",
            "IN",
            "ID",
            "Is",
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

        AdvancedFlags.getInstance().getLogger().info(abbreviations.toString());

        System.out.println(BLUE_BACKGROUND+"↱STARTED FLAG DOWNLOADING↰");

        for (String abbreviation : csv) {
            try {
                flags.add(new Flag(abbreviation));
                System.out.println(BLUE_BACKGROUND+"|           "+abbreviation+"           |");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(BLUE_BACKGROUND+"↳      FINISHED FLAGS    ↲");

        AdvancedFlags.setupFlags();

    }

    /**
     * Draws a flag on a player
     * @param player the player to draw the flag on
     * @param flag the flag to draw on the player
     */
    public static void drawFlagOnPlayer(Player player, Flag flag)
    {
        double xx = flag.ow/2d;

        double xy = flag.oh/2d;

        for(int x=0;x<flag.ow;x++)
        {
            for(int y=0;y<flag.oh;y++)
            {
                flag.particles[x][y].display(player.getLocation().add(((double)x-xx)/-10d,((double)y-xy)/-10d+4d,0));
            }
        }
    }

}
