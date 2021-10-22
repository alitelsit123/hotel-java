/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import backend.DB;
import backend.Data;
import backend.Input;
import backend.Uuid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import threads.Threads;

/**
 *
 * @author A Little Shit
 */
public class TambahTipeKamar extends javax.swing.JFrame {

    /**
     * Creates new form CheckIn
     */
    public TambahTipeKamar() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        paneInputData = new javax.swing.JPanel();
        lblNomorKamar = new javax.swing.JLabel();
        txtNamaTipeKamar = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblInvoice3 = new javax.swing.JLabel();
        lblNomorKamar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        txtHargaPerOrang = new javax.swing.JTextField();
        txtHargaPerMalam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Layanan Hotel");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 123, 32));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tambah Tipe Kamar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tambah data Kamar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        paneInputData.setBackground(new java.awt.Color(255, 255, 255));
        paneInputData.setPreferredSize(new java.awt.Dimension(1010, 580));

        lblNomorKamar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNomorKamar.setText("Nama Tipe Kamar");

        txtNamaTipeKamar.setText("Nama Tipe Kamar");

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblInvoice3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice3.setText("Harga Layanan");

        lblNomorKamar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNomorKamar1.setText("Keterangan");

        txtDeskripsi.setColumns(20);
        txtDeskripsi.setRows(5);
        jScrollPane1.setViewportView(txtDeskripsi);

        txtHargaPerOrang.setText("Harga / orang");

        txtHargaPerMalam.setText("Harga / malam");

        javax.swing.GroupLayout paneInputDataLayout = new javax.swing.GroupLayout(paneInputData);
        paneInputData.setLayout(paneInputDataLayout);
        paneInputDataLayout.setHorizontalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1508, 1508, 1508))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneInputDataLayout.createSequentialGroup()
                                .addComponent(lblNomorKamar1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNomorKamar)
                                    .addComponent(txtNamaTipeKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInvoice3)
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addComponent(txtHargaPerOrang, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHargaPerMalam, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(1194, 1194, 1194))))
        );
        paneInputDataLayout.setVerticalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addComponent(lblNomorKamar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamaTipeKamar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addComponent(lblInvoice3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargaPerOrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHargaPerMalam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblNomorKamar1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(189, 189, 189)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        jPanel1.add(paneInputData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 67, 1090, 560));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("V1.0");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 640, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("2019, Hotel Indonesia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 637, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        Threads.get("TambahTipeKamar").exit();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Input input = new Input();
        input.set("id", Uuid.generate());
        input.set("nama", txtNamaTipeKamar.getText());
        input.set("hargamalam", txtHargaPerMalam.getText());
        input.set("hargaorang", txtHargaPerOrang.getText());
        input.set("keterangan", txtDeskripsi.getText());
        String sql = "INSERT INTO tipe_kamar (id_tipe_kamar, nama_tipe_kamar, harga_per_malam, harga_per_orang, keterangan) VALUES ('"+input.get("id")+"','"+input.get("nama")+"','"+input.get("hargamalam")+"','"+input.get("hargaorang")+"','"+input.get("keterangan")+"')";
        DB.getInstance().exec(sql);
    }//GEN-LAST:event_btnSubmitActionPerformed
   
    
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInvoice3;
    private javax.swing.JLabel lblNomorKamar;
    private javax.swing.JLabel lblNomorKamar1;
    private javax.swing.JPanel paneInputData;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextField txtHargaPerMalam;
    private javax.swing.JTextField txtHargaPerOrang;
    private javax.swing.JTextField txtNamaTipeKamar;
    // End of variables declaration//GEN-END:variables
}
