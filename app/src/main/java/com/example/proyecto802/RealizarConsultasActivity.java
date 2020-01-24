package com.example.proyecto802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class RealizarConsultasActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_consultas);

        listView = findViewById(R.id.listview);
        //TODO
        String [] resultados = {""};
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultados);
        listView.setAdapter(itemsAdapter);

    }

    public void realizarConsulta(View view) {

        EditText editText_Tabla = findViewById(R.id.editText_nombreTabla);
        EditText editText_query = findViewById(R.id.editText_query);

        //rawQuery acepta queries select

    }
}
