package com.yerlan.learn_spring.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record type got accessor methods, constructor, equals, hashcode, to String automatically 
record Person(String name, int age, Address address) {};
record Address (String firstLine, String city){};

// Configuration annotation tells Spring that this file consists Beans
@Configuration 
public class HelloWorldConfiguration {
    
    @Bean
    public String name(){
        return "Alison";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("Sam", 30, new Address("Baker Street", "London"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3){
        return new Person(name, age, address3);
    }

    @Bean (name = "address2")
    @Primary
    public Address address(){
        return new Address("Baker Street", "London");
    }

    @Bean 
    public Address address3(){
        return new Address("Motiganar", "Hyderabad");
    }
}
