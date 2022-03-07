package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarVariosActivity extends AppCompatActivity {
    private TextView tvLista;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    private String listado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_varios);
        tvLista=findViewById(R.id.tvLista);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();
        try{
            String[] datosARecuperar={"codigo", "nombre"};
            Cursor c = dbAlumnos.query("alumnos", datosARecuperar, null,null,null,null,null,null);
            if (c.moveToFirst()) { //significa que se ha recuperado algo en la consulta
                //recorremos el cursor hasta que no haya más registros
                do {
                    int codigo = c.getInt(0);
                    String nombre = c.getString(1);
                    listado=listado+(codigo+": "+nombre+"\n");
                }while (c.moveToNext());
                c.close();
            }
            else
                Toast.makeText(this, "Usuario inexistente", Toast.LENGTH_LONG).show();

        }catch(Exception e){

        }
        tvLista.setText(listado);
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnConsultarVariosVolver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}