/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import backend.DB;
import backend.Data;
import backend.Hash;
import backend.Input;
import backend.Uuid;
import com.sun.prism.PhongMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Timer;
import threads.Threads;

/**
 *
 * @author A Little Shit
 */
public class TambahPegawai extends javax.swing.JFrame {

    /**
     * Creates new form CheckIn
     */
    public TambahPegawai() {
        initComponents();
        mirror();
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

        bgJK = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        paneInputData = new javax.swing.JPanel();
        lblNomorKamar = new javax.swing.JLabel();
        lblInvoice2 = new javax.swing.JLabel();
        cbJabatan = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblInvoice3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtTahun = new javax.swing.JTextField();
        lblInvoice9 = new javax.swing.JLabel();
        txtNomorTelp = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtBulan = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        rbLakiLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        lblInvoice10 = new javax.swing.JLabel();
        txtTahunMasuk = new javax.swing.JTextField();
        txtBulanMasuk = new javax.swing.JTextField();
        txtTanggalMasuk = new javax.swing.JTextField();
        lblInvoice4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        lblInvoice5 = new javax.swing.JLabel();
        lblInvoice6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah User Admin");

        jPanel1.setBackground(new java.awt.Color(0, 123, 32));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tambah Pegawai");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tambah data Pegawai");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        paneInputData.setBackground(new java.awt.Color(255, 255, 255));
        paneInputData.setPreferredSize(new java.awt.Dimension(1010, 580));

        lblNomorKamar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblInvoice2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice2.setText("Jabatan");

        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --", "ADMINISTRATOR", "SUPER ADMINISTRATOR" }));

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
        lblInvoice3.setText("Nama Lengkap");

        txtTahun.setText("tahun");

        lblInvoice9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice9.setText("Tanggal Lahir");

        txtNomorTelp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setText("Jenis Kelamin");

        txtBulan.setText("bulan");

        txtTanggal.setText("tanggal");

        rbLakiLaki.setSelected(true);
        rbLakiLaki.setText("Laki-Laki");

        rbPerempuan.setText("Perempuan");

        lblInvoice10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice10.setText("Tanggal Bergabung Perusahaan");

        txtTahunMasuk.setText("tahun");

        txtBulanMasuk.setText("bulan");

        txtTanggalMasuk.setText("tanggal");

        lblInvoice4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice4.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        lblInvoice5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice5.setText("Nomor Telp");

        lblInvoice6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvoice6.setText("Email");

        javax.swing.GroupLayout paneInputDataLayout = new javax.swing.GroupLayout(paneInputData);
        paneInputData.setLayout(paneInputDataLayout);
        paneInputDataLayout.setHorizontalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addComponent(lblInvoice4)
                                .addGap(312, 312, 312))
                            .addComponent(jScrollPane1)))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomorKamar)
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                                        .addComponent(rbLakiLaki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblInvoice3)
                                            .addComponent(lblEmail)
                                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)))
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                                .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblInvoice9)
                                            .addComponent(lblInvoice2)
                                            .addComponent(cbJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(20, 20, 20)
                                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomorTelp)
                                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                                .addComponent(lblInvoice5)
                                                .addGap(0, 241, Short.MAX_VALUE))))
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                                .addComponent(txtTahunMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBulanMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblInvoice10))
                                        .addGap(20, 20, 20)
                                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                                .addComponent(lblInvoice6)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtEmail)))))))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneInputDataLayout.setVerticalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addComponent(lblInvoice3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmail)
                                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblInvoice10)
                                        .addComponent(lblInvoice6)))
                                .addGap(11, 11, 11)
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbLakiLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTahunMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtBulanMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(paneInputDataLayout.createSequentialGroup()
                                    .addComponent(lblInvoice9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNomorTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(paneInputDataLayout.createSequentialGroup()
                                    .addComponent(lblInvoice5)
                                    .addGap(51, 51, 51))))
                        .addGap(18, 18, 18)
                        .addComponent(lblInvoice2))
                    .addComponent(lblNomorKamar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInvoice4)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
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
        Threads.get("TambahPegawai").exit();
        
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Input input = new Input();
        input.set(Uuid.generate());
        input.set(txtNama.getText());
        input.set(txtEmail.getText());
        input.set(txtNomorTelp.getText());
        input.set(txtTahun.getText() + "-" + txtBulan.getText() + "-" + txtTanggal.getText());
        for(Enumeration<AbstractButton> buttons = bgJK.getElements(); buttons.hasMoreElements();)
        {
            AbstractButton button = buttons.nextElement();
            if(button.isSelected())
                input.set(button.getText());
        }
        input.set(cbJabatan.getSelectedItem().toString());
        input.set(txtTahunMasuk.getText() + "-" + txtBulanMasuk.getText() + "-" + txtTanggalMasuk.getText());
        input.set(txtAlamat.getText());
        DB.getInstance().exec(Data.tambahPegawai(input));
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    private void mirror()
    {
         bgJK = new ButtonGroup();
         bgJK.add(rbLakiLaki);
         bgJK.add(rbPerempuan);
    }
    Timer delay;
    int paneListKamarWidth,paneInputDataWidth,paneX,paneY;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbJabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInvoice10;
    private javax.swing.JLabel lblInvoice2;
    private javax.swing.JLabel lblInvoice3;
    private javax.swing.JLabel lblInvoice4;
    private javax.swing.JLabel lblInvoice5;
    private javax.swing.JLabel lblInvoice6;
    private javax.swing.JLabel lblInvoice9;
    private javax.swing.JLabel lblNomorKamar;
    private javax.swing.JPanel paneInputData;
    private javax.swing.JRadioButton rbLakiLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtBulan;
    private javax.swing.JTextField txtBulanMasuk;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNomorTelp;
    private javax.swing.JTextField txtTahun;
    private javax.swing.JTextField txtTahunMasuk;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTanggalMasuk;
    // End of variables declaration//GEN-END:variables
}
