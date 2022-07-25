package com.example.demo.Parttern;

public class ThreadSafe {
    private static volatile ThreadSafe instance;

    private ThreadSafe() {
    }
    
    public static synchronized ThreadSafe getIntance(){
        if(instance == null)
            instance = new ThreadSafe();
        return instance;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
