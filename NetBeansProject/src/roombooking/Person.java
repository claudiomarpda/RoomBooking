package roombooking;

import java.sql.Date;

/**
 * 
 * Person class represents database tables PERSON, PHONE and EMAIL.
 */
public abstract class Person {

    protected String cpf;
    protected String name;
    protected String gender;
    protected Date birth;
    //protected ArrayList<String> phoneNumberList;
    protected String phoneNumber;
    protected String email;

    public Person() {

    }

    // Constructor with only one phone number
    public Person(String cpf, String name, String gender, Date birth, String phoneNumber, String email) {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "cpf=" + cpf + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }

}
