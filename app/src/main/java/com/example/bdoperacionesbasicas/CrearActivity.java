package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearActivity extends AppCompatActivity {
    private EditText etCodigo, etNombre;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        etCodigo=findViewById(R.id.etCodigo);
        etNombre=findViewById(R.id.etNombre);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();

    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnInsert:
                try{
                    String nombre=etNombre.getText().toString();
                    int cod=Integer.parseInt(etCodigo.getText().toString());
                    ContentValues nuevaTupla=new ContentValues();
                    nuevaTupla.put("codigo", cod);
                    nuevaTupla.put("nombre", nombre);
                    long l=dbAlumnos.insert("alumnos", null, nuevaTupla);
                    if (l!=0){
                        Toast.makeText(this, "Inserción OK!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Inserción... o más bien no.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnInsertVolver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}