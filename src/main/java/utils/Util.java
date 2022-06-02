/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.DAOGeneral;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MagicPOS
 */
public final class Util {
  public static String generarFolio(String sufijo, String numReg){
    String num = "00000";
    int pos = num.length() - numReg.length();
    
    return sufijo+"-"+num.substring(0,pos) + numReg;
  }
  
  public static String encriptar(String pwd){
    try {
       MessageDigest md = MessageDigest.getInstance("SHA-1");
       byte[] messageDigest = md.digest(pwd.getBytes());
       BigInteger no = new BigInteger(1, messageDigest);
       String hashtext = no.toString(16);
       while (hashtext.length() < 32) {
           hashtext = "0" + hashtext;
       }
       return hashtext;
   }
   catch (NoSuchAlgorithmException e) {
       throw new RuntimeException(e);
    }
  }
  
  public static boolean validarRegex(String cadena, String regex){
    return true;
  }
  
  public static void eliminarRegistro(JTable tabla, DAOGeneral controlador, JFrame contexto){
    int filaSeleccionada = tabla.getSelectedRow();
    if(filaSeleccionada == -1){
      JOptionPane.showMessageDialog(contexto, "Seleccione una fila para realizar esta operación",
            "Upsi!", JOptionPane.WARNING_MESSAGE);
    }else{
      String key = tabla.getValueAt(filaSeleccionada, 0).toString();
      if(controlador.eliminar(key)){
        DefaultTableModel dftable = (DefaultTableModel) tabla.getModel();
        dftable.removeRow(filaSeleccionada);
        JOptionPane.showMessageDialog(contexto, "Registro eliminado con éxito",
              "Eureka!", JOptionPane.INFORMATION_MESSAGE);
      }else{
        JOptionPane.showMessageDialog(contexto, "Algo salió mal, intente más tarde",
              "Oh no!", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  public static void renderizarTabla(JTable tabla, JFrame contexto, JTextField buscador,
          List todos, List filtro, String match, DAOGeneral controlador){
    if(match.length() > 0){
      if(filtro.isEmpty()){
        JOptionPane.showMessageDialog(contexto, "Se encontraron cero coincidencias",
              "Upsi!", JOptionPane.WARNING_MESSAGE);
            tabla.setModel(controlador.getTableModel(todos));
            buscador.setText("");
      }else{
        System.out.println("L");
        tabla.setModel(controlador.getTableModel(filtro));
        System.out.println("F");
      }
    }else{
      JOptionPane.showMessageDialog(contexto, "El buscador está vacío. Por favor, llénelo.",
              "Upsi!", JOptionPane.WARNING_MESSAGE);
      tabla.setModel(controlador.getTableModel(todos));
    }
  }
}
