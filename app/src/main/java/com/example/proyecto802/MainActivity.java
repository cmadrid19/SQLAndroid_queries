package com.example.proyecto802;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ejecutarSQL:
                Intent intent = new Intent(this, EjecutarSQLActivity.class);
                startActivity(intent);
                break;
            case R.id.realizarConsulta:
                Intent intent1 = new Intent(this, RealizarConsultasActivity.class);
                startActivity(intent1);
                break;
            case R.id.Salir:
                finish();
                break;
            default:
                //TODO
        }
        return true;
    }



}
