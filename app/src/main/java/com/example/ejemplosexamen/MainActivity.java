package com.example.ejemplosexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ejemplosexamen.fragmentos.Fragmento1;
import com.example.ejemplosexamen.fragmentos.Fragmento2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCambiar = null;
    Button btnFragmento1 = null;
    Button btnFragmento2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCambiar = findViewById(R.id.btnCambiar);
        btnCambiar.setOnClickListener(this);

        btnFragmento1 = findViewById(R.id.btnFragmento1);
        btnFragmento2 = findViewById(R.id.btnFragmento2);

        btnFragmento2.setOnClickListener(this);
        btnFragmento1.setOnClickListener(this);

    }

    @Override
    public void onClick(View click) {

        if ( click == btnCambiar){
            Intent intent = new Intent(this.getBaseContext(),SegundaActividad.class);
            intent.putExtra("nombre","Carolina");
            startActivity(intent);
        }else if(click == btnFragmento1){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainerView, Fragmento1.class, null)
                    .commit();
        }else if(click == btnFragmento2){
            Bundle bundle = new Bundle();
            bundle.putString("nombre","segundo fragmento desde bundle");
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainerView, Fragmento2.class, bundle)
                    .commit();
        }

    }
}