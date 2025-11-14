package com.yerlan.learn_spring_1.game_4;

import org.springframework.stereotype.Component;

@Component
public class GameRunner  {
    IGame game;

    public GameRunner(IGame game){
        this.game = game;
    }
    public void run() {
        System.out.println("---------------------");
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
    
}
