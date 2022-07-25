package Students.model;

import Students.base.People;

import java.util.ArrayList;

public class Teacher extends People {
    private double salary;
    private final double defSalary=2000;

    public Teacher(String last_name, String first_name, int age, Address address, double salary) {
        super(last_name, first_name, age, address);
        setSalary(salary);
    }

//    void changeAddress(Address address){
//        this.address = address;
//    }
//
//    void printInfo(){
//        System.out.printf("Преподаватель: %s, возраст: %d, адрес жительства: %s, ЗП=%.2f\n", this.last_name+" "+this.first_name, age, address.getAddress(),this.salary);
//    }
    //only as example
//    double calcSalary(double working_hours, double hourly_payment){
//        return (working_hours*hourly_payment);
//    }

//    void changeSalary(double salary){
//        if (salary > 0) {
//            this.salary = salary;
//        }
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = defSalary;
        }
    }

    @Override
    public String toString() {
        return "Учитель{" +
                super.toString()+
                ", З/П=" + salary +
                '}';
    }
    public String toStringShort() {
        return this.getLast_name() + " " + this.getFirst_name();
    }
    public static String ListToString(ArrayList<Teacher> teachers, int i) {
        if (teachers.size()-1 < i){
            return "";
        } else {
            String str = ((i > 0) ? (",") : (""))+ teachers.get(i).getLast_name() + " " + teachers.get(i).getFirst_name();
              return str + ListToString(teachers,++i);
        }
    }
}
