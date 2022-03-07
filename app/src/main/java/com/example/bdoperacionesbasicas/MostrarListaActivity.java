package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MostrarListaActivity extends AppCompatActivity {
    private ListView lvUsuarios;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        lvUsuarios=findViewById(R.id.lvUsuarios);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();
        ArrayList<String> datosUsuarios=new ArrayList<>();
        try{
            String[] datosARecuperar={"codigo", "nombre"};
            Cursor c = dbAlumnos.query("alumnos", datosARecuperar, null,null,null,null,null,null);
            if (c.moveToFirst()) { //significa que se ha recuperado algo en la consulta
                //recorremos el cursor hasta que no haya más registros
                do {
                    int codigo = c.getInt(0);
                    String nombre = c.getString(1);
                    datosUsuarios.add(codigo+": "+nombre);
                }while (c.moveToNext());
                c.close();
            }

        }catch (Exception e){
            Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_LONG).show();
        }
        //String[] datos = (String[]) datosUsuarios.toArray();
        String[] datos = datosUsuarios.toArray(new String[0]);

        AdaptadorListado adaptadorPersonalizado=new AdaptadorListado(this, R.layout.fila_simple,
                 datos);
        lvUsuarios.setAdapter(adaptadorPersonalizado);

        //Listener una vez más:
        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MostrarListaActivity.this,
                        adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnListViewVolver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}