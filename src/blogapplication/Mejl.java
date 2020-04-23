/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

/**
 *
 * @author Morhaf
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Team14
 */
public class Mejl {

    public static void skickaMejl(String mottagare, String amne, String meddelande) {
        //Hämtar objektet 
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.user", "Projektetbloggen");
        String losen = "morhaf123";
        String fran = "projektetbloggen@gmail.com";

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fran, losen);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fran));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mottagare));
            message.setSubject(amne);
            String footer = "\n\nObservera att detta mejl är autoskickat och därför inte går att besvara.";
            message.setText(meddelande + footer);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
