package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class AlgoRandom extends Algo {

	public AlgoRandom(Instance i) {
		super(i);

	}

	ArrayList<int[]> bestcentres = new ArrayList<int[]>();
	Solution bestSolution = null;
	int bestScore = Integer.MAX_VALUE;

	@Override
	Solution resoudre() {
		ArrayList<int[]> centres = new ArrayList<int[]>();
		Random r = new Random();
		int[] premierCentre = this.instance.points.get(
				(new Random()).nextInt(this.instance.nbPoints)
															).clone();
		centres.add(premierCentre);
		while(centres.size() < this.instance.nbCentres){
			int[] centre;
			do{
				centre = this.instance.points.get(r.nextInt(this.instance.points.size()));
			}while(Util.member(centres, centre));
			centres.add(centre);
		}
		Solution s = new Solution(this.instance, centres);
		
		
		return s;
	}



}