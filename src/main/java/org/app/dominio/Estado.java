package org.app.dominio;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class Estado implements Serializable {
    private long id;
private String nome;

    public Estado(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estado(HttpResponse<String> response) {
        String json = response.body();

        Gson gson = new Gson();
        Estado estado = gson.fromJson(json, Estado.class);
        this.nome = estado.getNome();
        this.id = estado.getId();
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
            Gson gson = new Gson();

            String[] linhas = body.split("content\":\\[")[1].split("]")[0].split("},*");

            List<Estado> list = new ArrayList<>();
            for (String s: linhas){
                Estado estado = gson.fromJson(s+"}", Estado.class);
                list.add(estado);
            }
            Object[][] estados = new Object[linhas.length][2];

            for (int i = 0; i < linhas.length; i++) {
                estados[i][0] = list.get(i).getId();
                estados[i][1] = list.get(i).getNome();
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
