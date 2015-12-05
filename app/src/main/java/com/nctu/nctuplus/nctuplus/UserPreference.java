package com.nctu.nctuplus.nctuplus;

/**
 * Created by cober on 2015/12/5.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class UserPreference {

    Context context;
    String LOG_TAG = getClass().getSimpleName();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefEditor;

    public UserPreference(Context context) {
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences("Pref", Context.MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();
    }

    public String getFbId() {
        return sharedPreferences.getString(context.getString(R.string.pref_fb_id), null);
    }

    public String getId() {
        return sharedPreferences.getString(context.getString(R.string.pref_id), null);
    }

    public String getEmail() {
        return sharedPreferences.getString(context.getString(R.string.pref_email), "example@example.com");
    }

    public String getName() {
        return sharedPreferences.getString(context.getString(R.string.pref_name), "Guest");
    }

    public void saveFbId(String fbId) {
        prefEditor.putString(context.getString(R.string.pref_fb_id), fbId);
        prefEditor.apply();
    }
    public void saveId(String id) {
        prefEditor.putString(context.getString(R.string.pref_id), id);
        prefEditor.apply();
    }

    public void saveEmail(String email) {
        prefEditor.putString(context.getString(R.string.pref_email), email);
        prefEditor.apply();
    }


    public void saveName(String name) {
        prefEditor.putString(context.getString(R.string.pref_name), name);
        prefEditor.apply();
    }

    public void clearAll() {
        prefEditor.clear();
        prefEditor.apply();
    }

}