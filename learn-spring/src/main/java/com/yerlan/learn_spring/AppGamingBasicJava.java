package com.yerlan.learn_spring;

import com.yerlan.learn_spring.game1.GameRunner;
import com.yerlan.learn_spring.game1.MarioGame;
import com.yerlan.learn_spring.game1.SuperContraGame;
import com.yerlan.learn_spring.game2.GameRunner2;
import com.yerlan.learn_spring.game2.MarioGame2;
import com.yerlan.learn_spring.game2.SuperContraGame2;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        
        //Tight Coupling here. 
        //If you want to change MarioGame for other game, you need change code in GameRunner
        //Because GameRunner takes to its constructor only MarioGame Class
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

        //Loose Coupling here (through interface). 
        //If you want to change MarioGame for other game, you need NO change in GameRunner
        //Because GameRunner takes to its constructor any class which implements common
        var marioGame2 = new MarioGame2();
        var gameRunner2 = new GameRunner2(marioGame2);
        gameRunner2.run();
        var superContraGame2 = new SuperContraGame2();
        var gameRunner3 = new GameRunner2(superContraGame2);
        gameRunner3.run();

    }
}
