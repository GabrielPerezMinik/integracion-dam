package IesPerezMinik.Gestor.de.Correos.Api;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SmtpPrueba {

	


	    public static void main(String[] args) {
	        //final String username = "gabrielc2profe@gmail.com";
	        
	        final String username = "pruebas1232023@outlook.es";
	        final String password = "wp:J2ewJu-X7H2F"; 
	        //final String password = "Palkia8400*"; 
	        
	        
	        // Configurar propiedades del servidor SMTP
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.office365.com");
	        props.put("mail.smtp.port", "587");

	        
	        try (OutputStream outputStream = new FileOutputStream("email.properties")) {
	            // Guardar las propiedades en el archivo
	        	props.store(outputStream, "Configuración de la aplicación");
	            System.out.println("Archivo de propiedades creado exitosamente.");
	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo de propiedades: " + e.getMessage());
	        }
	        
	        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
	            // Cargar las propiedades desde el archivo
	        	props.load(fileInputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        
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
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pruebas1232023@outlook.es"));
	            message.setSubject("Asunto del correo electrónico");
	            message.setText("Contenido del correo electrónico");

	            // Enviar correo electrónico
	           // Transport.send(message);
	            
	            Transport t= session.getTransport();
	            t.connect(username, password);
	            t.sendMessage(message,message.getAllRecipients());

	            System.out.println("El correo electrónico ha sido enviado exitosamente.");
	        } catch (MessagingException e) {
	            System.out.println("Error al enviar el correo electrónico: " + e.getMessage());
	        }
	    }

	
}
