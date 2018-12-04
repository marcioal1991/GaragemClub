package com.example.marcioal1991.garagemclub;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void singIn(View view) {
        Banco con = new Banco(this);

        Cursor linhas = con.db.rawQuery("SELECT * FROM usuarios", null);

        String retorno = "";
        if(linhas.moveToFirst()){ //retorna false se não há linhas na tabela
            do{
                String ID = linhas.getString(0);
                String NOME = linhas.getString(1);
                String PLACA = linhas.getString(2);
                String ANO = linhas.getString(3);
                retorno+=ID+","+ NOME+","+PLACA+","+ANO+"\n";
            }
            while(linhas.moveToNext()); //laço até a última linha da tabela
        }
        System.out.println(retorno);
        con.db.close();

    }

    public void singUp(View view) {
        Intent it = new Intent(this, CadastrarUsuarioActivity.class);
        this.startActivity(it);
    }
}
