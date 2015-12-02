/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.mediator;

import mathgame.questions.Answer;
import mathgame.game.Game;
import mathgame.game.GameMode;
import mathgame.gui.Screens;

/**
 *
 * @author feilan
 */
public class MathGameMediator {
    
    private Game game;
    private Screens screens;
    
    public void setGame(Game game) {
        this.game = game;
    }

    public void setScreens(Screens screens) {
        this.screens = screens;
    }    
    
    public void gameStarted(GameMode gameMode) {
        game.play(gameMode);
    }
    
    public void gameQuit() {
        game.quit();
    } 
   
    public void gameEnded() {
        screens.endGame();
    }
    
    public int getStartingHealth() {
        return Game.STARTING_HEALTH;
    }
    
    public int getCurrentHealth() {
        return game.getHealth();
    }
    
    public int getScore() {
        return game.getScore();
    }
    
    public long getTimeLeftForQuestion() {
        return game.getTimeLeft();
    }
    
    public long getInitialTimeForQuestion() {
        return game.getInitialTime();
    }
    
    public void questionAnswered(String answer) {
        game.answerQuestion(answer);
    }
    
    public void questionAsked(Answer question) {
        screens.loadQuestion(question);
    }
    
    public void statsReset() {
        
    }
    
    public void statsUpdate(GameMode gameMode) {
        
    }
    
    public void statsInit() {
        
    }
    
    public void updateHealthBar() {
        screens.updateHealthBar();
    }
    
    public void updateTimeLabel() {
        screens.updateTimeLabel();
    }
    
    public void updateScoreLabel() {
        screens.updateScoreLabel();
    }
    
}
