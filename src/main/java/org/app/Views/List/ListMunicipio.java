/*
 * Created by JFormDesigner on Thu Oct 26 14:14:33 BRT 2023
 */

package org.app.Views.List;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import lombok.Getter;
import lombok.Setter;
import net.miginfocom.swing.*;
import org.app.Views.Cad.CadMunicipio;
import org.app.repository.EstadoRepositorio;
import org.app.repository.MunicipioRepositorio;

import static javax.swing.JTable.AUTO_RESIZE_OFF;

/**
 * @author marcos
 */
public class ListMunicipio extends JFrame {
    @Getter
    @Setter
    private Object[][] municipios = null;
    private String[] colunas = {"ID Municipio","Municipio","ID Estado","Estado"};
    public ListMunicipio() {
        initComponents();
        setVisible(true);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MunicipioRepositorio municipioRepositorio = new MunicipioRepositorio();
        setMunicipios(municipioRepositorio.listar());
        DefaultTableModel model = new DefaultTableModel(getMunicipios(),colunas){
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        tblMunicipios.setModel(model);
        tblMunicipios.getTableHeader().setResizingAllowed(false);
        tblMunicipios.getTableHeader().setReorderingAllowed(false);
        tblMunicipios.setAutoResizeMode(AUTO_RESIZE_OFF);
        tblMunicipios.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblMunicipios.getColumnModel().getColumn(1).setPreferredWidth(190);
        tblMunicipios.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblMunicipios.getColumnModel().getColumn(3).setPreferredWidth(190);
        pnl.requestFocus();
    }

    private void thisKeyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 27)
            btnFechar(null);

    }

    private void thisWindowActivated(WindowEvent e) {
        // TODO add your code here
    }

    private void tblEstadosMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void btnIncluir(ActionEvent e) {
        CadMunicipio cadMunicipio = new CadMunicipio();
    }

    private void btnEditar(ActionEvent e) {
        // TODO add your code here
    }

    private void btnFechar(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(null,"Você gostaria de sair?","Confirme sua ação",JOptionPane.OK_CANCEL_OPTION) == 0)
            dispose();
    }

    private void thisKeyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    private void thisKeyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    private void pnlKeyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 112)
            btnIncluir(null);
        if( e.getKeyCode() == 27)
            btnFechar(null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        tblMunicipios = new JTable();
        btnIncluir = new JButton();
        btnEditar = new JButton();
        btnFechar = new JButton();
        pnl = new JPanel();

        //======== this ========
        setResizable(false);
        setTitle("Municipios Cadastrados");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                thisKeyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                thisKeyReleased(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                thisKeyTyped(e);
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
        label1.setText("Listagem de Municipios");
        contentPane.add(label1, "cell 3 1,alignx center,growx 0");

        //======== scrollPane1 ========
        {

            //---- tblMunicipios ----
            tblMunicipios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tblMunicipios.setCellSelectionEnabled(true);
            tblMunicipios.setToolTipText("Para editar utilize o bot\u00e3o de edi\u00e7\u00e3o.");
            tblMunicipios.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblEstadosMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tblMunicipios);
        }
        contentPane.add(scrollPane1, "cell 1 2 3 4");

        //---- btnIncluir ----
        btnIncluir.setText("F1- Incluir");
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

        //======== pnl ========
        {
            pnl.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    pnlKeyPressed(e);
                }
            });
            pnl.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
            java.awt.Color.red),pnl. getBorder()));pnl. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});
            pnl.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[6,fill]",
                // rows
                "[3]"));
        }
        contentPane.add(pnl, "cell 5 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable tblMunicipios;
    private JButton btnIncluir;
    private JButton btnEditar;
    private JButton btnFechar;
    private JPanel pnl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
