package resolutionKcentres;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgoDominant extends Algo {

	public AlgoDominant(Instance i) {
		super(i);
		
	}

	
	
	@Override
	Solution resoudre() {
		ArrayList<Integer> ld = Util.generateDistanceList(this.instance.points);
		Collections.sort(ld);
		/*for(int i = 0; i < ld.size();i++){
			int d = ld.get(i);
			ArrayList<int[]> C = new ArrayList<int[]>();
			//G graphe voisins à distance d
			//tant que C ne couvre pas G
				//e sommet ayant le plus grand nombre de voisins non couverts dans G
				//C.add(e);
			
			
			if(C.size() <= this.instance.nbCentres){
				return new Solution(this.instance,C);
			}
			
		}*/
		
		/*ArrayList<int[]> centres = new ArrayList<int[]>();
		int[] premierCentre = this.instance.points.get(
				(new Random()).nextInt(this.instance.nbPoints)
															).clone();
		centres.add(premierCentre);
		while(centres.size() < this.instance.nbCentres){
			int[] centre = Util.plusEloigne(centres, this.instance.points);
			centres.add(centre);
		}*/
		Solution s = new Solution(null,null);
		
		
		return s;
	}

}