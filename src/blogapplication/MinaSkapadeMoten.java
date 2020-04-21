/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author Morhaf
 */
public class MinaSkapadeMoten extends javax.swing.JFrame {

    private DataHanterare dataHanterare;
    private InfDB databasen;
    private int userId;
    private int motesId;
    private ArrayList<String> forslagidLista;
    private String datum1;
    private String stt1;
    private String slt1;
    private String datum2;
    private String stt2;
    private String slt2;
    private String datum3;
    private String stt3;
    private String slt3;

    /**
     * Creates new form BefentligtMote
     */
    public MinaSkapadeMoten(int userId, int motesId) {
        initComponents();
        dataHanterare = new DataHanterare();
        databasen = DataHanterare.dataHanterare();
        this.userId = userId;
        this.motesId = motesId;
        this.setLocationRelativeTo(null);
        forslagidLista = new ArrayList<String>();
        fyllRespons();
        setRubrik();
        setTider();
    }

    public void setRubrik() {
        String anvandarNamn = dataHanterare.getFullNamn(userId);
        String motesNamn = dataHanterare.getMotesnamn(motesId);
        lblRubrik.setText("Välkommen " + anvandarNamn + ". Nedan ser du inbjudarnas respons för mötet: " + motesNamn);
        lblInst.setText("Välj en tid från tiderna nedan för att bestämma mötestiden.");
    }

    public void setTider() {
        forslagidLista=dataHanterare.getForslagId(motesId);
        String f1 = forslagidLista.get(0);
        String datumlang1 = dataHanterare.getMotesTid(f1);
        String datum1 = datumlang1.substring(0, 10);
        String st1 = datumlang1.substring(11, 16);
        String sluttid1 = dataHanterare.getMotesSluttid(f1);
        this.datum1 = datum1;
        this.stt1 = st1;
        this.slt1 = sluttid1;

        String f2 = forslagidLista.get(1);
        String datumlang2 = dataHanterare.getMotesTid(f2);
        String datum2 = datumlang2.substring(0, 10);
        String st2 = datumlang2.substring(11, 16);
        String sluttid2 = dataHanterare.getMotesSluttid(f2);
        this.datum2 = datum2;
        this.stt2 = st2;
        this.slt2 = sluttid2;

        String f3 = forslagidLista.get(2);
        String datumlang3 = dataHanterare.getMotesTid(f3);
        String datum3 = datumlang3.substring(0, 10);
        String st3 = datumlang3.substring(11, 16);
        String sluttid3 = dataHanterare.getMotesSluttid(f3);
        this.datum3 = datum3;
        this.stt3 = st3;
        this.slt3 = sluttid3;

        rbtnTid1.setText(datum1 + " " + stt1 + "-" + sluttid1);
        rbtnTid1.setActionCommand(datum1 + " " + stt1 + "-" + sluttid1);
        rbtnTid2.setText(datum2 + " " + stt2 + "-" + sluttid2);
        rbtnTid2.setActionCommand(datum2 + " " + stt2 + "-" + sluttid2);
        rbtnTid3.setText(datum3 + " " + stt3 + "-" + sluttid3);
        rbtnTid3.setActionCommand(datum3 + " " + stt3 + "-" + sluttid3);

    }

    public void fyllRespons() {
        String textAttSkrivaUt = "";

        ArrayList<String> allaInbjudna = dataHanterare.getDeltagarnasId(motesId);
        for (int i = 0; i < allaInbjudna.size(); i++) {
            String value = allaInbjudna.get(i);
            boolean harSvarat = dataHanterare.harSvaratInbjudan(motesId, value);
            if (!harSvarat) {
                textAttSkrivaUt = textAttSkrivaUt + dataHanterare.getInteSvaratRespons(value) + "\n";
            } else if (harSvarat) {
                ArrayList<String> fId = dataHanterare.getForslagId(motesId, value);
                this.forslagidLista = fId;
                for (String s : fId) {
                    textAttSkrivaUt += dataHanterare.getAnvandarRespons(s) + "\n";

                }
            }
        }
        txaRespons.append(textAttSkrivaUt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtngTider = new javax.swing.ButtonGroup();
        lblRubrik = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRespons = new javax.swing.JTextArea();
        lblInst = new javax.swing.JLabel();
        btnBestamMote = new javax.swing.JButton();
        rbtnTid1 = new javax.swing.JRadioButton();
        rbtnTid2 = new javax.swing.JRadioButton();
        rbtnTid3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblRubrik.setText("txt");

        txaRespons.setEditable(false);
        txaRespons.setColumns(20);
        txaRespons.setRows(5);
        jScrollPane1.setViewportView(txaRespons);

        lblInst.setText("jLabel1");

        btnBestamMote.setText("Bestäm mötestiden");
        btnBestamMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestamMoteActionPerformed(evt);
            }
        });

        rbtngTider.add(rbtnTid1);
        rbtnTid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTid1ActionPerformed(evt);
            }
        });

        rbtngTider.add(rbtnTid2);

        rbtngTider.add(rbtnTid3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRubrik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lblInst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnTid2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnTid1)
                                .addGap(143, 143, 143)
                                .addComponent(btnBestamMote))
                            .addComponent(rbtnTid3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnTid1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnTid2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnTid3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnBestamMote)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTid1ActionPerformed

    private void btnBestamMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestamMoteActionPerformed
        String stringAttSkrivaUT = "Något gick fel här!";
        if (rbtnTid1.isSelected()) {
            dataHanterare.bestamMotestid(motesId, userId, datum1, stt1, slt1);
            stringAttSkrivaUT = "Mötet " + dataHanterare.getMotesnamn(motesId) + " är nu bestämt till " + datum1 + " " + stt1 + "-" + slt1;
        } else if (rbtnTid2.isSelected()) {
            dataHanterare.bestamMotestid(motesId, userId, datum2, stt2, slt2);
            stringAttSkrivaUT = "Mötet " + dataHanterare.getMotesnamn(motesId) + " är nu bestämt till " + datum2 + " " + stt2 + "-" + slt2;
        } else if (rbtnTid3.isSelected()) {
            dataHanterare.bestamMotestid(motesId, userId, datum3, stt3, slt3);
            stringAttSkrivaUT = "Mötet " + dataHanterare.getMotesnamn(motesId) + " är nu bestämt till " + datum3 + " " + stt3 + "-" + slt3;
        }

        JOptionPane.showMessageDialog(null, stringAttSkrivaUT);
        rbtnTid1.setSelected(false);
        rbtnTid2.setSelected(false);
        rbtnTid3.setSelected(false);
        this.dispose();
    }//GEN-LAST:event_btnBestamMoteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestamMote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInst;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JRadioButton rbtnTid1;
    private javax.swing.JRadioButton rbtnTid2;
    private javax.swing.JRadioButton rbtnTid3;
    private javax.swing.ButtonGroup rbtngTider;
    private javax.swing.JTextArea txaRespons;
    // End of variables declaration//GEN-END:variables
}
