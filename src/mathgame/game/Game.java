/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import mathgame.questions.*;
import javax.swing.Timer;

/**
 *
 * @author feilan
 */
public class Game { // "source" for GameEvent
    // addGameListener and goes here
    /*
    stats: private with lazy instantiation
    screens responds to questionChanged
    */
    
    public Game(GameMode gameMode) {
        this.mode = gameMode;
        this.health = STARTING_HEALTH;
    }
    
    public final int STARTING_HEALTH = 100;
    
    private Timer timer;
    private GameMode mode;
    private int health;
    
}
