package com.example.demo.Parttern;

public class LazyInitialization {
    private static LazyInitialization instance;
    public LazyInitialization(){

    }
    public static LazyInitialization getInstance( String name){
        if(instance == null)
            instance = new LazyInitialization(name);
        return instance;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LazyInitialization(String name) {
        this.name = name;
    }
    
}
