package com.in28minutes.learnspringframework.game;

public class GameRunner {
//    MarioGame game;
    private GamingConsole game;
    public GameRunner(GamingConsole marioGame) {
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
