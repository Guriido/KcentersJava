package resolutionKcentres;

public class Test {

	public static void main(String[] args) {
		
		int n = 50;
		int k = 8;
		
		AbstractGenerator generateur = new UniformeGene();
		
		Instance instance = generateur.generer(n, k);
		System.out.println("generation");
		Algo algo = new AlgoDescente(instance);
		Algo algo2 = new AlgoExact(instance);
		System.out.println("Initialisation");
		Solution s = algo.resoudre();
		Solution s2 = algo2.resoudre();
		System.out.println(algo.getClass().toString() +" : "+ s.getScore());
		System.out.println(algo2.getClass().toString() +" : "+ s2.getScore());
		//Util.printArrayList(s.centres);
		//s.afficheSolution();
		//s2.afficheSolution();
		System.out.println("done.");
		
		
		//s2.afficheSolution();
	}

}
