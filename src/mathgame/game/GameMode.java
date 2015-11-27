/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import mathgame.questions.QuestionTypes;

/**
 *
 * @author feilan
 */
public enum GameMode {
    //TODO add allowed question types when enum complete
    ALGEBRA(),
    GEOMETRY(),
    TRIGONOMETRY();
    
    public final QuestionTypes[] allowedQuestionTypes;
    
    GameMode(QuestionTypes... allowed) {
        this.allowedQuestionTypes = allowed;
    }
}
