package org.app.repository;

import org.app.config.Configuracoes;
import org.app.dominio.Municipio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MunicipioRepositorio {
    public Object[][] listar(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/municipio"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return Municipio.fromJson(response.body());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
