package Students.base;

import Students.model.Address;

public class People {
    private String last_name;
    private String first_name;
    private int age;
    private Address address;

    public People(String last_name, String first_name, int age, Address address) {
        this.last_name = last_name;
        this.first_name = first_name;
        setAge(age);
        this.address = address;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age){
        if (age > 0) {
            this.age = age;
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "фамилия='" + last_name + '\'' +
               ", имя='" + first_name + '\'' +
               ", возраст=" + age +
               ", " + address;
    }
}
