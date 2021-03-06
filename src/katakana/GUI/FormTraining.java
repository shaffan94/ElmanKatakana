/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import katakana.elmanRNN.BPController;
import katakana.elmanRNN.ERNNController;
import katakana.elmanRNN.MTraining;
import katakana.image.ImagePreprocessing;
import katakana.image.KatakanaImage;
import katakana.image.KatakanaImageCollection;
import katakana.image.KatakanaImageViewer;
import katakana.image.KatakanaPixelsLoader;
import katakana.util.ExtensionFileFilter;
import katakana.util.Util;
import katakana.wavelet.EkstraksiWavelet;




/**
 *
 * @author nana
 */
public class FormTraining extends javax.swing.JFrame {
    
    /**
     * Creates new form trainingform
     */
    JFileChooser flchooser = new JFileChooser();
    KatakanaImage ki ;
    KatakanaImageCollection kicollection=new KatakanaImageCollection();
    
    
    
    public FormTraining() {
        initComponents();
        Util.TengahWindow(this);
        setResizable(false);
        setTitle("Training");
        ki=new KatakanaImage(300, 300);
    }
   
 
    
    public void showWarning(String pesan)
    {
        JOptionPane.showMessageDialog(this, pesan,"Peringatan",JOptionPane.WARNING_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        jlblHW = new javax.swing.JLabel();
        jButtonTraining = new javax.swing.JButton();
        chooseimgbutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableImage = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        zjLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel2.setText("Pelatihan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jButtonBack.setText("Kembali");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        imagePanel.setBackground(new java.awt.Color(192, 192, 192));
        imagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Picture", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 102))); // NOI18N
        imagePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imagePanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jlblHW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblHW.setText("HandWriting Image");

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagePanelLayout.createSequentialGroup()
                .addComponent(jlblHW, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblHW, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        jButtonTraining.setText("Pelatihan");
        jButtonTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrainingActionPerformed(evt);
            }
        });

        chooseimgbutton.setText("Pilih Gambar");
        chooseimgbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseimgbuttonActionPerformed(evt);
            }
        });

        jTableImage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama Citra", "Kelas Citra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableImageMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableImage);

        jLabel6.setText("%");

        jLabel7.setText("Status");

        jButton1.setText("Muat Ulang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setText("Kecepatan Belajar");

        jLabel11.setText("Error Maksimum");

        jTextField3.setText("0.8");

        jTextField4.setText("0.01");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chooseimgbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseimgbutton)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTraining))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(355, 355, 355))
        );

        jTabbedPane1.addTab("Choose Image and Trainning", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("cara melakukan pembelajaran/pelatihan");

        jLabel3.setText("1. memilih gambar yang ingin dilatih drngan meng-klik button choose image ");

        jLabel4.setText("2. lalu mengisi nama huruf sesuai dengan huruf yang akan dilatih");

        jLabel5.setText("3. kemudian klik button training tunggu hingga proses selesai");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Information/Help", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 560, 370));

        zjLabel1.setText("jLabel1");
        getContentPane().add(zjLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        FormMain main=new FormMain();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

private int ShowDialogOpenImage()
{
    
    FileFilter filter1 = new ExtensionFileFilter("Bitmap", new String[] { "BMP"});
    flchooser.setFileFilter(filter1);
    flchooser.setMultiSelectionEnabled(true);
    flchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    int tanggapan = flchooser.showOpenDialog(this);   
    return tanggapan;
}

private void showFilesImages()
{
    String[] header = new String[]{"No","Nama Citra","Kelas Citra"};
    String[][] data = new String[kicollection.getTotalHandWriting()][header.length];
    for(int i=0;i<kicollection.getTotalHandWriting();i++)
    {
     
        String ffname = kicollection.getHandWriting(i).getName();
        data[i][0] = String.valueOf(i+1);
        data[i][1] = ffname;
        data[i][2] = kicollection.getHandWriting(i).getKelas();
        
    }
    jTableImage.setModel(new DefaultTableModel(data, header));
}
  
private void refreshFilesImages()
{
    String[] header = new String[]{"No","Image Path","Nama Huruf"};
    String[][] data = null;
    
    jTableImage.setModel(new DefaultTableModel(data, header));
}
    private void chooseimgbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseimgbuttonActionPerformed
        // TODO add your handling code here:
        boolean ada;
        BufferedImage img;
        
        int tanggapan = ShowDialogOpenImage();
        
        if(tanggapan==JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = flchooser.getSelectedFile();
            
            File direktori = new File(selectedFile.getAbsolutePath());
            File[] daftarFile = direktori.listFiles();
            int n_citra = daftarFile.length;
            System.out.println("banyak sampel citra : "+n_citra);

            for(int i=0; i<n_citra; i++){
                ada = daftarFile[i].isFile();
                if(ada == true){
                    try {
                        img = ImageIO.read(daftarFile[i]);
                        ImageIcon imgicon = new ImageIcon(img);                                                                  //ini untuk menampilkan image ke interface

                        KatakanaPixelsLoader kiLoad = new KatakanaPixelsLoader();
                        kiLoad.loadPixelsFrom(img);
                        ki = kiLoad.getMyImage();
                        ki.SetName(daftarFile[i].getName());
                        ki.setKelas(getkelas(daftarFile[i].getName()));
                        ImagePreprocessing pp= new ImagePreprocessing();
                        pp.preprocesing(ki);
        //                            System.out.println("=========batas print thin=========");        
                        kicollection.addHandWriting(ki, daftarFile[i].getAbsolutePath());                     //menambahkan element2, sesuai bnyaknya methode add yang dipanggil pada saat nampili itu na
                    } catch (IOException ex) {
                        System.out.println("Terjadi kesalahan pada saat membuka berkas" + ex.getMessage());
                    }
                }
            }
            
            showFilesImages();
        }
    }//GEN-LAST:event_chooseimgbuttonActionPerformed
    
    private void jButtonTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrainingActionPerformed
        // TODO add your handling code here
        double alpha=Double.parseDouble(jTextField3.getText());
        double error=Double.parseDouble(jTextField4.getText());
        
        double[][] inputVec = new double[kicollection.getTotalHandWriting()][10];
        EkstraksiWavelet wv=new EkstraksiWavelet();
        ERNNController Ernn= new ERNNController();
        
        BPController bp= new BPController();
        double bar=0;
        double tg=kicollection.getTotalHandWriting();
        
        if (kicollection.getTotalHandWriting()>1) 
        {
            for (int i=0; i<kicollection.getTotalHandWriting(); i++){
                ki= kicollection.getHandWriting(i);   
                System.out.print("Ciri citra ke-"+i+" : ");
                for (int j=0; j<10; j++){

                    inputVec[i][j] = wv.main(ki)[j];

                    System.out.print(inputVec[i][j]+" ");
                }
                
                System.out.println();
                
                bar=bar+(100/tg);
                this.ProgressBar(jProgressBar1, bar);
            }
            
            JOptionPane.showMessageDialog(null, "ekstraksi fitur selesai");
            
            System.out.println("elman rnn");
            Ernn.parameter(alpha,error);
            Ernn.training(inputVec, kicollection);
            
            System.out.println("backpropagation");
            bp.parameter(alpha,error);
            bp.training(inputVec, kicollection);            
            
            JOptionPane.showMessageDialog(null, "Pelatihan Telah Selesai");
        }else 
        {
           showWarning("Belum Ada Data atau Tidak Cukup");
        } 
       
        jButtonTraining.setEnabled(false);
        chooseimgbutton.setEnabled(false);
        
        
    }//GEN-LAST:event_jButtonTrainingActionPerformed

    public void ProgressBar(JProgressBar loading,double value){
        loading.setValue((int) value);
        loading.setString(Integer.toString((int) value)+"%");
        loading.setStringPainted(true);
    }
    
    public String getkelas(String file){
        String[] kelas_file;
        String[] kelas;
        
        kelas_file = file.split("_");
        kelas = kelas_file[1].split("\\.");
        return kelas[0];
    }
    
    private void jTableImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableImageMouseClicked
        // TODO add your handling code here:
        int baris = jTableImage.rowAtPoint(evt.getPoint());
        ki = kicollection.getHandWriting(baris);
        KatakanaImageViewer kiv =new KatakanaImageViewer();
    

    
        kiv.setImage(ki);
        kiv.setViewer(jlblHW);
        try {
            kiv.viewImageOutput();
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jTableImageMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.refreshFilesImages();
        kicollection = new KatakanaImageCollection();
        int bar=0;
        ProgressBar(jProgressBar1, bar);
        jButtonTraining.setEnabled(true);
        chooseimgbutton.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(FormTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTraining().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseimgbutton;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonTraining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableImage;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel jlblHW;
    private javax.swing.JLabel zjLabel1;
    // End of variables declaration//GEN-END:variables
}
