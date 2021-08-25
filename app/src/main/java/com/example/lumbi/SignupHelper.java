package com.example.lumbi;

public class SignupHelper {
    String fName, sName,email, bDay, pass, cPass;

    public SignupHelper() {

    }

    public SignupHelper(String fName, String sName, String email, String bDay, String pass, String cPass) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.bDay = bDay;
        this.pass = pass;
        this.cPass = cPass;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getcPass() {
        return cPass;
    }

    public void setcPass(String cPass) {
        this.cPass = cPass;
    }
}
