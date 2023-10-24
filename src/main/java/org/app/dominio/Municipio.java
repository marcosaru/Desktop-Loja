package org.app.dominio;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.repository.MunicipioRepositorio;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Municipio {
    private long id;
    private String nome;
    private Estado estado;

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }

    public static Object[][] fromJson(String body) {
        String[] linhas = body.split("content\":\\[")[1].split("]")[0].split("},");
        List<Municipio> list = new ArrayList<>();
        Gson gson = new Gson();
        Object[][] objetoMunicipios = new Object[linhas.length][4];
        for(String s:linhas){
            String estado = s.split("\"estado\":")[1].replace("}}","}");
            Estado estadoEncontrado = gson.fromJson(estado, Estado.class);
            String municipio = s.split(",\"estado\":")[0]+"}";
            Municipio municipioEncontrado = gson.fromJson(municipio, Municipio.class);
            municipioEncontrado.setEstado(estadoEncontrado);
            list.add(municipioEncontrado);
        }
        for (int i = 0; i < list.size(); i++) {
            objetoMunicipios[i][0] = list.get(i).id;
            objetoMunicipios[i][1] = list.get(i).nome;
            objetoMunicipios[i][2] = list.get(i).estado.getId();
            objetoMunicipios[i][3] = list.get(i).estado.getNome();
        }
        return objetoMunicipios;
    }
}
