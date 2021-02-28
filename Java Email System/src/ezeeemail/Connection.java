/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;

import static ezeeemail.ReceiveMail.messages;
import static ezeeemail.User.password;
import static ezeeemail.User.user;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author moaza
 */
public abstract class Connection implements User {
        final static String host = "pop.gmail.com";
        final static String storeType = "pop3";
         static Store store;
        static Session emailSession;
        static Folder emailFolder;
        static Message[] messages;
        
       Connection(){
           try{
                 Properties properties = new Properties();

      properties.put("mail.pop3.host", host);
      properties.put("mail.pop3.port", "995");
      properties.put("mail.pop3.starttls.enable", "true");
       emailSession = Session.getDefaultInstance(properties);
  
      //create the POP3 store object and connect with the pop server
       store = emailSession.getStore("pop3s");

      store.connect(host, user, password);

      //create the folder object and open it
      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
      messages = emailFolder.getMessages();
      
      
           }catch(Exception ae){
               
           }
    
}
    
    
}
    

