/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;

import java.io.File;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
import javax.swing.JOptionPane;





/**
 *
 * @author moaza
 */
public class SendEmail implements User {
    private String TO;
    private String subject;
    private String msg;
    private File f;
//    public String UserName="moazamshahid555@gmail.com";
//    public String Password="Mo1z1m.1li@";
     String host = "pop.gmail.com";

     SendEmail( String TO){
        this.TO=TO;
    }
    public void Subject(String subject){
        this.subject=subject;
    }
    public void Message(String msg){
        this.msg=msg;
    }
    public void setFile(File f){
        this.f=f;
    }
    public void ComposeEmail(){
    
        
         Properties props = System.getProperties();  
      props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host",host);  
        props.put("mail.smtp.port", "587"); 
       Session session = Session.getInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(user));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(TO));  
         message.setSubject(subject);  
//         message.setText(msg);  

    BodyPart messageBodyPart1 = new MimeBodyPart();  
    messageBodyPart1.setText(msg);  
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
  
    String filename = f.toString();//change accordingly  
    DataSource source = new FileDataSource(filename);  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(filename);  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    //6) set the multiplart object to the message object  
    message.setContent(multipart );
  
         // Send message  
         Transport.send(message);  
         JOptionPane.showMessageDialog(null,"Message sent Successfully....");
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex)
      {
          mex.printStackTrace();
      }  
    }
}
