package com.example.intends;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// importando lo que se ocupa
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // ------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // ------------------------------------------------------------------------
        // instancia del boton + asignación visual
        Button botonUno = findViewById(R.id.button);
        // invocando el metodo para sobreescribirlo
        botonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // instancia del intent, pasarle parámetro del activity
                Intent intentactv = new Intent (MainActivity.this, MainActivity2.class);
                // iniciar actividad
                startActivity(intentactv);
            }
        });
        // ------------------------------------------------------------------------
        Button botonDos = findViewById(R.id.button2);
        botonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToast = new Intent ();
                Toast.makeText(getApplicationContext(),"Soy un mensaje", Toast.LENGTH_LONG).show();
            }
        });
        // ------------------------------------------------------------------------
        Button botonTres = findViewById(R.id.button3);
        botonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMagic = new Intent (MainActivity.this, MainActivity3.class);
                startActivity(intentMagic);
            }
        });
        // ------------------------------------------------------------------------
        Button botonCuatro = findViewById(R.id.button4);
        botonCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:25.5313316,-103.3233299"); //?????????
                Intent intentMapa = new Intent (Intent.ACTION_VIEW, location);
                if (intentMapa.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMapa);
                }
            }
        });
        // ------------------------------------------------------------------------
        Button botonCinco = findViewById(R.id.button5);
        botonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:25.5313316,-103.3233299"); //?????????
                Intent intentVirus = new Intent (Intent.ACTION_SENDTO);
                intentVirus.setData(Uri.parse("mailto:"));
                intentVirus.putExtra(Intent.EXTRA_EMAIL, new String[]{"23170055@utt.edu.mx"});
                intentVirus.putExtra(Intent.EXTRA_SUBJECT, "Virus");
                intentVirus.putExtra(Intent.EXTRA_TEXT, "Muahahahahahaha");
                if (intentVirus.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentVirus);
                }
            }
        });
        // ------------------------------------------------------------------------
        Button botonSeis = findViewById(R.id.button6);
        botonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLlamada = new Intent(Intent.ACTION_DIAL);
                intentLlamada.setData(Uri.parse("tel:911"));
                startActivity(intentLlamada);
            }
        });
    }
    }