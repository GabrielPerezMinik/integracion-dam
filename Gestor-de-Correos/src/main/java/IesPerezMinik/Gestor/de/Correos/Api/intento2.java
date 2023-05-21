package IesPerezMinik.Gestor.de.Correos.Api;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class intento2 {

    public static void main(String[] args) {


    	String username="";
    	String password="";
    	String recipientEmail="";
    	
    	
        // Configurar propiedades del servidor SMTP
        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.office365.com");
//        props.put("mail.smtp.port", "587");
        
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        

        // Crear sesión de correo electrónico
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Asunto del correo electrónico");
            message.setText("Contenido del correo electrónico");

            // Enviar correo electrónico
            
            Transport.send(message, username, password);

            System.out.println("El correo electrónico ha sido enviado exitosamente.");
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }
}

