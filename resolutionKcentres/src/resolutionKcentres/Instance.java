package resolutionKcentres;

import java.util.ArrayList;

public class Instance {

	public Instance(int n, int k, ArrayList<int[]> points) {
		this.nbCentres = k;
		this.nbPoints = n;
		this.points = points;
	}
	int nbCentres;
	int nbPoints;
	ArrayList<int[]> points;
	
	public Instance clone(){
		return new Instance(nbPoints,nbCentres,Util.clone(points));
	}
	
}
