/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAOProducto;
import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author cocol
 */
public class ControlProducto implements DAOProducto{

  @Override
  public Producto consultar(String id) {
    try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM Categoria WHERE Cat_Folio='" + id + "'");
      if (resultado.next()) {
        return new Producto(
          id,
          resultado.getString("Prod_Nombre"),
          resultado.getString("Prod_MedidaDescripcion"),
          resultado.getDouble("Prod_Precio"),
          resultado.getInt("Prod_Cantidad"),
          resultado.getInt("Prod_LimiteStock"),
          resultado.getShort("Prod_Descontinuado"),
          new Proveedor(resultado.getString("Prov_RFC")),
          new Categoria(resultado.getString("Cat_Folio"))
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
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
      stmt.executeUpdate("DELETE FROM Producto WHERE Prod_Clave='" + id + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean actualizar(Producto entidad) {
    Conexion conexion = new Conexion();
    conexion.conectar();
    Connection con = conexion.getCon();
    try {
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("UPDATE Producto SET Prod_Precio = '" + entidad.getPrecio() + "', "
        + "Prod_Cantidad = '" + entidad.getCantidad() + "', "
        + "Prod_LimiteStock = '" + entidad.getLimiteStock() + "', "
        + "Prod_Descontinuado = '" + entidad.getDescontinuado() + "' "
        + "WHERE Prod_Clave = '" + entidad.getClave() + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean insertar(Producto entidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Producto> listarTodos() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
