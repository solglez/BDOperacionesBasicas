package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Mostrar1Activity extends AppCompatActivity {
    private EditText etCodigo;
    private String DBname="DB_Alumnos";
    private SQLiteDatabase dbAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar1);
        etCodigo=findViewById(R.id.etCodigo);
        SQLiteOpenHelper aux=new SQLiteOpenHelper(this, DBname, null, 1);
        dbAlumnos=aux.getWritableDatabase();

    }
    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnConsultar1:
                try{
                    int cod=Integer.parseInt(etCodigo.getText().toString());
                    //Consulta con método específico -> query
                    String[] datosARecuperar={"nombre"};
                    Cursor cursor2=dbAlumnos.query("alumnos", datosARecuperar, "codigo="+String.valueOf(cod),null,null,null,null);
                    if(cursor2.moveToFirst()){ //Hay resultado
                        String strNombre=cursor2.getString(0); //Posición 0 porque solo recuperamos el nombre
                        Toast.makeText(this, "Nombre: "+strNombre, Toast.LENGTH_SHORT).show();
                    }else{ //Resultado vacío
                        Toast.makeText(this, "No he encontrado nada.", Toast.LENGTH_SHORT).show();
                    }
                    //HAY que cerrar el cursor
                    cursor2.close();
                }catch (Exception e){
                    Toast.makeText(this, "Ha ocurrido un error.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnMostrar1Volver:
                dbAlumnos.close();
                finish();
                break;
        }
    }
}