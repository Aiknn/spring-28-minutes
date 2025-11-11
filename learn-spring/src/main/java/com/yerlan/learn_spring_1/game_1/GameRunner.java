package com.yerlan.learn_spring_1.game_1;

public class GameRunner {
    private MarioGame game;

    public GameRunner(MarioGame game){
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
