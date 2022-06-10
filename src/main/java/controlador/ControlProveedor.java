/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOProveedor;
import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;

/**
 *
 * @author cocol
 */
public class ControlProveedor implements DAOProveedor{

  @Override
  public Proveedor consultar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM proveedor WHERE Prov_RFC='" + id + "'");
      if (resultado.next()) {
        return new Proveedor(
          id,
          resultado.getString("Prov_Nombre"),
          resultado.getString("Prov_ContactoNombre"),
          resultado.getString("Prov_ContactoDescripcion"),
          resultado.getString("Prov_Calle"),
          resultado.getString("Prov_NumExt"),
          resultado.getString("Prov_NumInt"),
          resultado.getString("Prov_Estado"),
          resultado.getString("Prov_Ciudad"),
          resultado.getString("Prov_CP"),
          resultado.getString("Prov_Correo"),
          resultado.getString("Prov_Telefono"),
          resultado.getString("Prov_SitioWeb")
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
      stmt.executeUpdate("DELETE FROM proveedor WHERE Prov_RFC='" + id + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean actualizar(Proveedor entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("UPDATE proveedor SET "
        + "Prov_ContactoNombre = '" + entidad.getContactoNombre() + "', "
        + "Prov_ContactoDescripcion = '" + entidad.getContactoDesc() + "', "
        + "Prov_Correo = '" + entidad.getCorreo() + "', "
        + "Prov_Telefono = '" + entidad.getTelefono() + "', "
        + "WHERE Prov_RFC = '" + entidad.getRfc() + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean insertar(Proveedor entidad) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO proveedor "
              + "VALUES ('" + entidad.getRfc() + "', "
              + "'" + entidad.getNombre() + "', "
              + "'" + entidad.getContactoNombre() + "', "
              + "'" + entidad.getContactoDesc() + "', "
              + "'" + entidad.getCalle() + "', "
              + "'" + entidad.getNumExt() + "', "
              + "'" + entidad.getNumInt() + "', "
              + "'" + entidad.getEstado() + "', "
              + "'" + entidad.getCiudad() + "', "
              + "'" + entidad.getCp() + "', "
              + "'" + entidad.getCorreo() + "', "
              + "'" + entidad.getTelefono() + "', "
              + "'" + entidad.getSitioWeb() + "');");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public List<Proveedor> listarTodos() {
    LinkedList<Proveedor> lista = new LinkedList<>();
    Conexion conexion = new Conexion();
    conexion.conectar();
    Connection con = conexion.getCon();
    try {
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM proveedor");
      while (resultado.next()) {
        lista.add(new Proveedor(
          resultado.getString("Prov_RFC"),
          resultado.getString("Prov_Nombre"),
          resultado.getString("Prov_ContactoNombre"),
          resultado.getString("Prov_ContactoDescripcion"),
          resultado.getString("Prov_Calle"),
          resultado.getString("Prov_NumExt"),
          resultado.getString("Prov_NumInt"),
          resultado.getString("Prov_Estado"),
          resultado.getString("Prov_Ciudad"),
          resultado.getString("Prov_CP"),
          resultado.getString("Prov_Correo"),
          resultado.getString("Prov_Telefono"),
          resultado.getString("Prov_SitioWeb")
        ));
      }
      con.close();
      return lista;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  @Override
  public DefaultTableModel getTableModel(List<Proveedor> lista){
    String[] encabezados2 = {"Folio", "Nombre","Contacto", "Descripción", "Teléfono", "Correo"};
    DefaultTableModel dftModel2 = new DefaultTableModel(encabezados2, 0);
    LinkedList<Proveedor> listaProveedor = (LinkedList<Proveedor>) lista;
    for (Proveedor prov : listaProveedor) {
      dftModel2.addRow(new Object[]{
        prov.getRfc(),
        prov.getNombre(),
        prov.getContactoNombre(),
        prov.getContactoDesc(),
        prov.getTelefono(),
        prov.getCorreo()
      });
    }
    return dftModel2;
  }
  
}
