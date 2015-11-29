/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.mediator;

import mathgame.game.Game;
import mathgame.game.GameMode;
import mathgame.game.GameStats;
import mathgame.gui.Screens;

/**
 *
 * @author feilan
 */
public class MathGameMediator {
    
    private Game game;
    private GameStats gameStats;
    private Screens screens;
    
    public void setGame(Game game) {
        this.game = game;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }

    public void setScreens(Screens screens) {
        this.screens = screens;
    }    
    
    public void gameStarted(GameMode gameMode) {
        game.play(gameMode);
    }
    
    public void gameEnded() {
        game.quit();
    }
    
    public void questionAnswered(String answer) {
        game.answerQuestion(answer);
    }
    
    public void questionAsked(String prompt/*whether question requires chart, diagram, etc.; how player will input answer(multiple choice or input text*/) {
        screens.loadQuestion(prompt);
    }
    
    public void statsReset() {
        
    }
    
    public void statsUpdate(GameMode gameMode) {
        
    }
    
    public void statsInit() {
        
    }
    
}
