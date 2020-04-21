/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import static com.oracle.jrockit.jfr.Transition.From;
import java.util.Date;
import java.util.Properties;
import javafx.scene.chart.PieChart.Data;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import oru.inf.InfDB;

/**
 *
 * @author Parisa Mohammadi
 */
public class Email {

    private static DataHanterare dataHanterare;
    private static InfDB databasen;
    private static String mailadress;

    public Email(DataHanterare datahanterare) {
        dataHanterare = new DataHanterare();
        databasen = DataHanterare.dataHanterare();

    }

    public void sendEmailNotiser(int notisnummer, String mailadress) {
        if (notisnummer == 1) {
            try {
                String host = "smtp.gmail.com";
                String user = "parisamohammadi76@gmail.com";
                String password = "123";
                String to = mailadress;
                String from = "parisamohammadi76@gmail.com";
                String subject = "Notis från oru";
                String message = "Någon har kommenterat ett inlägg du skapade!";
                boolean sessionDebug = false;

                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", 587);
                props.put("mail.smtp.auth", true);
                props.put("mail.smtp.starttls.required", true);

//              java.security.Security.addProvider(new com.sun.net.httpserver.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(message);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, password);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (notisnummer == 2) {
            try {
                String host = "smtp.gmail.com";
                String user = "parisamohammadi76@gmail.com";
                String password = "123";
                String to = mailadress;
                String from = "parisamohammadi76@gmail.com";
                String subject = "Notis från oru";
                String message = "Någon har kommenterat ett inlägg du följer!";
                boolean sessionDebug = false;

                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", 587);
                props.put("mail.smtp.auth", true);
                props.put("mail.smtp.starttls.required", true);

//              java.security.Security.addProvider(new com.sun.net.httpserver.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(message);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, password);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
