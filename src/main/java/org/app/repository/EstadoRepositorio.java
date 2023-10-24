package org.app.repository;

import org.app.config.Configuracoes;
import org.app.dominio.Estado;

import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class EstadoRepositorio implements Serializable {

    public static void cadastrar(Estado estado){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/estado"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(estado.toJson()))
                .build();
    }
    public EstadoRepositorio(){

    }
    public Object[][] listarTodos(){
       Object[][] estados = null;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/listarEstados"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if(status == 200){
                String body = response.body();
                estados = Estado.fromJson(body);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }
}
