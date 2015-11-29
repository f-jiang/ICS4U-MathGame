package mathgame.questions;

import java.util.Random;

public class QuestionGenerator{
	
	/*public static void main(String[] args){
		System.out.println(getProblem(QuestionTypes.ALGEBRA, 60).createPrompt(1));
	}*/
	
	public static Answer getProblem(QuestionTypes type, int t) {
		if(type==QuestionTypes.ALGEBRA){
			return algebraQuestions(t);
		}
		return null;
	}
	
	private static Answer algebraQuestions(int t){
		// polynomial shits
                Random danker = new Random();
                Answer answer = new Answer(Math.round(t/30)+1);
                int[] k = new int[Math.round(t/30)+1];
                for(int a=0;a<k.length;a++){
                        k[a] = danker.nextInt(10) - 5;
                }
                answer.roots = k;
                
                return answer;
	}

}
