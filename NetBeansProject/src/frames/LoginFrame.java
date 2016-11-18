package frames;

import java.util.logging.Level;
import java.util.logging.Logger;
import roombooking.DatabaseHelper;
import roombooking.KeyNotFoundException;
import roombooking.User;

/**
 *
 * @author Jonathan
 */
public class LoginFrame extends javax.swing.JFrame {

    private DatabaseHelper mDatabaseHelper;

    /**
     * Creates new form login
     */
    public LoginFrame() {
        mDatabaseHelper = new DatabaseHelper();
        initComponents();
        jFeedBackLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUserTextField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLoginButton = new javax.swing.JButton();
        reserva = new javax.swing.JLabel();
        ci = new javax.swing.JLabel();
        uf = new javax.swing.JLabel();
        jFeedBackLabel = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(932, 659));
        setResizable(false);
        setSize(new java.awt.Dimension(932, 659));
        getContentPane().setLayout(null);

        jUserTextField.setText("Usuário");
        jUserTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jUserTextField);
        jUserTextField.setBounds(326, 270, 280, 30);

        jPasswordField.setPreferredSize(new java.awt.Dimension(42, 20));
        getContentPane().add(jPasswordField);
        jPasswordField.setBounds(326, 330, 280, 30);

        jLoginButton.setText("Login");
        jLoginButton.setBorderPainted(false);
        jLoginButton.setOpaque(false);
        jLoginButton.setPreferredSize(new java.awt.Dimension(60, 23));
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jLoginButton);
        jLoginButton.setBounds(430, 390, 60, 23);

        reserva.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        reserva.setForeground(new java.awt.Color(255, 255, 255));
        reserva.setText("Reserva de Salas");
        getContentPane().add(reserva);
        reserva.setBounds(400, 90, 160, 22);

        ci.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ci.setForeground(new java.awt.Color(255, 255, 255));
        ci.setText("Centro de Informática");
        getContentPane().add(ci);
        ci.setBounds(380, 130, 190, 20);

        uf.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        uf.setForeground(new java.awt.Color(255, 255, 255));
        uf.setText("Universidade Federal da Paraíba");
        getContentPane().add(uf);
        uf.setBounds(330, 160, 290, 20);

        jFeedBackLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jFeedBackLabel.setForeground(new java.awt.Color(255, 153, 153));
        jFeedBackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jFeedBackLabel.setText("sdadsd");
        jFeedBackLabel.setToolTipText("");
        getContentPane().add(jFeedBackLabel);
        jFeedBackLabel.setBounds(330, 460, 260, 19);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        Background.setFocusable(false);
        Background.setRequestFocusEnabled(false);
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Starts when there is an event from login button. Verifies the login and
     * password from user input. If the user is authenticated, starts the
     * initial screen.
     *
     * @param evt from button when clicked
     */
    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed

        // Gets input from user.
        final String loginInput = "2016999999";//jUserTextField.getText();
        final String passwordInput = "123";//String.valueOf(jPasswordField.getPassword());
        
        // Checks if some input field is missing.
        if (loginInput.equals("") || passwordInput.equals("")) {
            jFeedBackLabel.setVisible(true);
            jFeedBackLabel.setText("Preencha os campos corretamente.");
        } else {

            User user = null;
            try {
                user = mDatabaseHelper.getUserByID(loginInput);
                if(user.getActive() == 0){
                    jFeedBackLabel.setVisible(true);
                    jFeedBackLabel.setText("Usuário inativo.");
                    return;
                }
                if (user.getUserID().equals(loginInput)) {
                    if (passwordInput.equals(user.getPassword())) {
                        startsInitialScreen(user);
                    } else {
                        jFeedBackLabel.setVisible(true);
                        jFeedBackLabel.setText("Senha inválida.");
                    }
                }
            } catch (KeyNotFoundException ex) {
                try {
                    user = mDatabaseHelper.getUserByCPF(loginInput);
                    startsInitialScreen(user);
                } catch (KeyNotFoundException ex1) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex1);
                    jFeedBackLabel.setVisible(true);
                    jFeedBackLabel.setText("Usuário ou senha inválidos.");
                }
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void startsInitialScreen(User user) {
        StartFrame mInicio = new StartFrame(mDatabaseHelper, user);
        this.dispose();
        mInicio.setVisible(true);
    }

    private void jUserTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel ci;
    private javax.swing.JLabel jFeedBackLabel;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jUserTextField;
    private javax.swing.JLabel reserva;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
