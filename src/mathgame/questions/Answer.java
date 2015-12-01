package mathgame.questions;

import java.util.Random;
import mathgame.util.calculator.Calculator;

public class Answer {
    
        int[] roots;
        double[][] triangle;
        
        String prompt;
        String solution;
        
        QuestionType questionType;
        
        public interface PromptTypes{
            int STANDARD = 0;
            int FACTORED = 1;
            
            int SIDELENGTHS = 0;
            int ANGLES = 1;
        }
        
        public Answer(QuestionType qType, int promptType){
            roots = new int[new Random().nextInt(1) + 1];
            triangle = new double[3][2];
            
            questionType = qType;
            if(questionType==QuestionType.ALGEBRA){
                for(int i=0;i<roots.length;i++){
                    roots[i] = new Random().nextInt(10) - 5;
                }
            }else if(questionType==QuestionType.TRIGONOMETRY){
                // side lengths: (first two created at random, hypotenuse by pyth. theorem)
                Random a = new Random();
                triangle[0][0] = (double) a.nextInt(24)+1;
                triangle[1][0] = (double) a.nextInt(24)+1;
                triangle[2][0] = Math.sqrt(Math.pow(triangle[0][0],2)+Math.pow(triangle[1][0],2));
                
                // angles:
                triangle[2][1] = Math.PI / 2;
                triangle[1][1] = Math.asin(triangle[0][0]/triangle[2][0]);
                triangle[0][1] = Math.asin(triangle[1][0]/triangle[2][0]);
            }
            
            prompt = createPrompt(promptType);
            solution = createFullSolution(promptType);
        }
        
        public String createPrompt(int type){
            if(type==PromptTypes.STANDARD && questionType==QuestionType.ALGEBRA){
                int[] coefficients = new int[roots.length+1];
                coefficients[0] = 1;
                coefficients[1] = (-roots[0])+(-roots[1]);
                coefficients[2] = (-roots[0])*(-roots[1]);
                for(int l=3;l<roots.length+1;l++){
                    coefficients[l] = -roots[l-1];
                    for(int m=0;m<l;m++){
                        coefficients[m] += -roots[l-1];
                    }
                }
                
                String a = "Identify the following expression's roots: ";
                for(int c=0;c<coefficients.length;c++){
                    if(c>0){
                        if(coefficients[c]<0){
                            a += " - "+Integer.toString(Math.abs(coefficients[c]))+"x^"+Integer.toString(coefficients.length-c)+" ";
                        }else if(coefficients[c]>0){
                            a += " + "+Integer.toString(coefficients[c])+"x^"+Integer.toString(coefficients.length-c)+" ";
                        }
                    }else{
                        a += Integer.toString(coefficients[c])+"x^"+Integer.toString(coefficients.length-c)+" ";
                    }
                }
                
                return a;
            }
            else if(type==PromptTypes.FACTORED && questionType==QuestionType.ALGEBRA){
                String a = "Identify the following expression's roots: ";
                for(int b=0;b<roots.length;b++){
                    if(roots[b]<0){
                        a += "(x + "+Integer.toString(Math.abs(roots[b]))+")";
                    }
                    else if(roots[b]>0){
                        a += "(x - "+roots[b]+")";
                    }
                    else{
                        a = "x"+a;
                    }
                }
                return a;
            }
            return null;
        }
        
        public String createFullSolution(int promptType){
            String banger = "";
            if(promptType==PromptTypes.FACTORED && questionType==QuestionType.ALGEBRA){
                for(int r:roots){
                    if(r>0){ // positive 
                        banger += "x - "+Math.abs(r)+" = 0";
                        banger += "\nx = "+r+"\n";
                    }else if(r<0){ // negative 
                        banger += "x + "+Math.abs(r)+" = 0";
                        banger += "\nx = "+r+"\n";
                    }else{
                        banger += "x = 0"+"\n";
                    }
                }
                
                return banger;
            }
            else if(promptType==PromptTypes.STANDARD && questionType==QuestionType.ALGEBRA){
                // guess-and-check for roots
                int dankerSteps = roots.length-1;
                int[] check = {0, 1 , -1, 2, -2, 3, -3, 4, -4, 5, -5};
                String expression;
                for(int c:check){
                    expression = createPrompt(PromptTypes.STANDARD);
                    Calculator evaluation = new Calculator();
                    evaluation.storeVariable("x", c);
                    banger += "x = "+c+"\n";
                    banger += expression.replace("x", "("+c+")")+" = "+evaluation.eval(expression, false)+"\n";
                    
                    if(evaluation.eval(expression, false).equals("0")){
                        banger += "(x = "+c+") is a root. ";
                        if(c>0){
                            banger += "(x - "+c+")\n";
                        }
                        else if(c<0){
                            banger += "(x + "+Math.abs(c)+")\n";
                        }
                        else{
                            banger += "(x)\n";
                        }
                        
                        banger += "\n";
                        break;
                    }
                }
                // now long division
                
                
                return banger;
            }
            return null;
        }
}
