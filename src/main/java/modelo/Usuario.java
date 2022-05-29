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
public class Usuario {
  private String folio;
  private String nombre;
  private String pwd;
  private RolUsuario rol;

  public Usuario(String folio, String nombre, String pwd, RolUsuario rol) {
    this.folio = folio;
    this.nombre = nombre;
    this.pwd = pwd;
    this.rol = rol;
  }
  
  public String getFolio() {
    return folio;
  }

  public String getNombre() {
    return nombre;
  }

  public String getPwd() {
    return pwd;
  }

  public RolUsuario getRol() {
    return rol;
  }
}
