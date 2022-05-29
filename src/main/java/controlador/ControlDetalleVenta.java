/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAODetalleVenta;
import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author cocol
 */
public class ControlDetalleVenta implements DAODetalleVenta{

  @Override
  public double calcularPrecioPorProducto(DetalleVenta venta) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public double calcularTotalVentas(List<DetalleVenta> ventas) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public double calcularCambioTotal(List<DetalleVenta> ventas, double cantidadRecibida) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean generarTicket(List<DetalleVenta> ventas) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public DetalleVenta consultar(String id) {
      try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM detalle_venta WHERE Venta_Folio='" + id + "'");
      if (resultado.next()) {
        return new DetalleVenta(
          id,
          new Producto(resultado.getString("Prod_Clave")),
          resultado.getInt("DetV_Cantidad"),
          resultado.getDouble("DetV_Descuento"),
          resultado.getDate("Venta_Fecha")
        );
      }
      con.close();
    } catch (SQLException ex) {
      Logger.getLogger(ControlDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
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
      stmt.executeUpdate("DELETE FROM detalle_venta WHERE Venta_Folio='" + id + "'");
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public boolean actualizar(DetalleVenta entidad) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean insertar(DetalleVenta entidad) {
     try {
      Conexion conexion = new Conexion();
      conexion.conectar();
      Connection con = conexion.getCon();
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      Statement stmt;
      stmt = con.createStatement();
      stmt.executeUpdate("INSERT INTO detalle_venta "
        + "VALUES ('" + entidad.getFolio() + "', "
        + "'" + entidad.getProducto().getClave() + "', "
        + "'" + entidad.getCantidad() + "', "
        + "'" + entidad.getDescuento() + "', "
        + "'" + formato.format(entidad.getFechaReg()) + "')"
      );
      con.close();
      return true;
    } catch (SQLException ex) {
      Logger.getLogger(ControlDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  @Override
  public List<DetalleVenta> listarTodos() {
    LinkedList<DetalleVenta> lista = new LinkedList<>();
    Conexion conexion = new Conexion();
    conexion.conectar();
    Connection con = conexion.getCon();
    try {
      Statement stmt;
      stmt = con.createStatement();
      ResultSet resultado = stmt.executeQuery("SELECT * FROM detalle_venta");
      while (resultado.next()) {
        lista.add(new DetalleVenta(
          resultado.getString("Venta_Folio"),
          new Producto(resultado.getString("Prod_Clave")),
          resultado.getInt("DetV_Cantidad"),
          resultado.getDouble("DetV_Descuento"),
          resultado.getDate("Venta_Fecha")
        ));
      }
      con.close();
      return lista;
    } catch (SQLException ex) {
      Logger.getLogger(ControlDetalleVenta.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
}
