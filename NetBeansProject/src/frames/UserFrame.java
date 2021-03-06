/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Color;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
//import java.util.Date;
import roombooking.*;

/**
 *
 * @author Jonathan
 */
public class UserFrame extends javax.swing.JFrame {

    /**
     * Creates new form usuario
     *
     * @param helper
     * @param currentUser
     */
    public UserFrame(DatabaseHelper helper, User currentUser) {
        initComponents();
        edit();
        this.helper = helper;
        this.currentUser = currentUser;
        jToggleActiveInitialize();
    }

    /**
     *
     * @param helper
     * @param currentUser
     * @param usr
     */
    public UserFrame(DatabaseHelper helper, User currentUser, User usr) {
        initComponents();
        isEditable = false;
        this.usr = usr;
        this.helper = helper;
        this.currentUser = currentUser;

        jToggleActiveInitialize();

        jTextFieldId_user.setText(usr.getUserID());
        jTextFieldCpf.setText(usr.getCpf());
        jTextFieldName.setText(usr.getName());
        jTextFieldEmail.setText(usr.getEmail());
        jTextFieldNumber.setText(usr.getPhoneNumber());
        jTextFieldPassword.setText(usr.getPassword());
        char c = usr.getUserTypeDescription().toLowerCase().charAt(1);
        switch (c) {
            case 'd':
                buttonGroupUserType.setSelected(jRadioButtonAdmin.getModel(), true);
                //jRadioButtonAdmin.setSelected(true);
                break;
            case 'l':
                buttonGroupUserType.setSelected(jRadioButtonStudant.getModel(), true);
                jRadioButtonStudant.setSelected(true);
                break;
            case 'r':
                jRadioButtonProfessor.setSelected(true);
                break;

        }

        Date birth = usr.getBirth();
        jFormattedTextFieldData.setText(formatDate(birth));

        if (usr.getGender().charAt(0) == 'M') {
            jRadioButtonM.setSelected(true);
            jRadioButtonF.setSelected(false);
        } else if (usr.getGender().charAt(0) == 'F') {
            jRadioButtonF.setSelected(true);
            jRadioButtonM.setSelected(false);
        }
    }

    private void jToggleActiveInitialize() {

        if (usr != null && currentUser != null) {
            if (currentUser.getUserTypeID() == User.ADMIN) {
                jToggleActive.setVisible(true);
            } else {
                jToggleActive.setVisible(false);
            }
            if (usr.getActive() == 1) { // user is active
                jToggleActive.setSelected(true);
                jToggleActive.setText("ATIVO");
                jToggleActive.setForeground(Color.CYAN);
            } else {
                jToggleActive.setText("INATIVO");
                jToggleActive.setSelected(false);
                jToggleActive.setForeground(Color.RED);
            }
        }

    }

    private void edit() {
        isEditable = true;

        jTextFieldId_user.setEditable(true);
        jTextFieldCpf.setEditable(true);
        jTextFieldName.setEditable(true);
        jTextFieldEmail.setEditable(true);
        jTextFieldNumber.setEditable(true);
        jTextFieldPassword.setEditable(true);
        jFormattedTextFieldData.setEditable(true);
        jRadioButtonM.setEnabled(true);
        jRadioButtonF.setEnabled(true);
        jRadioButtonAdmin.setEnabled(true);
        jRadioButtonStudant.setEnabled(true);
        jRadioButtonProfessor.setEnabled(true);

        jButtonEditar.setText("Salvar");
    }

    private String formatDate(Date d) {
        String date = d.toString();

        String year;
        String month;
        String day;

        year = "" + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
        month = "" + date.charAt(5) + date.charAt(6);
        day = "" + date.charAt(8) + date.charAt(9);

        return day + "/" + month + "/" + year;
    }

    private Date formatDateBack(String date) {
        String year;
        String month;
        String day;

        year = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
        month = "" + date.charAt(3) + date.charAt(4);
        day = "" + date.charAt(0) + date.charAt(1);

        Date d;
        d = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        return d;
    }

    private String formatDateBackStr(String date) {
        String year;
        String month;
        String day;

        year = "" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9);
        month = "" + date.charAt(3) + date.charAt(4);
        day = "" + date.charAt(0) + date.charAt(1);

        return year + "-" + month + "-" + day;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        buttonGroupUserType = new javax.swing.ButtonGroup();
        jButtonInicio = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelUser_type = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelGender = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jRadioButtonF = new javax.swing.JRadioButton();
        jRadioButtonM = new javax.swing.JRadioButton();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jTextFieldId_user = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldNumber = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelWarning = new javax.swing.JLabel();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jRadioButtonStudant = new javax.swing.JRadioButton();
        jRadioButtonProfessor = new javax.swing.JRadioButton();
        jButtonEditar = new javax.swing.JButton();
        jToggleActive = new javax.swing.JToggleButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(932, 659));
        setResizable(false);
        setSize(new java.awt.Dimension(932, 670));
        getContentPane().setLayout(null);

        jButtonInicio.setText("Inicio");
        jButtonInicio.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonInicio.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonInicio.setOpaque(false);
        jButtonInicio.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio);
        jButtonInicio.setBounds(80, 80, 80, 30);

        jLabelID.setForeground(new java.awt.Color(240, 240, 240));
        jLabelID.setText("ID");
        getContentPane().add(jLabelID);
        jLabelID.setBounds(80, 150, 34, 16);

        jLabelCpf.setForeground(new java.awt.Color(240, 240, 240));
        jLabelCpf.setText("CPF");
        getContentPane().add(jLabelCpf);
        jLabelCpf.setBounds(80, 220, 34, 16);

        jLabelEmail.setForeground(new java.awt.Color(240, 240, 240));
        jLabelEmail.setText("Email");
        getContentPane().add(jLabelEmail);
        jLabelEmail.setBounds(80, 500, 34, 16);

        jLabelUser_type.setForeground(new java.awt.Color(240, 240, 240));
        jLabelUser_type.setText("Tipo de Usuário");
        getContentPane().add(jLabelUser_type);
        jLabelUser_type.setBounds(500, 300, 150, 16);

        jLabelName.setForeground(new java.awt.Color(240, 240, 240));
        jLabelName.setText("Nome");
        getContentPane().add(jLabelName);
        jLabelName.setBounds(80, 290, 34, 16);

        jLabelGender.setForeground(new java.awt.Color(240, 240, 240));
        jLabelGender.setText("Genero");
        getContentPane().add(jLabelGender);
        jLabelGender.setBounds(500, 150, 60, 16);

        jLabelDate.setForeground(new java.awt.Color(240, 240, 240));
        jLabelDate.setText("Data de Nascimento");
        getContentPane().add(jLabelDate);
        jLabelDate.setBounds(500, 220, 130, 16);

        jLabelNumber.setForeground(new java.awt.Color(240, 240, 240));
        jLabelNumber.setText("Telefone");
        getContentPane().add(jLabelNumber);
        jLabelNumber.setBounds(80, 430, 80, 16);

        jLabelPassword.setForeground(new java.awt.Color(240, 240, 240));
        jLabelPassword.setText("Senha");
        getContentPane().add(jLabelPassword);
        jLabelPassword.setBounds(80, 360, 60, 16);

        buttonGroupGender.add(jRadioButtonF);
        jRadioButtonF.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonF.setText("Feminino");
        jRadioButtonF.setEnabled(false);
        jRadioButtonF.setOpaque(false);
        getContentPane().add(jRadioButtonF);
        jRadioButtonF.setBounds(610, 180, 80, 28);

        buttonGroupGender.add(jRadioButtonM);
        jRadioButtonM.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonM.setText("Masculino");
        jRadioButtonM.setEnabled(false);
        jRadioButtonM.setOpaque(false);
        getContentPane().add(jRadioButtonM);
        jRadioButtonM.setBounds(500, 180, 80, 28);

        jFormattedTextFieldData.setEditable(false);
        jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldData.setText("DD/MM/AAAA");
        jFormattedTextFieldData.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jFormattedTextFieldData);
        jFormattedTextFieldData.setBounds(500, 240, 90, 30);

        jTextFieldId_user.setEditable(false);
        getContentPane().add(jTextFieldId_user);
        jTextFieldId_user.setBounds(80, 170, 270, 30);

        jTextFieldCpf.setEditable(false);
        getContentPane().add(jTextFieldCpf);
        jTextFieldCpf.setBounds(80, 240, 270, 30);

        jTextFieldPassword.setEditable(false);
        getContentPane().add(jTextFieldPassword);
        jTextFieldPassword.setBounds(80, 380, 270, 30);

        jTextFieldName.setEditable(false);
        jTextFieldName.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jTextFieldName);
        jTextFieldName.setBounds(80, 310, 270, 30);

        jTextFieldNumber.setEditable(false);
        getContentPane().add(jTextFieldNumber);
        jTextFieldNumber.setBounds(80, 450, 270, 30);

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(270, 30));
        getContentPane().add(jTextFieldEmail);
        jTextFieldEmail.setBounds(80, 520, 270, 30);

        jLabelWarning.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(jLabelWarning);
        jLabelWarning.setBounds(80, 580, 340, 30);

        buttonGroupUserType.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonAdmin.setText("Administrador");
        jRadioButtonAdmin.setEnabled(false);
        jRadioButtonAdmin.setOpaque(false);
        getContentPane().add(jRadioButtonAdmin);
        jRadioButtonAdmin.setBounds(500, 330, 110, 28);

        buttonGroupUserType.add(jRadioButtonStudant);
        jRadioButtonStudant.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonStudant.setText("Aluno");
        jRadioButtonStudant.setEnabled(false);
        jRadioButtonStudant.setOpaque(false);
        getContentPane().add(jRadioButtonStudant);
        jRadioButtonStudant.setBounds(610, 330, 64, 28);

        buttonGroupUserType.add(jRadioButtonProfessor);
        jRadioButtonProfessor.setForeground(new java.awt.Color(240, 240, 240));
        jRadioButtonProfessor.setText("Professor");
        jRadioButtonProfessor.setEnabled(false);
        jRadioButtonProfessor.setOpaque(false);
        getContentPane().add(jRadioButtonProfessor);
        jRadioButtonProfessor.setBounds(680, 330, 100, 28);

        jButtonEditar.setText("Editar");
        jButtonEditar.setOpaque(false);
        jButtonEditar.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar);
        jButtonEditar.setBounds(760, 580, 80, 30);

        jToggleActive.setText("INATIVO");
        jToggleActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleActiveActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleActive);
        jToggleActive.setBounds(510, 410, 80, 32);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        int userTypeID;
        String gender;

        // TODO verify all inputTextField
        if (jTextFieldId_user.getText().equals("") || jTextFieldCpf.equals("")) {
            return;
        }

        if (jRadioButtonAdmin.isSelected()) {
            userTypeID = User.ADMIN;
        } else if (jRadioButtonProfessor.isSelected()) {
            userTypeID = User.PROFESSOR;
        } else {
            userTypeID = User.STUDENT;
        }

        if (jRadioButtonF.isSelected()) {
            gender = "F";
        } else {
            gender = "M";
        }

        if (!isEditable) {
            edit();
        } else if (usr == null) {

            try {
                helper.addUser(
                        jTextFieldId_user.getText(),
                        jTextFieldCpf.getText(),
                        userTypeID,
                        jTextFieldEmail.getText(),
                        jTextFieldNumber.getText(),
                        jTextFieldName.getText(),
                        gender.charAt(0),
                        formatDateBackStr(jFormattedTextFieldData.getText()),
                        jTextFieldPassword.getText(),
                        1); // flag for active user

                //usr = helper.getUserByCPF(jTextFieldCpf.getText());
                usr = null;
                resetInputFields();

                jLabelWarning.setForeground(Color.CYAN);
                jLabelWarning.setText("Usuário adicionado com sucesso.");
            } catch (KeyExistsException ex) {
                Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
                jLabelWarning.setForeground(Color.RED);
                jLabelWarning.setText("Conflito, o usuário já existe!");
            }
            /*catch (KeyNotFoundException ex) {
                Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
                jLabelWarning.setText("Usuário não encontrado.");
            /*catch (KeyNotFoundException ex) {
                Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
                jLabelWarning.setText("Usuário não encontrado.");
            }*/

        } else {
            String oldUsr = usr.getUserID();

            usr.setUserTypeID((byte) userTypeID);
            usr.setUserTypeDescription(jTextFieldPassword.getText());
            usr.setCpf(jTextFieldCpf.getText());
            usr.setName(jTextFieldName.getText());
            usr.setGender(gender);
            usr.setBirth(formatDateBack(jFormattedTextFieldData.getText()));
            usr.setPhoneNumber(jTextFieldNumber.getText());
            usr.setEmail(jTextFieldEmail.getText());
            usr.setPassword(jTextFieldPassword.getText());

            helper.updateUser(oldUsr, usr);
        }

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
        new StartFrame(helper, currentUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jToggleActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleActiveActionPerformed

        if (usr.getUserTypeID() == User.ADMIN) {
            jToggleActive.setSelected(true);
            return;
        }

        if (jToggleActive.getText().equals("ATIVO")) {
            jToggleActive.setText("INATIVO");
            jToggleActive.setForeground(Color.RED);
        } else {
            jToggleActive.setText("ATIVO");
            jToggleActive.setForeground(Color.CYAN);
        }

        helper.reverseUserActivation(usr);

    }//GEN-LAST:event_jToggleActiveActionPerformed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame(new DatabaseHelper(), new User()).setVisible(true);
            }
        });
    }

    private void resetInputFields() {

        jTextFieldId_user.setText(null);
        jTextFieldCpf.setText(null);
        jTextFieldName.setText(null);
        jTextFieldPassword.setText(null);
        jTextFieldNumber.setText(null);
        jTextFieldEmail.setText(null);
        jFormattedTextFieldData.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.ButtonGroup buttonGroupUserType;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUser_type;
    private javax.swing.JLabel jLabelWarning;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonF;
    private javax.swing.JRadioButton jRadioButtonM;
    private javax.swing.JRadioButton jRadioButtonProfessor;
    private javax.swing.JRadioButton jRadioButtonStudant;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldId_user;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumber;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JToggleButton jToggleActive;
    // End of variables declaration//GEN-END:variables
    private User usr;
    private boolean isEditable;
    private DatabaseHelper helper;
    private User currentUser;

}
