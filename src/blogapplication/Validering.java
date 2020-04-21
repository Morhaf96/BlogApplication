/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Date;

/**
 *
 * @author Team 14
 */
public class Validering {

    /**
     * Metoden kontrollerar ett textfält och returnerar true ifall det är tomt,
     * och false annars. Om fältet är tomt dyker ett felmeddelande upp för att
     * varna användaren om felet och det tömma fältet får fokus.
     *
     * @param ettTextFalt
     * @return
     */
    public static boolean FaltArTom(JTextField ettTextFalt) {
        boolean resultat = false;
        if (ettTextFalt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Textfältet kan inte vara tomt!");
            ettTextFalt.requestFocus();
            resultat = true;
        }

        return resultat;
    }

    /**
     * Metoden kontrollerar två lösenordsfält och jämför deras innehåll. Metoden
     * returnerar true ifall lönsorden är identiska, och false annars.
     *
     * @param nyttpw
     * @param confirmpw
     * @return boolean arLika true om båda lösenordsfälten är lika.
     */
    public static boolean losenordArLika(JPasswordField nyttpw, JPasswordField confirmpw) {
        boolean arLika = false;
        if (Arrays.equals(nyttpw.getPassword(), confirmpw.getPassword())) {
            arLika = true;
            System.out.println("Nytt Lösenord bekräftat.");
        } else {
            nyttpw.requestFocus();
            JOptionPane.showMessageDialog(null, "Lösenordet gick inte att bekräfta. \n Vänligen försök igen!");
        }
        return arLika;
    }

    /**
     * Metoden kontrollerar ett textfält och returnerar true ifall det är tomt,
     * och false annars.
     *
     * @param ettTextFalt
     * @return
     */
    public static boolean FaltArTomUtanPopUp(JTextField ettTextFalt) {
        boolean resultat = false;
        if (ettTextFalt.getText().isEmpty()) {
            ettTextFalt.requestFocus();
            resultat = true;
        }

        return resultat;
    }

    /**
     * Metoden returnerar true om lösenordsfältet är tomt. Om fältet är tomt
     * dyker ett felmeddelande upp för att varna användaren om felet och det
     * tömma fältet får fokus
     *
     * @param pwfalt
     * @return boolean arTomt
     */
    public static boolean pwFaltArTom(JPasswordField pwfalt) {
        boolean resultat = false;
        if (pwfalt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lösenordsfältet kan inte vara tomt!");
            pwfalt.requestFocus();
            resultat = true;
        }

        return resultat;
    }

    public static boolean arTid(JTextField txtfalt) {
        boolean lyckats = false;
        try {
            String time = txtfalt.getText();

            DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date date = sdf.parse(time);
            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Är inte koreekt tid");
            System.out.println(e.getMessage());
        }

        return lyckats;
    }

    /**
     * Metoden kontrollerar att imatning består av enbart siffror och returnerar
     * true isåfall, och false annars. Om fältet innehåller annat än siffror
     * dyker ett felmeddelande upp för att varna användaren om felet och det
     * tömma fältet får fokus.
     *
     * @param ettTextFalt
     * @return
     */
    public static boolean arHeltal(JTextField ettTextFalt) {
        String stringAttKolla = ettTextFalt.getText();
        boolean resultat = true;
        try {
            Double num = Double.parseDouble(stringAttKolla);
        } catch (NumberFormatException e) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Textfältet får bara innehålla siffror!");
            System.out.println("arHeltal felmeddelande: " + e.getMessage());
            ettTextFalt.requestFocus();
        }
        return resultat;
    }

    public static boolean arMejl(JTextField ettTextFalt) {
        boolean resultat = true;
        try {
            String textAttKolla = ettTextFalt.getText();
            if (!textAttKolla.contains("@") || !textAttKolla.contains(".")) {
                resultat = false;
                JOptionPane.showMessageDialog(null, "Vänligen ange ett giltigt mejl!");
                ettTextFalt.requestFocus();
            }
        } catch (Exception e) {
            System.out.println("arHeltal felmeddelande: " + e.getMessage());
        }
        return resultat;
    }

    /**
     * Metoden kontrollerar om dagen som användaren har matat in är verklig
     * eller inte och returnerar en boolean med resultatet.
     *
     * @param ettTextFalt
     * @return
     */
    public static boolean giltigDag(JTextField ettTextFalt) {
        boolean resultat = false;
        String txt = ettTextFalt.getText();
        int dag = Integer.parseInt(txt);
        if (dag > 0 && dag <= 31) {
            resultat = true;
        } else {
            JOptionPane.showMessageDialog(null, "Vänligen ange en giltig dag!");
            System.out.println("giltigDag felmeddelande");
            ettTextFalt.requestFocus();
        }
        return resultat;
    }

    /**
     * Metoden kontrollerar om månaden som användaren har matat in är verklig
     * eller inte och returnerar en boolean med resultatet.
     *
     * @param ettTextFalt
     * @return
     */
    public static boolean giltigManad(JTextField ettTextFalt) {
        boolean resultat = false;
        String txt = ettTextFalt.getText();
        int manad = Integer.parseInt(txt);
        if (manad > 0 && manad <= 12) {
            resultat = true;
        } else {
            JOptionPane.showMessageDialog(null, "Vänligen ange en giltig månad!");
            System.out.println("giltigManad felmeddelande");
            ettTextFalt.requestFocus();
        }
        return resultat;
    }

    /**
     * Metoden kontrollerar att startdatumet är innan slutdatumet.
     *
     * @param startAr
     * @param startManad
     * @param startDag
     * @param slutAr
     * @param slutManad
     * @param slutDag
     * @return
     */
    public static boolean datumOrdning(JTextField startAr, JTextField startManad, JTextField startDag, JTextField slutAr, JTextField slutManad, JTextField slutDag) {
        boolean resultat = false;
        int startAret = Integer.parseInt(startAr.getText());
        int startManaden = Integer.parseInt(startManad.getText());
        int startDagen = Integer.parseInt(startDag.getText());
        int slutAret = Integer.parseInt(slutAr.getText());
        int slutManaden = Integer.parseInt(slutManad.getText());
        int slutDagen = Integer.parseInt(slutDag.getText());
        int startDatum = startAret + startManaden + startDagen;
        int slutDatum = slutAret + slutManaden + slutDagen;
        if (startDatum <= slutDatum) {
            resultat = true;
        } else {
            JOptionPane.showMessageDialog(null, "Startdatumet måste vara innan slutdatumet!");
            System.out.println("datumOrdning felmeddelande");
        }
        return resultat;
    }

    public static boolean arTelefonnummer(JTextField textfalt) {
        boolean arTNummer = true;
        int tfLangd = textfalt.getText().toString().length();

        if (tfLangd != 10) {
            arTNummer = false;
            System.out.println("arHeltal är false");
            JOptionPane.showMessageDialog(null, "Vänligen ange telefonnumret i formatet bredvid!");
            textfalt.requestFocus();
        }

        return arTNummer;
    }
}
