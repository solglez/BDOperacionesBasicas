package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActivity extends AppCompatActivity {
    private EditText etCodigo;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        etCodigo=findViewById(R.id.etCodigo);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnEliminar:
                try{
                    int cod=Integer.parseInt(etCodigo.getText().toString());
                    dbAlumnos.delete("alumnos", "codigo="+String.valueOf(cod), null);
                    Toast.makeText(this, "Borrado OK!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEliminarVolver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}