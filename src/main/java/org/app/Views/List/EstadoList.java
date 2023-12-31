/*
 * Created by JFormDesigner on Wed Oct 25 10:20:11 BRT 2023
 */

package org.app.Views.List;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

import lombok.Getter;
import lombok.Setter;
import net.miginfocom.swing.*;
import org.app.Views.Cad.CadEstado;
import org.app.dominio.Estado;
import org.app.repository.EstadoRepositorio;

/**
 * @author marcos
 */
public class EstadoList extends JFrame {
    private String[] colunas = {"ID","Estado"};
    private Object[][] estados;
    @Getter
    @Setter
    private Estado selectedEstado;
    public boolean selecionado;
    public EstadoList() {
        initComponents();
        setVisible(true);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        estados = estadoRepositorio.listarTodos();

        DefaultTableModel model = new DefaultTableModel(estados,colunas){
            boolean[] columnEditable = new boolean[] {
                    false, true
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        tbl.setModel(model);
        tbl.getTableHeader().setResizingAllowed(false);

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
        int selectedRow = tbl.getSelectedRow();
        CadEstado cadEstado = new CadEstado(estados[selectedRow][0].toString(),estados[selectedRow][1].toString());
    }

    private void thisWindowActivated(WindowEvent e) {
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        estados = estadoRepositorio.listarTodos();

    }
    private void tblEstadosMouseClicked(MouseEvent e) {
        System.out.println("getButton: "+e.getButton());
        System.out.println("qtdClick: "+e.getClickCount());
        if (e.getClickCount() >= 2 && e.getButton() == 1){
            System.out.println("oi");
        }
    }

    private void tblMouseClicked(MouseEvent e) {
        if (e.getClickCount() >= 2 && e.getButton() == 1){
            setVisible(false);
            setSelectedEstado(new Estado((Long) estados[tbl.getSelectedRow()][0], (String) estados[tbl.getSelectedRow()][1]));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        btnIncluir = new JButton();
        scrollPane1 = new JScrollPane();
        tbl = new JTable();
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

        //---- btnIncluir ----
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(e -> btnIncluir(e));
        contentPane.add(btnIncluir, "cell 5 2");

        //======== scrollPane1 ========
        {

            //---- tbl ----
            tbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tbl);
        }
        contentPane.add(scrollPane1, "cell 3 3");

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
    private JButton btnIncluir;
    private JScrollPane scrollPane1;
    private JTable tbl;
    private JButton btnEditar;
    private JButton btnFechar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
