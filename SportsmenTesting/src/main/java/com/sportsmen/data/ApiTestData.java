package com.sportsmen.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApiTestData {
    private JSONParser parser;
    private String JSONString;
    private String path;

    public ApiTestData(String path) {
        parser = new JSONParser();
        this.path = path;
    }

    public String getJSONString() {
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONString = jsonObject.toJSONString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSONString;
    }
}
