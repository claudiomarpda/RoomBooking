/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

/**
 *
 * @author Jonathan
 */
public class reserva extends javax.swing.JFrame {

    /**
     * Creates new form usuario
     */
    public reserva() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelID = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUser_type = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jRadioButtonF = new javax.swing.JRadioButton();
        jRadioButtonM = new javax.swing.JRadioButton();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jTextFieldId_user = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldUser_type = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldNumber = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonEditar1 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(932, 659));
        setMinimumSize(new java.awt.Dimension(932, 659));
        setResizable(false);
        setSize(new java.awt.Dimension(932, 670));
        getContentPane().setLayout(null);

        jLabelID.setForeground(new java.awt.Color(240, 240, 240));
        jLabelID.setText("ID");
        getContentPane().add(jLabelID);
        jLabelID.setBounds(70, 60, 34, 16);

        jLabelCpf.setForeground(new java.awt.Color(240, 240, 240));
        jLabelCpf.setText("CPF");
        getContentPane().add(jLabelCpf);
        jLabelCpf.setBounds(70, 130, 34, 16);

        jLabelEmail.setForeground(new java.awt.Color(240, 240, 240));
        jLabelEmail.setText("Email");
        getContentPane().add(jLabelEmail);
        jLabelEmail.setBounds(70, 560, 34, 16);

        jLabelUser_type.setForeground(new java.awt.Color(240, 240, 240));
        jLabelUser_type.setText("Tipo de Usuário");
        getContentPane().add(jLabelUser_type);
        jLabelUser_type.setBounds(70, 200, 80, 16);

        jLabelName.setForeground(new java.awt.Color(240, 240, 240));
        jLabelName.setText("Nome");
        getContentPane().add(jLabelName);
        jLabelName.setBounds(70, 270, 34, 16);

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Genero");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 340, 60, 16);

        jLabelData.setForeground(new java.awt.Color(240, 240, 240));
        jLabelData.setText("Data de Nascimento");
        getContentPane().add(jLabelData);
        jLabelData.setBounds(70, 410, 130, 16);

        jLabelNumber.setForeground(new java.awt.Color(240, 240, 240));
        jLabelNumber.setText("Telefone");
        getContentPane().add(jLabelNumber);
        jLabelNumber.setBounds(70, 490, 80, 16);

        buttonGroup1.add(jRadioButtonF);
        jRadioButtonF.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonF.setText("Feminino");
        jRadioButtonF.setEnabled(false);
        jRadioButtonF.setOpaque(false);
        getContentPane().add(jRadioButtonF);
        jRadioButtonF.setBounds(180, 370, 80, 28);

        buttonGroup1.add(jRadioButtonM);
        jRadioButtonM.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonM.setText("Masculino");
        jRadioButtonM.setEnabled(false);
        jRadioButtonM.setOpaque(false);
        getContentPane().add(jRadioButtonM);
        jRadioButtonM.setBounds(70, 370, 80, 28);

        jFormattedTextFieldData.setEditable(false);
        jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldData.setText("DD/MM/AAAA");
        jFormattedTextFieldData.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jFormattedTextFieldData);
        jFormattedTextFieldData.setBounds(70, 430, 90, 30);

        jTextFieldId_user.setEditable(false);
        getContentPane().add(jTextFieldId_user);
        jTextFieldId_user.setBounds(70, 80, 270, 30);

        jTextFieldCpf.setEditable(false);
        getContentPane().add(jTextFieldCpf);
        jTextFieldCpf.setBounds(70, 150, 270, 30);

        jTextFieldUser_type.setEditable(false);
        getContentPane().add(jTextFieldUser_type);
        jTextFieldUser_type.setBounds(70, 220, 270, 30);

        jTextFieldName.setEditable(false);
        jTextFieldName.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jTextFieldName);
        jTextFieldName.setBounds(70, 290, 270, 30);

        jTextFieldNumber.setEditable(false);
        getContentPane().add(jTextFieldNumber);
        jTextFieldNumber.setBounds(70, 510, 270, 30);

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(70, 580, 270, 30);

        jButtonEditar.setText("Editar");
        jButtonEditar.setOpaque(false);
        getContentPane().add(jButtonEditar);
        jButtonEditar.setBounds(780, 530, 90, 32);

        jButtonEditar1.setText("Reservas");
        jButtonEditar1.setOpaque(false);
        getContentPane().add(jButtonEditar1);
        jButtonEditar1.setBounds(780, 580, 90, 32);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEditar1;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelUser_type;
    private javax.swing.JRadioButton jRadioButtonF;
    private javax.swing.JRadioButton jRadioButtonM;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldId_user;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldUser_type;
    // End of variables declaration//GEN-END:variables
}
