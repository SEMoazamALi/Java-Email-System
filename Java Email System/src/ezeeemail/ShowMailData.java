/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;

import static ezeeemail.Connection.messages;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import org.jsoup.Jsoup;
import javax.swing.text.html.HTML;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author moaza
 */
public class ShowMailData extends Connection {
    
    ShowMailData(int val){
        try{
          
          
          String attachFiles = ""; 
          String messageContent = "";
          
          
          
         Message showMessage = messages[val];
         System.out.println("---------------------------------");
         //System.out.println("Email Number " + (val));
         
         String From=showMessage.getFrom()[0].toString();
         String subject=showMessage.getSubject();
         
         System.out.println("Subject: " + subject);
         System.out.println("From: " + From);
         
         String contentType = showMessage.getContentType();
         if (contentType.contains("multipart")) {
                    // content may contain attachments
                    Multipart multiPart = (Multipart) showMessage.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            
                            //part.saveFile(saveDirectory + File.separator + fileName);
                        } else {
                            // this part may be the message content
                            messageContent = part.getContent().toString();
                        }
                    }

                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                } else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
                    Object content = showMessage.getContent();
                    
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }
          
         
         
          String Msgtext = Jsoup.parse(messageContent).text();
          
          
                System.out.println("\t Message: " + Msgtext);
         
         //System.out.println("Text: " + showMessage.getContent().toString());
         
         
         
         ShowMail sm= new ShowMail(val);
         sm.setVisible(true);
         sm.setData(From, subject, Msgtext);
      }catch(Exception e){
          System.out.println(e);
            

      }
    }
    
}
