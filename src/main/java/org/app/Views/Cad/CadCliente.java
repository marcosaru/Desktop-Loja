/*
 * Created by JFormDesigner on Mon Oct 30 18:15:22 BRT 2023
 */

package org.app.Views.Cad;

import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.app.Views.List.ListMunicipio;
import org.app.config.Configuracoes;
import org.app.dominio.Municipio;
import org.app.repository.MunicipioRepositorio;

/**
 * @author marcos
 */
public class CadCliente extends JFrame {
    public CadCliente() {
        initComponents();
        setVisible(true);
        setSize(550, 290);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private void textField8KeyPressed(KeyEvent e) {
        if(e.getKeyCode() == 10 && !edtCodigoMunicipio.getText().equals("")){
            String input = edtCodigoMunicipio.getText();
            boolean contemLetras = input.matches(".*[A-Za-z].*");
            if (contemLetras) {
               JOptionPane.showMessageDialog(null, "Municipio não encontrado, por favor insira o código numérico do municipio!","Erro ao consultar Municipio",JOptionPane.ERROR_MESSAGE);
               return;
           }else{
               MunicipioRepositorio municipioRepositorio = new MunicipioRepositorio();
               Optional<Municipio> municipio = municipioRepositorio.encontrarPorId(Long.parseLong(edtCodigoMunicipio.getText()));
               if (municipio.isPresent()) {
                    EdtNomeMunicipio.setText(municipio.get().getNome());
                    chkMunicipio.setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, "Municipio não encontrado, por favor insira o código numérico do municipio!", "Erro ao consultar Municipio", JOptionPane.ERROR_MESSAGE);
                    chkMunicipio.setVisible(false);
               }
           }
        }
    }

    private void btnBuscarMunicipio(ActionEvent e) {
        ListMunicipio listMunicipio = new ListMunicipio(Configuracoes.MODO_BUSCAR);
        if (ListMunicipio.getMunicipio() != null) {
            EdtNomeMunicipio.setText(ListMunicipio.getMunicipio().getNome());
            edtCodigoMunicipio.setText(String.valueOf(ListMunicipio.getMunicipio().getId()));
            chkMunicipio.setVisible(true);
        }
    }

    private void thisWindowActivated(WindowEvent e) {
        if (ListMunicipio.getMunicipio() != null) {
            EdtNomeMunicipio.setText(ListMunicipio.getMunicipio().getNome());
            edtCodigoMunicipio.setText(String.valueOf(ListMunicipio.getMunicipio().getId()));
            chkMunicipio.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        edtNome = new JTextField();
        label3 = new JLabel();
        edtEmail = new JTextField();
        label4 = new JLabel();
        edtCpf = new JTextField();
        label5 = new JLabel();
        edtEndereco = new JTextField();
        label6 = new JLabel();
        edtTelefone = new JTextField();
        label7 = new JLabel();
        edtCodigoMunicipio = new JTextField();
        EdtNomeMunicipio = new JTextField();
        chkMunicipio = new JCheckBox();
        btnBuscarMunicipio = new JButton();
        label8 = new JLabel();

        //======== this ========
        setTitle("Cadastrar Cliente");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
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
            "[fill]" +
            "[fill]" +
            "[108,fill]" +
            "[97,fill]" +
            "[90,fill]",
            // rows
            "[]" +
            "[center]" +
            "[center]" +
            "[center]" +
            "[center]" +
            "[center]" +
            "[center]" +
            "[center]" +
            "[]"));

        //---- label1 ----
        label1.setText("ID");
        label1.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label1, "cell 1 1,alignx right,growx 0");

        //---- textField1 ----
        textField1.setEnabled(false);
        textField1.setMaximumSize(new Dimension(50, 22));
        contentPane.add(textField1, "cell 2 1 2 1");

        //---- label2 ----
        label2.setText("Nome");
        label2.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label2, "cell 1 2,alignx right,growx 0");

        //---- edtNome ----
        edtNome.setMinimumSize(new Dimension(49, 25));
        edtNome.setMaximumSize(new Dimension(2147483647, 22));
        contentPane.add(edtNome, "cell 2 2 6 1");

        //---- label3 ----
        label3.setText("Email");
        label3.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label3, "cell 1 3,alignx right,growx 0");

        //---- edtEmail ----
        edtEmail.setMaximumSize(new Dimension(2147483647, 22));
        contentPane.add(edtEmail, "cell 2 3 6 1");

        //---- label4 ----
        label4.setText("CPF");
        label4.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label4, "cell 1 4,alignx right,growx 0");

        //---- edtCpf ----
        edtCpf.setMaximumSize(new Dimension(2147483647, 22));
        contentPane.add(edtCpf, "cell 2 4 6 1");

        //---- label5 ----
        label5.setText("Endere\u00e7o");
        label5.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label5, "cell 1 5,alignx right,growx 0");

        //---- edtEndereco ----
        edtEndereco.setMaximumSize(new Dimension(2147483647, 22));
        contentPane.add(edtEndereco, "cell 2 5 6 1");

        //---- label6 ----
        label6.setText("Tefone");
        label6.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label6, "cell 1 6,alignx right,growx 0");

        //---- edtTelefone ----
        edtTelefone.setMaximumSize(new Dimension(2147483647, 22));
        contentPane.add(edtTelefone, "cell 2 6 6 1");

        //---- label7 ----
        label7.setText("Municipio");
        label7.setHorizontalTextPosition(SwingConstants.RIGHT);
        contentPane.add(label7, "cell 1 7,alignx right,growx 0");

        //---- edtCodigoMunicipio ----
        edtCodigoMunicipio.setMaximumSize(new Dimension(2147483647, 22));
        edtCodigoMunicipio.setPreferredSize(new Dimension(50, 30));
        edtCodigoMunicipio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textField8KeyPressed(e);
            }
        });
        contentPane.add(edtCodigoMunicipio, "cell 2 7 2 1");

        //---- EdtNomeMunicipio ----
        EdtNomeMunicipio.setEnabled(false);
        EdtNomeMunicipio.setMaximumSize(new Dimension(250, 22));
        EdtNomeMunicipio.setMinimumSize(new Dimension(300, 30));
        contentPane.add(EdtNomeMunicipio, "cell 4 7 5 1");

        //---- chkMunicipio ----
        chkMunicipio.setBackground(new Color(0x00cc00));
        chkMunicipio.setSelected(true);
        chkMunicipio.setVisible(false);
        contentPane.add(chkMunicipio, "cell 4 7 5 1");

        //---- btnBuscarMunicipio ----
        btnBuscarMunicipio.setText("Busca");
        btnBuscarMunicipio.setMaximumSize(new Dimension(90, 22));
        btnBuscarMunicipio.setMinimumSize(new Dimension(90, 30));
        btnBuscarMunicipio.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBuscarMunicipio.addActionListener(e -> btnBuscarMunicipio(e));
        contentPane.add(btnBuscarMunicipio, "cell 9 7");

        //---- label8 ----
        label8.setText("Digite o c\u00f3digo do municipio e pressione \"enter\".");
        contentPane.add(label8, "cell 2 8 7 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField edtNome;
    private JLabel label3;
    private JTextField edtEmail;
    private JLabel label4;
    private JTextField edtCpf;
    private JLabel label5;
    private JTextField edtEndereco;
    private JLabel label6;
    private JTextField edtTelefone;
    private JLabel label7;
    private JTextField edtCodigoMunicipio;
    private JTextField EdtNomeMunicipio;
    private JCheckBox chkMunicipio;
    private JButton btnBuscarMunicipio;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
