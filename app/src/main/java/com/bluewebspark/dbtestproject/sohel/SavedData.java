package com.bluewebspark.dbtestproject.sohel;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bluewebspark.dbtestproject.AppControlar;

public class SavedData {
    private static final String CITY_STATUS = "cityStatus";
    private static final String CITY = "city";
    private static final String LOCATION = "location";
    private static final String LAT = "lat";
    private static final String LNG = "lng";

    static SharedPreferences prefs;

    public static SharedPreferences getInstance() {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(AppControlar.getmInstance());
        }
        return prefs;
    }

    public static boolean getCityStatus() {
        return getInstance().getBoolean(CITY_STATUS, false);
    }

    public static void saveCityStatus(boolean cityStatus) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putBoolean(CITY_STATUS, cityStatus);
        editor.apply();
    }

    public static String getCity() {
        return getInstance().getString(CITY, "");
    }

    public static void saveCity(String city) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(CITY, city);
        editor.apply();
    }

    public static String getLocation() {
        return getInstance().getString(LOCATION, "");
    }

    public static void saveLocation(String location) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(LOCATION, location);
        editor.apply();
    }

    public static String getLat() {
        return getInstance().getString(LAT, "");
    }

    public static void saveLat(String lat) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(LAT, lat);
        editor.apply();
    }

    public static String getLng() {
        return getInstance().getString(LNG, "");
    }

    public static void saveLng(String lng) {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.putString(LNG, lng);
        editor.apply();
    }

    public static void clear() {
        SharedPreferences.Editor editor = getInstance().edit();
        editor.clear();
        editor.apply();
    }
}