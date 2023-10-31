package org.app.repository;

import org.app.config.Configuracoes;
import org.app.dominio.Cliente;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteRepositorio {
    public void cadastrar(Cliente cliente) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/cadCliente"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(cliente.toJson()))
                .build();
        try{
            System.out.println(cliente.toJson());
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }else
                System.out.println("Erro ao cadastrar."+response.body());
        }catch (Exception expe){
            expe.printStackTrace();
        }
    }

    public Object[][] listarTodos() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Configuracoes.LOCALHOST + "/listarClientes"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if(status == 200){
                String body = response.body();
               return Cliente.fromJson(body);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
