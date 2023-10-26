package org.app.Views;

import lombok.Getter;
import org.app.dominio.Estado;
import org.app.repository.EstadoRepositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ListEstados extends JFrame {
    @Getter
    private JPanel pnlMain;
    private JTable tblEstados;
    private JButton btnEditar;
    private JPanel pnlBotoes;
    private JButton btnCancelar;

    public JPanel getPnlTable() {
        return new JPanel();
    }



    public ListEstados(){
        pnlMain = new JPanel();
        final String[] colunas = {"ID","Estado"};
        setContentPane(pnlMain);
        setVisible(true);
        setTitle("Listagem de Estados");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        EstadoRepositorio estadoRepositorio = new EstadoRepositorio();
        Object[][] estados = estadoRepositorio.listarTodos();


        DefaultTableModel model = new DefaultTableModel(estados,colunas);
        tblEstados.setModel(model);

        GridLayout layout = new GridLayout(2,1);
        setLayout(layout);
        pnlMain.add(tblEstados);
        pnlMain.add(pnlBotoes);
//        pnlMain.add(btnEditar);


        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblEstados.getSelectedRow();
                CadEstados cadEstados = new CadEstados(estados[selectedRow][0].toString(),estados[selectedRow][1].toString());
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
