package com.jbnu.comall.util;


public class Strings {

    public static String key(String key) {
        return key.replaceAll("\\.", "")
                .replaceAll(" ", "");
    }

    public static boolean empty(String str) {
        return str == null || str.replaceAll(" ", "").equals("");
    }
}