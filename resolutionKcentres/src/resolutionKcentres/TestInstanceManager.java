package resolutionKcentres;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestInstanceManager {

	public static void main(String[] args) {
		
		InstancesManager manager = new InstancesManager();
		Path hcPath = Paths.get("testInstances");
		String path = hcPath.toAbsolutePath().toString();
		System.out.println(path);
		String path2 = "Z:\\Workspace\\resolutionKcentres\\src\\resolutionKcentres\\testInstances";
		manager.read(path2);
		
		Algo algo = new AlgoGlouton(manager.instances.get(0));
		
		Solution s = algo.resoudre();
		Panel panel = new Panel(s);
		GUI frame = new GUI(panel);
		frame.setVisible(true);
		System.out.println("affichage done.");
	}

}
