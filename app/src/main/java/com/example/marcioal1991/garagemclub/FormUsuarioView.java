package com.example.marcioal1991.garagemclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class FormUsuarioView extends AppCompatActivity {

    EditText et_nome;
    EditText et_data_nascimento;
    EditText et_estado_civil;
    EditText et_cpf;
    EditText et_cep;
    EditText et_cidade;
    EditText et_bairro;
    EditText et_endereco;
    EditText et_telefone;

    RadioButton rb_masculino;
    RadioButton rb_feminino;

    ImageButton img_foto;


    String nome;
    String data_nascimento;
    String estado_civil;
    String cpf;
    String cep;
    String cidade;
    String bairro;
    String endereco;
    String telefone;

    String masculino;
    String feminino;

    ImageButton foto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_usuario_view);

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_data_nascimento = (EditText) findViewById(R.id.et_data_nascimento);
        et_estado_civil = (EditText) findViewById(R.id.et_estado_civil);
        et_cpf = (EditText) findViewById(R.id.et_cpf);
        et_cep = (EditText) findViewById(R.id.et_cep);
        et_cidade = (EditText) findViewById(R.id.et_cidade);
        et_bairro = (EditText) findViewById(R.id.et_bairro);
        et_endereco = (EditText) findViewById(R.id.et_endereco);
        et_telefone = (EditText) findViewById(R.id.et_telefone);

        rb_masculino = (RadioButton) findViewById(R.id.rb_masculino);
        rb_feminino = (RadioButton) findViewById(R.id.rb_feminino);

        img_foto = (ImageButton) findViewById(R.id.ib_foto);
    }

    public void submitForm(View view) {

        nome = et_nome.getText().toString();
        data_nascimento = et_data_nascimento.getText().toString();
        estado_civil = et_estado_civil.getText().toString();
        cpf = et_cpf.getText().toString();
        cep = et_cep.getText().toString();
        cidade = et_cidade.getText().toString();
        bairro = et_bairro.getText().toString();
        endereco = et_endereco.getText().toString();
        telefone = et_telefone.getText().toString();
        masculino = rb_masculino.getText().toString();
        feminino = rb_feminino.getText().toString();
    }
}
