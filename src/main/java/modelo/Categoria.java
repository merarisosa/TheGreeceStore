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
public class Categoria {
  private String folio;
  private String nombre;
  private String descripcion;

  public Categoria(String folio, String nombre, String descripcion) {
    this.folio = folio;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public Categoria(String folio) {
    this.folio = folio;
  }

  public String getFolio() {
    return folio;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }
  
}
