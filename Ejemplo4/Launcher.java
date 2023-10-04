package Ejemplo4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

	static final int NUM_PROCESOS = 4;
	static final String PREFIJO_FICHEROS = "fich";

	public static void lanzarSumador(int n1, int n2, String fichResultados) throws IOException {
		File directorioSumador;
		File fichResultado = new File(fichResultados);
		
		String comando;
		
		directorioSumador = new File("C:\\Users\\SegundoDAM\\eclipse-workspace\\Pepe\\src\\Ejemplo4\\");
		comando = "Sumador.java";


		ProcessBuilder pb;
		pb = new ProcessBuilder("java", comando, String.valueOf(n1), String.valueOf(n2));
		// Directorio donde busca el comando a ejecutar
		pb.directory(directorioSumador);
		pb.redirectOutput(fichResultado);
		pb.redirectError(new File("errores.txt"));
		pb.start();
	}

	public static int getResultadoFichero(String nombreFichero) {
		int suma = 0;
		try {
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			// Solo lee una linea
			String linea = br.readLine();

			suma = Integer.parseInt(linea);
			return suma;

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir " + nombreFichero);
		} catch (IOException e) {
			System.out.println("No hay nada en " + nombreFichero);
		}
		return suma;
	}

	// PARAMETRO UN POCO INUIL
	public static int getSumaTotal(int numFicheros) {
		int sumaTotal = 0;
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			sumaTotal += getResultadoFichero(PREFIJO_FICHEROS + String.valueOf(i));
		}
		return sumaTotal;

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int salto = (n2 / NUM_PROCESOS) - 1;
		for (int i = 1; i <= NUM_PROCESOS; i++) {
			System.out.println("n1:" + n1);
			int resultadoSumaConSalto = n1 + salto;
			System.out.println("n2:" + resultadoSumaConSalto);
			lanzarSumador(n1, n1 + salto, PREFIJO_FICHEROS + String.valueOf(i));
			n1 = n1 + salto + 1;
			System.out.println("Suma lanzada...");
		}
		//THREAD ES HILO, LLAMAMOS A UN MÉTODO ESTÁTICO --> DORMIR MEDIO SEGUNDO EL HILO PRINCIPAL MAIN
		Thread.sleep(5000);
		int sumaTotal = getSumaTotal(NUM_PROCESOS);
		System.out.println("La suma total es:" + sumaTotal);
		
		File resTotal= new File("resultadoTotal");
		FileWriter fw = new FileWriter(resTotal,true);
		fw.append("el resultado total es " + sumaTotal);
		fw.close();
		System.out.println("Resultado guardado en " + resTotal.getName());
	}
}
