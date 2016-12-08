package resolutionKcentres;

//import general.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

//import antSolution.Data;
//import bruteForce.BruteForce;
//import convexHull.ConvexHull;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	Solution solution;

	/*
	 * On crée un constructeur par type de tracé que l'on souhaite faire
	 */
	public Panel(Solution s) {
		super();
		this.solution = s;
	}


	/*
	 * En fonction du type de tracé que l'on souhaite faire, on place les points et les segments nécessaires
	 * les attributs ne correspondant pas au tracé en cours étant à null
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < this.solution.instance.points.size(); i++) {
			double x = this.solution.instance.points.get(i)[0];
			double y = this.solution.instance.points.get(i)[1];
			g.fillOval((int) x,(int) y, 10, 10);
		}
		for (int i = 0; i < this.solution.centres.size(); i++) {
			double x0 = this.solution.centres.get(i)[0];
			double y0 = this.solution.centres.get(i)[1];
			g.setColor(Color.red);
			g.fillOval((int) x0,(int) y0, 10, 10);
		}


	}

}
