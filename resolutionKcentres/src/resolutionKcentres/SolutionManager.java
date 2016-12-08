package resolutionKcentres;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolutionManager {

	ArrayList<Solution> solutions;

	InstancesManager instancesManager;

	public SolutionManager() {
		this.solutions = new ArrayList<Solution>();
		this.instancesManager = new InstancesManager();
	}

	public void eraseSolutions(){
		this.solutions = new ArrayList<Solution>();
	}

	public void loadInstances(String spath){
		Path hcPath = Paths.get(spath);
		String path = hcPath.toAbsolutePath().toString();
		this.instancesManager.read(path);
	}

	public void generateInstances(AbstractGenerator generator, int nbInstances, int n, int k){
		this.instancesManager.generate(generator, nbInstances, n, k);
	}

	public void resolve(Algo algo){
		for(int i = 0; i < this.instancesManager.instances.size(); i++){
			Instance instance = this.instancesManager.instances.get(i);
			algo.setInstance(instance);
			this.solutions.add(algo.resoudre());
		}
	}

	public void exportCSV() throws IOException{

		String date = "_" + LocalDateTime.now();
		date = date.substring(0, 20);
		date = date.replace(':', '-');
		System.out.println(date);
		CsvOutput output = new CsvOutput(new ArrayList<Integer>(), new ArrayList<Double>(), new ArrayList<Double>());
		Path p = Paths.get("Test"+this.solutions.size()+"solutions"+date+ ".csv");
		output.toCSV(p);

		for(int i = 0; i < this.solutions.size(); i++){

			int moyenne = this.solutions.get(i).getScore();
			output.addData(this.solutions.get(i).centres.size(), moyenne,this.solutions.get(i).instance.nbPoints, p);
			//score moyen n k
		}


	}

	public void generateInstancesVar(AbstractGenerator generator, int nbMoyenne, int nDepart, int nArrivee, int nPas, int k){
		for(int n = nDepart; n < nArrivee; n+=nPas){
			this.generateInstances(generator,nbMoyenne,n,k);
		}
	}
	
	public void exportCSV(int nbMoyenne, int nbNs,String generator,String algo) throws IOException{

		String date = "_" + LocalDateTime.now();
		date = date.substring(0, 20);
		date = date.replace(':', '-');
		System.out.println(date);
		CsvOutput output = new CsvOutput(new ArrayList<Integer>(), new ArrayList<Double>(), new ArrayList<Double>());
		Path p = Paths.get("Testk"+this.solutions.get(0).centres.size()+"Var"+this.solutions.size()+"solutions"+generator+algo+date+ ".csv");
		output.toCSV(p);

		for(int i = 0; i < nbNs; i++){
			double moyenne = 0;
			for(int j = i; j < i + nbMoyenne; j++){		
				moyenne += (double)this.solutions.get(j).getScore() / (double)nbMoyenne;

			}
			output.addData(this.solutions.get(i*nbMoyenne).centres.size(), moyenne,this.solutions.get(i*nbMoyenne).instance.nbPoints, p);
			//score moyen n k
		}


	}

}
