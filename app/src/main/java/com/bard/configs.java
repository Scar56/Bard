package com.bard;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public final class configs {
    static Map<String,Object> defaults = new HashMap<>();
    private configs(){
    }

    public static void initialize(Map configs) {
        if(configs.isEmpty()){
            defaults.put("song",0xFF00AA00);
        }

    }
    public static String getFont(){
        return (String) defaults.get("font");
    }
    public static int getColor(String type, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(
                String.valueOf(R.string.preference_file), Context.MODE_PRIVATE);
        return sharedPref.getInt(type, (int)defaults.get(type));
    }
}
