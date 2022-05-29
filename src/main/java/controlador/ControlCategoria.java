/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOCategoria;
import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;

/**
 *
 * @author cocol
 */
public class ControlCategoria implements DAOCategoria{

  @Override
  public Categoria consultar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Categoria WHERE Cat_Folio='" + id + "'");
      if (resultado.next()) {
        return new Categoria(
          id,
          resultado.getString("Cat_nombre"),
          resultado.getString("Cat_descripcion")
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public boolean eliminar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("DELETE FROM Categoria WHERE Cat_Folio='" + id + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean actualizar(Categoria entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("UPDATE Categoria SET Cat_Descripcion = '" + entidad.getDescripcion() + "'"
        + "WHERE Cat_Folio = '" + entidad.getFolio() + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean insertar(Categoria entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO Categoria "
        + "VALUES ('" + entidad.getFolio() + "', "
        + "'" + entidad.getNombre() + "', "
        + "'" + entidad.getDescripcion() + "');");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public List<Categoria> listarTodos() {
    
    try {
      LinkedList<Categoria> lista = new LinkedList<>();
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Categoria");
      while (resultado.next()) {
        lista.add(new Categoria(
          resultado.getString("Cat_Folio"),
          resultado.getString("Cat_Nombre"),
          resultado.getString("Cat_Descripcion")));
      }
      con.close();
      return lista;
    } catch (SQLException ex) {
      Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
}
