/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * Original answer on StackOverflow: http://stackoverflow.com/questions/32001/resettable-java-timer/32073#32073
 *
 * @author David Sykes (http://stackoverflow.com/users/3154/david-sykes)
 * 
 */
public class ReschedulableTimer extends Timer {
    
    private Runnable task;
    private ReschedulableTimerTask reschedulableTimerTask;
    
    
    private class ReschedulableTimerTask extends TimerTask {
        @Override
        public void run() { 
            task.run();
        }        
    }

    @Override
    public void schedule(TimerTask task, long delay) {        
        this.task = task;
        this.reschedulableTimerTask = new ReschedulableTimerTask();
        super.schedule(this.reschedulableTimerTask, delay);
    }

    @Override
    public void schedule(TimerTask task, long delay, long period) {        
        this.task = task;
        this.reschedulableTimerTask = new ReschedulableTimerTask();
        super.schedule(this.reschedulableTimerTask, delay, period);
    }    
    
    public void reschedule(long delay) {
        this.reschedulableTimerTask.cancel();
        this.reschedulableTimerTask = new ReschedulableTimerTask();
        super.schedule(this.reschedulableTimerTask, delay);        
    }

    public void reschedule(long delay, long period) {
        this.reschedulableTimerTask.cancel();
        this.reschedulableTimerTask = new ReschedulableTimerTask();
        super.schedule(this.reschedulableTimerTask, delay, period);        
    }
    
}
