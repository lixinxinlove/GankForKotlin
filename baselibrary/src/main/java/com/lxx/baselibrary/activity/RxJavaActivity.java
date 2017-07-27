package com.lxx.baselibrary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lxx.baselibrary.R;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private AppCompatButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn1);
        btn2 = (AppCompatButton) findViewById(R.id.btn2);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn1) {
            Toast.makeText(RxJavaActivity.this, "btn1", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.btn2) {
            Toast.makeText(RxJavaActivity.this, "btn2", Toast.LENGTH_SHORT).show();
        }
    }
}
