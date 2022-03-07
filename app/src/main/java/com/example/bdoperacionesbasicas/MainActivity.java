package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnInsertar, btnModificar,  btnEliminar, btnMostrar1, btnMostrarVarios, btnMostrarLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declarar();
    }

    public void onClickBtn(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnInsertar:
                intent=new Intent(this, CrearActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBorrar:
                intent=new Intent(this, EliminarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnModificar:
                intent=new Intent(this, ModificarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrar1:
                intent=new Intent(this, Mostrar1Activity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrarVarios:
                intent=new Intent(this, MostrarVariosActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrarLista:
                intent=new Intent(this, MostrarListaActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void declarar(){
        btnEliminar=findViewById(R.id.btnBorrar);
        btnInsertar=findViewById(R.id.btnInsertar);
        btnModificar=findViewById(R.id.btnModificar);
        btnMostrar1=findViewById(R.id.btnMostrar1);
        btnMostrarVarios=findViewById(R.id.btnMostrarVarios);
        btnMostrarLista=findViewById(R.id.btnMostrarLista);
    }
}