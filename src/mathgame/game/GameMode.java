/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import mathgame.questions.QuestionType;

/**
 *
 * @author feilan
 */
public enum GameMode {
    //TODO add allowed question types when enum complete
    ALGEBRA(),
    TRIGONOMETRY(),
    INACTIVE();
    
    public final QuestionType[] allowedQuestionTypes;
    
    GameMode(QuestionType... allowed) {
        this.allowedQuestionTypes = allowed;
    }
}
