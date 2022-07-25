package Students.Repository;

import Students.model.Teacher;
import Students.util.Logger;
import Students.util.ParseUtils;

import java.util.ArrayList;

public class TeacherRepository {
    private ArrayList<Teacher> teachers;
    public TeacherRepository(){
        Logger.writeLog("constructor TeacherRepository");
        this.teachers = ParseUtils.LoadTeachers("fileTeacher.txt");
    }

    public ArrayList<Teacher> getTeachers() {
        Logger.writeLog("TeacherRepository.getTeachers");
        return teachers;
    }
}
