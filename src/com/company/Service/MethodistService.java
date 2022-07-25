package Students.Service;

import Students.Repository.MethodistRepository;
import Students.model.Methodist;
import Students.model.Teacher;
import Students.util.Converter;
import Students.util.Logger;

import java.util.ArrayList;

public class MethodistService {
    private MethodistRepository methodistRepository;
    public MethodistService(ArrayList<Teacher> teachers) {
        Logger.writeLog("constructor MethodistService.");
        this.methodistRepository = new MethodistRepository(teachers);
    }
    public ArrayList<Methodist> getMethodists(){
        Logger.writeLog("MethodistService.getMethodists");
        return methodistRepository.getMethodists();
    }
    public void TeacherToMethodist(Teacher teacher, String subject, ArrayList<Methodist> methodists, ArrayList<Teacher> teachers){
        Converter<Teacher, Methodist> converter = x -> new Methodist(x.getLast_name(), x.getFirst_name(), x.getAge(),x.getAddress(),subject);
        Methodist methodist = converter.convert(teacher);
        methodists.add(methodist);
        teachers.remove(teacher);
    }
}
