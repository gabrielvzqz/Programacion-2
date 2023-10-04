package PBuild;

import java.io.IOException;

public class PBuild008 {
	public static void main(String[] arg) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("powershell.exe",
				"echo", "Hello GeeksforGeeks" , "This is ProcessBuilder Example");
		pb.inheritIO();
		
		Process process = pb.start();
		//esperando a que termine laejecución de echo
		process.waitFor();
	}
}