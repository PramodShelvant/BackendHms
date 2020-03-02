package com.hms.management;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSender {
  
  public static boolean sendMail(String from, String password, String message,String to ){
	 String host="smtp.gmail.com";
	 Properties props= System.getProperties();
	 props.put("mail.smtp.host", host);
	 props.put("mail.smtp.user", from);
	 props.put("mail.smtp.password", password);
	 props.put("mail.smtp.port", 587);
	 props.put("mail.smtp.starttls.enable", "true");
	 props.put("mail.smtp.auth", "true");
	 
	 Authenticator auth = new Authenticator() {
     public PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(from, password);
         }     
     };
	Session session=Session.getDefaultInstance(props, auth);
	//session.setDebug(debug);	
	MimeMessage msg = new MimeMessage(session);
	try    
	{
		msg.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress= new InternetAddress[to.length()];
		for(int i=0;i<to.length();i++){
			toAddress[i]= new InternetAddress(to);
		}
		for(int i=0;i<toAddress.length;i++){
			  msg.addRecipient(RecipientType.TO, toAddress[i]);
		}
		    msg.setSubject("mail using java");
		    msg.setText(message);
		    Transport transport= session.getTransport("smtp");
			transport.connect(from,password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		    return true;
	 }
		    catch(MessagingException me){
			me.printStackTrace();
		}
		    return false;
	}
	}