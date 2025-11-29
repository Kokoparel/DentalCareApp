package com.example.dentalcareapp.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPrefManager {

    private static final String PREF_NAME = "DentalCarePrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_STREAK_COUNT = "streakCount";

    private static final String KEY_USER_PASSWORD = "user_password";

    private static SharedPrefManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefManager(context.getApplicationContext());
        }
        return instance;
    }

    // Login/Logout methods
    public void login(String userId, String name, String email, String password) {
        editor.putString(KEY_USER_ID, userId);
        editor.putString(KEY_USER_NAME, name);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USER_PASSWORD, password); // TAMBAH INI
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();

        Log.d("SharedPrefManager", "=== USER LOGIN ===");
        Log.d("SharedPrefManager", "User ID: " + userId);
        Log.d("SharedPrefManager", "Name: " + name);
        Log.d("SharedPrefManager", "Email: " + email);
        Log.d("SharedPrefManager", "==================");
    }

    public void printAllData() {
        Log.d("SharedPrefManager", "=== ALL SAVED DATA ===");
        Log.d("SharedPrefManager", "User ID: " + getUserId());
        Log.d("SharedPrefManager", "Name: " + getUserName());
        Log.d("SharedPrefManager", "Email: " + getUserEmail());
        Log.d("SharedPrefManager", "Password: " + getUserPassword()); // TAMBAH INI
        Log.d("SharedPrefManager", "Is Logged In: " + isLoggedIn());
        Log.d("SharedPrefManager", "=====================");
    }

    public void logout() {
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // User data methods
    public String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, null);
    }

    public String getUserName() {
        return sharedPreferences.getString(KEY_USER_NAME, "User");
    }

    public String getUserEmail() {
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }

    // Streak methods
    public int getStreakCount() {
        return sharedPreferences.getInt(KEY_STREAK_COUNT, 0);
    }

    public String getUserPassword() {
        return sharedPreferences.getString(KEY_USER_PASSWORD, null);
    }

    public void setStreakCount(int count) {
        editor.putInt(KEY_STREAK_COUNT, count);
        editor.apply();
    }

    // Generic methods
    public void saveBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void saveString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public void saveInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
}
