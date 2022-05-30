/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JFrame;
import modelo.RolUsuario;
import modelo.Usuario;

/**
 *
 * @author MagicPOS
 */
public interface DAORolUsuario extends DAOGeneral<RolUsuario,String>{
  public void accesoPorRol(Usuario usuario, JFrame anterior);
}
