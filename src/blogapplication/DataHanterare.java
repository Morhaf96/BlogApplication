/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Morhaf
 */
public class DataHanterare {
     private static InfDB databasen;

    public static InfDB dataHanterare() {

        if (databasen == null) {
            try {
                File dbFil = new File("BLOGDB.FDB");
                String path = dbFil.getAbsolutePath();
                databasen = new InfDB(path);
                JOptionPane.showMessageDialog(null, "Uppkopplingen lyckades!");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Systemet kan inte nå databasen!");
                System.out.println("Databasfelet som har inträffat: " + e.getMessage());
            }
        }
        return databasen;
    }
}
