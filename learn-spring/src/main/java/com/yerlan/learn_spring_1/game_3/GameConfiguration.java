package com.yerlan.learn_spring_1.game_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class GameConfiguration {

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
    
}
