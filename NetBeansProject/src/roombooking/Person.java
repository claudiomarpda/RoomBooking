package roombooking;

import java.util.ArrayList;
import java.util.Date;

public abstract class Person {
    protected String cpf;
    protected String name;
    protected char gender;
    protected Date birth;
    protected ArrayList<String> phoneNumberList;

    public Person(String cpf, String name, char gender, Date birth, ArrayList<String> phoneNumberList) {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phoneNumberList = phoneNumberList;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public ArrayList<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(ArrayList<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }
    
    
}
