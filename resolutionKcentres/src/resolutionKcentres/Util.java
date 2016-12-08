package resolutionKcentres;

import java.util.ArrayList;

public class Util {

	static boolean member(ArrayList<int[]> l, int[] point){
		boolean member = false;
		for(int[] e : l){
			if(e[1] == point[1] && e[0] == point[0]){
				member = true;
			}
		}
		
		return member;
	}
	
	static int getDistanceSquared(int[] a, int[] b){
		return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
	}
	
	static int[] plusEloigne(ArrayList<int[]> centres,ArrayList<int[]> points){
		int[] plusEloigne = null;
		int dmax = 0;
		for(int[] point : points){
			int dmin = Integer.MAX_VALUE;
			for(int[] centre : centres){
				int d = Util.getDistanceSquared(centre, point);
				if(d < dmin){
					dmin = d;
				}
			}
			// dmin vaut ici la distance min entre point et tous les centres
			if(dmin > dmax){
				dmax = dmin;
				plusEloigne = point.clone();
			}
		}
		return plusEloigne;
	}
	
	static int getDistancePlusEloigne(ArrayList<int[]> centres,ArrayList<int[]> points){
		//int[] plusEloigne = null;
		int dmax = 0;
		for(int[] point : points){
			int dmin = Integer.MAX_VALUE;
			for(int[] centre : centres){
				int d = Util.getDistanceSquared(centre, point);
				if(d < dmin){
					dmin = d;
				}
			}
			// dmin vaut ici la distance min entre point et tous les centres
			if(dmin > dmax){
				dmax = dmin;
				//plusEloigne = point.clone();
			}
		}
		return dmax;
	}
	
	static void printArrayList(ArrayList<int[]> liste){
		for(int[] element : liste){
			System.out.println("["+element[0]+","+element[1]+"]");
		}
	}
	
	static ArrayList<int[]> clone(ArrayList<int[]> liste){
		ArrayList<int[]> newlist = new ArrayList<int[]>();
		for(int[] el : liste){
			newlist.add(el.clone());
		}
		return newlist;
	}
	
	static ArrayList<Integer> generateDistanceList(ArrayList<int[]> liste){
		ArrayList<Integer> dListe = new ArrayList<Integer>();
		for(int i = 0; i < liste.size(); i++){
			for(int j = i + 1; j < liste.size(); j++){
				dListe.add(Util.getDistanceSquared(liste.get(i), liste.get(j)));
			}
		}
		return dListe;
	}
	
}
