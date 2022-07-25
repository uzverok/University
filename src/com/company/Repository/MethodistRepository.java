package Students.Repository;

import Students.model.Methodist;
import Students.model.Student;
import Students.model.Teacher;
import Students.util.Logger;
import Students.util.ParseUtils;

import java.util.ArrayList;

public class MethodistRepository {
        private ArrayList<Methodist> methodists;
        public MethodistRepository(ArrayList<Teacher> teachers){
            Logger.writeLog("constructor MethodistRepository");
            this.methodists = ParseUtils.LoadMethodists("fileMethodist.txt",teachers);
        }

    public ArrayList<Methodist> getMethodists() {
        Logger.writeLog("MethodistRepository.getMethodists");
        return methodists;
    }
}
