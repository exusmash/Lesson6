package ru.mirea.kokorevkv.securesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static PreferenceManager INSTANCE;
    private static SharedPreferences sharedPreferences;

    synchronized public static PreferenceManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PreferenceManager();
            sharedPreferences = context.getSharedPreferences("userinfo3", Context.MODE_PRIVATE);
        }
        return INSTANCE;
    }

    public void setString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }
}
