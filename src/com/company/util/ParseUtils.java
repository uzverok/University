package Students.util;

import Students.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ParseUtils {
    private static int flat_number;
    private static double salary;
    private static Address address = null;
    public static ArrayList<Student> LoadStudents(String fileName) {
        Logger.writeLog("Start LoadStudents");
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            try {
                String s;
                while ((s = input.readLine()) != null) {
                    Logger.writeLog("fileLine: "+s);
                    String[] student = s.split(" ");
                    try {
                        flat_number = Integer.parseInt(student[6]);
                    } catch (NumberFormatException e) {
                        flat_number = 0;
                        Logger.writeLog("Не удалось сконвертировать занчение квартиры для студента "+student[0]);
                    }
                    address = new Address(student[3],student[4],Integer.parseInt(student[5]),flat_number);
                    students.add(new Student(student[0],student[1],Integer.parseInt(student[2]),address));
                }
            } finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.writeLog("Finish LoadStudents. StudentsCount:"+students.size());
        return students;
    }
    public static ArrayList<Teacher> LoadTeachers(String fileName) {
        Logger.writeLog("Start LoadTeachers");
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            try {
                String s;
                while ((s = input.readLine()) != null) {
                    Logger.writeLog("fileLine: "+s);
                    String[] teacher = s.split(" ");
//                    Logger.writeLog("teachers.county: "+ Arrays.stream(teacher).count());
                    try {
                        flat_number = Integer.parseInt(teacher[6]);
                    } catch (NumberFormatException e) {
                        flat_number = 0;
                        Logger.writeLog("Не удалось сконвертировать занчение квартиры для преподавателя "+teacher[0]);
                    }
                    try {
                        salary = Double.parseDouble(teacher[7]);
                    } catch (NumberFormatException e){
                        salary = 0;
                        Logger.writeLog("Не удалось сконвертировать занчение з/п для преподавателя "+teacher[0]);
                    }
                    address = new Address(teacher[3],teacher[4],Integer.parseInt(teacher[5]),flat_number);
                    teachers.add(new Teacher(teacher[0],teacher[1],Integer.parseInt(teacher[2]),address,salary));
                }
            } finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.writeLog("Finish LoadTeachers. TeachersCount:"+teachers.size());
        return teachers;
    }
    public static ArrayList<Methodist> LoadMethodists(String fileName,ArrayList<Teacher> main_teachers) {
        Logger.writeLog("Start LoadMethodists");
        ArrayList<Methodist> methodists = new ArrayList<Methodist>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            try {
                String s;
                while ((s = input.readLine()) != null) {
                    Logger.writeLog("fileLine: "+s);
                    String[] methodist = s.split(" ");
                    try {
                        flat_number = Integer.parseInt(methodist[6]);
                    } catch (NumberFormatException e) {
                        flat_number = 0;
                        Logger.writeLog("Не удалось сконвертировать занчение квартиры для методиста "+methodist[0]);
                    }
                    address = new Address(methodist[3],methodist[4],Integer.parseInt(methodist[5]),flat_number);
                    //придумать поиск учителя по ФИО из файла
                    String[] teacherList = methodist[8].split(",");
                    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
                    for (String t: teacherList){
//                        teachers.add(main_teachers..stream().filter(teacher -> t.equals(teacher.getLast_name())));
//                        Logger.writeLog("teacherIndex="+t);
                        teachers.add(main_teachers.get(Integer.parseInt(t)));
                    }
                    methodists.add(new Methodist(methodist[0],methodist[1],Integer.parseInt(methodist[2]),address,methodist[7],teachers));
                }
            } finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.writeLog("Finish LoadMethodists. MethodistsCount:"+methodists.size());
        return methodists;
    }
    public static ArrayList<Group> LoadGroups(String fileName,ArrayList<Teacher> main_teachers, ArrayList<Student> main_students) {
        Logger.writeLog("Start LoadGroups");
        ArrayList<Group> groups = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            try {
                String s;
                while ((s = input.readLine()) != null) {
                    String[] group = s.split(" ");
                    String[] studentsList = group[3].split(",");
                    ArrayList<Student> students = new ArrayList<Student>();
                    for (String t: studentsList){
//                        teachers.add(main_teachers..stream().filter(teacher -> t.equals(teacher.getLast_name())));
//                        Logger.writeLog("teacherIndex="+t);
                        students.add(main_students.get(Integer.parseInt(t)));
                    }
                    groups.add(new Group(group[0],Integer.parseInt(group[1]),main_teachers.get(Integer.parseInt(group[2])),students));
                }
            } finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.writeLog("Finish LoadGroups. GroupsCount:"+groups.size());
        return groups;
    }
}
