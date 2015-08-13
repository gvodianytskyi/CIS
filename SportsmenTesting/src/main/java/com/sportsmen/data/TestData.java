package com.sportsmen.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.*;

public class TestData {
    private JSONParser parser;

    private String lastName;
    private String firstName;
    private String birth;
    private String middleName;
    private String region1;
    private String region2;
    private String fst1;
    private String fst2;
    private String trainer1;
    private String trainer2;
    private String style;
    private String age;
    private String year;
    private String status;

    public TestData(String path) {
        parser = new JSONParser();
        parseInputData(path);
    }

    public void parseInputData(String path) {
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            lastName = (String) jsonObject.get("lastName");
            firstName = (String) jsonObject.get("firstName");
            birth = (String) jsonObject.get("birth");
            middleName = (String) jsonObject.get("middleName");
            region1 = (String) jsonObject.get("region1");
            region2 = (String) jsonObject.get("region2");
            fst1 = (String) jsonObject.get("fst1");
            fst2 = (String) jsonObject.get("fst2");
            trainer1 = (String) jsonObject.get("trainer1");
            trainer2 = (String) jsonObject.get("trainer2");
            style = (String) jsonObject.get("style");
            age = (String) jsonObject.get("age");
            year = (String) jsonObject.get("year");
            status = (String) jsonObject.get("status");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    public String getFst1() {
        return fst1;
    }

    public void setFst1(String fst1) {
        this.fst1 = fst1;
    }

    public String getFst2() {
        return fst2;
    }

    public void setFst2(String fst2) {
        this.fst2 = fst2;
    }

    public String getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(String trainer1) {
        this.trainer1 = trainer1;
    }

    public String getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(String trainer2) {
        this.trainer2 = trainer2;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
