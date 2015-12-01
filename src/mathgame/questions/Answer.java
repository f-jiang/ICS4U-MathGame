package mathgame.questions;

import java.util.Collections;
import java.util.Random;
import mathgame.util.calculator.Calculator;

public class Answer {
    
        int[] roots;
        
        double[][] triangle;
        int[] visible;
        
        String prompt;
        String solution;
        String[] multipleChoiceAnswers = new String[4];
        int correctAnswerIndex;
        
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
            }
            else if(questionType==QuestionType.TRIGONOMETRY){
                // side lengths: (first two created at random, hypotenuse by pyth. theorem)
                Random a = new Random();
                triangle[0][0] = (double) a.nextInt(24)+1;
                triangle[1][0] = (double) a.nextInt(24)+1;
                triangle[2][0] = Math.sqrt(Math.pow(triangle[0][0],2)+Math.pow(triangle[1][0],2));
                
                // angles:
                triangle[2][1] = Math.PI / 2;
                triangle[1][1] = Math.asin(triangle[0][0]/triangle[2][0]);
                triangle[0][1] = Math.asin(triangle[1][0]/triangle[2][0]);
                
                if(promptType==PromptTypes.SIDELENGTHS){
                    int v1 = a.nextInt(2);
                    int v2 = a.nextInt(2);
                    while(v2==v1){
                        v2 = a.nextInt(2);
                    }
                    visible = new int[]{v1, v2}; // values provided to the user to solve problem
                }
                else if(promptType==PromptTypes.ANGLES){
                    visible = new int[]{a.nextInt(2)}; // angle provided to user to solve problem
                }
            }
            
            prompt = createPrompt(promptType);
            solution = createFullSolution(promptType);
            randomiseMultipleChoiceOrder();
        }
        
        private String createPrompt(int type){
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
            else if(type==PromptTypes.ANGLES && questionType==QuestionType.TRIGONOMETRY){
                String banger = "";
                banger += "Angle A = "+triangle[visible[0]][1]+"\n";
                banger += "Side a = "+triangle[visible[0]][0]+"\n";
                Random b = new Random();
                int v1 = b.nextInt(2);
                while(v1==visible[0]){
                    v1 = b.nextInt(2);
                }
                banger += "Side b = "+triangle[v1][0]+"\n";
                int v2 = b.nextInt(2);
                while(v2==visible[0] || v2==v1){
                    v2 = b.nextInt(2);
                }
                banger += "Side c = "+triangle[v2][0]+"\n";
                banger += "Find angles B and C.";
                
                multipleChoiceAnswers[0] = Double.toString(triangle[v1][1])+", "+Double.toString(triangle[v2][1]);
                for(int i=1;i<4;i++){
                    multipleChoiceAnswers[i] = Double.toString(Math.asin((b.nextInt(24)+1)/(b.nextInt(24)+1)));
                    multipleChoiceAnswers[i] += ", "+Double.toString(Math.asin((b.nextInt(24)+1)/(b.nextInt(24)+1)));
                }
                // shuffle dis
                
                return banger;
            }
            else if(type==PromptTypes.SIDELENGTHS && questionType==QuestionType.TRIGONOMETRY){
                String banger = "";
                banger += "Side a = "+Double.toString(triangle[visible[0]][0])+"\n";
                banger += "Side b = "+Double.toString(triangle[visible[1]][0])+"\n";
                Random a = new Random();
                int v = a.nextInt(2);
                while(v==visible[0] || v==visible[1]){
                    v = a.nextInt(2);
                }
                banger += "Angle C = "+Double.toString(triangle[v][1])+"\n";
                banger += "Find side length c.";
                
                multipleChoiceAnswers[0] = Double.toString(triangle[v][0]);
                for(int i=1;i<4;i++){
                    multipleChoiceAnswers[i] = Integer.toString(a.nextInt(24)+1);
                }
                // shuffle dis
                
                return banger;
            }
            return null;
        }
        
        private String createFullSolution(int promptType){
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
                if(roots.length==3){ // cubic
                    // guess-and-check for roots
                    int[] check = {0, 1 , -1, 2, -2, 3, -3, 4, -4, 5, -5};
                    int ld=0;
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
                            
                            ld = c;
                            banger += "\n";
                            break;
                        }
                    }
                    banger += "now long divide. You should end up with a quadratic which factors to\n";
                    for(int r:roots){
                        if(r!=ld){
                            if(r>0){
                                banger += "(x - "+r+")\n";
                            }
                            else if(r<0){
                                banger += "(x + "+Math.abs(r)+")\n";
                            }
                            else{
                                banger += "(x)\n";
                            }
                        }
                    }
                }
                
                return banger;
            }
            else if(promptType==PromptTypes.ANGLES && questionType==QuestionType.TRIGONOMETRY){
                // nothing to bang
            }
            else if(promptType==PromptTypes.SIDELENGTHS && questionType==QuestionType.TRIGONOMETRY){
                // nothing to bang
            }
            return null;
        }
        
        private void randomiseMultipleChoiceOrder(){
            int index;
            Random random = new Random();
            int[] array = {0,1,2,3};
            for (int i = array.length - 1; i > 0; i--)
            {
                index = random.nextInt(i + 1);
                if (index != i)
                {
                    array[index] ^= array[i];
                    array[i] ^= array[index];
                    array[index] ^= array[i];
                }
            }
            String[] danker = multipleChoiceAnswers;
            for(int i=0;i<4;i++){
                multipleChoiceAnswers[array[i]] = danker[i];
                if(array[i]==0){
                    correctAnswerIndex = i;
                }
            }
        }
}
