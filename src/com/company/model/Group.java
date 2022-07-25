package Students.model;

import java.util.ArrayList;

public class Group {
    private String faculty;
    int course;
    private ArrayList<Student> students = null;
    private Teacher teacher;

    public Group(String faculty, int course, Teacher teacher, ArrayList<Student> students) {
        this.faculty = faculty;
        this.course = course;
        this.students = students;
        this.teacher = teacher;
    }

    public int getCourse() {
        return course;
    }

    void setCourse(int course) {
        if (course > 0 && course <= 5) {
            this.course = course;
        }
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    void printInfo() {
//        System.out.printf("Информация по группе: курс: %d\n", this.course);
//        System.out.println("Студенты:");
//        if (!this.students.isEmpty()) {
//            this.students.forEach((student) -> student.toString());
//        }
//        this.teacher.toString();
//    }

    @Override
    public String toString() {
        return "Группа{" +
                "факультет=" + faculty +
                ", курс=" + course +
                ", преподаватель=" + teacher.toStringShort() +
                ", студенты группы=" + Student.ListToString(this.students,0) +
                '}';
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void addStudent(ArrayList<Student> students, Student student) {
        students.add(student);
    }
    public void delStudent(ArrayList<Student> students, Student student) {
        students.remove(student);
    }
}
