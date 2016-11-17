package frames;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import roombooking.DatabaseHelper;
import roombooking.Room;
import roombooking.User;

/**
 *
 * @author Jonathan
 */
public class salas extends javax.swing.JFrame {

    private DatabaseHelper database;
    private User user;
    private ArrayList<Room> roomList;
    private DefaultTableModel dtm;
    
    /**
     * Creates new form usuarios
     */
    public salas(DatabaseHelper database, User user) {
        initComponents();
        this.database = database;
        this.user = user;

        roomList = database.getAllRooms();
        
        setJTableNotEditable(jTable1);
        
        jButtonCancelar.setVisible(false);
        if (user != null) {
            if (user.getUserTypeID() != User.ADMIN) {
                jButtonEditar.setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(932, 659));
        setResizable(false);
        setSize(new java.awt.Dimension(932, 659));
        getContentPane().setLayout(null);

        jButtonEditar.setText("Editar");
        jButtonEditar.setOpaque(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar);
        jButtonEditar.setBounds(800, 520, 80, 32);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setOpaque(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(800, 570, 80, 32);

        jButtonInicio.setText("Inicio");
        jButtonInicio.setOpaque(false);
        jButtonInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInicioMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonInicio);
        jButtonInicio.setBounds(70, 80, 60, 32);

        jTable1.setModel(new DefaultTableModel());
        jTable1.setPreferredSize(new java.awt.Dimension(480, 320));
        jScrollPaneTable.setViewportView(jTable1);

        getContentPane().add(jScrollPaneTable);
        jScrollPaneTable.setBounds(70, 150, 700, 403);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/base-00.png"))); // NOI18N
        Background.setMaximumSize(new java.awt.Dimension(933, 660));
        getContentPane().add(Background);
        Background.setBounds(0, 0, 932, 659);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        jButtonEditar.setText("Editar");
        jButtonCancelar.setVisible(false);
        
        setJTableNotEditable(jTable1);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) { // no row selected
            return;
        }

        if (jButtonEditar.getText().equals("Editar")) {
            jButtonEditar.setText("Salvar");
            jButtonCancelar.setVisible(true);

            setJTableRowEditable(jTable1, selectedRow);

        } else {
            jButtonEditar.setText("Editar");
            jButtonCancelar.setVisible(false);
            setJTableNotEditable(jTable1);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void setValuesToTableModel(DefaultTableModel dtm) {
        dtm.addColumn("ID");
        dtm.addColumn("TIPO");
        dtm.addColumn("ANDAR");
        dtm.addColumn("CAPACIDADE");
        dtm.addColumn("PROJETOR");
        dtm.addColumn("COMPUTADORES");

        roomList.stream().forEach((room) -> {
            dtm.addRow(new Object[]{
                room.getRoomID(),
                room.getRoomTypeDescription(),
                room.getFloor(),
                room.getCapacity(),
                room.HasProjector() ? "SIM" : "NÃO",
                room.getNumberOfComputers()
            });
        });
    }

    private void setJTableRowEditable(JTable jTable, int selectedRow) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return row == selectedRow;
            }
        };
        jTable.setModel(dtm);
        setValuesToTableModel(dtm);
    }

    private void setJTableNotEditable(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable.setModel(dtm);
        setValuesToTableModel(dtm);
    }

    private void jButtonInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInicioMouseClicked
        new inicio(database, user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonInicioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
