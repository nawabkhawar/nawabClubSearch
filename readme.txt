DROP TABLE IF EXISTS CLUB;

CREATE TABLE CLUB (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    District VARCHAR(4) DEFAULT NULL,
    Division VARCHAR(2) DEFAULT NULL,
    Area VARCHAR(2) DEFAULT NULL,
    Club VARCHAR(10) DEFAULT NULL,
    Clubname VARCHAR(50) DEFAULT NULL,
    Clubest VARCHAR(11) DEFAULT NULL,
    Clubstatus VARCHAR(10) DEFAULT NULL,
    Clubaddr1 VARCHAR(150) DEFAULT NULL,
    Clubaddr2 VARCHAR(100) DEFAULT NULL,
    Clubcity VARCHAR(20) DEFAULT NULL,
    Clubstate VARCHAR(15) DEFAULT NULL,
    Clubzip VARCHAR(10) DEFAULT NULL,
    Clubcountry VARCHAR(15) DEFAULT NULL,
    Clubphone VARCHAR(40) DEFAULT NULL,
    Clubday_o VARCHAR(40) DEFAULT NULL,
    Clubtime_o VARCHAR(40) DEFAULT NULL,
    Clubday VARCHAR(20) DEFAULT NULL,
    Clubtime VARCHAR(10) DEFAULT NULL,
    Clublen VARCHAR(4) DEFAULT NULL,
    Clubfreq VARCHAR(4) DEFAULT NULL,
    Clubopen VARCHAR(4) DEFAULT NULL,
    Cluburl1 VARCHAR(250) DEFAULT NULL,
    Cluburl2 VARCHAR(250) DEFAULT NULL,
    Clubwebstat1 VARCHAR(200) DEFAULT NULL,
    Clubwebstat2 VARCHAR(200) DEFAULT NULL,
    Clubemail VARCHAR(100) DEFAULT NULL,
    Clubadvanced VARCHAR(10) DEFAULT NULL
);


DROP TABLE IF EXISTS CLUB;

CREATE TABLE CLUB (
    id INT AUTO_INCREMENT ,
    District VARCHAR(4) DEFAULT NULL,
    Division VARCHAR(2) DEFAULT NULL,
    Area VARCHAR(2) DEFAULT NULL,
    Club VARCHAR(10) PRIMARY KEY,
    Clubname VARCHAR(100) DEFAULT NULL,
    Clubest VARCHAR(11) DEFAULT NULL,
    Clubstatus VARCHAR(10) DEFAULT NULL,
    Clubaddr1 VARCHAR(240) DEFAULT NULL,
    Clubaddr2 VARCHAR(200) DEFAULT NULL,
    Clubcity VARCHAR(35) DEFAULT NULL,
    Clubstate VARCHAR(20) DEFAULT NULL,
    Clubzip VARCHAR(18) DEFAULT NULL,
    Clubcountry VARCHAR(20) DEFAULT NULL,
    Clubphone VARCHAR(40) DEFAULT NULL,
    Clubday_o VARCHAR(40) DEFAULT NULL,
    Clubtime_o VARCHAR(40) DEFAULT NULL,
    Clubday VARCHAR(20) DEFAULT NULL,
    Clubtime VARCHAR(10) DEFAULT NULL,
    Clublen VARCHAR(4) DEFAULT NULL,
    Clubfreq VARCHAR(4) DEFAULT NULL,
    Clubopen VARCHAR(4) DEFAULT NULL,
    Cluburl1 VARCHAR(200) DEFAULT NULL,
    Cluburl2 VARCHAR(200) DEFAULT NULL,
    Clubwebstat1 VARCHAR(200) DEFAULT NULL,
    Clubwebstat2 VARCHAR(200) DEFAULT NULL,
    Clubemail VARCHAR(100) DEFAULT NULL,
    Clubadvanced VARCHAR(10) DEFAULT NULL,
    INDEX(id)
);

UPDATE Table CLUB
ADD COLUMN created

very important things while configuring gmail
1. enable less secure apps in settings
2. unlock account to be connected -  https://accounts.google.com/DisplayUnlockCaptcha

convert csv to json
https://www.convertcsv.com/csv-to-json.html


-----new logic judging -----
DROP TABLE IF EXISTS judge;
DROP TABLE IF EXISTS chiefjudge;
DROP TABLE IF EXISTS participant;
DROP TABLE IF EXISTS event;

CREATE TABLE event (
    eventid INT AUTO_INCREMENT,
    eventname varchar(15) not null,
    participant1 varchar(25) NOT NULL,
    participant2 varchar(25) NOT NULL,
    participant3 varchar(25) DEFAULT NULL,
    participant4 varchar(25) DEFAULT NULL,
    participant5 varchar(25) DEFAULT NULL,
    participant6 varchar(25) DEFAULT NULL,
    participant7 varchar(25) DEFAULT NULL,
    participant8 varchar(25) DEFAULT NULL,
    participant9 varchar(25) DEFAULT NULL,
    participant10 varchar(25) DEFAULT NULL,
    PRIMARY KEY (eventid)
);

CREATE TABLE chiefjudge (
    chiefjudgeid INT AUTO_INCREMENT ,
    name VARCHAR(20) NOT NULL,
    emailid VARCHAR(60) NOT NULL,
    cjsecret varchar(20) NOT NULL,
    eventid int(12) NOT NULL,
    PRIMARY KEY (chiefjudgeid),
    FOREIGN KEY (eventid) REFERENCES event(eventid)
);

CREATE TABLE judge (
    judgeid INT AUTO_INCREMENT ,
    name VARCHAR(20) NOT NULL,
    emailid VARCHAR(60) NOT NULL,
    jsecret varchar(20) NOT NULL,
    eventid int(12) NOT NULL,
    chiefjudgeid int(12) NOT NULL ,
    one varchar(20) DEFAULT NULL ,
    two varchar(20) DEFAULT NULL ,
    three varchar(20) DEFAULT NULL ,
    PRIMARY KEY (judgeid),
    FOREIGN KEY (eventid) REFERENCES event(eventid),
    FOREIGN KEY (chiefjudgeid) REFERENCES chiefjudge(chiefjudgeid)
);



insert into event (eventname,participant1,participant2) values('nawabevent','nawab','shibani');
select * from event;

insert into chiefjudge(name,emailid,cjsecret,eventid) values('nawabcj','nawab@nawab.com',1234,1);
select * from chiefjudge;


insert into judge(name,emailid,jsecret,eventid,chiefjudgeid) values('nawab1','nawab@nawab.com',20,1,1);
insert into judge(name,emailid,jsecret,eventid,chiefjudgeid) values('nawabj2','nawab@nawab.com',21,1,1);
insert into judge(name,emailid,jsecret,eventid,chiefjudgeid) values('nawabj3','nawab@nawab.com',22,1,1);
insert into judge(name,emailid,jsecret,eventid,chiefjudgeid) values('nawabj4','nawab@nawab.com',23,1,1);
insert into judge(name,emailid,jsecret,eventid,chiefjudgeid) values('nawabj5','nawab@nawab.com',24,1,1);
select * from judge;

 select * from judge j
 join chiefjudge cj on j.chiefjudgeid = cj.chiefjudgeid
 join event e on j.eventid = e.eventid
 where j.jsecret =21 and j.emailid='nawab@nawab.com';



mail file latest

package com.example.nawabClubSearch.processors;

import com.example.nawabClubSearch.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

@Component
public class EmailDelegate {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(EmailRequest emailRequest) {
        //Session session = Session.getInstance(properties, auth);

        try {
            Message msg = javaMailSender.createMimeMessage();
            msg.setRecipient(Message.RecipientType.TO,new InternetAddress(emailRequest.toAddress));

        //msg.setTo(emailRequest.toAddress);

        msg.setSubject(emailRequest.subject);
       // emailRequest.setText(emailRequest.getText() + getFooter());

        Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
            messageBodyPart.setContent(htmlText, "text/html");


            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID","123");


            imagePart.attachFile("src/main/resources/nawab1.png");
            imagePart.setDisposition(MimeBodyPart.ATTACHMENT);
            multipart.addBodyPart(imagePart);
            msg.setContent(multipart);
            javaMailSender.send((MimeMessage) msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //msg.setText(emailRequest.text);




    }

    /*private String getFooter() {
        StringBuffer footer = new StringBuffer();
            return footer.toString();
    }*/

    public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("bondkn@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }

}

1) We have 100 websites in network.
2) For sake of simplicity lets assume, each website Only publishes news articles.
3)Each page has only one news article. Each news article will have a title having the company's stock ticker code in the title.
