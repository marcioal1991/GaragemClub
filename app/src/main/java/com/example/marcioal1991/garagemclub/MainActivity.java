package com.example.marcioal1991.garagemclub;

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
        Banco con = new Banco(this);
        System.out.println("teste");
        Cursor insert = con.db.rawQuery("insert into usuarios (login,senha,email) values ('teste','1234','teste@teste.com')", null);
        Cursor linhas = con.db.rawQuery("SELECT * FROM usuarios", null);
        System.out.println("teste2");
        String retorno = "";
        System.out.println(linhas.getColumnName(0));
        if(linhas.moveToFirst()){ //retorna false se não há linhas na tabela
            do{
                //String ID = linhas.getString(0);
                //String NOME = linhas.getString(1);
                //String PLACA = linhas.getString(2);
                //String ANO = linhas.getString(3);
                //retorno+=ID+","+ NOME+","+PLACA+","+ANO+"\n";
                System.out.println(linhas.getString(0));
                System.out.println(linhas.getString(1));
                System.out.println(linhas.getString(2));
            }
            while(linhas.moveToNext()); //laço até a última linha da tabela
        }
        System.out.println(retorno);
        con.db.close();
    }
}
