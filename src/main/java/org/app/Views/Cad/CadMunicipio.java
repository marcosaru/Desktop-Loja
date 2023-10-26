/*
 * Created by JFormDesigner on Thu Oct 26 14:25:24 BRT 2023
 */

package org.app.Views.Cad;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author marcos
 */
public class CadMunicipio extends JFrame {
    public CadMunicipio() {
        initComponents();
        setVisible(true);
        setSize(490, 205);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCancelar(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(null, "Você esta preste a sair da tela de cadastro,\n você quer sair?", "Deseja sair?", JOptionPane.OK_CANCEL_OPTION) == 0)
            dispose();
    }

    private void btnConfirma(ActionEvent e) {
        // TODO add your code here
    }

    private void thisKeyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    private void edtEstadoKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27)
            btnCancelar(null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        edtID = new JTextField();
        label2 = new JLabel();
        edtEstado = new JTextField();
        label3 = new JLabel();
        edtEstado2 = new JTextField();
        btnCancelar = new JButton();
        btnConfirma = new JButton();

        //======== this ========
        setTitle("Cadastrar Municipio");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                thisKeyPressed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[43,fill]" +
            "[130,fill]" +
            "[69,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[45]" +
            "[70]" +
            "[]"));

        //---- label1 ----
        label1.setText("ID");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label1, "cell 1 0");

        //---- edtID ----
        edtID.setEnabled(false);
        contentPane.add(edtID, "cell 3 0 3 1");

        //---- label2 ----
        label2.setText("Estado");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2, "cell 1 1");

        //---- edtEstado ----
        edtEstado.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                edtEstadoKeyPressed(e);
            }
        });
        contentPane.add(edtEstado, "cell 3 1 4 1");

        //---- label3 ----
        label3.setText("Municipio");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3, "cell 1 3");
        contentPane.add(edtEstado2, "cell 3 3 4 1");

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> btnCancelar(e));
        contentPane.add(btnCancelar, "cell 5 5");

        //---- btnConfirma ----
        btnConfirma.setText("Confirmar");
        btnConfirma.addActionListener(e -> btnConfirma(e));
        contentPane.add(btnConfirma, "cell 6 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JLabel label1;
    private JTextField edtID;
    private JLabel label2;
    private JTextField edtEstado;
    private JLabel label3;
    private JTextField edtEstado2;
    private JButton btnCancelar;
    private JButton btnConfirma;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
