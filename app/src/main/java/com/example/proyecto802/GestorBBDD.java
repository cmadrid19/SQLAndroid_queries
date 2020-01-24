package com.example.proyecto802;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GestorBBDD extends SQLiteOpenHelper {

    private static final String TAG = "GestorBBBD";
    private final String sqlCreacionTablaCoche = "CREATE TABLE COCHE (" +
            "id INTEGER PRIMARY KEY," +
            "matricula TEXT," +
            " marca TEXT," +
            " modelo TEXT," +
            " caballos INTEGER," +
            " color TEXT)";

    public GestorBBDD(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto,nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlCreacionTablaCoche);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int versionAnt,int versionNueva){
    }

    public String ejecutarSQL(String sentencia){

        String error = "La sentencia se ha ejecutado correctamente";
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.execSQL(sentencia);
        }
        catch (SQLiteException e){
            error = e.getMessage();
        }
        return error;
    }

    public List<Coche> buscarCoches (String consulta)
    {
        List<Coche> lista_coches = null;
        Coche coche = null;

        SQLiteDatabase basedatos = this.getReadableDatabase();
        Cursor cursor = basedatos.rawQuery(consulta, null);

        int id;
        String matricula = "";
        String marca = "";
        String modelo = "";
        int caballos = -1;
        String color = "";


        if( cursor != null && cursor.getCount() >0)
        {
            cursor.moveToFirst();
            lista_coches = new ArrayList<Coche>(cursor.getCount());

            do
            {

                id = cursor.getInt(0); //la posicion primera, el id
                matricula = cursor.getString(1);
                marca = cursor.getString(2);
                modelo = cursor.getString(3);
                caballos = cursor.getInt(4);
                color = cursor.getString(5);


                coche = new Coche(id, matricula, marca, modelo, caballos, color);
                Log.d(TAG, "Econtrado: "+coche.toString());
                lista_coches.add(coche);

            }while (cursor.moveToNext());

            cursor.close();
        }

        basedatos.close();

        return lista_coches;
    }
}
