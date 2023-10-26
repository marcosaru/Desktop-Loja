/*
 * Created by JFormDesigner on Wed Oct 25 08:57:03 BRT 2023
 */

package org.app.Views;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.app.Views.Cad.CadEstado;
import org.app.Views.List.EstadoList;
import org.app.Views.List.ListMunicipio;

import static java.awt.event.KeyEvent.VK_ENTER;

/**
 * @author marcos
 */
public class MainForm extends JFrame {
    public MainForm() {
        initComponents();
        setVisible(true);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void subMListarEstadoMouseClicked(MouseEvent e) {
        // TODO add your code here
        EstadoList listEstados = new EstadoList();
    }

    private void subMListarEstado(ActionEvent e) {
        // TODO add your code here
        EstadoList listEstados = new EstadoList();
    }

    private void subMCadEstadoMouseClicked(MouseEvent e) {
        CadEstado cadEstado = new CadEstado();
    }

    private void subMCadEstado(ActionEvent e) {
        subMCadEstadoMouseClicked(null);
    }

    private void subMListarMunicipio(ActionEvent e) {
        ListMunicipio listMunicipio = new ListMunicipio();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
        pnlMenu = new JPanel();
        menuBar1 = new JMenuBar();
        mEstado = new JMenu();
        subMListarEstado = new JMenuItem();
        subMCadEstado = new JMenuItem();
        mMunicipio = new JMenu();
        subMListarMunicipio = new JMenuItem();
        subMCadastrar = new JMenuItem();
        pnlPrincipal = new JPanel();

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
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
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
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== pnlMenu ========
        {
            pnlMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
            ,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red),
            pnlMenu. getBorder()));pnlMenu. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});
            pnlMenu.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[19,top]"));

            //======== menuBar1 ========
            {

                //======== mEstado ========
                {
                    mEstado.setText("Estado");

                    //---- subMListarEstado ----
                    subMListarEstado.setText("Listar");
                    subMListarEstado.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            subMListarEstadoMouseClicked(e);
                        }
                    });
                    subMListarEstado.addActionListener(e -> subMListarEstado(e));
                    mEstado.add(subMListarEstado);

                    //---- subMCadEstado ----
                    subMCadEstado.setText("Cadastrar");
                    subMCadEstado.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            subMCadEstadoMouseClicked(e);
                        }
                    });
                    subMCadEstado.addActionListener(e -> subMCadEstado(e));
                    mEstado.add(subMCadEstado);
                }
                menuBar1.add(mEstado);

                //======== mMunicipio ========
                {
                    mMunicipio.setText("Municipio");

                    //---- subMListarMunicipio ----
                    subMListarMunicipio.setText("Listar");
                    subMListarMunicipio.addActionListener(e -> subMListarMunicipio(e));
                    mMunicipio.add(subMListarMunicipio);

                    //---- subMCadastrar ----
                    subMCadastrar.setText("Cadastrar");
                    mMunicipio.add(subMCadastrar);
                }
                menuBar1.add(mMunicipio);
            }
            pnlMenu.add(menuBar1, "cell 0 0 2 1,aligny top,growy 0");
        }
        contentPane.add(pnlMenu, "cell 0 0 26 1");

        //======== pnlPrincipal ========
        {
            pnlPrincipal.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));
        }
        contentPane.add(pnlPrincipal, "cell 0 1 26 11");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - MARCOS GONCALVES TEIXEIRA
    private JPanel pnlMenu;
    private JMenuBar menuBar1;
    private JMenu mEstado;
    private JMenuItem subMListarEstado;
    private JMenuItem subMCadEstado;
    private JMenu mMunicipio;
    private JMenuItem subMListarMunicipio;
    private JMenuItem subMCadastrar;
    private JPanel pnlPrincipal;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
