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
                // nothing here yet
            }
            else if(type==PromptTypes.FACTORED){
                String a = "";
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
}
