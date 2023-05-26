package IesPerezMinik.Gestor.de.Correos.Api;


import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class llamadaSMTP {
    	
    	public Properties smtpMicrosoft() {
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
		return props;
    	}
        
    	
    	public Properties smtpGmail() {
            
            Properties props = new Properties();
          
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "587");
            
    		return props;
        	}
       
    	
    	public Properties smtpYahoo() {
            
            Properties props = new Properties();
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.mail.yahoo.com");
          props.put("mail.smtp.port", "587");
    		return props;
        	}
       
        public void EnviarMensaje(Properties props,String username,String password, List<String> emails, String subject,String text) throws AddressException, MessagingException {
        
        // Crear sesión de correo electrónico
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

            // Crear mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            InternetAddress[] addresses = new InternetAddress[emails.size()];
            for (int i = 0; i < emails.size(); i++) {
                addresses[i] = new InternetAddress(emails.get(i));
            }
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(subject);
            message.setText(text);

            // Enviar correo electrónico
            
            Transport.send(message, username, password);

            System.out.println("El correo electrónico ha sido enviado exitosamente.");

        }
    
}

