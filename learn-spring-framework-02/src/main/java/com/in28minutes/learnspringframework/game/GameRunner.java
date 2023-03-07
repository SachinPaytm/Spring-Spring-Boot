package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
//    MarioGame game;
    private GamingConsole game;
    public GameRunner(@Qualifier("superContraGame") GamingConsole marioGame) {
        this.game = marioGame;
    }

    public void run() {
        System.out.println("Game is Running: "+game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
