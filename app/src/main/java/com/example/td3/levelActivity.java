package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class levelActivity extends AppCompatActivity {
    private TextView t1;
    private Button btn1;
    public final static String EXTRA_LEVELS = "EXTRA_LEVEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level);
        Intent intent = getIntent();
        int level = intent.getIntExtra(MainActivity.EXTRA_LEVEL,1 );
        t1 = findViewById(R.id.t1);

        t1.setText(String.valueOf(level));
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActi = new Intent(levelActivity.this, MainActivity.class);
                mainActi.putExtra(EXTRA_LEVELS, level);
                setResult(RESULT_OK, mainActi);
                finish();
            }
        });
    }


}