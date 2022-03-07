package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarActivity extends AppCompatActivity {
    private EditText etCodigo, etNombre;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        etCodigo=findViewById(R.id.etCodigo);
        etNombre=findViewById(R.id.etNombre);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnModificar:
                try{
                    String nombre=etNombre.getText().toString();
                    int cod=Integer.parseInt(etCodigo.getText().toString());
                    ContentValues tuplaMod=new ContentValues();
                    tuplaMod.put("nombre", nombre);
                    dbAlumnos.update("alumnos", tuplaMod, "codigo="+String.valueOf(cod),null);
                    Toast.makeText(this, "Modificación OK!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnModificarVolver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}