package org.app.dominio;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    private String host = "base";
    private String user = "postgres";
    private String password = "admin";
    private String url = "jdbc:postgresql://localhost:5432/";

    public DataBase(String host, String user, String password, String url) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public DataBase(String host) {
        this.host = host;
    }
    public static Connection conexao(String url,String host, String user, String password){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url+host, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public DataBase( ) {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}