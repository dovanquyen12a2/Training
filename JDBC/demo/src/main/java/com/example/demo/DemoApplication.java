package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Parttern.EagerInitialization;
import com.example.demo.Parttern.LazyInitialization;
import com.example.demo.Parttern.ThreadSafe;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//Java Singleton (Creational Design Patterns) 
		EagerInitialization eager1 = EagerInitialization.getInstance();
        eager1.setName("Eager");
        System.out.println(eager1.getName());

        EagerInitialization eager2 = EagerInitialization.getInstance();
        System.out.println(eager2.getName());

        LazyInitialization lazy = LazyInitialization.getInstance("Lazy");
        System.out.println(lazy.getName());

        ThreadSafe Th = ThreadSafe.getIntance();
        Th.setName("ThreadSafe");
        System.out.println(Th.getName());

	}

}
