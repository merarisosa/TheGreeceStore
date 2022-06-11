/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControlRolUsuario;
import controlador.ControlUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.RolUsuario;
import modelo.Usuario;
import utils.Util;

/**
 *
 * @author merarimaysosa
 */
public class Usuarios_Agregar extends javax.swing.JFrame {

  /**
   * Creates new form Usuarios_Agregar
   */
  public Usuarios_Agregar() {
    initComponents();
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    ControlRolUsuario rolUsuario = new ControlRolUsuario();
    List<RolUsuario> lista = rolUsuario.listarTodos();
    ArrayList<String> arrlista = new ArrayList();
    for (RolUsuario rol : lista) {
      arrlista.add(rol.getNombre());
    }
    this.comboRol.setModel(new DefaultComboBoxModel(arrlista.toArray(String[]::new)));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel = new javax.swing.JPanel();
    divs = new javax.swing.JPanel();
    imgs = new javax.swing.JPanel();
    img_logo = new javax.swing.JPanel();
    txt = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    boton_dentro = new javax.swing.JPanel();
    agregar = new javax.swing.JButton();
    regresa = new javax.swing.JButton();
    data = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    campoUsuario = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    comboRol = new javax.swing.JComboBox<>();
    campoContrasena = new javax.swing.JPasswordField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    divs.setLayout(new java.awt.GridLayout(1, 2));

    img_logo.setBackground(new java.awt.Color(255, 255, 255));
    img_logo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 3));

    txt.setFont(new java.awt.Font("Cute Cartoon", 1, 36)); // NOI18N
    txt.setText("Agregar usuario");

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-user.png"))); // NOI18N

    boton_dentro.setBackground(new java.awt.Color(204, 204, 255));
    boton_dentro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    agregar.setText("Agregar");
    agregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        agregarActionPerformed(evt);
      }
    });

    regresa.setText("Regresar");
    regresa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        regresaActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout boton_dentroLayout = new javax.swing.GroupLayout(boton_dentro);
    boton_dentro.setLayout(boton_dentroLayout);
    boton_dentroLayout.setHorizontalGroup(
      boton_dentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(boton_dentroLayout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(boton_dentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(agregar)
          .addComponent(regresa))
        .addContainerGap(32, Short.MAX_VALUE))
    );

    boton_dentroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {agregar, regresa});

    boton_dentroLayout.setVerticalGroup(
      boton_dentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boton_dentroLayout.createSequentialGroup()
        .addContainerGap(25, Short.MAX_VALUE)
        .addComponent(agregar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(regresa)
        .addGap(25, 25, 25))
    );

    boton_dentroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {agregar, regresa});

    javax.swing.GroupLayout img_logoLayout = new javax.swing.GroupLayout(img_logo);
    img_logo.setLayout(img_logoLayout);
    img_logoLayout.setHorizontalGroup(
      img_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(img_logoLayout.createSequentialGroup()
        .addGroup(img_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(img_logoLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addGroup(img_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(txt)
              .addGroup(img_logoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(boton_dentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(img_logoLayout.createSequentialGroup()
            .addGap(78, 78, 78)
            .addComponent(jLabel1)))
        .addContainerGap(20, Short.MAX_VALUE))
    );
    img_logoLayout.setVerticalGroup(
      img_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(img_logoLayout.createSequentialGroup()
        .addGap(27, 27, 27)
        .addComponent(txt)
        .addGap(31, 31, 31)
        .addComponent(jLabel1)
        .addGap(35, 35, 35)
        .addComponent(boton_dentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(47, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout imgsLayout = new javax.swing.GroupLayout(imgs);
    imgs.setLayout(imgsLayout);
    imgsLayout.setHorizontalGroup(
      imgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(img_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    imgsLayout.setVerticalGroup(
      imgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(img_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    divs.add(imgs);

    data.setBackground(new java.awt.Color(204, 204, 255));
    data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 3));

    jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    jLabel5.setText("Usuario:");

    jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    jLabel6.setText("Contraseña:");

    jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    jLabel7.setText("Rol:");

    comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout dataLayout = new javax.swing.GroupLayout(data);
    data.setLayout(dataLayout);
    dataLayout.setHorizontalGroup(
      dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataLayout.createSequentialGroup()
        .addGap(0, 63, Short.MAX_VALUE)
        .addComponent(jLabel6)
        .addGap(68, 68, 68))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataLayout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(campoContrasena)
          .addComponent(comboRol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(campoUsuario, javax.swing.GroupLayout.Alignment.LEADING))
        .addGap(32, 32, 32))
      .addGroup(dataLayout.createSequentialGroup()
        .addGroup(dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(dataLayout.createSequentialGroup()
            .addGap(73, 73, 73)
            .addComponent(jLabel5))
          .addGroup(dataLayout.createSequentialGroup()
            .addGap(95, 95, 95)
            .addComponent(jLabel7)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    dataLayout.setVerticalGroup(
      dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(dataLayout.createSequentialGroup()
        .addGap(39, 39, 39)
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel6)
        .addGap(14, 14, 14)
        .addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(60, Short.MAX_VALUE))
    );

    dataLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoUsuario, comboRol});

    divs.add(data);

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(divs, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    panelLayout.setVerticalGroup(
      panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(divs, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void regresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresaActionPerformed
      // TODO add your handling code here:
      this.setVisible(false);
      new Admin_Usuarios().setVisible(true);
    }//GEN-LAST:event_regresaActionPerformed

  private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
    // TODO add your handling code here:
    String nombre = this.campoUsuario.getText();
    String pwd = new String(this.campoContrasena.getPassword());
    String pwdEncriptado = Util.encriptar(pwd);
    int rol = this.comboRol.getSelectedIndex() + 1;
    String folioRol = Util.generarFolio("ROL", String.valueOf(rol));
    
    if(nombre.length() > 0 && pwd.length() > 0){
      ControlUsuario usuario = new ControlUsuario();
      List<Usuario> lista = usuario.listarTodos();
      int cantidadUsuarios = lista.size();
      int siguiente = cantidadUsuarios + 1;
      String folioUsu = Util.generarFolio("USU", String.valueOf(siguiente));
      Usuario usu = new Usuario(folioUsu, nombre, pwdEncriptado,new RolUsuario(folioRol));
      if(usuario.insertar(usu)){
        JOptionPane.showMessageDialog(this, "Usuario agragado con éxito", 
                "Eureka!", JOptionPane.INFORMATION_MESSAGE);
        this.campoUsuario.setText("");
        this.campoContrasena.setText("");
      }else{
        JOptionPane.showMessageDialog(this, "Algo salió mal, intente más tarde", 
                "Oh no!", JOptionPane.ERROR_MESSAGE);
      }
    }else{
      JOptionPane.showMessageDialog(this, "Ambos campos deben ser llenados", 
              "Ojo!", JOptionPane.WARNING_MESSAGE);
    }
  }//GEN-LAST:event_agregarActionPerformed

  /**
   * @param args the command line arguments
   */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Usuarios_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Usuarios_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Usuarios_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Usuarios_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Usuarios_Agregar().setVisible(true);
//            }
//        });
//    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton agregar;
  private javax.swing.JPanel boton_dentro;
  private javax.swing.JPasswordField campoContrasena;
  private javax.swing.JTextField campoUsuario;
  private javax.swing.JComboBox<String> comboRol;
  private javax.swing.JPanel data;
  private javax.swing.JPanel divs;
  private javax.swing.JPanel img_logo;
  private javax.swing.JPanel imgs;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel panel;
  private javax.swing.JButton regresa;
  private javax.swing.JLabel txt;
  // End of variables declaration//GEN-END:variables
}
