package org.app.Views;

import lombok.Getter;
import org.app.repository.MunicipioRepositorio;

import javax.swing.*;

public class ListMunicipios extends JFrame {
    @Getter
    private JPanel pnlMain;

    private JTable tblMunicipios;

    private JButton btnEditar;
    private JButton btnCancelar;
    private String[] header = {"Municipio ID","Nome","Estado ID", "Estado"};

    public ListMunicipios(){
        pnlMain = new JPanel();
        setContentPane(pnlMain);
        setVisible(true);
        setTitle("Listagem de Municipios");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        MunicipioRepositorio municipioRepositorio = new MunicipioRepositorio();
        Object[][] municipios = municipioRepositorio.listar();
        tblMunicipios = new JTable(municipios,header);
        JScrollPane barraRolagem = new JScrollPane(tblMunicipios);

        pnlMain.add(barraRolagem);
        add(btnCancelar);
        add(btnEditar);
    }


}
