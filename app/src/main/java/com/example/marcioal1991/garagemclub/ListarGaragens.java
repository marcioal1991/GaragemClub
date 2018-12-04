package com.example.marcioal1991.garagemclub;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yuri on 02/12/2018.
 */

public class ListarGaragens extends AppCompatActivity {
    private LinearLayout mainLayout = null;
    private Banco con = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_garagens);

        this.mainLayout = this.findViewById(R.id.mainLayout);
        this.con = new Banco(this);
    }

    public void cadastrarGaragem(View view)
    {
        Intent it = new Intent(this, CadastrarGaragem1.class);
        startActivity(it);
    }

    protected void showGarages() {
        Cursor linhas = this.con.db.rawQuery("SELECT endereco, cidade, bairro, estado, cep, tamanho, valor  FROM garagens", null);

        if(linhas.moveToFirst()){
            do{

                String endereco = linhas.getString(0);
                String cidade = linhas.getString(1);
                String bairro = linhas.getString(2);
                String estado = linhas.getString(3);
                String cep = linhas.getString(4);
                float tamanho = linhas.getFloat(5);
                float valor = linhas.getFloat(6);


                LinearLayout l = new LinearLayout(this);
                l.setOrientation(LinearLayout.VERTICAL);
                l.setPadding(5,5,5,5);

                TextView estadoCidade = new TextView(this);
                TextView valorView = new TextView(this);
                TextView tamanhoView = new TextView(this);

                estadoCidade.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));;
                estadoCidade.setText("Localização: " + estado + ", " + cidade + ", " + bairro + ", " + endereco + ", " + cep);
                estadoCidade.setPadding(0,3,0,3);

                valorView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));;
                valorView.setText("Valor: R$ " + valor);
                valorView.setPadding(0,3,0,3);

                tamanhoView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));;
                tamanhoView.setText("Tamanh: R$ " + tamanho);
                tamanhoView.setPadding(0,3,0,3);

                l.addView(tamanhoView);
                l.addView(valorView);
                l.addView(estadoCidade);

                this.mainLayout.addView(l);



            }
            while(linhas.moveToNext());
        } else {
            Toast.makeText(this, "Nenhuma garagem encontrada", Toast.LENGTH_SHORT).show();
        }
    }

}
