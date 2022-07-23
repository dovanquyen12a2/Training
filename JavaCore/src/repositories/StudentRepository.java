package repositories;


import models.*;

public class StudentRepository implements StudentInterface {
     
    // Override Fuction updateName of StudentInterface
    @Override
    public void updateName(Student student, String name) {
        student.setName(name);
    }
}