package mathgame.questions;

public class Answer {
	
	static int[] roots;
        
        public interface PromptTypes{
            int STANDARD = 0;
            int FACTORED = 1;
        }
        
        public Answer(int t){
            roots = new int[t];
        }
        
        public String createPrompt(int type){
            if(type==PromptTypes.STANDARD){
                // screw this
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
            else if(type==PromptTypes.FACTORED){
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
        
        public String[] createFullSolution(int roots[]){
            
        }
}
