/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.event;

/**
 *
 * @author feilan
 */
public interface GameListener {
    
    public void gameStarted(GameEvent e);
    
    public void gameEnded(GameEvent e);
    
    public void gameQuit(GameEvent e);
    
    public void questionAnswered(GameEvent e);
    
}
