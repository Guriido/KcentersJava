package resolutionKcentres;

import java.io.IOException;

public class TestSolutionManager {

	public static void main(String[] args) throws IOException {
		
		SolutionManager s = new SolutionManager();
		UniformeGene generator = new UniformeGene();
		AlgoGlouton algo = new AlgoGlouton(null);
		/*int nbInstances = 10;
		int n = 100;
		int k = 20;
		s.generateInstances(generator, nbInstances, n, k);
		s.resolve(algo);
		s.exportCSV();
		*/
		
		int nbMoyenne = 500;
		int nDepart = 10;
		int nArrivee = 200;
		int nPas = 10;
		int k = 4;
		int nbNs = (nArrivee - nDepart)/nPas;
		
		s.generateInstancesVar(generator, nbMoyenne, nDepart, nArrivee, nPas, k);
		s.resolve(algo);
		s.exportCSV(nbMoyenne, nbNs);
		

	}

}
