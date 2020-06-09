package com.example.nawabClubSearch.controller;


import com.example.nawabClubSearch.dto.Club;
import com.example.nawabClubSearch.Dao.ClubRepository;
import com.example.nawabClubSearch.converter.ConvertCSVtoJsonMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

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

    @GetMapping(path="/getAllEmployee",produces = "application/json")
    public List<Club> getAllEmployee(){

        List<Club> emp = clubRepository.findAll();

        //logger.info("Employee id 2 -> {}", emp.get());
        return emp;

    }

    @Transactional
    @PostMapping(path="/addEmployee",produces = "application/json",consumes = "application/json")
    public String addEmployee(@RequestBody Club club){

        //Optional emp = employeeRepository.findById(1L);
        clubRepository.saveAndFlush(club);
        //System.out.println(employee.getFirstName());
        //employeeRepository.flush();


        //logger.info("Employee id 2 -> {}", emp.get());
        return "done";

    }

    @Transactional
    @PostMapping(path="/addClubs",produces = "application/json",consumes = "application/json")
    public String addClub(@RequestBody Club club){

        //Optional emp = employeeRepository.findById(1L);
        clubRepository.saveAndFlush(club);
        //System.out.println(employee.getFirstName());
        //employeeRepository.flush();


        //logger.info("Employee id 2 -> {}", emp.get());
        return "done";

    }

    /*public Optional getClub(){


    }*/

}
