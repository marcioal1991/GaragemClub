package com.example.marcioal1991.garagemclub;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
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
    EditText et_valor;

    ImageButton foto;

    String cep;
    String estado;
    String cidade;
    String bairro;
    String endereco;
    String descricao;
    String observacao;
    String tamanho;
    String valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_garagem1);

        et_cep = (EditText) findViewById(R.id.et_cep);
        et_estado = (EditText) findViewById(R.id.et_estado);
        et_cidade = (EditText) findViewById(R.id.et_cidade);
        et_bairro = (EditText) findViewById(R.id.et_bairro);
        et_endereco = (EditText) findViewById(R.id.et_endereco);
        et_descricao = (EditText) findViewById(R.id.et_descricao);
        et_observacao = (EditText) findViewById(R.id.et_observacao);
        et_tamanho = (EditText) findViewById(R.id.et_tamanho);
        et_valor = (EditText) findViewById(R.id.et_valor);

        foto = (ImageButton) findViewById(R.id.ib_foto);
    }

    public void cadastrarGaragem() {
        Banco con = new Banco(this);

        cep = et_cep.getText().toString();
        estado = et_estado.getText().toString();
        cidade = et_cidade.getText().toString();
        bairro = et_bairro.getText().toString();
        endereco = et_endereco.getText().toString();
        descricao = et_descricao.getText().toString();
        observacao = et_observacao.getText().toString();
        tamanho = et_tamanho.getText().toString();
        valor = et_valor.getText().toString();
        double valorFloat = Float.parseFloat(valor);
        double tamanhoFloat = Float.parseFloat(tamanho);

        int userId = con.lastUserConnected();
        SQLiteStatement st = con.db.compileStatement(
     "insert into garagens (cep, estado, bairro, cidade, endereco, descricao, observacao, tamanho) values (?,?,?,?,?,?,?,?)");
        st.bindString(1, cep);
        st.bindString(2, estado);
        st.bindString(3, bairro);
        st.bindString(4, cidade);
        st.bindString(5, endereco);
        st.bindString(6, descricao);
        st.bindString(7, observacao);
        st.bindDouble(8, tamanhoFloat);
        st.bindDouble(9, valorFloat);
        st.bindLong(10, userId);
        st.execute();
        st.clearBindings();

        con.db.close();
        Toast.makeText(this, "Garagem cadastrada", Toast.LENGTH_SHORT).show();
//        return "teste";
    }
}

