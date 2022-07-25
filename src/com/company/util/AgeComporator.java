package Students.util;

import Students.model.Student;

import java.util.Comparator;

public class AgeComporator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
