package com.example.activite1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button bouton;
    private TextView tv;
    private int cpt;

    @Override
    public void onBackPressed() {
        Log.i("CPT","passage dans onbackpressed");
        Intent intent =getIntent();
        intent.putExtra("counter",cpt);
        setResult(RESULT_OK,intent);
        super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_activite2);
        bouton =findViewById(R.id.bt);
        tv = findViewById(R.id.tv);

        if(savedInstanceState !=null){
            cpt = savedInstanceState.getInt("compteur",0);
            tv.setText(String.valueOf(cpt));
        }

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cpt++;

                tv.setText(String.valueOf(cpt));
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("compteur",cpt);
    }
}
