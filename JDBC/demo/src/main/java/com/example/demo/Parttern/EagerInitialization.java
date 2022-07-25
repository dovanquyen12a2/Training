package com.example.demo.Parttern;

public class EagerInitialization {
    public static final EagerInitialization INSTANCE = new EagerInitialization();
    private EagerInitialization(){

    }   
    public static EagerInitialization getInstance(){
        return INSTANCE;
    } 
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
