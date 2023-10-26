package org.app.Views;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    @Getter
    private JPanel MainFrame;
    private JMenu btnListEstado;
    private JMenuItem buttonEstado;
    private JMenuItem btnSubMunicipio;
    private JMenuItem btnMunicipio;
    private JMenuItem buttEstado;
    private JMenuItem Cadastrar;
    private JMenuItem CadProduto;

    public Principal() {




        buttEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListEstados listEstados = new ListEstados();
            }
        });
    }



}
