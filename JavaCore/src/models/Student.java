package models;

public class Student {
    //Instance variable
    private String id;
    private String name;
    private String information;
    //Create Contructer
    public Student() {
    }
    public Student(String id, String name, String information) {
        this.id = id;
        this.name = name;
        this.information = information;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }
    public void showInformation(){
        System.out.println("ID :" + this.getId()+ " Name :" + this.getName()+" Information :" + this.getInformation());
    }
}
