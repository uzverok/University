package Students.Repository;

import Students.model.Group;
import Students.model.Student;
import Students.model.Teacher;
import Students.util.Logger;
import Students.util.ParseUtils;

import java.util.ArrayList;

public class GroupRepository {
    private ArrayList<Group> groups;
    public GroupRepository(ArrayList<Teacher> teachers, ArrayList<Student> students){
        Logger.writeLog("constructor GroupRepository");
        this.groups = ParseUtils.LoadGroups("fileGroup.txt",teachers,students);
    }

    public ArrayList<Group> getGroups() {
        Logger.writeLog("GroupRepository.getGroups");
        return groups;
    }
}
