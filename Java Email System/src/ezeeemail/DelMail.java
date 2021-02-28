/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;


import static ezeeemail.Connection.messages;
import javax.mail.Flags;
import javax.mail.Message;

import javax.swing.JOptionPane;
  
public class DelMail extends Connection {  
 
        DelMail(int val){
             try{
     
     Message delMessage = messages[val];
        
	       // set the DELETE flag to true
	       delMessage.setFlag(Flags.Flag.DELETED, true);
	       System.out.println("Marked DELETE for message: " + delMessage.getSubject());
               JOptionPane.showMessageDialog(null, "Message Deleted Sucessfully");
               
               
     }
     catch(Exception e){
         
     }
        }
}  