package me.mrxbox98.advancedflags.utils;

import me.mrxbox98.advancedflags.config.AdvancedConfig;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class IpHelper {

    public static String getTwoLetterCode(String ip)
    {
        try
        {
            String url = "http://api.ipstack.com/" + ip + "?access_key=" + AdvancedConfig.ipStackApiKey;
            String raw = readJsonFromUrl(url);
            int start = raw.indexOf("country+code")+16;
            int end = start+2;
            return raw.substring(start,end);
        }
        catch(Exception | Error e)
        {
            e.printStackTrace();
            return null;
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

    public static String readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            return readAll(rd);
        } finally {
            is.close();
        }
    }

}
