package com.example.marcioal1991.garagemclub;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Banco {
    Context ctx = null;
    private SQLiteDatabase db;

    public Banco(Context ctx) {
        this.ctx = ctx;
        this.db = this.ctx.openOrCreateDatabase("garagem_club", Context.MODE_PRIVATE,null);

        this.db.execSQL(
                "CREATE TABLE IF NOT EXISTS garagem_club.usuarios (\n" +
                "  id INTEGER NOT NULL PRIMARY KEY,\n" +
                "  login TEXT NOT NULL,\n" +
                "  senha TEXT NOT NULL,\n" +
                "  email TEXT NOT NULL);"
        );

        this.db.execSQL(
                "CREATE TABLE IF NOT EXISTS session (\n" +
                        "  id INTEGER NOT NULL PRIMARY KEY,\n" +
                        "  user_id TEXT NOT NULL);"
        );

        this.db.execSQL(
                "CREATE TABLE IF NOT EXISTS pessoas (\n" +
                        "  id INTEGER NOT NULL PRIMARY KEY,\n" +
                        "  usuario_id INTEGER NOT NULL,\n" +
                        "  nome TEXT NOT NULL,\n" +
                        "  sexo TEXT NOT NULL,\n" +
                        "  data_nascimento TEXT NOT NULL,\n" +
                        "  estado_civil TEXT NOT NULL,\n" +
                        "  cliente INTEGER NOT NULL DEFAULT 0,\n" +
                        "  proprietario INTEGER NOT NULL DEFAULT 0,\n" +
                        "  rg TEXT NOT NULL,\n" +
                        "  cpf TEXT NOT NULL,\n" +
                        "  endereco TEXT NOT NULL,\n" +
                        "  cidade TEXT NOT NULL,\n" +
                        "  bairro TEXT NOT NULL,\n" +
                        "  estado TEXT NOT NULL DEFAULT 'RS',\n" +
                        "  cep TEXT NOT NULL,\n" +
                        "  telefone_fixo TEXT NOT NULL,\n" +
                        "  telefone_celular TEXT NOT NULL,\n" +
                        "  foto TEXT NOT NULL);"
        );

        this.db.execSQL(
                "CREATE TABLE IF NOT EXISTS garagem_club.`garagens` (\n" +
                        "    id INTEGER NOT NULL PRIMARY KEY,\n" +
                        "    proprietario_id INTEGER NOT NULL,\n" +
                        "    cliente_id INTEGER NOT NULL,\n" +
                        "    endereco TEXT NOT NULL,\n" +
                        "    cidade TEXT NOT NULL,\n" +
                        "    bairro TEXT NOT NULL,\n" +
                        "    estado TEXT NOT NULL,\n" +
                        "    cep TEXT NOT NULL,\n" +
                        "    tamanho INTEGER NOT NULL,\n" +
                        "    descricao TEXT NOT NULL,\n" +
                        "    observacao TEXT NOT NULL,\n" +
                        "    foto TEXT NOT NULL,\n" +
                        "    valor INTEGER NOT NULL);"
        );
    }


    public int lastUserConnected() {
        Cursor linhas = db.rawQuery("SELECT user_id FROM session ORDER BY id DESC LIMIT 1", null);

        String retorno = "";
        if(linhas.moveToFirst()){
            do{
                return linhas.getInt(0);
            }
            while(linhas.moveToNext());
        }

        return 0;
    }
}
