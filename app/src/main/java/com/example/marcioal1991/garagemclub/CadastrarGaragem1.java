package com.example.marcioal1991.garagemclub;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

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

    public String cadastrarGaragem() {
        Banco con = new Banco(this);

        //Banco linhas = db.rawQuery("SELECT * FROM carro WHERE nome = '"+nome+"'", null);


        cep = et_cep.toString();
        estado = et_estado.toString();
        cidade = et_cidade.toString();
        bairro = et_bairro.toString();
        endereco = et_endereco.toString();
        descricao = et_endereco.toString();
        observacao = et_observacao.toString();
        tamanho = et_tamanho.toString();

        con.db.rawQuery("insert into garagens (cep, estado, cidade, bairro, endereco, descricao, observacao, tamanho) VALUES (" + cep + "," + estado + "," + cidade + "," + bairro + "," + endereco + "," + descricao + "," + observacao + "," + tamanho + ")",null);

        Cursor linhas = con.db.rawQuery("SELECT * FROM garagens", null);
        //poderia ser feito assim também:
        //Cursor linhas = db.rawQuery("SELECT * FROM carro WHERE nome = ?", new String[] { nome });

        String retorno = "";
        if(linhas.moveToFirst()){ //retorna false se não há linhas na tabela
            do{
                String id_garagens = linhas.getString();
            }
            while(linhas.moveToNext()); //laço até a última linha da tabela
        }
        con.db.close();



        return "teste";
    }
}

