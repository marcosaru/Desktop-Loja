package org.app;

import org.app.Views.Principal;
import org.app.dominio.DataBase;

import javax.swing.*;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        String host = "base";
        String user = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/";
        Connection connection = DataBase.conexao(url,host,user,password);
            try{
                Principal principal = new Principal();
                principal.setVisible(true);
                principal.setContentPane(principal.getMainFrame());
                principal.setTitle("Sistema de Revenda - Marcos Goncalves Teixeira");
                principal.setSize(1200, 800);
                principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
