package org.telegram.messenger.vellor;

import android.content.Context;
import android.content.SharedPreferences;
import org.telegram.messenger.ApplicationLoader;

public class VellorConfig {

    private static final String PREFS_NAME =  vellor_config;
    private static SharedPreferences preferences;

    // Features
    public static boolean ghostMode = false;
    public static boolean hideReadStatus = false;
    public static boolean hideOnline = false;
    public static boolean hideTyping = false;
    public static boolean antiDeleteMessages = true;
    public static boolean noSponsoredAds = true;
    public static boolean saveRestrictedMedia = true;
    public static boolean unlimitedAccounts = true;

    // Crimson Theme Colors
    public static final int CRIMSON_PRIMARY = 0xFFE63946;
    public static final int CRIMSON_DARK = 0xFF140709;
    public static final int CRIMSON_ACCENT = 0xFFFF1E42;
    public static final int CRIMSON_SURFACE = 0xFF1A1114;
    public static final int CRIMSON_BG = 0xFF0A0507;

    public static void loadConfig() {
        if (ApplicationLoader.applicationContext == null) return;
        preferences = ApplicationLoader.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        ghostMode = preferences.getBoolean(ghostMode, false);
        hideReadStatus = preferences.getBoolean(hideReadStatus, false);
        hideOnline = preferences.getBoolean(hideOnline, false);
        hideTyping = preferences.getBoolean(hideTyping, false);
        antiDeleteMessages = preferences.getBoolean(antiDeleteMessages, true);
        noSponsoredAds = preferences.getBoolean(noSponsoredAds, true);
        saveRestrictedMedia = preferences.getBoolean(saveRestrictedMedia, true);
        unlimitedAccounts = preferences.getBoolean(unlimitedAccounts, true);
    }

    public static void toggleGhostMode(boolean enabled) {
        ghostMode = enabled;
        hideReadStatus = enabled;
        hideOnline = enabled;
        hideTyping = enabled;
        save();
    }

    public static void save() {
        if (preferences == null) return;
        preferences.edit()
                .putBoolean(ghostMode, ghostMode)
                .putBoolean(hideReadStatus, hideReadStatus)
                .putBoolean(hideOnline, hideOnline)
                .putBoolean(hideTyping, hideTyping)
                .putBoolean(antiDeleteMessages, antiDeleteMessages)
                .putBoolean(noSponsoredAds, noSponsoredAds)
                .putBoolean(saveRestrictedMedia, saveRestrictedMedia)
                .putBoolean(unlimitedAccounts, unlimitedAccounts)
                .apply();
    }
}
