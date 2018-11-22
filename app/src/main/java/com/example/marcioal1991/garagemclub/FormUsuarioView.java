package com.example.marcioal1991.garagemclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class FormUsuarioView extends AppCompatActivity {

    EditText nome;
    EditText data_nascimento;
    EditText estado_civil;
    EditText cpf;
    EditText cep;
    EditText cidade;
    EditText bairro;
    EditText endereco;
    EditText telefone;

    RadioButton masculino;
    RadioButton feminino;

    ImageButton foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_usuario_view);

        nome = (EditText) findViewById(R.id.et_nome);
        data_nascimento = (EditText) findViewById(R.id.et_data_nascimento);
        estado_civil = (EditText) findViewById(R.id.et_estado_civil);
        cpf = (EditText) findViewById(R.id.et_cpf);
        cep = (EditText) findViewById(R.id.et_cep);
        cidade = (EditText) findViewById(R.id.et_cidade);
        bairro = (EditText) findViewById(R.id.et_bairro);
        endereco = (EditText) findViewById(R.id.et_endereco);
        telefone = (EditText) findViewById(R.id.et_telefone);

        masculino = (RadioButton) findViewById(R.id.rb_masculino);
        feminino = (RadioButton) findViewById(R.id.rb_feminino);

        foto = (ImageButton) findViewById(R.id.ib_foto);
    }



}
