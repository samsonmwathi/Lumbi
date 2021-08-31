package com.example.lumbi;

public class ChildHelperClass {
    String fName, sName,gender,bDay ;
    int age;

    public ChildHelperClass(String fName, String sName, String gender, String bDay, int age) {
        this.fName = fName;
        this.sName = sName;
        this.gender = gender;
        this.bDay = bDay;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
