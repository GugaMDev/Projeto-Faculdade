
package projeto.a3;

import Classes.Empresas;
import Classes.Usuario;
import DAO.ConnectionFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Telalogin extends javax.swing.JFrame {

    /**
     * Creates new form Telalogin
     */
    public Telalogin() {
        initComponents();
    }
     public void abrirTelaediçãoUsu(){
         dispose();
         
         Editarusu edu = new Editarusu();
         edu.setVisible(true);
     
     }
      public void abrirTelaLoginUsu(){
         dispose();
         
         TelaloginEMp tl = new TelaloginEMp();
         tl.setVisible(true);
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtsenhalogin = new javax.swing.JPasswordField();
        cksenhalogin = new javax.swing.JCheckBox();
        txtusulogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btregistrar = new javax.swing.JButton();
        btlogar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        txtsenhalogin.setBackground(new java.awt.Color(240, 245, 241));
        txtsenhalogin.setBorder(null);
        jPanel1.add(txtsenhalogin);
        txtsenhalogin.setBounds(350, 340, 240, 30);

        cksenhalogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cksenhaloginActionPerformed(evt);
            }
        });
        jPanel1.add(cksenhalogin);
        cksenhalogin.setBounds(350, 376, 85, 20);

        txtusulogin.setBackground(new java.awt.Color(240, 245, 241));
        txtusulogin.setBorder(null);
        txtusulogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuloginActionPerformed(evt);
            }
        });
        jPanel1.add(txtusulogin);
        txtusulogin.setBounds(350, 259, 230, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CEPEEFI.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -20, 960, 640);

        btregistrar.setText("jButton1");
        btregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btregistrar);
        btregistrar.setBounds(850, 10, 80, 23);

        btlogar.setText("jButton2");
        btlogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogarActionPerformed(evt);
            }
        });
        jPanel1.add(btlogar);
        btlogar.setBounds(350, 400, 260, 30);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(420, 510, 75, 23);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(400, 457, 150, 10);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(400, 480, 150, 10);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1020, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btlogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogarActionPerformed
 //pega o login do usuário
String Cpf = txtusulogin.getText();
//pega a senha do usuário como char[] e converte para String
String Senha = new String (txtsenhalogin.getPassword());

//verifica se o usuário é válido
Usuario usu = new Usuario (Cpf, Senha);
boolean usuExiste = false;
        try {
            usuExiste = usu.login();
        } catch (SQLException ex) {
            Logger.getLogger(Telalogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
if (usuExiste){
    JOptionPane.showMessageDialog(null, "Bem vindo, " + usu.getNome()); 
dispose ();

abrirNTelaMenu();}
else 
    JOptionPane.showMessageDialog(null, "Login invalido"); 


                                           
    }//GEN-LAST:event_btlogarActionPerformed

    private void txtusuloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuloginActionPerformed

    private void cksenhaloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cksenhaloginActionPerformed
        if (cksenhalogin.isSelected()) {
            txtsenhalogin.setEchoChar((char) 0); // Exibe a senha
        } else {
            txtsenhalogin.setEchoChar('*'); // Oculta a senha
        }
    }//GEN-LAST:event_cksenhaloginActionPerformed

    private void btregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistrarActionPerformed
        abrirTelaCadUsu();
    }//GEN-LAST:event_btregistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abrirNTelaMenu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        abrirTelaediçãoUsu();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        abrirTelaLoginUsu();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void abrirNTelaMenu() {
        // Feche a tela de login
        dispose();

        // Crie e exiba a tela de menu
        NTelaMenu NTelaMenu = new NTelaMenu();
        NTelaMenu.setVisible(true);
    }
    
     public void abrirTelaCadUsu() {
        // Feche a tela de login
        dispose();

        // Crie e exiba a tela de menu
        UACadUsu TCU = new UACadUsu();
        TCU.setVisible(true);
     }
     
     public void abrirTelalogin() {
        // Feche a tela de registro
        dispose();

        // Crie e exiba a tela de menu
        Telalogin telalogin = new Telalogin();
        telalogin.setVisible(true);
     }
     
    
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
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telalogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlogar;
    private javax.swing.JButton btregistrar;
    private javax.swing.JCheckBox cksenhalogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtsenhalogin;
    private javax.swing.JTextField txtusulogin;
    // End of variables declaration//GEN-END:variables
}
