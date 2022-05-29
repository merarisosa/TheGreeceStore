/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.DetalleVenta;

/**
 *
 * @author cocol
 */
public interface DAODetalleVenta extends DAOGeneral<DetalleVenta,String>{
  public double calcularPrecioPorProducto(DetalleVenta venta);
  public double calcularTotalVentas(List<DetalleVenta> ventas);
  public double calcularCambioTotal(List<DetalleVenta> ventas, double cantidadRecibida);
  public boolean generarTicket(List<DetalleVenta> ventas);
}
