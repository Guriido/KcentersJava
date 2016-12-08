package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class AlgoDescente extends Algo {

	public AlgoDescente(Instance i) {
		super(i);
		
	}

	int meilleurScore;
	Random r = new Random();
	
	@Override
	Solution resoudre() {
		int tentatives = 10000;
		//Initialiser solution
		Solution s = (new AlgoRandom(this.instance)).resoudre();
		meilleurScore = s.getScore();
		
		for(int i = 0; i < tentatives;i++){
			s = this.testMutation(s);
			System.out.println("score max : "+this.meilleurScore);
		}
		
		return s;
	}
	
	private Solution testMutation(Solution s){
		
		Solution temp = s.clone();
		int indexCentre = r.nextInt(temp.centres.size());
		int indexPoint = r.nextInt(temp.instance.points.size());
		
		temp.centres.remove(indexCentre);
		temp.centres.add(temp.instance.points.get(indexPoint));
		int score = temp.getScore();
		if( score <= meilleurScore){
			meilleurScore = score;
			return temp;
		} else {
			return s;
		}
	}

}
