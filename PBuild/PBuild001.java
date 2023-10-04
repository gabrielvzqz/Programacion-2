package PBuild;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PBuild001 {

	public static void main(String[] arg) throws IOException {
		// creating list of process
		List<String> list = new ArrayList<String>();
		list.add("notepad.exe");

		// create the process
		ProcessBuilder build = new ProcessBuilder(list);

		// checking the command i list
		System.out.println("command: " + build.command());
		
		//Despuues de chequear el proceso lo lanzo
		build.start();

		//Código que aproveche el proceso lanzado
	}
}