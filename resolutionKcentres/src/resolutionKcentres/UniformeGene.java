package resolutionKcentres;

import java.util.ArrayList;
import java.util.Random;

public class UniformeGene extends AbstractGenerator {

	int seed = (new Random()).nextInt();
	final static int size = 1000;
	
	@Override
	Instance generer(int n, int k) {
		ArrayList<int[]> points = new ArrayList<int[]>();
		Random r = new Random(this.seed);
		int i = 0;
		while(i < n){

			int[] point = new int[]{r.nextInt(size), r.nextInt(size)};
			if(!Util.member(points, point)){
				points.add(point);
				i++;
			}
		}
		Instance instance = new Instance(n, k, points);
		
		return instance;
	}
	
	
}