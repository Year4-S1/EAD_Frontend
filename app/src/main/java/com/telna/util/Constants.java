package com.telna.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Constants {
    public static URL BASEURL;

    static {
        try {
            BASEURL = new URL("http://10.0.2.2:5000");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

