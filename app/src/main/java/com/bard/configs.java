package com.bard;

import java.util.HashMap;
import java.util.Map;

public final class configs {
    static Map<String,Object> defaults = new HashMap<>();
    private configs(){
    }

    public static void initialize(Map configs) {

    }
    public static String getFont(){
        return (String) defaults.get("font");
    }
    public static int getColor(){
//        return (String) defaults.get("color");
        return 0xFF000000;
    }
}
