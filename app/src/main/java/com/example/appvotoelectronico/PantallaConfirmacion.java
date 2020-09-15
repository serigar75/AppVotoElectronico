package com.example.appvotoelectronico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PantallaConfirmacion extends AppCompatActivity {
String candidaturaelegida,candidatoselegidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_confirmacion);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        candidaturaelegida = getIntent().getExtras().getString("Candidatura");
        candidatoselegidos = getIntent().getExtras().getString("Candidatos");
        int ressId = getResources().getIdentifier(candidaturaelegida , "drawable", getPackageName());
        AppCompatImageView iv = (AppCompatImageView)findViewById(R.id.imageView15);
        iv.setImageResource(ressId);
        TextView txtView = (TextView)findViewById(R.id.textView7);
        txtView.setText(candidatoselegidos);
    }

    public void VuelveVotacion(View view) {
        Intent intent = new Intent(this, PantallaVotacion.class);
        startActivity(intent);
    }
    public void ConfirmaVotacion(View view) {
            Intent intent = new Intent(this, PantallaFinal.class);
            startActivity(intent);
    }
}
