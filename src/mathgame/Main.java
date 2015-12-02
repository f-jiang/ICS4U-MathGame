/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame;

import mathgame.mediator.MathGameMediator;
import mathgame.gui.Screens;
import mathgame.game.Game;

/**
 *
 * @author Feilan
 */
public class Main {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MathGameMediator mediator = new MathGameMediator();
        Screens screens = new Screens(mediator);
        Game game = new Game(mediator);
        
        mediator.setGame(game);        
        mediator.setScreens(screens);
                
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            screens.setVisible(true);
        });
    }
    
}
