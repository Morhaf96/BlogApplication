/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import oru.inf.InfDB;

/**
 *
 * @author Team 14
 */
public class VisaBloggInlagg extends javax.swing.JFrame {

    private DataHanterare dataHanterare;
    private InfDB databasen;
    private Box box;
    private int userId;

    /**
     * Creates new form VisaInlagg
     */
    public VisaBloggInlagg(int userId) {
        initComponents();
        dataHanterare = new DataHanterare();
        databasen = DataHanterare.dataHanterare();
        this.setLocationRelativeTo(null);
        box = new Box(BoxLayout.Y_AXIS);
        jScrollPane1.setViewportView(box);
        this.userId = userId;
        SetBorders();
        setVlkmn();
        dataHanterare.fyllCmbAnvandarnamn(cmbAnvNamn);
    }

    public void SetBorders() {
        Border b = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.blue);
        lblFormellB.setBorder(b);
        lblForskningB.setBorder(b);
        lblInformellB.setBorder(b);
        lblUtbildningB.setBorder(b);
    }

    public void setVlkmn() {

        lblVlkmn.setText("Välkommen " + dataHanterare.getFullNamn(userId) + "! Klicka på en bloggsektion för att visa inläggen!");
    }

    public void VisaFormellBlogg() {
        jScrollPane1.repaint();
        box.removeAll();
        ArrayList IIDlista = dataHanterare.getFormellaInlaggId();
        try {
            if (IIDlista.size() > 0) {
                for (Object inlagg : IIDlista) {

                    JPanel importeradPanel = new EttInlagg(inlagg.toString());
                    importeradPanel.setVisible(true);
                    box.add(importeradPanel);
                    box.revalidate();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga inlägg på denna blogg än!");
        }
    }

    public void VisaInormellBlogg() {
        jScrollPane1.repaint();
        box.removeAll();
        ArrayList IIDlista = dataHanterare.getInformellaInlaggId();
        try {
            if (IIDlista.size() > 0) {
                for (Object inlagg : IIDlista) {

                    JPanel importeradPanel = new EttInlagg(inlagg.toString());
                    importeradPanel.setVisible(true);
                    box.add(importeradPanel);
                    box.revalidate();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga inlägg på denna blogg än!");
        }

    }

    public void VisaUtbildningInlagg() {
        jScrollPane1.repaint();
        box.removeAll();
        ArrayList IIDlista = dataHanterare.getUtbildningInlaggId();
        try {
            if (IIDlista.size() > 0) {
                for (Object inlagg : IIDlista) {

                    JPanel importeradPanel = new EttInlagg(inlagg.toString());
                    importeradPanel.setVisible(true);
                    box.add(importeradPanel);
                    box.revalidate();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga inlägg på denna blogg än!");
        }
    }

    public void VisaForskningInlagg() {
        jScrollPane1.repaint();
        box.removeAll();
        ArrayList IIDlista = dataHanterare.getForskningInlaggId();
        try {
            if (IIDlista.size() > 0) {
                for (Object inlagg : IIDlista) {

                    JPanel importeradPanel = new EttInlagg(inlagg.toString());
                    importeradPanel.setVisible(true);
                    box.add(importeradPanel);
                    box.revalidate();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga inlägg på denna blogg än!");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lblVlkmn = new javax.swing.JLabel();
        lblInformellB = new javax.swing.JLabel();
        lblUtbildningB = new javax.swing.JLabel();
        lblForskningB = new javax.swing.JLabel();
        lblFormellB = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTaBortInlagg = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfInlaggnr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbAnvNamn = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblVlkmn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblVlkmn.setText("Välkommen! Klicka på en bloggsektion för att visa inläggen!");

        lblInformellB.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        lblInformellB.setText("Informell blogg");
        lblInformellB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInformellBMouseClicked(evt);
            }
        });

        lblUtbildningB.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        lblUtbildningB.setText("Utbildning blogg");
        lblUtbildningB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUtbildningBMouseClicked(evt);
            }
        });

        lblForskningB.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        lblForskningB.setText("Forskning blogg");
        lblForskningB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForskningBMouseClicked(evt);
            }
        });

        lblFormellB.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        lblFormellB.setText("Fomell blogg");
        lblFormellB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFormellBMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));

        btnTaBortInlagg.setText("Ta bort inlägget");
        btnTaBortInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortInlaggActionPerformed(evt);
            }
        });

        jLabel2.setText("Ange numret på inlägget som du vill ta bort");

        jLabel3.setText("Inlägg nummer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfInlaggnr, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaBortInlagg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfInlaggnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(btnTaBortInlagg))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Eras Medium ITC", 1, 18)); // NOI18N
        jLabel1.setText("Adminfunktioner");

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));

        jLabel4.setText("Adminstatus:");

        jButton1.setText("Gör till admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gör till icke-admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAnvNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(cmbAnvNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVlkmn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblFormellB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lblInformellB, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblUtbildningB, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(lblForskningB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVlkmn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormellB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInformellB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUtbildningB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblForskningB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInformellBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformellBMouseClicked
        VisaInormellBlogg();
    }//GEN-LAST:event_lblInformellBMouseClicked

    private void lblUtbildningBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUtbildningBMouseClicked
        VisaUtbildningInlagg();
    }//GEN-LAST:event_lblUtbildningBMouseClicked

    private void lblForskningBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForskningBMouseClicked
        VisaForskningInlagg();
    }//GEN-LAST:event_lblForskningBMouseClicked

    private void lblFormellBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFormellBMouseClicked
        VisaFormellBlogg();
    }//GEN-LAST:event_lblFormellBMouseClicked

    private void btnTaBortInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortInlaggActionPerformed
        if (Validering.FaltArTom(tfInlaggnr) || !Validering.arHeltal(tfInlaggnr)) {
            System.out.println("Inmatning i fältet inläggnr är felaktig");
        } else {
            String inlaggnr = tfInlaggnr.getText();
            if (!dataHanterare.arAdmin(userId) && !dataHanterare.arInlaggetsSkribent(userId, inlaggnr)) {
                JOptionPane.showMessageDialog(null, "Du är inte admin och därför kan bara ta bort dina egna inlägg");
            } else {
                if (dataHanterare.inlaggFinns(inlaggnr)) {
                    if (dataHanterare.inlaggetHarFil(inlaggnr)) {
                        dataHanterare.taBortInlaggFil(inlaggnr);
                    }
                    dataHanterare.taBortInlagg(inlaggnr);
                    this.dispose();
                    new VisaBloggInlagg(userId).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Det finns inget inlägg med det angivna numret. \n Vänligen ange ett korrekt nummer och försök igen");
                }
            }
        }


    }//GEN-LAST:event_btnTaBortInlaggActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((cmbAnvNamn.getSelectedIndex() == -1)) {
            JOptionPane.showMessageDialog(null, "Du måste först välja en användare från listan för att göra den till admin");
        } else {
            if (!dataHanterare.arAdmin(userId)) {
                JOptionPane.showMessageDialog(null, "Du är inte admin och därför kan inte ändra adminstatus på någon användare");
            } else {
                String anvandare = cmbAnvNamn.getSelectedItem().toString();
                String[] namnet = anvandare.split(" ");
                String fornamn = namnet[0].toString();
                String efternamn = namnet[1].toString();
                int anvId = dataHanterare.getAnvandarId(fornamn, efternamn);
                if (dataHanterare.makeUserAdmin(anvId)) {
                    JOptionPane.showMessageDialog(null, "Användaren " + anvandare + " är nu admin");
                } else {
                    JOptionPane.showMessageDialog(null, "Något gick fel1");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((cmbAnvNamn.getSelectedIndex() == -1)) {
            JOptionPane.showMessageDialog(null, "Du måste först välja en användare från listan för att ta bort adminsstatus");
        } else {
            if (!dataHanterare.arAdmin(userId)) {
                JOptionPane.showMessageDialog(null, "Du är inte admin och därför kan inte ändra adminstatus på någon användare");
            } else {
                String anvandare = cmbAnvNamn.getSelectedItem().toString();
                String[] namnet = anvandare.split(" ");
                String fornamn = namnet[0].toString();
                String efternamn = namnet[1].toString();
                int anvId = dataHanterare.getAnvandarId(fornamn, efternamn);
                if (dataHanterare.makeUserIckeAdmin(anvId)) {
                    JOptionPane.showMessageDialog(null, "Användaren " + anvandare + " är nu inte admin längre");
                } else {
                    JOptionPane.showMessageDialog(null, "Något gick fel2");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaBortInlagg;
    private javax.swing.JComboBox<String> cmbAnvNamn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFormellB;
    private javax.swing.JLabel lblForskningB;
    private javax.swing.JLabel lblInformellB;
    private javax.swing.JLabel lblUtbildningB;
    private javax.swing.JLabel lblVlkmn;
    private javax.swing.JTextField tfInlaggnr;
    // End of variables declaration//GEN-END:variables
}
