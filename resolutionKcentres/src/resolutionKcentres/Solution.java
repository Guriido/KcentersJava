package resolutionKcentres;

import java.util.ArrayList;

public class Solution {

	public Solution(Instance instance, ArrayList<int[]> centres) {
		this.instance = instance;
		this.centres = centres;
	}
	ArrayList<int[]> centres;
	Instance instance;
	
	public int getScore(){
		return Util.getDistancePlusEloigne(this.centres, this.instance.points);
	}
	
	public void afficheSolution(){
		Panel panel = new Panel(this);
		GUI frame = new GUI(panel);
		frame.setVisible(true);
	}
	
	public Solution clone(){
		return new Solution(instance.clone(),Util.clone(centres));
	}
	
}
