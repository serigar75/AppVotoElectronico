package com.example.appvotoelectronico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class PantallaVotacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_votacion);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Candidatura[] candidaturas = new Candidatura[12];
        candidaturas[0] = new Candidatura(0, "Animalista", "animalista","1. María de los Llanos Soriano García.\n2. Juan Carlos Castañeda Diehl.\n3. Sandra Argudo Rodríguez.\n4. David Abidanza González.");
        candidaturas[1] = new Candidatura(1, "Ciudadanos", "ciudadanos","1. María Dolores Arteaga Espinosa de los Monteros (Independiente).\n2. Hugo Gabriel Guillen Malagón.\n3. Ana Isabel Martínez Molina.\n4. Cristian Cuerda González.");
        candidaturas[2] = new Candidatura(2, "Partido Comunista", "comunista","1. Jesús Molina Valera.\n2. María Rosario Martínez Valverde.\n3. Juan Carlos Rodríguez Domínguez.\n4. María Teresa Cases Martínez.");
        candidaturas[3] = new Candidatura(3, "Comunistas Trabajadores", "comunistatrabajadores","1. Jesús Cózar Calderón.\n2. Irene Gracia Redondo.\n3. Carlos Molina Villanueva.\n4. Bárbara Marín Prada.");
        candidaturas[4] = new Candidatura(4, "Jubilados", "jubilados","1. José Antonio Maciá Gómez.\n2. Silvia Lazausa Julve.\n3. Nemesio Rodríguez Álvarez.\n4. Josefa Antonia Alor Olmo.");
        candidaturas[5] = new Candidatura(5, "Mundojusto", "mundojusto","1. Alberto Martínez Cuartero.\n2. María Pilar Mora Lizan.\n3. Carlos Villarias Castedo.\n4. Ángeles Cuartero Marqueño.");
        candidaturas[6] = new Candidatura(6, "Podemos", "podemos","1. María Pérez Segovia.\n2. Emilio Zamora Martínez.\n3. Darcy Gioconda Cárdenas Barrera.\n4. Sergio León Bullón.");
        candidaturas[7] = new Candidatura(7, "Pp", "pp","1. María Carmen Navarro Lacoba.\n2. Manuel Ramón Serrano López.\n3. Manuel Serena Fernández.\n4. Cristina Garcia Martínez.");
        candidaturas[8] = new Candidatura(8, "Psoe", "psoe","1. Manuel Gabriel González Ramos.\n2. María Luisa Vilches Ruiz.\n3. José Carlos Díaz Rodríguez.\n4. Estefanía Escribano Villena.");
        candidaturas[9] = new Candidatura(9, "Recortescero", "recortescero","1. Ginesa Martínez Sánchez.\n2. Damián Sánchez Núnez.\n3. Josefa Ros López.\n4. Guillermo Hernández Uría (PCAS-TC).");
        candidaturas[10] = new Candidatura(10, "Votoblanco", "votoblanco","1. Sin candidato\n2. Sin candidato\n3. Sin candidato\n4. Sin candidato\n");
        candidaturas[11] = new Candidatura(11, "Vox", "vox","1. Rafael Fernández-Lomana Gutiérrez.\n2. Juan Francisco Robles Descalzo.\n3. María Remedios Gil Martínez.\n4. María Teresa Fernández Lara.");

        /* Aprovisionamiento numeros aleatorios sin repeticiones en lista */
        Set<Integer> ints = new LinkedHashSet<>();
        Random rand = new Random();
        Integer numrandom ;
        while( ints.size() < 12 ) {
            numrandom = rand.nextInt(12);
            if ( ! ints.contains(numrandom) ) {ints.add(numrandom);}
        }
        /*TextView mTextView = (TextView) findViewById(R.id.textView7);
        mTextView.setText(Arrays.toString(ints.toArray()));
        TextView m2TextView = (TextView) findViewById(R.id.textView6);
        m2TextView.setText(itr.next().toString());*/


        Iterator itr = ints.iterator();
        AppCompatImageView imagenmostrada;
        String mDrawableName, imagenID;
        Integer aux;


        for(int i=1; i<13; i++) {
                imagenID = "imageView" + i;
                int resID = this.getResources().getIdentifier(imagenID, "id",  getPackageName());
                imagenmostrada = (AppCompatImageView)findViewById(resID);
                aux = Integer.parseInt(itr.next().toString());
                mDrawableName = candidaturas[aux].Imagen;

                //TextView m2TextView = (TextView) findViewById(R.id.textView6);
                //m2TextView.setText(imagenID);
                //imagenmostrada = (AppCompatImageView)findViewById(R.id.imageView0);

                int ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                imagenmostrada.setImageResource(ressId);

            //final Integer finalAux = aux;
            final String finalAux = candidaturas[aux].Imagen;
            final String finalAux2 = candidaturas[aux].Candidatos;
            imagenmostrada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PantallaVotacion.this, PantallaConfirmacion.class);
                    //There is no limit for number of Extras you want to pass to activity
                    intent.putExtra("Candidatura", finalAux);
                    intent.putExtra("Candidatos", finalAux2);
                    startActivity(intent);
                }

        });

        }
/*
        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        int ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView0);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView1);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);


        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView2);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView3);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView4);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView5);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView6);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView7);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView8);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView9);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView10);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView11);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        aux = Integer.parseInt(itr.next().toString());
        mDrawableName = candidaturas[aux].Imagen;
        ressId = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        iv = (AppCompatImageView)findViewById(R.id.imageView12);
        iv.setImageResource(ressId);
        iv.setTag(candidaturas[aux].idCandidatura);

        //final Integer finalAux = aux;
        final String finalAux = candidaturas[aux].Imagen;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( PantallaVotacion.this, PantallaConfirmacion.class);
                //There is no limit for number of Extras you want to pass to activity
                intent.putExtra("Candidatura", finalAux);
                startActivity(intent);
            }
        });*/
    }

    //public void SeleccionaVotacion(View view) {
        /*Intent intent = new Intent(this, PantallaConfirmacion.class);
        intent.putExtra("Candidatura",candidaturas[aux].idCandidatura)
        //startActivity(intent);
        TextView m2TextView = (TextView) findViewById(R.id.textView6);
        Integer identi = view.getId();
        AppCompatImageView iv = (AppCompatImageView)findViewById(identi);
        if (iv.getTag(0) = null) {
             m2TextView.setText("nulo");}
            else {m2TextView.setText("no nulo");}
            //String a = iv.getTag(0).toString();
        //m2TextView.setText(view.getTag(0).toString());
        //m2TextView.setText(a);
    }*/

}
