package com.yerlan.learn_spring_1.game_2;


public class App {
    public static void main(String[] args) {

        //Loose Coupling here (through interface). 
        //If you want to change MarioGame for other game, you need NO change in GameRunner
        //Because GameRunner takes to its constructor any class which implements IGame
        
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
        
        var contraGame = new ContraGame();
        gameRunner = new GameRunner(contraGame);
        gameRunner.run();

    }
}
