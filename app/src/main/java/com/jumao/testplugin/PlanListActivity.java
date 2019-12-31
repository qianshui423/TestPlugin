package com.jumao.testplugin;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jumao.testplugin.util.ProcessUtil;

import static com.jumao.testplugin.constant.LogTag.TAG_PROCESS_NAME;

public class PlanListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_list);
        Log.d(TAG_PROCESS_NAME, ProcessUtil.getProcessName(this, Process.myPid()));
    }
}
