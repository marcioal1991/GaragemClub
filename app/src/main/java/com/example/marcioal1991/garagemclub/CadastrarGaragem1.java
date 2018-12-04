package com.example.marcioal1991.garagemclub;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadastrarGaragem1 extends AppCompatActivity {

    EditText et_cep;
    EditText et_estado;
    EditText et_cidade;
    EditText et_bairro;
    EditText et_endereco;
    EditText et_descricao;
    EditText et_observacao;
    EditText et_tamanho;

    ImageButton foto;

    String cep;
    String estado;
    String cidade;
    String bairro;
    String endereco;
    String descricao;
    String observacao;
    String tamanho;

    private Banco db = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_garagem1);

        //Banco this.db = new Banco(this);


        //Edit Text
        et_cep = (EditText) findViewById(R.id.et_cep);
        et_estado = (EditText) findViewById(R.id.et_estado);
        et_cidade = (EditText) findViewById(R.id.et_cidade);
        et_bairro = (EditText) findViewById(R.id.et_bairro);
        et_endereco = (EditText) findViewById(R.id.et_endereco);
        et_descricao = (EditText) findViewById(R.id.et_descricao);
        et_observacao = (EditText) findViewById(R.id.et_observacao);
        et_tamanho = (EditText) findViewById(R.id.et_tamanho);

        //Image Button
        foto = (ImageButton) findViewById(R.id.ib_foto);
    }

    public void cadastrarGaragem(View view) {
        cep = et_cep.toString();
        estado = et_estado.getText().toString();
        cidade = et_cidade.getText().toString();
        bairro = et_bairro.getText().toString();
        endereco = et_endereco.getText().toString();
        descricao = et_endereco.getText().toString();
        observacao = et_observacao.getText().toString();
        tamanho = et_tamanho.getText().toString();

        Cursor linhas = db.db.rawQuery("SELECT id FROM garagens ORDER BY id DESC LIMIT 1", null);

        int proprietario_id = 0;
        if (linhas.moveToFirst()) {
            proprietario_id = linhas.getInt(0);
        }

        SQLiteStatement st = db.db.compileStatement("insert into pessoas (proprietario_id, cep, estado, cidade, bairro, endereco, descricao, observacao, tamanho) VALUES (?,?,?,?,?,?,?,?,?)");

        st.bindLong(1, proprietario_id);
        st.bindString(2, cep);
        st.bindString(3, estado);
        st.bindString(4, cidade);
        st.bindString(5, bairro);
        st.bindString(6, endereco);
        st.bindString(7, descricao);
        st.bindString(8, observacao);
        st.bindString(9, tamanho);

        st.execute();
        st.clearBindings();

        Toast.makeText(this, "Garagem Cadastrada", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}

