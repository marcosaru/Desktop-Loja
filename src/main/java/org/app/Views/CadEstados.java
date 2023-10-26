package org.app.Views;

import lombok.Getter;

import javax.swing.*;

public class CadEstados extends JFrame {
    private JButton cancelarButton;
    private JButton btnSalvar;
    private JTextField EdtNome;
    private JLabel lbl;
    @Getter
    private JPanel pnlMain;
    private JTextField EdtId;


    public CadEstados(String string, String s){
        EdtNome.setText(s);
        EdtId.setText(string);
        setVisible(true);
        setContentPane(getPnlMain());
        setTitle("Cadastro de Estados");
        setSize(395, 235);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public CadEstados(){
        this("","");
    }
}
