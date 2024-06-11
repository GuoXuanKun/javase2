package day240611;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MyEmailUtil {
    public static final Properties PROPERTIES;
    private static final String FROM;
    private static final String SECRET_TOKEN;

    static {
        // 读取配置文件，获取整个程序需要的全局配置信息
        PROPERTIES = loadFromConfiguration();
        FROM = PROPERTIES.getProperty("from", "admin@xxx.com");
        SECRET_TOKEN = PROPERTIES.getProperty("secret_token");
    }

    public static void send(String email, String content)  throws Exception {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.qq.com");
        prop.put("mail.smtp.port", "587");

        // https://wx.mail.qq.com/list/readtemplate?name=app_intro.html#/agreement/authorizationCode
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, SECRET_TOKEN);
            }
        });

        Message message = new MimeMessage(session);
        // who you are
        message.setFrom(new InternetAddress(FROM));
        // send to ...
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

        message.setSubject("来自 Java 的提醒");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

        System.out.println("邮件发送成功");
    }

    public static void main(String[] args) throws Exception {
        MyEmailUtil.send(PROPERTIES.getProperty("to"), "这是一段测试消息");
    }

    private static Properties loadFromConfiguration() {
        Properties properties = new Properties();
        String fileName = "src/main/java/day240611/config.properties";
        try {
            properties.load(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("配置文件[" + fileName + "]不存在。");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("未知的错误！");
            throw new RuntimeException(e);
        }
        //System.out.println(properties);
        System.out.println("配置文件读取成功");
        return properties;
    }
}