/*
 * Created by JFormDesigner on Wed Oct 25 10:20:11 BRT 2023
 */

package org.app.Views.List;

import java.awt.event.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;
import org.app.Views.Cad.CadEstado;
import org.app.Views.CadEstados;
import org.app.repository.EstadoRepositorio;

/**
 * @author marcos
 */
public class EstadoList extends JFrame {
    private String[] colunas = {"ID","Estado"};
    private Object[][] estados;
    private long idMax;
    public EstadoList() {
        initComponents();
        setVisible(true);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        estados = estadoRepositorio.listarTodos();
        DefaultTableModel model = new DefaultTableModel(estados,colunas);
        tblEstados.setModel(model);
    }

    private void thisKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            dispose();
        else if (e.getKeyCode() == 1)
            dispose();
    }

    private void btnIncluir(ActionEvent e) {
        // TODO add your code here
        CadEstado cadEstados = new CadEstado();
    }

    private void btnFechar(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void btnEditar(ActionEvent e) {
        // TODO add your code here
        int selectedRow = tblEstados.getSelectedRow();

        CadEstado cadEstado = new CadEstado(estados[selectedRow][0].toString(),estados[selectedRow][1].toString());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        tblEstados = new JTable();
        btnIncluir = new JButton();
        btnEditar = new JButton();
        btnFechar = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("Estados Cadastrados");
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
            "[fill]" +
            "[fill]",
            // rows
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
        label1.setText("Listagem de Estados");
        contentPane.add(label1, "cell 3 1,alignx center,growx 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblEstados);
        }
        contentPane.add(scrollPane1, "cell 1 2 3 4");

        //---- btnIncluir ----
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(e -> btnIncluir(e));
        contentPane.add(btnIncluir, "cell 5 2");

        //---- btnEditar ----
        btnEditar.setText("Editar");
        btnEditar.addActionListener(e -> btnEditar(e));
        contentPane.add(btnEditar, "cell 5 3");

        //---- btnFechar ----
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(e -> btnFechar(e));
        contentPane.add(btnFechar, "cell 5 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable tblEstados;
    private JButton btnIncluir;
    private JButton btnEditar;
    private JButton btnFechar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
