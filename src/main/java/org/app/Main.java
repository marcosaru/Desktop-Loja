package org.app;

import org.app.Views.MainForm;
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
                MainForm mainForm = new MainForm();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    /*

    "content": [
            {
            "id": 1,
            "nome": "Bahia"
            },
            {
            "id": 2,
            "nome": "São Paulo"
            },
            {
            "id": 52,
            "nome": "PARANA"
            },
            {
            "id": 53,
            "nome": "GOIAS"
            }
            ]
*/