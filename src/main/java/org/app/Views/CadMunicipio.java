package org.app.Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadMunicipio extends JFrame {
    public JPanel getPnlMain() {
        return pnlMain;
    }

    private JPanel pnlMain;
    private JButton btnCadastrar;
    private JButton btnCancelar;

    public CadMunicipio() {
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Deseja cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
            }
        });
    }
}
