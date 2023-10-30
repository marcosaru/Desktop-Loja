package org.app.dominio;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private long id;
    private String nome;
    private double valor;
    private int quantidade;
    private String descricao;
    private String marca;
    private String modelo;
    private double custo;

    private Categoria categoria;
    private Fornecedor fornecedor;
}
