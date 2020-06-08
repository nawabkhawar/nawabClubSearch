package com.example.nawabClubSearch.controller;


import com.example.nawabClubSearch.converter.ConvertCSVtoJsonMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;
import java.util.logging.Logger;

@EnableSwagger2
@RestController
@RequestMapping("/nawabClubSearch")
@ComponentScan(basePackages = {
        "com.example.nawabClubSearch.converter"
})
public class NawabClubSearchController {

    private static final Logger LOGGER =
            Logger.getLogger(NawabClubSearchController.class.getName());

    @Autowired
    ConvertCSVtoJsonMain convertCSVToJson;

    @GetMapping(path="/getAllClubs",produces = "application/json")
    public Object getAllClubs() throws Exception {
        LOGGER.info("came to getAllClubs");
        String csvURL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_183.82.181.43.csv";
        return convertCSVToJson.convertCSVToJson(csvURL);
    }

    @GetMapping(path="/refreshClubs",produces = "application/json")
    public Object refreshClubs() throws Exception {
        LOGGER.info("came to getAllClubs");
        String csvURL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_183.82.181.43.csv";
        return convertCSVToJson.convertCSVToJson(csvURL);
    }

    /*public Optional getClub(){


    }*/

}
