package com.example.nawabClubSearch.controller;


import com.example.nawabClubSearch.dto.Club;
import com.example.nawabClubSearch.Dao.ClubRepository;
import com.example.nawabClubSearch.converter.ConvertCSVtoJsonMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;
import java.util.List;


@EnableSwagger2
@RestController
@RequestMapping("/nawabClubSearch")
@ComponentScan(basePackages = {
        "com.example.nawabClubSearch.converter"
})
public class NawabClubSearchController {

    @Autowired
    ClubRepository clubRepository;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(NawabClubSearchController.class);

    @Autowired
    ConvertCSVtoJsonMain convertCSVToJson;

    @GetMapping(path="/getAllClubs",produces = "application/json")
    public Object getAllClubs() throws Exception {
        LOGGER.info("came to getAllClubs");
        String csvURL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_183.82.181.43.csv";
        return convertCSVToJson.convertCSVToJson(csvURL);
    }

    @PostMapping (path="/refreshClubs",produces = "application/json")
    public Object refreshClubs() throws Exception {
       // List<Club> clubs = new ArrayList<Club>();
        LOGGER.error("came to refresh clubs");
        String csvURL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_183.82.181.43.csv";
          List<Club> clubs = convertCSVToJson.convertCSVToJson(csvURL);
        LOGGER.error("error: got clubs");
              if(null!=clubs && !clubs.isEmpty()) {
                  saveClubs(clubs);
                  LOGGER.error("clubs saved");
              }else{
                  LOGGER.error("gotnull clubs");
                  return "got null clubs";
              }
         return "done";
    }

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

}
