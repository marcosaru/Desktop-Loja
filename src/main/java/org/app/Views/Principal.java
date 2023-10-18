package org.app.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel MainFrame;
    private JMenu menu;
    private JMenuItem Cadastrar;
    private JMenuItem CadProduto;

    public Principal() {
        Cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadMunicipio cadMunicipio = new CadMunicipio();
                cadMunicipio.setVisible(true);
                cadMunicipio.setContentPane(cadMunicipio.getPnlMain());
                cadMunicipio.setTitle("Cadastro de Municipio");
                cadMunicipio.setSize(600, 400);
                cadMunicipio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }

    public JPanel getMainFrame() {
        return MainFrame;
    }

    public void setMainFrame(JPanel mainFrame) {
        MainFrame = mainFrame;
    }

}
