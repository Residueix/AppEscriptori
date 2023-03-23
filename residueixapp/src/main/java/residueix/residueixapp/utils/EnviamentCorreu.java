package residueix.residueixapp.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Classe per enviar correus electrònics
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */

public class EnviamentCorreu {
   
    /**
     * Mètode main de la classe EnviamentCorreu
     * @param args
     */
    public static void main(String[] args){
    }
    
    /**
     * Mètode enviament de la classe EnviamentCorreu
     * @param assumpte (String) : assumpte del correu
     * @param missatge (String) : missatge del correu
     * @param destinatari (String) : correu al que va dirigit
     * @return true/false (Boolean) : resultat.
     */
    public boolean enviament(String assumpte, String missatge, String destinatari){

        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.smtp.port", "587");
        props.put("mail.smtp.user", "residueix@gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        
        Session sessio = Session.getDefaultInstance(props);
        MimeMessage mail = new MimeMessage(sessio);
        
        try {
            mail.setFrom(new InternetAddress ("residueix@gmail.com"));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatari));
            mail.setSubject(assumpte);
            mail.setText(missatge);
            
            try (Transport trans = sessio.getTransport("smtp")) {
                trans.connect("residueix@gmail.com","dqadjkwuwinqyrpi");
                trans.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
            
            return true;
                    
        } catch (MessagingException ex){
            
            System.out.println(ex.getMessage());
            return false;
            
            
        }
        
    }
    
}
