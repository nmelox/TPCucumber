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
		Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.outlook.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.socketFactory.port", "587");
        props.setProperty("mail.smtp.user", "melonahuel@hotmail.com");
        props.setProperty("mail.user", "melonahuel@hotmail.com");
        props.setProperty("mail.user", "Spiderman2013");
        props.setProperty("mail.smtps.auth", "true");
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        ZipFiler zipFile = new ZipFiler();
        try {
        	zipFile.zipFile();
			message.setFrom(new InternetAddress("melonahuel@hotmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("nmelo@belatrixsf.com")); //CC or BCC
			message.setSubject("Reporte del test");
			BodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			String filename = "C:\\CursoAutomation\\TPCucumber\\TPFinal\\target\\site\\cucumber-pretty\\DescriptionBook.zip";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			//message.setText("Envio del reporte del test");
			Transport t = session.getTransport("smtp");
			t.connect("melonahuel@hotmail.com","Spiderman2013");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
