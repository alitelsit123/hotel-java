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
import controller.CtrlTambahTamu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import threads.Threads;

/**
 *
 * @author A Little Shit
 */
public class TambahTamu extends javax.swing.JFrame {

    /**
     * Creates new form CheckIn
     */
    CtrlTambahTamu tamu;
    public TambahTamu() {
        this.tamu = new CtrlTambahTamu(this);
        initComponents();
        this.tamu.add();
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
        lblNamaTamu = new javax.swing.JLabel();
        txtNamaTamu = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblInvoice3 = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtIdentitas = new javax.swing.JTextField();
        txtNomortelp1 = new javax.swing.JTextField();
        lblNomorTelp = new javax.swing.JLabel();
        cbIdentitas = new javax.swing.JComboBox<>();
        cbNamaTamu = new javax.swing.JComboBox<>();
        txtNomortelp0 = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail0 = new javax.swing.JTextField();
        txtEmail2 = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        lblNamaTamu1 = new javax.swing.JLabel();
        txtWarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Tamu");

        jPanel1.setBackground(new java.awt.Color(0, 123, 32));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tambah Tamu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tamu baru");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        paneInputData.setBackground(new java.awt.Color(255, 255, 255));
        paneInputData.setPreferredSize(new java.awt.Dimension(1010, 580));

        lblNamaTamu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNamaTamu.setText("Nama Lengkap");

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
        lblInvoice3.setText("Identitas");

        lblAlamat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAlamat.setText("Alamat Lengkap");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        lblNomorTelp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNomorTelp.setText("Nomor Telpon");

        cbIdentitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KTP", "SIM", "PASSPORT" }));

        cbNamaTamu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Ms.", "Mrs." }));

        txtNomortelp0.setText("+62");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEmail.setText("Email");

        txtEmail1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail1.setText("@");

        lblNamaTamu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNamaTamu1.setText("Warga Negara");

        javax.swing.GroupLayout paneInputDataLayout = new javax.swing.GroupLayout(paneInputData);
        paneInputData.setLayout(paneInputDataLayout);
        paneInputDataLayout.setHorizontalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtWarga, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(paneInputDataLayout.createSequentialGroup()
                                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbNamaTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNamaTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblNamaTamu))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblInvoice3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlamat)
                            .addComponent(lblNamaTamu1))
                        .addGap(333, 333, 333)))
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomorTelp)
                            .addComponent(lblEmail)
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addComponent(txtNomortelp0, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNomortelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(paneInputDataLayout.createSequentialGroup()
                                        .addComponent(txtEmail0, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        paneInputDataLayout.setVerticalGroup(
            paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputDataLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addComponent(lblNamaTamu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNamaTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblInvoice3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneInputDataLayout.createSequentialGroup()
                                .addComponent(lblNomorTelp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomortelp0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomortelp1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))
                    .addGroup(paneInputDataLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblNamaTamu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWarga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneInputDataLayout.createSequentialGroup()
                        .addGroup(paneInputDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(187, 187, 187))))
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
        this.tamu.exit();
        
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        this.tamu.save();
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbIdentitas;
    private javax.swing.JComboBox<String> cbNamaTamu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInvoice3;
    private javax.swing.JLabel lblNamaTamu;
    private javax.swing.JLabel lblNamaTamu1;
    private javax.swing.JLabel lblNomorTelp;
    private javax.swing.JPanel paneInputData;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtEmail0;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtIdentitas;
    private javax.swing.JTextField txtNamaTamu;
    private javax.swing.JTextField txtNomortelp0;
    private javax.swing.JTextField txtNomortelp1;
    private javax.swing.JTextField txtWarga;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnBatal
     */
    public javax.swing.JButton getBtnBatal() {
        return btnBatal;
    }

    /**
     * @return the btnSubmit
     */
    public javax.swing.JButton getBtnSubmit() {
        return btnSubmit;
    }

    /**
     * @return the cbIdentitas
     */
    public javax.swing.JComboBox<String> getCbIdentitas() {
        return cbIdentitas;
    }

    /**
     * @return the cbNamaTamu
     */
    public javax.swing.JComboBox<String> getCbNamaTamu() {
        return cbNamaTamu;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @return the jLabel5
     */
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @return the lblAlamat
     */
    public javax.swing.JLabel getLblAlamat() {
        return lblAlamat;
    }

    /**
     * @return the lblEmail
     */
    public javax.swing.JLabel getLblEmail() {
        return lblEmail;
    }

    /**
     * @return the lblInvoice3
     */
    public javax.swing.JLabel getLblInvoice3() {
        return lblInvoice3;
    }

    /**
     * @return the lblNamaTamu
     */
    public javax.swing.JLabel getLblNamaTamu() {
        return lblNamaTamu;
    }

    /**
     * @return the lblNamaTamu1
     */
    public javax.swing.JLabel getLblNamaTamu1() {
        return lblNamaTamu1;
    }

    /**
     * @return the lblNomorTelp
     */
    public javax.swing.JLabel getLblNomorTelp() {
        return lblNomorTelp;
    }

    /**
     * @return the paneInputData
     */
    public javax.swing.JPanel getPaneInputData() {
        return paneInputData;
    }

    /**
     * @return the txtAlamat
     */
    public javax.swing.JTextArea getTxtAlamat() {
        return txtAlamat;
    }

    /**
     * @return the txtEmail0
     */
    public javax.swing.JTextField getTxtEmail0() {
        return txtEmail0;
    }

    /**
     * @return the txtEmail1
     */
    public javax.swing.JTextField getTxtEmail1() {
        return txtEmail1;
    }

    /**
     * @return the txtEmail2
     */
    public javax.swing.JTextField getTxtEmail2() {
        return txtEmail2;
    }

    /**
     * @return the txtIdentitas
     */
    public javax.swing.JTextField getTxtIdentitas() {
        return txtIdentitas;
    }

    /**
     * @return the txtNamaTamu
     */
    public javax.swing.JTextField getTxtNamaTamu() {
        return txtNamaTamu;
    }

    /**
     * @return the txtNomortelp0
     */
    public javax.swing.JTextField getTxtNomortelp0() {
        return txtNomortelp0;
    }

    /**
     * @return the txtNomortelp1
     */
    public javax.swing.JTextField getTxtNomortelp1() {
        return txtNomortelp1;
    }

    /**
     * @return the txtWarga
     */
    public javax.swing.JTextField getTxtWarga() {
        return txtWarga;
    }
}
