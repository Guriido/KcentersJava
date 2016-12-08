package resolutionKcentres;

import java.util.ArrayList;

public class TestGenerator {

	public static void main(String[] args) {
		
		int n = 40;
		int k = 4;
		
		AbstractGenerator generateur = new GenerateurDur();
		
		Instance instance = generateur.generer(n, k);
	
		Solution s = new Solution(instance,new ArrayList<int[]>());
		System.out.println("done.");
		
		
		s.afficheSolution();
	}

}
