/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAORolUsuario;
import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleVenta;
import modelo.RolUsuario;
import modelo.Usuario;
import vista.Admin_Inventario;
import vista.Admin_Reportes;
import vista.Login;
import vista.Login_Admin;
import vista.Vendedor_Ventas;

/**
 *
 * @author MagicPOS
 */
public class ControlRolUsuario implements DAORolUsuario{

  @Override
  public void accesoPorRol(Usuario usuario, JFrame anterior) {
    String id = usuario.getRol().getFolioRol();
    JFrame siguiente = new JFrame();
    switch(id){
      case "ROL-00001":
        siguiente = new Login_Admin(usuario);
        break;
      case "ROL-00002":
        siguiente = new Vendedor_Ventas();
        break;
      case "ROL-00003":
        siguiente = new Admin_Inventario(anterior);
        break;
      case "ROL-00004":
        siguiente = new Admin_Reportes(anterior);
        break;
      default:
        siguiente = new Login();
    }
    siguiente.setLocationRelativeTo(anterior);
    anterior.dispose();
    siguiente.setVisible(true);
  }

  @Override
  public RolUsuario consultar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Rol_Usuario WHERE RolUsu_Folio='"+id+"'");
      if(resultado.next()){
        return new RolUsuario(
          id,
          resultado.getString("RolUsu_Nombre")
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
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean actualizar(RolUsuario entidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean insertar(RolUsuario entidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<RolUsuario> listarTodos() {
    LinkedList<RolUsuario> lista = new LinkedList<>();
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Rol_Usuario");
      while(resultado.next()){
        lista.add(new RolUsuario(
          resultado.getString("RolUsu_Folio"),
          resultado.getString("RolUsu_Nombre")
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
  public DefaultTableModel getTableModel(List<RolUsuario> lista){
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
