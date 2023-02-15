package com.example.nawabClubSearch.utils;

import com.example.nawabClubSearch.dto.Cert;
import com.example.nawabClubSearch.dto.EmailRequest;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public static final String csvUrl = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D121_152.58.210.35.csv;" +
            "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_152.58.210.35.csv";

    public Cert transformEmailReqToCert(EmailRequest emailRequest){
        Cert cert = new Cert();
        cert.setCreatedtime(Calendar.getInstance(TimeZone.getDefault()).getTime());
        cert.setArea(emailRequest.getArea());
        cert.setAward1(emailRequest.getAward1());
        cert.setAward2(emailRequest.getAward2());
        cert.setAward3(emailRequest.getAward3());
        cert.setAward4(emailRequest.getAward4());
        cert.setAward5(emailRequest.getAward5());
        cert.setAward6(emailRequest.getAward6());
        cert.setClubemail(emailRequest.getClubemail());
        cert.setClubname(emailRequest.getClubname());
        cert.setClubnumber(emailRequest.getClubnumber());
        cert.setDate(emailRequest.getDate());
        cert.setDistrict(emailRequest.getDistrict());
        cert.setDivision(emailRequest.getDivision());
        cert.setEmailtext(emailRequest.getText());
        cert.setMeetingnumber(emailRequest.getMeetingnumber());
        cert.setRec1(emailRequest.getRec1());
        cert.setRec2(emailRequest.getRec2());
        cert.setRec3(emailRequest.getRec3());
        cert.setRec4(emailRequest.getRec4());
        cert.setRec5(emailRequest.getRec5());
        cert.setRec6(emailRequest.getRec6());
        return cert;
    }

}
