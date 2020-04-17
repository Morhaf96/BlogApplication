/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Team 14
 */
public class DataHanterare {

    private static InfDB databasen;

    public static InfDB dataHanterare() {
        if (databasen == null) {
            try {
                File dbFil = new File("BLOGDB.FDB");
                String path = dbFil.getAbsolutePath();
                databasen = new InfDB(path);
                System.out.println("Uppkopplingen lyckades!");
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

    public int getNextInlaggId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Inlagg", "InlaggId");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public int getNextMotesId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Moten", "MotesId");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public int getNextFilkategoriId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Filkategorier", "FKID");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public int getNextFilId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Filer", "FILID");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public int getNextForslagId() {
        String id = "";
        try {
            id = databasen.getAutoIncrement("Anvandare_moten", "ForslagId");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public boolean registreraNyAnvandare(String fornamn, String efternamn, String email, String losenord, String telefonnummer) {
        boolean anvandareRegistrerad = false;
        String fornamnet = stringFormat(fornamn);
        String efternamnet = stringFormat(efternamn);
        String mejlet = stringFormat(email);

        try {
            databasen.insert("insert into anvandare(anvandarid, fornamn, efternamn, mejl, telefonnummer, losenord, profilbildurl) "
                    + "values ('" + getNextAnvandarId() + "', '" + fornamnet + "', '" + efternamnet + "', '" + mejlet + "', '"
                    + telefonnummer + "', '" + losenord + "', 'Profilepic.jpg');");
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

    public boolean skapaNyttMote(int motesId, int arrangor, String datum, String starttid, String sluttid, String titel, String plats) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into moten values ('" + motesId + "', '" + arrangor + "', '" + datum + "', '" + starttid + "', '"
                    + sluttid + "', '" + titel + "', 'Profilepic.jpg');");
            lyckats = true;
            JOptionPane.showMessageDialog(null, "Nytt möte har registrerats");

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Registreringen misslyckades");
            lyckats = false;
            System.out.println("Nytt möte registrering lyckades ej. \n"
                    + e.getMessage());
        }
        return lyckats;
    }

    public void fyllCmbAnvandarnamn(JComboBox cmbAnvandarnamn) {
        try {
            ArrayList anvandarIdLista = new ArrayList();
            anvandarIdLista = databasen.fetchColumn("SELECT anvandarId FROM ANVANDARE");
            ArrayList<String> allaAnvandare = new ArrayList<>();

            for (Object anvandarId : anvandarIdLista) {
                String fornamn = databasen.fetchSingle("SELECT FORNAMN FROM ANVANDARE WHERE anvandarId='" + anvandarId + "'");
                String efternamn = databasen.fetchSingle("SELECT EFTERNAMN FROM ANVANDARE WHERE anvandarId='" + anvandarId + "'");
                String anvandare = fornamn + " " + efternamn;
                allaAnvandare.add(anvandare);
            }
            allaAnvandare.sort(String::compareToIgnoreCase);

            for (String namn : allaAnvandare) {
                cmbAnvandarnamn.addItem(namn);
            }
            cmbAnvandarnamn.setSelectedIndex(-1);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }

    public int getAnvandarId(String fornamn, String efternamn) {
        int id = 0;
        try {
            String stringId = databasen.fetchSingle("Select anvandarId from Anvandare where fornamn='" + fornamn + "' and efternamn='" + efternamn + "';");
            id = Integer.parseInt(stringId);
            System.out.println(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        return id;
    }

    public boolean laggTillMotesForslag(int anvandarId, int motesId, int forslagId, int andraforslagId, int tredjeforlsagId,
            String datum1, String starttid1, String slutid1, String datum2, String starttid2, String slutid2,
            String datum3, String starttid3, String slutid3) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into anvandare_moten values ('" + anvandarId + "', '" + motesId + "', 'U', '" + forslagId + "', 'U', '"
                    + datum1 + " " + starttid1 + "', '" + slutid1 + "');");
            databasen.insert("insert into anvandare_moten values ('" + anvandarId + "', '" + motesId + "', 'U', '" + andraforslagId + "', 'U', '"
                    + datum2 + " " + starttid2 + "', '" + slutid2 + "');");
            databasen.insert("insert into anvandare_moten values ('" + anvandarId + "', '" + motesId + "', 'U', '" + tredjeforlsagId + "', 'U', '"
                    + datum3 + " " + starttid3 + "', '" + slutid3 + "');");

            lyckats = true;
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel här!!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }

        return lyckats;
    }

    public void fyllListMotesInbjudningar(int anvandarId, JList lista) {
        DefaultListModel model = new DefaultListModel();
        DefaultListModel model1 = new DefaultListModel();
        ArrayList<String> enLista = null;
        ArrayList<String> enLista2 = null;

        try {
            enLista = databasen.fetchColumn("SELECT DISTINCT Titel FROM MOTEN JOIN Anvandare_Moten ON Anvandare_Moten.MostesId = MOTEN.MotesId WHERE Anvandare_Moten.Deltagare = '" + anvandarId + "';");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            String svar = "";
            for (int i = 0; i < enLista.size(); i++) {
                svar = enLista.get(i);
                model.addElement(svar);
            }

            lista.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Du har inga aktuella mötesinjudningar");
        }
    }

    public void fyllListInplaneradeMoten(int anvandarId, JList lista) {
        DefaultListModel model = new DefaultListModel();
        ArrayList<String> enLista = null;
        ArrayList<String> enLista2 = null;

        try {
            ArrayList<String> listan = databasen.fetchColumn("SELECT MOTE.titel FROM MOTEN "
                    + "JOIN Anvandare_Moten ON MOTEN.motesId=Anvandare_Moten.MostesId "
                    + "WHERE Deltagare='" + anvandarId + "'");
            String svar = "";
            for (int i = 0; i < listan.size(); i++) {
                svar = listan.get(i);
                model.addElement(svar);
            }
            lista.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Du har inga inplanerade möten");
        }
    }

    public boolean skapaInlagg(int inlaggID, int skribent, String inlagg, int bsektion, String titel, String datum, String tid) {
        boolean lyckats = false;
        try {
            String fraga = "INSERT INTO INLAGG VALUES('" + inlaggID + "','" + skribent + "','" + inlagg + "','" + bsektion + "', '" + titel + "', '" + datum + "', '" + tid + "');";
            databasen.insert(fraga);
            lyckats = true;
        } catch (Exception e) {
            System.out.println("Internt felmeddelande från skapaInlägg:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean laggTillFil(String namn, String filUrl, int inlaggId) {
        boolean lyckats = false;
        int filid = getNextFilId();
        try {
            databasen.insert("insert into filer values('" + filid + "', '" + namn + "', '" + filUrl + "', '" + inlaggId + "');");
            lyckats = true;
        } catch (InfException e) {

        }
        return lyckats;
    }

    public int getMotesId(String motesNamn) {
        int svar = 0;
        try {
            String idString = databasen.fetchSingle("select motesid from moten where titel='" + motesNamn + "';");
            svar = Integer.parseInt(idString);
        } catch (InfException e) {
            System.out.println("Det gick inte att hämta mötesId");
        }
        return svar;
    }

    public String getFullNamn(int userId) {
        String namnet = "";
        String fornamn = "";
        String efternamn = "";
        try {
            fornamn = databasen.fetchSingle("select fornamn from anvandare where anvandarId='" + userId + "';");
            efternamn = databasen.fetchSingle("select efternamn from anvandare where anvandarId='" + userId + "';");
            namnet = fornamn + " " + efternamn;
        } catch (InfException e) {
            System.out.println("Det gick inte att hämta namnet på personen!");
        }
        return namnet;
    }

    public String getMotesnamn(int motesId) {
        String namnet = "";

        try {
            namnet = databasen.fetchSingle("select titel from moten where motesid='" + motesId + "';");
        } catch (InfException e) {
            System.out.println("Det gick inte att hämta namnet på personen!");
        }
        return namnet;
    }

    public boolean inlaggetHarFil(String inlaggId) {
        boolean filFinns = false;
        try {
            databasen.fetchSingle("select filurl from filer where InlaggId='" + inlaggId + "';");
            filFinns = true;
        } catch (Exception e) {
            System.out.println("inlaggetHarFil error:" + e.getMessage());
        }
        return filFinns;
    }

    public int getInlaggFilId(String inlaggId) {
        int filId = 0;
        try {
            String filIdS = databasen.fetchSingle("select FilId from filer where inlaggid='" + inlaggId + "';");
            filId = Integer.parseInt(filIdS);
        } catch (Exception e) {

        }
        return filId;
    }

    public ArrayList getFormellaInlaggId() {
        ArrayList enLista = new ArrayList();
        try {
            enLista = databasen.fetchColumn("SELECT INLAGGID FROM INLAGG WHERE BSEKTION='1' ORDER BY DATUM DESC, TID DESC");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("getFormellInlaggId error:" + e.getMessage());
        }
        return enLista;
    }

    public String getInlaggTitel(String inlaggId) {
        String titel = "Untitled post";
        try {
            titel = databasen.fetchSingle("select titel from inlagg where inlaggid='" + inlaggId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggFilId error:" + e.getMessage());
        }
        return titel;
    }

    public String getInlaggSkribentNamn(String inlaggId) {
        String fornamn = "";
        String efternamn = "";
        try {
            fornamn = databasen.fetchSingle("select fornamn from Anvandare join Inlagg on inlagg.skribent = anvandare.anvandarid where inlagg.inlaggid='" + inlaggId + "';");
            efternamn = databasen.fetchSingle("select efternamn from Anvandare join Inlagg on inlagg.skribent = anvandare.anvandarid where inlagg.inlaggid='" + inlaggId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggSkribentNamn error:" + e.getMessage());
        }

        String fullnamn = fornamn + " " + efternamn;
        return fullnamn;
    }

    public String getInlaggDatum(String inlaggId) {
        String datum = "";
        try {
            datum = databasen.fetchSingle("select datum from inlagg where inlaggid='" + inlaggId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggDatum error:" + e.getMessage());
        }

        return datum;
    }

    public String getInlaggTid(String inlaggId) {
        String tid = "";
        try {
            tid = databasen.fetchSingle("select tid from inlagg where inlaggid='" + inlaggId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }

        return tid;
    }

    public String getFilNamn(int filId) {
        String filnamn = "";
        try {
            filnamn = databasen.fetchSingle("select filnamn from filer where filid='" + filId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }

        return filnamn;
    }

    public String getFilUrl(int filId) {
        String url = "";
        try {
            url = databasen.fetchSingle("select filurl from filer where filid='" + filId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }

        return url;
    }

    public String getInlaggText(String inlaggId) {
        String text = "";
        try {
            text = databasen.fetchSingle("select text from inlagg where inlaggid='" + inlaggId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }

        return text;
    }

    public String getAnvandarFornamn(int userId) {
        String namn = "";
        try {
            namn = databasen.fetchSingle("select fornamn from anvandare where anvandarId='" + userId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }

        return namn;
    }
    
    public String getMotetsSkapareNamn(int motesId){
     String fornamn = "";
     String efternamn = "";
     try {
            fornamn = databasen.fetchSingle("select fornamn from anvandare join moten on anvandare.anvandarId=moten.arrangor where moten.motesid='" + motesId + "';");
            efternamn=fornamn = databasen.fetchSingle("select efternamn from anvandare join moten on anvandare.anvandarId=moten.arrangor where moten.motesid='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }
     String fullnamn=fornamn + " " + efternamn;
     return fullnamn;
    }

}
