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


        // ---------------------------------------------------

    }
    }