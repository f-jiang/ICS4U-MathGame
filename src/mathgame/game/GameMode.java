/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

/**
 *
 * @author feilan
 */
public enum GameMode {
    //TODO add allowed question types when enum complete
    ALGEBRA(),
    GEOMETRY(),
    TRIGONOMETRY();
    
    public final /*QuestionType*/int[] allowedQuestionTypes;
    
    GameMode(/*QuestionType*/int... allowed) {
        this.allowedQuestionTypes = allowed;
    }
}
