package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class AlgoGlouton extends Algo {

	public AlgoGlouton(Instance i) {
		super(i);
		
	}

	
	
	@Override
	Solution resoudre() {
		ArrayList<int[]> centres = new ArrayList<int[]>();
		int[] premierCentre = this.instance.points.get(
				(new Random()).nextInt(this.instance.nbPoints)
															).clone();
		centres.add(premierCentre);
		while(centres.size() < this.instance.nbCentres){
			int[] centre = Util.plusEloigne(centres, this.instance.points);
			centres.add(centre);
		}
		Solution s = new Solution(this.instance, centres);
		
		
		return s;
	}

}
