/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cocol
 */
public class Producto {
  private String clave;
  private String nombre;
  private String medidaDesc;
  private double precio;
  private int cantidad;
  private int limiteStock;
  private short descontinuado;
  private Proveedor proveedor;
  private Categoria categoria;

  public Producto(String clave, String nombre, String medidaDesc, double precio, int cantidad, int limiteStock, short descontinuado, Proveedor proveedor, Categoria categoria) {
    this.clave = clave;
    this.nombre = nombre;
    this.medidaDesc = medidaDesc;
    this.precio = precio;
    this.cantidad = cantidad;
    this.limiteStock = limiteStock;
    this.descontinuado = descontinuado;
    this.proveedor = proveedor;
    this.categoria = categoria;
  }

  public Producto(String clave, String nombre, String medidaDesc, double precio, int cantidad, int limiteStock, short descontinuado) {
    this.clave = clave;
    this.nombre = nombre;
    this.medidaDesc = medidaDesc;
    this.precio = precio;
    this.cantidad = cantidad;
    this.limiteStock = limiteStock;
    this.descontinuado = descontinuado;
  }

  public Producto(String clave) {
      this.clave = clave;
  }

  public String getClave() {
    return clave;
  }

  public String getNombre() {
    return nombre;
  }

  public String getMedidaDesc() {
    return medidaDesc;
  }

  public double getPrecio() {
    return precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public int getLimiteStock() {
    return limiteStock;
  }

  public short getDescontinuado() {
    return descontinuado;
  }

  public Proveedor getProveedor() {
    return proveedor;
  }

  public Categoria getCategoria() {
    return categoria;
  }
  
}
