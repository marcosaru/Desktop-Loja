/*
 * Created by JFormDesigner on Mon Oct 30 18:15:22 BRT 2023
 */

package org.app.Views.Cad;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author marcos
 */
public class cadCliente extends JFrame {
    public cadCliente() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[108,fill]" +
            "[97,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("ID");
        contentPane.add(label1, "cell 1 1");
        contentPane.add(textField1, "cell 2 1");

        //---- label2 ----
        label2.setText("Nome");
        contentPane.add(label2, "cell 1 2");
        contentPane.add(textField2, "cell 2 2 6 1");

        //---- label3 ----
        label3.setText("Email");
        contentPane.add(label3, "cell 1 3");
        contentPane.add(textField3, "cell 2 3 6 1");

        //---- label4 ----
        label4.setText("CPF");
        contentPane.add(label4, "cell 1 4");
        contentPane.add(textField4, "cell 2 4 6 1");

        //---- label5 ----
        label5.setText("Endere\u00e7o");
        contentPane.add(label5, "cell 1 5");
        contentPane.add(textField5, "cell 2 5 6 1");

        //---- label6 ----
        label6.setText("Tefone");
        contentPane.add(label6, "cell 1 6");
        contentPane.add(textField6, "cell 2 6 6 1");

        //---- label7 ----
        label7.setText("Municipio");
        contentPane.add(label7, "cell 1 7");
        contentPane.add(textField7, "cell 2 7 6 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
