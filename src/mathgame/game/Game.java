/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.game;

import java.util.List;
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

    public static final int STARTING_HEALTH = 100;
    public static final String TIME_CURVE_FUNCTION = "1000 * (0.96^(%d - 50) + 5)";
    public static final long COUNTDOWN_TICK_UNIT = 100;
    
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
            mediator.updateTimeLabel();
        }
    }
    
    public Game(MathGameMediator mediator) {
        this.mediator = mediator;        
        this.mode = GameMode.INACTIVE;        
        this.health = 0;
        this.score = 0;
        this.questionNumber = 0;
        this.timeLeft = 0;
    }    

    public int getHealth() {
        return this.health;
    }
    
    public long getInitialTime() {
        return this.initialTime;
    }
    
    public int getScore() {
        return this.score;
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
        this.score = 0;
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
        boolean isCorrect;
        if (this.currentQuestion.isMultipleChoice()) {
//            System.out.println("Correct answer: " + this.currentQuestion.getCorrectAnswers().get(0));
            isCorrect = (answer.equals(this.currentQuestion.getCorrectAnswers().get(0)));
        } else {
//            System.out.println("Correct answer(s): " + this.currentQuestion.getCorrectAnswers().toString());
            isCorrect = this.currentQuestion.getCorrectAnswers().contains(answer);
        }
        
//        System.out.println("Your answer: " + answer);
        
        endQuestion(isCorrect);
    }
    
    private void endQuestion(boolean isAnswerCorrect) {
        if (isAnswerCorrect && timeLeft > 0) {
            System.out.println("Right answer");
            this.health += 10;
            this.score += 0.001*timeLeft + 1;
        } else {
            System.out.println("Wrong answer");
            this.health -= 20;
        }
        
        if (this.health > STARTING_HEALTH) {
            this.health = STARTING_HEALTH;
        }
        
        this.mediator.updateHealthBar();
        this.mediator.updateScoreLabel();
        
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
        
        PromptType[] allowedQuestionTypes = this.mode.allowedQuestionTypes;
        int random = (int) (Math.random() * (allowedQuestionTypes.length - 1));
        this.currentQuestion = new Answer(this.mode.questionType, allowedQuestionTypes[random]);
        mediator.questionAsked(this.currentQuestion);               
        
        System.out.println(currentQuestion.getCorrectAnswers().toString());
        
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
    }
    
}
