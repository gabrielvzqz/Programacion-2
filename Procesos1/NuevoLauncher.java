package Procesos1;

public class NuevoLauncher {
	public void lanzarSumador(Integer n1, Integer n2) {
		String clase = "Proceso1.Sumador";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NuevoLauncher l = new NuevoLauncher();
		l.lanzarSumador(1, 51);
		l.lanzarSumador(51, 100);
		System.out.println("Ok");
	}
}