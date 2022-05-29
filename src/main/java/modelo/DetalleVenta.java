/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author cocol
 */
public class DetalleVenta {
  private String folio;
  private Producto producto;
  private int cantidad;
  private double descuento;
  private Date fechaReg;

  public DetalleVenta(String folio, Producto producto, int cantidad, double descuento, Date fechaReg) {
    this.folio = folio;
    this.producto = producto;
    this.cantidad = cantidad;
    this.descuento = descuento;
    this.fechaReg = fechaReg;
  }

  public String getFolio() {
    return folio;
  }

  public Producto getProducto() {
    return producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public double getDescuento() {
    return descuento;
  }

  public Date getFechaReg() {
    return fechaReg;
  }
  
}
