package Students.Repository;

import Students.model.Student;
import Students.util.Logger;
import Students.util.ParseUtils;

import java.util.ArrayList;

public class StudentRepository {
    private ArrayList<Student> students;
    public StudentRepository(){
        Logger.writeLog("constructor StudentRepository");
        this.students = ParseUtils.LoadStudents("fileStudent.txt");
    }

    public ArrayList<Student> getStudents() {
        Logger.writeLog("StudentRepository.getStudents");
        return students;
    }
}
