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
        String id = "1";
        try {
            id = databasen.getAutoIncrement("Anvandare", "AnvandarId");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        return Integer.parseInt(id);
    }

    public int getNextInlaggId() {
        int id = 1;
        try {
           String idI = databasen.getAutoIncrement("Inlagg", "InlaggId");
            id=Integer.parseInt(idI);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        catch(java.lang.NumberFormatException e){
       id=1;
        }
        return id;
    }

    public int getNextMotesId() {
        int id = 1;
        try {
          String idI = databasen.getAutoIncrement("Moten", "MotesId");
            id=Integer.parseInt(idI);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        catch(java.lang.NumberFormatException e){
       id=1;
        }
        return id;
        
    }

    public int getNextFilkategoriId() {
        int id = 1;
        try {
          String idI = databasen.getAutoIncrement("filkategorier", "fkid");
            id=Integer.parseInt(idI);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        catch(java.lang.NumberFormatException e){
       id=1;
        }
        return id;
    }

    public int getNextFilId() {
         int id = 1;
        try {
          String idI = databasen.getAutoIncrement("filer", "filid");
            id=Integer.parseInt(idI);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        catch(java.lang.NumberFormatException e){
       id=1;
        }
        return id;
    }

    public int getNextForslagId() {
         int id = 1;
        try {
          String idI = databasen.getAutoIncrement("Anvandare_moten", "forslagid");
            id=Integer.parseInt(idI);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("getNextAnvandarId felmeddelande: " + e.getMessage());
        }
        catch(java.lang.NumberFormatException e){
       id=1;
        }
        return id;
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
        String nyString = "";
        try {
            String forstabokstav = enString.substring(0, 1).toUpperCase();
            String resten = enString.substring(1, enString.length()).toLowerCase();
            nyString = forstabokstav + resten;
        } catch (StringIndexOutOfBoundsException e) {

        }
        return nyString;
    }

    public boolean skapaNyttMote(int motesId, int arrangor, String datum, String starttid, String sluttid, String titel, String plats) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into moten values ('" + motesId + "', '" + arrangor + "', '" + datum + "', '" + starttid + "', '"
                    + sluttid + "', '" + titel + "', '" + plats + "');");
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

    public void harMotesInbjudningar(int anvandarId) {
        boolean har = false;
        try {
            String data = databasen.fetchSingle("SELECT DISTINCT Titel FROM MOTEN JOIN Anvandare_Moten ON Anvandare_Moten.MostesId = MOTEN.MotesId WHERE Anvandare_Moten.Deltagare = '" + anvandarId + "';");
            if (data != null && !data.isEmpty()) {
                har = true;
            }
        } catch (Exception e) {
            System.out.println("harMotesInbjudningar error: " + e.getMessage());
        }

        if (har == false) {
            JOptionPane.showMessageDialog(null, "Du har inga aktuella mötesinjudningar");
        }
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

            System.out.println("fyllListMotesInbjudningar error: " + e.getMessage());
        }
    }

    public void harSkapadeMoten(int anvandarId) {
        boolean har = false;
        try {
            String data = databasen.fetchSingle("SELECT DISTINCT Titel FROM MOTEN WHERE Arrangor = '" + anvandarId + "' and datum='2000-01-01';");
            if (data != null && !data.isEmpty()) {
                har = true;
            }
        } catch (Exception e) {
            System.out.println("harSkapadeMoten error: " + e.getMessage());
        }

        if (har == false) {
            JOptionPane.showMessageDialog(null, "Du har inte skapat några möten än");
        }
    }

    public void fyllListaMinaSkapadeMoten(int anvandarId, JList lista) {
        DefaultListModel model = new DefaultListModel();
        ArrayList<String> enLista = null;

        try {
            enLista = databasen.fetchColumn("SELECT DISTINCT Titel FROM MOTEN WHERE Arrangor = '" + anvandarId + "' and datum='2000-01-01';");
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
            System.out.println("fyllListaMinaSkapadeMoten error: " + e.getMessage());

        }
    }

    public void harInplaneradeMoten(int anvandarId) {
        boolean har = false;
        try {
            String data = databasen.fetchSingle("SELECT distinct MOTEN.titel FROM MOTEN "
                    + "JOIN Anvandare_Moten ON MOTEN.motesId=Anvandare_Moten.MostesId "
                    + "WHERE Deltagare='" + anvandarId + "' or arrangor='" + anvandarId + "';");
            if (data != null && !data.isEmpty()) {
                har = true;
            }
        } catch (Exception e) {
            System.out.println("harInplaneradeMoten error: " + e.getMessage());
        }

        if (har == false) {
            JOptionPane.showMessageDialog(null, "Du har inga inplanerade möten");
        }
    }

    public void fyllListInplaneradeMoten(int anvandarId, JList lista) {
        DefaultListModel model = new DefaultListModel();
        try {
            ArrayList<String> listan = databasen.fetchColumn("SELECT distinct MOTEN.titel FROM MOTEN "
                    + "JOIN Anvandare_Moten ON MOTEN.motesId=Anvandare_Moten.MostesId "
                    + "WHERE moten.datum not like '2000-01-01' and (Deltagare='" + anvandarId + "' or arrangor='" + anvandarId + "');");
            String svar = "";
            for (int i = 0; i < listan.size(); i++) {
                svar = listan.get(i);
                model.addElement(svar);
            }
            lista.setModel(model);
        } catch (Exception e) {
            System.out.println("fyllListInplaneradeMoten error: " + e.getMessage());
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

    public boolean laggTillFil(String namn, String filUrl, int inlaggId, String fkid) {
        boolean lyckats = false;
        if (namn.isEmpty()||namn.equals(null)){
        namn="Unnamed File";
        }
        int filid = getNextFilId();
        try {
            databasen.insert("insert into filer values('" + filid + "', '" + namn + "', '" + filUrl + "', '" + inlaggId + "', '" + fkid + "');");
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
   

    public String getMotetsSkapareNamn(int motesId) {
        String fornamn = "";
        String efternamn = "";
        try {
            fornamn = databasen.fetchSingle("select fornamn from anvandare join moten on anvandare.anvandarId=moten.arrangor where moten.motesid='" + motesId + "';");
            efternamn  = databasen.fetchSingle("select efternamn from anvandare join moten on anvandare.anvandarId=moten.arrangor where moten.motesid='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getInlaggTid error:" + e.getMessage());
        }
        String fullnamn = fornamn + " " + efternamn;
        return fullnamn;
    }

    public ArrayList getDeltagarnasId(int motesId) {
        ArrayList deltagarsID = new ArrayList();
        try {
            deltagarsID = databasen.fetchColumn("SELECT distinct deltagare FROM ANVANDARE_Moten where mostesid='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getDeltagarnasId error:" + e.getMessage());
        }
        return deltagarsID;
    }

    public ArrayList getForslagId(int motesId, String anvId) {
        ArrayList FId = new ArrayList();
        try {
            FId = databasen.fetchColumn("SELECT distinct forslagId FROM ANVANDARE_Moten where mostesid='" + motesId + "' And deltagare='" + anvId + "';");
        } catch (Exception e) {
            System.out.println("getDeltagarnasId error:" + e.getMessage());
        }
        return FId;
    }

    public boolean harSvaratInbjudan(int motesId, String anvId) {
        boolean svarat = false;
        try {
            String svar = databasen.fetchSingle("Select kan from anvandare_moten where mostesId='" + motesId + "' and deltagare='" + anvId + "';");

            if (svar.trim().equalsIgnoreCase("Y") || svar.trim().equalsIgnoreCase("N")) {
                svarat = true;
            }
        } catch (Exception e) {
            System.out.println("harSvaratInbjudan error:" + e.getMessage());
        }
        return svarat;
    }

    public String getInteSvaratRespons(String anvId) {
        String svar = "";
        int idI = Integer.parseInt(anvId);
        try {
            svar = getFullNamn(idI) + " har inte meddelat tillgänglighet än. \n";
        } catch (Exception e) {
            System.out.println("getInteSvaratRespons error:" + e.getMessage());
        }

        return svar;
    }

    public String getAnvandarRespons(String forslagId) {
        String svar = "";
        try {
            String anvIdS = databasen.fetchSingle("Select deltagare from ANVANDARE_MOTEN where forslagid='" + forslagId + "';");
            int anvandaresId = Integer.parseInt(anvIdS);
            String fullnamn = getFullNamn(anvandaresId);
            String datumlang = databasen.fetchSingle("Select datum from ANVANDARE_MOTEN where forslagid='" + forslagId + "';");
            String sluttid = databasen.fetchSingle("Select sluttid from ANVANDARE_MOTEN where forslagid='" + forslagId + "';");
            String datum = datumlang.substring(0, 10);
            String starttid = datumlang.substring(11, 16);
            String kan = databasen.fetchSingle("Select kan from ANVANDARE_MOTEN where forslagid='" + forslagId + "';");

            if (kan.trim().equalsIgnoreCase("Y")) {
                svar = fullnamn + " kan komma den " + datum + " kl " + starttid + "-" + sluttid + ".\n";
            } else if (kan.trim().equalsIgnoreCase("N")) {
                svar = fullnamn + " kan inte komma den " + datum + " kl " + starttid + "-" + sluttid + ".\n";
            }
        } catch (Exception e) {
            System.out.println("getAnvandarRespons error:" + e.getMessage());
        }
        return svar;
    }

    public String getMotesTid(String forlsagId) {
        String svar = "";
        try {
            svar = databasen.fetchSingle("select datum from anvandare_moten where forslagid='" + forlsagId + "';");
        } catch (Exception e) {
            System.out.println("getMotesTider error:" + e.getMessage());
        }
        return svar;
    }

    public String getMotesSluttid(String forlsagId) {
        String svar = "";
        try {
            svar = databasen.fetchSingle("select sluttid from anvandare_moten where forslagid='" + forlsagId + "';");
        } catch (Exception e) {
            System.out.println("getMotesSluttid error:" + e.getMessage());
        }
        return svar;
    }

    public boolean bestamMotestid(int motesId, int userId, String datum, String starttid, String sluttid) {
        boolean lyckats = false;
        try {
            databasen.update("update moten set datum='" + datum + "', starttid='" + starttid + "', sluttid='" + sluttid + "' where motesid='" + motesId + "' and arrangor='" + userId + "';");
            lyckats = true;
        } catch (Exception e) {
            System.out.println("bestamMotestid error:" + e.getMessage());
        }

        return lyckats;
    }

    public ArrayList getForslagId(int motesId) {
        ArrayList Lista = new ArrayList();
        try {
            Lista = databasen.fetchColumn("select forslagid from anvandare_moten where mostesid='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getForslagId error:" + e.getMessage());
        }
        return Lista;
    }

    public ArrayList getPlaneradeMoten(String datum) {
        ArrayList Lista = new ArrayList();
        try {
            Lista = databasen.fetchColumn("select motesid from moten where datum='" + datum + "';");
        } catch (Exception e) {
            System.out.println("getForslagId error:" + e.getMessage());
        }
        return Lista;
    }

    public String getMotetsDatum(String motesId) {
        String svar = "";
        try {
            svar = databasen.fetchSingle("select datum from moten where motesId='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getMotetsDatum error:" + e.getMessage());
        }
        return svar;
    }

    public String getMotetsStarttid(String motesId) {
        String svar = "";
        try {
            svar = databasen.fetchSingle("select starttid from moten where motesId='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getMotetsStarttid error:" + e.getMessage());
        }
        return svar;
    }

    public String getMotetsSluttid(String motesId) {
        String svar = "";
        try {
            svar = databasen.fetchSingle("select sluttid from moten where motesId='" + motesId + "';");
        } catch (Exception e) {
            System.out.println("getMotetsSluttid error:" + e.getMessage());
        }
        return svar;
    }

    public String getMotetsnamn(String motesId) {
        String namnet = "";

        try {
            namnet = databasen.fetchSingle("select titel from moten where motesid='" + motesId + "';");
        } catch (InfException e) {
            System.out.println("Det gick inte att hämta namnet på personen!");
        }
        return namnet;
    }

    public ArrayList getInformellaInlaggId() {
        ArrayList enLista = new ArrayList();
        try {
            enLista = databasen.fetchColumn("SELECT INLAGGID FROM INLAGG WHERE BSEKTION='2' ORDER BY DATUM DESC, TID DESC");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("getInformellaInlaggId error:" + e.getMessage());
        }
        return enLista;
    }

    public ArrayList getUtbildningInlaggId() {
        ArrayList enLista = new ArrayList();
        try {
            enLista = databasen.fetchColumn("SELECT INLAGGID FROM INLAGG WHERE BSEKTION='3' ORDER BY DATUM DESC, TID DESC");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("getUtbildningInlaggId error:" + e.getMessage());
        }
        return enLista;
    }

    public ArrayList getForskningInlaggId() {
        ArrayList enLista = new ArrayList();
        try {
            enLista = databasen.fetchColumn("SELECT INLAGGID FROM INLAGG WHERE BSEKTION='4' ORDER BY DATUM DESC, TID DESC");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("getForskningInlaggId error:" + e.getMessage());
        }
        return enLista;
    }

    public boolean inlaggFinns(String inlaggId) {
        boolean lyckats = false;
        try {
            databasen.fetchSingle("select * from inlagg where InlaggID='" + inlaggId + "';");
            lyckats = true;
        } catch (Exception e) {
            System.out.println("inlaggFinns error:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean taBortInlaggFil(String inlaggId) {
        boolean lyckats = false;
        try {
            databasen.delete("delete from filer where InlaggID='" + inlaggId + "';");
            lyckats = true;
        } catch (Exception e) {
            System.out.println("taBortInlaggFil error:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean taBortInlagg(String inlaggId) {
        boolean lyckats = false;
        try {
            databasen.delete("delete from inlagg where InlaggID='" + inlaggId + "';");
            lyckats = true;
        } catch (Exception e) {
            System.out.println("taBortInlagg error:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean arAdmin(int userId) {
        boolean admin = false;
        try {
            ArrayList<String> adminLista = databasen.fetchColumn("select anvandarId from admins");
            for (String s : adminLista) {
                if (s.equalsIgnoreCase(Integer.toString(userId))) {
                    admin = true;
                }
            }

        } catch (Exception e) {
            System.out.println("arAdmin error:" + e.getMessage());
        }
        System.out.println("Ar admin returnerar " + admin);
        return admin;
    }

    public boolean arInlaggetsSkribent(int userId, String inlaggId) {
        boolean arSkribenten = false;
        try {
            String inlaggetsSkribentS = databasen.fetchSingle("select skribent from inlagg where inlaggId='" + inlaggId + "';");
            int inlaggetsSkribent = Integer.parseInt(inlaggetsSkribentS);
            if (inlaggetsSkribent == userId) {
                arSkribenten = true;
            }

        } catch (Exception e) {
            System.out.println("arInlaggetsSkribent error:" + e.getMessage());
        }
        System.out.println("Ar admin returnerar " + arSkribenten);
        return arSkribenten;
    }

    public boolean laggTillFilKategori(String kNamn) {
        boolean lyckats = false;
        String knamnF = stringFormat(kNamn);
        ArrayList<String> FKNamn = new ArrayList();
        try {
            FKNamn = databasen.fetchColumn("select distinct fknamn from filkategorier");
            boolean finns = false;
            for (String s : FKNamn) {
                if (s.equalsIgnoreCase(knamnF)) {
                    finns = true;
                    JOptionPane.showMessageDialog(null, "Den kategorin finns redan. \n Vänligen välj den från listan eller ange en ny kategori");
                }
            }
            if (finns == false) {
                int nastaFKId = getNextFilkategoriId();
                databasen.insert("insert into filkategorier values('" + nastaFKId + "','" + knamnF + "');");
            }

        } catch (Exception e) {
            System.out.println("laggTillKategori error:" + e.getMessage());
        }
        return lyckats;
    }

    public void fyllCmbFilkategorier(JComboBox cmbFKategori) {

        ArrayList<String> FKNamn = new ArrayList();
        try {
            FKNamn = databasen.fetchColumn("select distinct fknamn from filkategorier");
            for (String s : FKNamn) {
                cmbFKategori.addItem(s);
            }
            cmbFKategori.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println("fyllCmbFilkategorier error:" + e.getMessage());
        }
    }

    public String getFKID(String FKNamn) {
        String fkid = "";
        try {
            fkid = databasen.fetchSingle("select fkid from filkategorier where fknamn='" + FKNamn + "';");
        } catch (Exception e) {
            System.out.println("fyllCmbFilkategorier error:" + e.getMessage());
        }
        return fkid;
    }

    public String getFKid2(int filid) {
        String fkid = "";
        try {
            fkid = databasen.fetchSingle("select fkid from filer where filid='" + filid + "';");
        } catch (Exception e) {
            System.out.println("fyllCmbFilkategorier error:" + e.getMessage());
        }
        return fkid;
    }

    public String getFKnamn(String fkid) {
        String fknamn = "";
        try {
            fknamn = databasen.fetchSingle("select fknamn from filkategorier where fkid='" + fkid + "';");
        } catch (Exception e) {
            System.out.println("fyllCmbFilkategorier error:" + e.getMessage());
        }
        return fknamn;
    }

    public boolean taBortFK(String fkid) {
        boolean lyckats = false;
        try {
            databasen.delete("delete from filkategorier where fkid='" + fkid + "';");
            lyckats = true;
        } catch (Exception e) {
            System.out.println("taBortFK error:" + e.getMessage());
        }

        return lyckats;
    }

    public String getAnvMejl(int userId) {
        String mejl = "";
        try {
            mejl = databasen.fetchSingle("Select mejl from anvandare where anvandarid='" + userId + "';");
        } catch (Exception e) {
            System.out.println("getAnvandarnamn error:" + e.getMessage());
        }
        return mejl;
    }

    public boolean stangAvBloggNotiser(String userId) {
        boolean lyckats = false;
        try {
            databasen.delete("DELETE FROM notiser WHERE anvandarid = '" + userId + "' ");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "stangAvBloggNotiser har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean faFormellNotiser(String userId) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into notiser values('" + userId + "', '1');");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "stangAvBloggNotiser har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean faInformellNotiser(String userId) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into notiser values('" + userId + "', '2');");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "stangAvBloggNotiser har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean faUtbildningNotiser(String userId) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into notiser values('" + userId + "', '3');");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "stangAvBloggNotiser har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }

    public boolean faForskningNotiser(String userId) {
        boolean lyckats = false;
        try {
            databasen.insert("insert into notiser values('" + userId + "', '4');");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "stangAvBloggNotiser har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }

    public ArrayList<String> getBloggNotisLista(int BSId) {
        ArrayList<String> anvIdLista = new ArrayList<>();
        try {
            anvIdLista = databasen.fetchColumn("Select distinct anvandarid from notiser where bloggsektionid='" + BSId + "';");
        } catch (Exception e) {
            System.out.println("faBloggNotisLista error:" + e.getMessage());
        }
        return anvIdLista;
    }

    public String getBsNamn(int BSId) {
        String namnet = "";
        try {
            namnet = databasen.fetchSingle("Select bsektionnamn from bloggsektioner where bsektionid='" + BSId + "';");
        } catch (Exception e) {
            System.out.println("getBsNamn error:" + e.getMessage());
        }
        return namnet;

    }

    public void skickaBloggNotis(int userId, int skribent, int BSId) {
        String anvNamn = getFullNamn(userId);
        String skribenten = getFullNamn(skribent);
        String bsNamn = getBsNamn(BSId);
        String anvMejl = getAnvMejl(userId);
        String rubrik = "Blogginlägg notis";
        String innehall = "Hej " + anvNamn + "! \nEtt nytt inlägg har lagts i bloggsektionen \"" + bsNamn + "\" av " + skribenten + ". \nLogga in till systemet för att läsa inläggen.";
        Mejl.skickaMejl(anvMejl, rubrik, innehall);
    }

    public boolean setMotesNotis(int userId, int motesId, String notis) {
        boolean lyckats = false;
        try {
            databasen.update("update ANVANDARE_MOTEN set fapaminnelse='" + notis + "' where deltagare='" + userId + "' and mostesid='" + motesId + "';");

            lyckats = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "setMotesNotis har misslyckats:" + e.getMessage());
        }
        return lyckats;
    }
}
