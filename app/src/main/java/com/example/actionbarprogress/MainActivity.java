package com.example.actionbarprogress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;

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

        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.horizontal);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.text);
        refresh();
        add.setOnClickListener(this);
        reset.setOnClickListener(this);
        reduce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                // 增加第一进度和第二进度10个刻度
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(10);
                break;

            case R.id.reduce:
                // 减少第一进度和第二进度10个刻度
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-10);
                break;

            case R.id.reset:
                progressBar.setProgress(50);
                progressBar.setSecondaryProgress(80);
                break;

            default:
                break;
        }
        refresh();
    }

    private void refresh() {
        // 获取第一进度条的进度
        int first = progressBar.getProgress();
        // 获取第二进度条的进度
        int second = progressBar.getSecondaryProgress();
        // 获取进度条的最大进度
        int max = progressBar.getMax();
        text.setText("第一进度百分比：" + (int) (first / (float) max * 100) + "% 第二进度百分比：" + (int) (second / (float) max * 100) + "%");
    }
}
