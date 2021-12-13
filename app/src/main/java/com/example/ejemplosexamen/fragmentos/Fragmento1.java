package com.example.ejemplosexamen.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ejemplosexamen.R;



public class Fragmento1 extends Fragment implements View.OnClickListener{

    Button btnToast = null;

    public Fragmento1() {
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
        return inflater.inflate(R.layout.fragment_fragmento1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnToast = view.findViewById(R.id.btnToast);
        btnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnToast) {//Toas por defecto
            Toast toast = Toast.makeText(requireActivity().getApplicationContext(), "Mensaje Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();

            toastPersonalizado(); //Ejecucion de ambos toast simultaneos
        }
    }

    private void toastPersonalizado(){
        //Dos formas de consegir un Layout inflates, el asociado a la clase principal, o traves de un servicio
        //Del sistema
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        LayoutInflater inflater2 = (LayoutInflater) requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View toastPersonalizado = inflater.inflate(R.layout.custom_toast,null);
        //Atributos del toast
        Toast toast = new Toast(requireContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastPersonalizado);
        toast.show();//Muestra el toast
    }

}