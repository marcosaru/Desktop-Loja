/*
 * Created by JFormDesigner on Thu Oct 26 14:25:24 BRT 2023
 */

package org.app.Views.Cad;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.*;

import com.google.gson.Gson;
import net.miginfocom.swing.*;
import org.app.config.Configuracoes;
import org.app.dominio.Estado;
import org.app.repository.EstadoRepositorio;

/**
 * @author marcos
 */
public class CadMunicipio extends JFrame {
    final private EstadoRepositorio estadoRepositorio;
    public CadMunicipio() {
        initComponents();
        setVisible(true);
        chkEstado.setBackground(Color.red);
        estadoRepositorio = new EstadoRepositorio();
        setSize(490, 205);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void setMunicipioSelecionado(Object[] municipio) {
     //
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCancelar(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(null, "Você esta preste a sair da tela de cadastro,\n você quer sair?", "Deseja sair?", JOptionPane.OK_CANCEL_OPTION) == 0)
            dispose();
    }

    private void btnConfirma(ActionEvent e) {
        if (edtEstado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Favor informar o nome do Estado!","Nome vazio",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(edtMunicipio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Favor informar o nome do Municipio!","Nome vazio",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!chkEstado.isSelected()){
            JOptionPane.showMessageDialog(null,"é Obrigatório informar o nome do Estado!");
            return;
        }
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        Estado estadoEncontrado = estadoRepositorio.encontrar(edtEstado.getText());
        if (estadoEncontrado != null){
            Gson gson = new Gson();
            String json = "{\"nome\":\""+edtMunicipio.getText()+"\",\"estado\":"+gson.toJson(estadoEncontrado)+"}";
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(Configuracoes.LOCALHOST + "/cadMunicipio"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            try{
                HttpResponse<?> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode() == 200)
                    JOptionPane.showMessageDialog(null,"Cadastrado com sucesso.","Sucesso",JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
        else
            JOptionPane.showMessageDialog(null,"Não foi encontrado um estado com este nome, \nVerifique se digitou corretamente.","Erro ao informar Estado!",JOptionPane.ERROR_MESSAGE);


    }

    private void thisKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == 112)
            btnConfirma(null);
    }

    private void edtEstadoKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10 && !edtEstado.getText().isEmpty()){
            Estado encontrar = estadoRepositorio.encontrar(edtEstado.getText());
            if (encontrar != null){
                edtID.setText(String.valueOf(encontrar.getId()));
                chkEstado.setBackground(Color.green);
                chkEstado.setSelected(true);
                edtEstado.setEnabled(false);
                edtMunicipio.requestFocus();
            }
            else{
                chkEstado.setSelected(false);
                chkEstado.setBackground(Color.red);
            }
        }
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
        chkEstado = new JCheckBox();
        label3 = new JLabel();
        edtMunicipio = new JTextField();
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
            "[20,fill]",
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

        //---- chkEstado ----
        chkEstado.setEnabled(false);
        chkEstado.setBackground(new Color(0xcc0000));
        contentPane.add(chkEstado, "cell 7 1");

        //---- label3 ----
        label3.setText("Municipio");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3, "cell 1 3");
        contentPane.add(edtMunicipio, "cell 3 3 4 1");

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
    private JCheckBox chkEstado;
    private JLabel label3;
    private JTextField edtMunicipio;
    private JButton btnCancelar;
    private JButton btnConfirma;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
