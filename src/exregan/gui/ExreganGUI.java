/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package exregan.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import parser.Lexer;
import parser.Parser;

/**
 *
 * @author saulc
 */
public class ExreganGUI extends javax.swing.JFrame {

  /**
   * Creates new form ExreganGUI
   */
  public ExreganGUI() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    consoleArea = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    editorArea = new javax.swing.JTextArea();
    jPanel3 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    reportLabel = new javax.swing.JLabel();
    regexComboBox = new javax.swing.JComboBox<>();
    jMenuBar1 = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    openMenuItem = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    fsmGenMenu = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    jLabel1.setText("Consola:");

    consoleArea.setEditable(false);
    consoleArea.setBackground(new java.awt.Color(0, 0, 0));
    consoleArea.setColumns(20);
    consoleArea.setForeground(new java.awt.Color(255, 255, 255));
    consoleArea.setRows(5);
    jScrollPane1.setViewportView(consoleArea);

    editorArea.setColumns(20);
    editorArea.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
    editorArea.setRows(5);
    editorArea.setTabSize(2);
    jScrollPane2.setViewportView(editorArea);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jPanel1.add(jPanel2);

    jScrollPane3.setViewportView(reportLabel);

    regexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione regex" }));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jScrollPane3)
          .addComponent(regexComboBox, 0, 383, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(regexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanel1.add(jPanel3);

    fileMenu.setText("Archivo");

    openMenuItem.setText("Abrir");
    openMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(openMenuItem);

    jMenuBar1.add(fileMenu);

    jMenu2.setText("Ejecutar");

    fsmGenMenu.setText("Generar automata");
    fsmGenMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fsmGenMenuActionPerformed(evt);
      }
    });
    jMenu2.add(fsmGenMenu);

    jMenuBar1.add(jMenu2);

    jMenu3.setText("Reportes");

    jMenuItem4.setText("Arbol");
    jMenu3.add(jMenuItem4);

    jMenuItem5.setText("AFD");
    jMenu3.add(jMenuItem5);

    jMenuItem6.setText("Siguientes");
    jMenu3.add(jMenuItem6);

    jMenuItem7.setText("Transiciones");
    jMenu3.add(jMenuItem7);

    jMenuBar1.add(jMenu3);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
    final JFileChooser fc = new JFileChooser();
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      try {
        File file = fc.getSelectedFile();
        Scanner reader = new Scanner(file);
        editorArea.setText("");
        while (reader.hasNextLine()) {
          editorArea.append(reader.nextLine()+"\n");
        }
      } catch (FileNotFoundException ex) {
      }
    }
  }//GEN-LAST:event_openMenuItemActionPerformed

  private void fsmGenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsmGenMenuActionPerformed
    try {
      Lexer s = new Lexer(new java.io.StringReader(editorArea.getText()));
      Parser p = new Parser(s);
      p.parse();
      consoleArea.append("$ Archivo termniado de analizar\n");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }//GEN-LAST:event_fsmGenMenuActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ExreganGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ExreganGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ExreganGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ExreganGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ExreganGUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextArea consoleArea;
  private javax.swing.JTextArea editorArea;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem fsmGenMenu;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JMenuItem openMenuItem;
  private javax.swing.JComboBox<String> regexComboBox;
  private javax.swing.JLabel reportLabel;
  // End of variables declaration//GEN-END:variables
}