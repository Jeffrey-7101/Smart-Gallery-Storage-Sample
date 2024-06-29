package com.example.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;


public class RegisterFragment extends Fragment {

    private EditText  editTextAutor, editTextTitulo, editTextTecnica, editTextCategoria,editTextDescripcion,editTextAno;
    private Button btnGuardar, btnCancelar;


    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_register, container, false);

        editTextAutor=view.findViewById(R.id.editTextAutor);
        editTextTitulo=view.findViewById(R.id. editTextTitulo);
        editTextTecnica=view.findViewById(R.id.editTextTecnica);
        editTextCategoria=view.findViewById(R.id.editTextCategoria);
        editTextDescripcion=view.findViewById(R.id.editTextDescripcion);
        editTextAno=view.findViewById(R.id.editTextAno);

        btnGuardar=view.findViewById(R.id.btnGuardar);
        btnCancelar=view.findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                editTextAutor.setText("");
                editTextTitulo.setText("");
                editTextTecnica.setText("");
                editTextCategoria.setText("");
                editTextDescripcion.setText("");
                editTextAno.setText("");
            }
        });


        return view;
    }

    private void guardarDatos(){
        String autor= editTextAutor.getText().toString();
        String titulo= editTextTitulo.getText().toString();
        String tecnica= editTextTecnica.getText().toString();
        String categoria= editTextCategoria.getText().toString();
        String descripcion= editTextDescripcion.getText().toString();
        String ano= editTextAno.getText().toString();

        String datos= autor + "," + titulo + "," + tecnica + "," + categoria + "," + descripcion + "," + ano;

        try {
            FileOutputStream fos= getContext().openFileOutput("pintura.txt", Context.MODE_PRIVATE);
            fos.write(datos.getBytes());
            fos.close();
            Toast.makeText(getContext(),"Datos Guardados",Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al guardar datos", Toast.LENGTH_SHORT).show();
        }
    }

}
