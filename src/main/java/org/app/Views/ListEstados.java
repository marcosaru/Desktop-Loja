package org.app.Views;

import org.app.repository.EstadoRepositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListEstados extends JFrame {
    private JPanel pnlMain;
    private JTable tblEstados;
    private JButton btnEditar;
    private JPanel pnlBotoes;
    private JButton btnCancelar;
    private JPanel pnlTable;
    private String[] colunas = {"ID","Estado"};

    public JPanel getPnlMain() {
        return pnlMain;
    }
    public ListEstados(){
        pnlMain = new JPanel();
        pnlBotoes = new JPanel();
        pnlBotoes.setVisible(true);
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        Object[][] estados = estadoRepositorio.listarTodos();
        JScrollPane barraRolagem = new JScrollPane(tblEstados);
        pnlMain.add(barraRolagem);


        pnlMain.add(pnlBotoes);
        pnlMain.add(btnEditar);
        pnlMain.add(btnCancelar);


        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblEstados.getSelectedRow();
                CadEstados cadEstados = new CadEstados(estados[selectedRow][0].toString(),estados[selectedRow][1].toString());
                cadEstados.setVisible(true);
                cadEstados.setContentPane(cadEstados.getPnlMain());
                cadEstados.setTitle("Cadastro de Estados");
                cadEstados.setSize(600, 400);
                cadEstados.setLocationRelativeTo(null);
                cadEstados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }

}
