package resolutionKcentres;

public abstract class Algo {
	
	public Instance instance;
	
	public Algo(Instance i){
		this.instance = i;
	}
	
	public Algo(){};
	
	public void setInstance(Instance i){
		this.instance = i;
	}
	
	abstract Solution resoudre();
	
	
}
