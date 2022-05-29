/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MagicPOS
 */
public class RolUsuario {
  private String folioRol;
  private String nombre;

  public RolUsuario(String folioRol, String nombre) {
    this.folioRol = folioRol;
    this.nombre = nombre;
  }
  
  public RolUsuario(String folioRol) {
    this.folioRol = folioRol;
  }

  public String getFolioRol() {
    return folioRol;
  }

  public String getNombre() {
    return nombre;
  }
  
  
  
}
