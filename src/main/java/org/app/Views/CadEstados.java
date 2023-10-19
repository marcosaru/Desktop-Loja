package org.app.Views;

import javax.swing.*;

public class CadEstados extends JFrame {
    private JButton cancelarButton;
    private JButton btnSalvar;
    private JTextField EdtNome;
    private JLabel lbl;
    private JPanel pnlMain;
    private JTextField EdtId;

    public JPanel getPnlMain() {
        return pnlMain;
    }
    public CadEstados(String string, String s){
        EdtNome.setText(s);
        EdtId.setText(string);
    }
}
