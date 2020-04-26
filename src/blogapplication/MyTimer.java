/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogapplication;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Morhaf
 */
public class MyTimer  {
    static int i=0;
   public static void main(String[] args){
   TimerTask tt= new TimerTask() {
       @Override
       public void run() {
           
       }
   };
   
   Timer t=new Timer();
   t.schedule(tt, 1000);
   }
   
}
