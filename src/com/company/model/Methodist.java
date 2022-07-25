package Students.model;

import Students.base.People;

import java.util.ArrayList;
import java.util.Arrays;

public class Methodist extends People {
    private String subject;
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public Methodist(String last_name, String first_name, int age, Address address, String subject, ArrayList<Teacher> teachers) {
        super(last_name, first_name, age, address);
        this.subject = subject;
        this.teachers = teachers;
    }
    public Methodist(String last_name, String first_name, int age, Address address, String subject) {
        super(last_name, first_name, age, address);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Методист{" +
                super.toString()+
                ", предмет='" + subject + '\'' +
                ", подшефные преподаватели=" + Teacher.ListToString(this.teachers,0) +
                '}';
    }
}

