package com.example.actionbarprogress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启用窗口特征，启用带进度和不带进度的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        // 显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(true);
        // Max=10000
        setProgress(600);
    }
}
