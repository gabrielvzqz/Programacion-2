package PBuild;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PBuild007 {
	public static void main(String[] arg) throws IOException {
		// creating list of commands
		List<String> commands = new ArrayList<String>();
		commands.add("powershell.exe"); // command
		commands.add("dir"); // command
		//commands.add("-l"); // command
		//commands.add("/Users/abhishekverma"); // command in Mac OS

		// creating the process
		ProcessBuilder pb = new ProcessBuilder(commands);

		// startinf the process
		//Que pinta aqui la clase PROCESS

		Process process = pb.start();

		// for reading the ouput from stream
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}
	}
}
