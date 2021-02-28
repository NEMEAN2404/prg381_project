package BussinessLayer;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
    public static void sendMail(String recepient, String MessageContent, String Subject) throws Exception{
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "CharmaineRaheal@gmail.com";
        String password = "CharmaineRaheal123";
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

       Message message = prepareMessage(session, myAccountEmail, recepient, MessageContent, Subject);

       Transport.send(message);
       System.out.println("Message sent");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String MessageContent, String Subject){
        try{        Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(Subject);
            message.setText(MessageContent);         
            return message;
        } catch (Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}

