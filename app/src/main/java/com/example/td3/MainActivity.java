package com.example.td3;
//import static android.os.BatteryManager.EXTRA_LEVEL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_LEVEL = "EXTRA_LEVEL";
    public final static int LEVEL = 10;
    public final static int SIZE = 15;
    private TextView score, level, text, text_score, text_level, act2;
    private Button restart, play, setting;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(LEVEL == requestCode && RESULT_OK == resultCode){
            int zoom = data.getIntExtra(levelActivity.EXTRA_LEVELS, 0);
            act2.setText("Activite 2 a été lancée :"+" " + String.valueOf(zoom-1)+" "+ "fois");

        }

        if(SIZE == requestCode && RESULT_OK == resultCode){
            int size = data.getIntExtra(settings.EXTRA_SIZE, 25);
            int textsiz = size/4;
            //zone de text score
            score.setHeight(size+20);
            score.setTextSize(textsiz);
            // zone de text level
            level.setHeight(size+20);
            level.setTextSize(textsiz);

            // zone de texte
            text_score.setHeight(size+20);
            text_score.setTextSize(textsiz);


            text_level.setHeight(size+20);
            //text_level.setWidth(size+75);
            text_level.setTextSize(textsiz);

            //act2.setHeight(size+40);
            //act2.setWidth(size+75);
            act2.setTextSize(textsiz);

            //play.setHeight(size+40);
            //play.setWidth(size+75);
            play.setTextSize(textsiz);


            //restart.setHeight(size+40);
            //restart.setWidth(size+75);
            restart.setTextSize(textsiz);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = findViewById(R.id.score);
        level = findViewById(R.id.level);
        restart = findViewById(R.id.restart);
        play = findViewById(R.id.play);
        setting = findViewById(R.id.btn_setting);
        text = findViewById(R.id.textzoom);
        text_level = findViewById(R.id.text_level);
        text_score = findViewById(R.id.text_score);
        act2 = findViewById(R.id.act2);

        score.setText("0");
        level.setText("1");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String sc = (String) score.getText();
                try {
                    int sc = Integer.parseInt(score.getText().toString());

                    sc++;
                    if(sc %5 == 0){
                        int le=Integer.parseInt(level.getText().toString());
                        le++;
                        //int[] t = {le, sc};
                        Intent intent = new Intent(MainActivity.this, levelActivity.class);
                        //Intent scI = new Intent(MainActivity.this, levelActivity.class);
                        intent.putExtra(EXTRA_LEVEL, le);
                        startActivityForResult(intent, LEVEL);

                        //startActivity(intent);


                        level.setText(String.valueOf(le));
                        Intent main = getIntent();
                        //int levelR = main.getIntExtra(MainActivity.EXTRA_LEVEL,1 );
                        //int newSC = (levelR*5)-5;
                        //level.setText(String.valueOf(levelR));
                        //score.setText(String.valueOf(newSC));
                        //scI.putExtra(EXTRA_LEVEL, sc);
                    }
                    score.setText(String.valueOf(sc));

                }catch(Exception e){
                    e.getMessage();
                }



            }

        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.setText("0");
                level.setText("1");


            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, settings.class);
                startActivityForResult(intent, SIZE);
                //startActivity(intent);
            }
        });

    }

}
