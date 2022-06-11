/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOUsuario;
import database.Conexion;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.RolUsuario;
import modelo.Usuario;
import utils.Util;

/**
 *
 * @author MagicPOS
 */
public class ControlUsuario implements DAOUsuario {

  @Override
  public boolean login(Usuario usuario) {
    return (usuario != null);
  }

  @Override
  public Usuario consultar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Usuario WHERE Usu_Folio='" + id + "'");
      if (resultado.next()) {
        return new Usuario(
                id,
                resultado.getString("Usu_Nombre"),
                resultado.getString("Usu_Pwd"),
                new RolUsuario(
                        resultado.getString("RolUsu_Folio")
                )
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public Usuario consultar(String nombre, String password) {
    String pwdEncrypt = Util.encriptar(password);
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Usuario WHERE "
              + "Usu_Nombre='" + nombre + "' and Usu_Pwd='" + pwdEncrypt + "'");
      if (resultado.next()) {
        return new Usuario(
                resultado.getString("Usu_Folio"),
                nombre,
                pwdEncrypt,
                new RolUsuario(
                        resultado.getString("RolUsu_Folio")
                )
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
      stmt.executeUpdate("DELETE FROM Usuario WHERE Usu_Folio='" + id + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean actualizar(Usuario entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("UPDATE Usuario SET Usu_Nombre = '" + entidad.getNombre() + "'"
              + "WHERE Usu_Folio = '" + entidad.getFolio() + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean insertar(Usuario entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO Usuario "
              + "VALUES ('" + entidad.getFolio() + "', "
              + "'" + entidad.getNombre() + "', "
              + "'" + entidad.getRol().getFolioRol() + "', "
              + "'" + entidad.getPwd() + "')");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlRolUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public List<Usuario> listarTodos() {
    LinkedList<Usuario> lista = new LinkedList<>();
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Usuario");
      while (resultado.next()) {
        lista.add(new Usuario(
                resultado.getString("Usu_Folio"),
                resultado.getString("Usu_Nombre"),
                resultado.getString("Usu_Pwd"),
                new RolUsuario(
                        resultado.getString("RolUsu_Folio")
                )
        ));
      }
      con.close();
      return lista;
    } catch (SQLException ex) {
      Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public DefaultTableModel getTableModel(List<Usuario> lista) {
    String[] encabezados = {"Folio", "Nombre", "Rol", "Contraseña"};
    DefaultTableModel dftModel = new DefaultTableModel(encabezados, 0){
      @Override
      public boolean isCellEditable(int row, int column) {
        return column == 1;
      }
    };
    LinkedList<Usuario> listaUsu = (LinkedList<Usuario>) lista;
    for (Usuario usu : listaUsu) {
      dftModel.addRow(new Object[]{
        usu.getFolio(),
        usu.getNombre(),
        usu.getRol().getFolioRol(),
        usu.getPwd()
      });
    }
    return dftModel;
  }
}
