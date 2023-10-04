package Procesos1;

//PARA ABRIR PROGRAMAS, EN ESTE CASO ADOBE
public class LanzadorProceso {
	public void ejecutar(String ruta) {

		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String ruta = "C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
		LanzadorProceso lp = new LanzadorProceso();
		lp.ejecutar(ruta);
		System.out.println("Finalizado");
	}
}