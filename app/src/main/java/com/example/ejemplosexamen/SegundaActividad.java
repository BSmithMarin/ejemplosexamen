package com.example.ejemplosexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    TextView tvMensaje = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        String mensaje = getIntent().getStringExtra("nombre");

        tvMensaje = findViewById(R.id.tvMensaje);
        tvMensaje.setText(mensaje);

    }
}