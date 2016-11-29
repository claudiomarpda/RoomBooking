/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import roombooking.*;

/**
 *
 * @author Jonathan
 */
public class AddBookingFrame extends javax.swing.JFrame {

    private DatabaseHelper mDatabaseHelper;
    private User user;
    final ArrayList<Room> allRooms;
    private ArrayList<Room> currentList = null;

    /**
     * Creates new form for Booking
     */
    public AddBookingFrame(DatabaseHelper database, User user) {
        mDatabaseHelper = database;
        this.user = user;
        String[] types = {Room.AUDITORIO, Room.LABORATORIO, Room.PROFESSOR, Room.REUNIAO, Room.AULA};
        allRooms = mDatabaseHelper.getAllRooms();

        initComponents();

        jCBRoomType.removeAllItems();
        jCBRoomType.addItem("");
        for (int i = 0; i < types.length; i++) {
            jCBRoomType.addItem(types[i]);
        }

        updateCBRoom(jCBRoom, allRooms);
        jLabelFeedBack.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSala = new javax.swing.JLabel();
        jLabelObjetivo = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jLabelDemanda = new javax.swing.JLabel();
        jScrollPaneObejtivo = new javax.swing.JScrollPane();
        jTextPaneObjetivo = new javax.swing.JTextPane();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jFormattedTextFieldHora = new javax.swing.JFormattedTextField();
        jSpinnerDemanda = new javax.swing.JSpinner();
        jButtonSalvar = new javax.swing.JButton();
        jCBRoomType = new javax.swing.JComboBox<>();
        jLabelTipoDeSala = new javax.swing.JLabel();
        jCBRoom = new javax.swing.JComboBox<>();
        jButtonInicio = new javax.swing.JButton();
        jLabelFeedBack = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(932, 659));
        setResizable(false);
        setSize(new java.awt.Dimension(932, 659));
        getContentPane().setLayout(null);

        jLabelSala.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSala.setText("Sala");
        getContentPane().add(jLabelSala);
        jLabelSala.setBounds(70, 230, 25, 16);

        jLabelObjetivo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelObjetivo.setText("Objetivo");
        getContentPane().add(jLabelObjetivo);
        jLabelObjetivo.setBounds(70, 280, 46, 16);

        jLabelData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelData.setText("Data");
        getContentPane().add(jLabelData);
        jLabelData.setBounds(70, 400, 26, 16);

        jLabelHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHora.setText("Hora");
        getContentPane().add(jLabelHora);
        jLabelHora.setBounds(180, 400, 27, 16);

        jLabelDemanda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDemanda.setText("Demanda");
        jLabelDemanda.setToolTipText("Quantidade de pessoas a ocupar a sala.");
        getContentPane().add(jLabelDemanda);
        jLabelDemanda.setBounds(70, 480, 80, 16);

        jScrollPaneObejtivo.setViewportView(jTextPaneObjetivo);

        getContentPane().add(jScrollPaneObejtivo);
        jScrollPaneObejtivo.setBounds(71, 306, 270, 65);

        jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldData.setText("DD/MM/AAAA");
        getContentPane().add(jFormattedTextFieldData);
        jFormattedTextFieldData.setBounds(70, 420, 90, 30);

        jFormattedTextFieldHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFormattedTextFieldHora.setText("HH:mm");
        getContentPane().add(jFormattedTextFieldHora);
        jFormattedTextFieldHora.setBounds(180, 420, 91, 30);

        jSpinnerDemanda.setModel(new javax.swing.SpinnerNumberModel());
        jSpinnerDemanda.setOpaque(false);
        getContentPane().add(jSpinnerDemanda);
        jSpinnerDemanda.setBounds(70, 500, 54, 26);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setOpaque(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar);
        jButtonSalvar.setBounds(800, 570, 66, 32);

        jCBRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRoomTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jCBRoomType);
        jCBRoomType.setBounds(170, 170, 150, 26);

        jLabelTipoDeSala.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoDeSala.setText("Tipo de sala");
        getContentPane().add(jLabelTipoDeSala);
        jLabelTipoDeSala.setBounds(70, 170, 70, 16);

        jCBRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRoomActionPerformed(evt);
            }
        });
        getContentPane().add(jCBRoom);
        jCBRoom.setBounds(170, 230, 150, 26);

        jButtonInicio.setText("Início");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio);
        jButtonInicio.setBounds(70, 50, 60, 32);

        jLabelFeedBack.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelFeedBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFeedBack.setText("Feedback");
        getContentPane().add(jLabelFeedBack);
        jLabelFeedBack.setBounds(240, 580, 440, 19);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        if (jButtonSalvar.getText().equals("Salvar")) {
            saveBookingButton();
        } else {
            resetAllInputs();

            jButtonSalvar.setText("Salvar");
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void saveBookingButton() {
        int iRoomSelected = jCBRoom.getSelectedIndex() - 1;
        Room room = null;
        if (iRoomSelected > -1 || !areInputsEmpty()) {
            room = currentList.get(iRoomSelected);

            final Timestamp mTimestamp = getTimestamp(
                    jFormattedTextFieldData.getText(), // date
                    jFormattedTextFieldHora.getText()); // time

            // TODO to verify if no field is null
            String bookingSubject = jTextPaneObjetivo.getText();
            if (bookingSubject.length() > 254) { // TINY TEXT size of MySQL
                bookingSubject = bookingSubject.substring(0, 254);
            }

            try {
                mDatabaseHelper.addBooking(
                        user.getUserID(),
                        room.getRoomID(),
                        bookingSubject,
                        (Integer) jSpinnerDemanda.getValue(),
                        mTimestamp
                );
            } catch (KeyExistsException ex) {
                Logger.getLogger(AddBookingFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            jLabelFeedBack.setText("Reserva casastrada");
            jLabelFeedBack.setForeground(Color.GREEN);

            //resetAllInputs();
            jButtonSalvar.setText("Nova");

        } else {
            jLabelFeedBack.setText("Preencha os campos corretamente.");
            jLabelFeedBack.setForeground(Color.RED);
        }
        jLabelFeedBack.setVisible(true);
    }

    private boolean areInputsEmpty() {
        if (jLabelObjetivo.getText().length() <= 0
                || jLabelData.getText().equals("")
                || jLabelHora.getText().equals("")
                || (int) jSpinnerDemanda.getValue() <= 0) {
            return true;
        }
        return false;
    }

    private void resetAllInputs() {
        jTextPaneObjetivo.setText("");
        jLabelData.setText("");
        jLabelHora.setText("");
        jSpinnerDemanda.resetKeyboardActions();
        jCBRoom.setSelectedIndex(0);
        jCBRoomType.setSelectedIndex(0);
    }

    private Timestamp getTimestamp(String dateString, String timeString) {
        if (timeString.equals("HH:mm")) {
            return null;
        }
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("dd/MM/yyyy kk:mm");
        java.util.Date javaDate = null;
        try {
            javaDate = sdf.parse(dateString + " " + timeString);
        } catch (ParseException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        Timestamp ts = null;
        if (javaDate != null) {
            ts = new Timestamp(javaDate.getTime());
        }
        return ts;
    }

    private void updateCBRoom(JComboBox jComboBox, ArrayList<Room> list) {
        jComboBox.removeAllItems();
        jCBRoom.addItem("");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                jCBRoom.addItem(list.get(i).getRoomID());
            }
        }
    }

    private void jCBRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRoomTypeActionPerformed
        // TODO add your handling code here:
        System.out.println(jCBRoomType.getSelectedIndex());
        int itemSelected = jCBRoomType.getSelectedIndex();
        //String itemSelectedString = String.valueOf(jCBRoomType.getSelectedItem());

        switch (itemSelected) {
            // case 0:
            // Goes to default and reset the jComboBox.
            case 1: // auditorio
                currentList = mDatabaseHelper.getAllRoomsByType(Room.AUDITORIO_ID);
                break;
            case 2:
                currentList = mDatabaseHelper.getAllRoomsByType(Room.LABORATORIO_ID);
                break;
            case 3:
                currentList = mDatabaseHelper.getAllRoomsByType(Room.PROFESSOR_ID);
                break;
            case 4:
                currentList = mDatabaseHelper.getAllRoomsByType(Room.REUNIAO_ID);
                break;
            case 5:
                currentList = mDatabaseHelper.getAllRoomsByType(Room.AULA_ID);
                break;
            default:
                currentList = allRooms;

        }

        if (currentList != null) {
            updateCBRoom(jCBRoom, currentList);
        } else {
            updateCBRoom(jCBRoom, null);
        }
    }//GEN-LAST:event_jCBRoomTypeActionPerformed

    private void jCBRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRoomActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
        new StartFrame(mDatabaseHelper, user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jCBRoom;
    private javax.swing.JComboBox<String> jCBRoomType;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JFormattedTextField jFormattedTextFieldHora;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDemanda;
    private javax.swing.JLabel jLabelFeedBack;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelObjetivo;
    private javax.swing.JLabel jLabelSala;
    private javax.swing.JLabel jLabelTipoDeSala;
    private javax.swing.JScrollPane jScrollPaneObejtivo;
    private javax.swing.JSpinner jSpinnerDemanda;
    private javax.swing.JTextPane jTextPaneObjetivo;
    // End of variables declaration//GEN-END:variables
}