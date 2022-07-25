package Students.Service;

import Students.Repository.GroupRepository;
import Students.model.Group;
import Students.model.Student;
import Students.model.Teacher;
import Students.util.Logger;

import java.util.ArrayList;

public class GroupService {
    private GroupRepository groupRepository;
    public GroupService(ArrayList<Teacher> teachers,ArrayList<Student> students) {
        Logger.writeLog("constructor GroupService.");
        this.groupRepository = new GroupRepository(teachers,students);
    }
    public ArrayList<Group> getGroups(){
        Logger.writeLog("GroupService.getGroups");
        return groupRepository.getGroups();
    }
    public ArrayList<Student> addStudent(Student student, ArrayList<Student> students) {
        students.add(student);
        return students;
    }
    public ArrayList<Student> delStudent(Student student, ArrayList<Student> students) {
        students.remove(student);
        return students;
    }
    void changeTeacher(Teacher teacher, Group group) {
        group.setTeacher(teacher);
    }
}
