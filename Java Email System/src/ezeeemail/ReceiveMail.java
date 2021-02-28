/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;

import java.io.IOException;  
import java.util.Properties;  
import javax.mail.Folder;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.NoSuchProviderException;  
import javax.mail.Session;  
import com.sun.mail.pop3.POP3Store; 
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsoup.*;

  
public class ReceiveMail extends Connection implements User{  
  
    
    static MailDashBoard b;
    String saveDirectory = "G:\\sdsf";
 public  ReceiveMail() {
       
//       String host = "pop.gmail.com";
//        String storeType = "pop3";
        
//        String user = "moazamshahid555@gmail.com"; //username for the mail you want to read
//        String password = "Mo1z1m.1li@"; //password
        
            b =new MailDashBoard();
            System.out.println("Object Created"+b);
            b.setVisible(true);
            
      try {

      //create properties field
//      Properties properties = new Properties();
//
//      properties.put("mail.pop3.host", host);
//      properties.put("mail.pop3.port", "995");
//      properties.put("mail.pop3.starttls.enable", "true");
//      Session emailSession = Session.getDefaultInstance(properties);
//  
//      //create the POP3 store object and connect with the pop server
//      Store store = emailSession.getStore("pop3s");
//
//      store.connect(host, user, password);
//
//      //create the folder object and open it
//      Folder emailFolder = store.getFolder("INBOX");
//      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
//      messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);

      for (int i = messages.length; i >=200; i--) {
         Message message = messages[i];
         System.out.println("---------------------------------");
         System.out.println("Email Number " + (i + 1));
         System.out.println("Subject: " + message.getSubject());
//         System.out.println("From: " + message.getFrom()[0]);
//         System.out.println("Text: " + message.getContent().toString());
        
            String sub =message.getSubject();
           String [] GR={message.getSubject()};
                DefaultTableModel tbl= (DefaultTableModel)b.tblInbox.getModel();
                tbl.addRow(GR);

      }
      

      //close the store and folder objects
      emailFolder.close(false);
      store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 


}  