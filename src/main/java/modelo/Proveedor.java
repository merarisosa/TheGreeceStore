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
public class Proveedor {
  private String rfc;
  private String nombre;
  private String contactoNombre;
  private String contactoDesc;
  private String calle;
  private String numExt;
  private String numInt;
  private String estado;
  private String ciudad;
  private String cp;
  private String correo;
  private String telefono;
  private String sitioWeb;

  public Proveedor(String rfc, String nombre, String contactoNombre, String contactoDesc, String calle, String numExt, String numInt, String estado, String ciudad, String cp, String correo, String telefono, String sitioWeb) {
    this.rfc = rfc;
    this.nombre = nombre;
    this.contactoNombre = contactoNombre;
    this.contactoDesc = contactoDesc;
    this.calle = calle;
    this.numExt = numExt;
    this.numInt = numInt;
    this.estado = estado;
    this.ciudad = ciudad;
    this.cp = cp;
    this.correo = correo;
    this.telefono = telefono;
    this.sitioWeb = sitioWeb;
  }

  public Proveedor(String rfc) {
    this.rfc = rfc;
  }

  public String getRfc() {
    return rfc;
  }

  public String getNombre() {
    return nombre;
  }

  public String getContactoNombre() {
    return contactoNombre;
  }

  public String getContactoDesc() {
    return contactoDesc;
  }

  public String getCalle() {
    return calle;
  }

  public String getNumExt() {
    return numExt;
  }

  public String getNumInt() {
    return numInt;
  }

  public String getEstado() {
    return estado;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getCp() {
    return cp;
  }

  public String getCorreo() {
    return correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getSitioWeb() {
    return sitioWeb;
  }
  
  
}
