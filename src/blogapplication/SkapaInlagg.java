/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.awt.Color;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author xxx
 */
public class SkapaInlagg extends javax.swing.JFrame {
 
    private DataHanterare dataHanterare;
    private InfDB databasen;
    private int userId;
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

        jPanel1 = new javax.swing.JPanel();
        JLSkapainlagg = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInlagg = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Publicera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(JLSkapainlagg))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLSkapainlagg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTInlaggFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTInlaggFocusGained
        if(jTInlagg.getText().equals("Vad tänker du på?"))
        {
            jTInlagg.setText("");
        }
        jTInlagg.setForeground(Color.black);
    }//GEN-LAST:event_jTInlaggFocusGained

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int skribent = userId;
        String inlagg = jTInlagg.getText();
        DataHanterare in = new DataHanterare();
        int inlaggID = in.getNextInlaggId();
        int bsektion = 1;
        try{
            in.skapaInlagg(inlaggID, skribent, inlagg, bsektion);
            jTInlagg.setText("");
            JOptionPane.showMessageDialog(null, "Inlägget har publicerat!");
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error vid publicering!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLSkapainlagg;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTInlagg;
    // End of variables declaration//GEN-END:variables
}
