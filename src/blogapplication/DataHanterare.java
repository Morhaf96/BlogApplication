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
    
    public int getUserId(String mejl) {
        int userId = 0;
        try {
            String query = databasen.fetchSingle("Select AnvandarId from Anvandare where Mejl='" + mejl + "';");
            userId = Integer.parseInt(query);
        } catch (InfException e) {
            System.out.println("getUserId felmeddelande1: " + e.getMessage());
            System.out.println(userId);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Användaren hiitades ej! \n"
                    + "Vänligen dubbelkolla mejlet du angav och försök igen.");
            System.out.println("getUserId felmeddelande2: " + e.getMessage());
        }

        return userId;
    }
    
    public static boolean kontrolleraInloggning(int userId, char[] losenord) {
        boolean stammer = false;
        String userLosenord = "";
        try {
            userLosenord = databasen.fetchSingle("Select Losenord from Anvandare where AnvandarId='" + userId + "'");
        } catch (InfException e) {
            System.out.println("kollaInloggning felmeddelande: " + e);
        }
        if (Arrays.equals(losenord, userLosenord.toCharArray())) {
            stammer = true;
        }
        return stammer;
    }
    
    public int getNextAnvandarId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Anvandare", "AnvandarId");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }
    
    public boolean registreraNyAnvandare(String fornamn, String efternamn, String email, String losenord, String telefonnummer) {
        boolean anvandareRegistrerad = false;
        String fornamnet=stringFormat(fornamn);
        String efternamnet=stringFormat(efternamn);
        String mejlet=stringFormat(email);
        
        try {
            databasen.insert("insert into anvandare(anvandarid, fornamn, efternamn, mejl, telefonnummer, losenord, profilbildurl) "
                    + "values ('" + getNextAnvandarId() + "', '" + fornamnet + "', '" + efternamnet + "', '" + mejlet + "', '"+
                    telefonnummer +"', '"+losenord+"', 'Profilepic.jpg');");
            anvandareRegistrerad = true;
            JOptionPane.showMessageDialog(null, "Registreringen lyckades!");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Registreringen misslyckades");
            System.out.println("Registreringen misslyckades!\n"
                    + "RegistreraNyElev felmeddelande: " + e.getMessage());
        }
        return anvandareRegistrerad;
    }
    
    public String stringFormat(String enString) {
        String nyString = enString.substring(0, 1).toUpperCase() + enString.substring(1, enString.length()).toLowerCase();
        return nyString;
    }
    
}
    

