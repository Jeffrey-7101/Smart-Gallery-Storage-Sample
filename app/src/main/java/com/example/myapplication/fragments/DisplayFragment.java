package com.example.myapplication.fragments;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayFragment extends Fragment {
    private TextView textViewDatos;

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(String param1, String param2) {
        DisplayFragment fragment = new DisplayFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_display, container, false);
        textViewDatos= view.findViewById(R.id.textViewDatos);
        cargarDatos();
        return view;
    }

    private void cargarDatos() {
        try {
            FileInputStream fis = getContext().openFileInput("pintura.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String datos = reader.readLine();
            reader.close();
            fis.close();

            if (datos != null) {
                String[] partes = datos.split(",");
                StringBuilder sb = new StringBuilder();
                sb.append("Autor: ").append(partes[0]).append("\n");
                sb.append("Título: ").append(partes[1]).append("\n");
                sb.append("Técnica: ").append(partes[2]).append("\n");
                sb.append("Categoría: ").append(partes[3]).append("\n");
                sb.append("Descripción: ").append(partes[4]).append("\n");
                sb.append("Año: ").append(partes[5]).append("\n");

                textViewDatos.setText(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error al cargar datos", Toast.LENGTH_SHORT).show();
        }
    }

}