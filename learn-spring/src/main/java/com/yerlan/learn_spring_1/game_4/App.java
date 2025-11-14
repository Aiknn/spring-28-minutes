package com.yerlan.learn_spring_1.game_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
    
@Configuration
@ComponentScan("com.yerlan.learn_spring_1.game_4")
public class App {
    //Evolving our Spring project 

    //@Configuration – replacement for XML configuration file; 
    //marks the class that defines beans (objects created and managed by Spring).

    //@ComponentScan("package") – tells Spring where to look for components 
    //and other Spring-managed classes (e.g. @Component, @Service, @Repository, @Controller).

    //@Component – marks a class as a Spring-managed component; 
    //Spring automatically creates its object (bean) and puts it into the application context.
   
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App.class)){
            context.getBean(GameRunner.class).run();
        }
    }
}
