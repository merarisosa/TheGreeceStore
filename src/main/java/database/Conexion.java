/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cocol
 */
public class Conexion {
  private final String db = "b6y9vrhjxiytjl3q9aqz";
  private final String user = "ujablamxufzlb1a3";
  private final String pwd = "9L4rQ5EXyKKgQ2hHDqQv";
  private final String driver = "jdbc:mysql";
  private final String host = "b6y9vrhjxiytjl3q9aqz-mysql.services.clever-cloud.com";
  private final String url = driver+"://"+host+"/"+db;
  private Connection con = null;
  
  public boolean conectar(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url,user, pwd);
      return true;
    } catch (ClassNotFoundException | SQLException e) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return false;
  }

  public Connection getCon() {
    return con;
  }
}
