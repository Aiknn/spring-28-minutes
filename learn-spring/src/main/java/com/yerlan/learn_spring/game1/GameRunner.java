package com.yerlan.learn_spring.game1;

public class GameRunner {
    private MarioGame game;

    public GameRunner(MarioGame game){
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
