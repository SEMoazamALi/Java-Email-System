/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezeeemail;

/**
 *
 * @author moaza
 */
public class ReplyMail extends Connection {
    
    String To;
    ReplyMail(String sub, String TO ){
        String reply="Re<"+sub+">";
        this.To=TO;
        
        new SendMail().Reply(TO, reply);
    }
    
}
