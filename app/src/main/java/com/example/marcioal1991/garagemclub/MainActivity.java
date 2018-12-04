package com.example.marcioal1991.garagemclub;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
    }


    public void singIn(View view) {
        Banco con = new Banco(this);

        if (login.getText().toString().equals("")) {
            String texto = "Insira o login";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, texto,duracao);
            toast.show();
            return;
        }

        if (password.getText().toString().equals("")) {
            String texto = "Insira a senha";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, texto,duracao);
            toast.show();
            return;
        }

        Cursor linhas = con.db.rawQuery("SELECT count(*) as total FROM usuarios WHERE login = '" + login.getText().toString() + "' AND senha = '" + password.getText().toString() + "'"
                , null);

        if(linhas.moveToFirst()) { //retorna false se não há linhas na tabela
            if ( linhas.getInt(0) > 0) {
                System.out.println("teste passou");
            } else  {
                String texto = "Login ou senha inválidos";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this, texto,duracao);
                toast.show();
            }
        }

        con.db.close();

    }

    public void singUp(View view) {
        Banco con = new Banco(this);
        System.out.println("teste");
        //Cursor insert = con.db.rawQuery("insert into usuarios (login,senha,email) values ('teste','1234','teste@teste.com')", null);
        Cursor linhas = con.db.rawQuery("SELECT * FROM usuarios", null);
        System.out.println("teste2");
        String retorno = "";
        if(linhas.moveToFirst()){ //retorna false se não há linhas na tabela
            do{
                String ID = linhas.getString(0);
                String LOGIN = linhas.getString(1);
                String SENHA = linhas.getString(2);
                String EMAIL = linhas.getString(3);
                retorno +=ID+","+ LOGIN+","+SENHA+","+EMAIL+"\n";
                System.out.println(retorno);
            }
            while(linhas.moveToNext()); //laço até a última linha da tabela
        }
        con.db.close();
    }
}
