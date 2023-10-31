package org.app.dominio;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private Municipio municipio;
    private String endereco;
    private String telefone;

    public static Object[][] fromJson(String body) {
        String[] linhas = body.split("\"content\":\\[")[1].split("],")[0].split("},");
        Object[][] dados = new Object[linhas.length][10];

        for(int i =0; i< linhas.length; i++){
            Gson gson = new Gson();
            String cont = linhas[i].replace("{", "").replace("}}","");
            String estado = "{"+cont.split("estado\":")[1]+"}";
            Estado estadoEncontrado = gson.fromJson(estado.replace("}}","}"), Estado.class);
            Municipio municipioEncontrado= gson.fromJson("{"+cont.split("municipio\":")[1].split(",\"estado")[0]+"}", Municipio.class);
            municipioEncontrado.setEstado(estadoEncontrado);
            Cliente cliente = gson.fromJson("{"+cont.split(",\"municipio\"")[0]+"}", Cliente.class);
            cliente.setMunicipio(municipioEncontrado);

            dados[i][0] = cliente.getId();
            dados[i][1] = cliente.getNome();
            dados[i][2] = cliente.getCpf();
            dados[i][3] = cliente.getTelefone();
            dados[i][4] = cliente.getEndereco();
            dados[i][5] = cliente.getMunicipio().getId();
            dados[i][6] = cliente.getMunicipio().getNome();
            dados[i][7] = cliente.getMunicipio().getEstado().getId();
            dados[i][8] = cliente.getMunicipio().getEstado().getNome();
            dados[i][9] = cliente.getEmail();

        }

        return dados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", municipio=" + municipio +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"nome\":\"" + nome + '\"' +
                ", \"email\":\"" + email + '\"' +
                ", \"cpf\":\"" + cpf + '\"' +
                ", \"endereco\":\"" + endereco + '\"' +
                ", \"telefone\":\"" + telefone + '\"' +
                ", \"municipio\":" +"{"+
                "\"id\":"+municipio.getId() +","+
                "\"nome\":\""+municipio.getNome()+"\","+
                "\"estado\":"+"{"+
                "\"id\":"+municipio.getEstado().getId()+","+
                "\"nome\":\""+municipio.getEstado().getNome()+"\""+
                '}'+"}}";
    }
}