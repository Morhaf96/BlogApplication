/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Team 14
 */
public class Sms {

    public static void skickaSms(String sms, String avsandare, String mottagare) {
        try {

            String apiKey = "apikey=" + "";
            //74wY8g/SAVY-WdrolirP5LObuecEI5BXEU0N6sG4PQ
            //JKBbA3k0XEQ-iaRLZpQidmLDOTW8dkq49k5wzaiQWM
            //Q4g4fSAHPg8-ToaXxb2XO7fTM1E3YYJYj3ARpE0Yp5
            
            String message = "&message=" + sms;
            String sender = "&sender=" + avsandare;
            String numbers = "&numbers=" + mottagare;

            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {

                JOptionPane.showMessageDialog(null, "message" + line);
            }
            rd.close();

        } catch (Exception e) {
            System.out.print(e+" message: " + e.getMessage());
        }
    }
}
