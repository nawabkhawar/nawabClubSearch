package com.example.nawabClubSearch.controller;


import com.example.nawabClubSearch.Dao.*;
import com.example.nawabClubSearch.dto.*;
import com.example.nawabClubSearch.converter.ConvertCSVtoJsonMain;
import com.example.nawabClubSearch.processors.EmailDelegate;
import com.example.nawabClubSearch.processors.HTTP;
import com.example.nawabClubSearch.utils.Utils;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.*;


@EnableSwagger2
@RestController
@RequestMapping("/nawabClubSearch")
@ComponentScan(basePackages = {
        "com.example.nawabClubSearch.converter","com.example.nawabClubSearch.processors"
})
public class NawabClubSearchController {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    CertRepository certRepository;

    @Autowired
    JudgeRepository judgeRepository;

    @Autowired
    ChiefJudgeRepository chiefJudgeRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    HighlightRepository highlightRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    HighlightUserRepository highlightUserRepository;

    @Autowired
    EmailDelegate emailDelegate;

    @Autowired
    HTTP http;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(NawabClubSearchController.class);

    @Autowired
    ConvertCSVtoJsonMain convertCSVToJson;

    @GetMapping(path="/getAllClubs",produces = "application/json")
    public ResponseEntity<Object> getAllClubs(HttpServletRequest request) throws Exception {
        LOGGER.info("came to getAllClubs");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        String referer = request.getHeader("referer");
        LOGGER.error("referer:" + referer);

        if(null!=referer && referer.contains("http://nawabkhawar.in")) {
            LOGGER.error("clubRepository get");
            List<Club> clubs = clubRepository.findAll();
            return ResponseEntity.ok().headers(headers).body(clubs);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(path="/getAllClubsSome",produces = "application/json")
    public ResponseEntity<Object> getAllClubs2(HttpServletRequest request) throws Exception {
        LOGGER.info("came to getAllClubs");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        List<Club> clubs = clubRepository.findAll();
            return ResponseEntity.ok().headers(headers).body(clubs);
    }

    @GetMapping(path="/getAllClubsByDistrict/{district}",produces = "application/json")
    public ResponseEntity<Object> getAllClubsDis(HttpServletRequest request,@PathVariable("district") String districtId) throws Exception {
        LOGGER.error("came to get clubs by district");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        String referer = request.getHeader("referer");
        LOGGER.error("referer:" + referer);

        if(null!=referer && referer.contains("http://nawabkhawar.in")) {
            LOGGER.error("clubRepository get");
            List<Club> clubs = clubRepository.findByDistrict(districtId);
            return ResponseEntity.ok().headers(headers).body(clubs);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(path="/updateSomeClubs",produces = "application/json")
    public ResponseEntity<Object> updateSomeClubs(HttpServletRequest request) throws Exception {
        LOGGER.info("came to getAllClubs");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        String referer = request.getHeader("referer");
        LOGGER.error("referer:" + referer);
        List<Club> clubs = clubRepository.findAll();
        //if(null!=referer && referer.contains("http://nawabkhawar.in")) {

        return ResponseEntity.ok().headers(headers).body(clubs);
        /*}
        else{
            return ResponseEntity.badRequest().body(null);
        }*/
    }

    @PostMapping (path="/refreshClubs",produces = "application/json")
    public Object refreshClubs() throws Exception {
       // List<Club> clubs = new ArrayList<Club>();
        LOGGER.error("came to refresh clubs");
        //export.cgi?FILE=csv/getclubs-D41_103.211.58.74.csv
        //getclubs-D92_103.211.58.74.csv
        //getclubs-D92_103.211.58.74.csv
        String csvURL[] = Utils.csvUrl.split(";");
        for(int i=0;i<csvURL.length;i++) {
            List<Club> clubs = convertCSVToJson.convertCSVToJson(csvURL[i]);
            LOGGER.error("error: got clubs");
            if (null != clubs && !clubs.isEmpty()) {
                saveClubs(clubs);
                LOGGER.error("clubs saved");
            } else {
                LOGGER.error("gotnull clubs");
                return "got null clubs";
            }
        }
         return "done";
    }



    @PostMapping (path="/processResults",produces = "application/json")
    public Object processResults(@RequestBody String str1) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        LOGGER.error("String that came:" + str1);
        //3,nawab@nawab.com,1|:1,2,shibani:2,1,nawab        //
        //judgeid, judgeemail, chiefjudgeid | winnerposition,participantposition,name : winnerposition,participantposition,name
        if(null!=str1) {
            try {
                String[] strings = str1.split(";");
                String[] judgeString = strings[0].split(",");
                String[] individualWinners = strings[1].split(":");

                String judgeId = judgeString[0];
                List<Judge> judges = judgeRepository.findByjudgeid(Long.parseLong(judgeId));

                if (judges != null && !judges.isEmpty()) {
                    Judge judge = judges.get(0);


                    //String[]  = winnerString.split(":");
                    Map<String, String> winnerMap = new HashMap<String, String>();
                    for (String str : individualWinners) {
                        String[] individualWinnerPostions = str.split(",");
                        if (individualWinnerPostions.length > 1)
                            winnerMap.put(individualWinnerPostions[0], individualWinnerPostions[1]);
                    }
                    if (winnerMap.containsKey("1"))
                        judge.setOne(winnerMap.get("1"));
                    if (winnerMap.containsKey("2"))
                        judge.setTwo(winnerMap.get("2"));
                    if (winnerMap.containsKey("3"))
                        judge.setThree(winnerMap.get("3"));
                    if (winnerMap.containsKey("4"))
                        judge.setFour(winnerMap.get("4"));
                    if (winnerMap.containsKey("5"))
                        judge.setFive(winnerMap.get("5"));
                    if (winnerMap.containsKey("6"))
                        judge.setSix(winnerMap.get("6"));
                    if (winnerMap.containsKey("7"))
                        judge.setSeven(winnerMap.get("7"));
                    if (winnerMap.containsKey("8"))
                        judge.setEight(winnerMap.get("8"));
                    if (winnerMap.containsKey("9"))
                        judge.setNine(winnerMap.get("9"));
                    if (winnerMap.containsKey("10"))
                        judge.setTen(winnerMap.get("10"));

                    LOGGER.error("winners" + winnerMap);
                    judgeRepository.save(judge);

                    List<ChiefJudge> chiefjudgeList= chiefJudgeRepository.findBychiefjudgeid(judge.getChiefjudgeid());
                    //sendEmailToChiefJudge that a result was submitted
                    sendEmailForResultSubmission(judge,chiefjudgeList.get(0));
                }
            }catch(ArrayIndexOutOfBoundsException e){
                return ResponseEntity.ok().headers(headers).body("wrong inputs!!!");
            }
        }
        return ResponseEntity.ok().headers(headers).body("success!!!");
    }

    private void sendEmailForResultSubmission(Judge judge, ChiefJudge chiefJudge) {
        String msgForChiefJudge ="Just a confirmation\n" +
                "1.You can go back to http://nawabkhawar.in/chiefjudge.html?q=" + chiefJudge.getCjsecret() +
                " to get the results" +
                "\n2.Or press LoadMoreResults button on the page to load more results";


        String subjectForChiefJudge = "result submitted by -: " + judge.getName() + "-: "+ judge.getEmailid();
        EmailRequest emailRequestForJudge = new EmailRequest();
        emailRequestForJudge.setText(msgForChiefJudge);
        emailRequestForJudge.setSubject(subjectForChiefJudge);
        emailRequestForJudge.setToAddress(chiefJudge.getEmailid());
        sendEmail(emailRequestForJudge);
    }


    @PostMapping (path="/saveEvent",produces = "application/json")
    public Object saveEvent(@RequestBody String eventString) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        LOGGER.error("String that came:" + eventString);
         String[] strings;
        String participants[];
        String judges[];
        String chiefjudgeData[];

        //p1-p2-p3:j1,kkjk@jkjk.com-j2,kjkj@gjkk.com-t1,tt@gg.com:aaa,aa@aa.com,aaevent
        //participant //:kljkdljlk,ljkljk-kjkdjk,jkkj-jkjk,kjkjk-,-,-,-,-,-,-ddd,eee:
        if(null!=eventString) {
            try {
                strings = eventString.split(":");
                participants= strings[0].split("-");
                judges = strings[1].split("-");
                chiefjudgeData = strings[2].split(",");
                String chiefJudgeName = chiefjudgeData[0];
                String chiefJudgeEmail = chiefjudgeData[1];
                String eventName = chiefjudgeData[2];
                String eventType = strings[3];

                Event event = new Event();
                event.setEventname(eventName);
                if(participants[0]!="blank"){
                    event.setParticipant1(participants[0]);
                }
                if(participants[1]!="blank"){
                    event.setParticipant2(participants[1]);
                }if(participants[2]!="blank"){
                    event.setParticipant3(participants[2]);
                }if(participants[3]!="blank"){
                    event.setParticipant4(participants[3]);
                }
                if(participants[4]!="blank"){
                    event.setParticipant5(participants[4]);
                }
                if(participants[5]!="blank"){
                    event.setParticipant6(participants[5]);
                }
                if(participants[6]!="blank"){
                    event.setParticipant7(participants[6]);
                }

                if(participants[7]!="blank"){
                    event.setParticipant8(participants[7]);
                }
                if(participants[8]!="blank"){
                    event.setParticipant9(participants[8]);
                }
                if(participants[9]!="blank"){
                    event.setParticipant10(participants[9]);
                }
                event.setEventtype(eventType);

                Event savedEvent = eventRepository.save(event); //saveEvent


                ChiefJudge chiefJudge = new ChiefJudge();
                //toBeGenerated
                chiefJudge.setCjsecret("" + System.currentTimeMillis());
                chiefJudge.setEmailid(chiefJudgeEmail);
                chiefJudge.setName(chiefJudgeName);
                chiefJudge.setEventid(savedEvent.getEventid());

                ChiefJudge savedChiefJudge = chiefJudgeRepository.save(chiefJudge);
                List<Judge> judgesList = new ArrayList<Judge>();
                int count =1;
                for(String judgeStr : judges) {
                    Judge judge = new Judge();
                    if(count==judges.length){
                        judge.setTiebreaker("1");
                    }
                    judge.setName(judgeStr.split(",")[0]);
                    judge.setEmailid(judgeStr.split(",")[1]);
                    judge.setJsecret(""+System.currentTimeMillis());
                    judge.setEventid(savedEvent.getEventid());
                    judge.setChiefjudgeid(savedChiefJudge.getChiefjudgeid());
                    judgeRepository.save(judge);
                    judgesList.add(judge);
                    //sendJudgesEmail
                    sendJudgeEmail(judge,chiefJudgeName,chiefJudgeEmail,eventName, eventType);
                    //sendChiefJudgeEmail that email was sent to this judge
                    count++;
                }

                sendChiefJudgeEmail(chiefJudge, judgesList, eventName,eventType);
            }catch(ArrayIndexOutOfBoundsException e){
                return ResponseEntity.ok().headers(headers).body("wrong inputs!!!");
            }
        }
        return ResponseEntity.ok().headers(headers).body("success!!!");
    }

    private void sendChiefJudgeEmail(ChiefJudge chiefJudge, List<Judge> judgesList,String eventName, String eventType) {
        String eventTag = "";
        if(eventType.equals("H")){
            eventTag += "Humorous speech contest";
        }
        else if(eventType.equals("E")){
            eventTag += "Evaluation speech contest";
        }
        String msgForChieftJudge = "Hi " + chiefJudge.getName() + ", \n\nChief Judge's site is -" +
                "http://nawabkhawar.in/chiefjudge.html?q=" + chiefJudge.getCjsecret();
        int count =0;
        String listmsg = "";
        for(Judge judge : judgesList){
            count++;
            listmsg += "\n" + count + ". " + judge.getName() + "-"+ judge.getEmailid();
        }
        msgForChieftJudge += listmsg;
        String guidelines =
        "\n" +
                "\n" +
                "\nGuidelines-\n" +
                "1. All your judges must have got Emails with personal judging links \n" +
                "2. Ask them to go to their links \n" +
                "3. You need to go to your link \n" +
                 "(recieved now in email)\n" +
                "4. Once your judges 'press submit' you will get email notifications(without results)\n" +
                "5. Once you get enough emails, press Load More Results button on the page";


        msgForChieftJudge+= guidelines;


        String subjectForChiefJudge = "chief judging link for: "+ eventTag + " attached for event - " + eventName;
        EmailRequest emailRequestForJudge = new EmailRequest();
        emailRequestForJudge.setText(msgForChieftJudge);
        emailRequestForJudge.setSubject(subjectForChiefJudge);
        emailRequestForJudge.setToAddress(chiefJudge.getEmailid());
        sendEmail(emailRequestForJudge);
    }

    private void sendJudgeEmail(Judge judge, String chiefJudgeName, String chiefJudgeEmail, String eventName, String eventType) {
        String eventTag = "";
        String msgPart2 ="";
        if(eventType.equals("H")){
            eventTag += "Humorous speech contest";
            msgPart2    += chiefJudgeName + " selected you as a judge for event -" + eventName +
                    ", \n judge site is -" + "http://nawabkhawar.in/judge.html?q="+judge.getJsecret() ;
        }
        else if(eventType.equals("E")){
            eventTag += "Evaluation speech contest";
            msgPart2    += chiefJudgeName + " selected you as a judge for event -" + eventName +
                    ", \n judge site is -" + "http://nawabkhawar.in/judge.html?q="+judge.getJsecret() ;
        }
        else if(eventType.equals("EP")){
            eventTag += "Emparch Presentation Contest";
            msgPart2    += chiefJudgeName + " selected you as a judge for event -" + eventName +
                    ", \n judge site is -" + "http://nawabkhawar.in/judgeEmparch.html?q="+judge.getJsecret() ;
        }

        String msgToJudge = "Hi " + judge.getName() + ",\n\n ";



        /*String msgPart2    = chiefJudgeName + " selected you as a judge for event -" + eventName +
                ", \n judge site is -" + "http://nawabkhawar.in/judge.html?q="+judge.getJsecret() ;*/

        String tieBreakerMsg = "\n\n you are the tiebreaking judge & you will have to mark all the contestants" ;
        String pleaseNote = "\n \n Please Note- \n" +
        "1.Use the website in Landscape mode for best experience \n" +
        "2.Don't share your links with anyone, even Chief judge does not know what it is \n" +
                "(only your top3 scores are shared, that too, after you press submit)" +
        "3.If you are Judge for 2 contests, you will get 2 different emails, with 2 different links, make sure when to use which1 \n" +
        "4.Website will decrypt the link using AWS services and then by Automation realize which event you are here to judge\n" +
        "(basically same portal for all judging)" +
        "5.Only Your top3 Names will go to the chief judge, scores will be deleted and is not saved \n" +
        "6.If you want to see, for whom did you vote for, just go back to your link \n" +
        "You will see your top 3 selections, scores , as are deleted, will not be fetched" +
        "7.Chief Judge has no access to your portal, your link, your judging is your judging";

        String subjectForJudge ="";
        msgToJudge += msgPart2;
        if(null!=judge.getTiebreaker() && judge.getTiebreaker().equals("1")){
            msgToJudge+= tieBreakerMsg;
            subjectForJudge = "Tiebreaker - ";
        }
        msgToJudge += pleaseNote;


        subjectForJudge +="Judging link for - " + eventTag + " attached" + " for event -" + eventName;
        EmailRequest emailRequestForJudge = new EmailRequest();
        emailRequestForJudge.setText(msgToJudge);
        emailRequestForJudge.setSubject(subjectForJudge);
        emailRequestForJudge.setToAddress(judge.getEmailid());
        sendEmail(emailRequestForJudge);
    }


    @GetMapping(path="/getParticipants/{judgeId}",produces = "application/json")
    public ResponseEntity<Object> getParticipants(HttpServletRequest request,@PathVariable("judgeId") String judgeId) throws Exception {
        LOGGER.error("came to get clubs by district");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        //String referer = request.getHeader("referer");
        //LOGGER.error("referer:" + referer);

        //if(null!=referer && referer.contains("http://nawabkhawar.in")) {
            LOGGER.error("clubRepository get");
            List<Judge> judges = judgeRepository.findByjsecret(judgeId);
            JudgeEvent judgeEvent = new JudgeEvent();

            if(judges!=null && !judges.isEmpty()) {
                judgeEvent.setJudge(judges.get(0));
                List<Event> events = eventRepository.findByeventid(judges.get(0).getEventid());
                if(events!=null && !events.isEmpty()) {
                    judgeEvent.setEvent(events.get(0));
                }
            }
            return ResponseEntity.ok().headers(headers).body(judgeEvent);
        }

    @GetMapping(path="/getChiefJudgeData/{chiefJudgeId}",produces = "application/json")
    public ResponseEntity<Object> getChiefJudgeData(HttpServletRequest request,@PathVariable("chiefJudgeId") String chiefJudgeid) throws Exception {
        LOGGER.error("came to get clubs by district");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        //String referer = request.getHeader("referer");
        //LOGGER.error("referer:" + referer);

        //if(null!=referer && referer.contains("http://nawabkhawar.in")) {
        LOGGER.error("clubRepository get");
        List<ChiefJudge> chiefJudges = chiefJudgeRepository.findBycjsecret(chiefJudgeid);
        JudgeEvent judgeEvent = new JudgeEvent();

        if(chiefJudges!=null && !chiefJudges.isEmpty()) {
            judgeEvent.setChiefJudge(chiefJudges.get(0));

            List<Judge> judges = judgeRepository.findBychiefjudgeid(chiefJudges.get(0).getChiefjudgeid());
            if(judges!=null && !judges.isEmpty()) {
                judgeEvent.setJudges(judges);
            }
            List<Event> events = eventRepository.findByeventid(chiefJudges.get(0).getEventid());
            if(events!=null && !events.isEmpty()) {
                judgeEvent.setEvent(events.get(0));
            }
        }


        return ResponseEntity.ok().headers(headers).body(judgeEvent);
    }
        //else{
          //  return ResponseEntity.badRequest().body(null);
        //}


        /*List<String> partipants = new ArrayList<>();
        partipants.add("Nawab");
        partipants.add("Rishabh");
        partipants.add("Sagnik");
        partipants.add("Shibani");
        partipants.add("Manas");
        partipants.add("Kirti");
        partipants.add("Annesha");
        partipants.add("Pawas");
        partipants.add("Vanitha");
        partipants.add("Sunil");
        if((6 == Integer.parseInt(judgeId))){
            return ResponseEntity.ok().headers(headers).body(null);
        }else{
            return ResponseEntity.ok().headers(headers).body(partipants);
        }*/

  //  }

    @Transactional
    @PostMapping(path="/addClub",produces = "application/json",consumes = "application/json")
    public String addClub(@RequestBody Club club){
        LOGGER.info("came to add Club");
        LOGGER.error("error: came to add Club");
        LOGGER.debug("debug: came to add");
        LOGGER.trace("trace: came to add");

        saveClub(club);
        return "done";
    }

    @Transactional
    @PostMapping(path="/addClubs",produces = "application/json",consumes = "application/json")
    public String addClubs(@RequestBody List<Club> clubs){
        saveClubs(clubs);
        return "done";

    }

    @Transactional
    @PostMapping(path="/addClubsPartial",produces = "application/json",consumes = "application/json")
    public String addClubsPartial(@RequestBody List<Club> clubs){
        saveClubsPartial(clubs);
        return "done";

    }

    /*@Transactional
    @PostMapping(path="/addClubs",produces = "application/json",consumes = "application/text")
    public String addClubs(@RequestBody String str){
        saveClubs(clubs);
        return "done";

    }*/

    private void saveClubs(@RequestBody List<Club> clubs) {
        if(null!=clubs && !clubs.isEmpty()) {
            for (Club club : clubs) {
                saveClub(club);
            }
        }
        else{
            LOGGER.error("saveClubs : clubs was null" );
        }
    }

    private void saveClubsPartial(@RequestBody List<Club> clubs) {
        if(null!=clubs && !clubs.isEmpty()) {
            for (Club club : clubs) {
                saveClubPartial(club);
            }
        }
        else{
            LOGGER.error("saveClubs : clubs was null" );
        }
    }

    private void saveClub(Club club){
        List<Club> clubs= clubRepository.findByClub(club.getClub());
        if(null!=clubs && !clubs.isEmpty()){
            club.setId(clubs.get(0).getId());
        }
        else{
            LOGGER.info("club was null : clubs was null" );
        }
        clubRepository.save(club);
    }

    private void saveClubPartial(Club club){
        List<Club> clubs= clubRepository.findByClub(club.getClub());
        if(null!=clubs && !clubs.isEmpty()){
            Club searchedClub = clubs.get(0);
            club.setId(searchedClub.getId());

            if(StringUtils.isEmpty(club.getArea())){
                club.setArea(searchedClub.getArea());
            }
            if(StringUtils.isEmpty(club.getClubaddr1())){
                club.setClubaddr1(searchedClub.getClubaddr1());
            }
            if(StringUtils.isEmpty(club.getClubaddr2())){
                club.setClubaddr2(searchedClub.getClubaddr2());
            }
            if(StringUtils.isEmpty(club.getClubadvanced())){
                club.setClubadvanced(searchedClub.getClubadvanced());
            }
            if(StringUtils.isEmpty(club.getClubcity())){
                club.setClubcity(searchedClub.getClubcity());
            }
            if(StringUtils.isEmpty(club.getClubcountry())){
                club.setClubcountry(searchedClub.getClubcountry());
            }
            if(StringUtils.isEmpty(club.getClubday())){
                club.setClubday(searchedClub.getClubday());
            }
            if(StringUtils.isEmpty(club.getClubdayO())){
                club.setClubdayO(searchedClub.getClubdayO());
            }
            if(StringUtils.isEmpty(club.getClubemail())){
                club.setClubemail(searchedClub.getClubemail());
            }
            if(StringUtils.isEmpty(club.getClubest())){
                club.setClubest(searchedClub.getClubest());
            }
            if(StringUtils.isEmpty(club.getClubfreq())){
                club.setClubfreq(searchedClub.getClubfreq());
            }
            if(StringUtils.isEmpty(club.getClublen())){
                club.setClublen(searchedClub.getClublen());
            }
            if(StringUtils.isEmpty(club.getClubname())){
                club.setClubname(searchedClub.getClubname());
            }
            if(StringUtils.isEmpty(club.getClubopen())){
                club.setClubopen(searchedClub.getClubopen());
            }
            if(StringUtils.isEmpty(club.getClubphone())){
                club.setClubphone(searchedClub.getClubphone());
            }
            if(StringUtils.isEmpty(club.getClubstate())){
                club.setClubstate(searchedClub.getClubstate());
            }
            if(StringUtils.isEmpty(club.getClubstatus())){
                club.setClubstatus(searchedClub.getClubstatus());
            }

            if(StringUtils.isEmpty(club.getClubzip())){
                club.setClubzip(searchedClub.getClubzip());

            }
            if(StringUtils.isEmpty(club.getDistrict()))
            {
                club.setDistrict(searchedClub.getDistrict());
            }
            if(StringUtils.isEmpty(club.getDivision())){
                club.setDivision(searchedClub.getDivision());
            }
            if(StringUtils.isEmpty(club.getClubwebstat1())){
                club.setClubwebstat1(searchedClub.getClubwebstat1());
            }
            if(StringUtils.isEmpty(club.getClubwebstat2())){
                club.setClubwebstat2(searchedClub.getClubwebstat2());
            }
            if(StringUtils.isEmpty(club.getClubtime())){
                club.setClubtime(searchedClub.getClubtime());
            }
            if(StringUtils.isEmpty(club.getClubtimeO())){
                club.setClubtimeO(searchedClub.getClubtimeO());
            }
            if(StringUtils.isEmpty(club.getCluburl1())){
                club.setCluburl1(searchedClub.getCluburl1());
            }
            if(StringUtils.isEmpty(club.getCluburl2())){
                club.setCluburl2(searchedClub.getCluburl2());
            }

        }
        else{
            LOGGER.info("club was null : clubs was null" );
        }
        clubRepository.save(club);
    }

    @Transactional
    @PostMapping(path="/sendEmail",produces = "application/json",consumes = "application/json")
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        LOGGER.info("came to send email");
        LOGGER.error("came to send email");
        LOGGER.debug("came to send email");
        LOGGER.trace("came to send email");

        emailDelegate.sendEmail(emailRequest);
        Cert cert = new Utils().transformEmailReqToCert(emailRequest);
        this.saveCert(cert);
        LOGGER.error("Cert was inserted" );

        return "done";
    }

    @Transactional
    @PostMapping(path="/saveCert",produces = "application/json",consumes = "application/json")
    public void  saveCert(@RequestBody Cert cert){
        cert.setCreatedtime(Calendar.getInstance(TimeZone.getTimeZone("IST")).getTime());
        Date date = new Date();
        date.setHours((new Date().getHours()+ 5));
        date.setMinutes((date.getMinutes()+ 30));
        cert.setCreatedtime(date);
        LOGGER.error("Cert was inserted" );
        certRepository.save(cert);
        //return "certsaved";
    }


    @PostMapping(path="/saveHighlight",produces = "application/json",consumes = "application/json")
    public String  saveHighlight(@RequestBody Highlight highlight){
        highlight.setCreatedon(getTime());
        LOGGER.error("highlight came to insert" );
        highlightRepository.save(highlight);
        LOGGER.error("highlight saved" );
        return "highlight saved";
    }


    @PostMapping(path="/saveHighlightUser",produces = "application/json",consumes = "application/json")
    public String  saveHighlightUser(@RequestBody HighlightUser highlightUser){
        highlightUser.setCreatedon(getTime());
        LOGGER.error("highlightUserRepository came to insert" );
        highlightUserRepository.save(highlightUser);
        LOGGER.error("inserted" );
        return "usersaved";
    }

    @Transactional
    @PostMapping(path="/saveBook",produces = "application/json",consumes = "application/json")
    public String  saveBook(@RequestBody Book book){
        LOGGER.error("came to insert book" );
        bookRepository.save(book);
        LOGGER.error("book inserted" );
        return "booksaved";
    }

    public Date getTime(){
        Date date = new Date();
        date.setHours((new Date().getHours()+ 5));
        date.setMinutes((date.getMinutes()+ 30));
        return date;
    }

    @Transactional
    @PostMapping(path="/getAllHighlights",produces = "application/json",consumes = "application/json")
    public HighlightUsers getAllHighlights(@RequestBody HighlightUser user){
        LOGGER.error("came to get all highlights for user" );
        List<Highlight> highlights;
        Optional<HighlightUser> searchedUser = highlightUserRepository.findById(user.getId());
        HighlightUsers user1 = new HighlightUsers();
        if(null!=searchedUser){
            LOGGER.error("user found" );
            HighlightUser foundUser = searchedUser.get();
            user1.setUsername(foundUser.getName());
            user1.setUseremail(foundUser.getEmail());
            user1.setSendToEmail(foundUser.getContactemail());

            List<Book> books = bookRepository.findByUserid(searchedUser.get().getId());
            if(null!=books && !books.isEmpty() ){
                int index=0;
                for(Book book : books){
                    List<Highlight> highlights1 = highlightRepository.findByBookid(book.getId());
                    //books.get(index).setHighlight ist(highlights1);
                    if(index==0){
                        user1.setHighlightList(highlights1);
                    }else {
                        user1.getHighlightList().addAll(highlights1);
                    }
                    index++;
                }
                //searchedUser.get().setBookList(books);
            }
            return user1;
        }


        return null;
    }

    @Transactional
    @PostMapping(path="/getBook",produces = "application/json",consumes = "application/json")
    public Book getBook(@RequestBody Book book){
        LOGGER.error("came to get all books for user" );
        //List<Book> books;
        Optional<Book> foundBook = bookRepository.findById(book.getId());
        if(foundBook !=null  && null!=foundBook.get()){
        Book book1 = foundBook.get();
            return book1;
        }

    else return null;

    }

    @Transactional
    @PostMapping(path="/getHighlightUser",produces = "application/json",consumes = "application/json")
    public HighlightUser getHighlightUser(@RequestBody HighlightUser highlightUser){
        LOGGER.error("came to get all books for user" );
        //List<Book> books;
        Optional<HighlightUser> userFound = highlightUserRepository.findById(highlightUser.getId());
        if(userFound !=null  && null!=userFound.get()){
            HighlightUser user1= userFound.get();
            return user1;
        }

        else return null;

    }


    /*@Transactional
    @PostMapping(path="/getAwards",produces = "application/json",consumes = "application/json")
    public String getAwards(@RequestBody AwardRequest awardRequest){
        LOGGER.info("came to send email");
        LOGGER.error("came to send email");
        LOGGER.debug("came to send email");
        LOGGER.trace("came to send email");

        http.postAwards(awardRequest);
        return "done";
    }*/


}
