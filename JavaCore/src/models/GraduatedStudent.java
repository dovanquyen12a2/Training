package models;

//class GraduatedStudent inheritance of class Student
public class GraduatedStudent extends Student{
    private String graduatedYear;

    public String getGraduatedYear() {
        return graduatedYear;
    }

    public void setGraduatedYear(String graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public GraduatedStudent(String id, String name, String information, String graduatedYear) {
        super(id, name, information);
        this.graduatedYear = graduatedYear;
    }
    public void showInformation(){
        System.out.println("ID :" + this.getId()+ " Name :" + this.getName()+" Information :" + this.getInformation()+" GraduatedYear :" + this.getGraduatedYear());
    }
}
