package com.yerlan.learn_spring_1.game_1;

public class App {
    public static void main(String[] args) {
        
        //Tight Coupling here. 
        //If you want to change MarioGame for other game, you need change code in GameRunner
        //Because GameRunner takes to its constructor only MarioGame class
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

    
    }
}
