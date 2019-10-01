package com.youngprime.revenue.users.mail;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
//
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.youngprime.revenue.users.config.MailConfigProperties;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@ApplicationScoped
public class EmailService {
	
	@Inject
	private MailConfigProperties mailConfig;
	
    public class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(mailConfig.getSenderEmailId(), 
            		mailConfig.getSenderPassword());
        }
    }
//    
    public boolean sendSimpleMessage(Mail mail, String templateName) throws MessagingException, IOException, TemplateException {
    	try {
    		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
        	MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            emailSender.setHost(mailConfig.getMailHost());
            emailSender.setPort(mailConfig.getMailHostPort());
             
            emailSender.setUsername(mailConfig.getSenderEmailId());
            emailSender.setPassword(mailConfig.getSenderPassword());
            Properties props = emailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            FreemarkerConfig freemarker = new FreemarkerConfig();
            Template t = freemarker.getConfiguration().getTemplate(templateName);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
            
            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mailConfig.getMailFrom(), 
            		mailConfig.getMailPersonel());

            emailSender.send(message);
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }

}
