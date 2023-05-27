package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class settings extends AppCompatActivity {
    private Button petit, moyen, grand;
    private RadioButton rb1, rb2, rb3;
    public final static String EXTRA_SIZE = "EXTRA_LEVEL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        /*petit = findViewById(R.id.petit);
        moyen = findViewById(R.id.moyen);
        grand = findViewById(R.id.grand);


        petit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pet = 25;
                Intent petI = new Intent(settings.this, MainActivity.class);
                petI.putExtra(EXTRA_SIZE, pet);
                setResult(RESULT_OK, petI);
                finish();
            }
        });

        moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int moy = 48;
                Intent moyI = new Intent(settings.this, MainActivity.class);
                moyI.putExtra(EXTRA_SIZE, moy);
                setResult(RESULT_OK, moyI);
                finish();
            }
        });



        grand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gran = 60;
                Intent grands = new Intent(settings.this, MainActivity.class);
                grands.putExtra(EXTRA_SIZE, gran);
                setResult(RESULT_OK, grands);
                finish();
            }
        });*/
    }

    public void onRadioButtonClicked(View view) {

        rb1 = findViewById(R.id.radio_petit);
        rb2 = findViewById(R.id.radio_moyen);
        rb3 = findViewById(R.id.radio_grand);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_petit:
                // AFFICHAGE PETITE TAILLE
                if (checked){
                    int pet = 25;
                    Intent petI = new Intent(settings.this, MainActivity.class);
                    petI.putExtra(EXTRA_SIZE, pet);
                    setResult(RESULT_OK, petI);
                    finish();

                }
                    // AFFICHAGE MOYEN
                    break;
            case R.id.radio_moyen:
                if (checked){
                    int moy = 48;
                    Intent moyI = new Intent(settings.this, MainActivity.class);
                    moyI.putExtra(EXTRA_SIZE, moy);
                    setResult(RESULT_OK, moyI);
                    finish();
                }
                    // AFFICHAGE GRANDE TAILLE
                    break;
            case R.id.radio_grand:
                if(checked){
                    int gran = 60;
                    Intent grands = new Intent(settings.this, MainActivity.class);
                    grands.putExtra(EXTRA_SIZE, gran);
                    setResult(RESULT_OK, grands);
                    finish();
                }
        }
    }


}