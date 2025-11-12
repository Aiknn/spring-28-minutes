package com.yerlan.learn_spring_1.game_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class App {
    //Loose Coupling here (through interface + Spring Beans). 
    //If you want to change MarioGame for other game, you need just add 
    //@Primary to the Bean in Configuration file
    //Spring reads configuration from App (Config file deleted) 
    //creates Beans, creates objects for us 
    @Bean
    public IGame mario(){
        var game = new MarioGame();
        return game;
    }

    @Bean
    @Primary
    public IGame contra(){
        var game = new ContraGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner (IGame game){
        return new GameRunner(game);
    }
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App.class)){
            context.getBean(GameRunner.class).run();
        }
    }
}
