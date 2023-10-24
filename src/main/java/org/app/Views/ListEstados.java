package org.app.Views;

import org.app.dominio.Estado;
import org.app.repository.EstadoRepositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;

public class ListEstados extends JFrame {
    private JPanel pnlMain;
    private JTable tblEstados;
    private JButton btnEditar;
    private JPanel pnlBotoes;
    private JButton btnCancelar;

    public JPanel getPnlTable() {
        return new JPanel();
    }

    private JPanel pnlTable;
    private String[] colunas = {"ID","Estado"};

    public JPanel getPnlMain() {
        return pnlMain;
    }
    public ListEstados(){
        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        Object[][] estados = estadoRepositorio.listarTodos();
        GridLayout layoutMain = new GridLayout(2,1);
        GridLayout layoutBotoes = new GridLayout(1,2);
        GridLayout layoutTable = new GridLayout(1,1);
        //pnlMain = new JPanel(layoutMain);
        pnlBotoes = new JPanel(layoutBotoes);
        pnlTable = new JPanel(layoutTable);

        DefaultTableModel defaultTableModel = new DefaultTableModel(estados,colunas);
        tblEstados.setModel(defaultTableModel);

        add(pnlTable);
        add(pnlBotoes);
        setContentPane(pnlMain);

        setVisible(true);
        setLayout(layoutMain);

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
        btnEditar.addComponentListener(new ComponentAdapter() {
        });
        btnEditar.addContainerListener(new ContainerAdapter() {
        });
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (tblEstados.getColumnSelectionAllowed()){
                    JOptionPane.showMessageDialog(null,"Selecione um estado para editar");
                }
            }
        });
        btnCancelar.addMouseMotionListener(new MouseMotionAdapter() {
        });
        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });
        pnlMain.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });
        pnlMain.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
    }
}
