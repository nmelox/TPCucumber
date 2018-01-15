package utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
	
	public void sendMail() {
		System.out.println("Entre al MailSender.");
		Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.outlook.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "587");
        props.setProperty("mail.user", "melonahuel@hotmail.com");
        props.setProperty("mail.password", "Spiderman2013");
        props.setProperty("mail.smtp.auth", "true");
        System.out.println("Configure las properties.");
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
        System.out.println("Inicie la sesion.");
        MimeMessage message = new MimeMessage(session);
        ZipFiler zipFile = new ZipFiler();
        try {
        	zipFile.zipFile();
			message.setFrom(new InternetAddress("melonahuel@hotmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("melonahuel@hotmail.com")); //CC or BCC
			message.setSubject("Reporte del test");
			//message.setText("Envio del reporte del test");
			BodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Envio del reporte del test");
			String filename = "C:\\\\CursoAutomation\\\\TPCucumber\\\\TPFinal\\DescriptionBook.zip";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport t = session.getTransport("smtp");
			t.connect("melonahuel@hotmail.com","Spiderman2013");
			//t.connect("cristiantest1234@gmail.com","Password");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} 
        
	}
	
}
