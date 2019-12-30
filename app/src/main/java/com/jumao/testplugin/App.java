package com.jumao.testplugin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        Toast.makeText(this, "getSharedPreferences", Toast.LENGTH_SHORT).show();
        return super.getSharedPreferences(name, mode);
    }
}
