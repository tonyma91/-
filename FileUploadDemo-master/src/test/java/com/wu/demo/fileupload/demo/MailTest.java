package com.wu.demo.fileupload.demo;
import com.wu.demo.fileupload.demo.util.mail.MailConst;
import com.wu.demo.fileupload.demo.util.mail.MailSenderUtil;

import java.util.ArrayList;

public class MailTest {
    public static void main(String[] args) {
//        ArrayList<String> emailArray = new ArrayList<>();
        //测试，收取邮件的邮箱，可以填写自己的发送邮件的邮箱
//        emailArray.add("majinming@xiaomi.com");
        //收件人姓名
        String senderName="马金明小朋友";
        //邮件内容在
        String mainMessage=  "６４６４";
        MailSenderUtil.sendMailTOSingleUser("majinming@xiaomi.com", MailConst.NOTIFICATION_MAIL_TITLE_ROLE,senderName+MailConst.NOTIFICATION_MAIL_CONTENT+mainMessage);
//        MailSenderUtil.sendMailToUserArray(emailArray, MailConst.NOTIFICATION_MAIL_TITLE,MailConst.NOTIFICATION_MAIL_CONTENT);
    }
}
