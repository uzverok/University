package Students.Service;

import Students.Repository.StudentRepository;
import Students.model.Address;
import Students.model.Student;
import Students.util.Logger;

import java.util.ArrayList;

public class StudentService {
    private StudentRepository studentRepository;
    public StudentService() {
//        Logger.writeLog("constructor StudentService.");
        this.studentRepository = new StudentRepository();
    }
    public ArrayList<Student> getStudents(){
//        Logger.writeLog("StudentService.getStudents");
        return studentRepository.getStudents();
    }
    void changeAddress(Address address, Student student){
        student.setAddress(address);
    }
}
