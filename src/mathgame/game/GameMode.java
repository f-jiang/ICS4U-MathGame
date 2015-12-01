/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import mathgame.questions.QuestionType;
import mathgame.questions.Answer.PromptType;

/**
 *
 * @author feilan
 */
public enum GameMode {
    ALGEBRA(QuestionType.ALGEBRA, PromptType.ANGLES, PromptType.SIDELENGTHS),
    TRIGONOMETRY(QuestionType.TRIGONOMETRY, PromptType.FACTORED, PromptType.STANDARD),
    INACTIVE(null);
    
    public final PromptType[] allowedQuestionTypes;
    public final QuestionType questionType;
    
    GameMode(QuestionType type, PromptType... allowed) {
        this.allowedQuestionTypes = allowed;
        this.questionType = type;
    }
}
