package com.example.marcioal1991.garagemclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yuri on 02/12/2018.
 */

public class ListarGaragens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_garagens);

        List<Garagem> garagens = buscarTodasGaragens();

        ListView listaGaragens = (ListView) findViewById(R.id.listaGaragens);

        ArrayAdapter<Garagem> adapter = new ArrayAdapter<Garagem>(this, android.R.layout.simple_list_item_1);

        listaGaragens.setAdapter(adapter);
    }

    public List<Garagem> buscarTodasGaragens() {
        try {
            List<Garagem> garagens = new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
