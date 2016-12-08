package resolutionKcentres;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InstancesManager {

	ArrayList<Instance> instances;

	public InstancesManager(){
		this.instances = new ArrayList<Instance>();
	}
	
	public void generate(AbstractGenerator generator, int nbInstances, int n, int k){
		for(int i = 0; i < nbInstances; i++){
			this.instances.add(generator.generer(n, k));
		}
	}
	
	
	
	public void read(String path){
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(path)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String arg = null;

		try {
			arg = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] args = arg.split(" ");

		//System.out.println(args);
		int nbInstances = Integer.parseInt(args[0]);
		
		int currentpoints = -1;
		int currentcentres = -1;
		ArrayList<int[]> currentListe = null;
		ArrayList<Instance> instances = new ArrayList<Instance>();
		for(int i = 0; i < nbInstances; i++){
			for(int ligne = 0; ligne < 3; ligne++){
				
				if(ligne == 0){
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					currentListe = new ArrayList<int[]>();
				} else if(ligne == 1){
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					args = arg.split(",");
					currentpoints = Integer.parseInt(args[0]);
					currentcentres = Integer.parseInt(args[1]); 
				} else {
					
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					args = arg.split(",");
					
					for(int k = 0; k < currentpoints*2;k+=2){
						int[] point = new int[2];
						point[0] = Integer.parseInt(args[k+0]);
						point[1] = Integer.parseInt(args[k+1]);
						currentListe.add(point);
					}
					
				}

			}
			Instance instance = new Instance(currentpoints, currentcentres, currentListe);
			instances.add(instance);
		}
		this.instances = instances;


	}

	
	
	
	/*public void write(String path){
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(path)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String arg = null;

		try {
			arg = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] args = arg.split(" ");

		//System.out.println(args);
		int nbInstances = Integer.parseInt(args[0]);
		
		int currentpoints = -1;
		int currentcentres = -1;
		ArrayList<int[]> currentListe = null;
		ArrayList<Instance> instances = new ArrayList<Instance>();
		for(int i = 0; i < nbInstances; i++){
			for(int ligne = 0; ligne < 3; ligne++){
				
				if(ligne == 0){
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					currentListe = new ArrayList<int[]>();
				} else if(ligne == 1){
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					args = arg.split(",");
					currentpoints = Integer.parseInt(args[0]);
					currentcentres = Integer.parseInt(args[1]); 
				} else {
					
					try {
						arg = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					args = arg.split(",");
					
					for(int k = 0; k < currentpoints*2;k+=2){
						int[] point = new int[2];
						point[0] = Integer.parseInt(args[k+0]);
						point[1] = Integer.parseInt(args[k+1]);
						currentListe.add(point);
					}
					
				}

			}
			Instance instance = new Instance(currentpoints, currentcentres, currentListe);
			instances.add(instance);
		}
		this.instances = instances;


	}*/
	
	



}




