package com.yerlan.learn_spring_1.game_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        //Loose Coupling here (through interface + Spring Beans). 
        //If you want to change MarioGame for other game, you need just add 
        //@Primary to the Bean in Configuration file
        
        try (var context = new AnnotationConfigApplicationContext(GameConfiguration.class)){
            context.getBean(GameRunner.class).run();
        }
    }
}
