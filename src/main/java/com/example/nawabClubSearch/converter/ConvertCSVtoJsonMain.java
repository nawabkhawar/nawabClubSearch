package com.example.nawabClubSearch.converter;

import com.example.nawabClubSearch.controller.NawabClubSearchController;
import com.example.nawabClubSearch.dto.Club;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Configuration
public class ConvertCSVtoJsonMain {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ConvertCSVtoJsonMain.class);

    //private static final String CSVURL_ORIGINAL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/getclubs-D92_183.82.181.43.csv";
    //private static final String CSVURL = "https://www.marshalls.org/tmtools/export.cgi?FILE=csv/directory-D92_152.58.210.35.csv"

    /*public static void main(String[] args) throws Exception {
        ConvertCSVtoJsonMain convertCSVtoJson = new ConvertCSVtoJsonMain();

        File file = new File("/Users/nawab-mac/Documents/mac backup/workspace/nawabClubSearch1/src/main/resources/folder/Test.csv");

        FileUtils.copyURLToFile(new URL(CSVURL), file);

        System.out.println(file);

            *//*ConvertCSVtoJson convertCSVtoJson = new ConvertCSVtoJson();
            File input = new File(convertCSVtoJson.getClass().getClassLoader().getResource("Test.csv").getFile());*//*

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();

        CsvMapper csvMapper = new CsvMapper();

        // Read data from CSV file
        List<List<Object>> readAll = asList(csvMapper.readerFor(Map.class).with(csvSchema).readValues(file).readAll());

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Write JSON formated data to output.json file
        Object finalRow = new Object();

        for (Object row : readAll) {
            for (int i =0; i<((ArrayList) row).size();i++) {
                Map<String, String> map = (Map<String, String>) ((ArrayList) row).get(0);

                String fileName = map.get("fileName");

                finalRow = row;

            }
        }
        File output = new File("/Users/nawab-mac/Documents/workspace/nawabClubSearch/src/main/resources/folder/Output.txt");
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, finalRow);
    }*/



    public List<Club> convertCSVToJson(String csvURL) {
        ConvertCSVtoJsonMain convertCSVtoJson = new ConvertCSVtoJsonMain();
        LOGGER.error("came to convert CSV");
        try {
            //File file = new File("Test.csv");
            //LOGGER.error("created CSV");
            //FileUtils.copyURLToFile(new URL(csvURL), file);


        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        // Read data from CSV file
        List<Club> readAll = (List<Club>)(Object)csvMapper.readerFor(Club.class).with(csvSchema).readValues(new URL(csvURL)).readAll();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return readAll;
        } catch (IOException e) {
            LOGGER.error("exception while fetching csv from url" + e);
        }
        catch (Exception e) {
            LOGGER.error("exception while creating Test.csv" + e);
        }
        LOGGER.error("returning null");
        return null;
    }

        private File getFileFromResources(String fileName) {

            ClassLoader classLoader = getClass().getClassLoader();

            URL resource = classLoader.getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("file is not found!");
            } else {
                return new File(resource.getFile());
            }

        }

    }

