/*
 * Created by JFormDesigner on Wed Oct 25 14:42:13 BRT 2023
 */

package org.app.Views.Cad;

import com.google.gson.Gson;
import net.miginfocom.swing.MigLayout;
import org.app.config.Configuracoes;
import org.app.dominio.Estado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author marcos
 */
public class CadEstado extends JFrame {
    public CadEstado() {
        this("","");
    }
    public CadEstado(String id,String nome){
        initComponents();
        setVisible(true);
        setTitle("Cadastrar Estado");
        setSize(395, 210);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        edtID.setText(id);
        edtEstado.setText(nome);
    }

    private void btnCancelar(ActionEvent e) {
        dispose();
    }

    private void btnConfirma(ActionEvent e) {
        if (edtEstado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Você precisa informar o nome do Estado","Erro ao informar estado",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!edtEstado.getText().isEmpty() && edtID.getText().isEmpty()) {
            HttpClient httpClient = HttpClient.newHttpClient();
            Gson gson = new Gson();
            Estado estado = new Estado(1,edtEstado.getText());
            String json = gson.toJson(estado);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Configuracoes.LOCALHOST + "/cadEstado"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();


            try {
                HttpResponse<?> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    JOptionPane.showMessageDialog(null,"Estado foi salvo com sucesso!","Operação realizada com sucesso.",JOptionPane.INFORMATION_MESSAGE);
                } else if(response.statusCode() == 400)
                    JOptionPane.showMessageDialog(null,response.body(),"Erro",JOptionPane.ERROR_MESSAGE);
                else
                    throw new RuntimeException("Não foi possivel.");
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }
        else {
            HttpClient httpClient = HttpClient.newHttpClient();
            Gson gson = new Gson();
            Estado estado = new Estado(Long.valueOf(edtID.getText()),edtEstado.getText());
            String json = gson.toJson(estado);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Configuracoes.LOCALHOST + "/estado/id="+edtID.getText()))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(json))
                    .build();


            try {
                HttpResponse<?> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    JOptionPane.showMessageDialog(null,"Estado foi alterado com sucesso!","Operação realizada com sucesso.",JOptionPane.INFORMATION_MESSAGE);
                } else if(response.statusCode() == 400)
                    JOptionPane.showMessageDialog(null,response.body(),"Erro",JOptionPane.ERROR_MESSAGE);
                else
                    throw new RuntimeException("Não foi possivel.");
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        edtID = new JTextField();
        label2 = new JLabel();
        edtEstado = new JTextField();
        btnCancelar = new JButton();
        btnConfirma = new JButton();

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
            "[43,fill]" +
            "[130,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[45]" +
            "[]"));

        //---- label1 ----
        label1.setText("ID");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label1, "cell 1 1");

        //---- edtID ----
        edtID.setEnabled(false);
        contentPane.add(edtID, "cell 2 1 4 1");

        //---- label2 ----
        label2.setText("Estado");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2, "cell 1 3");
        contentPane.add(edtEstado, "cell 2 3 5 1");

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
    private JButton btnCancelar;
    private JButton btnConfirma;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
