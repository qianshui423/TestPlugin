package com.jumao.testplugin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Log MainActivity");

        SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("test", true).apply();

//        findViewById(R.id.btnOnClick).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("MainActivity", "你好，短按");
//            }
//        });
//
//        findViewById(R.id.btnOnLongClick).setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Log.d("MainActivity", "你好，长按");
//                return false;
//            }
//        });
        findViewById(R.id.btnOnClick).setOnClickListener(new OnClickListenerImpl());

        findViewById(R.id.btnOnLongClick).setOnLongClickListener(new OnLongClickClickListenerImpl());
    }

    private class OnClickListenerImpl implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.d("MainActivity", "你好，短按");
        }
    }

    private class OnLongClickClickListenerImpl implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            Log.d("MainActivity", "你好，长按");
            return false;
        }
    }
}
