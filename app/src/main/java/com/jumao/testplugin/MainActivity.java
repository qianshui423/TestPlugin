package com.jumao.testplugin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jumao.testplugin.util.ProcessUtil;

import static com.jumao.testplugin.constant.LogTag.TAG_PROCESS_NAME;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG_PROCESS_NAME, ProcessUtil.getProcessName(this, Process.myPid()));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_home_menu_plan) {
            startActivity(new Intent(this, PlanListActivity.class));
        }
        return super.onOptionsItemSelected(item);
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
