package com.telna.util;

import java.net.MalformedURLException;
import java.net.URL;

public class Constants {
    public static URL BASEURL;

    static {
        try {
            BASEURL = new URL("https://localhost:44391");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

