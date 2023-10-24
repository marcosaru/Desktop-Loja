package org.app.Views;

import lombok.Getter;
import org.app.dominio.Municipio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    @Getter
    private JPanel MainFrame;
    private JMenu menu;
    private JMenu btnEstado;
    private JMenuItem buttonEstado;
    private JMenu btnMunicipio;
    private JMenuItem btnSubMunicipio;
    private JMenuItem Cadastrar;
    private JMenuItem CadProduto;

    public Principal() {


        btnEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEstados listEstados = new ListEstados();
                listEstados.setVisible(true);
                listEstados.setContentPane(listEstados.getPnlMain());
                listEstados.setTitle("Listagem de Estados");
                listEstados.setSize(600, 400);
                listEstados.setLocationRelativeTo(null);
                listEstados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        buttonEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEstados listEstados = new ListEstados();
                listEstados.setTitle("Listagem de Estados");
                listEstados.setSize(600, 800);
                listEstados.setLocationRelativeTo(null);
                listEstados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        btnSubMunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListMunicipios listMunicipios = new ListMunicipios();
            }
        });
    }



}
