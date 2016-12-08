package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class AlgoExact extends Algo {

	public AlgoExact(Instance i) {
		super(i);

	}

	ArrayList<int[]> bestcentres = new ArrayList<int[]>();
	Solution bestSolution = null;
	int bestScore = Integer.MAX_VALUE;

	@Override
	Solution resoudre() {
		this.bestcentres = new ArrayList<int[]>();
		ArrayList<int[]> centres = new ArrayList<int[]>();
		recursion(centres, 0, this.instance.nbCentres);
		return this.bestSolution;
	}

	private void recursion(ArrayList<int[]> centres, int indexMin, int nbKAplacer){
		ArrayList<int[]> tempcentres = Util.clone(centres);
		if(nbKAplacer != 0){
			for(int i = indexMin; i < this.instance.nbPoints - nbKAplacer; i++){
				tempcentres.add(this.instance.points.get(i).clone());
				recursion(tempcentres,i+1,nbKAplacer-1);
				tempcentres.remove(tempcentres.size()-1);
			}
		} else {
			Solution s = new Solution(this.instance,tempcentres);
			int score = s.getScore();
			if(score < this.bestScore){
				bestScore = score;
				bestSolution = s;
			}
		}

	}

}