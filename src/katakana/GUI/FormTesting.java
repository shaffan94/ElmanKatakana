/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import katakana.elmanRNN.BPController;
import katakana.elmanRNN.ERNNController;
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
public class FormTesting extends javax.swing.JFrame {

    /**
     * Creates new form testingform
     */
    JFileChooser flchooser = new JFileChooser();
    KatakanaImage kitest;
    KatakanaImageCollection kicollection; 
    public static List<String> outputfinal;
    public static List<String> outputfinalbp;
//    boolean bool=false;
    
    public FormTesting() {
        initComponents();
        Util.TengahWindow(this);
        setResizable(false);
        setTitle("Testing");
        kicollection = new KatakanaImageCollection();
        outputfinal = new ArrayList <String>();
        outputfinalbp = new ArrayList <String>();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_testing = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        imagePanel = new javax.swing.JPanel();
        jlblHW = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        zjLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel2.setText("Pengujian");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 110, -1));

        jButton2.setText("Pilih Gambar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "huruf", "Hasil Klasifikasi", "Keterangan"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 560, 120));

        btn_testing.setText("Testing");
        btn_testing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_testingActionPerformed(evt);
            }
        });
        getContentPane().add(btn_testing, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 230, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama ", "Huruf", "Hasil Klasifikasi", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 560, 120));

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
                .addComponent(jlblHW, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addComponent(jlblHW, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 230, 210));

        jLabel5.setText("masukan data dibawah ini sebelum memilih gambar...");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jButton4.setText("Muat Ulang");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 230, -1));

        zjLabel1.setText("jLabel1");
        getContentPane().add(zjLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showFilesImages()
    {
        String[] header = new String[]{"No","Nama Huruf","Kelas Huruf", "Klasifikasi Huruf", "Keterangan"};
        String[][] data = new String[kicollection.getTotalHandWriting()][header.length];
        for(int i=0;i<kicollection.getTotalHandWriting();i++)
        {
            data[i][0] = String.valueOf(i+1);
            data[i][1] = kicollection.getHandWriting(i).getName();
            data[i][2] = kicollection.getHandWriting(i).getKelas();
            data[i][3] = "";
            data[i][4] = "";
        
        }
        jTable1.setModel(new DefaultTableModel(data, header));
        jTable2.setModel(new DefaultTableModel(data, header));
    }
    
    
    private void showResults()
    {
        String[] header = new String[]{"No","Nama Huruf","Kelas Huruf", "Klasifikasi Huruf", "Keterangan"};
        String[][] data = new String[kicollection.getTotalHandWriting()][header.length];
        String[][] datas = new String[kicollection.getTotalHandWriting()][header.length];
        
        System.out.println("Hasil Klasifikasi : ");
        
        for(int i=0;i<kicollection.getTotalHandWriting();i++)
        {
            System.out.println(kicollection.getFileNames(i)+" : ");
            try{
                String ffname = outputfinal.get(i);
                data[i][0] = String.valueOf(i+1);
                data[i][1] = kicollection.getHandWriting(i).getName();
                data[i][2] = kicollection.getHandWriting(i).getKelas();
                data[i][3] = ffname;
                if(ffname.equals(kicollection.getHandWriting(i).getName())){
                    data[i][4] = "huruf dikenali";
                }
                else{
                    data[i][4] = "huruf tidak dikenali";
                }
            }catch(Exception e){}
            try{
                String ffnamebp = outputfinalbp.get(i);
                System.out.println("BP : "+ffnamebp);
                datas[i][0] = String.valueOf(i+1);
                datas[i][1] = kicollection.getHandWriting(i).getName();
                datas[i][2] = kicollection.getHandWriting(i).getKelas();
                datas[i][3] = ffnamebp;
                if(ffnamebp.equals(kicollection.getHandWriting(i).getKelas())){
                    datas[i][4] = "huruf dikenali";
                }
                else{
                    datas[i][4] = "huruf tidak dikenali";
                }
            }catch(Exception e){}
        }
        jTable1.setModel(new DefaultTableModel(data, header));
        jTable2.setModel(new DefaultTableModel(datas, header));
    }
    
    private int ShowDialogOpenImage()
    {
        FileFilter filter1 = new ExtensionFileFilter("Bitmap", new String[] { "BMP"});
        flchooser.setFileFilter(filter1);
        flchooser.setMultiSelectionEnabled(true);
        flchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int tanggapan = flchooser.showOpenDialog(this);   
        return tanggapan;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormMain main=new FormMain();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
                        ImageIcon imgicon = new ImageIcon(img);
                        
                        KatakanaPixelsLoader kiLoad = new KatakanaPixelsLoader();
                        kiLoad.loadPixelsFrom(img);
                        kitest = kiLoad.getMyImage();
                        kitest.SetName(daftarFile[i].getName());
                        kitest.setKelas(getkelas(daftarFile[i].getName()));
                        KatakanaImageViewer kiv =new KatakanaImageViewer();
                        kiv.setImage(kitest);
                        kiv.setViewer(jlblHW);
                        ImagePreprocessing pp= new ImagePreprocessing();
                        pp.preprocesing(kitest);
                        kicollection.addHandWriting(kitest,daftarFile[i].getAbsolutePath());       
                    } catch (IOException ex) {
                        System.out.println("Terjadi kesalahan pada saat membuka berkas" + ex.getMessage());
                    }
                }
            }
            
            showFilesImages();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        KatakanaImage ki = kicollection.getHandWriting(baris);
        KatakanaImageViewer kiv =new KatakanaImageViewer();
        kiv.setImage(ki);
        kiv.setViewer(jlblHW);
        kiv.viewImageOutput();
    
        //int baris = jTableImage.rowAtPoint(evt.getPoint());
//        kitest = kicollection.getHandWriting(baris);
//        KatakanaImageViewer kiv =new KatakanaImageViewer();
//    
//
//    
//        kiv.setImage(kitest);
//        kiv.setViewer(jlblHW);
//        try {
//            kiv.viewImageOutput();
//        } catch (Exception e) {
//            
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_testingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_testingActionPerformed
        // TODO add your handling code here:
        double[] inputVec = new double[10];
        EkstraksiWavelet wv=new EkstraksiWavelet();
        ERNNController ernn=new ERNNController();
        BPController bp=new BPController();
        
        if (kicollection.getTotalHandWriting()>=1) 
        {   
            for (int i=0; i<kicollection.getTotalHandWriting(); i++){
                kitest= kicollection.getHandWriting(i);
                
                try {
                    for(int j=0; j<inputVec.length; j++){
                        inputVec[j] = wv.main(kitest)[j];
                    }
                    System.out.println("data ke-"+(i+1));
                    
                    ernn.testing(inputVec);
                    bp.testing(inputVec);
                }catch (SQLException ex) {
                    Logger.getLogger(FormTesting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            this.showResults();
            JOptionPane.showMessageDialog(null, "Pelatihan Telah Selesai");
//            
        }else 
        {
           showWarning("Belum Ada Data atau Tidak Cukup");
        }
    }//GEN-LAST:event_btn_testingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FormTesting ft = new FormTesting();
        outputfinal.removeAll(outputfinal);
        outputfinalbp.removeAll(outputfinal);
        ft.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        KatakanaImage ki = kicollection.getHandWriting(baris);
        KatakanaImageViewer kiv =new KatakanaImageViewer();
        kiv.setImage(ki);
        kiv.setViewer(jlblHW);
        kiv.viewImageOutput();
    }//GEN-LAST:event_jTable2MouseClicked

    public void showWarning(String pesan)
    {
        JOptionPane.showMessageDialog(this, pesan,"Peringatan",JOptionPane.WARNING_MESSAGE);
    }
    
    public String getkelas(String file){
        String[] kelas_file;
        String[] kelas;
        
        kelas_file = file.split("_");
        kelas = kelas_file[1].split("\\.");
        return kelas[0];
    }
    
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
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTesting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_testing;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel jlblHW;
    private javax.swing.JLabel zjLabel1;
    // End of variables declaration//GEN-END:variables
}
