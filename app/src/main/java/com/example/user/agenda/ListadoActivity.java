package com.example.user.agenda;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<Contacto> miagenda;
        ListView lstContactos;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        DBContactos gestion=new DBContactos(this);
        Cursor cur=gestion.recuperarContactos();
        //recupera ListView
        lstContactos=(ListView)this.findViewById(R.id.lstContactos);
        String [] columns=new String[]{"nombre","email","edad"};
        //crea adaptador y lo asigna a la lista
        SimpleCursorAdapter sc= new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cur,
                columns,
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lstContactos.setAdapter(sc);
        gestion.close();
    }


       public void salir(View view){
        this.finish();
    }
}




