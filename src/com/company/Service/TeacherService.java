package Students.Service;

import Students.Repository.TeacherRepository;
import Students.model.Address;
import Students.model.Student;
import Students.model.Teacher;
import Students.util.Logger;

import java.util.ArrayList;

public class TeacherService {
    private TeacherRepository teacherRepository;

    public	TeacherService (){
//        Logger.writeLog("constructor TeacherService.");
        this.teacherRepository = new TeacherRepository();
    }
    public ArrayList<Teacher> getTeachers(){
//        Logger.writeLog("TeacherService.getTeachers");
        return teacherRepository.getTeachers();
    }
    void changeSalary(double salary, Teacher teacher) {
        teacher.setSalary(salary);
    }
    void changeAddress(Address address, Teacher teacher){
        teacher.setAddress(address);
    }
}