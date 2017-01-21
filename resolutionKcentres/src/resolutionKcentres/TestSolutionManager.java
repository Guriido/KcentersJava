package resolutionKcentres;

import java.io.IOException;

public class TestSolutionManager {

	public static void main(String[] args) throws IOException {
		
		SolutionManager s = new SolutionManager();
		AbstractGenerator generator = new UniformeGene();
		Algo algo = new AlgoExact(null);
		/*int nbInstances = 10;
		int n = 100;
		int k = 20;
		s.generateInstances(generator, nbInstances, n, k);
		s.resolve(algo);
		s.exportCSV();
		*/
		
		int nbMoyenne = 1;
		int nDepart = 50;
		int nArrivee = 100;
		int nPas = 10;
		int k = 7;
		int nbNs = (nArrivee - nDepart)/nPas;
		
		s.generateInstancesVar(generator, nbMoyenne, nDepart, nArrivee, nPas, k);
		s.resolve(algo);
		s.exportCSV(nbMoyenne, nbNs,generator.getClass().toString(),algo.getClass().toString());
		

	}

}
