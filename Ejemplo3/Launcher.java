package Ejemplo3;

import java.io.File;

public class Launcher {

	// Nuevo parámetro en este método --> fichero de almacenamiento para el
	// resultado
	public void lanzarSumador(Integer n1, Integer n2, String fichResultado) {

		//Metodo no muy apropiado para compilar y luego ejecutar la clase sumador
		String clase = "C:\\Users\\SegundoDAM\\eclipse-workspace\\Pepe\\src\\Ejemplo3\\Sumador.java";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(fichResultado));
			pb.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Launcher l = new Launcher();
		l.lanzarSumador(1, 10, "suma1.txt");
		l.lanzarSumador(6, 10, "suma2.txt");
		System.out.println("Ok");
	}
}