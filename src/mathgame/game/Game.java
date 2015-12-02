/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import java.util.Arrays;
import mathgame.mediator.MathGameMediator;
import mathgame.questions.Answer;
import mathgame.util.calculator.Calculator;
import mathgame.util.ReschedulableTimer;
import mathgame.questions.Answer.PromptType;
import java.util.TimerTask;

/**
 *
 * @author feilan
 */
public class Game {

    private static final int STARTING_HEALTH = 100;
    private static final String TIME_CURVE_FUNCTION = "100 * (0.95^(%d - 50) + 10)";
    private static final long COUNTDOWN_TICK_UNIT = 100;
    
    private Answer currentQuestion;
    private MathGameMediator mediator;
    private GameMode mode;
    private ReschedulableTimer questionTimer;
    private ReschedulableTimer countdownTimer;
    private int health;
    private int score;
    private int questionNumber;
    private long initialTime;
    private long timeLeft;
    
    private class NextQuestionTask extends TimerTask {        
        @Override
        public void run() { // time is up            
            endQuestion(false);
        }
    }        
    
    private class CountdownTask extends TimerTask {
        @Override
        public void run() {
//            System.out.format("%d ms remaining%n", timeLeft);
            timeLeft -= COUNTDOWN_TICK_UNIT;            
        }
    }
    
    public Game(MathGameMediator mediator) {
        this.mediator = mediator;        
        this.mode = GameMode.INACTIVE;        
        this.health = 0;
        this.questionNumber = 0;
        this.timeLeft = 0;
    }    

    public long getInitialTime() {
        return this.initialTime;
    }
    
    public long getTimeLeft() {
        return this.timeLeft;
    }
    
    public void play(GameMode gameMode) {                
        System.out.println("new game");
        this.mode = gameMode;
        this.questionTimer = new ReschedulableTimer();
        this.countdownTimer = new ReschedulableTimer();
        this.health = STARTING_HEALTH;
        this.questionNumber = 0;
        askQuestion();
    }
    
    public void quit() {
        System.out.println("quit game");
        this.questionTimer.cancel();
        this.countdownTimer.cancel();
        this.mode = GameMode.INACTIVE;        
    }

    public void answerQuestion(String answer) {
        // TODO: evaluate answer and time left
        
        endQuestion(Math.random() > 0.5);
    }
    
    private void endQuestion(boolean isAnswerCorrect) {
        isAnswerCorrect = false;
        
        if (isAnswerCorrect && timeLeft > 0) {
            this.health += 10;
        } else {
            System.out.println("time up");
            this.health -= 20;
        }
        
        // update stats
        
        if (this.health > 0) {
            askQuestion();
        } else { 
            endGame();
        }        
    }
    
    private void endGame() {
        System.out.println("game over");
        quit();
        
        mediator.gameEnded();
    }
    
    private void askQuestion() {
        System.out.println("new question");
        this.questionNumber++;
        
        // TODO: remove when done
//        System.out.println(this.currentQuestion.getPrompt());
//        System.out.println(this.currentQuestion.getSolution());
//        System.out.println(Arrays.toString(this.currentQuestion.getMultipleChoiceAnswers()));
//        System.out.println(this.currentQuestion.getCorrectAnswerIndex());
        
        String exp = String.format(TIME_CURVE_FUNCTION, this.questionNumber);
        this.initialTime = this.timeLeft = (long) Double.parseDouble(Calculator.eval(exp, false));
        
        if (this.questionNumber == 1) {            
            this.questionTimer.schedule(new NextQuestionTask(), this.initialTime);
            this.countdownTimer.schedule(new CountdownTask(), 0, COUNTDOWN_TICK_UNIT);
        } else {
            this.questionTimer.reschedule(this.initialTime);
            this.countdownTimer.reschedule(0, COUNTDOWN_TICK_UNIT);
        }
            
        System.out.format("next question scheduled to appear in %d ms%n", this.initialTime);
        
        PromptType[] allowedQuestionTypes = this.mode.allowedQuestionTypes;
        int random = (int) (Math.random() * (allowedQuestionTypes.length - 1));
        this.currentQuestion = new Answer(this.mode.questionType, allowedQuestionTypes[random]);
        mediator.questionAsked(this.currentQuestion);        
    }
    
}
