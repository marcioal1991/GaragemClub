package com.example.marcioal1991.garagemclub;

import android.content.Intent;
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
        Intent it = new Intent(this, CadastrarUsuarioActivity.class);
        this.startActivity(it);
    }
}
