package com.example.marcioal1991.garagemclub;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CadastrarUsuarioActivity extends Activity {
    private EditText loginInput = null;
    private EditText senhaInput = null;
    private EditText emailInput = null;
    private EditText nomeInput = null;
    private EditText nascimentoInput = null;
    private EditText cpfInput = null;
    private EditText rgInput = null;
    private EditText cepInput = null;
    private EditText estadoInput = null;
    private EditText cidadeInput = null;
    private EditText bairroInput = null;
    private EditText enderecoInput = null;
    private EditText telefoneInput = null;
    private RadioGroup sexoRadio = null;
    private Banco db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        this.loginInput = this.findViewById(R.id.loginInput);
        this.senhaInput = this.findViewById(R.id.senhaInput);
        this.nomeInput = this.findViewById(R.id.nomeInput);
        this.emailInput = this.findViewById(R.id.emailInput);
        this.nascimentoInput = this.findViewById(R.id.nascimentoInput);
        this.cpfInput = this.findViewById(R.id.cpfInput);
        this.rgInput = this.findViewById(R.id.rgInput);
        this.cepInput = this.findViewById(R.id.cepInput);
        this.estadoInput = this.findViewById(R.id.estadoInput);
        this.cidadeInput = this.findViewById(R.id.cidadeInput);
        this.bairroInput = this.findViewById(R.id.bairroInput);
        this.enderecoInput = this.findViewById(R.id.enderecoInput);
        this.telefoneInput = this.findViewById(R.id.telefoneInput);
        this.sexoRadio = this.findViewById(R.id.sexoRadioGroup);
        this.db = new Banco(this);
    }

    protected boolean validate() {
        return !this.loginInput.getText().toString().equals("") &&
                !this.senhaInput.getText().toString().equals("") &&
                !this.emailInput.getText().toString().equals("") &&
                !this.nomeInput.getText().toString().equals("") &&
                !this.nascimentoInput.getText().toString().equals("") &&
                !this.cpfInput.getText().toString().equals("") &&
                !this.rgInput.getText().toString().equals("") &&
                !this.cepInput.getText().toString().equals("") &&
                !this.cidadeInput.getText().toString().equals("") &&
                !this.estadoInput.getText().toString().equals("") &&
                !this.bairroInput.getText().toString().equals("") &&
                !this.enderecoInput.getText().toString().equals("") &&
                !this.telefoneInput.getText().toString().equals("") &&
                this.sexoRadio.getCheckedRadioButtonId() != 0;
    }

    public void cadastrar() {
        if (!this.validate()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteStatement st = db.db.compileStatement("insert into usuarios(login, senha, email) values (?,?,?)");
        st.bindString(1, this.loginInput.getText().toString());
        st.bindString(2, this.senhaInput.getText().toString());
        st.bindString(3, this.emailInput.getText().toString());
        st.execute();
        st.clearBindings();

        Cursor linhas = db.db.rawQuery("SELECT id FROM usuarios ORDER BY id DESC LIMIT 1", null);

        int user_id = 0;
        if (linhas.moveToFirst()) {
            user_id = linhas.getInt(0);
        }

        st = db.db.compileStatement("insert into pessoas (usuario_id, nome, sexo, data_nascimento, rg, cpf, endereco, cidade, bairro, estado, cep, telefone_fixo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

        RadioButton radio = this.findViewById(this.sexoRadio.getCheckedRadioButtonId());
        st.bindLong(1, user_id );
        st.bindString(2, this.nomeInput.getText().toString() );
        st.bindString(3, radio.getText().toString() );
        st.bindString(4, this.nascimentoInput.getText().toString());
        st.bindString(5, this.rgInput.getText().toString());
        st.bindString(6, this.cpfInput.getText().toString());
        st.bindString(7, this.enderecoInput.getText().toString());
        st.bindString(8, this.cidadeInput.getText().toString());
        st.bindString(9, this.bairroInput.getText().toString());
        st.bindString(10, this.estadoInput.getText().toString());
        st.bindString(11, this.cepInput.getText().toString());
        st.bindString(12, this.telefoneInput.getText().toString());

        st.execute();
        st.clearBindings();

        Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
    }
}
