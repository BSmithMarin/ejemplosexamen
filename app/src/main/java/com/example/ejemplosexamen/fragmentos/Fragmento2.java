package com.example.ejemplosexamen.fragmentos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejemplosexamen.R;


public class Fragmento2 extends Fragment implements View.OnClickListener{

    TextView tvMensaje = null;
    Button btnAlertDialog = null;

    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvMensaje = view.findViewById(R.id.tvMensaje);
        tvMensaje.setText(getArguments().getString("nombre"));

        btnAlertDialog = view.findViewById(R.id.btnAlertDialog);
        btnAlertDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if ( v == btnAlertDialog ){
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setMessage("Mensaje Dialogo");
                builder.setTitle("TITULO TODO MOLON");
                builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tvMensaje.setText("Pulsado boton aceptar");
                }
            });
            //Sin lambda
            builder.setNegativeButton("Cancelar",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tvMensaje.setText("Pulsado boton CANCELAR");
                }
            });
            //Con lambdas
            builder.setNeutralButton("Ignorar", (dialog, which) -> tvMensaje.setText("Pulsado boton NEUTRAL"));


            //Crea y muestra venta de dialogo
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }

    }
}