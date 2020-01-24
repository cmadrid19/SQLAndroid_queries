package com.example.proyecto802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EjecutarSQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejecutar_sql);



    }

    public void ejecutar(View vista){
        EditText nombreBBDD = findViewById(R.id.etNombreBBDD);
        EditText sentencia = findViewById(R.id.etSQL);
        TextView tResultado = findViewById(R.id.tResultado);

        GestorBBDD gestor = new GestorBBDD(this, nombreBBDD.getText().toString(),null,1);
        if (!sentencia.getText().toString().equals("")){
            String resultado = gestor.ejecutarSQL(sentencia.getText().toString());
            tResultado.setText(resultado);
        }
        else{
            tResultado.setText("BBDD "+nombreBBDD.getText().toString()+" creada!");
        }
        gestor.close();
        // Idealmente, el objeto gestor debería crearse como variable de clase
        // y cerrarse al cerrar la aplicación (onDestroy) o cuando no se vaya a usar más
    }

}
