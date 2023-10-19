package org.app.dominio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Estado implements Serializable {
    private long id;
private String nome;

    public Estado(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public static Object[][]  fromJson(String body) {
        if (body.contains("content")){
            String[] linhas = body.split("content\":\\[")[1].split("]")[0].split("},");
            Object[][] estados = new Object[linhas.length][2];
            for (int i = 0; i < linhas.length; i++) {
                String[] colunas = linhas[i].split(",");
                for (int j = 0; j < colunas.length; j++) {
                    String[] atributo = colunas[j].split(":");
                    if (atributo[0].contains("id"))
                        estados[i][0] = atributo[1];
                    else if (atributo[0].contains("nome"))
                        estados[i][1] = atributo[1].replace("\"", "").replace("}", "");
                }
            }
            return estados;
        }
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toJson() {
        return "{" +
                "\"id\":" + id +
                ", \"nome\":\"" + nome + '\"' +
                '}';
    }
}
