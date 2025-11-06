package com.yerlan.learn_spring.game2;

public class GameRunner2 {
    GamingConsole game;

    public GameRunner2(GamingConsole game){
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
