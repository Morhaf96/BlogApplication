/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;
import java.util.ArrayList;
/**
 *
 * @author Morhaf
 */
public class User {
    private int userId;
    private String firstName;
    private String lastname;
    private String eMail;
    private String password;
    private boolean adminStatus;
    
   public User(String fornamn, String efternamn, String email, String losenord){
   firstName = fornamn;
   lastname = efternamn;
   eMail = email;
   password = losenord;
   adminStatus = false;
   
   }
    
}
