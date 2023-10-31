package org.app.repository;

import com.google.gson.Gson;
import org.app.config.Configuracoes;
import org.app.dominio.Cliente;
import org.app.dominio.Municipio;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

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

    public Optional<Municipio> encontrarPorId(long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/municipio/id="+id))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        Optional<Municipio> munEncontrado;
        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return Optional.of(new Municipio(response));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
