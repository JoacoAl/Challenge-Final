package com.example.challengefinal.growshop.models;

import com.example.challengefinal.growshop.models.Correo;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;
@Service
public class EmailSend {
    public void sendEmail(Correo mensajeCorreo) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        String username = "growshopgozo@gmail.com";
        String password = "xfiuncmddpjgregt";
        String remitente = mensajeCorreo.getRemitente();
        String asunto= mensajeCorreo.getAsunto();
        String comentario = mensajeCorreo.getComentario();
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress( remitente));

            String mensajeAdicional = "Hola, su correo fue enviado con éxito a Gozo, aquí le dejamos lo que envió:" + comentario;


            message.setSubject(asunto);
            message.setText(mensajeAdicional);
            Transport t = session.getTransport("smtp");
            t.connect(username,password);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            JOptionPane.showMessageDialog(null,"El correo electrónico fue enviado exitosamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo.", e);
        }
    }
}
