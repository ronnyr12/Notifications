package com.example.notifications;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start, btn_stop;
    Intent intent, intent2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        intent2 = getIntent();
        String message = intent2.getStringExtra("key");
        tv.setText(message);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(btn_start == view){
            intent = new Intent(this, PlayMusic_Service.class);
            startService(intent);
        }
        if(btn_stop == view){
            intent = new Intent(this, PlayMusic_Service.class);
            stopService(intent);
        }
    }
}