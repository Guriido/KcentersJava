package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class GenerateurDur extends AbstractGenerator {

	int seed = (new Random()).nextInt();
	final static int size = 1000;

	@Override
	Instance generer(int n, int k) {
		ArrayList<int[]> points = new ArrayList<int[]>();
		int[] centre = new int[]{size/2, size/2};
		int radiusCluster = n*size/1000;
		Random r = new Random(this.seed);
		int quantite = n/k;
		for(int i = 0; i < k; i++){
			int[] centreCluster = new int[]{(int)Math.floor((double)centre[0]+((double)size/2. - (double)radiusCluster)*Math.cos(2.*Math.PI*(double)i/(double)k)),
					(int)Math.floor(centre[1]+(size/2 - radiusCluster)*Math.sin(2*Math.PI*i/k))};
			int dir = r.nextInt(8);
			int[] delta = new int[]{(int)Math.floor((radiusCluster*8./10.)*Math.cos(2.*Math.PI*dir/8)),
					(int)Math.floor((radiusCluster*8./10.)*Math.sin(2*Math.PI*dir/8))};

			int[] point1 = new int[]{centreCluster[0]+delta[0],centreCluster[1]+delta[1]};

			if(!Util.member(points, point1)){
				points.add(point1);
			}
			if(!Util.member(points, centreCluster)){
				points.add(centreCluster);
			}

			int[] centre2 = new int[]{centreCluster[0]-delta[0],centreCluster[1]-delta[1]};

			if(i == k-1){ //on complete les points manquants sur le dernier cluster
				while(points.size() < n){
					int dirAleat = r.nextInt(8);
					int[] pointAleat = new int[]{(int)Math.floor((radiusCluster*2./10.)*r.nextDouble()*Math.cos(2.*Math.PI*dirAleat/8))+centre2[0],
							(int)Math.floor((radiusCluster*2./10.)*r.nextDouble()*Math.sin(2*Math.PI*dirAleat/8))+centre2[1]};
					if(!Util.member(points, pointAleat)){
						points.add(pointAleat);
						//System.out.println(points.size() +" size");
					}
				}	
			} else {
				while(points.size() < (i+1)*quantite){
					int dirAleat = r.nextInt(8);
					int[] pointAleat = new int[]{(int)Math.floor((radiusCluster*2./10.)*r.nextDouble()*Math.cos(2.*Math.PI*dirAleat/8))+centre2[0],
							(int)Math.floor((radiusCluster*2./10.)*r.nextDouble()*Math.sin(2*Math.PI*dirAleat/8))+centre2[1]};
					if(!Util.member(points, pointAleat)){
						points.add(pointAleat);
					}
				}
			}
			//System.out.println(" i " + i + " points "+ points.size());


		}





		Instance instance = new Instance(n, k, points);

		return instance;
	}


}