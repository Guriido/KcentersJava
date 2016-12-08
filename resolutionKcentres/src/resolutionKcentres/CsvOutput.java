package resolutionKcentres;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;


public class CsvOutput {







	/* Attributes */
	ArrayList<Double> parametre1;
	ArrayList<Double> parametre2;
	ArrayList<Integer> parametre3;


	/* Methods */
	public CsvOutput(
			ArrayList<Integer> parametre3,
			ArrayList<Double> parametre1,
			ArrayList<Double> parametre2) {
		this.parametre3 = parametre3;
		this.parametre1 = parametre1;
		this.parametre2 = parametre2;
	}


	public void toCSV(Path p) throws IOException {
		FileWriter file = new FileWriter(p.toString());

		java.util.ListIterator<Integer> parametre3Iter = this.parametre3.listIterator();
		java.util.ListIterator<Double> parametre1Iter = this.parametre1.listIterator();
		java.util.ListIterator<Double> parametre2Iter = this.parametre2.listIterator();

		file.write("n; k; ScoreMoyen;\n");

		boolean cont = true;
		while(cont) {
			String line =
					((parametre3Iter.hasNext()) ? (parametre3Iter.next()+";") : (";"))
					+ ((parametre1Iter.hasNext()) ? (parametre1Iter.next()+";") : (";"))
					+ ((parametre2Iter.hasNext()) ? (parametre2Iter.next()+";") : (";"))
					+ "\n";
			file.write(line);
			cont =
					parametre3Iter.hasNext()
					|| parametre1Iter.hasNext()
					|| parametre2Iter.hasNext();

		}
		file.close();
	}

	public void addData(double parametre1, double parametre2, int parametre3){
		this.parametre1.add(parametre1);
		this.parametre2.add(parametre2);
		this.parametre3.add(parametre3);
	}

	public void addData(double parametre1, double parametre2, int parametre3, Path p) throws IOException{

		FileWriter file = new FileWriter(p.toString(), true);

		this.parametre1.add(parametre1);
		this.parametre2.add(parametre2);
		this.parametre3.add(parametre3);

		String line =
				parametre3 + ";" +
						parametre1 + ";"+
						parametre2 + "\n";

		file.write(line);
		file.close();
	}
}

