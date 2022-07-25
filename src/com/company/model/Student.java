package Students.model;

import Students.base.People;

import java.util.ArrayList;

public class Student extends People {

    public Student(String last_name, String first_name, int age, Address address) {
        super(last_name,first_name,age,address);
    }

    @Override
    public String toString() {
        return "Студент{"+super.toString()+"}";
    }
    public static String ListToString(ArrayList<Student> students, int i) {
        if (students.size()-1 < i){
            return "";
        } else {
            String str = ((i > 0) ? (",") : (""))+ students.get(i).getLast_name() + " " + students.get(i).getFirst_name();
            return str + ListToString(students,++i);
        }
    }


//
//    void printInfo(){
//        System.out.printf("Student Name: %s, age: %d, living address: %s\n", this.last_name+" "+this.first_name, age, address.getAddress());
//    }
}
