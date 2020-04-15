/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oru.inf.InfDB;

/**
 *
 * @author xxx
 */
public class SkapaInlagg extends javax.swing.JFrame {
 
    private DataHanterare dataHanterare;
    private InfDB databasen;
    private int userId;
    private static String filnamn;
    private File fil;
    /**
     * Creates new form SkapaInlagg
     */
    public SkapaInlagg(int userId) {
        dataHanterare = new DataHanterare();
        databasen = DataHanterare.dataHanterare();
        this.userId=userId;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel = new javax.swing.JPanel();
        JLSkapainlagg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInlagg = new javax.swing.JTextArea();
        tfTitel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBifogaFil = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfFilUrl = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFilUrl = new javax.swing.JLabel();
        tfFilNamn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLSkapainlagg.setText("Skapa inlägg");

        jTInlagg.setColumns(20);
        jTInlagg.setRows(5);
        jTInlagg.setText("\n");
        jTInlagg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTInlaggFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTInlaggFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTInlagg);

        jLabel1.setText("Titel:");

        jLabel2.setText("Inlägg:");

        btnBifogaFil.setText("Bifoga fil");
        btnBifogaFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBifogaFilActionPerformed(evt);
            }
        });

        tfFilUrl.setEditable(false);
        tfFilUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFilUrlActionPerformed(evt);
            }
        });

        jButton1.setText("Publicera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblFilUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFilUrlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFilUrlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFilUrlMouseExited(evt);
            }
        });

        tfFilNamn.setEditable(false);

        jLabel4.setText("Filnamn:");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(JLSkapainlagg)
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTitel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(JpanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(128, 128, 128)))
                                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JpanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblFilUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(JpanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnBifogaFil))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)))
                                        .addGap(18, 18, 18)
                                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfFilNamn, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                            .addComponent(tfFilUrl)))))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32))))
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addComponent(JLSkapainlagg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addComponent(tfTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBifogaFil)
                            .addComponent(tfFilUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFilNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFilUrl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//        private void fyllCmbKategoriNamn() {
//            try {
//                ArrayList<String> lista = db.fetchColumn("SELECT NAMN FROM KATEGORI");
//                for (int i = 0; i < lista.size(); i++) {
//                    cmb.addItem(lista.get(i));
//                }
//            } catch (InfException e) {
//            }
//        }
    
    private void btnBifogaFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBifogaFilActionPerformed
        JFileChooser fc = new JFileChooser();
        //FileSystemView.getFileSystemView().getHomeDirectory() (Gets desktop url)
        //"C:\\Users\\HHHLO\\OneDrive\\Documents"
        fc.setDialogTitle("Välj en fil att bifoga");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        int returnValue = fc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            filnamn = f.getAbsolutePath();
            File fil = new File(filnamn);
            this.fil=fil;
            tfFilUrl.setText(filnamn);
            tfFilNamn.setEditable(true);
            
            lblFilUrl.setText(filnamn);
            lblFilUrl.setForeground(Color.BLUE.darker());
            lblFilUrl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
        }

    }//GEN-LAST:event_btnBifogaFilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime nu = LocalDateTime.now();
        String datum = nu.toString().substring(0, 10);
        String tid = nu.toString().substring(11, 16);

        int inlaggID = dataHanterare.getNextInlaggId();
        int skribent = userId;
        String inlagg = jTInlagg.getText();
        int bsektion = 1;
        String titel=tfTitel.getText();

        if(dataHanterare.skapaInlagg(inlaggID, skribent, inlagg, bsektion, titel,datum, tid)){
            if(!tfFilUrl.getText().equals("")){
                String filNamn="Unnamed File";
                if(!tfFilNamn.equals(null)){
                filNamn=tfFilNamn.getText();
                }
                dataHanterare.laggTillFil(filNamn, filnamn, inlaggID);
            }
            JOptionPane.showMessageDialog(null, "Ditt inlägg har skapats!");
            jTInlagg.setText("");
            tfTitel.setText("");
            tfFilUrl.setText("");
            tfFilNamn.setText("");
        }
        else{
            System.out.print("Misslyckades");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTInlaggFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTInlaggFocusLost
        if(jTInlagg.getText().equals(""))
        {
            jTInlagg.setText("Vad tänker du på?");
            jTInlagg.setForeground(Color.gray);
        }

        else if (!jTInlagg.getText().equals(""))
        {
            jTInlagg.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTInlaggFocusLost

    private void jTInlaggFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTInlaggFocusGained
        if(jTInlagg.getText().equals("Vad tänker du på?"))
        {
            jTInlagg.setText("");
        }
        jTInlagg.setForeground(Color.black);
    }//GEN-LAST:event_jTInlaggFocusGained

    private void tfFilUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFilUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFilUrlActionPerformed

    private void lblFilUrlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFilUrlMouseClicked
        try {
             Runtime.getRuntime().exec("explorer \"" + filnamn + "\"");
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
    }//GEN-LAST:event_lblFilUrlMouseClicked

    private void lblFilUrlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFilUrlMouseEntered
        if(!lblFilUrl.toString().equals("")){
        lblFilUrl.setText("<html><a href=''>" + filnamn + "</a></html>");
        }
    }//GEN-LAST:event_lblFilUrlMouseEntered

    private void lblFilUrlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFilUrlMouseExited
           if(!lblFilUrl.toString().equals("")){
        lblFilUrl.setText(filnamn);
           }
    }//GEN-LAST:event_lblFilUrlMouseExited

    
    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLSkapainlagg;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btnBifogaFil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTInlagg;
    private javax.swing.JLabel lblFilUrl;
    private javax.swing.JTextField tfFilNamn;
    private javax.swing.JTextField tfFilUrl;
    private javax.swing.JTextField tfTitel;
    // End of variables declaration//GEN-END:variables
}
