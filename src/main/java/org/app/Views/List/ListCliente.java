/*
 * Created by JFormDesigner on Mon Oct 30 15:01:29 BRT 2023
 */

package org.app.Views.List;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.jformdesigner.C;
import lombok.Getter;
import lombok.Setter;
import net.miginfocom.swing.*;
import org.app.Views.Cad.CadCliente;
import org.app.repository.ClienteRepositorio;
import org.app.repository.MunicipioRepositorio;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.JTable.AUTO_RESIZE_OFF;

/**
 * @author marcos
 */
public class ListCliente extends JFrame {
    private Object[][] dados=null;
    @Getter
    @Setter
    private int modo;
    private String[] colunas = {"ID","Nome","CPF","Telefone","Endereco","ID Municipio","Municipio","ID Estado","Estado","Email"};
    public ListCliente(int modo) {
        initComponents();
        setModo(modo);
        setVisible(true);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        dados = clienteRepositorio.listarTodos();

        DefaultTableModel model = new DefaultTableModel(dados,colunas){
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        tbl.setModel(model);
        tbl.getTableHeader().setResizingAllowed(false);
        tbl.getTableHeader().setReorderingAllowed(false);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(190);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(190);
        tbl.setAutoResizeMode(AUTO_RESIZE_OFF);
    }

    private void thisKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void thisWindowActivated(WindowEvent e) {
        // TODO add your code here
    }

    private void btnIncluir(ActionEvent e) {
        CadCliente cadCliente = new CadCliente();
    }

    private void tblMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnEditar(ActionEvent e) {
        // TODO add your code here
    }

    private void btnFechar(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        btnIncluir = new JButton();
        scrollPane2 = new JScrollPane();
        tbl = new JTable();
        btnEditar = new JButton();
        btnFechar = new JButton();

        //======== this ========
        setResizable(false);
        setTitle("Clientes Cadastrados");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                thisKeyPressed(e);
            }
        });
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
            "[688,fill]" +
            "[34,fill]" +
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

        //---- btnIncluir ----
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(e -> btnIncluir(e));
        contentPane.add(btnIncluir, "cell 5 2");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(tbl);
        }
        contentPane.add(scrollPane2, "cell 2 3");

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
    private JButton btnIncluir;
    private JScrollPane scrollPane2;
    private JTable tbl;
    private JButton btnEditar;
    private JButton btnFechar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
