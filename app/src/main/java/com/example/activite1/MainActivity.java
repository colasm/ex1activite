package com.example.activite1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bouton;
    private int cpt = 0;
    private final static int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bouton = findViewById(R.id.button);
        bouton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) { Intent intent = new Intent(this, SecondActivity.class);
    intent.putExtra("counter",cpt);
    startActivityForResult(intent,REQUESTCODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("CPT","passage dans onresult avant if");
        if(requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Log.i("CPT","passage dans onresult");
            cpt = data.getIntExtra("counter",3);
            bouton.setText(String.valueOf(cpt));
        }
    }

}

