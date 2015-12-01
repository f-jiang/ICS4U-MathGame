/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import mathgame.mediator.MathGameMediator;
import mathgame.util.calculator.Calculator;
import mathgame.util.ReschedulableTimer;
import java.util.TimerTask;

/**
 *
 * @author feilan
 */
public class Game {

    private static final int STARTING_HEALTH = 100;
    private static final String TIME_CURVE_FUNCTION = "100 * (0.95^(%d - 50) + 10)";
    private static final long COUNTDOWN_TICK_UNIT = 100;
    
    private MathGameMediator mediator;
    private GameMode mode;
    private ReschedulableTimer questionTimer;
    private ReschedulableTimer countdownTimer;
    private int health;
    private int questionNumber;
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
    
    public void play(GameMode gameMode) {
//        System.out.println("new game");
        this.mode = gameMode;
        this.questionTimer = new ReschedulableTimer();
        this.countdownTimer = new ReschedulableTimer();
        this.health = STARTING_HEALTH;
        this.questionNumber = 0;
        askQuestion();
    }
    
    public void quit() {
//        System.out.println("quit game");
        this.questionTimer.cancel();
        this.countdownTimer.cancel();
        this.mode = GameMode.INACTIVE;        
    }

    public void answerQuestion(String answer) {
        // evalute answer and time left
        
        endQuestion(Math.random() > 0.5);
    }
    
    private void endQuestion(boolean isAnswerCorrect) {
        if (isAnswerCorrect && timeLeft > 0) {
            // increase health and score
        } else {
//            System.out.println("time up");
            // decrease health and score
        }
        
        // update stats
        
        if (this.health > 0) {
            askQuestion();
        } else { 
            endGame();
        }        
    }
    
    private void endGame() {
//        System.out.println("game over");
        quit();
        
//        tell mediator to show performance analysis
    }
    
    private void askQuestion() {
//        System.out.println("new question");
        this.questionNumber++;
//        generate question
//        notify mediator
        mediator.questionAsked(new String());

        
        String exp = String.format(TIME_CURVE_FUNCTION, this.questionNumber);
        this.timeLeft = (long) Double.parseDouble(Calculator.eval(exp, false));
        
        if (this.questionNumber == 1) {            
            this.questionTimer.schedule(new NextQuestionTask(), this.timeLeft);
            this.countdownTimer.schedule(new CountdownTask(), 0, COUNTDOWN_TICK_UNIT);
        } else {
            this.questionTimer.reschedule(this.timeLeft);
            this.countdownTimer.reschedule(0, COUNTDOWN_TICK_UNIT);
        }
            
//        System.out.format("next question scheduled to appear in %d ms%n", this.timeLeft);
    }
    
}
