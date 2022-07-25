package Students;

import Students.Repository.TeacherRepository;
import Students.Service.GroupService;
import Students.Service.MethodistService;
import Students.Service.StudentService;
import Students.Service.TeacherService;
import Students.model.*;
import Students.util.AgeComporator;
import Students.util.Logger;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.writeLog("Start project.");
        ArrayList<Teacher> teachers = null;
        TeacherService teacherService = new TeacherService();
        teachers = teacherService.getTeachers();
        for (Teacher t: teachers) {
            logger.writeLog(t.toString());
        }
        ArrayList<Student> students = null;
        StudentService studentService = new StudentService();
        students = studentService.getStudents();
        for (Student t: students) {
            logger.writeLog(t.toString());
        }
        ArrayList<Methodist> methodists = null;
        MethodistService methodistService = new MethodistService(teachers);
        methodists = methodistService.getMethodists();
        for (Methodist t: methodists) {
            logger.writeLog(t.toString());
        }
        ArrayList<Group> groups = null;
        GroupService groupService = new GroupService(teachers,students);
        groups = groupService.getGroups();
        for (Group t: groups) {
            logger.writeLog(t.toString());
        }
        //сортировка студентов по возрасту
        AgeComporator ageComporator = new AgeComporator();
        students.stream()
                .sorted(ageComporator)
                .forEach(student -> logger.writeLog(student.toString()));
    }
//    public static void main(String[] args) {
//        Student student1 = new Student("student1","Ivan",18,new Address("Minsk","Pushkina",1,55));
//        Student student2 = new Student("student2","Petr",20,new Address("Gomel","Partizanskaya",4,88));
//        Student student3 = new Student("student3","Leonid",20,new Address("Vitebsk","Masherova",3,3));
//        Teacher teacher1 = new Teacher("teacher1","Irina",44,new Address("Minsk","Sadovaya",1));
//        Teacher teacher2 = new Teacher("teacher2","Marina",34,new Address("Minsk","Kozlova",1,11));
//        Teacher teacher3 = new Teacher("teacher3","Anna",36,new Address("Minsk","Zaharova",6,51));
//        Group group1 = new Group("Group1",1,teacher1);
////        group1.addStudent(student1);
////        group1.addStudent(student2);
////
////        group1.printInfo();
//
//        group1.addStudentNew(student1);
//        group1.addStudentNew(student2);
//        group1.printInfoNew();
//
//        Group group2 = new Group("Group2",3,teacher2);
////        group2.addStudent(student3);
////        group2.printInfo();
//
//        group2.addStudentNew(student3);
//        group2.printInfoNew();
//
//
////        group1.delStudent(student1);
////        group1.delStudent(student2);
////        group2.addStudent(student1);
////        group2.setTeacher(teacher3);
//        group1.delStudentNew(student1);
//        group1.delStudentNew(student2);
//        group2.addStudentNew(student1);
//        group2.setTeacher(teacher3);
//        student2.changeAddress(new Address("Lida","Kabushkina", 5));
//        teacher2.changeAddress(new Address("Lida","Kabushkina", 6,14));
//        teacher2.changeSalary(1500.66);
//
////        group1.printInfo();
////        group2.printInfo();
//        group1.printInfoNew();
//        group2.printInfoNew();
//
//
//    }

}
