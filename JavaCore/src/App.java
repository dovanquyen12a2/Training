import java.util.ArrayList;
import java.util.List;

import models.GraduatedStudent;
import models.Student;
import repositories.*;

public class App {
    public static void main(String[] args) throws Exception {
        //Object In Java
        Student student1 = new Student("1", "Student1", "Information1");
        Student student2 = new Student("2", "Student2", "Information2");
        //List Interface in Java
        List<Student> students = new ArrayList<Student>() ;
        students.add(student1);
        students.add(student2);


        Student student3 = new Student();
        student3.setId("3");
        student3.setName("Student3");
        student3.setInformation("Information3");
        students.add(student3);

        for(int i=0; i < students.size();i++){
            students.get(i).showInformation();; 
        }
        //Inheritance in Java
        GraduatedStudent graduatedStudent = new GraduatedStudent("4", "Student4", "Information1", "2020");
        graduatedStudent.showInformation();
        //Interface in Java
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updateName(student3, "updateName3");

    }
}
