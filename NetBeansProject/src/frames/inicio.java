package frames;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class inicio extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public inicio() {
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

        jLabel_salas = new javax.swing.JLabel();
        jLabel_reserva = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_disponibilidade = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(932, 659));
        setSize(new java.awt.Dimension(932, 659));
        getContentPane().setLayout(null);

        jLabel_salas.setBackground(new java.awt.Color(0, 102, 204));
        jLabel_salas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_salas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salas.png"))); // NOI18N
        jLabel_salas.setText(" Salas");
        jLabel_salas.setOpaque(true);
        jLabel_salas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel_salasMouseReleased(evt);
            }
        });
        getContentPane().add(jLabel_salas);
        jLabel_salas.setBounds(100, 110, 320, 170);

        jLabel_reserva.setBackground(new java.awt.Color(0, 102, 204));
        jLabel_reserva.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reserva.png"))); // NOI18N
        jLabel_reserva.setText(" Adicionar reserva");
        jLabel_reserva.setOpaque(true);
        getContentPane().add(jLabel_reserva);
        jLabel_reserva.setBounds(510, 110, 320, 170);

        jLabel_usuario.setBackground(new java.awt.Color(0, 102, 204));
        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        jLabel_usuario.setText(" Usuário");
        jLabel_usuario.setOpaque(true);
        jLabel_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel_usuarioMouseReleased(evt);
            }
        });
        getContentPane().add(jLabel_usuario);
        jLabel_usuario.setBounds(100, 390, 320, 170);

        jLabel_disponibilidade.setBackground(new java.awt.Color(0, 102, 204));
        jLabel_disponibilidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_disponibilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disponibilidade.png"))); // NOI18N
        jLabel_disponibilidade.setText(" Disponibilidadede");
        jLabel_disponibilidade.setOpaque(true);
        getContentPane().add(jLabel_disponibilidade);
        jLabel_disponibilidade.setBounds(510, 390, 320, 170);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_salasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_salasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_salasMouseReleased

    private void jLabel_usuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_usuarioMouseReleased
        // TODO add your handling code here:
        new usuarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_usuarioMouseReleased

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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel jLabel_disponibilidade;
    private javax.swing.JLabel jLabel_reserva;
    private javax.swing.JLabel jLabel_salas;
    private javax.swing.JLabel jLabel_usuario;
    // End of variables declaration//GEN-END:variables
}
