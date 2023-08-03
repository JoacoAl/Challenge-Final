package com.example.challengefinal.growshop.servicios;

import com.example.challengefinal.growshop.models.Correo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.util.Properties;
@Service
public class EmailSend {

    @Autowired
    private JavaMailSender javaMailSender;
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


    public ResponseEntity<Object> sendFactura(Correo mensajeCorreo, byte[] pdfData) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        String username = "growshopgozo@gmail.com";
        String password = "xfiuncmddpjgregt";
        String remitente = mensajeCorreo.getRemitente();
        String destinatario = mensajeCorreo.getDestinatario();
        String asunto= mensajeCorreo.getAsunto();
        String comentario = mensajeCorreo.getComentario();
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(username));
            helper.setTo(new InternetAddress(destinatario));
            helper.setSubject(asunto);

            helper.setText(comentario);


            MimeMessage messageGozo = javaMailSender.createMimeMessage();
            MimeMessageHelper helperGozo = new MimeMessageHelper(messageGozo, true);
            helperGozo.setFrom(new InternetAddress(username));
            helperGozo.setTo(new InternetAddress(remitente));
            helperGozo.setSubject(asunto);

            String mensajeParaGozo = "Aquí el comprobante de la factura de compra";

            helperGozo.setText(mensajeParaGozo);

            // Agregar el archivo PDF adjunto
            helper.addAttachment("factura.pdf", new ByteArrayResource(pdfData));
            helperGozo.addAttachment("factura.pdf", new ByteArrayResource(pdfData));
            javaMailSender.send(messageGozo);
            javaMailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo.", e);
        }
        return new ResponseEntity<>("Email enviado", HttpStatus.OK);
    }

}
